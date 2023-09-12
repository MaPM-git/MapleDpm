package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.mihile.*;
import org.mapledpmlab.type.skill.attackskill.nightwalker.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.mihile.*;
import org.mapledpmlab.type.skill.buffskill.nightwalker.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NightWalkerDealCycle extends DealCycle {

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

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanx());
            add(new Dominion());
            add(new ElementDarkness());
            add(new QuintupleThrow());
            add(new QuintupleThrowBlack());
            add(new QuintupleThrowBlackFinal());
            add(new QuintupleThrowFinal());
            add(new RapidThrow());
            add(new RapidThrowEnd());
            add(new RavenousBat());
            add(new RavenousBatReinforce());
            add(new ShadowBite());
            add(new ShadowSpear());
            add(new Silence());
            add(new SilenceShadowStar());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new CygnusPhalanxDelay());
            add(new QuintupleThrowBlackDelay());
            add(new QuintupleThrowBlackFinalDelay());
            add(new QuintupleThrowDelay());
            add(new QuintupleThrowFinalDelay());
            add(new RapidThrowDelay());
            add(new RapidThrowEndDelay());
            add(new SilenceDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new DominionBuff());
            add(new GloryOfGuardians());
            add(new PriorPreparation());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new ShadowBiteBuff());
            add(new ShadowIllusion());
            add(new ShadowServantExtend());
            add(new ShadowSpearBuff());
            add(new SilenceBuff());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new TranscendentCygnusBlessing(0L));
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    private int batCount = 0;
    private RavenousBatReinforce ravenousBatReinforce = new RavenousBatReinforce();
    private ShadowSpear shadowSpear = new ShadowSpear();

    public NightWalkerDealCycle(Job job) {
        super(job, new RavenousBat());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
        Dominion dominion = new Dominion();
        ElementDarkness elementDarkness = new ElementDarkness();
        GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
        PriorPreparation priorPreparation = new PriorPreparation();
        QuintupleThrow quintupleThrow = new QuintupleThrow();
        QuintupleThrowBlack quintupleThrowBlack = new QuintupleThrowBlack();
        RapidThrow rapidThrow = new RapidThrow();
        RavenousBat ravenousBat = new RavenousBat();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        ShadowBiteBuff shadowBiteBuff = new ShadowBiteBuff();
        ShadowIllusion shadowIllusion = new ShadowIllusion();
        ShadowServantExtend shadowServantExtend = new ShadowServantExtend();
        ShadowSpearBuff shadowSpearBuff = new ShadowSpearBuff();
        Silence silence = new Silence();
        SilenceShadowStar silenceShadowStar = new SilenceShadowStar();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        // 엘리멘트 : 다크니스
        for (int i = 0; i < 720 * 1000; i += elementDarkness.getInterval()) {
            getSkillEventList().add(new SkillEvent(elementDarkness, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

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
        dealCycle1.add(shadowSpearBuff);
        dealCycle1.add(gloryOfGuardians);
        dealCycle1.add(shadowServantExtend);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(transcendentCygnusBlessing);

        // 예열 후 사용(6차)
        final1.add(silence);
        final1.add(shadowIllusion);
        final1.add(dominion);
        final1.add(shadowBiteBuff);
        final1.add(readyToDie);
        final1.add(soulContract);
        final1.add(restraintRing);
        final1.add(rapidThrow);

        // 극딜 예열
        dealCycle2.add(shadowSpearBuff);
        dealCycle2.add(gloryOfGuardians);
        dealCycle2.add(shadowServantExtend);
        dealCycle2.add(transcendentCygnusBlessing);

        // 예열 후 사용
        final2.add(shadowIllusion);
        final2.add(dominion);
        final2.add(shadowBiteBuff);
        final2.add(readyToDie);
        final2.add(soulContract);
        final2.add(restraintRing);
        final2.add(rapidThrow);

        // 준극딜
        dealCycle3.add(readyToDie);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(rapidThrow);

        int finalChk = 0;
        Timestamp finalTime = new Timestamp(-1);
        Timestamp silenceEndTime = new Timestamp(-1);

        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                System.out.println("-----------");
                System.out.println("dc1");
                System.out.println(getStart());
                addDealCycle(dealCycle1);
                finalTime = new Timestamp(getStart().getTime() + 19500);
                finalChk = 0;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                System.out.println("-----------");
                System.out.println("dc2");
                System.out.println(getStart());
                addDealCycle(dealCycle2);
                finalTime = new Timestamp(getStart().getTime() + 21500);
                finalChk = 1;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().after(new Timestamp(finalTime.getTime() + 10000))
            ) {
                System.out.println("-----------");
                System.out.println("dc3");
                System.out.println(getStart());
                addDealCycle(dealCycle3);
            } else if (
                    getStart().after(finalTime)
                    && finalChk == 0
            ) {
                System.out.println("-----------");
                System.out.println("f1");
                System.out.println(getStart());
                silenceEndTime = new Timestamp(getStart().getTime() + 25000);
                addDealCycle(final1);
                finalChk = 2;
            } else if (
                    getStart().after(finalTime)
                    && finalChk == 1
            ) {
                System.out.println("-----------");
                System.out.println("f2");
                System.out.println(getStart());
                addDealCycle(final2);
                finalChk = 2;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    getStart().before(silenceEndTime)
                    && cooldownCheck(silenceShadowStar)
            ) {
                addSkillEvent(silenceShadowStar);
            } else if (
                    cooldownCheck(shadowServantExtend)
            ) {
                System.out.println("-----------");
                System.out.println("sse");
                System.out.println(getStart());
                addSkillEvent(shadowServantExtend);
            } else if (
                    cooldownCheck(cygnusPhalanx)
            ) {
                System.out.println("-----------");
                System.out.println("cp");
                System.out.println(getStart());
                addSkillEvent(cygnusPhalanx);
            } else if (
                    cooldownCheck(shadowBiteBuff)
            ) {
                System.out.println("-----------");
                System.out.println("sb");
                System.out.println(getStart());
                addSkillEvent(shadowBiteBuff);
            } else if (
                    cooldownCheck(quintupleThrowBlack)
            ) {
                addSkillEvent(quintupleThrowBlack);
            } else {
                addSkillEvent(quintupleThrow);
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
            overlappingSkillEvents = deduplication(overlappingSkillEvents, SkillEvent::getSkill);
            boolean isShadowIllusion = false;
            boolean isShadowServantExtend = false;
            boolean isShadowSpear = false;
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof ShadowIllusion) {
                    isShadowIllusion = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof ShadowServantExtend) {
                    isShadowServantExtend = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof ShadowSpearBuff) {
                    isShadowSpear = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BuffSkill) {
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
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            for (SkillEvent se : useAttackSkillList) {
                AttackSkill attackSkill = (AttackSkill) se.getSkill();
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    if (isShadowIllusion && isShadowServantExtend) {
                        attackSkill.setLimitAttackCount((long) (attackSkill.getLimitAttackCount() * 2.5));
                        attackSkill.minusFinalDamage(0.85);
                        attackSkill.addFinalDamage(0.67);
                    } else if (isShadowIllusion) {
                        attackSkill.setLimitAttackCount(attackSkill.getLimitAttackCount() * 2);
                        attackSkill.minusFinalDamage(0.85);
                        attackSkill.addFinalDamage(0.625);
                    } else if (isShadowServantExtend) {
                        attackSkill.setLimitAttackCount((long) (attackSkill.getLimitAttackCount() * 1.5));
                    }
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    if (isShadowIllusion && isShadowServantExtend) {
                        attackSkill.setLimitAttackCount((long) (attackSkill.getLimitAttackCount() / 2.5));
                        attackSkill.addFinalDamage(0.85);
                        attackSkill.minusFinalDamage(0.67);
                    } else if (isShadowIllusion) {
                        attackSkill.setLimitAttackCount(attackSkill.getLimitAttackCount() / 2);
                        attackSkill.addFinalDamage(0.85);
                        attackSkill.minusFinalDamage(0.625);
                    } else if (isShadowServantExtend) {
                        attackSkill.setLimitAttackCount((long) (attackSkill.getLimitAttackCount() / 1.5));
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    if (batCount % 5 == 0) {
                        totalDamage += getAttackDamage(new SkillEvent(ravenousBatReinforce, start, end), buffSkill, start, end);
                        totalDamage += getAttackDamage(new SkillEvent(shadowSpear, start, end), buffSkill, start, end);
                        batCount ++;
                    } else {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                        batCount ++;
                    }
                    if (isShadowSpear) {
                        totalDamage += getAttackDamage(new SkillEvent(shadowSpear, start, end), buffSkill, start, end);
                        totalDamage += getAttackDamage(new SkillEvent(shadowSpear, start, end), buffSkill, start, end);
                    }
                }
                if (isShadowSpear && se.getSkill() instanceof DarkAttack) {
                    totalDamage += getAttackDamage(new SkillEvent(shadowSpear, start, end), buffSkill, start, end);
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
