package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CraftEnchantJavelin());
            add(new CraftEnchantJavelinCancel());
            add(new CraftEnchantJavelinFragment());
            add(new CraftEnchantJavelinSOC());
            add(new CraftEnchantJavelinCancelSOC());
            add(new CraftEnchantJavelinFragmentSOC());
            add(new CraftJavelin());
            add(new CraftJavelinCancel());
            add(new CraftJavelinFragment());
            add(new CraftJavelinSOC());
            add(new CraftJavelinCancelSOC());
            add(new CraftJavelinFragmentSOC());
            //add(new CraftLonginus());
            add(new CraftOrb());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CrystalGate());
            add(new CrystalIgnitionBeforeDelay());
            add(new CrystalIgnition());
            add(new CrystalIgnitionAfterDelay());
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
            add(new ReactionDestructionSOC());
            add(new ReactionDomination());
            add(new ReactionDominationSOC());
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CrystalGateBuff());
            add(new CrystalSkillGloryWing());
            add(new FastCharge());
            add(new GrandisGoddessBlessingLef(600L));
            add(new MagicCircuitFullDriveBuff());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new RingSwitching());
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
    CraftEnchantJavelinSOC craftEnchantJavelinSOC = new CraftEnchantJavelinSOC();
    CraftEnchantJavelinCancel craftEnchantJavelinCancel = new CraftEnchantJavelinCancel();
    CraftEnchantJavelinCancelSOC craftEnchantJavelinCancelSOC = new CraftEnchantJavelinCancelSOC();
    CraftJavelinSOC craftJavelinSOC = new CraftJavelinSOC();
    CraftJavelinCancelSOC craftJavelinCancelSOC = new CraftJavelinCancelSOC();
    CrystalGate crystalGate = new CrystalGate();
    CrystalSkillDeusSatellite1 crystalSkillDeusSatellite1 = new CrystalSkillDeusSatellite1();
    CrystalSkillDeusSatellite2 crystalSkillDeusSatellite2 = new CrystalSkillDeusSatellite2();
    CrystalSkillDeusSatellite3 crystalSkillDeusSatellite3 = new CrystalSkillDeusSatellite3();

    GloryWingEnchantJavelin gloryWingEnchantJavelin = new GloryWingEnchantJavelin();
    Lio1 lio1 = new Lio1();
    Lio2 lio2 = new Lio2();
    Lio3 lio3 = new Lio3();
    MagicCircuitFullDrive magicCircuitFullDrive = new MagicCircuitFullDrive();
    ReactionDestruction reactionDestruction = new ReactionDestruction();
    ReactionDestructionSOC reactionDestructionSOC = new ReactionDestructionSOC();
    ReactionDomination reactionDomination = new ReactionDomination();
    ReactionDominationSOC reactionDominationSOC = new ReactionDominationSOC();
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
        super(job, new CurseMark());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        CraftJavelin craftJavelin = new CraftJavelin();
        CraftJavelinCancel craftJavelinCancel = new CraftJavelinCancel();
        CraftLonginus craftLonginus = new CraftLonginus();
        CraftOrb craftOrb = new CraftOrb();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrystalGateBuff crystalGateBuff = new CrystalGateBuff();
        CrystalIgnitionBeforeDelay crystalIgnitionBeforeDelay = new CrystalIgnitionBeforeDelay();
        CrystalSkillDeus crystalSkillDeus = new CrystalSkillDeus();
        CrystalSkillGloryWing crystalSkillGloryWing = new CrystalSkillGloryWing();
        CrystalSkillMortalSwing crystalSkillMortalSwing = new CrystalSkillMortalSwing();
        FastCharge fastCharge = new FastCharge();
        GloryWingJavelin gloryWingJavelin = new GloryWingJavelin();
        GloryWingMortalWingBeat gloryWingMortalWingBeat = new GloryWingMortalWingBeat();
        Gramholder gramholder = new Gramholder();
        GrandisGoddessBlessingLef grandisGoddessBlessingLef = new GrandisGoddessBlessingLef(600L);
        Machina machina = new Machina();
        MagicCircuitFullDriveBuff magicCircuitFullDriveBuff = new MagicCircuitFullDriveBuff();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SoulOfCrystal soulOfCrystal = new SoulOfCrystal();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        UnlimitedCrystal1 unlimitedCrystal1 = new UnlimitedCrystal1();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WrathOfGod wrathOfGod = new WrathOfGod();

        ringSwitching.setCooldown(90.0);

        addSkillEvent(lio1);
        addSkillEvent(machina);

        soulContract.setApplyReuse(true);

        grandisGoddessBlessingLef.setCooldown(240.0);
        magicCircuitFullDriveBuff.setCooldown(180.0);

        magicCircuitFullDrive.setApplyFinalAttack(true);
        spiderInMirror.setApplyFinalAttack(true);
        crestOfTheSolar.setApplyFinalAttack(true);

        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(crystalGateBuff)
                    //&& cooldownCheck(soulOfCrystal)
                    && cooldownCheck(wrathOfGod)
                    && cooldownCheck(magicCircuitFullDriveBuff)
                    && cooldownCheck(gramholder)
                    && cooldownCheck(crystalSkillDeus)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
                    && cooldownCheck(crystalIgnitionBeforeDelay)
                    && crystalCharge >= 150
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(lio1);
                addSkillEvent(crystalGateBuff);
                while (
                        cooldownCheck(unlimitedCrystal1)
                        && !cooldownCheck(soulOfCrystal)
                ) {
                    if (gloryCrystalFragment != 0) {
                        gloryCrystalFragment = 0;
                    }
                    if (crystalFragment == 30) {
                        addSkillEvent(craftEnchantJavelin);
                        crystalFragment = 0;
                        crystalCharge += 25;
                    } else {
                        addSkillEvent(craftJavelin);
                        crystalFragment++;
                    }
                }
                if (cooldownCheck(soulOfCrystal)) {
                    addSkillEvent(soulOfCrystal);
                }
                addSkillEvent(magicCircuitFullDriveBuff);
                addSkillEvent(wrathOfGod);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(craftJavelin);
                    crystalFragment++;
                    if (crystalFragment > 30) {
                        crystalFragment = 30;
                    }
                }
                if (cooldownCheck(grandisGoddessBlessingLef)) {
                    if (getStart().before(new Timestamp(10 * 1000))) {
                        grandisGoddessBlessingLef.setCooldown(360.0);
                    } else if (getStart().after(new Timestamp(5 * 60 * 1000))) {
                        grandisGoddessBlessingLef.setCooldown(180.0);
                    }
                    addSkillEvent(grandisGoddessBlessingLef);
                }
                addSkillEvent(gramholder);
                addSkillEvent(crystalSkillDeus);
                addSkillEvent(crystalSkillMortalSwing);
                addSkillEvent(crystalSkillGloryWing);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                if (cooldownCheck(unlimitedCrystal1)) {
                    addSkillEvent(unlimitedCrystal1);
                }
                addSkillEvent(gloryWingMortalWingBeat);
                addSkillEvent(crystalIgnitionBeforeDelay);
            } else if (
                    cooldownCheck(fastCharge)
                    && getStart().after(crystalSkillGloryWingEndTime)
            ) {
                boolean isSOC = false;
                while (!cooldownCheck(crystalSkillDeus)) {
                    if (cooldownCheck(soulOfCrystal)) {
                        addSkillEvent(soulOfCrystal);
                        isSOC = true;
                    }
                    if (gloryCrystalFragment != 0) {
                        gloryCrystalFragment = 0;
                    }
                    if (crystalFragment == 30) {
                        addSkillEvent(craftEnchantJavelin);
                        crystalFragment = 0;
                        crystalCharge += 25;
                    } else {
                        addSkillEvent(craftJavelin);
                        crystalFragment++;
                    }
                }
                addSkillEvent(crystalSkillDeus);
                addSkillEvent(fastCharge);
                addSkillEvent(ringSwitching);
                while (
                        !isSOC && (
                            !cooldownCheck(soulOfCrystal)
                            || getStart().before(soulOfCrystalEndTime)
                        )

                ) {
                    if (gloryCrystalFragment != 0) {
                        gloryCrystalFragment = 0;
                    }
                    if (crystalFragment == 30) {
                        if (crystalCharge >= 150) {
                            addSkillEvent(craftEnchantJavelin);
                        } else {
                            addSkillEvent(craftEnchantJavelinCancel);
                            addSkillEvent(craftOrb);
                        }
                        crystalFragment = 0;
                        crystalCharge += 25;
                    } else {
                        if (crystalCharge >= 150) {
                            addSkillEvent(craftJavelin);
                        } else {
                            addSkillEvent(craftJavelinCancel);
                            addSkillEvent(craftOrb);
                        }
                        crystalFragment++;
                    }
                }
                if (cooldownCheck(soulOfCrystal)) {
                    addSkillEvent(soulOfCrystal);
                }
                addSkillEvent(crystalSkillMortalSwing);
                addSkillEvent(crystalSkillGloryWing);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(gloryWingMortalWingBeat);
                while (cooldownCheck(fastCharge)) {
                    addSkillEvent(fastCharge);
                    addSkillEvent(crystalSkillMortalSwing);
                    addSkillEvent(crystalSkillGloryWing);
                    addSkillEvent(gloryWingMortalWingBeat);
                }
            } else if (
                    getStart().after(crystalSkillGloryWingEndTime)
                    && crystalCharge >= 150
                    && cooldownCheck(crystalSkillDeus)
                    && !getStart().after(new Timestamp(710 * 1000))
                    && !cooldownCheck(wrathOfGod)
            ) {
                addSkillEvent(crystalSkillDeus);
                addSkillEvent(crystalSkillMortalSwing);
                addSkillEvent(crystalSkillGloryWing);
                if (cooldownCheck(soulContract)) {
                    addSkillEvent(soulContract);
                }
                addSkillEvent(gloryWingMortalWingBeat);
            } else if (
                    cooldownCheck(soulOfCrystal)
                    && getStart().before(new Timestamp(fastCharge.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(soulOfCrystal);
            } else if (
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
                    if (crystalCharge >= 150) {
                        addSkillEvent(craftEnchantJavelin);
                    } else {
                        addSkillEvent(craftEnchantJavelinCancel);
                        addSkillEvent(craftOrb);
                    }
                    crystalFragment = 0;
                    crystalCharge += 25;
                } else {
                    if (crystalCharge >= 150) {
                        addSkillEvent(craftJavelin);
                    } else {
                        addSkillEvent(craftJavelinCancel);
                        addSkillEvent(craftOrb);
                    }
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
            if (skill instanceof SoulOfCrystal) {
                soulOfCrystalEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof CrystalGateBuff) {
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
                    soulOfCrystalBuff.setDuration((soulOfCrystalEndTime.getTime() - getStart().getTime()) / 1000);
                    getSkillEventList().add(new SkillEvent(soulOfCrystalBuff, new Timestamp(getStart().getTime()), new Timestamp(soulOfCrystalEndTime.getTime())));
                    soulOfCrystalEndTime = new Timestamp(-1);
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
            if (skill instanceof CraftEnchantJavelin) {
                addSkillEvent(craftEnchantJavelinSOC);
            } else if (skill instanceof CraftEnchantJavelinCancel) {
                addSkillEvent(craftEnchantJavelinCancelSOC);
            } else if (skill instanceof CraftJavelin) {
                addSkillEvent(craftJavelinSOC);
            } else if (skill instanceof CraftJavelinCancel) {
                addSkillEvent(craftJavelinCancelSOC);
            }
            if (getStart().before(soulOfCrystalEndTime)) {
                if (skill instanceof ReactionDestruction) {
                    addSkillEvent(reactionDestructionSOC);
                } else if (skill instanceof ReactionDomination) {
                    addSkillEvent(reactionDominationSOC);
                }
            }
            if (
                    getStart().before(crystalGateEndTime)
                    && cooldownCheck(crystalGate)
                    && !(skill instanceof CrystalGate)
                    && !(skill instanceof MagicCircuitFullDrive)
            ) {
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
                    && !(skill instanceof CrystalGate)
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
                addSkillEvent(unlimitedCrystalResonance);
                resonance++;
                if (resonance == 3) {
                    addSkillEvent(unlimitedCrystalRelease);
                    resonance = 0;
                }
            }
            if (
                    skill instanceof CraftOrb
                    && cooldownCheck(reactionDomination)
            ) {
                addSkillEvent(reactionDomination);
            }
            if (
                    (
                            skill instanceof CraftJavelinCancel
                            || skill instanceof CraftEnchantJavelinCancel
                            || skill instanceof CraftLonginus
                            || skill instanceof CraftJavelin
                            || skill instanceof CraftEnchantJavelin
                    )
                    && cooldownCheck(reactionDestruction)
            ) {
                addSkillEvent(reactionDestruction);
            }
            if (
                    skill instanceof CraftJavelinCancel
                    || skill instanceof CraftJavelin
            ) {
                crystalCharge += 1;
            }
            if (skill instanceof CraftOrb) {
                crystalCharge += 2;
            }
            if (skill instanceof CraftLonginus) {
                crystalCharge += 3;
            }
            if (
                    skill instanceof CraftEnchantJavelin
                    || skill instanceof CraftEnchantJavelinCancel
            ) {
                crystalCharge += 25;
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
                        if (
                                !(skillEvent.getSkill() instanceof GloryWingJavelinMagicMissile)
                                && !(skillEvent.getSkill() instanceof GloryWingEnchantJavelinMagicMissile)
                                && !(skillEvent.getSkill() instanceof CraftJavelinFragment)
                                && !(skillEvent.getSkill() instanceof CraftEnchantJavelinFragment)
                        ) {
                            remove.add(skillEvent);
                        }
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
            boolean isSoulOfCrystal = false;
            boolean isCrystalSkillGloryWing = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof CrystalSkillGloryWing) {
                    isCrystalSkillGloryWing = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (
                        skillEvent.getSkill() instanceof SoulOfCrystal
                                && !isCrystalSkillGloryWing
                ) {
                    isSoulOfCrystal = true;
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
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
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
}
