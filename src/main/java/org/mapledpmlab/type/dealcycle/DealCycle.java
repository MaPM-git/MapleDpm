package org.mapledpmlab.type.dealcycle;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.RestraintRing;

import java.sql.Timestamp;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@Setter
public class DealCycle {
    private AttackSkill finalAttack = null;
    private Job job = null;
    private Timestamp start = new Timestamp(0);
    private Timestamp end = new Timestamp(12 * 60 * 1000);
    private List<AttackSkill> attackSkillList;
    private List<AttackSkill> delaySkillList;
    private List<BuffSkill> buffSkillList;
    private List<SkillEvent> skillEventList = new ArrayList<>();
    private List<Timestamp> eventTimeList = new ArrayList<>();
    Timestamp restraintRingStartTime = null;
    Timestamp restraintRingEndTime = null;
    Timestamp fortyEndTime = null;
    Long totalDamage;
    Long DPM;
    Long restraintRingDeal;
    Long fortyDeal;
    int i=0;

    public DealCycle() {}

    public DealCycle(Job job, AttackSkill finalAttack) {
        this.finalAttack = finalAttack;
        this.job = job;
        this.job.addTotal(this.job.getJobType());
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (start.before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (
                    skill instanceof RestraintRing
                    && restraintRingStartTime == null
                    && restraintRingEndTime == null
                    && fortyEndTime == null
            ) {
                restraintRingStartTime = new Timestamp(getStart().getTime());
                restraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
                fortyEndTime = new Timestamp(getStart().getTime() + 40000);
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (start.getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + job.getPlusBuffDuration() * 0.01)));
                skillEventList.add(new SkillEvent(skill, new Timestamp(start.getTime()), endTime));
            } else {
                endTime = new Timestamp(start.getTime() + ((BuffSkill) skill).getDuration() * 1000);
                skillEventList.add(new SkillEvent(skill, new Timestamp(start.getTime()), endTime));
            }
        } else {
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                                    && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                    ) {
                        remove.add(skillEvent);
                    }
                }
                this.getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        skillEventList.add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        eventTimeList.add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        skillEventList.add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        eventTimeList.add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else {
                endTime = new Timestamp(start.getTime() + skill.getDelay());
                skillEventList.add(new SkillEvent(skill, new Timestamp(start.getTime()), endTime));
            }
        }
        applyCooldown(skill);
        eventTimeList.add(start);
        eventTimeList.add(new Timestamp(start.getTime() + skill.getDelay()));
        if (endTime != null) {
            eventTimeList.add(endTime);
        }
        start.setTime(start.getTime() + skill.getDelay());
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= job.getReuse()) {
                } else  {
                    skill.setActivateTime(new Timestamp((int) (start.getTime() + applyCooldownReduction(skill) * 1000)));
                }
            } else {
                skill.setActivateTime(new Timestamp((int) (start.getTime() + applyCooldownReduction(skill) * 1000)));
            }
        }
    }

    public void addDealCycle(List<Skill> skillList) {
        for (Skill s : skillList) {
            this.addSkillEvent(s);
        }
    }

    public boolean cooldownCheck(Skill skill) {
        if (!(start.after(skill.getActivateTime()) || start.equals(skill.getActivateTime()))) {
            return false;
        }
        return true;
    }

    public boolean cooldownCheck(List<Skill> skillList) {
        for (Skill s : skillList) {
            if (!(start.after(s.getActivateTime()) || start.equals(s.getActivateTime()))) {
                return false;
            }
        }
        return true;
    }

    public Double applyCooldownReduction(Skill skill) {
        Double cooldown = 0.0;
        Double cooldownReduction = 0.0;
        cooldown = skill.getCooldown() * (1 - job.getCooldownReductionP() * 0.01);
        if (skill.getCooldown() <= 5) {
            return skill.getCooldown();
        }
        while (cooldownReduction != 0) {
            if (cooldown - 10 > cooldownReduction) {
                cooldown -= cooldownReduction;
                cooldownReduction = 0.0;
            } else if (cooldown < 10) {
                cooldown -= cooldownReduction * 0.05;
                cooldownReduction = 0.0;
            } else if (cooldown - 10 < cooldownReduction) {
                cooldown = 10.0;
                cooldownReduction -= (cooldown - 10);
            }
        }
        if (cooldown <= 5) {
            cooldown = 5.0;
        }
        return cooldown;
    }

    public void applyDoping() {
        this.job.Doping();
        totalDamage = calcTotalDamage(eventTimeList);
    }

    public void print() {
        Long verifyDamage = 0L;
        for (AttackSkill as : attackSkillList) {
            if (as.getCumulativeDamage() == 0) {
                continue;
            }
            as.print();
            verifyDamage += as.getCumulativeDamage();
        }
        System.out.println("검증용 : " + verifyDamage);
        System.out.println("총데미지 : " + totalDamage);
        System.out.println("DPM : " + totalDamage/12);
        System.out.println("리스트레인트링 : " + calcRestraintRingDeal());
        System.out.println("40초 : " + calcFortyDeal());
    }

    public Object[] getOpject() {
        DPM = getTotalDamage() / 12;
        restraintRingDeal = calcRestraintRingDeal();
        fortyDeal = calcFortyDeal();
        Object[] result = new Object[]{
                this.getJob().getName(), this.getDPM() + "",
                "=TEXT(" + getDPM() + "/SUM(IF(A2:A16=\"비숍\", VALUE(B2:B16),0)),\"0.0%\")", this.getRestraintRingDeal() + "",
                "=TEXT(" + getRestraintRingDeal() + "/SUM(IF(A2:A16=\"비숍\", VALUE(D2:D16),0)),\"0.0%\")", this.getFortyDeal() + "",
                "=TEXT(" + getFortyDeal() + "/SUM(IF(A2:A16=\"비숍\", VALUE(F2:F16),0)),\"0.0%\")"
        };
        return result;
    }

    public List<SkillEvent> getOverlappingSkillEvents(Timestamp start, Timestamp end) {
        List<SkillEvent> overlappingSkillEvents = new ArrayList<>();
        for (SkillEvent skillEvent : skillEventList) {
            if (
                    (skillEvent.getStart().before(end) && skillEvent.getEnd().after(start))
                    || (skillEvent.getStart().equals(start) && skillEvent.getStart().equals(skillEvent.getEnd()))
            ) {
                overlappingSkillEvents.add(skillEvent);
            }
        }
        return overlappingSkillEvents;
    }

    public Long calcTotalDamage(List<Timestamp> eventTimeList) {
        Long totalDamage = 0L;
        Timestamp start = null;
        Timestamp end = null;
        List<SkillEvent> overlappingSkillEvents;
        BuffSkill buffSkill;
        for (int i = 0; i < eventTimeList.size() -1; i++) {
            List<SkillEvent> useAttackSkillList = new ArrayList<>();
            buffSkill = new BuffSkill();
            start = eventTimeList.get(i);
            end = eventTimeList.get(i + 1);
            overlappingSkillEvents = getOverlappingSkillEvents(start, end);
            overlappingSkillEvents = deduplication(overlappingSkillEvents, SkillEvent::getSkill);
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    buffSkill.addBuffAttMagic(((BuffSkill) skillEvent.getSkill()).getBuffAttMagic());
                    buffSkill.addBuffAttMagicPer(((BuffSkill) skillEvent.getSkill()).getBuffAttMagicPer());
                    buffSkill.addBuffAllStatP(((BuffSkill) skillEvent.getSkill()).getBuffAllStatP());
                    buffSkill.addBuffCriticalDamage(((BuffSkill) skillEvent.getSkill()).getBuffCriticalDamage());
                    buffSkill.addBuffCriticalP(((BuffSkill) skillEvent.getSkill()).getBuffCriticalP());
                    buffSkill.addBuffDamage(((BuffSkill) skillEvent.getSkill()).getBuffDamage());
                    buffSkill.addBuffFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffFinalDamage());
                    buffSkill.addBuffIgnoreDefense(((BuffSkill) skillEvent.getSkill()).getBuffIgnoreDefense());
                    buffSkill.addBuffMainStat(((BuffSkill) skillEvent.getSkill()).getBuffMainStat());
                    buffSkill.addBuffMainStatP(((BuffSkill) skillEvent.getSkill()).getBuffMainStatP());
                    buffSkill.addBuffOtherStat1(((BuffSkill) skillEvent.getSkill()).getBuffOtherStat1());
                    buffSkill.addBuffOtherStat2(((BuffSkill) skillEvent.getSkill()).getBuffOtherStat2());
                    buffSkill.addBuffProperty(((BuffSkill) skillEvent.getSkill()).getBuffProperty());
                    buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
                    buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= finalAttack.getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(finalAttack, start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                attackDamage = (long) Math.floor(((job.getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                        + job.getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
                        * (Math.floor((job.getAtt() + buffSkill.getBuffAttMagic())
                        * (1 + (job.getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + job.getPerXAtt())
                        * job.getConstant()
                        * (1 + (job.getDamage() + job.getBossDamage() + job.getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (job.getFinalDamage() + buffSkill.getBuffPlusFinalDamage() - 1)
                        * buffSkill.getBuffFinalDamage()
                        * job.getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * job.getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (job.getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (job.getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3 * (1 - buffSkill.getIgnoreDefense()) * (1 - job.getIgnoreDefense()) * (1 - job.getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                }
                Long distance = end.getTime() - start.getTime();
                if (as.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / as.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        return attackDamage;
    }

    public Long calcRestraintRingDeal() {
        for (AttackSkill as : attackSkillList) {
            as.setShare(0.0);
            as.setUseCount(0L);
            as.setCumulativeDamage(0L);
        }
        List<Timestamp> tmp = new ArrayList<>();
        for (Timestamp ts : eventTimeList) {
            if (
                    (ts.equals(restraintRingStartTime) || ts.after(restraintRingStartTime))
                    && (ts.equals(restraintRingEndTime) || ts.before(restraintRingEndTime))
            ) {
                tmp.add(ts);
            }
        }
        return calcTotalDamage(tmp);
    }

    public Long calcFortyDeal() {
        for (AttackSkill as : attackSkillList) {
            as.setShare(0.0);
            as.setUseCount(0L);
            as.setCumulativeDamage(0L);
        }
        List<Timestamp> tmp = new ArrayList<>();
        for (Timestamp ts : eventTimeList) {
            if (
                    (ts.equals(restraintRingStartTime) || ts.after(restraintRingStartTime))
                    && (ts.equals(fortyEndTime) || ts.before(fortyEndTime))
            ) {
                tmp.add(ts);
            }
        }
        return calcTotalDamage(tmp);
    }

    public void sortEventTimeList() {
        getEventTimeList().add(getEnd());
        setEventTimeList(new ArrayList<>(new HashSet<>(getEventTimeList())));
        Collections.sort(getEventTimeList());
        while (getEnd().before(getEventTimeList().get(getEventTimeList().size() - 1))) {
            getEventTimeList().remove(getEventTimeList().size() - 1);
        }
    }

    public static <T> List<T> deduplication(final List<T> list, Function<? super T,?> key) {
        return list.stream()
                .filter(deduplication(key))
                .collect(Collectors.toList());
    }

   private static <T> Predicate<T> deduplication(Function<? super T, ?> key) {
        final Set<Object> set = ConcurrentHashMap.newKeySet();
        return predicate -> set.add(key.apply(predicate));
    }
}
