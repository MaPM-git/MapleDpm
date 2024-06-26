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

    /*
     */

    // 6차, 리레
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 리레, 초시축
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private final List<Skill> dealCycle3 = new ArrayList<>();

    // 극딜 마지막, 6차 포함
    private final List<Skill> final1 = new ArrayList<>();

    // 극딜 마지막
    private final List<Skill> final2 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackMihile());
            add(new AuraWeaponDot());
            add(new ClaimhSolais());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
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

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new CygnusPhalanxDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new GloryOfGuardians());
            add(new GuardOfLight());
            add(new LightOfCourage());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new RhoAias());
            add(new SoulContract());
            add(new SoulMajesty());
            add(new SwordOfSoulLightBuff());
            add(new ThiefCunning());
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
        this.setDelaySkillList(delaySkillList);
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
        PriorPreparation priorPreparation = new PriorPreparation();
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
        ThiefCunning thiefCunning = new ThiefCunning();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(90.0);

        // 극딜 예열
        dealCycle1.add(rhoAias);
        dealCycle1.add(gloryOfGuardians);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(transcendentCygnusBlessing);
        dealCycle1.add(royalGuard);
        dealCycle1.add(guardOfLight);
        //dealCycle1.add(cygnusPhalanx);
        dealCycle1.add(lightOfCourage);
        dealCycle1.add(swordOfSoulLight);
        dealCycle1.add(soulMajesty);
        dealCycle1.add(deadlyCharge);
        dealCycle1.add(claimhSolais);

        // 예열 후 사용(6차)
        final1.add(soulContract);
        final1.add(restraintRing);
        final1.add(royalGuard);
        final1.add(deadlyCharge);
        final1.add(claimhSolais);
        final1.add(lightForceRei);
        final1.add(durandal1);

        // 극딜 예열
        dealCycle2.add(rhoAias);
        dealCycle2.add(gloryOfGuardians);
        dealCycle2.add(transcendentCygnusBlessing);
        dealCycle2.add(royalGuard);
        dealCycle2.add(guardOfLight);
        //dealCycle2.add(cygnusPhalanx);
        dealCycle2.add(lightOfCourage);
        dealCycle2.add(swordOfSoulLight);
        dealCycle2.add(soulMajesty);
        dealCycle2.add(deadlyCharge);
        dealCycle2.add(claimhSolais);

        // 예열 후 사용
        final2.add(soulContract);
        final2.add(restraintRing);
        final2.add(royalGuard);
        final2.add(deadlyCharge);
        final2.add(claimhSolais);
        final2.add(lightForceRei);

        // 준극딜
        dealCycle3.add(lightOfCourage);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(royalGuard);
        dealCycle3.add(deadlyCharge);
        dealCycle3.add(claimhSolais);

        int finalChk = 0;

        while (getStart().before(getEnd())) {
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (cooldownCheck(installShield)) {
                addSkillEvent(installShield);
            }
            if (
                    cooldownCheck(cygnusPhalanx)
            ) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle1);
                finalChk = 0;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
                finalChk = 1;
            } else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    getStart().after(new Timestamp(soulMajestyEndTime.getTime() - 10000))
                    && finalChk == 0
                    && cooldownCheck(final1)
            ) {
                addDealCycle(final1);
                finalChk = 2;
            } else if (
                    getStart().after(new Timestamp(soulMajestyEndTime.getTime() - 10000))
                    && finalChk == 1
                    && cooldownCheck(final2)
            ) {
                addDealCycle(final2);
                finalChk = 2;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(deadlyCharge)
                    && getStart().before(new Timestamp(lightOfCourage.getActivateTime().getTime() - 15000))
                    && getStart().after(soulMajestyEndTime)
            ) {
                addSkillEvent(deadlyCharge);
            } else if (
                    cooldownCheck(claimhSolais)
                    && getStart().before(new Timestamp(lightOfCourage.getActivateTime().getTime() - 15000))
                    && getStart().after(soulMajestyEndTime)
            ) {
                addSkillEvent(claimhSolais);
            } else if (
                    cooldownCheck(royalGuard)
            ) {
                addSkillEvent(royalGuard);
            } else if (
                    getStart().before(swordOfSoulLightEndTime)
            ) {
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
