package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.illium.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.illium.*;
import org.mapledpmlab.type.skill.buffskill.illium.SoulOfCrystal;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class IlliumDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CraftEnchantJavelin());
            add(new CraftEnchantJavelinFragment());
            add(new CraftJavelin());
            add(new CraftJavelinFragment());
            //add(new CraftLonginus());
            add(new CraftOrb());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CrystalGate());
            add(new CrystalIgnition());
            add(new CrystalSkillDeus());
            add(new CrystalSkillDeusSatellite1());
            add(new CrystalSkillDeusSatellite2());
            add(new CrystalSkillDeusSatellite3());
            add(new CrystalSkillMortalSwing());
            add(new CurseMark());
            add(new GloryWingEnchantJavelin());
            add(new GloryWingEnchantJavelinMagicMissile());
            add(new GloryWingJavelin());
            add(new GloryWingJavelinMagicMissile());
            add(new GloryWingMortalWingBeat());
            add(new Gramholder());
            add(new Lio1());
            add(new Lio2());
            add(new Lio3());
            add(new Machina());
            add(new MagicCircuitFullDrive());
            add(new ReactionDestruction());
            add(new ReactionDomination());
            add(new ReactionSpectrum());
            add(new org.mapledpmlab.type.skill.attackskill.illium.SoulOfCrystal());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new UnlimitedCrystal1());
            add(new UnlimitedCrystal2());
            add(new UnlimitedCrystal3());
            add(new UnlimitedCrystalRelease());
            add(new UnlimitedCrystalResonance());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new CrystalIgnitionAfterDelay());
            add(new CrystalIgnitionBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CrystalGateBuff());
            add(new CrystalSkillGloryWing());
            add(new FastCharge());
            add(new GrandisGoddessBlessingLef(520L));
            add(new MagicCircuitFullDriveBuff());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SoulOfCrystal());
            add(new SoulOfCrystalBuff());
            add(new ThiefCunning());
            add(new UnlimitedCrystalBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WrathOfGod());
        }
    };

    CraftEnchantJavelin craftEnchantJavelin = new CraftEnchantJavelin();
    CrystalGate crystalGate = new CrystalGate();
    CrystalSkillDeusSatellite1 crystalSkillDeusSatellite1 = new CrystalSkillDeusSatellite1();
    CrystalSkillDeusSatellite2 crystalSkillDeusSatellite2 = new CrystalSkillDeusSatellite2();
    CrystalSkillDeusSatellite3 crystalSkillDeusSatellite3 = new CrystalSkillDeusSatellite3();
    CurseMark curseMark = new CurseMark();
    GloryWingEnchantJavelin gloryWingEnchantJavelin = new GloryWingEnchantJavelin();
    Lio1 lio1 = new Lio1();
    Lio2 lio2 = new Lio2();
    Lio3 lio3 = new Lio3();
    MagicCircuitFullDrive magicCircuitFullDrive = new MagicCircuitFullDrive();
    ReactionDestruction reactionDestruction = new ReactionDestruction();
    ReactionDomination reactionDomination = new ReactionDomination();
    ReactionSpectrum reactionSpectrum = new ReactionSpectrum();
    SoulOfCrystal soulOfCrystal = new SoulOfCrystal();
    UnlimitedCrystalRelease unlimitedCrystalRelease = new UnlimitedCrystalRelease();
    UnlimitedCrystalResonance unlimitedCrystalResonance = new UnlimitedCrystalResonance();

    Timestamp crystalGateEndTime = new Timestamp(-1);
    Timestamp crystalSkillDeusEndTime = new Timestamp(-1);
    Timestamp crystalSkillGloryWingEndTime = new Timestamp(-1);
    Timestamp magicCircuitFullDriveEndTime = new Timestamp(-1);
    Timestamp soulOfCrystalEndTime = new Timestamp(-1);
    Timestamp unlimitedCrystalEndTime = new Timestamp(-1);

    int crystalCharge = 150;
    int deusAttack = 0;
    int lioAttack = 0;
    int crystalFragment = 0;
    int gloryCrystalFragment = 0;
    int resonance = 0;

    boolean fastChargeReuse = false;

    public IlliumDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        CraftJavelin craftJavelin = new CraftJavelin();
        CraftLonginus craftLonginus = new CraftLonginus();
        CraftOrb craftOrb = new CraftOrb();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrystalIgnitionBeforeDelay crystalIgnitionBeforeDelay = new CrystalIgnitionBeforeDelay();
        CrystalSkillDeus crystalSkillDeus = new CrystalSkillDeus();
        CrystalSkillGloryWing crystalSkillGloryWing = new CrystalSkillGloryWing();
        CrystalSkillMortalSwing crystalSkillMortalSwing = new CrystalSkillMortalSwing();
        FastCharge fastCharge = new FastCharge();
        GloryWingJavelin gloryWingJavelin = new GloryWingJavelin();
        GloryWingMortalWingBeat gloryWingMortalWingBeat = new GloryWingMortalWingBeat();
        Gramholder gramholder = new Gramholder();
        GrandisGoddessBlessingLef grandisGoddessBlessingLef = new GrandisGoddessBlessingLef(520L);
        Machina machina = new Machina();
        MagicCircuitFullDriveBuff magicCircuitFullDriveBuff = new MagicCircuitFullDriveBuff();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SoulOfCrystal soulOfCrystal = new SoulOfCrystal();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UnlimitedCrystal1 unlimitedCrystal1 = new UnlimitedCrystal1();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WrathOfGod wrathOfGod = new WrathOfGod();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(90.0);

        dealCycle1.add(lio1);
        dealCycle1.add(crystalGate);
        dealCycle1.add(soulOfCrystal);
        dealCycle1.add(wrathOfGod);
        dealCycle1.add(magicCircuitFullDriveBuff);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(grandisGoddessBlessingLef);
        dealCycle1.add(gramholder);
        dealCycle1.add(crystalSkillDeus);
        dealCycle1.add(crystalSkillMortalSwing);
        dealCycle1.add(crystalSkillGloryWing);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(unlimitedCrystal1);
        dealCycle1.add(gloryWingMortalWingBeat);
        dealCycle1.add(crystalIgnitionBeforeDelay);

        dealCycle2.add(lio1);
        dealCycle2.add(crystalGate);
        dealCycle2.add(soulOfCrystal);
        dealCycle2.add(wrathOfGod);
        dealCycle2.add(magicCircuitFullDriveBuff);
        dealCycle2.add(grandisGoddessBlessingLef);
        dealCycle2.add(gramholder);
        dealCycle2.add(crystalSkillDeus);
        dealCycle2.add(crystalSkillMortalSwing);
        dealCycle2.add(crystalSkillGloryWing);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(gloryWingMortalWingBeat);
        dealCycle2.add(crystalIgnitionBeforeDelay);

        dealCycle3.add(fastCharge);
        dealCycle3.add(ringSwitching);
        dealCycle3.add(soulOfCrystal);
        dealCycle3.add(crystalSkillDeus);
        dealCycle3.add(crystalSkillMortalSwing);
        dealCycle3.add(crystalSkillGloryWing);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(gloryWingMortalWingBeat);

        addSkillEvent(lio1);
        addSkillEvent(machina);

        soulContract.setApplyReuse(true);

        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && crystalCharge >= 150
            ) {
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && crystalCharge >= 150
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(fastCharge)
                    && getStart().after(crystalSkillGloryWingEndTime)
            ) {
                while (!cooldownCheck(crystalSkillDeus)) {
                    if (gloryCrystalFragment != 0) {
                        gloryCrystalFragment = 0;
                    }
                    if (crystalFragment == 30) {
                        addSkillEvent(craftEnchantJavelin);
                        addSkillEvent(craftOrb);
                        crystalFragment = 0;
                        crystalCharge += 25;
                    } else {
                        addSkillEvent(craftJavelin);
                        addSkillEvent(craftOrb);
                        crystalFragment++;
                    }
                }
                addDealCycle(dealCycle3);
            } else if (
                    getStart().after(crystalSkillGloryWingEndTime)
                    && crystalCharge >= 150
                    && cooldownCheck(soulOfCrystal)
                    && cooldownCheck(crystalSkillDeus)
                    && !getStart().after(new Timestamp(710 * 1000))
                    && !cooldownCheck(wrathOfGod)
            ) {
                addSkillEvent(soulOfCrystal);
                addSkillEvent(crystalSkillDeus);
                addSkillEvent(crystalSkillMortalSwing);
                addSkillEvent(crystalSkillGloryWing);
                if (cooldownCheck(soulContract)) {
                    addSkillEvent(soulContract);
                }
                addSkillEvent(gloryWingMortalWingBeat);
            } /* else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            }*/ /*else if (
                    cooldownCheck(craftLonginus)
            ) {
                addSkillEvent(craftLonginus);
            }*/ else if (
                    getStart().before(crystalSkillGloryWingEndTime)
            ) {
                if (crystalFragment != 0) {
                    crystalFragment = 0;
                }
                if (gloryCrystalFragment == 10) {
                    addSkillEvent(gloryWingEnchantJavelin);
                    gloryCrystalFragment = 0;
                } else {
                    addSkillEvent(gloryWingJavelin);
                    gloryCrystalFragment++;
                }
            } else {
                if (gloryCrystalFragment != 0) {
                    gloryCrystalFragment = 0;
                }
                if (crystalFragment == 30) {
                    addSkillEvent(craftEnchantJavelin);
                    addSkillEvent(craftOrb);
                    crystalFragment = 0;
                    crystalCharge += 25;
                } else {
                    addSkillEvent(craftJavelin);
                    addSkillEvent(craftOrb);
                    crystalFragment++;
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof CrystalGate) {
                crystalGateEndTime = new Timestamp(getStart().getTime() + 190000);
            }
            if (skill instanceof MagicCircuitFullDriveBuff) {
                magicCircuitFullDriveEndTime = new Timestamp(getStart().getTime() + 60000);
            }
            if (skill instanceof UnlimitedCrystalBuff) {
                unlimitedCrystalEndTime = new Timestamp(getStart().getTime() + 20000);
            }
            if (skill instanceof FastCharge) {
                crystalCharge = 150;
                soulOfCrystalEndTime = new Timestamp(-1);
            }
            if (skill instanceof CrystalSkillGloryWing) {
                crystalCharge = 0;
                crystalSkillGloryWingEndTime = new Timestamp(getStart().getTime() + 20000);
                if (soulOfCrystalEndTime.after(getStart())) {
                    SoulOfCrystalBuff soulOfCrystalBuff = new SoulOfCrystalBuff();
                    getSkillEventList().add(new SkillEvent(soulOfCrystalBuff, new Timestamp(getStart().getTime()), new Timestamp(soulOfCrystalEndTime.getTime())));
                }
            }
            List<SkillEvent> remove = new ArrayList<>();
            for (SkillEvent skillEvent : this.getSkillEventList()) {
                if (
                        skill instanceof CrystalSkillGloryWing
                        && skillEvent.getStart().after(getStart())
                        && skillEvent.getEnd().before(crystalSkillGloryWingEndTime)
                        && skillEvent.getSkill() instanceof Machina
                ) {
                    remove.add(skillEvent);
                }
            }
            getSkillEventList().removeAll(remove);
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
            if (getStart().before(crystalGateEndTime)) {
                addSkillEvent(crystalGate);
            }
            if (
                    skill instanceof CrystalIgnitionAfterDelay
                    || skill instanceof CrystalIgnitionBeforeDelay
            ) {
                if (cooldownCheck(reactionSpectrum)) {
                    addSkillEvent(reactionSpectrum);
                }
            }
            if (
                    getStart().before(magicCircuitFullDriveEndTime)
                    && cooldownCheck(magicCircuitFullDrive)
                    && !(skill instanceof MagicCircuitFullDrive)
                    && !(skill instanceof CurseMark)
            ) {
                addSkillEvent(magicCircuitFullDrive);
            }
            if (skill instanceof UnlimitedCrystal1) {
                crystalSkillGloryWingEndTime = new Timestamp(crystalSkillGloryWingEndTime.getTime() + 10000);
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof CrystalSkillGloryWing
                            && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getSkillEventList().get(i).getEnd().getTime() + 10000);
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            }
            if (
                    getStart().before(unlimitedCrystalEndTime)
                    && (
                            skill instanceof ReactionDestruction
                            || skill instanceof ReactionDomination
                            || skill instanceof ReactionSpectrum
                            || skill instanceof GloryWingJavelin
                            || skill instanceof GloryWingEnchantJavelin
                    )
                    && cooldownCheck(unlimitedCrystalResonance)
            ) {
                if (resonance == 4) {
                    addSkillEvent(unlimitedCrystalRelease);
                    resonance = 0;
                } else {
                    addSkillEvent(unlimitedCrystalResonance);
                    resonance++;
                }
            }
            if (skill instanceof org.mapledpmlab.type.skill.attackskill.illium.SoulOfCrystal) {
                soulOfCrystalEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (
                    !(skill instanceof CraftOrb)
                    && !(skill instanceof CrestOfTheSolar)
                    && !(skill instanceof CrestOfTheSolarDot)
                    && !(skill instanceof CurseMark)
                    && !(skill instanceof MagicCircuitFullDrive)
                    && !(skill instanceof SpiderInMirror)
                    && !(skill instanceof SpiderInMirrorDot)
            ) {
                addSkillEvent(curseMark);
            }
            if (
                    skill instanceof CraftOrb
                    && cooldownCheck(reactionDomination)
            ) {
                addSkillEvent(reactionDomination);
            }
            if (
                    (
                            skill instanceof CraftJavelin
                            || skill instanceof CraftEnchantJavelin
                            || skill instanceof CraftLonginus
                    )
                    && cooldownCheck(reactionDestruction)
            ) {
                addSkillEvent(reactionDestruction);
            }
            if (skill instanceof CraftJavelin) {
                crystalCharge += 1;
            }
            if (skill instanceof CraftOrb) {
                crystalCharge += 2;
            }
            if (skill instanceof CraftLonginus) {
                crystalCharge += 3;
            }
            if (crystalCharge > 150) {
                crystalCharge = 150;
            }
            if (skill instanceof CrystalSkillDeus) {
                crystalSkillDeusEndTime = new Timestamp(getStart().getTime() + 30000);
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
                    if (
                            skill instanceof Lio1
                            && skillEvent.getStart().after(getStart())
                            && (
                                    skillEvent.getSkill() instanceof Lio1
                                    || skillEvent.getSkill() instanceof Lio2
                                    || skillEvent.getSkill() instanceof Lio3
                            )
                    ) {
                        remove.add(skillEvent);
                    }
                    if (
                            skill instanceof CrystalSkillDeus
                            && skillEvent.getStart().after(getStart())
                            && skillEvent.getEnd().before(crystalSkillDeusEndTime)
                            && (
                                    skillEvent.getSkill() instanceof Lio1
                                    || skillEvent.getSkill() instanceof Lio2
                                    || skillEvent.getSkill() instanceof Lio3
                                    || skillEvent.getSkill() instanceof Machina
                            )
                    ) {
                        remove.add(skillEvent);
                    }
                }
                getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                skill instanceof Lio1
                                || skill instanceof Lio2
                                || skill instanceof Lio3
                        ) {
                            if (lioAttack >= 10 && lioAttack < 20) {
                                skill = lio2;
                            } else if (lioAttack >= 20) {
                                skill = lio3;
                            }
                        }
                        if (
                                skill instanceof CrystalSkillDeusSatellite1
                                || skill instanceof CrystalSkillDeusSatellite2
                                || skill instanceof CrystalSkillDeusSatellite3
                        ) {
                            if (deusAttack >= 10 && deusAttack < 20) {
                                skill = crystalSkillDeusSatellite2;
                            } else if (deusAttack >= 20) {
                                skill = crystalSkillDeusSatellite3;
                            }
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        if (
                                skill instanceof Lio1
                                || skill instanceof Lio2
                                || skill instanceof Lio3
                        ) {
                            lioAttack ++;
                            skill = lio1;
                        }
                        if (lioAttack == 40) {
                            lioAttack = 0;
                        }
                        if (
                                skill instanceof CrystalSkillDeusSatellite1
                                || skill instanceof CrystalSkillDeusSatellite2
                                || skill instanceof CrystalSkillDeusSatellite3
                        ) {
                            deusAttack ++;
                            skill = crystalSkillDeusSatellite1;
                        }
                        if (deusAttack == 40) {
                            deusAttack = 0;
                        }
                    }
                } else {
                    Long attackCount = 0L;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof UnlimitedCrystalRelease) {
                        i += 300;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                        if (skill instanceof CrystalIgnition) {
                            Timestamp temp = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (cooldownCheck(reactionSpectrum)) {
                                addSkillEvent(reactionSpectrum);
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
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isSoulOfCrystal = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (
                        skillEvent.getSkill() instanceof SoulOfCrystal
                        && skillEvent.getStart().after(crystalSkillGloryWingEndTime)
                ) {
                    isSoulOfCrystal = true;
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
                buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            for (SkillEvent se : useAttackSkillList) {
                if (isSoulOfCrystal && se.getSkill() instanceof ReactionDestruction) {
                    se.setSkill(new ReactionDestruction());
                    ((ReactionDestruction) se.getSkill()).addFinalDamage(2.8);
                }
                if (isSoulOfCrystal && se.getSkill() instanceof ReactionDomination) {
                    se.setSkill(new ReactionDomination());
                    ((ReactionDomination) se.getSkill()).addFinalDamage(2.8);
                }
                if (isSoulOfCrystal && se.getSkill() instanceof ReactionSpectrum) {
                    se.setSkill(new ReactionSpectrum());
                    ((ReactionSpectrum) se.getSkill()).addFinalDamage(3.0);
                }
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

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        if (
                attackSkill instanceof CraftEnchantJavelin
                || attackSkill instanceof CraftEnchantJavelinFragment
                || attackSkill instanceof CraftJavelin
                || attackSkill instanceof CraftJavelinFragment
                || attackSkill instanceof CraftLonginus
                || attackSkill instanceof CraftOrb
                || attackSkill instanceof CrystalGate
                || attackSkill instanceof CrystalIgnition
                || attackSkill instanceof CrystalSkillDeus
                || attackSkill instanceof CrystalSkillDeusSatellite1
                || attackSkill instanceof CrystalSkillDeusSatellite2
                || attackSkill instanceof CrystalSkillDeusSatellite3
                || attackSkill instanceof CrystalSkillMortalSwing
                || attackSkill instanceof GloryWingEnchantJavelin
                || attackSkill instanceof GloryWingEnchantJavelinMagicMissile
                || attackSkill instanceof GloryWingJavelin
                || attackSkill instanceof GloryWingJavelinMagicMissile
                || attackSkill instanceof GloryWingMortalWingBeat
                || attackSkill instanceof Gramholder
                || attackSkill instanceof Lio1
                || attackSkill instanceof Lio2
                || attackSkill instanceof Lio3
                || attackSkill instanceof Machina
                || attackSkill instanceof ReactionDestruction
                || attackSkill instanceof ReactionDomination
                || attackSkill instanceof ReactionSpectrum
                || attackSkill instanceof UnlimitedCrystal1
                || attackSkill instanceof UnlimitedCrystal2
                || attackSkill instanceof UnlimitedCrystal3
                || attackSkill instanceof UnlimitedCrystalRelease
                || attackSkill instanceof UnlimitedCrystalResonance
        ) {
            buffSkill.addBuffFinalDamage(1.08);
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat()) * 4
                        + this.getJob().getFinalSubstat()) * 0.01
                        * (Math.floor((this.getJob().getMagic() + buffSkill.getBuffAttMagic())
                        * (1 + (this.getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + this.getJob().getPerXAtt())
                        * this.getJob().getConstant()
                        * (1 + (this.getJob().getDamage() + this.getJob().getBossDamage() + this.getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (this.getJob().getFinalDamage())
                        * buffSkill.getBuffFinalDamage()
                        * this.getJob().getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * this.getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (this.getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (this.getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - this.getJob().getIgnoreDefense()) * (1 - this.getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                this.getJob().addMainStat(-buffSkill.getBuffMainStat());
                this.getJob().addSubStat(-buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(-buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(-buffSkill.getBuffOtherStat2());
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                }
                Long distance = end.getTime() - start.getTime();
                if (attackSkill.getMultiAttackInfo().size() == 0 && attackSkill.getInterval() == 0 && attackSkill.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / attackSkill.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        if (
                attackSkill instanceof CraftEnchantJavelin
                        || attackSkill instanceof CraftEnchantJavelinFragment
                        || attackSkill instanceof CraftJavelin
                        || attackSkill instanceof CraftJavelinFragment
                        || attackSkill instanceof CraftLonginus
                        || attackSkill instanceof CraftOrb
                        || attackSkill instanceof CrystalGate
                        || attackSkill instanceof CrystalIgnition
                        || attackSkill instanceof CrystalSkillDeus
                        || attackSkill instanceof CrystalSkillDeusSatellite1
                        || attackSkill instanceof CrystalSkillDeusSatellite2
                        || attackSkill instanceof CrystalSkillDeusSatellite3
                        || attackSkill instanceof CrystalSkillMortalSwing
                        || attackSkill instanceof GloryWingEnchantJavelin
                        || attackSkill instanceof GloryWingEnchantJavelinMagicMissile
                        || attackSkill instanceof GloryWingJavelin
                        || attackSkill instanceof GloryWingJavelinMagicMissile
                        || attackSkill instanceof GloryWingMortalWingBeat
                        || attackSkill instanceof Gramholder
                        || attackSkill instanceof Lio1
                        || attackSkill instanceof Lio2
                        || attackSkill instanceof Lio3
                        || attackSkill instanceof Machina
                        || attackSkill instanceof ReactionDestruction
                        || attackSkill instanceof ReactionDomination
                        || attackSkill instanceof ReactionSpectrum
                        || attackSkill instanceof UnlimitedCrystal1
                        || attackSkill instanceof UnlimitedCrystal2
                        || attackSkill instanceof UnlimitedCrystal3
                        || attackSkill instanceof UnlimitedCrystalRelease
                        || attackSkill instanceof UnlimitedCrystalResonance
        ) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffPlusFinalDamage() / 1.08);
        }
        return attackDamage;
    }
}
