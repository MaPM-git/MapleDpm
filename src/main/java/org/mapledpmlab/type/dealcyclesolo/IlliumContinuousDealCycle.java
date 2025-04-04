package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.illium.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.illium.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class IlliumContinuousDealCycle extends DealCycle {

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
            add(new CraftLonginus());
            add(new CraftOrb());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CrystalGate());
            add(new CrystalIgnitionBeforeDelay());
            add(new CrystalIgnition());
            add(new CrystalIgnitionAfterDelay());
            add(new CrystalSkillDeus());
            add(new CrystalSkillDeusSatellite());
            add(new CrystalSkillMortalSwing());
            add(new CurseMark());
            add(new GloryWingEnchantJavelin());
            add(new GloryWingEnchantJavelinMagicMissile());
            add(new GloryWingJavelin());
            add(new GloryWingJavelinMagicMissile());
            add(new GloryWingMortalWingBeat());
            add(new Gramholder());
            add(new Lio());
            add(new Machina());
            add(new MagicCircuitFullDrive());
            add(new ReactionDestruction());
            add(new ReactionDestructionSOC());
            add(new ReactionDomination());
            add(new ReactionDominationSOC());
            add(new ReactionSpectrum());
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
            add(new ContinuousRing());
            add(new CrystalGateBuff());
            add(new CrystalSkillGloryWing());
            add(new FastCharge());
            add(new GrandisGoddessBlessingLef(600L));
            add(new MagicCircuitFullDriveBuff());
            add(new PriorPreparation());
            add(new SoulContract());
            add(new SoulOfCrystal1());
            add(new SoulOfCrystal1Buff());
            add(new SoulOfCrystal2());
            add(new SoulOfCrystal2Buff());
            add(new ThiefCunning());
            add(new UnlimitedCrystalBuff());
            add(new WrathOfGod());
        }
    };

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp crystalGateEndTime = new Timestamp(-1);
    Timestamp crystalSkillDeusEndTime = new Timestamp(-1);
    Timestamp crystalSkillGloryWingEndTime = new Timestamp(-1);
    Timestamp magicCircuitFullDriveEndTime = new Timestamp(-1);
    Timestamp soulOfCrystalEndTime = new Timestamp(-1);
    Timestamp unlimitedCrystalEndTime = new Timestamp(-1);

    int crystalCharge = 150;
    int crystalFragment = 0;
    int deusAttack = 0;
    int gloryCrystalFragment = 0;
    int resonance = 0;

    boolean fastChargeReuse = false;
    boolean isNuke = false;

    ContinuousRing continuousRing = new ContinuousRing();
    CraftEnchantJavelin craftEnchantJavelin = new CraftEnchantJavelin();
    CraftEnchantJavelinSOC craftEnchantJavelinSOC = new CraftEnchantJavelinSOC();
    CraftEnchantJavelinCancel craftEnchantJavelinCancel = new CraftEnchantJavelinCancel();
    CraftEnchantJavelinCancelSOC craftEnchantJavelinCancelSOC = new CraftEnchantJavelinCancelSOC();
    CraftJavelin craftJavelin = new CraftJavelin();
    CraftJavelinCancel craftJavelinCancel = new CraftJavelinCancel();
    CraftJavelinSOC craftJavelinSOC = new CraftJavelinSOC();
    CraftJavelinCancelSOC craftJavelinCancelSOC = new CraftJavelinCancelSOC();
    CraftLonginus craftLonginus = new CraftLonginus();
    CraftOrb craftOrb = new CraftOrb();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CrystalGate crystalGate = new CrystalGate();
    CrystalGateBuff crystalGateBuff = new CrystalGateBuff();
    CrystalIgnitionBeforeDelay crystalIgnitionBeforeDelay = new CrystalIgnitionBeforeDelay();
    CrystalSkillDeus crystalSkillDeus = new CrystalSkillDeus();
    CrystalSkillDeusSatellite crystalSkillDeusSatellite = new CrystalSkillDeusSatellite();
    CrystalSkillGloryWing crystalSkillGloryWing = new CrystalSkillGloryWing();
    CrystalSkillMortalSwing crystalSkillMortalSwing = new CrystalSkillMortalSwing();
    FastCharge fastCharge = new FastCharge();
    GloryWingJavelin gloryWingJavelin = new GloryWingJavelin();
    GloryWingEnchantJavelin gloryWingEnchantJavelin = new GloryWingEnchantJavelin();
    GloryWingMortalWingBeat gloryWingMortalWingBeat = new GloryWingMortalWingBeat();
    Gramholder gramholder = new Gramholder();
    GrandisGoddessBlessingLef grandisGoddessBlessingLef = new GrandisGoddessBlessingLef(600L);
    Lio lio = new Lio();
    Machina machina = new Machina();
    MagicCircuitFullDrive magicCircuitFullDrive = new MagicCircuitFullDrive();
    MagicCircuitFullDriveBuff magicCircuitFullDriveBuff = new MagicCircuitFullDriveBuff();
    ReactionDestruction reactionDestruction = new ReactionDestruction();
    ReactionDestructionSOC reactionDestructionSOC = new ReactionDestructionSOC();
    ReactionDomination reactionDomination = new ReactionDomination();
    ReactionDominationSOC reactionDominationSOC = new ReactionDominationSOC();
    ReactionSpectrum reactionSpectrum = new ReactionSpectrum();
    SoulContract soulContract = new SoulContract();
    SoulOfCrystal1 soulOfCrystal1 = new SoulOfCrystal1();
    SoulOfCrystal2 soulOfCrystal2 = new SoulOfCrystal2();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    UnlimitedCrystal1 unlimitedCrystal1 = new UnlimitedCrystal1();
    UnlimitedCrystalRelease unlimitedCrystalRelease = new UnlimitedCrystalRelease();
    UnlimitedCrystalResonance unlimitedCrystalResonance = new UnlimitedCrystalResonance();
    WrathOfGod wrathOfGod = new WrathOfGod();

    public IlliumContinuousDealCycle(Job job) {
        super(job, new CurseMark());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        soulContract.setApplyReuse(true);

        grandisGoddessBlessingLef.setCooldown(120.0);
        magicCircuitFullDriveBuff.setCooldown(180.0);

        magicCircuitFullDrive.setApplyFinalAttack(true);
        spiderInMirror.setApplyFinalAttack(true);
        crestOfTheSolar.setApplyFinalAttack(true);

        crystalSkillDeus.setActivateTime(new Timestamp(1000));
        soulOfCrystal1.setActivateTime(new Timestamp(10 * 1000));
        gramholder.setActivateTime(new Timestamp(19 * 1000));

        getSkillSequence1().add(magicCircuitFullDriveBuff);
        getSkillSequence1().add(wrathOfGod);                // 30
        getSkillSequence1().add(crystalSkillDeus);          // 30

        getSkillSequence2().add(grandisGoddessBlessingLef);
        getSkillSequence2().add(soulContract);              // 30

        getSkillSequence3().add(fastCharge);                // 30
        getSkillSequence3().add(crystalSkillDeus);          // 30
        getSkillSequence3().add(soulOfCrystal2);
    }

    @Override
    public void setSoloDealCycle() {
        addSkillEvent(machina);
        addSkillEvent(lio);
        while (getStart().before(getEnd())) {
            if (
                    crystalCharge >= 150
                    && cooldownCheck(gramholder)
            ) {
                isNuke = true;
                addSkillEvent(crystalGateBuff);
                addDealCycle(getSkillSequence1());
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                while (!cooldownCheck(soulOfCrystal1)) {
                    addPlatDeal();
                }
                addSkillEvent(soulOfCrystal1);
                addSkillEvent(crystalSkillMortalSwing);
                addSkillEvent(crystalSkillGloryWing);
                while (!cooldownCheck(gramholder)) {
                    addPlatDeal();
                }
                addSkillEvent(gramholder);
                addDealCycle(getSkillSequence2());
                isNuke = false;
                if (cooldownCheck(unlimitedCrystal1)) {
                    addSkillEvent(unlimitedCrystal1);
                }
                addSkillEvent(gloryWingMortalWingBeat);
                while (!cooldownCheck(crystalIgnitionBeforeDelay)) {
                    addPlatDeal();
                }
                addSkillEvent(crystalIgnitionBeforeDelay);
                while (
                        getStart().before(crystalSkillGloryWingEndTime)
                        || !cooldownCheck(crystalSkillDeus)
                ) {
                    addPlatDeal();
                }
                while (!cooldownCheck(fastCharge)) {
                    addPlatDeal();
                }
                addDealCycle(getSkillSequence3());
                addSkillEvent(crystalSkillMortalSwing);
                addSkillEvent(crystalSkillGloryWing);
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
                    cooldownCheck(soulOfCrystal1)
                            && getStart().before(new Timestamp(fastCharge.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(soulOfCrystal1);
            } else {
                addPlatDeal();
            }
        }
        sortEventTimeList();
    }

    public void addPlatDeal() {
        if (cooldownCheck(craftLonginus)) {
            addSkillEvent(craftLonginus);
            crystalFragment += 2;
            gloryCrystalFragment += 3;
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
                if (
                        crystalCharge >= 150
                                && !cooldownCheck(reactionDomination)
                ) {
                    addSkillEvent(craftEnchantJavelin);
                } else {
                    addSkillEvent(craftEnchantJavelinCancel);
                    addSkillEvent(craftOrb);
                }
                crystalFragment = 0;
                crystalCharge += 25;
            } else {
                if (
                        crystalCharge >= 150
                                && !cooldownCheck(reactionDomination)
                ) {
                    addSkillEvent(craftJavelin);
                } else {
                    addSkillEvent(craftJavelinCancel);
                    addSkillEvent(craftOrb);
                }
                crystalFragment++;
            }
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        int soc = 0;
        for (SkillEvent skillEvent : this.getSkillEventList()) {
            if (
                    skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill() instanceof SoulOfCrystal2
            ) {
                soc = 2;
                break;
            } else if (
                    skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill() instanceof SoulOfCrystal1
            ) {
                soc ++;
                if (soc == 2) {
                    break;
                }
            }
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (
                    skill instanceof SoulOfCrystal1
                    || skill instanceof SoulOfCrystal2
            ) {
                soulOfCrystalEndTime = new Timestamp(getStart().getTime() + 33000);
            }
            if (skill instanceof CrystalGateBuff) {
                crystalGateEndTime = new Timestamp(getStart().getTime() + 190000);
            }
            if (skill instanceof MagicCircuitFullDriveBuff) {
                magicCircuitFullDriveEndTime = new Timestamp(getStart().getTime() + 63000);
            }
            if (skill instanceof UnlimitedCrystalBuff) {
                unlimitedCrystalEndTime = new Timestamp(getStart().getTime() + 20000);
            }
            if (skill instanceof FastCharge) {
                crystalCharge = 150;
            }
            if (skill instanceof CrystalSkillGloryWing) {
                crystalCharge = 0;
                crystalSkillGloryWingEndTime = new Timestamp(getStart().getTime() + 20000);
                if (soulOfCrystalEndTime.after(getStart())) {
                    if (soc == 2) {
                        SoulOfCrystal2Buff soulOfCrystal2Buff = new SoulOfCrystal2Buff();
                        soulOfCrystal2Buff.setDuration((soulOfCrystalEndTime.getTime() - getStart().getTime()) / 1000);
                        getSkillEventList().add(new SkillEvent(soulOfCrystal2Buff, new Timestamp(getStart().getTime()), new Timestamp(soulOfCrystalEndTime.getTime())));
                    } else if (soc == 1) {
                        SoulOfCrystal1Buff soulOfCrystal1Buff = new SoulOfCrystal1Buff();
                        soulOfCrystal1Buff.setDuration((soulOfCrystalEndTime.getTime() - getStart().getTime()) / 1000);
                        getSkillEventList().add(new SkillEvent(soulOfCrystal1Buff, new Timestamp(getStart().getTime()), new Timestamp(soulOfCrystalEndTime.getTime())));
                    }
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
                    skill instanceof SoulContract
                    && restraintRingStartTime == null
                    && restraintRingEndTime == null
                    && fortyEndTime == null
                    && isNuke
            ) {
                restraintRingStartTime = new Timestamp(getStart().getTime());
                restraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
                fortyEndTime = new Timestamp(getStart().getTime() + 40000);
            } else if (
                    skill instanceof SoulContract
                            && restraintRingStartTime != null
                            && restraintRingEndTime != null
                            && fortyEndTime != null
                            && originXRestraintRingStartTime == null
                            && originXRestraintRingEndTime == null
                            && isNuke
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
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof CraftJavelin
                            || skill instanceof CraftJavelinCancel
                            || skill instanceof CraftLonginus
                            || skill instanceof CraftOrb
                            || skill instanceof CrystalSkillMortalSwing
                            || skill instanceof GloryWingJavelin
                    )
            ) {
                addSkillEvent(continuousRing);
            }
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
                            || skill instanceof ReactionDestructionSOC
                            || skill instanceof ReactionDomination
                            || skill instanceof ReactionDominationSOC
                            || skill instanceof ReactionSpectrum
                            || skill instanceof GloryWingJavelin
                            || skill instanceof GloryWingEnchantJavelin
                    )
                    && cooldownCheck(unlimitedCrystalResonance)
            ) {
                if (resonance == 3) {
                    addSkillEvent(unlimitedCrystalRelease);
                    resonance = 0;
                } else {
                    addSkillEvent(unlimitedCrystalResonance);
                    resonance++;
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
                lio.setActivateTime(new Timestamp(-1));
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
                            skill instanceof Lio
                            && skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill() instanceof Lio
                    ) {
                        remove.add(skillEvent);
                    }
                    if (
                            skill instanceof CrystalSkillDeus
                            && skillEvent.getStart().after(getStart())
                            && skillEvent.getEnd().before(crystalSkillDeusEndTime)
                            && (
                                    skillEvent.getSkill() instanceof Lio
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
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
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
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
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
        if (skill instanceof SoulOfCrystal1) {
            soulOfCrystal2.setActivateTime(new Timestamp(soulOfCrystal1.getActivateTime().getTime()));
        } else if (skill instanceof SoulOfCrystal2) {
            soulOfCrystal1.setActivateTime(new Timestamp(soulOfCrystal2.getActivateTime().getTime()));
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
                        skillEvent.getSkill() instanceof SoulOfCrystal2
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
                            * (1 - 0.5 * (1 - (this.getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
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

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Timestamp tmp = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CraftEnchantJavelin
                            || skill instanceof CraftEnchantJavelinCancel
                            || skill instanceof GloryWingEnchantJavelin
                            || skill instanceof GloryWingMortalWingBeat
                            || skill instanceof UnlimitedCrystal1
                            || skill instanceof UnlimitedCrystal2
                            || skill instanceof UnlimitedCrystal3
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            getStart().setTime(tmp.getTime());
        }
    }
}
