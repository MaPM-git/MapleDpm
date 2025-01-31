package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.striker.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.striker.CreationOfTheWorld;
import org.mapledpmlab.type.skill.buffskill.striker.LightningUnion;
import org.mapledpmlab.type.skill.buffskill.striker.TyphoonBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class StrikerDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new Annihilation());
            add(new CreateThunderChain());
            add(new CreateThunderChainFinal());
            add(new CreateThunderChainHugeLightning());
            add(new CreateThunderChainLightning());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanxDelay());
            add(new CygnusPhalanx());
            add(new GodOfTheSea());
            add(new Lightning());
            add(new LightningGodSpearStrike());
            add(new LightningGodSpearStrikeDot());
            add(new SeaWave());
            add(new SeaWaveThunderboltFlash());
            add(new SharkWave());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new Thunderbolt());
            add(new ThunderboltFlash());
            add(new ThunderBreakTheSea());
            add(new ThunderBreakTheSeaFinal());
            add(new Thunderstroke());
            add(new ThunderstrokeGiant());
            add(new Typhoon());
            add(new WaterWave());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CreationOfTheWorld());
            add(new GloryOfGuardians());
            add(new LightningUnion());
            add(new LoadedDice());
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new TranscendentCygnusBlessing(0L));
            add(new TyphoonBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int lightningGodSpearStrikeCount = 0;
    int linkCount = 0;
    int seaWaveCount = 0;
    int sharkWaveCount = 0;

    Timestamp creationOfTheWorldEndTime = new Timestamp(-1);
    Timestamp lightningUnionEndTime = new Timestamp(-1);

    Annihilation annihilation = new Annihilation();
    CreateThunderChain createThunderChain = new CreateThunderChain();
    CreateThunderChainHugeLightning createThunderChainHugeLightning = new CreateThunderChainHugeLightning();
    CreateThunderChainLightning createThunderChainLightning = new CreateThunderChainLightning();
    CreationOfTheWorld creationOfTheWorld = new CreationOfTheWorld();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
    GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
    GodOfTheSea godOfTheSea = new GodOfTheSea();
    Lightning lightning = new Lightning();
    LightningGodSpearStrike lightningGodSpearStrike = new LightningGodSpearStrike();
    LightningUnion lightningUnion = new LightningUnion();
    LoadedDice loadedDice = new LoadedDice();
    Overdrive overdrive = new Overdrive(255L);
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SeaWave seaWave = new SeaWave();
    SharkWave sharkWave = new SharkWave();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    Thunderbolt thunderbolt = new Thunderbolt();
    ThunderboltFlash thunderboltFlash = new ThunderboltFlash();
    Thunderstroke thunderstroke = new Thunderstroke();
    ThunderstrokeGiant thunderstrokeGiant = new ThunderstrokeGiant();
    ThunderBreakTheSea thunderBreakTheSea = new ThunderBreakTheSea();
    TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
    Typhoon typhoon = new Typhoon();
    WaterWave waterWave = new WaterWave();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public StrikerDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(120.0);

        transcendentCygnusBlessing.setCooldown(120.0);
        transcendentCygnusBlessing.setApplyCooldownReduction(false);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);

        getSkillSequence1().add(gloryOfGuardians);              // 30
        getSkillSequence1().add(lightningUnion);                // 180
        getSkillSequence1().add(overdrive);                     // 420
        getSkillSequence1().add(soulContract);                  // 30

        getSkillSequence2().add(overdrive);
        getSkillSequence2().add(soulContract);

        getSkillSequence3().add(loadedDice);

        getSkillSequence4().add(creationOfTheWorld);

        loadedDice.setDelay(660L);

        creationOfTheWorld.setDelay(660L);

        lightningUnion.setDelay(180L);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(loadedDice)) {
                addSkillEvent(loadedDice);
            }
            if (cooldownCheck(cygnusPhalanx)) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(transcendentCygnusBlessing)
                            && getStart().after(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 5000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (
                    cooldownCheck(createThunderChain)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(sharkWave);
                addSkillEvent(waterWave);
                addSkillEvent(createThunderChain);
                if (cooldownCheck(thunderBreakTheSea)) {
                    addSkillEvent(thunderBreakTheSea);
                }
                while (!cooldownCheck(creationOfTheWorld)) {
                    if (cooldownCheck(typhoon)) {
                        addSkillEvent(typhoon);
                        addSkillEvent(annihilation);
                    } else {
                        if (cooldownCheck(thunderboltFlash)) {
                            addSkillEvent(thunderboltFlash);
                        } else {
                            addSkillEvent(thunderbolt);
                        }
                        addSkillEvent(annihilation);
                    }
                }
                addSkillEvent(creationOfTheWorld);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(110 * 1000))
                            && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && !cooldownCheck(gloryOfGuardians)
            ) {
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(godOfTheSea)
            ) {
                addSkillEvent(godOfTheSea);
            } else if (
                    cooldownCheck(sharkWave)
                            && getStart().before(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 6000))
            ) {
                addSkillEvent(sharkWave);
            } else if (
                    getStart().before(creationOfTheWorldEndTime)
            ) {
                typhoon.setActivateTime(new Timestamp(-1));
                if (cooldownCheck(thunderboltFlash)) {
                    addSkillEvent(thunderboltFlash);
                } else {
                    addSkillEvent(typhoon);
                }
                typhoon.setActivateTime(new Timestamp(-1));
                addSkillEvent(annihilation);
            } else if (
                    cooldownCheck(typhoon)
            ) {
                addSkillEvent(typhoon);
                addSkillEvent(annihilation);
            } else {
                if (cooldownCheck(thunderboltFlash)) {
                    addSkillEvent(thunderboltFlash);
                } else {
                    addSkillEvent(thunderbolt);
                }
                addSkillEvent(annihilation);
            }
        }
        sortEventTimeList();
    }

    public void lightningGodSpearStrikeCooldownReduction() {
        if (lightningGodSpearStrikeCount < 6) {
            lightningGodSpearStrike.setActivateTime(new Timestamp(lightningGodSpearStrike.getActivateTime().getTime() - 500));
            lightningGodSpearStrikeCount ++;
        }
    }

    public void sharkWaveCooldownReduction() {
        if (sharkWaveCount < 4) {
            sharkWave.setActivateTime(new Timestamp(sharkWave.getActivateTime().getTime() - 500));
            sharkWaveCount ++;
        }
    }

    public void seaWaveCooldownReduction() {
        if (seaWaveCount < 6) {//4) {
            seaWave.setActivateTime(new Timestamp(seaWave.getActivateTime().getTime() - 1500));
            seaWaveCount ++;
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime()) && getStart().after(new Timestamp(0))) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof LightningUnion) {
                lightningUnionEndTime = new Timestamp(getStart().getTime() + 62000);
            }
            if (skill instanceof CreationOfTheWorld) {
                creationOfTheWorldEndTime = new Timestamp(getStart().getTime() + 3000 + 30000);
                sharkWaveCount = 0;
                seaWaveCount = 0;
                lightningGodSpearStrikeCount = 0;
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
                if (skill instanceof TranscendentCygnusBlessing) {
                    for (long i = 0; i < 48000; i += 4000) {
                        getSkillEventList().add(new SkillEvent(new TranscendentCygnusBlessing(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 4000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 4000));
                    }
                }
                if (skill instanceof OverdriveDebuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 31000), new Timestamp(getStart().getTime() + (long) (applyCooldownReduction(skill) * 1000))));
                } else {
                    endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                    if (skill.isApplyServerLag()) {
                        endTime = new Timestamp(endTime.getTime() + 3000);
                    }
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
            if (
                    skill instanceof Thunderbolt
                    || skill instanceof ThunderboltFlash
                    || skill instanceof GodOfTheSea
            ) {
                addSkillEvent(thunderstroke);
            }
            if (
                    skill instanceof Typhoon
                    || skill instanceof SharkWave
                    || skill instanceof LightningGodSpearStrike
                    || skill instanceof CreateThunderChainFinal
            ) {
                addSkillEvent(thunderstrokeGiant);
            }
            if (skill instanceof SeaWave) {
                seaWaveCount = 0;
            }
            if (skill instanceof LightningGodSpearStrike) {
                lightningGodSpearStrikeCount = 0;
            }
            if (skill instanceof SharkWave) {
                sharkWaveCount = 0;
            }
            if (getStart().before(creationOfTheWorldEndTime)) {
                if (
                        skill instanceof SeaWave
                        || skill instanceof Typhoon
                        || skill instanceof SharkWave
                        || skill instanceof LightningGodSpearStrike
                        || skill instanceof LightningGodSpearStrikeDot
                ) {
                    lightningGodSpearStrikeCooldownReduction();
                    seaWaveCooldownReduction();
                    sharkWaveCooldownReduction();
                }
            }
            if (
                    skill instanceof Annihilation
                    || skill instanceof GodOfTheSea
                    || skill instanceof SharkWave
                    || skill instanceof Thunderbolt
                    || skill instanceof ThunderboltFlash
                    || skill instanceof Typhoon
                    || skill instanceof WaterWave
                    || skill instanceof CreateThunderChainFinal
            ) {
                linkCount ++;
                if (linkCount > 8 && cooldownCheck(lightningGodSpearStrike)) {
                    addSkillEvent(lightningGodSpearStrike);
                    linkCount = 0;
                }
                if (cooldownCheck(seaWave)) {
                    addSkillEvent(seaWave);
                }
            }
            if (
                    getStart().before(lightningUnionEndTime)
                    && (
                            skill instanceof CreateThunderChain
                            || skill instanceof CreateThunderChainFinal
                            || skill instanceof CreateThunderChainHugeLightning
                            || skill instanceof CreateThunderChainLightning
                            || skill instanceof GodOfTheSea
                            || skill instanceof LightningGodSpearStrike
                            || skill instanceof LightningGodSpearStrikeDot
                            || skill instanceof SharkWave
                            || skill instanceof Thunderbolt
                            || skill instanceof ThunderBreakTheSea
                            || skill instanceof ThunderBreakTheSeaFinal
                            || skill instanceof Typhoon
                            || skill instanceof WaterWave
                    )
                    && cooldownCheck(lightning)
            ) {
                addSkillEvent(lightning);
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
                        if (skill instanceof CreateThunderChain) {
                            linkCount ++;
                            Timestamp current = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (linkCount > 8 && cooldownCheck(lightningGodSpearStrike)) {
                                addSkillEvent(lightningGodSpearStrike);
                                linkCount = 0;
                            }
                            if (cooldownCheck(seaWave)) {
                                addSkillEvent(seaWave);
                            }
                            getStart().setTime(current.getTime());
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        if (skill instanceof CreateThunderChain) {
                            getSkillEventList().add(new SkillEvent(createThunderChainLightning, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            getSkillEventList().add(new SkillEvent(thunderstrokeGiant, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        }
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

    @Override
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
        boolean isOverdrive = false;
        for (SkillEvent skillEvent : overlappingSkillEvents) {
            if (skillEvent.getSkill() instanceof Overdrive) {
                isOverdrive = true;
                break;
            }
        }
        if (isOverdrive) {
            for (int i = 0; i < overlappingSkillEvents.size(); i++) {
                if (overlappingSkillEvents.get(i).getSkill() instanceof OverdriveDebuff) {
                    overlappingSkillEvents.remove(i);
                }
            }
        }
        return overlappingSkillEvents;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    skill instanceof ThunderBreakTheSea
                    || skill instanceof ThunderBreakTheSeaFinal
            ) {
                linkCount ++;
                Timestamp current = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (linkCount > 8 && cooldownCheck(lightningGodSpearStrike)) {
                    addSkillEvent(lightningGodSpearStrike);
                    linkCount = 0;
                }
                if (cooldownCheck(seaWave)) {
                    addSkillEvent(seaWave);
                }
                getStart().setTime(current.getTime());
                getSkillEventList().add(new SkillEvent(thunderstrokeGiant, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            }
        }
    }
}
