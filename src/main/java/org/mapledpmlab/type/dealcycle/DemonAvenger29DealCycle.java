package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.DemonAvenger;
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

public class DemonAvenger29DealCycle extends DealCycle {
    /*
     */

    // 메용2, 6차, 리레, 스인미, 크오솔
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private final List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private final List<Skill> dealCycle4 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ArmorBreak());
            add(new BloodFeast());
            add(new CrestOfTheSolarDA());
            add(new CrestOfTheSolarDot());
            add(new DemonFrenzy29());
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

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new DimensionSwordDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ArmorBreakDebuff());
            add(new AuraWeaponBuffDA());
            add(new CallMastemaDA());
            //add(new DemonFrenzyBuff());
            add(new DemonicFortitudeDA());
            //add(new ForbiddenContract());
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
    DemonFrenzy29 demonFrenzy29 = new DemonFrenzy29();
    DemonFrenzyBuff tmpDemonFrenzyBuff = new DemonFrenzyBuff();

    //
    int maxExceed = 18;
    int exceed = 18;

    int demonFrenzyAttackCnt = 0;
    int demonFrenzyHpReduceCnt = 0;
    int furyStorage = 0;
    Double thornOfFuryCooldown = 0.0;

    Timestamp revenantEndTime = new Timestamp(-1);
    ThornOfFury thornOfFury = new ThornOfFury();

    public DemonAvenger29DealCycle(Job job) {
        super(job, new FinalAttackDemonAvenger());

        getJob().setName("데몬 어벤져(29)");

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        ArmorBreak armorBreak = new ArmorBreak();
        AuraWeaponBuffDA auraWeaponBuff = new AuraWeaponBuffDA();
        BloodFeast bloodFeast = new BloodFeast();
        CallMastemaDA callMastema = new CallMastemaDA();
        CrestOfTheSolarDA crestOfTheSolar = new CrestOfTheSolarDA();
        DemonFrenzyBuff demonFrenzyBuff = new DemonFrenzyBuff();
        DemonicFortitudeDA demonicFortitudeDA = new DemonicFortitudeDA();
        DimensionSwordDelay dimensionSword = new DimensionSwordDelay();
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
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        // 1-4-3-2-3-4
        // 메용2, 6차, 리레, 스인미, 크오솔
        dealCycle1.add(armorBreak);
        dealCycle1.add(demonicFortitudeDA);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(callMastema);
        dealCycle1.add(otherWorldGoddessBlessing);
        dealCycle1.add(revenant);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(requiem);
        dealCycle1.add(dimensionSword);

        // 메용2, 6차, 웨폰퍼프
        dealCycle2.add(armorBreak);
        dealCycle2.add(demonicFortitudeDA);
        dealCycle2.add(callMastema);
        dealCycle2.add(otherWorldGoddessBlessing);
        dealCycle2.add(revenant);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(requiem);
        dealCycle2.add(dimensionSword);

        // 메용2, 리레, 스인미, 코오솔
        dealCycle3.add(armorBreak);
        dealCycle3.add(demonicFortitudeDA);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(callMastema);
        dealCycle3.add(otherWorldGoddessBlessing);
        dealCycle3.add(revenant);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);
        dealCycle3.add(dimensionSword);

        // 메용2, 웨폰퍼프
        dealCycle4.add(armorBreak);
        dealCycle4.add(demonicFortitudeDA);
        dealCycle4.add(callMastema);
        dealCycle4.add(otherWorldGoddessBlessing);
        dealCycle4.add(revenant);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(dimensionSword);

        // 펫이 자동으로 사용(딜레이 X)
        // 270초마다 쓸샾(5%), 쓸뻥(5%), 쓸컴뱃(5%), 쓸어블(5%) 사용
        // 180초마다 리프랙트 이블(900), 디아볼릭 리커버리(900) 사용
        int dealCycleOrder = 1;
        Timestamp buffEndTime1 = new Timestamp(270 * 1000);
        Timestamp buffEndTime2 = new Timestamp(180 * 1000);
        Timestamp diabolicRecoveryTime = new Timestamp(5500);

        addSkillEvent(releaseOverload);
        addSkillEvent(exceedExecution3);
        addSkillEvent(exceedExecution4);
        Timestamp releaseOverloadTime = new Timestamp(-1);
        Timestamp roarOfDemonSwordTime = new Timestamp(-1);
        int roarOfDemonSwordChk = 0;

        while (getStart().before(getEnd())) {
            if (hp < 150000) {
                hp = 150000;
            }
            if (getStart().after(buffEndTime1)) {
                hp -= maxHP * 0.2;
                buffEndTime1 = new Timestamp(getStart().getTime() + 270 * 1000);
                if (getStart().before(revenantEndTime)) {
                    furyStorage += maxHP * 0.2;
                    if (furyStorage >= 300000) {
                        furyStorage = 300000;
                    }
                    thornOfFury.setCooldownByFury(furyStorage);
                    if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                        thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                        thornOfFuryCooldown = thornOfFury.getCooldown();
                    }
                }
            }
            if (getStart().after(buffEndTime2)) {
                hp -= 1800;
                buffEndTime2 = new Timestamp(getStart().getTime() + 180 * 1000);
                if (getStart().before(revenantEndTime)) {
                    furyStorage += 1800;
                    if (furyStorage >= 300000) {
                        furyStorage = 300000;
                    }
                    thornOfFury.setCooldownByFury(furyStorage);
                    if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                        thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                        thornOfFuryCooldown = thornOfFury.getCooldown();
                    }
                }
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
                releaseOverloadTime = new Timestamp(getStart().getTime() + 45000);
                roarOfDemonSwordTime = new Timestamp(getStart().getTime() + 10000);
                roarOfDemonSwordChk = 1;
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
            ) {
                addDealCycle(dealCycle2);
                releaseOverloadTime = new Timestamp(getStart().getTime() + 45000);
                roarOfDemonSwordTime = new Timestamp(getStart().getTime() + 10000);
                roarOfDemonSwordChk = 1;
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 3 || dealCycleOrder == 5)
            ) {
                addDealCycle(dealCycle3);
                releaseOverloadTime = new Timestamp(getStart().getTime() + 45000);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                addSkillEvent(exceedExecution5);
                addSkillEvent(exceedExecution5);
                addDealCycle(dealCycle4);
                releaseOverloadTime = new Timestamp(getStart().getTime() + 45000);
                dealCycleOrder ++;
            } else if (
                    getStart().after(roarOfDemonSwordTime)
                    && roarOfDemonSwordChk == 1
            ) {
                addSkillEvent(roarOfDemonSword);
                roarOfDemonSwordChk = 0;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(9 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && (
                            (
                                    getStart().after(new Timestamp(30 * 1000))
                                            && getStart().before(new Timestamp(90 * 1000))
                            )
                                    ||
                                    (
                                            getStart().after(new Timestamp(150 * 1000))
                                                    && getStart().before(new Timestamp(210 * 1000))
                                    )
                                    ||
                                    (
                                            getStart().after(new Timestamp(270 * 1000))
                                                    && getStart().before(new Timestamp(330 * 1000))
                                    )
                                    ||
                                    (
                                            getStart().after(new Timestamp(390 * 1000))
                                                    && getStart().before(new Timestamp(450 * 1000))
                                    )
                                    ||
                                    (
                                            getStart().after(new Timestamp(510 * 1000))
                                                    && getStart().before(new Timestamp(570 * 1000))
                                    )
                                    ||
                                    (
                                            getStart().after(new Timestamp(630 * 1000))
                                                    && getStart().before(new Timestamp(690 * 1000))
                                    )
                    )
            ) {
                if (getStart().before(new Timestamp(90 * 1000))) {
                    addSkillEvent(otherWorldGoddessBlessing);
                }
                addSkillEvent(armorBreak);
                addSkillEvent(soulContract);
                releaseOverloadTime = new Timestamp(getStart().getTime() + 45000);
            } else if (
                    cooldownCheck(releaseOverload)
                    && getStart().after(releaseOverloadTime)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(releaseOverload);
                exceed = 9;
            } else if (cooldownCheck(bloodFeast)) {
                addSkillEvent(bloodFeast);
            } else if (cooldownCheck(shieldChasing)) {
                addSkillEvent(shieldChasing);
            } else {
                if (exceed == 9) {
                    addSkillEvent(exceedExecution3);
                } else if (exceed == 10) {
                    addSkillEvent(exceedExecution4);
                } else {
                    addSkillEvent(exceedExecution5);
                }
                if (exceed < 18) {
                    exceed++;
                }
            }
        }
        sortEventTimeList();
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;
        int j = 0;
        if (skill instanceof Revenant) {
            revenantEndTime = new Timestamp(getStart().getTime() + 18000);
            furyStorage = 0;
        }
        while (demonFrenzyAttackCnt < getStart().getTime() / 240) {
            getSkillEventList().add(new DemonAvengerSkillEvent(demonFrenzy29, new Timestamp(getStart().getTime() + j), new Timestamp(getStart().getTime() + j), (long) this.hp));
            getEventTimeList().add(new Timestamp(getStart().getTime() + j));
            j++;
            demonFrenzyAttackCnt++;
            hp += 500000 * 0.01;
            if (hp > 500000) {
                hp = 500000;
            }
        }
        while (demonFrenzyHpReduceCnt < getStart().getTime() / 1000) {
            hp -= 6000;
            demonFrenzyHpReduceCnt++;
            if (getStart().before(revenantEndTime)) {
                furyStorage += 6000;
                if (furyStorage >= 300000) {
                    furyStorage = 300000;
                }
                thornOfFury.setCooldownByFury(furyStorage);
            }
        }
        if (skill instanceof GaugeAttackSkill) {
            hp += ((GaugeAttackSkill) skill).getGaugeCharge();
            hp += maxHP * ((GaugeAttackSkill) skill).getGaugePer() * 0.01;
            if (getStart().before(revenantEndTime)) {
                if (((GaugeAttackSkill) skill).getGaugeCharge() < 0) {
                    furyStorage -= ((GaugeAttackSkill) skill).getGaugeCharge();
                }
                if (((GaugeAttackSkill) skill).getGaugePer() < 0) {
                    furyStorage -= maxHP * ((GaugeAttackSkill) skill).getGaugePer() * 0.01;
                }
                if (furyStorage >= 300000) {
                    furyStorage = 300000;
                }
                thornOfFury.setCooldownByFury(furyStorage);
                if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                    thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                    thornOfFuryCooldown = thornOfFury.getCooldown();
                }
            }
        } else if (skill instanceof GaugeBuffSkill) {
            hp += ((GaugeBuffSkill) skill).getGaugeCharge();
            hp += maxHP * ((GaugeBuffSkill) skill).getGaugePer() * 0.01;
            if (getStart().before(revenantEndTime)) {
                if (((GaugeBuffSkill) skill).getGaugeCharge() < 0) {
                    furyStorage -= ((GaugeBuffSkill) skill).getGaugeCharge();
                }
                if (((GaugeBuffSkill) skill).getGaugePer() < 0) {
                    furyStorage -= maxHP * ((GaugeBuffSkill) skill).getGaugePer() * 0.01;
                }
                if (furyStorage >= 300000) {
                    furyStorage = 300000;
                }
                thornOfFury.setCooldownByFury(furyStorage);
                if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                    thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                    thornOfFuryCooldown = thornOfFury.getCooldown();
                }
            }
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
                getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, (long) this.hp));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, (long) this.hp));
            }
        } else {
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (skill instanceof ShieldChasingAfterSecond) {
                        break;
                    }
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
                        getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.hp));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.hp));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, (long) this.hp));
                if (
                        (
                                skill instanceof ExceedExecution1
                                || skill instanceof ExceedExecution2
                                || skill instanceof ExceedExecution3
                                || skill instanceof ExceedExecution4
                                || skill instanceof ExceedExecution5
                        )
                        && getStart().before(revenantEndTime)
                        && cooldownCheck(thornOfFury)
                ) {
                    getSkillEventList().add(new DemonAvengerSkillEvent(thornOfFury, endTime, endTime, (long) this.hp));
                    applyCooldown(thornOfFury);
                }
            }
            hp += 500000 * 0.01;
            if (hp > 500000) {
                hp = 500000;
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
                        totalDamage += getAttackDamage(new DemonAvengerSkillEvent(getFinalAttack(), start, end, ((DemonAvengerSkillEvent) se).getCurrentHp()), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        tmpDemonFrenzyBuff.setFinalDamageByHp(((DemonAvengerSkillEvent) skillEvent).getCurrentHp());
        buffSkill.addBuffFinalDamage(tmpDemonFrenzyBuff.getBuffFinalDamage());
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(((((DemonAvenger) getJob()).getFinalHp())// * 4
                        + ((DemonAvenger) getJob()).getStr()) * 0.01
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
        buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / tmpDemonFrenzyBuff.getBuffFinalDamage());
        return attackDamage;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), (long) this.hp));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    !(skill instanceof Requiem)
                    && !(skill instanceof RequiemDemonSword)
            ) {
                hp += 500000 * 0.01;
                if (hp > 500000) {
                    hp = 500000;
                }
            }
        }
    }

    @Override
    public void getJobInfo() {
        System.out.println("-------------------");
        System.out.println("직업 : " + getJob().getName());
        System.out.println("순 HP : " + getJob().getAp());
        System.out.println("총 HP : " + ((DemonAvenger) getJob()).getTotalHp());
        System.out.println("기본 주스탯 수치 : " + getJob().getHp());
        System.out.println("주스탯 % 수치 : " + (getJob().getMainStatP()));
        System.out.println("% 미적용 주스탯 수치 : " + getJob().getPerXMainStat());
        System.out.println("기본 부스탯 수치 : " + getJob().getMainStat());
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
        System.out.println("총 공격력 : " + getJob().getAtt());
        System.out.println(getJob().getLinkListStr());
        System.out.println(getJob().getAbility().getDescription());
    }
}
