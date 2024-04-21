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
    private List<Long> dpsList = new ArrayList<>();
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
        setFinalAttack(finalAttack);
        setJob(job);
        getJob().addTotal(getJob().getJobType());
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
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
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
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
                getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        }
        applyCooldown(skill);
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }

    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= getJob().getReuse()) {
                } else  {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            } else {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
            }
            if (!skill.isApplyCooldownReduction()) {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + skill.getCooldown() * 1000)));
            }
        }
    }

    public void addDealCycle(List<Skill> skillList) {
        for (Skill s : skillList) {
            this.addSkillEvent(s);
        }
    }

    public boolean cooldownCheck(Skill skill) {
        if (!(getStart().after(skill.getActivateTime()) || getStart().equals(skill.getActivateTime()))) {
            return false;
        }
        return true;
    }

    public boolean cooldownCheck(List<Skill> skillList) {
        for (Skill s : skillList) {
            if (!(getStart().after(s.getActivateTime()) || getStart().equals(s.getActivateTime()))) {
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
        getJob().Doping();
        setTotalDamage(calcTotalDamage(getEventTimeList()));
    }

    public void print() {
        Long verifyDamage = 0L;
        for (AttackSkill as : getAttackSkillList()) {
            /*if (as.getCumulativeDamage() == 0) {
                continue;
            }*/
            as.print();
            verifyDamage += as.getCumulativeDamage();
        }
        System.out.println("검증용 : " + verifyDamage);
        System.out.println("총데미지 : " + getTotalDamage());
        System.out.println("DPM : " + getTotalDamage()/12);
        System.out.println("리스트레인트링 : " + calcRestraintRingDeal());
        System.out.println("40초 : " + calcFortyDeal());
    }

    public Object[] getObject() {
        setDPM(getTotalDamage() / 12);
        setRestraintRingDeal(calcRestraintRingDeal());
        setFortyDeal(calcFortyDeal());
        Object[] result = new Object[]{
                this.getJob().getName(), this.getDPM() + "",
                "=TEXT(" + getDPM() + "/SUM(IF(A2:A48=\"비숍\", VALUE(B2:B48),0)),\"0.0%\")", this.getRestraintRingDeal() + "",
                "=TEXT(" + getRestraintRingDeal() + "/SUM(IF(A2:A48=\"비숍\", VALUE(D2:D48),0)),\"0.0%\")", this.getFortyDeal() + "",
                "=TEXT(" + getFortyDeal() + "/SUM(IF(A2:A48=\"비숍\", VALUE(F2:F48),0)),\"0.0%\")"
        };
        return result;
    }

    public List<SkillEvent> getOverlappingSkillEvents(Timestamp start, Timestamp end) {
        List<SkillEvent> overlappingSkillEvents = new ArrayList<>();
        for (SkillEvent skillEvent : getSkillEventList()) {
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
            List<SkillEvent> useBuffSkillList = new ArrayList<>();
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            for (SkillEvent skillEvent : useBuffSkillList) {
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
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : getAttackSkillList()) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                attackDamage = (long) Math.floor(((getJob().getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                        + getJob().getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
                        * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                        * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + getJob().getPerXAtt())
                        * getJob().getConstant()
                        * (1 + (getJob().getDamage() + getJob().getBossDamage() + getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (getJob().getFinalDamage())
                        * buffSkill.getBuffFinalDamage()
                        * getJob().getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3 * (1 - buffSkill.getIgnoreDefense()) * (1 - getJob().getIgnoreDefense()) * (1 - getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                }
                Long distance = end.getTime() - start.getTime();
                if (as.getMultiAttackInfo().size() == 0 && as.getInterval() == 0 && as.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / as.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        return attackDamage;
    }

    public Long calcRestraintRingDeal() {
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(0.0);
            as.setUseCount(0L);
            as.setCumulativeDamage(0L);
        }
        List<Timestamp> tmp = new ArrayList<>();
        for (Timestamp ts : getEventTimeList()) {
            if (
                    (ts.equals(getRestraintRingStartTime()) || ts.after(getRestraintRingStartTime()))
                    && (ts.equals(getRestraintRingEndTime()) || ts.before(getRestraintRingEndTime()))
            ) {
                tmp.add(ts);
            }
        }
        return calcTotalDamage(tmp);
    }

    public Long calcFortyDeal() {
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(0.0);
            as.setUseCount(0L);
            as.setCumulativeDamage(0L);
        }
        List<Timestamp> tmp = new ArrayList<>();
        for (Timestamp ts : getEventTimeList()) {
            if (
                    (ts.equals(getRestraintRingStartTime()) || ts.after(getRestraintRingStartTime()))
                    && (ts.equals(getFortyEndTime()) || ts.before(getFortyEndTime()))
            ) {
                tmp.add(ts);
            }
        }
        return calcTotalDamage(tmp);
    }

    public void calcDps() {
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(0.0);
            as.setUseCount(0L);
            as.setCumulativeDamage(0L);
        }
        for (int i = 0; i < 720; i++) {
            List<Timestamp> tmp = new ArrayList<>();
            Long dps = 0L;
            for (Timestamp ts : getEventTimeList()) {
                if (
                        (ts.equals(new Timestamp(i * 1000)) || ts.after(new Timestamp(i * 1000)))
                        && (ts.equals(new Timestamp((i + 1) * 1000)) || ts.before(new Timestamp((i + 1) * 1000)))
                ) {
                    tmp.add(ts);
                }
            }
            dps += calcTotalDamage(tmp);
            dpsList.add(dps);
        }
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
