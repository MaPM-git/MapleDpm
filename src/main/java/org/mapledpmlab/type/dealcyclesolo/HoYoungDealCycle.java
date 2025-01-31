package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.hoyoung.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.hoyoung.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HoYoungDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ChasingGhostTalisman());
            //add(new ConflagrationChainHeaven());
            //add(new ConflagrationChainHeavenFalseTrue());
            //add(new ConflagrationChainHeavenReinforce());
            //add(new ConflagrationChainHeavenFlame());
            //add(new ConflagrationChainHeavenFalseTrueReinforce());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EarthChainEarth());
            add(new EarthChainFalseTrue());
            add(new EarthChainEarthReinforce());
            add(new EarthChainFalseTrueReinforce());
            add(new EarthquakeChainEarth());
            add(new EarthquakeChainFalseTrue());
            add(new EarthquakeChainEarthReinforce());
            add(new EarthquakeChainEarthAloofBlueMoon());
            add(new EarthquakeChainFalseTrueReinforce());
            add(new FistMethodButterflyDreamAttack());
            add(new FistMethodDoomingLight());
            add(new FistMethodInhalingVortex());
            add(new FistMethodMountainSpiritSummon());
            add(new FistMethodMountainSpiritSummonRoar());
            add(new FlyingFanHuman());
            add(new FlyingFanHumanReinforce());
            add(new GoldCudgelHuman());
            add(new GoldCudgelHumanFinish());
            add(new GoldCudgelHumanReinforce());
            add(new GoldCudgelHumanEnergyOfGoblin());
            add(new GoldCudgelHumanFinishReinforce());
            //add(new MagicCalabash1());
            //add(new MagicCalabash2());
            add(new MysticEnergyApotheosisKeydown1());
            add(new MysticEnergyApotheosisKeydown2());
            add(new MysticEnergyApotheosisFinish());
            add(new MysticEnergyCloneSageTaeul());
            add(new MysticEnergyExtremeRampageAttack());
            add(new MysticEnergyIllusionOfHeavenEarthAndHumanAttack());
            add(new PhantasmalCloneTalismanAttack());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new AdventOfGods());
            add(new StrokeOfGods());
            add(new WindWaveHeaven());
            add(new WindWaveFalseTrue());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AdventOfGodsBuff());
            //add(new AllCreationOfHeavenAndEarth());
            add(new FistMethodButterflyDreamBuff());
            add(new FistMethodDoomingLightBuff());
            add(new GrandisGoddessBlessingAnima());
            add(new MysticEnergyAdventOfRebelliousPower());
            add(new MysticEnergyExtremeCloneRampage());
            add(new MysticEnergyIllusionOfHeavenEarthAndHuman());
            add(new MysticEnergyTaeulDivineMedicine());
            add(new PhantasmalCloneTalisman());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    boolean isCooldownReset =false;
    boolean isReinforce = false;

    int advent = 0;
    int beforeProperty = 0; // 0 - 천, 1 - 지, 2 - 인
    int flameCnt = 0;
    int illusionAttack = 0;
    int linkCnt = 0;
    int scroll = 900;
    int talisman = 100;

    Timestamp adventEndTime = new Timestamp(-1);
    Timestamp extremeEndTime = new Timestamp(-1);
    Timestamp finalTime = new Timestamp(-1);
    Timestamp flameEndTime = new Timestamp(-1);
    Timestamp grandisEndTime = new Timestamp(-1);
    Timestamp illusionEndTime = new Timestamp(-1);
    Timestamp medicineEndTime = new Timestamp(-1);
    Timestamp medicineEndTime2 = new Timestamp(-1);
    Timestamp mountainEndTime = new Timestamp(-1);

    List<Boolean> property = new ArrayList<>(){
        {
            add(false); // 천
            add(false); // 지
            add(false); // 인
        }
    };

    AdventOfGods adventOfGods = new AdventOfGods();
    AllCreationOfHeavenAndEarth allCreationOfHeavenAndEarth = new AllCreationOfHeavenAndEarth();
    ChasingGhostTalisman chasingGhostTalisman = new ChasingGhostTalisman();
    ConflagrationChainHeaven conflagrationChainHeaven = new ConflagrationChainHeaven();
    ConflagrationChainHeavenFlame conflagrationChainHeavenFlame = new ConflagrationChainHeavenFlame();
    ConflagrationChainHeavenReinforce conflagrationChainHeavenReinforce = new ConflagrationChainHeavenReinforce();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    EarthChainEarth earthChainEarth = new EarthChainEarth();
    EarthChainEarthReinforce earthChainEarthReinforce = new EarthChainEarthReinforce();
    EarthquakeChainEarth earthquakeChainEarth = new EarthquakeChainEarth();
    EarthquakeChainEarthReinforce earthquakeChainEarthReinforce = new EarthquakeChainEarthReinforce();
    FistMethodButterflyDreamAttack fistMethodButterflyDreamAttack = new FistMethodButterflyDreamAttack();
    FistMethodButterflyDreamBuff fistMethodButterflyDreamBuff = new FistMethodButterflyDreamBuff();
    FistMethodDoomingLight fistMethodDoomingLight = new FistMethodDoomingLight();
    FistMethodInhalingVortex fistMethodInhalingVortex = new FistMethodInhalingVortex();
    FistMethodMountainSpiritSummon fistMethodMountainSpiritSummon = new FistMethodMountainSpiritSummon();
    FistMethodMountainSpiritSummonRoar fistMethodMountainSpiritSummonRoar = new FistMethodMountainSpiritSummonRoar();
    FlyingFanHuman flyingFanHuman = new FlyingFanHuman();
    FlyingFanHumanReinforce flyingFanHumanReinforce = new FlyingFanHumanReinforce();
    GoldCudgelHuman goldCudgelHuman = new GoldCudgelHuman();
    GoldCudgelHumanReinforce goldCudgelHumanReinforce = new GoldCudgelHumanReinforce();
    GrandisGoddessBlessingAnima grandisGoddessBlessingAnima = new GrandisGoddessBlessingAnima();
    MagicCalabash1 magicCalabash1 = new MagicCalabash1();
    MysticEnergyAdventOfRebelliousPower mysticEnergyAdventOfRebelliousPower = new MysticEnergyAdventOfRebelliousPower();
    MysticEnergyApotheosisKeydown1 mysticEnergyApotheosisKeydown1 = new MysticEnergyApotheosisKeydown1();
    MysticEnergyCloneSageTaeul mysticEnergyCloneSageTaeul = new MysticEnergyCloneSageTaeul();
    MysticEnergyExtremeCloneRampage mysticEnergyExtremeCloneRampage = new MysticEnergyExtremeCloneRampage();
    MysticEnergyExtremeRampageAttack mysticEnergyExtremeRampageAttack = new MysticEnergyExtremeRampageAttack();
    MysticEnergyIllusionOfHeavenEarthAndHuman mysticEnergyIllusionOfHeavenEarthAndHuman = new MysticEnergyIllusionOfHeavenEarthAndHuman();
    MysticEnergyIllusionOfHeavenEarthAndHumanAttack mysticEnergyIllusionOfHeavenEarthAndHumanAttack = new MysticEnergyIllusionOfHeavenEarthAndHumanAttack();
    MysticEnergyTaeulDivineMedicine mysticEnergyTaeulDivineMedicine = new MysticEnergyTaeulDivineMedicine();
    MysticEnergyTaeulDivineMedicineTic mysticEnergyTaeulDivineMedicineTic = new MysticEnergyTaeulDivineMedicineTic();
    PhantasmalCloneTalisman phantasmalCloneTalisman = new PhantasmalCloneTalisman();
    PhantasmalCloneTalismanAttack phantasmalCloneTalismanAttack = new PhantasmalCloneTalismanAttack();
    ReadyToDie readyToDie = new ReadyToDie();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    StrokeOfGods strokeOfGods = new StrokeOfGods();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    WindWaveHeaven windWaveHeaven = new WindWaveHeaven();

    public HoYoungDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(87.0);
        ringSwitching.setApplyCooldownReduction(false);

        conflagrationChainHeavenReinforce.setCooldown(15.0);

        grandisGoddessBlessingAnima.setCooldown(120.0);

        getSkillSequence1().add(grandisGoddessBlessingAnima);
        getSkillSequence1().add(mysticEnergyIllusionOfHeavenEarthAndHuman);
        getSkillSequence1().add(mysticEnergyExtremeCloneRampage);

        getSkillSequence2().add(mysticEnergyAdventOfRebelliousPower);
        getSkillSequence2().add(soulContract);                              // 30
        getSkillSequence2().add(readyToDie);                                // 380
        getSkillSequence2().add(restraintRing);                             // 30

        getSkillSequence3().add(mysticEnergyIllusionOfHeavenEarthAndHuman); // 220
        getSkillSequence3().add(soulContract);                              // 30
        getSkillSequence3().add(readyToDie);
        getSkillSequence3().add(weaponJumpRing);                            // 30

        getSkillSequence4().add(mysticEnergyTaeulDivineMedicine);
        getSkillSequence4().add(phantasmalCloneTalisman);
        getSkillSequence4().add(fistMethodButterflyDreamBuff);

        grandisGoddessBlessingAnima.setDelay(220L);
        mysticEnergyIllusionOfHeavenEarthAndHuman.setDelay(220L);
        mysticEnergyExtremeCloneRampage.setDelay(220L);

        mysticEnergyAdventOfRebelliousPower.setDelay(220L);

        readyToDie.setDelay(380L);

        mysticEnergyTaeulDivineMedicine.setDelay(220L);
        phantasmalCloneTalisman.setDelay(220L);
        fistMethodButterflyDreamBuff.setDelay(220L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(mysticEnergyExtremeCloneRampage)) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence4());
                addSkillEvent(fistMethodInhalingVortex);
                addSkillEvent(fistMethodMountainSpiritSummon);
                addSkillEvent(chasingGhostTalisman);
                addSkillEvent(fistMethodDoomingLight);
                addDealCycle(getSkillSequence1());
                if (cooldownCheck(earthquakeChainEarth)) {
                    addSkillEvent(earthquakeChainEarth);
                } else if (cooldownCheck(earthChainEarth)) {
                    addSkillEvent(earthChainEarth);
                }
                addDealCycle(getSkillSequence2());
                addSkillEvent(mysticEnergyCloneSageTaeul);
                if (cooldownCheck(mysticEnergyApotheosisKeydown1)) {
                    addSkillEvent(mysticEnergyApotheosisKeydown1);
                }
            } else if (
                    cooldownCheck(chasingGhostTalisman)
                    && getStart().before(new Timestamp(mysticEnergyExtremeCloneRampage.getActivateTime().getTime() - 5000))
            ) {
                addDealCycle(getSkillSequence4());
                addSkillEvent(fistMethodInhalingVortex);
                addSkillEvent(chasingGhostTalisman);
                addSkillEvent(fistMethodDoomingLight);
                addDealCycle(getSkillSequence3());
            } else if (getStart().after(finalTime)) {
                addSkillEvent(adventOfGods);
                finalTime = new Timestamp(720 * 1000);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(fistMethodInhalingVortex)
                            && getStart().before(new Timestamp(soulContract.getActivateTime().getTime() - 15000))
                            && scroll == 900
            ) {
                addSkillEvent(fistMethodInhalingVortex);
            } else if (isReinforce) {
                if (cooldownCheck(earthquakeChainEarthReinforce)) {
                    addSkillEvent(earthquakeChainEarthReinforce);
                } else if (cooldownCheck(goldCudgelHumanReinforce)) {
                    addSkillEvent(goldCudgelHumanReinforce);
                } else if (cooldownCheck(flyingFanHumanReinforce)) {
                    addSkillEvent(flyingFanHumanReinforce);
                }
                earthquakeChainEarth.setActivateTime(new Timestamp(earthquakeChainEarthReinforce.getActivateTime().getTime()));
                goldCudgelHuman.setActivateTime(new Timestamp(goldCudgelHumanReinforce.getActivateTime().getTime()));
                conflagrationChainHeaven.setActivateTime(new Timestamp(conflagrationChainHeavenReinforce.getActivateTime().getTime()));
                flyingFanHuman.setActivateTime(new Timestamp(flyingFanHumanReinforce.getActivateTime().getTime()));
                isReinforce = false;
            } else if (getStart().before(new Timestamp(illusionEndTime.getTime() - 500))) {
                if (!property.get(1)) {
                    addSkillEvent(earthChainEarth);
                }
                addSkillEvent(earthChainEarth);
                if (cooldownCheck(goldCudgelHuman)) {
                    addSkillEvent(goldCudgelHuman);
                    if (!property.get(0)) {
                        addSkillEvent(windWaveHeaven);
                    }
                    if (!property.get(1)) {
                        addSkillEvent(earthChainEarth);
                    }
                    addSkillEvent(goldCudgelHuman);
                }
            } else {
                if (cooldownCheck(goldCudgelHuman)) {
                    addSkillEvent(goldCudgelHuman);
                } else if (cooldownCheck(earthquakeChainEarth)) {
                    addSkillEvent(earthquakeChainEarth);
                } else if (cooldownCheck(earthChainEarth)) {
                    addSkillEvent(earthChainEarth);
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t두루마리 : " + scroll + "\t부적 : " + talisman + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t두루마리 : " +scroll + "\t부적 : " + talisman + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (
                skill instanceof MagicCalabash1
                || skill instanceof PhantasmalCloneTalisman
                || skill instanceof ChasingGhostTalisman
        ) {
            if (getStart().after(medicineEndTime2)) {
                talisman = 0;
            }
            if (getStart().before(grandisEndTime)) {
                scroll += 350;
            } else {
                scroll += 200;
            }
            if (scroll > 900) {
                scroll = 900;
            }
        }
        if (
                getStart().after(medicineEndTime2)
                && (
                        skill instanceof FistMethodDoomingLight
                        || skill instanceof FistMethodInhalingVortex
                        || skill instanceof FistMethodButterflyDreamBuff
                        || skill instanceof FistMethodMountainSpiritSummon
                )
        ) {
            scroll = 0;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof MysticEnergyExtremeCloneRampage) {
                extremeEndTime = new Timestamp(getStart().getTime() + 33000);
                addSkillEvent(mysticEnergyExtremeRampageAttack);
            }
            if (skill instanceof MysticEnergyIllusionOfHeavenEarthAndHuman) {
                illusionEndTime = new Timestamp(getStart().getTime() + 33000);
                illusionAttack = 0;
            }
            if (skill instanceof MysticEnergyAdventOfRebelliousPower) {
                adventEndTime = new Timestamp(getStart().getTime() + 30000);
                advent = 0;
            }
            if (skill instanceof MysticEnergyTaeulDivineMedicine) {
                medicineEndTime = new Timestamp(getStart().getTime() + 12000);
                medicineEndTime2 = new Timestamp(getStart().getTime() + 3000);
            }
            if (skill instanceof GrandisGoddessBlessingAnima) {
                grandisEndTime = new Timestamp(getStart().getTime() + 43000);
            }
            if (skill instanceof MysticEnergyTaeulDivineMedicine) {
                talisman = 100;
                scroll = 900;
            }
            if (skill instanceof MysticEnergyAdventOfRebelliousPower) {
                finalTime = new Timestamp(getStart().getTime() + 29000);
            }
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
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (
                    skill instanceof EarthChainEarth
                    || skill instanceof EarthChainFalseTrue
                    || skill instanceof EarthChainEarthReinforce
                    || skill instanceof EarthChainFalseTrueReinforce
                    || skill instanceof MagicCalabash2
                    || skill instanceof EarthquakeChainEarth
                    || skill instanceof EarthquakeChainFalseTrue
                    || skill instanceof EarthquakeChainEarthReinforce
                    || skill instanceof EarthquakeChainFalseTrueReinforce
                    || skill instanceof FistMethodDoomingLight
                    || skill instanceof FlyingFanHuman
                    || skill instanceof FlyingFanHumanReinforce
                    || skill instanceof GoldCudgelHuman
                    || skill instanceof GoldCudgelHumanFinish
                    || skill instanceof GoldCudgelHumanReinforce
                    || skill instanceof GoldCudgelHumanFinishReinforce
            ) {
                if (
                        getStart().before(extremeEndTime)
                        && cooldownCheck(mysticEnergyExtremeRampageAttack)
                ) {
                    addSkillEvent(mysticEnergyExtremeRampageAttack);
                }
                if (
                        getStart().after(extremeEndTime)
                        && cooldownCheck(phantasmalCloneTalismanAttack)
                ) {
                    addSkillEvent(phantasmalCloneTalismanAttack);
                }
            }
            if (skill instanceof FistMethodMountainSpiritSummon) {
                mountainEndTime = new Timestamp(getStart().getTime() + 63000);
            }
            if (
                    cooldownCheck(fistMethodButterflyDreamAttack)
                    && !(skill instanceof FistMethodButterflyDreamAttack)
                    && !(skill instanceof ConflagrationChainHeavenFlame)
                    && !(skill instanceof StrokeOfGods)
            ) {
                addSkillEvent(fistMethodButterflyDreamAttack);
            }
            if (
                    skill instanceof FlyingFanHuman
                    || skill instanceof FlyingFanHumanReinforce
                    || skill instanceof MagicCalabash2
                    || skill instanceof EarthChainEarth
                    || skill instanceof EarthquakeChainEarth
                    || skill instanceof ConflagrationChainHeaven
                    || skill instanceof GoldCudgelHuman
                    || skill instanceof GoldCudgelHumanReinforce
                    || skill instanceof FistMethodButterflyDreamAttack
                    || skill instanceof MysticEnergyCloneSageTaeul
                    || skill instanceof AdventOfGods
            ) {
                flameCnt ++;
                if (skill instanceof FistMethodButterflyDreamAttack) {
                    flameCnt += 4;
                }
                if (
                        flameCnt >= 3
                        && getStart().before(flameEndTime)
                ) {
                    addSkillEvent(conflagrationChainHeavenFlame);
                    flameCnt = 0;
                    flameEndTime = new Timestamp(-1);
                }
            }
            if (skill instanceof ConflagrationChainHeavenFalseTrueReinforce) {
                flameEndTime = new Timestamp(getStart().getTime() + 15000);
                flameCnt = 0;
            }
            int propertyCnt = 0;
            for (Boolean b : property) {
                if (b) {
                    propertyCnt ++;
                }
            }
            if (skill instanceof MysticEnergyIllusionOfHeavenEarthAndHumanAttack) {
                int tmpProperty = beforeProperty;
                if (!property.get(0)) {
                    beforeProperty = 0;
                    property.set(0, true);
                } else if (!property.get(1)) {
                    beforeProperty = 1;
                    property.set(1, true);
                } else if (!property.get(2)) {
                    beforeProperty = 2;
                    property.set(2, true);
                } else {
                    if (beforeProperty == 0) {
                        beforeProperty = 1;
                    } else if (beforeProperty == 1) {
                        beforeProperty = 2;
                    } else if (beforeProperty == 2) {
                        beforeProperty = 0;
                    }
                }
                mysticEnergyIllusionOfHeavenEarthAndHumanAttack = new MysticEnergyIllusionOfHeavenEarthAndHumanAttack();
                skill = mysticEnergyIllusionOfHeavenEarthAndHumanAttack;
                if (tmpProperty != beforeProperty) {
                    ((MysticEnergyIllusionOfHeavenEarthAndHumanAttack) skill).addFinalDamage(1.05);
                }
            }
            int tmpProperty = beforeProperty;
            if (
                    skill instanceof ConflagrationChainHeaven
                    || skill instanceof ConflagrationChainHeavenReinforce
                    || skill instanceof WindWaveHeaven
            ) {
                beforeProperty = 0;
                property.set(0, true);
                if (skill instanceof ConflagrationChainHeaven) {
                    conflagrationChainHeaven = new ConflagrationChainHeaven();
                    skill = conflagrationChainHeaven;
                } else if (skill instanceof ConflagrationChainHeavenReinforce) {
                    conflagrationChainHeavenReinforce = new ConflagrationChainHeavenReinforce();
                    skill = conflagrationChainHeavenReinforce;
                } else if (skill instanceof WindWaveHeaven) {
                    windWaveHeaven = new WindWaveHeaven();
                    skill = windWaveHeaven;
                }
                if (tmpProperty != beforeProperty) {
                    ((AttackSkill) skill).addFinalDamage(1.05);
                    if (skill.getRelatedSkill() != null) {
                        ((AttackSkill) skill.getRelatedSkill()).addFinalDamage(1.05);
                        if (skill.getRelatedSkill().getRelatedSkill() != null) {
                            ((AttackSkill) skill.getRelatedSkill().getRelatedSkill()).addFinalDamage(1.05);
                        }
                    }
                }
            }
            if (
                    skill instanceof EarthChainEarth
                    || skill instanceof EarthChainEarthReinforce
                    || skill instanceof EarthquakeChainEarth
                    || skill instanceof EarthquakeChainEarthReinforce
            ) {
                beforeProperty = 1;
                property.set(1, true);
                if (skill instanceof EarthChainEarth) {
                    earthChainEarth = new EarthChainEarth();
                    skill = earthChainEarth;
                } else if (skill instanceof EarthChainEarthReinforce) {
                    earthChainEarthReinforce = new EarthChainEarthReinforce();
                    skill = earthChainEarthReinforce;
                } else if (skill instanceof EarthquakeChainEarth) {
                    earthquakeChainEarth = new EarthquakeChainEarth();
                    skill = earthquakeChainEarth;
                } else {
                    earthquakeChainEarthReinforce = new EarthquakeChainEarthReinforce();
                    skill = earthquakeChainEarthReinforce;
                }
                if (tmpProperty != beforeProperty) {
                    ((AttackSkill) skill).addFinalDamage(1.05);
                    if (skill.getRelatedSkill() != null) {
                        ((AttackSkill) skill.getRelatedSkill()).addFinalDamage(1.05);
                        if (skill.getRelatedSkill().getRelatedSkill() != null) {
                            ((AttackSkill) skill.getRelatedSkill().getRelatedSkill()).addFinalDamage(1.05);
                        }
                    }
                }
            }
            if (
                    skill instanceof GoldCudgelHuman
                    || skill instanceof GoldCudgelHumanReinforce
                    || skill instanceof FlyingFanHuman
                    || skill instanceof FlyingFanHumanReinforce
            ) {
                beforeProperty = 2;
                property.set(2, true);
                if (skill instanceof GoldCudgelHuman) {
                    goldCudgelHuman = new GoldCudgelHuman();
                    skill = goldCudgelHuman;
                } else if (skill instanceof GoldCudgelHumanReinforce) {
                    goldCudgelHumanReinforce = new GoldCudgelHumanReinforce();
                    skill = goldCudgelHumanReinforce;
                } else if (skill instanceof FlyingFanHuman) {
                    flyingFanHuman = new FlyingFanHuman();
                    skill = flyingFanHuman;
                } else {
                    flyingFanHumanReinforce = new FlyingFanHumanReinforce();
                    skill = flyingFanHumanReinforce;
                }
                if (tmpProperty != beforeProperty) {
                    ((AttackSkill) skill).addFinalDamage(1.05);
                    if (skill.getRelatedSkill() != null) {
                        ((AttackSkill) skill.getRelatedSkill()).addFinalDamage(1.05);
                        if (skill.getRelatedSkill().getRelatedSkill() != null) {
                            ((AttackSkill) skill.getRelatedSkill().getRelatedSkill()).addFinalDamage(1.05);
                        }
                    }
                }
            }
            if (
                    skill instanceof EarthChainEarth
                    || skill instanceof EarthChainFalseTrue
                    || skill instanceof EarthChainEarthReinforce
                    || skill instanceof EarthChainFalseTrueReinforce
                    || skill instanceof MagicCalabash2
                    || skill instanceof EarthquakeChainEarth
                    || skill instanceof EarthquakeChainFalseTrue
                    || skill instanceof EarthquakeChainEarthReinforce
                    || skill instanceof EarthquakeChainFalseTrueReinforce
                    || skill instanceof FistMethodDoomingLight
                    || skill instanceof GoldCudgelHuman
                    || skill instanceof GoldCudgelHumanFinish
                    || skill instanceof GoldCudgelHumanReinforce
                    || skill instanceof GoldCudgelHumanFinishReinforce
                    || skill instanceof MysticEnergyIllusionOfHeavenEarthAndHumanAttack
                    || skill instanceof MysticEnergyExtremeRampageAttack
                    || skill instanceof FistMethodMountainSpiritSummonRoar
                    || skill instanceof FistMethodButterflyDreamAttack
            ) {
                if (skill instanceof MysticEnergyExtremeRampageAttack) {
                    advent += 9;
                } else if (skill instanceof FistMethodButterflyDreamAttack) {
                    advent += 4;
                }
                advent ++;
            }
            if (
                    getStart().before(adventEndTime)
                    && (
                            skill instanceof MysticEnergyExtremeRampageAttack
                            || skill instanceof PhantasmalCloneTalismanAttack
                            || skill instanceof FistMethodButterflyDreamAttack
                    )
            ) {
                advent += ((AttackSkill) skill).getMultiAttackInfo().size();
            }
            if (
                    getStart().before(adventEndTime)
                    && advent >= 12
                    && !(skill instanceof StrokeOfGods)
                    && cooldownCheck(strokeOfGods)
            ) {
                addSkillEvent(strokeOfGods);
                advent = -12;
            }
            if (
                    skill instanceof ConflagrationChainHeaven
                    || skill instanceof ConflagrationChainHeavenFalseTrue
                    || skill instanceof ConflagrationChainHeavenReinforce
                    || skill instanceof ConflagrationChainHeavenFalseTrueReinforce
                    || skill instanceof EarthChainEarth
                    || skill instanceof EarthChainEarthReinforce
                    || skill instanceof EarthquakeChainEarth
                    || skill instanceof EarthquakeChainFalseTrue
                    || skill instanceof EarthquakeChainEarthReinforce
                    || skill instanceof EarthquakeChainFalseTrueReinforce
                    || skill instanceof FlyingFanHuman
                    || skill instanceof FlyingFanHumanReinforce
                    || skill instanceof GoldCudgelHuman
                    || skill instanceof GoldCudgelHumanFinish
                    || skill instanceof GoldCudgelHumanReinforce
                    || skill instanceof GoldCudgelHumanFinishReinforce
                    || skill instanceof MysticEnergyIllusionOfHeavenEarthAndHumanAttack
            ) {
                if (getStart().before(grandisEndTime)) {
                    if (propertyCnt == 0) {
                        talisman += 17;
                    } else if (propertyCnt == 1) {
                        talisman += 26;
                    } else if (propertyCnt == 2) {
                        talisman += 35;
                    }
                    scroll += 26;
                } else {
                    if (propertyCnt == 0) {
                        talisman += 10;
                    } else if (propertyCnt == 1) {
                        talisman += 15;
                    } else if (propertyCnt == 2) {
                        talisman += 20;
                    }
                    scroll += 15;
                }
                if (talisman > 100) {
                    talisman = 100;
                }
                if (scroll > 900) {
                    scroll = 900;
                }
            }
            if (
                    cooldownCheck(mysticEnergyIllusionOfHeavenEarthAndHumanAttack)
                    && (
                            skill instanceof ConflagrationChainHeaven
                            || skill instanceof ConflagrationChainHeavenReinforce
                            || skill instanceof EarthChainEarth
                            || skill instanceof EarthChainEarthReinforce
                            || skill instanceof EarthquakeChainEarth
                            || skill instanceof EarthquakeChainEarthReinforce
                            || skill instanceof FlyingFanHuman
                            || skill instanceof FlyingFanHumanReinforce
                            || skill instanceof GoldCudgelHuman
                            || skill instanceof GoldCudgelHumanReinforce
                            || skill instanceof MagicCalabash2
                            || skill instanceof FistMethodDoomingLight
                            || skill instanceof MysticEnergyApotheosisFinish
                            || skill instanceof MysticEnergyApotheosisKeydown1
                            || skill instanceof MysticEnergyApotheosisKeydown2
                    )
            ) {
                if (getStart().before(illusionEndTime)) {
                    addSkillEvent(mysticEnergyIllusionOfHeavenEarthAndHumanAttack);
                    mysticEnergyIllusionOfHeavenEarthAndHumanAttack.setActivateTime(new Timestamp(-1));
                    addSkillEvent(mysticEnergyIllusionOfHeavenEarthAndHumanAttack);
                    mysticEnergyIllusionOfHeavenEarthAndHumanAttack.setActivateTime(new Timestamp(getStart().getTime() + 1880));
                } else {
                    mysticEnergyIllusionOfHeavenEarthAndHumanAttack.setCooldown(5.0);
                    addSkillEvent(mysticEnergyIllusionOfHeavenEarthAndHumanAttack);
                }
            }
            if (propertyCnt == 3) {
                property.set(0, false);
                property.set(1, false);
                property.set(2, false);
                linkCnt ++;
                if (getStart().before(illusionEndTime)) {   // 지진쇄 or 금고봉
                    isCooldownReset = true;
                }
                if (
                        linkCnt >= 3
                                && cooldownCheck(allCreationOfHeavenAndEarth)
                ) {
                    applyCooldown(allCreationOfHeavenAndEarth);
                    isReinforce = true;
                    linkCnt = 0;
                    conflagrationChainHeavenReinforce.setActivateTime(new Timestamp(conflagrationChainHeaven.getActivateTime().getTime()));
                    earthChainEarthReinforce.setActivateTime(new Timestamp(earthChainEarth.getActivateTime().getTime()));
                    earthquakeChainEarthReinforce.setActivateTime(new Timestamp(earthquakeChainEarth.getActivateTime().getTime()));
                    flyingFanHumanReinforce.setActivateTime(new Timestamp(flyingFanHuman.getActivateTime().getTime()));
                    goldCudgelHumanReinforce.setActivateTime(new Timestamp(goldCudgelHuman.getActivateTime().getTime()));
                }
                if (
                        getStart().before(mountainEndTime)
                                //&& cooldownCheck(fistMethodMountainSpiritSummonRoar)
                ) {
                    for (SkillEvent skillEvent : this.getSkillEventList()) {
                        if (
                                skillEvent.getStart().after(getStart())
                                        && skillEvent.getSkill() instanceof FistMethodMountainSpiritSummon
                                        && (skillEvent.getStart().getTime() - getStart().getTime()) <= 3000
                        ) {
                            this.getSkillEventList().add(new SkillEvent(fistMethodMountainSpiritSummonRoar, new Timestamp(skillEvent.getStart().getTime()), new Timestamp(skillEvent.getEnd().getTime())));
                            this.getSkillEventList().add(new SkillEvent(fistMethodMountainSpiritSummonRoar, new Timestamp(skillEvent.getStart().getTime()), new Timestamp(skillEvent.getEnd().getTime())));
                            this.getSkillEventList().add(new SkillEvent(fistMethodMountainSpiritSummonRoar, new Timestamp(skillEvent.getStart().getTime()), new Timestamp(skillEvent.getEnd().getTime())));
                            this.getSkillEventList().add(new SkillEvent(fistMethodMountainSpiritSummonRoar, new Timestamp(skillEvent.getStart().getTime()), new Timestamp(skillEvent.getEnd().getTime())));
                            this.getSkillEventList().add(new SkillEvent(fistMethodMountainSpiritSummonRoar, new Timestamp(skillEvent.getStart().getTime()), new Timestamp(skillEvent.getEnd().getTime())));
                            this.getSkillEventList().add(new SkillEvent(fistMethodMountainSpiritSummonRoar, new Timestamp(skillEvent.getStart().getTime()), new Timestamp(skillEvent.getEnd().getTime())));
                            this.getSkillEventList().add(new SkillEvent(fistMethodMountainSpiritSummonRoar, new Timestamp(skillEvent.getStart().getTime()), new Timestamp(skillEvent.getEnd().getTime())));
                            this.getSkillEventList().remove(skillEvent);
                            break;
                        }
                    }
                }
            }
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
                        if (skill instanceof ChasingGhostTalisman) {
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                        if (
                                skill instanceof MysticEnergyApotheosisKeydown1
                                || skill instanceof MysticEnergyApotheosisKeydown2
                        ) {
                            Timestamp temp = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (
                                    getStart().before(extremeEndTime)
                                    && cooldownCheck(mysticEnergyExtremeRampageAttack)
                            ) {
                                addSkillEvent(mysticEnergyExtremeRampageAttack);
                            }
                            if (
                                    getStart().after(extremeEndTime)
                                    && cooldownCheck(phantasmalCloneTalismanAttack)
                            ) {
                                addSkillEvent(phantasmalCloneTalismanAttack);
                            }
                            getStart().setTime(temp.getTime());
                        }
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
        if (
                getStart().before(medicineEndTime)
                && cooldownCheck(mysticEnergyTaeulDivineMedicineTic)
        ) {
            applyCooldown(mysticEnergyTaeulDivineMedicineTic);
            if (getStart().before(grandisEndTime)) {
                talisman += 61;
                scroll += 612;
            } else {
                talisman += 35;
                scroll += 350;
            }
            if (talisman > 100) {
                talisman = 100;
            }
            if (scroll > 900) {
                scroll = 900;
            }
        }
        applyCooldown(skill);
        if (getStart().before(illusionEndTime) && isCooldownReset) {
            if (!cooldownCheck(goldCudgelHuman)) {
                goldCudgelHuman.setActivateTime(new Timestamp(-1));
                goldCudgelHumanReinforce.setActivateTime(new Timestamp(-1));
                isCooldownReset = false;
            } else if (!cooldownCheck(earthChainEarth)) {
                earthquakeChainEarth.setActivateTime(new Timestamp(-1));
                earthquakeChainEarthReinforce.setActivateTime(new Timestamp(-1));
                isCooldownReset = false;
            }
        }
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill instanceof AdventOfGods) {
            addSkillEvent(new AdventOfGodsBuff());
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
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
            for (SkillEvent skillEvent : useBuffSkillList) {
                for (BuffSkill bs : buffSkillList) {
                    if (
                            bs.getClass().getName().equals(skillEvent.getSkill().getClass().getName())
                                    && start.equals(skillEvent.getStart())
                    ) {
                        if (bs.getStartTimeList().size() == 0) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        } else if (skillEvent.getStart().after(bs.getStartTimeList().get(bs.getStartTimeList().size() - 1))) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        }
                    }
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
            boolean isAdventOfGods = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof AdventOfGodsBuff) {
                    isAdventOfGods = true;
                    break;
                }
            }
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
            }
            for (SkillEvent se : useAttackSkillList) {
                if (
                        isAdventOfGods
                        && (
                                se.getSkill() instanceof ConflagrationChainHeaven
                                || se.getSkill() instanceof ConflagrationChainHeavenFalseTrue
                                || se.getSkill() instanceof ConflagrationChainHeavenFalseTrueReinforce
                                || se.getSkill() instanceof ConflagrationChainHeavenFlame
                                || se.getSkill() instanceof ConflagrationChainHeavenReinforce
                                || se.getSkill() instanceof EarthChainEarth
                                || se.getSkill() instanceof EarthChainEarthReinforce
                                || se.getSkill() instanceof EarthChainFalseTrue
                                || se.getSkill() instanceof EarthChainFalseTrueReinforce
                                || se.getSkill() instanceof EarthquakeChainEarth
                                || se.getSkill() instanceof EarthquakeChainEarthAloofBlueMoon
                                || se.getSkill() instanceof EarthquakeChainEarthReinforce
                                || se.getSkill() instanceof EarthquakeChainFalseTrue
                                || se.getSkill() instanceof EarthquakeChainFalseTrueReinforce
                                || se.getSkill() instanceof FlyingFanHuman
                                || se.getSkill() instanceof FlyingFanHumanReinforce
                                || se.getSkill() instanceof GoldCudgelHuman
                                || se.getSkill() instanceof GoldCudgelHumanEnergyOfGoblin
                                || se.getSkill() instanceof GoldCudgelHumanFinish
                                || se.getSkill() instanceof GoldCudgelHumanFinishReinforce
                                || se.getSkill() instanceof GoldCudgelHumanReinforce
                        )
                ) {
                    buffSkill.addBuffDamage(20L);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isAdventOfGods
                                && (
                                se.getSkill() instanceof ConflagrationChainHeaven
                                        || se.getSkill() instanceof ConflagrationChainHeavenFalseTrue
                                        || se.getSkill() instanceof ConflagrationChainHeavenFalseTrueReinforce
                                        || se.getSkill() instanceof ConflagrationChainHeavenFlame
                                        || se.getSkill() instanceof ConflagrationChainHeavenReinforce
                                        || se.getSkill() instanceof EarthChainEarth
                                        || se.getSkill() instanceof EarthChainEarthReinforce
                                        || se.getSkill() instanceof EarthChainFalseTrue
                                        || se.getSkill() instanceof EarthChainFalseTrueReinforce
                                        || se.getSkill() instanceof EarthquakeChainEarth
                                        || se.getSkill() instanceof EarthquakeChainEarthAloofBlueMoon
                                        || se.getSkill() instanceof EarthquakeChainEarthReinforce
                                        || se.getSkill() instanceof EarthquakeChainFalseTrue
                                        || se.getSkill() instanceof EarthquakeChainFalseTrueReinforce
                                        || se.getSkill() instanceof FlyingFanHuman
                                        || se.getSkill() instanceof FlyingFanHumanReinforce
                                        || se.getSkill() instanceof GoldCudgelHuman
                                        || se.getSkill() instanceof GoldCudgelHumanEnergyOfGoblin
                                        || se.getSkill() instanceof GoldCudgelHumanFinish
                                        || se.getSkill() instanceof GoldCudgelHumanFinishReinforce
                                        || se.getSkill() instanceof GoldCudgelHumanReinforce
                        )
                ) {
                    buffSkill.addBuffDamage(-20L);
                }
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

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (skill instanceof MysticEnergyApotheosisFinish) {
                Timestamp tmp = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (
                        getStart().before(extremeEndTime)
                        && cooldownCheck(mysticEnergyExtremeRampageAttack)
                ) {
                    addSkillEvent(mysticEnergyExtremeRampageAttack);
                }
                if (
                        getStart().after(extremeEndTime)
                        && cooldownCheck(phantasmalCloneTalismanAttack)
                ) {
                    addSkillEvent(phantasmalCloneTalismanAttack);
                }
                getStart().setTime(tmp.getTime());
            }
        }
    }

    @Override
    public Double applyCooldownReduction(Skill skill) {
        Double cooldown = 0.0;
        Double cooldownReduction = 0.0;
        if (skill.getCooldown() <= 1) {
            return skill.getCooldown();
        }
        cooldown = skill.getCooldown() * (1 - getJob().getCooldownReductionP() * 0.01);
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
                cooldown -= cooldownReduction * 0.05;
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
}
