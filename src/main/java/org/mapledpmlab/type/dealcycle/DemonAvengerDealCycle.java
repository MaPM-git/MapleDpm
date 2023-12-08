package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.hyper.HyperDemonAvenger;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.MastemaClaw;
import org.mapledpmlab.type.skill.attackskill.common.OtherWorldVoid;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.attackskill.demonavenger.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.PriorPreparation;
import org.mapledpmlab.type.skill.buffskill.common.RingSwitching;
import org.mapledpmlab.type.skill.buffskill.common.SoulContract;
import org.mapledpmlab.type.skill.buffskill.common.ThiefCunning;
import org.mapledpmlab.type.skill.buffskill.demonavenger.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DemonAvengerDealCycle extends DealCycle {
    /*
     */

    // 메용2, 6차, 리레, 스인미, 크오솔
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private List<Skill> dealCycle4 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ArmorBreak());
            add(new BloodFeast());
            add(new CrestOfTheSolarDA());
            add(new CrestOfTheSolarDot());
            add(new DemonFrenzy());
            add(new DimensionSword());
            add(new ExceedExecution1());
            add(new ExceedExecution2());
            add(new ExceedExecution3());
            add(new ExceedExecution4());
            add(new ExceedExecution5());
            add(new FinalAttackDemonAvenger());
            add(new MastemaClaw());
            add(new OtherWorldVoid());
            add(new Requiem());
            add(new RequiemDemonSword());
            add(new RoarOfDemonSword());
            add(new ShieldChasing());
            add(new ShieldChasingAfterSecond());
            add(new SpiderInMirrorDA());
            add(new SpiderInMirrorDot());
            add(new ThornOfFury());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new RequiemDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ArmorBreakDebuff());
            add(new AuraWeaponBuffDA());
            add(new CallMastemaDA());
            add(new DemonFrenzyBuff());
            add(new DemonicFortitudeDA());
            add(new ForbiddenContract());
            add(new OtherWorldGoddessBlessingDA());
            add(new PriorPreparation());
            add(new RestraintRingDA());
            add(new Revenant());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRingDA(875L));
        }
    };

    int maxHP = 500000;
    int hp = 150000;

    int exceed = 18;

    public DemonAvengerDealCycle(Job job) {
        super();
        this.setFinalAttack(new FinalAttackDemonAvenger());
        this.setJob(job);
        this.getJob().addTotal(this.getJob().getJobType());
        this.getJob().addObject(new HyperDemonAvenger(this.getJob().getLevel(), getJob().getCriticalP()));

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        ArmorBreak armorBreak = new ArmorBreak();
        AuraWeaponBuffDA auraWeaponBuff = new AuraWeaponBuffDA();
        BloodFeast bloodFeast = new BloodFeast();
        CallMastemaDA callMastema = new CallMastemaDA();
        CrestOfTheSolarDA crestOfTheSolar = new CrestOfTheSolarDA();
        DemonFrenzy demonFrenzy = new DemonFrenzy();
        DemonFrenzyBuff demonFrenzyBuff = new DemonFrenzyBuff();
        DemonicFortitudeDA demonicFortitudeDA = new DemonicFortitudeDA();
        DimensionSword dimensionSword = new DimensionSword();
        ExceedExecution1 exceedExecution1 = new ExceedExecution1();
        ExceedExecution2 exceedExecution2 = new ExceedExecution2();
        ExceedExecution3 exceedExecution3 = new ExceedExecution3();
        ExceedExecution4 exceedExecution4 = new ExceedExecution4();
        ExceedExecution5 exceedExecution5 = new ExceedExecution5();
        ForbiddenContract forbiddenContract = new ForbiddenContract();
        OtherWorldGoddessBlessingDA otherWorldGoddessBlessing = new OtherWorldGoddessBlessingDA();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReleaseOverload releaseOverload = new ReleaseOverload();
        Requiem requiem = new Requiem();
        Revenant revenant = new Revenant();
        RoarOfDemonSword roarOfDemonSword = new RoarOfDemonSword();
        RestraintRingDA restraintRing = new RestraintRingDA();
        RingSwitching ringSwitching = new RingSwitching();
        ShieldChasing shieldChasing = new ShieldChasing();
        SoulContract soulContract = new SoulContract();
        SpiderInMirrorDA spiderInMirror = new SpiderInMirrorDA();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRingDA weaponJumpRing = new WeaponJumpRingDA(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        // 1-4-3-2-3-4
        // 메용2, 6차, 리레, 스인미, 크오솔
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(callMastema);
        dealCycle1.add(otherWorldGoddessBlessing);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);

        // 메용2, 6차, 웨폰퍼프
        dealCycle2.add(callMastema);
        dealCycle2.add(otherWorldGoddessBlessing);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);

        // 메용2, 리레, 스인미, 코오솔
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(callMastema);
        dealCycle3.add(otherWorldGoddessBlessing);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);

        // 메용2, 웨폰퍼프
        dealCycle4.add(callMastema);
        dealCycle4.add(otherWorldGoddessBlessing);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);

        // 펫이 자동으로 사용(딜레이 X)
        // 270초마다 쓸샾(5%), 쓸뻥(5%), 쓸컴뱃(5%), 쓸어블(5%) 사용
        // 180초마다 리프랙트 이블(900), 디아볼릭 리커버리(900) 사용
        int dealCycleOrder = 1;
        Timestamp buffEndTime1 = new Timestamp(270 * 1000);
        Timestamp buffEndTime2 = new Timestamp(180 * 1000);
        Timestamp diabolicRecoveryTime = new Timestamp(5500);
        while (getStart().before(getEnd())) {
            if (getStart().after(buffEndTime1)) {
                hp -= maxHP * 0.2;
                buffEndTime1 = new Timestamp(getStart().getTime() + 270 * 1000);
            }
            if (getStart().after(buffEndTime2)) {
                hp -= 1800;
                buffEndTime2 = new Timestamp(getStart().getTime() + 180 * 1000);
            }
            if (getStart().after(diabolicRecoveryTime)) {
                hp += maxHP * 0.05;
                diabolicRecoveryTime = new Timestamp(getStart().getTime() + 5500);
            }
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 1
            ) {
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
            ) {
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 3 || dealCycleOrder == 5)
            ) {
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(9 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else {
                addSkillEvent(null);
            }
        }
        sortEventTimeList();
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;
        double gaugeTmp = 0;
        if (skill instanceof GaugeAttackSkill) {
            hp += ((GaugeAttackSkill) skill).getGaugeCharge();
            hp += maxHP * ((GaugeAttackSkill) skill).getGaugePer() * 0.01;
        } else if (skill instanceof GaugeBuffSkill) {
            hp += ((GaugeBuffSkill) skill).getGaugeCharge();
            hp += maxHP * ((GaugeBuffSkill) skill).getGaugePer() * 0.01;
        }
        if (hp > 500000) {
            hp = 500000;
        }
        if (hp < 1) {
            hp = 1;
        }
        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (
                    skill instanceof RestraintRingDA
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
                this.getSkillEventList().removeAll(remove);
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
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 1) {
                    buffSkill.addBuffDamage(100L);      // 데스 커스 
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
