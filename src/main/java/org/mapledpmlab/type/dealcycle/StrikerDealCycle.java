package org.mapledpmlab.type.dealcycle;

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

    // 리레, 스인미, 크오솔
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 웨펖, 초시축
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 웨펖
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 극딜 마지막, 6차 포함
    private List<Skill> final1 = new ArrayList<>();

    // 극딜 마지막
    private List<Skill> final2 = new ArrayList<>();

    // 극딜 마지막
    private List<Skill> final3 = new ArrayList<>();

    // 극딜 마지막
    private List<Skill> final4 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new Annihilation());
            add(new CreateThunderChain());
            add(new CreateThunderChainFinal());
            add(new CreateThunderChainHugeLightning());
            add(new CreateThunderChainLightning());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new CygnusPhalanxDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CreationOfTheWorld());
            add(new GloryOfGuardians());
            add(new LightningUnion());
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new TranscendentCygnusBlessing(0L));
            add(new TyphoonBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    CreateThunderChainHugeLightning createThunderChainHugeLightning = new CreateThunderChainHugeLightning();
    CreateThunderChainLightning createThunderChainLightning = new CreateThunderChainLightning();
    private Lightning lightning = new Lightning();
    private LightningGodSpearStrike lightningGodSpearStrike = new LightningGodSpearStrike();
    private SeaWave seaWave = new SeaWave();
    private SharkWave sharkWave = new SharkWave();
    Thunderstroke thunderstroke = new Thunderstroke();
    ThunderstrokeGiant thunderstrokeGiant = new ThunderstrokeGiant();

    private int lightningGodSpearStrikeCount = 0;
    private int linkCount = 0;
    private int seaWaveCount = 0;
    private int sharkWaveCount = 0;

    private Timestamp creationOfTheWorldEndTime = new Timestamp(-1);
    boolean isThunderStroke = false;

    public StrikerDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        Annihilation annihilation = new Annihilation();
        CreateThunderChain createThunderChain = new CreateThunderChain();
        CreationOfTheWorld creationOfTheWorld = new CreationOfTheWorld();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
        GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
        GodOfTheSea godOfTheSea = new GodOfTheSea();
        LightningUnion lightningUnion = new LightningUnion();
        Overdrive overdrive = new Overdrive(255L);
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        Thunderbolt thunderbolt = new Thunderbolt();
        ThunderboltFlash thunderboltFlash = new ThunderboltFlash();
        ThunderBreakTheSea thunderBreakTheSea = new ThunderBreakTheSea();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        Typhoon typhoon = new Typhoon();
        WaterWave waterWave = new WaterWave();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        // 리스트레인트 극딜 예열 - F1
        dealCycle1.add(gloryOfGuardians);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(lightningUnion);

        // 웨폰퍼프, 초시축 극딜 예열 - F2
        dealCycle2.add(gloryOfGuardians);
        dealCycle2.add(lightningUnion);

        // 웨폰퍼프 - F2
        dealCycle3.add(gloryOfGuardians);
        dealCycle3.add(lightningUnion);

        // 예열 후 사용(리레/6차)
        final1.add(overdrive);
        final1.add(soulContract);
        final1.add(restraintRing);
        final1.add(sharkWave);
        final1.add(waterWave);
        final1.add(thunderBreakTheSea);
        final1.add(createThunderChain);
        final1.add(creationOfTheWorld);

        // 예열 후 사용(리레)
        final2.add(overdrive);
        final2.add(soulContract);
        final2.add(restraintRing);
        final2.add(sharkWave);
        final2.add(waterWave);
        final2.add(createThunderChain);
        final2.add(creationOfTheWorld);

        // 예열 후 사용(웨퍼/6차)
        final3.add(overdrive);
        final3.add(soulContract);
        final3.add(weaponJumpRing);
        final3.add(sharkWave);
        final3.add(waterWave);
        final3.add(thunderBreakTheSea);
        final3.add(createThunderChain);
        final3.add(creationOfTheWorld);

        // 예열 후 사용(웨퍼)
        final4.add(overdrive);
        final4.add(soulContract);
        final4.add(weaponJumpRing);
        final4.add(sharkWave);
        final4.add(waterWave);
        final4.add(createThunderChain);
        final4.add(creationOfTheWorld);

        int finalChk = 0;
        int dealCycleOrder = 1;

        getStart().setTime(-25000);
        transcendentCygnusBlessing.setCooldown(260.0);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);
        while (getStart().before(getEnd())) {
            if (cooldownCheck(cygnusPhalanx)) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(transcendentCygnusBlessing)
            ) {
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && (dealCycleOrder == 1 || dealCycleOrder == 3 || dealCycleOrder == 5)
                    && cooldownCheck(final2)
            ) {
                addDealCycle(dealCycle1);
                if (dealCycleOrder == 1) {
                    finalChk = 1;
                }
                if (dealCycleOrder == 3 || dealCycleOrder == 5) {
                    finalChk = 2;
                }
                if (dealCycleOrder == 3) {
                    transcendentCygnusBlessing.setCooldown(150.0);
                }
                if (dealCycleOrder == 5) {
                    transcendentCygnusBlessing.setCooldown(720.0);
                }
                dealCycleOrder++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && dealCycleOrder == 4
                    && cooldownCheck(final3)
            ) {
                transcendentCygnusBlessing.setCooldown(720.0);
                addDealCycle(dealCycle2);
                finalChk = 3;
                dealCycleOrder++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
                    && cooldownCheck(final4)
            ) {
                transcendentCygnusBlessing.setCooldown(120.0);
                addDealCycle(dealCycle3);
                finalChk = 4;
                dealCycleOrder++;
            } else if (
                    finalChk == 1
                    && cooldownCheck(final1)
            ) {
                addDealCycle(final1);
                finalChk = 0;
            } else if (
                    finalChk == 2
                    && cooldownCheck(final2)
            ) {
                addDealCycle(final2);
                finalChk = 0;
            } else if (
                    finalChk == 3
                    && cooldownCheck(final3)
            ) {
                addDealCycle(final3);
                finalChk = 0;
            } else if (
                    finalChk == 4
                    && cooldownCheck(final4)
            ) {
                addDealCycle(final4);
                finalChk = 0;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(overdrive)
                    && cooldownCheck(soulContract)
                    && ((double) getStart().getTime() / 120 / 1000 % 1 < 0.75)
                    && ((double) getStart().getTime() / 120 / 1000 % 1 > 0.3)
            ) {
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(godOfTheSea)
            ) {
                addSkillEvent(godOfTheSea);
            } else if (
                    cooldownCheck(sharkWave)
                    && finalChk == 0
                    && ((double) getStart().getTime() / 120 / 1000 % 1 < 1)
                    && ((double) getStart().getTime() / 120 / 1000 % 1 > 0.07)
            ) {
                addSkillEvent(sharkWave);
            } else if (
                    getStart().before(creationOfTheWorldEndTime)
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
        if (seaWaveCount < 4) {
            seaWave.setActivateTime(new Timestamp(seaWave.getActivateTime().getTime() - 1500));
            seaWaveCount ++;
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime()) && getStart().after(new Timestamp(0))) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof CreationOfTheWorld) {
                creationOfTheWorldEndTime = new Timestamp(getStart().getTime() + 30000);
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
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (skill instanceof SeaWave) {
                seaWaveCount = 0;
            }
            if (skill instanceof LightningGodSpearStrike) {
                lightningGodSpearStrikeCount = 0;
            }
            if (skill instanceof SharkWave) {
                sharkWaveCount = 0;
            }
            if (skill instanceof Annihilation && !isThunderStroke) {
                isThunderStroke = true;
            }
            if (
                    isThunderStroke
                    && (
                            skill instanceof Thunderbolt
                            || skill instanceof ThunderboltFlash
                            || skill instanceof GodOfTheSea
                    )
            ) {
                addSkillEvent(thunderstroke);
                isThunderStroke = false;
            }
            if (
                    isThunderStroke
                    && (
                            skill instanceof Typhoon
                            || skill instanceof SharkWave
                            || skill instanceof LightningGodSpearStrike
                            || skill instanceof CreateThunderChain
                            || skill instanceof ThunderBreakTheSea
                    )
            ) {
                addSkillEvent(thunderstrokeGiant);
                isThunderStroke = false;
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
                    || skill instanceof CreateThunderChain
                    || skill instanceof CreateThunderChainFinal
                    || skill instanceof GodOfTheSea
                    || skill instanceof SharkWave
                    || skill instanceof Thunderbolt
                    || skill instanceof ThunderBreakTheSea
                    || skill instanceof ThunderBreakTheSeaFinal
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
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        if (skill instanceof CreateThunderChain) {
                            getSkillEventList().add(new SkillEvent(createThunderChainLightning, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + i));
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
}
