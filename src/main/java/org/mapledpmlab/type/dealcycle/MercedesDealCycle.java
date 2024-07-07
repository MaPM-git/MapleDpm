package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.mercedes.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.mercedes.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MercedesDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackMercedes());
            add(new AdvancedStrikeDualShot());
            add(new ChargeDrive1());
            add(new ChargeDrive2());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new ElementalKnightsDark());
            add(new ElementalKnightsFlame());
            add(new ElementalKnightsFlameDot());
            add(new FormOfEurel());
            add(new GuidedArrow());
            add(new GustDive());
            add(new HighkickDemolition());
            add(new IrkallaBreathBeforeDelay());
            add(new IrkallaBreath());
            add(new IrkallaBreathAfterDelay());
            add(new LeafTornado());
            add(new LeafTornadoSpiritEnchant());
            add(new LegendarySpear());
            add(new LegendarySpearSpiritEnchant());
            add(new LightningEdge());
            add(new RingOfIshtar());
            add(new RollingMoonsault());
            add(new RoyalKnightsAttack());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new StigmaOfIshtar());
            add(new StigmaOfIshtarComplete());
            add(new SylphidiaRush());
            add(new UnfadingGloryImpact());
            add(new UnfadingGlorySpiritKingAttack());
            add(new UnfadingGlorySpiritKingAttackReinforce());
            add(new UnfadingGloryWave());
            add(new UnicornSpike());
            add(new WrathOfEnlil());
            add(new WrathOfEnlilSpiritEnchant());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(100.0));
            add(new ElementalGhost());
            add(new HeroesOath());
            add(new LegendarySpearBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new RoyalKnights());
            add(new SoulContract());
            add(new Sylphidia());
            add(new SylphidiaEnd());
            add(new UnfadingGlorySpiritKing());
            add(new UnicornSpikeBuff());
            //add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    FormOfEurel formOfEurel = new FormOfEurel();
    LeafTornadoSpiritEnchant leafTornadoSpiritEnchant = new LeafTornadoSpiritEnchant();
    LegendarySpearSpiritEnchant legendarySpearSpiritEnchant = new LegendarySpearSpiritEnchant();
    StigmaOfIshtar stigmaOfIshtar = new StigmaOfIshtar();
    StigmaOfIshtarComplete stigmaOfIshtarComplete = new StigmaOfIshtarComplete();
    UnfadingGlorySpiritKingAttack unfadingGlorySpiritKingAttack = new UnfadingGlorySpiritKingAttack();
    UnfadingGlorySpiritKingAttackReinforce unfadingGlorySpiritKingAttackReinforce = new UnfadingGlorySpiritKingAttackReinforce();
    WrathOfEnlilSpiritEnchant wrathOfEnlilSpiritEnchant = new WrathOfEnlilSpiritEnchant();

    Timestamp elementalGhostEndTime = new Timestamp(-1);
    Timestamp sylphidiaEndTime = new Timestamp(-1);
    Timestamp unfadingGloryEndTime = new Timestamp(-1);
    Timestamp unicornSpikeEndTime = new Timestamp(-1);

    Long stigmaCnt = 0L;
    Long accumulateCnt = 0L;

    boolean isUnfadingGlory = false;
    boolean isCriticalReinforce = false;

    public MercedesDealCycle(Job job) {
        super(job, new AdvancedFinalAttackMercedes());

        for (BuffSkill buffSkill : buffSkillList) {
            if (
                    buffSkill instanceof CriticalReinforce
                    || buffSkill instanceof MapleWorldGoddessBlessing
                    || buffSkill instanceof RoyalKnights
            ) {
                buffSkill.setDelay(buffSkill.getDelay() / 2);
            }
        }

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        AdvancedStrikeDualShot advancedStrikeDualShot = new AdvancedStrikeDualShot();
        ChargeDrive1 chargeDrive1 = new ChargeDrive1();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(100.0);
        ElementalGhost elementalGhost = new ElementalGhost();
        ElementalKnightsDark elementalKnightsDark = new ElementalKnightsDark();
        ElementalKnightsFlame elementalKnightsFlame = new ElementalKnightsFlame();
        GuidedArrow guidedArrow = new GuidedArrow();
        GustDive gustDive = new GustDive();
        HeroesOath heroesOath = new HeroesOath();
        HighkickDemolition highkickDemolition = new HighkickDemolition();
        IrkallaBreathBeforeDelay irkallaBreathBeforeDelay = new IrkallaBreathBeforeDelay();
        LeafTornado leafTornado = new LeafTornado();
        LegendarySpear legendarySpear = new LegendarySpear();
        LightningEdge lightningEdge = new LightningEdge();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        RestraintRing restraintRing = new RestraintRing();
        RingOfIshtar ringOfIshtar = new RingOfIshtar();
        RingSwitching ringSwitching = new RingSwitching();
        RoyalKnights royalKnights = new RoyalKnights();
        RollingMoonsault rollingMoonsault = new RollingMoonsault();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        Sylphidia sylphidia = new Sylphidia();
        SylphidiaEnd sylphidiaEnd = new SylphidiaEnd();
        SylphidiaRush sylphidiaRush = new SylphidiaRush();
        UnfadingGloryWave unfadingGloryWave = new UnfadingGloryWave();
        UnicornSpike unicornSpike = new UnicornSpike();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WrathOfEnlil wrathOfEnlil = new WrathOfEnlil();

        ringSwitching.setCooldown(180.0);

        mapleWorldGoddessBlessing.setDelay(mapleWorldGoddessBlessing.getDelay() / 2);
        royalKnights.setDelay(royalKnights.getDelay() / 2);
        criticalReinforce.setDelay(criticalReinforce.getDelay() / 2);
        elementalGhost.setDelay(elementalGhost.getDelay() / 2);

        addSkillEvent(elementalKnightsDark);
        addSkillEvent(elementalKnightsFlame);
        addSkillEvent(guidedArrow);
        addSkillEvent(unicornSpike);

        mapleWorldGoddessBlessing.setCooldown(180.0);

        legendarySpear.setDelayByAttackSpeed(870L);
        legendarySpearSpiritEnchant.setDelayByAttackSpeed(870L);
        wrathOfEnlil.setDelayByAttackSpeed(270L);
        wrathOfEnlilSpiritEnchant.setDelayByAttackSpeed(270L);
        leafTornado.setDelayByAttackSpeed(480L);
        leafTornadoSpiritEnchant.setDelayByAttackSpeed(480L);

        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(legendarySpear)
                    && cooldownCheck(elementalGhost)
                    && cooldownCheck(sylphidia)
                    && cooldownCheck(heroesOath)
                    && cooldownCheck(criticalReinforce)
                    && cooldownCheck(mapleWorldGoddessBlessing)
                    && cooldownCheck(royalKnights)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
                    && cooldownCheck(irkallaBreathBeforeDelay)
                    && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(heroesOath);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(ringOfIshtar);
                }
                addSkillEvent(legendarySpear);
                addSkillEvent(elementalGhost);
                addSkillEvent(sylphidia);
                addSkillEvent(criticalReinforce);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(royalKnights);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                if (cooldownCheck(unfadingGloryWave)) {
                    addSkillEvent(unfadingGloryWave);
                }
                addSkillEvent(irkallaBreathBeforeDelay);
                addSkillEvent(sylphidiaEnd);
            } else if (
                    cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(heroesOath.getActivateTime().getTime() + 30000))
            ) {
                addSkillEvent(soulContract);
            } else if (getStart().before(elementalGhostEndTime)) {
                // 엔릴 스듀샷 유니콘 레전 리프
                advancedStrikeDualShot = new AdvancedStrikeDualShot();
                advancedStrikeDualShot.setDelayByAttackSpeed(450L);
                unicornSpike.setDelayByAttackSpeed(600L);
                addSkillEvent(wrathOfEnlil);
                addSkillEvent(advancedStrikeDualShot);
                addSkillEvent(unicornSpike);
                addSkillEvent(advancedStrikeDualShot);
                addSkillEvent(legendarySpear);
                addSkillEvent(leafTornado);
            } else if (getStart().after(unicornSpikeEndTime)) {
                unicornSpike = new UnicornSpike();
                addSkillEvent(unicornSpike);
            } else if (cooldownCheck(wrathOfEnlil)) {
                advancedStrikeDualShot = new AdvancedStrikeDualShot();
                advancedStrikeDualShot.setDelayByAttackSpeed(630L);
                addSkillEvent(wrathOfEnlil);
                addSkillEvent(advancedStrikeDualShot);
            } else {
                addSkillEvent(ringOfIshtar);
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
            if (skill instanceof UnicornSpikeBuff) {
                unicornSpikeEndTime = new Timestamp(getStart().getTime() + 60000);
            }
            if (skill instanceof SylphidiaEnd) {
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (getSkillEventList().get(i).getSkill() instanceof Sylphidia) {
                        getSkillEventList().get(i).setEnd(new Timestamp(getStart().getTime()));
                        sylphidiaEndTime = new Timestamp(getStart().getTime());
                        break;
                    }
                }
            }
            if (skill instanceof ElementalGhost) {
                elementalGhostEndTime = new Timestamp(getStart().getTime() + 90 * 1000);
            } else if (skill instanceof Sylphidia) {
                sylphidiaEndTime = new Timestamp(getStart().getTime() + 25 * 1000);
            } else if (skill instanceof UnfadingGlorySpiritKing) {
                unfadingGloryEndTime = new Timestamp(getStart().getTime() + 60 * 1000);
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
            if (
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
            if (
                    skill instanceof LeafTornado
                    && cooldownCheck(leafTornadoSpiritEnchant)
            ) {
                skill = leafTornadoSpiritEnchant;
            }
            if (
                    skill instanceof LegendarySpear
                    && cooldownCheck(legendarySpearSpiritEnchant)
            ) {
                skill = legendarySpearSpiritEnchant;
            }
            if (
                    skill instanceof WrathOfEnlil
                    && cooldownCheck(wrathOfEnlilSpiritEnchant)
            ) {
                skill = wrathOfEnlilSpiritEnchant;
            }
            if (
                    getStart().before(elementalGhostEndTime)
                    && (
                            skill instanceof ChargeDrive1
                            || skill instanceof GustDive
                            || skill instanceof HighkickDemolition
                            || skill instanceof LeafTornado
                            || skill instanceof LegendarySpear
                            || skill instanceof LightningEdge
                            || skill instanceof RollingMoonsault
                            || skill instanceof UnicornSpike
                            || skill instanceof WrathOfEnlil
                    )
            ) {
                formOfEurel.setActivateTime(new Timestamp(formOfEurel.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof AdvancedStrikeDualShot
                    || skill instanceof ChargeDrive1
                    || skill instanceof ChargeDrive2
                    || skill instanceof GustDive
                    || skill instanceof HighkickDemolition
                    || skill instanceof LeafTornado
                    || skill instanceof LeafTornadoSpiritEnchant
                    || skill instanceof LegendarySpear
                    || skill instanceof LegendarySpearSpiritEnchant
                    || skill instanceof LightningEdge
                    || skill instanceof RollingMoonsault
                    || skill instanceof UnicornSpike
                    || skill instanceof WrathOfEnlil
                    || skill instanceof WrathOfEnlilSpiritEnchant
            ) {
                stigmaCnt += 2;
            } else if (skill instanceof RingOfIshtar) {
                stigmaCnt += 1;
            }
            if (
                    cooldownCheck(formOfEurel)
                    && getStart().before(elementalGhostEndTime)
            ) {
                getSkillEventList().add(new SkillEvent(formOfEurel, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                getEventTimeList().add(new Timestamp(getStart().getTime()));
                applyCooldown(formOfEurel);
            }
            if (
                    cooldownCheck(unfadingGlorySpiritKingAttack)
                    && getStart().before(unfadingGloryEndTime)
                    && !(skill instanceof UnfadingGlorySpiritKingAttack)
                    && !(skill instanceof UnfadingGlorySpiritKingAttackReinforce)
            ) {
                if (isUnfadingGlory) {
                    addSkillEvent(unfadingGlorySpiritKingAttackReinforce);
                    unfadingGlorySpiritKingAttack.setActivateTime(new Timestamp(unfadingGlorySpiritKingAttackReinforce.getActivateTime().getTime()));
                    isUnfadingGlory = false;
                } else {
                    addSkillEvent(unfadingGlorySpiritKingAttack);
                    unfadingGlorySpiritKingAttackReinforce.setActivateTime(new Timestamp(unfadingGlorySpiritKingAttack.getActivateTime().getTime()));
                    isUnfadingGlory = false;
                }
            }
            if (stigmaCnt >= 12) {
                accumulateCnt ++;
                if (accumulateCnt >= 5) {
                    getSkillEventList().add(new SkillEvent(stigmaOfIshtarComplete, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                    getEventTimeList().add(new Timestamp(getStart().getTime()));
                    isUnfadingGlory = true;
                    accumulateCnt = 0L;
                    stigmaCnt = 0L;
                } else {
                    getSkillEventList().add(new SkillEvent(stigmaOfIshtar, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                    getEventTimeList().add(new Timestamp(getStart().getTime()));
                    stigmaCnt = 0L;
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
                this.getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof RoyalKnightsAttack) {
                        i = 0;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        if (skill instanceof RoyalKnightsAttack) {
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
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
                        if (
                                getStart().before(elementalGhostEndTime)
                                && getStart().after(sylphidiaEndTime)
                                && skill instanceof IrkallaBreath
                        ) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            IrkallaBreath temp = new IrkallaBreath();
                            temp.addFinalDamage(0.75);
                            if (ran <= 45) {
                                getSkillEventList().add(new SkillEvent(temp, new Timestamp(getStart().getTime() + temp.getInterval()), new Timestamp(getStart().getTime() + temp.getInterval() * 2)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + temp.getInterval() * 2));
                                stigmaCnt ++;
                                ran = (long) (Math.random() * 99 + 1);
                                if (ran <= 35) {
                                    getSkillEventList().add(new SkillEvent(temp, new Timestamp(getStart().getTime() + temp.getInterval() * 2), new Timestamp(getStart().getTime() + temp.getInterval() * 3)));
                                    getEventTimeList().add(new Timestamp(getStart().getTime() + temp.getInterval() * 3));
                                    stigmaCnt ++;
                                    ran = (long) (Math.random() * 99 + 1);
                                    if (ran <= 25) {
                                        getSkillEventList().add(new SkillEvent(temp, new Timestamp(getStart().getTime() + temp.getInterval() * 3), new Timestamp(getStart().getTime() + temp.getInterval() * 4)));
                                        getEventTimeList().add(new Timestamp(getStart().getTime() + temp.getInterval() * 4));
                                        stigmaCnt ++;
                                    }
                                }
                            }
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
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof AdvancedStrikeDualShot
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    AdvancedStrikeDualShot tmp = new AdvancedStrikeDualShot();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof ChargeDrive1
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    ChargeDrive1 tmp = new ChargeDrive1();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof ChargeDrive2
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    ChargeDrive2 tmp = new ChargeDrive2();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof GustDive
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    GustDive tmp = new GustDive();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof HighkickDemolition
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    HighkickDemolition tmp = new HighkickDemolition();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof LeafTornado
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    LeafTornado tmp = new LeafTornado();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof LeafTornadoSpiritEnchant
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    LeafTornadoSpiritEnchant tmp = new LeafTornadoSpiritEnchant();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof LegendarySpear
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    LegendarySpear tmp = new LegendarySpear();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof LegendarySpearSpiritEnchant
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    LegendarySpearSpiritEnchant tmp = new LegendarySpearSpiritEnchant();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof LightningEdge
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    LightningEdge tmp = new LightningEdge();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof RollingMoonsault
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    RollingMoonsault tmp = new RollingMoonsault();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof UnicornSpike
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    UnicornSpike tmp = new UnicornSpike();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof WrathOfEnlil
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    WrathOfEnlil tmp = new WrathOfEnlil();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof WrathOfEnlilSpiritEnchant
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    WrathOfEnlilSpiritEnchant tmp = new WrathOfEnlilSpiritEnchant();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 90) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt += 2;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 70) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt += 2;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt += 2;
                            }
                        }
                    }
                }
                if (
                        getStart().before(elementalGhostEndTime)
                        && getStart().after(sylphidiaEndTime)
                        && skill instanceof RingOfIshtar
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    RingOfIshtar tmp = new RingOfIshtar();
                    tmp.addFinalDamage(0.75);
                    if (ran <= 45) {
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay()), new Timestamp(getStart().getTime() + tmp.getDelay() * 2)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 2));
                        stigmaCnt ++;
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 35) {
                            getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 2), new Timestamp(getStart().getTime() + tmp.getDelay() * 3)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 3));
                            stigmaCnt ++;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 25) {
                                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(getStart().getTime() + tmp.getDelay() * 3), new Timestamp(getStart().getTime() + tmp.getDelay() * 4)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + tmp.getDelay() * 4));
                                stigmaCnt ++;
                            }
                        }
                    }
                }
            }
        }
        applyCooldown(skill);
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        if (
                skill instanceof BuffSkill
                && getStart().before(sylphidiaEndTime)
        ) {
            getStart().setTime(getStart().getTime() + skill.getDelay() / 2);
        } else {
            getStart().setTime(getStart().getTime() + skill.getDelay());
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
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof CriticalReinforce) {
                    isCriticalReinforce = true;
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
                buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
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
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            isCriticalReinforce = false;
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
        if (isCriticalReinforce) {
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP());
            buffSkill.addBuffCriticalDamage(criticalReinforce.getBuffCriticalDamage());
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
                    attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat()) * 0.01
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
        if (isCriticalReinforce) {
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP());
            buffSkill.addBuffCriticalDamage(-criticalReinforce.getBuffCriticalDamage());
        }
        return attackDamage;
    }
}
