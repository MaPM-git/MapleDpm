package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
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
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new CygnusPhalanxDelay());
            add(new CygnusPhalanx());
            add(new FlareSlash());
            add(new LunarDivide());
            add(new Shatter());
            add(new SolarSlash());
            add(new SolunarDivide());
            add(new SolunarPower());
            add(new SolunarPower2());
            add(new SolunarSlash());
            add(new SoulEclipse());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AstralBlitzBuff());
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new CosmicForge());
            add(new Elysion());
            add(new GloryOfGuardians());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new TranscendentCygnusBlessing(0L));
            add(new TrueSight());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int cosmicOrbCount = 0;
    int mainAttackChk = 0;
    int shatterCount = 0;

    Timestamp cosmicForgeEndTime = null;
    Timestamp elysionEndTime = new Timestamp(-1);
    Timestamp restraintRingEndTimestamp = new Timestamp(-1);
    Timestamp soulEclipseEndTime = null;
    Timestamp trueSightEndTime = new Timestamp(-1);
    Timestamp blessBurnTime = new Timestamp(-1);

    private final List<AttackSkill> mainAttack = new ArrayList<>(){
        {
            add(new LunarDivide());
            add(new SolarSlash());
        }
    };

    AstralBlitzBuff astralBlitzBuff = new AstralBlitzBuff();
    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    CosmicBurst cosmicBurst5 = new CosmicBurst(5L);
    CosmicBurst cosmicBurst10 = new CosmicBurst(10L);
    CosmicForge cosmicForge = new CosmicForge();
    CosmicShower cosmicShower5 = new CosmicShower(5L);
    CosmicShower cosmicShower10 = new CosmicShower(10L);
    Cosmos cosmos5 = new Cosmos(5L);
    Cosmos cosmos10 = new Cosmos(10L);
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CrossTheStyx crossTheStyx = new CrossTheStyx();
    CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
    Elysion elysion = new Elysion();
    FlareSlash flareSlash = new FlareSlash();
    GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    Shatter shatter = new Shatter();
    SolunarDivide solunarDivide = new SolunarDivide();
    SolunarPower solunarPower = new SolunarPower();
    SolunarSlash solunarSlash = new SolunarSlash();
    SoulContract soulContract = new SoulContract();
    SoulEclipse soulEclipse = new SoulEclipse();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
    TrueSight trueSight = new TrueSight();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public SoulMasterDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ((AttackSkill) auraWeaponBuff.getRelatedSkill()).addFinalDamage(0.9);
        ((AttackSkill) auraWeaponBuff.getRelatedSkill()).setAttackCount(((AttackSkill) auraWeaponBuff.getRelatedSkill()).getAttackCount() * 2);

        ringSwitching.setCooldown(90.0);
        auraWeaponBuff.setCooldown(180.0);
        transcendentCygnusBlessing.setCooldown(180.0);

        getSkillSequence1().add(transcendentCygnusBlessing);
        getSkillSequence1().add(auraWeaponBuff);
        getSkillSequence1().add(gloryOfGuardians);              // 30
        getSkillSequence1().add(cosmicForge);
        getSkillSequence1().add(elysion);
        getSkillSequence1().add(trueSight);                     // 600

        getSkillSequence2().add(bodyOfSteel);
        getSkillSequence2().add(soulContract);
        getSkillSequence2().add(restraintRing);

        transcendentCygnusBlessing.setDelay(90L);
        auraWeaponBuff.setDelay(90L);
        cosmicForge.setDelay(90L);
        elysion.setDelay(90L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(trueSightEndTime)
                    && getStart().after(new Timestamp(10 * 1000))
            ) {
                addSkillEvent(trueSight);
            }
            if (
                    cooldownCheck(cygnusPhalanx)
                    && getStart().after(elysionEndTime)
            ) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(transcendentCygnusBlessing)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                cosmicShower10.setActivateTime(new Timestamp(-1));
                addSkillEvent(cosmicShower10);
                blessBurnTime = new Timestamp(getStart().getTime() + 21000);
                addDealCycle(getSkillSequence1());
                addSkillEvent(soulEclipse);
            }
            if (
                    getStart().after(blessBurnTime)
                            && getStart().before(new Timestamp(600 * 1000))
            ) {
                blessBurnTime = new Timestamp(transcendentCygnusBlessing.getActivateTime().getTime());
                addDealCycle(getSkillSequence2());
                addSkillEvent(cosmos10);
                addSkillEvent(crossTheStyx);
                if (cooldownCheck(astralBlitzBuff)) {
                    addSkillEvent(astralBlitzBuff);
                    for (int i = 0; i < 10; i++) {
                        addSkillEvent(crossTheStyx);
                    }
                } else {
                    for (int i = 0; i < 21; i++) {
                        addSkillEvent(crossTheStyx);
                    }
                }
                addSkillEvent(solunarDivide);
                cosmicShower5.setActivateTime(cosmicShower10.getActivateTime());
                cosmos5.setActivateTime(cosmos10.getActivateTime());
            } else if (
                    cooldownCheck(cosmos5)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(weaponJumpRing)
                            && cosmicOrbCount >= 5
                            && getStart().after(new Timestamp(60 * 1000))
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(cosmos5);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                cosmos10.setActivateTime(cosmos5.getActivateTime());
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(70 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(cosmicShower5)
                            && cosmicOrbCount == 5
                            && !cooldownCheck(cosmicForge)
            ) {
                addSkillEvent(cosmicShower5);
                cosmicShower10.setActivateTime(cosmicShower5.getActivateTime());
            } else if (
                    getStart().before(elysionEndTime)
            ) {
                addSkillEvent(crossTheStyx);
            } else {
                addSkillEvent(mainAttack.get(mainAttackChk % 2));
                mainAttackChk ++;
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
        if (
                skill instanceof CosmicShower
                || skill instanceof CosmicBurst
                || skill instanceof Cosmos
        ) {
            cosmicOrbCount = 0;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof TrueSight) {
                trueSightEndTime = new Timestamp(getStart().getTime() + 50000);
            }
            if (skill instanceof CosmicForge) {
                cosmicForgeEndTime = new Timestamp(getStart().getTime() + 60000);
            }
            if (skill instanceof Elysion) {
                elysionEndTime = new Timestamp(getStart().getTime() + 3000 + 40000);
            }
            if (skill instanceof RestraintRing) {
                restraintRingEndTimestamp = new Timestamp(getStart().getTime() + 15000);
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
            if (skill instanceof SolunarDivide) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                                    && skillEvent.getSkill() instanceof SoulEclipse
                    ) {
                        remove.add(skillEvent);
                    }
                }
                this.getSkillEventList().removeAll(remove);
            }
            if (skill instanceof CrossTheStyx) {
                cosmicOrbCount = 10;
                flareSlash.setActivateTime(new Timestamp(flareSlash.getActivateTime().getTime() - 1200));
            }
            if (
                    skill instanceof SolarSlash
                    || skill instanceof LunarDivide
            ) {
                cosmicOrbCount ++;
                flareSlash.setActivateTime(new Timestamp(flareSlash.getActivateTime().getTime() - 800));
            }
            if (
                    getStart().before(elysionEndTime)
                    && cooldownCheck(shatter)
                    && skill instanceof CrossTheStyx
            ) {
                shatterCount ++;
                if (shatterCount == 6) {
                    addSkillEvent(shatter);
                    shatterCount = 0;
                }
            }
            if (
                    skill instanceof CrossTheStyx
                    || skill instanceof SolarSlash
                    || skill instanceof LunarDivide
            ) {
                if (cooldownCheck(solunarPower)) {
                    addSkillEvent(solunarPower);
                }
                if (cooldownCheck(flareSlash)) {
                    addSkillEvent(flareSlash);
                }
                if (cooldownCheck(cosmicBurst5)) {
                    if (getStart().before(cosmicForgeEndTime)) {
                        if (cosmicOrbCount >= 10) {
                            addSkillEvent(cosmicBurst10);
                            cosmicBurst5.setActivateTime(cosmicBurst10.getActivateTime());
                        }
                    } else {
                        if (cosmicOrbCount >= 5) {
                            addSkillEvent(cosmicBurst5);
                            cosmicBurst10.setActivateTime(cosmicBurst5.getActivateTime());
                        }
                    }
                }
            }
            if (skill instanceof SoulEclipse) {
                soulEclipseEndTime = new Timestamp(getStart().getTime() + 24000);
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
                    if (skill instanceof SoulEclipse) {
                        i = 1080;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
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
                if (
                        skill instanceof CrossTheStyx
                        && cooldownCheck(cosmicBurst5)
                ) {
                    if (getStart().before(cosmicForgeEndTime)) {
                        if (cosmicOrbCount >= 10) {
                            addSkillEvent(cosmicBurst10);
                            cosmicBurst5.setActivateTime(cosmicBurst10.getActivateTime());
                        }
                    } else {
                        if (cosmicOrbCount >= 5) {
                            addSkillEvent(cosmicBurst5);
                            cosmicBurst10.setActivateTime(cosmicBurst5.getActivateTime());
                        }
                    }
                }
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
        if (
                cooldownCheck(solunarSlash)
                && (
                        skill instanceof CygnusPhalanxDelay             //780
                        //|| skill instanceof Elysion                     //750
                        //|| skill instanceof CosmicForge                 //810
                        //|| skill instanceof AuraWeaponBuff              //720
                        //|| skill instanceof TranscendentCygnusBlessing  //630
                        //|| skill instanceof BodyOfSteel                 //720
                        //|| skill instanceof TrueSight                   //600
                )
                && getStart().after(restraintRingEndTimestamp)
        ) {
            addSkillEvent(solunarSlash);
        } else {
            getStart().setTime(getStart().getTime() + skill.getDelay());
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }
}
