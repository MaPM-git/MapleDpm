package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.aran.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.aran.AdrenalineBoost;
import org.mapledpmlab.type.skill.buffskill.aran.AdrenalineMaximum;
import org.mapledpmlab.type.skill.buffskill.aran.BlizzardTempest;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AranDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AMGoldenFlash());
            add(new AMIceStorm());
            add(new AMIceWave());
            add(new FinalAttackAran());
            add(new AuraWeaponDot());
            add(new Beyonder1());
            add(new Beyonder2());
            add(new Beyonder3());
            add(new FinalBeyonderWhiteTiger());
            add(new BeyonderMaha());
            add(new BoostEndAdrenalineSurge());
            add(new BoostEndHuntersTargetingBeforeDelay());
            add(new BoostEndHuntersTargeting());
            add(new BrandishMaha());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EndGameWave());
            add(new EndGameSlash());
            add(new FrozenGround());
            add(new GlacialFrozen());
            add(new HyperBoostEndAdrenalineSurge());
            add(new HyperBoostEndLastStand1());
            add(new HyperBoostEndLastStand2());
            add(new HyperBoostEndLastStand3());
            add(new IceBlock());
            add(new IceBlockAfterFirst());
            add(new SmashSwing1());
            add(new SmashSwing2());
            add(new SmashSwing3());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AdrenalineBoost());
            add(new AdrenalineMaximum());
            add(new AuraWeaponBuff());
            add(new BlizzardTempest());
            add(new BodyOfSteel(0L));
            add(new FreudBlessing1());
            add(new FreudBlessing2());
            add(new FreudBlessing3());
            add(new FreudBlessing4());
            add(new FreudBlessing5());
            add(new FreudBlessing6());
            add(new HeroesOath());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int freudStack = 0;

    AdrenalineBoost adrenalineBoost = new AdrenalineBoost();
    AdrenalineMaximum adrenalineMaximum = new AdrenalineMaximum();
    AMGoldenFlash AMGoldenFlash = new AMGoldenFlash();
    AMIceStorm AMIceStorm = new AMIceStorm();
    AMIceWave AMIceWave = new AMIceWave();
    AuraWeaponBuff auraWeapon = new AuraWeaponBuff();
    Beyonder1 beyonder = new Beyonder1();
    BeyonderMaha beyonderMaha = new BeyonderMaha();
    BlizzardTempest blizzardTempest = new BlizzardTempest();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    BoostEndAdrenalineSurge boostEndAdrenalineSurge = new BoostEndAdrenalineSurge();
    BoostEndHuntersTargetingBeforeDelay boostEndHuntersTargeting = new BoostEndHuntersTargetingBeforeDelay();
    BrandishMaha brandishMaha = new BrandishMaha();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    EndGameWave endGame = new EndGameWave();
    FreudBlessing1 freudBlessing1 = new FreudBlessing1();
    FreudBlessing2 freudBlessing2 = new FreudBlessing2();
    FreudBlessing3 freudBlessing3 = new FreudBlessing3();
    FreudBlessing4 freudBlessing4 = new FreudBlessing4();
    FreudBlessing5 freudBlessing5 = new FreudBlessing5();
    FreudBlessing6 freudBlessing6 = new FreudBlessing6();
    FrozenGround frozenGround = new FrozenGround();
    GlacialFrozen glacialFrozen = new GlacialFrozen();
    HeroesOath heroesOath = new HeroesOath();
    HyperBoostEndAdrenalineSurge hyperBoostEndAdrenalineSurge = new HyperBoostEndAdrenalineSurge();
    HyperBoostEndLastStand1 hyperBoostEndLastStand = new HyperBoostEndLastStand1();
    IceBlock iceBlock = new IceBlock();
    IceBlockAfterFirst iceBlock2 = new IceBlockAfterFirst();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SmashSwing1 smashSwing = new SmashSwing1();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    Timestamp adrenalineEndTime = new Timestamp(-1);
    Timestamp adrenalineMaximumEndTime = new Timestamp(-1);
    Timestamp blizzardTempestEndTime = new Timestamp(-1);

    public AranDealCycle(Job job) {
        super(job, new FinalAttackAran());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ((AttackSkill) adrenalineBoost.getRelatedSkill()).setDotDuration(((AttackSkill) adrenalineBoost.getRelatedSkill()).getDotDuration() + 3000);

        ringSwitching.setCooldown(90.0);
        auraWeapon.setCooldown(180.0);
        mapleWorldGoddessBlessing.setCooldown(120.0);

        auraWeapon.setDelay(70L);
        mapleWorldGoddessBlessing.setDelay(70L);
        bodyOfSteel.setDelay(70L);
        blizzardTempest.setDelay(570L);

        getSkillSequence1().add(auraWeapon);
        getSkillSequence1().add(heroesOath);                // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(bodyOfSteel);
        getSkillSequence1().add(blizzardTempest);
        getSkillSequence1().add(soulContract);              // 30
        getSkillSequence1().add(restraintRing);             // 30
        // + 아드(30ms)

        getSkillSequence2().add(blizzardTempest);
        getSkillSequence2().add(soulContract);              // 30
        getSkillSequence2().add(weaponJumpRing);            // 30
        getSkillSequence2().add(adrenalineBoost);           // 30

        getStart().setTime(-25000);
        freudBlessing4.setActivateTime(new Timestamp(-30000));
        addSkillEvent(freudBlessing4);
        getStart().setTime(0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(frozenGround)) {
                addSkillEvent(frozenGround);
            } else if (
                    cooldownCheck(freudBlessing1)
                    && freudStack == 6
                    && getStart().before(new Timestamp(7 * 60 * 1000))
            ) {
                addSkillEvent(freudBlessing1);
            } else if (
                    cooldownCheck(freudBlessing2)
                    && freudStack == 1
            ) {
                addSkillEvent(freudBlessing2);
            } else if (
                    cooldownCheck(freudBlessing3)
                    && freudStack == 2
            ) {
                addSkillEvent(freudBlessing3);
            } else if (
                    cooldownCheck(freudBlessing4)
                    && freudStack == 3
            ) {
                addSkillEvent(freudBlessing4);
            } else if (
                    cooldownCheck(freudBlessing6)
                    && freudStack == 5
                    && getStart().after(new Timestamp(freudBlessing6.getActivateTime().getTime() + 5000))
            ) {
                addSkillEvent(freudBlessing6);
            } else if (
                    getStart().before(new Timestamp(600 * 1000))
                    && getStart().after(new Timestamp(restraintRing.getActivateTime().getTime() - 1000))
            ) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                if (cooldownCheck(endGame)) {
                    while (!cooldownCheck(freudBlessing5)) {
                        if (cooldownCheck(brandishMaha)) {
                            addSkillEvent(brandishMaha);
                        } else {
                            addSkillEvent(beyonder);
                        }
                    }
                    addSkillEvent(freudBlessing5);
                }
                addDealCycle(getSkillSequence1());
                if (!cooldownCheck(endGame)) {
                    addSkillEvent(adrenalineBoost);
                    while (!cooldownCheck(brandishMaha)) {
                        addSkillEvent(beyonder);
                    }
                    addSkillEvent(brandishMaha);
                    addSkillEvent(boostEndHuntersTargeting);
                    addSkillEvent(new Beyonder1());
                    addSkillEvent(adrenalineMaximum);
                    addSkillEvent(hyperBoostEndAdrenalineSurge);
                    addSkillEvent(hyperBoostEndLastStand);
                } else {
                    addSkillEvent(endGame);
                    addSkillEvent(boostEndHuntersTargeting);
                    addSkillEvent(hyperBoostEndAdrenalineSurge);
                    addSkillEvent(hyperBoostEndLastStand);
                }
            } else if (
                    getStart().before(new Timestamp(660 * 1000))
                            && cooldownCheck(blizzardTempest)
                            && cooldownCheck(weaponJumpRing)
            ) {
                addDealCycle(getSkillSequence2());
                addSkillEvent(boostEndHuntersTargeting);
                addSkillEvent(boostEndAdrenalineSurge);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (cooldownCheck(brandishMaha)) {
                addSkillEvent(brandishMaha);
            } else {
                addSkillEvent(beyonder);
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
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof AMIceStorm) {
            applyCooldown(AMIceStorm);
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof FreudBlessing1) {
                freudStack = 1;
            } else if (skill instanceof FreudBlessing2) {
                freudStack = 2;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing1
                            && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing3) {
                freudStack = 3;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing2
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing4) {
                freudStack = 4;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing3
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing5) {
                freudStack = 5;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing4
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing6) {
                freudStack = 6;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing5
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof AdrenalineBoost) {
                adrenalineEndTime = new Timestamp(getStart().getTime() + 23000);
            } else if (skill instanceof AdrenalineMaximum) {
                adrenalineMaximumEndTime = new Timestamp(getStart().getTime() + 10000);
            } else if (skill instanceof BlizzardTempest) {
                blizzardTempestEndTime = new Timestamp(getStart().getTime() + 30000);
            } else if (
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
                if (skill instanceof BodyOfSteel) {
                    for (long i = 0; i < 21000; i += 1000) {
                        getSkillEventList().add(new SkillEvent(new BodyOfSteel(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 1000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
                    }
                }
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (
                    !(skill instanceof AMGoldenFlash)
                    && !(skill instanceof IceBlockAfterFirst)
                    && !(skill instanceof IceBlock)
                    && !(skill instanceof BeyonderMaha)
                    && !(skill instanceof AMIceStorm)
            ) {
                if (
                        cooldownCheck(AMGoldenFlash)
                        && getStart().before(adrenalineMaximumEndTime)
                ) {
                    addSkillEvent(AMGoldenFlash);
                }
                if (
                        cooldownCheck(AMIceStorm)
                        && (
                                getStart().before(adrenalineEndTime)
                                || getStart().before(adrenalineMaximumEndTime)
                        )
                ) {
                    addSkillEvent(AMIceStorm);
                }
            }
            if (
                    cooldownCheck(iceBlock2)
                    && getStart().before(blizzardTempestEndTime)
                    && !(skill instanceof IceBlockAfterFirst)
                    && !(skill instanceof IceBlock)
                    && !(skill instanceof BeyonderMaha)
                    && !(skill instanceof AMGoldenFlash)
                    && ((AttackSkill) skill).isApplyFinalAttack()
                    && ((AttackSkill) skill).getMultiAttackInfo().size() == 0
            ) {
                addSkillEvent(iceBlock2);
            }
            if (skill instanceof EndGameWave) {
                AdrenalineMaximum tmp1 = new AdrenalineMaximum();
                AdrenalineBoost tmp2 = new AdrenalineBoost();
                tmp1.setDuration(30L);
                tmp2.setDuration(30L);
                ((AttackSkill) tmp2.getRelatedSkill()).setDotDuration(30000L);
                addSkillEvent(tmp1);
                addSkillEvent(tmp2);
                adrenalineMaximum.setActivateTime(new Timestamp(tmp1.getActivateTime().getTime()));
                adrenalineEndTime = new Timestamp(getStart().getTime() + 30000);
                adrenalineMaximumEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (
                    cooldownCheck(beyonderMaha)
                    && !(skill instanceof BeyonderMaha)
                    && !(skill instanceof IceBlockAfterFirst)
                    && !(skill instanceof IceBlock)
                    && !(skill instanceof AMGoldenFlash)
            ) {
                addSkillEvent(beyonderMaha);
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
        if (skill instanceof BrandishMaha) {
            if (getStart().before(adrenalineEndTime)) {
                skill.setCooldown(20.0);
            } else {
                skill.setCooldown(10.0);
            }
        }
        applyCooldown(skill);
        if (skill instanceof FreudBlessing1) {
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing1.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing2) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing3) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing4) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing5) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing6) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
        }
        if (skill instanceof IceBlock) {
            iceBlock2.setActivateTime(new Timestamp(iceBlock.getActivateTime().getTime()));
        }
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

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            Timestamp tmp = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    cooldownCheck(iceBlock2)
                    && getStart().before(blizzardTempestEndTime)
                    && ((AttackSkill) skill).isApplyFinalAttack()
            ) {
                addSkillEvent(iceBlock2);
            }
            if (
                    cooldownCheck(beyonderMaha)
                    && !(skill instanceof BeyonderMaha)
            ) {
                addSkillEvent(beyonderMaha);
            }
            if (
                    cooldownCheck(AMGoldenFlash)
                    && getStart().before(adrenalineMaximumEndTime)
            ) {
                addSkillEvent(AMGoldenFlash);
            }
            if (
                    cooldownCheck(AMIceStorm)
                    && (
                            getStart().before(adrenalineEndTime)
                            || getStart().before(adrenalineMaximumEndTime)
                    )
            ) {
                addSkillEvent(AMIceStorm);
            }
            getStart().setTime(tmp.getTime());
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }
}
