package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.mihile.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.mihile.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MihileDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackMihile());
            add(new AuraWeaponDot());
            add(new ClaimhSolais());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanxDelay());
            add(new CygnusPhalanx());
            add(new DeadlyCharge());
            add(new Durandal1());
            add(new Durandal2());
            add(new Durandal3());
            add(new InstallShield());
            add(new LightForceRei());
            add(new PhotonShockwave());
            add(new PhotonWave());
            add(new RoyalGuard());
            add(new ShiningCrossAssault());
            add(new SoulLightSlash());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SwordOfSoulLight());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new GloryOfGuardians());
            add(new GuardOfLight());
            add(new LightOfCourage());
            add(new RestraintRing());
            add(new RhoAias());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SoulMajesty());
            add(new SwordOfSoulLightBuff());
            add(new TranscendentCygnusBlessing(0L));
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    private Timestamp soulMajestyEndTime = new Timestamp(-1);
    Timestamp swordOfSoulLightEndTime = null;

    PhotonShockwave photonShockwave = new PhotonShockwave();
    PhotonWave photonWave = new PhotonWave();

    public MihileDealCycle(Job job) {
        super(job, new AdvancedFinalAttackMihile());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        ClaimhSolais claimhSolais = new ClaimhSolais();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
        DeadlyCharge deadlyCharge = new DeadlyCharge();
        Durandal1 durandal1 = new Durandal1();
        GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
        GuardOfLight guardOfLight = new GuardOfLight();
        InstallShield installShield = new InstallShield();
        LightForceRei lightForceRei = new LightForceRei();
        LightOfCourage lightOfCourage = new LightOfCourage();
        RestraintRing restraintRing = new RestraintRing();
        RhoAias rhoAias = new RhoAias();
        RingSwitching ringSwitching = new RingSwitching();
        RoyalGuard royalGuard = new RoyalGuard();
        ShiningCrossAssault shiningCrossAssault = new ShiningCrossAssault();
        SoulContract soulContract = new SoulContract();
        SoulLightSlash soulLightSlash = new SoulLightSlash();
        SoulMajesty soulMajesty = new SoulMajesty();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SwordOfSoulLight swordOfSoulLight = new SwordOfSoulLight();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        ringSwitching.setCooldown(85.0);
        ringSwitching.setApplyCooldownReduction(false);

        auraWeaponBuff.setCooldown(180.0);
        transcendentCygnusBlessing.setCooldown(240.0);
        transcendentCygnusBlessing.setApplyCooldownReduction(false);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);

        while (getStart().before(getEnd())) {
            if (cooldownCheck(installShield)) {
                addSkillEvent(installShield);
            }
            if (cooldownCheck(cygnusPhalanx)) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(transcendentCygnusBlessing)
                    && getStart().after(new Timestamp(rhoAias.getActivateTime().getTime() - 5000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                if (getStart().before(new Timestamp(10 * 1000))) {
                    transcendentCygnusBlessing.setCooldown(360.0);
                } else if (getStart().after(new Timestamp(5 * 60 * 1000))) {
                    transcendentCygnusBlessing.setCooldown(180.0);
                }
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (
                    cooldownCheck(auraWeaponBuff)
                    && cooldownCheck(rhoAias)
                    && cooldownCheck(gloryOfGuardians)
                    && cooldownCheck(royalGuard)
                    && cooldownCheck(guardOfLight)
                    && cooldownCheck(lightOfCourage)
                    && cooldownCheck(swordOfSoulLight)
                    && cooldownCheck(soulMajesty)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
                    && cooldownCheck(deadlyCharge)
                    && cooldownCheck(claimhSolais)
                    && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
                addSkillEvent(rhoAias);
                addSkillEvent(gloryOfGuardians);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(shiningCrossAssault);
                }
                addSkillEvent(guardOfLight);
                addSkillEvent(lightOfCourage);
                addSkillEvent(swordOfSoulLight);
                addSkillEvent(soulMajesty);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(royalGuard);
                addSkillEvent(deadlyCharge);
                addSkillEvent(claimhSolais);
                addSkillEvent(lightForceRei);
                if (cooldownCheck(durandal1)) {
                    addSkillEvent(durandal1);
                }
            } else if (
                    cooldownCheck(lightOfCourage)
                    && !cooldownCheck(gloryOfGuardians)
            ) {
                addSkillEvent(lightOfCourage);
            } else if (
                    cooldownCheck(soulContract)
                    && !cooldownCheck(lightOfCourage)
            ) {
                addSkillEvent(soulContract);
            } /*else if (
                    cooldownCheck(lightOfCourage)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(weaponJumpRing)
            ) {
                addSkillEvent(lightOfCourage);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            }*/ else if (
                    cooldownCheck(deadlyCharge)
                    && (
                            getStart().before(new Timestamp(rhoAias.getActivateTime().getTime() - 5000))
                            || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addSkillEvent(deadlyCharge);
            } else if (
                    cooldownCheck(claimhSolais)
                    && (
                            getStart().before(new Timestamp(rhoAias.getActivateTime().getTime() - 5000))
                            || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addSkillEvent(claimhSolais);
            } else if (cooldownCheck(royalGuard)) {
                addSkillEvent(royalGuard);
            } else if (getStart().before(swordOfSoulLightEndTime)) {
                addSkillEvent(soulLightSlash);
            } else {
                addSkillEvent(shiningCrossAssault);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(skill.getName());
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof SwordOfSoulLightBuff) {
                swordOfSoulLightEndTime = new Timestamp(getStart().getTime() + 35000);
            }
            if (skill instanceof SoulMajesty) {
                soulMajestyEndTime = new Timestamp(getStart().getTime() + 25000);
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
                        getStart().before(soulMajestyEndTime)
                        && cooldownCheck(photonShockwave)
                ) {
                    if (
                            skill instanceof ShiningCrossAssault
                            || skill instanceof DeadlyCharge
                            || skill instanceof ClaimhSolais
                            || skill instanceof SoulLightSlash
                            || skill instanceof LightForceRei
                            || skill instanceof Durandal1
                            || skill instanceof Durandal2
                            || skill instanceof Durandal3
                            || skill instanceof InstallShield
                    ) {
                        photonShockwave.setCooldown(2.0);
                        addSkillEvent(photonShockwave);
                        photonShockwave.setCooldown(10.0);
                        addSkillEvent(new PhotonWave());
                    }
                } else if (
                        cooldownCheck(photonShockwave)
                ) {
                    if (
                            skill instanceof ShiningCrossAssault
                            || skill instanceof DeadlyCharge
                            || skill instanceof ClaimhSolais
                            || skill instanceof SoulLightSlash
                            || skill instanceof LightForceRei
                            || skill instanceof Durandal1
                            || skill instanceof Durandal2
                            || skill instanceof Durandal3
                    ) {
                        addSkillEvent(photonShockwave);
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
