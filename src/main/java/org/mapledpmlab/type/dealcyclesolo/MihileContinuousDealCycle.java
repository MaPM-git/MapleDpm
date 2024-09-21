package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
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

public class MihileContinuousDealCycle extends DealCycle {

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
            add(new LightOfCourageAttack());
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
            add(new BodyOfSteel(0L));
            add(new GuardOfLight());
            add(new LightOfCourage());
            add(new QueenOfTomorrow());
            add(new RhoAias());
            add(new SoulContract());
            add(new SoulMajesty());
            add(new SwordOfSoulLightBuff());
            add(new TranscendentCygnusBlessing(0L));
        }
    };

    boolean isNuke = false;

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp soulMajestyEndTime = new Timestamp(-1);
    Timestamp swordOfSoulLightEndTime = null;

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    ClaimhSolais claimhSolais = new ClaimhSolais();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
    DeadlyCharge deadlyCharge = new DeadlyCharge();
    Durandal1 durandal1 = new Durandal1();
    GuardOfLight guardOfLight = new GuardOfLight();
    InstallShield installShield = new InstallShield();
    LightForceRei lightForceRei = new LightForceRei();
    LightOfCourage lightOfCourage = new LightOfCourage();
    PhotonShockwave photonShockwave = new PhotonShockwave();
    PhotonWave photonWave = new PhotonWave();
    QueenOfTomorrow queenOfTomorrow = new QueenOfTomorrow();
    RhoAias rhoAias = new RhoAias();
    RoyalGuard royalGuard = new RoyalGuard();
    ShiningCrossAssault shiningCrossAssault = new ShiningCrossAssault();
    SoulContract soulContract = new SoulContract();
    SoulLightSlash soulLightSlash = new SoulLightSlash();
    SoulMajesty soulMajesty = new SoulMajesty();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SwordOfSoulLight swordOfSoulLight = new SwordOfSoulLight();
    TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);

    public MihileContinuousDealCycle(Job job) {
        super(job, new AdvancedFinalAttackMihile());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);


        auraWeaponBuff.setCooldown(180.0);
        transcendentCygnusBlessing.setCooldown(120.0);
        transcendentCygnusBlessing.setApplyCooldownReduction(false);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);
    }

    @Override
    public void setSoloDealCycle() {
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
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (
                    cooldownCheck(auraWeaponBuff)
                            && cooldownCheck(rhoAias)
                            && cooldownCheck(queenOfTomorrow)
                            //&& cooldownCheck(royalGuard)
                            && cooldownCheck(guardOfLight)
                            && cooldownCheck(lightOfCourage)
                            && cooldownCheck(swordOfSoulLight)
                            && cooldownCheck(soulMajesty)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(deadlyCharge)
                            && cooldownCheck(claimhSolais)
                            && getStart().before(new Timestamp(600 * 1000))
            ) {
                isNuke = true;
                addSkillEvent(auraWeaponBuff);
                addSkillEvent(rhoAias);
                addSkillEvent(bodyOfSteel);
                addSkillEvent(queenOfTomorrow);
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
                //addSkillEvent(royalGuard);
                addSkillEvent(deadlyCharge);
                addSkillEvent(claimhSolais);
                addSkillEvent(lightForceRei);
                if (cooldownCheck(durandal1)) {
                    addSkillEvent(durandal1);
                }
                isNuke = false;
            } else if (
                    cooldownCheck(lightOfCourage)
                            && !cooldownCheck(queenOfTomorrow)
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
            } /*else if (cooldownCheck(royalGuard)) {
                addSkillEvent(royalGuard);
            }*/ else if (getStart().before(swordOfSoulLightEndTime)) {
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
            if (skill instanceof SwordOfSoulLightBuff) {
                swordOfSoulLightEndTime = new Timestamp(getStart().getTime() + 38000);
            }
            if (skill instanceof SoulMajesty) {
                soulMajestyEndTime = new Timestamp(getStart().getTime() + 25000);
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
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof ClaimhSolais
                            || skill instanceof DeadlyCharge
                            || skill instanceof RoyalGuard
                            || skill instanceof ShiningCrossAssault
                            || skill instanceof SoulLightSlash
                    )
            ) {
                addSkillEvent(continuousRing);
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
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                if (cooldownCheck(royalGuard)) {
                    if (skill instanceof ClaimhSolais) {
                        claimhSolais = new ClaimhSolais();
                        claimhSolais.setApplyFinalAttack(false);
                    } else if (skill instanceof DeadlyCharge) {
                        deadlyCharge = new DeadlyCharge();
                        deadlyCharge.setApplyFinalAttack(false);
                    } else if (skill instanceof ShiningCrossAssault) {
                        shiningCrossAssault = new ShiningCrossAssault();
                        shiningCrossAssault.setApplyFinalAttack(false);
                    } else if (skill instanceof SoulLightSlash) {
                        soulLightSlash = new SoulLightSlash();
                        soulLightSlash.setApplyFinalAttack(false);
                    }
                }
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
        if (
                cooldownCheck(royalGuard)
                && !(skill instanceof RoyalGuard)
                && !(skill instanceof LightForceRei)
                && !(skill instanceof Durandal1)
                && !(skill instanceof Durandal2)
                && !(skill instanceof Durandal3)
                && !(skill instanceof RingSwitching)
                && skill.getDelay() >= 540
                && skill.getDelay() <= 1100
        ) {
            addSkillEvent(royalGuard);
            if (skill instanceof ClaimhSolais) {
                claimhSolais = new ClaimhSolais();
            } else if (skill instanceof DeadlyCharge) {
                deadlyCharge = new DeadlyCharge();
            } else if (skill instanceof ShiningCrossAssault) {
                shiningCrossAssault = new ShiningCrossAssault();
            } else if (skill instanceof SoulLightSlash) {
                soulLightSlash = new SoulLightSlash();
            }
        } else {
            getStart().setTime(getStart().getTime() + skill.getDelay());
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Timestamp now = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof LightForceRei
                            || skill instanceof Durandal1
                            || skill instanceof Durandal2
                            || skill instanceof Durandal3
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            getStart().setTime(now.getTime());
        }
    }
}
