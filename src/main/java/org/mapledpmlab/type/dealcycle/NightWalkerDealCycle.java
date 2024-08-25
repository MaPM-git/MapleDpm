package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.nightwalker.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.nightwalker.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NightWalkerDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanxDelay());
            add(new CygnusPhalanx());
            add(new Dominion());
            add(new ElementDarkness());
            add(new QuintupleThrow());
            add(new QuintupleThrowBlack());
            add(new QuintupleThrowBlackFinal());
            add(new QuintupleThrowFinal());
            add(new RapidThrowBeforeDelay());
            add(new RapidThrow());
            add(new RapidThrowEnd());
            add(new RavenousBat());
            add(new RavenousBatReinforce());
            add(new ShadowBite());
            add(new ShadowSpear());
            add(new ShadowSpearGiant());
            add(new Silence());
            add(new SilenceShadowStar());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new DominionBuff());
            add(new GloryOfGuardians());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new ShadowBiteBuff());
            add(new ShadowIllusion());
            add(new ShadowServantExtend());
            add(new ShadowSpearBuff());
            add(new SilenceBuff());
            add(new SoulContract());
            add(new TranscendentCygnusBlessing(0L));
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int batCount = 4;
    int finalAttackCount = 2;
    RavenousBatReinforce ravenousBatReinforce = new RavenousBatReinforce();
    RavenousBat ravenousBat1 = new RavenousBat();
    RavenousBat ravenousBat2 = new RavenousBat();
    RavenousBat ravenousBat3 = new RavenousBat();
    RavenousBat ravenousBat4 = new RavenousBat();
    RavenousBat ravenousBat5 = new RavenousBat();
    RavenousBat ravenousBat6 = new RavenousBat();
    RavenousBat ravenousBat7 = new RavenousBat();
    RavenousBat ravenousBat8 = new RavenousBat();
    ShadowSpear shadowSpear = new ShadowSpear();
    ShadowSpearGiant shadowSpearGiant = new ShadowSpearGiant();
    SilenceShadowStar silenceShadowStar = new SilenceShadowStar();
    Timestamp silenceEndTime = new Timestamp(-1);
    Timestamp shadowSpearEndTime = new Timestamp(-1);
    Timestamp shadowIllusionEndTime = new Timestamp(-1);
    Timestamp shadowServantExtendEndTime = new Timestamp(-1);
    Timestamp dominionEndTime = new Timestamp(-1);

    DominionSummonBat dominionSummonBat = new DominionSummonBat();

    public NightWalkerDealCycle(Job job) {
        super(job, new RavenousBat());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
        Dominion dominion = new Dominion();
        ElementDarkness elementDarkness = new ElementDarkness();
        GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
        QuintupleThrow quintupleThrow = new QuintupleThrow();
        QuintupleThrowBlack quintupleThrowBlack = new QuintupleThrowBlack();
        RapidThrowBeforeDelay rapidThrow = new RapidThrowBeforeDelay();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        ShadowBiteBuff shadowBiteBuff = new ShadowBiteBuff();
        ShadowIllusion shadowIllusion = new ShadowIllusion();
        ShadowServantExtend shadowServantExtend = new ShadowServantExtend();
        ShadowSpearBuff shadowSpearBuff = new ShadowSpearBuff();
        Silence silence = new Silence();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        // 엘리멘트 : 다크니스
        for (int i = 0; i < 720 * 1000; i += elementDarkness.getInterval()) {
            getSkillEventList().add(new SkillEvent(elementDarkness, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(90.0);

        transcendentCygnusBlessing.setCooldown(240.0);
        transcendentCygnusBlessing.setApplyCooldownReduction(false);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);
        while (getStart().before(getEnd())) {
            if (cooldownCheck(cygnusPhalanx)) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(transcendentCygnusBlessing)
                    && getStart().after(new Timestamp(shadowSpearBuff.getActivateTime().getTime() - 5000))
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
                    cooldownCheck(shadowSpearBuff)
                    && cooldownCheck(gloryOfGuardians)
                    && cooldownCheck(shadowServantExtend)
                    && cooldownCheck(shadowIllusion)
                    && cooldownCheck(dominion)
                    && cooldownCheck(shadowBiteBuff)
                    && cooldownCheck(readyToDie)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
                    && cooldownCheck(rapidThrow)
                    && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(shadowSpearBuff);
                addSkillEvent(gloryOfGuardians);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    if (cooldownCheck(quintupleThrowBlack)) {
                        addSkillEvent(quintupleThrowBlack);
                    } else {
                        addSkillEvent(quintupleThrow);
                    }
                }
                addSkillEvent(shadowServantExtend);
                addSkillEvent(shadowBiteBuff);
                if (cooldownCheck(silence)) {
                    addSkillEvent(silence);
                }
                addSkillEvent(dominion);
                addSkillEvent(shadowIllusion);
                addSkillEvent(readyToDie);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(rapidThrow);
            } else if (
                    cooldownCheck(readyToDie)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(weaponJumpRing)
                    && cooldownCheck(rapidThrow)
                    && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(readyToDie);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(rapidThrow);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(shadowServantExtend)
                    && !cooldownCheck(shadowSpearBuff)
            ) {
                addSkillEvent(shadowServantExtend);
            } else if (
                    cooldownCheck(shadowBiteBuff)
                    && (
                            !cooldownCheck(shadowSpearBuff)
                            || getStart().after(new Timestamp(660 * 1000))
                    )
            ) {
                addSkillEvent(shadowBiteBuff);
            } else if (cooldownCheck(quintupleThrowBlack)) {
                addSkillEvent(quintupleThrowBlack);
            } else {
                addSkillEvent(quintupleThrow);
            }
        }
        getStart().setTime(0);
        sortEventTimeList();
    }

    public void attackBat() {
        if (
                cooldownCheck(ravenousBat1)
                && ravenousBat1.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat1, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat1.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat1.setReady(false);
        }
        if (
                cooldownCheck(ravenousBat2)
                && ravenousBat2.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat2, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat2.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat2.setReady(false);
        }
        if (
                cooldownCheck(ravenousBat3)
                && ravenousBat3.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat3, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat3.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat3.setReady(false);
        }
        if (
                cooldownCheck(ravenousBat4)
                && ravenousBat4.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat4, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat4.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat4.setReady(false);
        }
        if (
                cooldownCheck(ravenousBat5)
                && ravenousBat5.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat5, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat5.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat5.setReady(false);
        }
        if (
                cooldownCheck(ravenousBat6)
                && ravenousBat6.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat6, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat6.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat6.setReady(false);
        }
        if (
                cooldownCheck(ravenousBat7)
                        && ravenousBat7.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat7, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat7.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat7.setReady(false);
        }
        if (
                cooldownCheck(ravenousBat8)
                        && ravenousBat8.isReady()
        ) {
            batCount ++;
            if (batCount == 5) {
                getSkillEventList().add(new SkillEvent(ravenousBatReinforce, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
                batCount = 0;
            } else {
                getSkillEventList().add(new SkillEvent(ravenousBat8, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 990)));
            }
            getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
            ravenousBat8.setActivateTime(new Timestamp(getStart().getTime() + 990));
            ravenousBat8.setReady(false);
        }
    }

    public void summonBat() {
        if (
                cooldownCheck(ravenousBat1)
                && !ravenousBat1.isReady()
        ) {
            ravenousBat1.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat1.setReady(true);
        } else if (
                cooldownCheck(ravenousBat2)
                && !ravenousBat2.isReady()
        ) {
            ravenousBat2.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat2.setReady(true);
        } else if (
                cooldownCheck(ravenousBat3)
                && !ravenousBat3.isReady()
        ) {
            ravenousBat3.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat3.setReady(true);
        } else if (
                cooldownCheck(ravenousBat4)
                && !ravenousBat4.isReady()
        ) {
            ravenousBat4.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat4.setReady(true);
        } else if (
                cooldownCheck(ravenousBat5)
                && !ravenousBat5.isReady()
        ) {
            ravenousBat5.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat5.setReady(true);
        } else if (
                cooldownCheck(ravenousBat6)
                && !ravenousBat6.isReady()
                && getStart().before(dominionEndTime)
        ) {
            ravenousBat6.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat6.setReady(true);
        } else if (
                cooldownCheck(ravenousBat7)
                && !ravenousBat7.isReady()
                && getStart().before(dominionEndTime)
        ) {
            ravenousBat7.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat7.setReady(true);
        } else if (
                cooldownCheck(ravenousBat8)
                && !ravenousBat8.isReady()
                && getStart().before(dominionEndTime)
        ) {
            ravenousBat8.setActivateTime(new Timestamp(getStart().getTime() + 960));
            ravenousBat8.setReady(true);
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        while (
                cooldownCheck(dominionSummonBat)
                && getStart().before(dominionEndTime)
        ) {
            summonBat();
            dominionSummonBat.setActivateTime(new Timestamp(getStart().getTime() + 700));
        }
        if (getStart().before(skill.getActivateTime()) && getStart().after(new Timestamp(0))) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof DominionBuff) {
                dominionEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof SilenceBuff) {
                silenceEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof ShadowSpearBuff) {
                shadowSpearEndTime = new Timestamp(getStart().getTime() + 87000);
            }
            if (skill instanceof ShadowIllusion) {
                shadowIllusionEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof ShadowServantExtend) {
                shadowServantExtendEndTime = new Timestamp(getStart().getTime() + 55000);
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
            if (getStart().before(shadowIllusionEndTime) && ((AttackSkill) skill).isApplyFinalAttack()) {
                applyCooldown(skill);
                if (skill instanceof QuintupleThrow) {
                    skill = new QuintupleThrow();
                } else if (skill instanceof QuintupleThrowBlack) {
                    skill = new QuintupleThrowBlack();
                } else if (skill instanceof QuintupleThrowBlackFinal) {
                    skill = new QuintupleThrowBlackFinal();
                } else if (skill instanceof QuintupleThrowFinal) {
                    skill = new QuintupleThrowFinal();
                } else if (skill instanceof RapidThrow) {
                    skill = new RapidThrow();
                } else if (skill instanceof RapidThrowEnd) {
                    skill = new RapidThrowEnd();
                }
                ((AttackSkill) skill).minusFinalDamage(0.85);
                ((AttackSkill) skill).addFinalDamage(0.67);
                ((AttackSkill) skill).setInterval(((AttackSkill) skill).getInterval() * 2 / 5);
                ((AttackSkill) skill).setLimitAttackCount(((AttackSkill) skill).getLimitAttackCount() * 5 / 2);
            } else if (getStart().before(shadowServantExtendEndTime) && ((AttackSkill) skill).isApplyFinalAttack()) {
                applyCooldown(skill);
                if (skill instanceof QuintupleThrow) {
                    skill = new QuintupleThrow();
                } else if (skill instanceof QuintupleThrowBlack) {
                    skill = new QuintupleThrowBlack();
                } else if (skill instanceof QuintupleThrowBlackFinal) {
                    skill = new QuintupleThrowBlackFinal();
                } else if (skill instanceof QuintupleThrowFinal) {
                    skill = new QuintupleThrowFinal();
                } else if (skill instanceof RapidThrow) {
                    skill = new RapidThrow();
                } else if (skill instanceof RapidThrowEnd) {
                    skill = new RapidThrowEnd();
                }
                ((AttackSkill) skill).setInterval(((AttackSkill) skill).getInterval() * 2 / 3);
                ((AttackSkill) skill).setLimitAttackCount(((AttackSkill) skill).getLimitAttackCount() * 3 / 2);
            }
            if (
                    getStart().before(silenceEndTime)
                    && cooldownCheck(silenceShadowStar)
                    && !(skill instanceof SilenceShadowStar)
            ) {
                addSkillEvent(silenceShadowStar);
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                    ) {
                        if (!(skill instanceof SilenceShadowStar)) {
                            remove.add(skillEvent);
                        }
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
                        if (skill instanceof RapidThrow) {
                            skill = new RapidThrow();
                            if ((new Timestamp(getStart().getTime() + i)).before(shadowSpearEndTime)) {
                                ((RapidThrow) skill).setDamage(1045.0 + 290);
                            }
                            if (getStart().before(shadowIllusionEndTime)) {
                                ((AttackSkill) skill).minusFinalDamage(0.85);
                                ((AttackSkill) skill).addFinalDamage(0.67);
                                ((AttackSkill) skill).setInterval(((AttackSkill) skill).getInterval() * 2 / 5);
                                ((AttackSkill) skill).setLimitAttackCount(((AttackSkill) skill).getLimitAttackCount() * 5 / 2);
                            } else if (getStart().before(shadowServantExtendEndTime)) {
                                ((AttackSkill) skill).setInterval(((AttackSkill) skill).getInterval() * 2 / 3);
                                ((AttackSkill) skill).setLimitAttackCount(((AttackSkill) skill).getLimitAttackCount() * 3 / 2);
                            }
                        }
                        if (skill instanceof RapidThrowEnd) {
                            skill = new RapidThrowEnd();
                            if ((new Timestamp(getStart().getTime() + i)).before(shadowSpearEndTime)) {
                                ((RapidThrowEnd) skill).setDamage(1870.0 + 290);
                            }
                            if (getStart().before(shadowIllusionEndTime)) {
                                ((AttackSkill) skill).minusFinalDamage(0.85);
                                ((AttackSkill) skill).addFinalDamage(0.67);
                                ((AttackSkill) skill).setInterval(((AttackSkill) skill).getInterval() * 2 / 5);
                                ((AttackSkill) skill).setLimitAttackCount(((AttackSkill) skill).getLimitAttackCount() * 5 / 2);
                            } else if (getStart().before(shadowServantExtendEndTime)) {
                                ((AttackSkill) skill).setInterval(((AttackSkill) skill).getInterval() * 2 / 3);
                                ((AttackSkill) skill).setLimitAttackCount(((AttackSkill) skill).getLimitAttackCount() * 3 / 2);
                            }
                        }
                        if (((AttackSkill) skill).isApplyFinalAttack()) {
                            finalAttackCount ++;
                            Timestamp now = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (finalAttackCount == 3) {
                                summonBat();
                                finalAttackCount = 0;
                            }
                            attackBat();
                            getStart().setTime(now.getTime());
                        }
                    }
                    if (skill instanceof RapidThrow) {
                        skill = new RapidThrow();
                        if ((new Timestamp(getStart().getTime() + i)).before(shadowSpearEndTime)) {
                            ((RapidThrow) skill).setDamage(1045.0);
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
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isShadowSpear = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof ShadowSpearBuff) {
                    isShadowSpear = true;
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
                if (
                        isShadowSpear
                        && se.getSkill() instanceof DarkAttack
                        && !(
                                se.getSkill() instanceof ElementDarkness
                                || se.getSkill() instanceof RapidThrow
                        )
                ) {
                    totalDamage += getAttackDamage(new SkillEvent(shadowSpear, start, end), buffSkill, start, end);
                    getStart().setTime(start.getTime());
                    if (cooldownCheck(shadowSpearGiant)) {
                        totalDamage += getAttackDamage(new SkillEvent(shadowSpearGiant, start, end), buffSkill, start, end);
                        applyCooldown(shadowSpearGiant);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
