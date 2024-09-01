package org.mapledpmlab.type.etc;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.dealcyclesolo.SkillEvent;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
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
    public Timestamp restraintRingStartTime = null;
    public Timestamp restraintRingEndTime = null;
    public Timestamp fortyEndTime = null;
    public Timestamp originXRestraintRingStartTime = null;
    public Timestamp originXRestraintRingEndTime = null;
    Long totalDamage;
    Long DPM;
    Long restraintRingDeal;
    Long fortyDeal;
    Long originXRestraintRingDeal;
    public int i=0;

    public DealCycle() {}

    public DealCycle(Job job, AttackSkill finalAttack) {
        setFinalAttack(finalAttack);
        setJob(job);
        getJob().addTotal(getJob().getJobType());
    }

    public void setSoloDealCycle() {}

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
            } else if (
                    skill instanceof RestraintRing
                    && restraintRingStartTime != null
                    && restraintRingEndTime != null
                    && fortyEndTime != null
                    && originXRestraintRingStartTime == null
                    && originXRestraintRingEndTime == null
            ) {
                originXRestraintRingStartTime = new Timestamp(getStart().getTime());
                originXRestraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
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
        return getStart().after(skill.getActivateTime()) || getStart().equals(skill.getActivateTime());
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
        if (skill.getCooldown() <= 1) {
            return skill.getCooldown();
        }
        cooldown = skill.getCooldown() * (1 - job.getCooldownReductionP() * 0.01);
        if (cooldown <= 1) {
            cooldown = 1.0;
            return cooldown;
        }
        if (cooldown <= 5) {
            return cooldown;
        }
        cooldownReduction = getJob().getCooldownReductionSec().doubleValue();
        while (cooldownReduction != 0) {
            if (cooldown - 10 > 0) {
                cooldown -= cooldownReduction;
                cooldownReduction = 0.0;
            } else if (cooldown <= 10) {
                cooldown = cooldown * (1 - cooldownReduction * 0.05);
                cooldownReduction = 0.0;
            } else if (cooldown - 10 <= cooldownReduction) {
                cooldown = 10.0;
                cooldownReduction -= (cooldown - 10);
            }
            if (cooldown <= 5) {
                cooldown = 5.0;
            }
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
        setOriginXRestraintRingDeal(calcOriginXRestraintDeal());
        Object[] result = new Object[]{
                this.getJob().getName(), String.valueOf(this.getDPM()),
                "=TEXT(" + getDPM() + "/SUM(IF(A2:A100=\"비숍(2분, 컨티)\", VALUE(B2:B100),0)),\"0.0%\")", String.valueOf(this.getRestraintRingDeal()),
                "=TEXT(" + getRestraintRingDeal() + "/SUM(IF(A2:A100=\"비숍(2분, 컨티)\", VALUE(D2:D100),0)),\"0.0%\")", String.valueOf(this.getFortyDeal()),
                "=TEXT(" + getFortyDeal() + "/SUM(IF(A2:A100=\"비숍(2분, 컨티)\", VALUE(F2:F100),0)),\"0.0%\")", String.valueOf(this.getOriginXRestraintRingDeal()),
                "=TEXT(" + getOriginXRestraintRingDeal() + "/SUM(IF(A2:A100=\"비숍(2분, 컨티)\", VALUE(H2:H100),0)),\"0.0%\")"
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
                StackTraceElement[] stackTraceElement = new Throwable().getStackTrace();
                if (
                        stackTraceElement[1].getMethodName().equals("calcOriginXRestraintDeal")
                        && (
                                skillEvent.getSkill() instanceof CrestOfTheSolarDot
                                || skillEvent.getSkill() instanceof SpiderInMirrorDot
                        )
                ) {
                    continue;
                }
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
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
                for (BuffSkill bs : buffSkillList) {
                    if (
                            bs.getClass().getName().equals(skillEvent.getSkill().getClass().getName())
                            && start.equals(skillEvent.getStart())
                    ) {
                        bs.setUseCount(bs.getUseCount() + 1);
                        bs.getStartTimeList().add(skillEvent.getStart());
                        bs.getEndTimeList().add(skillEvent.getEnd());
                    }
                }
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

    public Long getDotDamage(AttackSkill attackSkill, BuffSkill buffSkill) {
        Long attackDamage;
        attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                + getJob().getFinalSubstat()) * 0.01
                * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                + getJob().getPerXAtt())
                * getJob().getConstant()
                * (1 + (
                        getJob().getDamage()
                                + getJob().getBossDamage()
                                + getJob().getStatXDamage()
                                + buffSkill.getBuffDamage()
                                + attackSkill.getAddDamage()
                                - 310
                                - 0.5 * (1 - (getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01)
                ) * 0.01)
                * getJob().getMastery()
                * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
        );
        return attackDamage;
    }

    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : getAttackSkillList()) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
                    attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat()) * 0.01
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
                            * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - getJob().getIgnoreDefense()) * (1 - getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                    );
                }
                this.getJob().addMainStat(-buffSkill.getBuffMainStat());
                this.getJob().addSubStat(-buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(-buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(-buffSkill.getBuffOtherStat2());
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                    as.setCumulativeAttackCount(as.getCumulativeAttackCount() + attackSkill.getAttackCount());
                }
                Long distance = end.getTime() - start.getTime();
                if (attackSkill.getMultiAttackInfo().size() == 0 && attackSkill.getInterval() == 0 && attackSkill.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / attackSkill.getDelay() * distance;
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

    public Long calcOriginXRestraintDeal() {
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(0.0);
            as.setUseCount(0L);
            as.setCumulativeDamage(0L);
        }
        List<Timestamp> tmp = new ArrayList<>();
        for (Timestamp ts : getEventTimeList()) {
            if (
                    (ts.equals(getOriginXRestraintRingStartTime()) || ts.after(getOriginXRestraintRingStartTime()))
                            && (ts.equals(getOriginXRestraintRingEndTime()) || ts.before(getOriginXRestraintRingEndTime()))
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
        for (int i = 0; i < 720; i = i + 5) {
            List<Timestamp> tmp = new ArrayList<>();
            Long dps = 0L;
            for (Timestamp ts : getEventTimeList()) {
                if (
                        (ts.equals(new Timestamp(i * 1000L)) || ts.after(new Timestamp(i * 1000L)))
                        && (ts.equals(new Timestamp((i + 5) * 1000L)) || ts.before(new Timestamp((i + 5) * 1000L)))
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

    public void getJobInfo() {
        System.out.println("-------------------");
        System.out.println("직업 : " + getJob().getName());
        System.out.println("기본 주스탯 수치 : " + getJob().getMainStat());
        System.out.println("주스탯 % 수치 : " + (getJob().getMainStatP() + getJob().getAllStatP()));
        System.out.println("% 미적용 주스탯 수치 : " + getJob().getPerXMainStat());
        System.out.println("기본 부스탯 수치 : " + getJob().getSubStat());
        System.out.println("부스탯 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXSubStat());
        System.out.println("기본 스공 : " + getJob().getStatDamage());
        System.out.println("데미지 : " + getJob().getDamage());
        System.out.println("최종데미지 : " + getJob().getFinalDamage());
        System.out.println("보스 데미지 : " + getJob().getBossDamage());
        System.out.println("방어율 무시 : " + getJob().getIgnoreDefense());
        System.out.println("크리티컬 확률 : " + getJob().getCriticalP());
        System.out.println("장비 공격력 % : " + getJob().getAttP());
        System.out.println("장비 마력 % : " + getJob().getMagicP());
        System.out.println("크리티컬 데미지 : " + getJob().getCriticalDamage());
        System.out.println("쿨타임 감소 초 : " + getJob().getCooldownReductionSec());
        System.out.println("쿨타임 감소 % : " + getJob().getCooldownReductionP());
        System.out.println("버프 지속 시간 : " + getJob().getPlusBuffDuration());
        System.out.println("재사용 : " + getJob().getReuse());
        System.out.println("속성 내성 무시 : " + getJob().getProperty());
        System.out.println("무기 공격력 : " + getJob().getWeaponAttMagic());
        System.out.println(getJob().getLinkListStr());
        System.out.println(getJob().getAbility().getDescription());
    }
}
