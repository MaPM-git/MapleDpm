package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.windbreaker.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.windbreaker.EmeraldFlower;
import org.mapledpmlab.type.skill.buffskill.windbreaker.PinpointPierceBuff;
import org.mapledpmlab.type.skill.buffskill.windbreaker.StormWhimBuff;
import org.mapledpmlab.type.skill.buffskill.windbreaker.WindWall;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class WindBreakerDealCycle extends DealCycle {

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

    private StormBringer stormBringer = new StormBringer();
    private StormWhim stormWhim = new StormWhim();
    private TriflingWhim triflingWhim = new TriflingWhim();
    private TriflingWhimReinforce triflingWhimReinforce = new TriflingWhimReinforce();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanx());
            add(new GuidedArrow());
            add(new HowlingGale1());
            add(new HowlingGale2());
            add(new HowlingGale3());
            add(new IdleWhimAfterSecond());
            add(new IdleWhimDot());
            add(new IdleWhimFirst());
            add(new MistralSpring());
            add(new MistralSpringExcited());
            add(new MistralSpringNormal());
            add(new MistralSpringStrong());
            add(new PinpointPierce());
            add(new SongOfHeaven());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new StoneWind());
            add(new StormBringer());
            add(new StormWhim());
            add(new TriflingWhim());
            add(new TriflingWhimReinforce());
            add(new VortexSphere());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new CygnusPhalanxDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(0.0));
            add(new EmeraldFlower());
            add(new GloryOfGuardians());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new PinpointPierceBuff());
            add(new SoulContract());
            add(new StormWhimBuff());
            add(new ThiefCunning());
            add(new TranscendentCygnusBlessing(0L));
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WindWall());
        }
    };

    HowlingGale1 howlingGale1 = new HowlingGale1();
    HowlingGale2 howlingGale2 = new HowlingGale2();
    HowlingGale3 howlingGale3 = new HowlingGale3();

    public WindBreakerDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
        CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
        EmeraldFlower emeraldFlower = new EmeraldFlower();
        GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
        GuidedArrow guidedArrow = new GuidedArrow();
        IdleWhimFirst idleWhimFirst = new IdleWhimFirst();
        MistralSpring mistralSpring = new MistralSpring();
        PinpointPierce pinpointPierce = new PinpointPierce();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SongOfHeaven songOfHeaven = new SongOfHeaven();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        StoneWind stoneWind = new StoneWind();
        StormWhimBuff stormWhimBuff = new StormWhimBuff();
        ThiefCunning thiefCunning = new ThiefCunning();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        VortexSphere vortexSphere = new VortexSphere();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);

        // 리스트레인트 극딜 예열 - F1
        dealCycle1.add(emeraldFlower);
        dealCycle1.add(pinpointPierce);
        dealCycle1.add(gloryOfGuardians);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(stormWhimBuff);
        dealCycle1.add(criticalReinforce);

        // 웨폰퍼프, 초시축 극딜 예열 - F2
        dealCycle2.add(emeraldFlower);
        dealCycle2.add(pinpointPierce);
        dealCycle2.add(gloryOfGuardians);
        dealCycle2.add(stormWhimBuff);
        dealCycle2.add(criticalReinforce);

        // 웨폰퍼프 - F2
        dealCycle3.add(emeraldFlower);
        dealCycle3.add(pinpointPierce);
        dealCycle3.add(gloryOfGuardians);
        dealCycle3.add(stormWhimBuff);
        dealCycle3.add(criticalReinforce);

        // 예열 후 사용(리레/6차)
        final1.add(mistralSpring);
        final1.add(soulContract);
        final1.add(restraintRing);
        final1.add(howlingGale3);
        final1.add(vortexSphere);
        final1.add(idleWhimFirst);

        // 예열 후 사용(리레)
        final2.add(soulContract);
        final2.add(restraintRing);
        final2.add(howlingGale3);
        final2.add(vortexSphere);
        final2.add(idleWhimFirst);

        // 예열 후 사용(웨퍼/6차)
        final3.add(mistralSpring);
        final3.add(soulContract);
        final3.add(weaponJumpRing);
        final3.add(howlingGale3);
        final3.add(vortexSphere);
        final3.add(idleWhimFirst);

        // 예열 후 사용(웨퍼)
        final4.add(soulContract);
        final4.add(weaponJumpRing);
        final4.add(howlingGale3);
        final4.add(vortexSphere);
        final4.add(idleWhimFirst);

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
                    cooldownCheck(stoneWind)
            ) {
                addSkillEvent(stoneWind);
            }
            if (
                    cooldownCheck(transcendentCygnusBlessing)
            ) {
                System.out.println("--------");
                System.out.println("bless");
                System.out.println(getStart());
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && (dealCycleOrder == 1 || dealCycleOrder == 3 || dealCycleOrder == 5)
            ) {
                addDealCycle(dealCycle1);
                if (dealCycleOrder == 1) {
                    finalChk = 1;
                }
                if (dealCycleOrder == 3 || dealCycleOrder == 5) {
                    finalChk = 2;
                }
                if (dealCycleOrder == 3) {
                    transcendentCygnusBlessing.setCooldown(140.0);
                }
                if (dealCycleOrder == 5) {
                    transcendentCygnusBlessing.setCooldown(720.0);
                }
                dealCycleOrder++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && dealCycleOrder == 4
            ) {
                transcendentCygnusBlessing.setCooldown(720.0);
                addDealCycle(dealCycle2);
                finalChk = 3;
                dealCycleOrder++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
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
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(emeraldFlower)
                    && finalChk == 0
                    && getStart().before(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(emeraldFlower);
                addSkillEvent(pinpointPierce);
            } else if (
                    cooldownCheck(soulContract)
                    && finalChk == 0
                    && !cooldownCheck(gloryOfGuardians)
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(howlingGale2)
                    && ((
                            ((double) getStart().getTime() / 120 / 1000 % 1) < 0.75
                            && ((double) getStart().getTime() / 120 / 1000 % 1) > 0.25
                    ) || getStart().after(new Timestamp(660 * 1000)))
            ) {
                addSkillEvent(howlingGale2);
            } else if (
                    cooldownCheck(howlingGale1)
                    && ((double) getStart().getTime() / 120 / 1000 % 1) < 0.3
                    && ((double) getStart().getTime() / 120 / 1000 % 1) > 0.1
            ) {
                addSkillEvent(howlingGale1);
            } else if (
                    cooldownCheck(vortexSphere)
                    && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(vortexSphere);
            } else if (
                    cooldownCheck(idleWhimFirst)
                    && !cooldownCheck(gloryOfGuardians)
                    && !cooldownCheck(howlingGale3)
            ) {
                addSkillEvent(idleWhimFirst);
            } else {
                addSkillEvent(songOfHeaven);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime()) && getStart().after(new Timestamp(0))) {
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
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        }
        applyCooldown(skill);
        if (skill instanceof HowlingGale1) {
            applyCooldown(howlingGale2);
            applyCooldown(howlingGale3);
        } else if (skill instanceof HowlingGale2) {
            applyCooldown(howlingGale1);
            applyCooldown(howlingGale3);
        } else if (skill instanceof HowlingGale3) {
        applyCooldown(howlingGale1);
        applyCooldown(howlingGale2);
        }
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
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isStormWhim = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof StormWhimBuff) {
                    isStormWhim = true;
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
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (isStormWhim) {
                        if (ran <= stormWhim.getProp() && start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(stormWhim, start, end), buffSkill, start, end);
                        }
                    }
                    if (ran <= stormBringer.getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(stormBringer, start, end), buffSkill, start, end);
                    }
                    if (ran <= triflingWhim.getProp() && start.equals(se.getStart())) {
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= triflingWhimReinforce.getProp() && start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(triflingWhimReinforce, start, end), buffSkill, start, end);
                        } else {
                            totalDamage += getAttackDamage(new SkillEvent(triflingWhim, start, end), buffSkill, start, end);
                        }
                    }
                }
            }
            isStormWhim = false;
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
