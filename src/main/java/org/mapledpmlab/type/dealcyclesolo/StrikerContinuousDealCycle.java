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

public class StrikerContinuousDealCycle extends DealCycle {
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
            add(new ContinuousRing());
            add(new CreationOfTheWorld());
            add(new GloryOfGuardians());
            add(new LightningUnion());
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new SoulContract());
            add(new TranscendentCygnusBlessing(0L));
            add(new TyphoonBuff());
        }
    };

    int lightningGodSpearStrikeCount = 0;
    int linkCount = 0;
    int seaWaveCount = 0;
    int sharkWaveCount = 0;

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp creationOfTheWorldEndTime = new Timestamp(-1);
    Timestamp lightningUnionEndTime = new Timestamp(-1);

    boolean isNuke = false;

    Annihilation annihilation = new Annihilation();
    ContinuousRing continuousRing = new ContinuousRing();
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
    Overdrive overdrive = new Overdrive(255L);
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

    public StrikerContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        transcendentCygnusBlessing.setCooldown(120.0);
        transcendentCygnusBlessing.setApplyCooldownReduction(false);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
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
                    cooldownCheck(gloryOfGuardians)
                            && cooldownCheck(lightningUnion)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(sharkWave)
                            && cooldownCheck(waterWave)
                            && cooldownCheck(createThunderChain)
                            && cooldownCheck(creationOfTheWorld)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                isNuke = true;
                addSkillEvent(gloryOfGuardians);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    if (cooldownCheck(thunderboltFlash)) {
                        addSkillEvent(thunderboltFlash);
                    } else {
                        addSkillEvent(thunderbolt);
                    }
                    addSkillEvent(annihilation);
                }
                addSkillEvent(lightningUnion);
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(sharkWave);
                addSkillEvent(waterWave);
                if (cooldownCheck(thunderBreakTheSea)) {
                    addSkillEvent(thunderBreakTheSea);
                }
                addSkillEvent(createThunderChain);
                addSkillEvent(creationOfTheWorld);
                dealCycleOrder ++;
                isNuke = false;
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
                            && !cooldownCheck(gloryOfGuardians)
            ) {
                addSkillEvent(sharkWave);
            } else if (
                    getStart().before(creationOfTheWorldEndTime)
            ) {
                if (cooldownCheck(thunderboltFlash)) {
                    addSkillEvent(thunderboltFlash);
                } else {
                    addSkillEvent(typhoon);
                }
                typhoon.setActivateTime(new Timestamp(-1));
                addSkillEvent(annihilation);
            } /*else if (
                    cooldownCheck(typhoon)
            ) {
                addSkillEvent(typhoon);
                addSkillEvent(annihilation);
            }*/ else {
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
        if (lightningGodSpearStrikeCount < 8) {//6) {
            lightningGodSpearStrike.setActivateTime(new Timestamp(lightningGodSpearStrike.getActivateTime().getTime() - 500));
            lightningGodSpearStrikeCount ++;
        }
    }

    public void sharkWaveCooldownReduction() {
        if (sharkWaveCount < 12) {//4) {
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (skill instanceof LightningUnion) {
                lightningUnionEndTime = new Timestamp(getStart().getTime() + 62000);
            }
            if (skill instanceof CreationOfTheWorld) {
                creationOfTheWorldEndTime = new Timestamp(getStart().getTime() + 30000);
                sharkWaveCount = 0;
                seaWaveCount = 0;
                lightningGodSpearStrikeCount = 0;
            }
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
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                if (skill instanceof TranscendentCygnusBlessing) {
                    for (long i = 0; i < 45000; i += 4000) {
                        getSkillEventList().add(new SkillEvent(new TranscendentCygnusBlessing(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 4000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 4000));
                    }
                }
                if (skill instanceof OverdriveDebuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 28000), new Timestamp(getStart().getTime() + (long) (applyCooldownReduction(skill) * 1000))));
                } else {
                    endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof Annihilation
                            || skill instanceof CreateThunderChainFinal
                            || skill instanceof GodOfTheSea
                            || skill instanceof SharkWave
                            || skill instanceof Thunderbolt
                            || skill instanceof ThunderboltFlash
                            || skill instanceof Typhoon
                            || skill instanceof WaterWave
                    )
            ) {
                addSkillEvent(continuousRing);
            }
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
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
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
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                getStart().setTime(current.getTime());
                getSkillEventList().add(new SkillEvent(thunderstrokeGiant, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            }
        }
    }
}
