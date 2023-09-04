package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.soulmaster.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.soulmaster.AstralBlitzBuff;
import org.mapledpmlab.type.skill.buffskill.soulmaster.CosmicForge;
import org.mapledpmlab.type.skill.buffskill.soulmaster.Elysion;
import org.mapledpmlab.type.skill.buffskill.soulmaster.TrueSight;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SoulMasterDealCycle extends DealCycle {

    /*
     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레, 초시축
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 극딜 마지막, 6차 포함
    private List<Skill> final1 = new ArrayList<>();

    // 극딜 마지막
    private List<Skill> final2 = new ArrayList<>();

    private List<AttackSkill> mainAttack = new ArrayList<>(){
        {
            add(new LunarDivide());
            add(new SolarSlash());
        }
    };

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AstralBlitz1());
            add(new AstralBlitz2());
            add(new AuraWeaponDot());
            add(new CosmicBurst(0L));
            add(new CosmicBurstAfterSecond(0L));
            add(new CosmicShower(0L));
            add(new Cosmos(0L));
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CrossTheStyx());
            add(new CygnusPhalanx());
            add(new FlareSlash());
            add(new LunarDivide());
            add(new Shatter());
            add(new SolarSlash());
            add(new SolunarDivide());
            add(new SoulEclipse());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new AstralBlitzDelay());
            add(new CosmicShowerDelay());
            add(new CosmosDelay());
            add(new CrossTheStyxDelay());
            add(new CygnusPhalanxDelay());
            add(new SolunarDivideDelay());
            add(new SoulEclipseDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AstralBlitzBuff());
            add(new AuraWeaponBuff());
            add(new CosmicForge());
            add(new Elysion());
            add(new GloryOfGuardians());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new TranscendentCygnusBlessing(0L));
            add(new TrueSight());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    private CosmicBurst cosmicBurst5 = new CosmicBurst(5L);
    private CosmicBurst cosmicBurst10 = new CosmicBurst(10L);
    private FlareSlash flareSlash = new FlareSlash();
    private Shatter shatter = new Shatter();
    private int cosmicOrbCount = 0;
    private Timestamp cosmicForgeEndTime = null;

    public SoulMasterDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AstralBlitzBuff astralBlitzBuff = new AstralBlitzBuff();
        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        CosmicForge cosmicForge = new CosmicForge();
        CosmicShower cosmicShower5 = new CosmicShower(5L);
        CosmicShower cosmicShower10 = new CosmicShower(10L);
        Cosmos cosmos5 = new Cosmos(5L);
        Cosmos cosmos10 = new Cosmos(10L);
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrossTheStyx crossTheStyx = new CrossTheStyx();
        CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
        Elysion elysion = new Elysion();
        GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
        LunarDivide lunarDivide = new LunarDivide();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SolarSlash solarSlash = new SolarSlash();
        SolunarDivide solunarDivide = new SolunarDivide();
        SoulContract soulContract = new SoulContract();
        SoulEclipse soulEclipse = new SoulEclipse();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        TrueSight trueSight = new TrueSight();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        // 극딜 예열
        dealCycle1.add(gloryOfGuardians);
        dealCycle1.add(cosmicForge);
        dealCycle1.add(trueSight);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(transcendentCygnusBlessing);
        dealCycle1.add(soulEclipse);
        dealCycle1.add(cygnusPhalanx);
        dealCycle1.add(elysion);
        dealCycle1.add(crossTheStyx);
        dealCycle1.add(cosmicShower10);

        // 예열 후 사용(6차)
        final1.add(crossTheStyx);
        final1.add(cosmos10);
        final1.add(soulContract);
        final1.add(restraintRing);
        final1.add(astralBlitzBuff);
        for (int i = 0; i < 9; i++) {
            final1.add(crossTheStyx);
        }
        final1.add(solunarDivide);

        // 극딜 예열
        dealCycle2.add(gloryOfGuardians);
        dealCycle2.add(cosmicForge);
        dealCycle2.add(trueSight);
        dealCycle2.add(transcendentCygnusBlessing);
        dealCycle2.add(soulEclipse);
        dealCycle2.add(cygnusPhalanx);
        dealCycle2.add(elysion);
        dealCycle2.add(crossTheStyx);
        dealCycle2.add(cosmicShower10);

        // 예열 후 사용
        final2.add(crossTheStyx);
        final2.add(cosmos10);
        final2.add(soulContract);
        final2.add(restraintRing);
        for (int i = 0; i < 21; i++) {
            final2.add(crossTheStyx);
        }
        final2.add(solunarDivide);

        // 준극딜
        dealCycle3.add(trueSight);
        dealCycle3.add(cosmos5);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);

        int mainAttackChk = 0;
        int finalChk = 0;
        Timestamp soulEclipseEndTime = null;
        Timestamp elysionEndTime = null;

        while (getStart().before(getEnd())) {
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                cosmicForgeEndTime = new Timestamp(getStart().getTime() + 60000);
                addDealCycle(dealCycle1);
                soulEclipseEndTime = new Timestamp(getStart().getTime() + 40000 + 3420 - 1290 - 16000);
                elysionEndTime = new Timestamp(getStart().getTime() + 40000 + 3420 + 1140);
                cosmicShower5.setActivateTime(cosmicShower10.getActivateTime());
                finalChk = 0;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                cosmicForgeEndTime = new Timestamp(getStart().getTime() + 60000);
                addDealCycle(dealCycle2);
                soulEclipseEndTime = new Timestamp(getStart().getTime() + 40000 + 2040 - 1290 - 16000);
                elysionEndTime = new Timestamp(getStart().getTime() + 40000 + 2040 + 1140);
                cosmicShower5.setActivateTime(cosmicShower10.getActivateTime());
                finalChk = 1;
            } else if (
                    cooldownCheck(dealCycle3)
                    && cosmicOrbCount % 5 == 0
            ) {
                addDealCycle(dealCycle3);
                cosmos10.setActivateTime(cosmos5.getActivateTime());
            } else if (
                    getStart().after(soulEclipseEndTime)
                    && finalChk == 0
            ) {
                addDealCycle(final1);
                cosmos5.setActivateTime(cosmos10.getActivateTime());
                finalChk = 2;
            } else if (
                    getStart().after(soulEclipseEndTime)
                    && finalChk == 1
            ) {
                addDealCycle(final2);
                cosmos5.setActivateTime(cosmos10.getActivateTime());
                finalChk = 2;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(cosmicShower5)
                    && cosmicOrbCount % 5 == 0
                    && getStart().before(new Timestamp(cosmicForge.getActivateTime().getTime() - 50000))
            ) {
                addSkillEvent(cosmicShower5);
            } else if (
                    cooldownCheck(cygnusPhalanx)
                    && getStart().before(new Timestamp(cosmicForge.getActivateTime().getTime() - 20000))
            ) {
                addSkillEvent(cygnusPhalanx);
            } else if (
                    getStart().before(elysionEndTime)
            ) {
                cosmicOrbCount = 10;
                addSkillEvent(crossTheStyx);
                flareSlash.setActivateTime(new Timestamp(flareSlash.getActivateTime().getTime() - 12000));
            } else {
                cosmicOrbCount ++;
                addSkillEvent(mainAttack.get(mainAttackChk % 2));
                flareSlash.setActivateTime(new Timestamp(flareSlash.getActivateTime().getTime() - 8000));
                mainAttackChk ++;
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
                if (skill instanceof TranscendentCygnusBlessing) {
                    for (long i = 0; i < 45000; i += 4000) {
                        getSkillEventList().add(new SkillEvent(new TranscendentCygnusBlessing(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 4000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 4000));
                    }
                } else {
                    endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (((AttackSkill) skill).getInterval() != 0) {
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
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                if (!(skill instanceof FlareSlash) && cooldownCheck(flareSlash)) {
                    addSkillEvent(flareSlash);
                }
                if (skill instanceof CrossTheStyx && cooldownCheck(shatter)) {
                    addSkillEvent(shatter);
                }
                if (
                        (skill instanceof SolarSlash || skill instanceof LunarDivide || skill instanceof CrossTheStyx)
                        && cooldownCheck(cosmicBurst5)
                ) {
                    if (getStart().before(cosmicForgeEndTime)) {
                        if (cooldownCheck(cosmicBurst10) && cosmicOrbCount % 10 == 0) {
                            addSkillEvent(cosmicBurst10);
                            cosmicBurst5.setActivateTime(cosmicBurst10.getActivateTime());
                        }
                    } else {
                        if (cooldownCheck(cosmicBurst5) && cosmicOrbCount % 5 == 0) {
                            addSkillEvent(cosmicBurst5);
                            cosmicBurst10.setActivateTime(cosmicBurst5.getActivateTime());
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
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }
}
