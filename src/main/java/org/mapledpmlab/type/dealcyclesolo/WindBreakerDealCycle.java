package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanxDelay());
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(0.0));
            add(new EmeraldFlower());
            add(new GloryOfGuardians());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new RiskTakerRing());
            add(new PinpointPierceBuff());
            add(new SoulContract());
            add(new StormWhimBuff());
            add(new TranscendentCygnusBlessing(0L));
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WindWall());
        }
    };

    boolean isCriticalReinforce = false;

    Timestamp criticalReinforceEndTime = new Timestamp(-1);

    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
    CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
    EmeraldFlower emeraldFlower = new EmeraldFlower();
    GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
    GuidedArrow guidedArrow = new GuidedArrow();
    HowlingGale1 howlingGale1 = new HowlingGale1();
    HowlingGale2 howlingGale2 = new HowlingGale2();
    HowlingGale3 howlingGale3 = new HowlingGale3();
    IdleWhimFirst idleWhimFirst = new IdleWhimFirst();
    MistralSpring mistralSpring = new MistralSpring();
    PinpointPierce pinpointPierce = new PinpointPierce();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    RiskTakerRing riskTakerRing = new RiskTakerRing();
    SongOfHeaven songOfHeaven = new SongOfHeaven();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    StoneWind stoneWind = new StoneWind();
    StormBringer stormBringer = new StormBringer();
    StormWhim stormWhim = new StormWhim();
    StormWhimBuff stormWhimBuff = new StormWhimBuff();
    TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
    TriflingWhim triflingWhim = new TriflingWhim();
    TriflingWhimReinforce triflingWhimReinforce = new TriflingWhimReinforce();
    VortexSphere vortexSphere = new VortexSphere();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public WindBreakerDealCycle(Job job) {
        super(job, null);

        for (AttackSkill attackSkill : attackSkillList) {
            if (attackSkill instanceof CygnusPhalanx) {
                attackSkill.setApplyFinalAttack(true);
                break;
            }
        }

        getJob().addCooldownReductionSec(-1L);
        getJob().addMainStatP(8L);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        cygnusPhalanx.setApplyFinalAttack(true);

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(66.0);

        transcendentCygnusBlessing.setCooldown(125.0);
        //transcendentCygnusBlessing.setApplyCooldownReduction(false);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(transcendentCygnusBlessing)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (
                    cooldownCheck(emeraldFlower)
                            && cooldownCheck(pinpointPierce)
                            && cooldownCheck(gloryOfGuardians)
                            && cooldownCheck(stormWhimBuff)
                            && cooldownCheck(criticalReinforce)
                            && cooldownCheck(howlingGale3)
                            && cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(emeraldFlower);
                addSkillEvent(pinpointPierce);
                addSkillEvent(gloryOfGuardians);
                if (
                        dealCycleOrder == 1
                                || dealCycleOrder == 3
                                || dealCycleOrder == 5
                ) {
                    while (!cooldownCheck(crestOfTheSolar)) {
                        addSkillEvent(songOfHeaven);
                    }
                    addSkillEvent(crestOfTheSolar);
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(songOfHeaven);
                }
                if (
                        dealCycleOrder == 1
                                || dealCycleOrder == 2
                                || dealCycleOrder == 5
                ) {
                    addSkillEvent(stoneWind);
                }
                if (cooldownCheck(cygnusPhalanx)) {
                    addSkillEvent(cygnusPhalanx);
                }
                if (
                        dealCycleOrder == 1
                                || dealCycleOrder == 4
                ) {
                    addSkillEvent(mistralSpring);
                }
                addSkillEvent(stormWhimBuff);
                addSkillEvent(criticalReinforce);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(riskTakerRing)) {
                    addSkillEvent(riskTakerRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(howlingGale3);
                addSkillEvent(soulContract);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(emeraldFlower)
                            && cooldownCheck(pinpointPierce)
                            && cooldownCheck(howlingGale1)
                            && cooldownCheck(soulContract)
                            && !cooldownCheck(gloryOfGuardians)
            ) {
                addSkillEvent(emeraldFlower);
                addSkillEvent(pinpointPierce);
                if (cooldownCheck(cygnusPhalanx)) {
                    addSkillEvent(cygnusPhalanx);
                }
                if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                } else if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(riskTakerRing)) {
                    addSkillEvent(riskTakerRing);
                }
                addSkillEvent(howlingGale1);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(50 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(stoneWind)
                            && (
                            dealCycleOrder == 3
                                    || (
                                    dealCycleOrder == 4
                                            && getStart().after(new Timestamp(290 * 1000))
                            )
                                    || (
                                    dealCycleOrder == 5
                                            && getStart().after(new Timestamp(380 * 1000))
                                            && getStart().before(new Timestamp(400 * 1000))
                            )
                                    || (
                                    getStart().after(new Timestamp(600 * 1000))
                                            && getStart().before(new Timestamp(660 * 1000))
                            )
                    )
            ) {
                addSkillEvent(stoneWind);
            } else if (cooldownCheck(cygnusPhalanx)) {
                addSkillEvent(cygnusPhalanx);
            } else if (cooldownCheck(vortexSphere)) {
                addSkillEvent(vortexSphere);
            } else if (
                    cooldownCheck(howlingGale1)
                            && getStart().before(criticalReinforceEndTime)
            ) {
                addSkillEvent(howlingGale1);
            } else if (cooldownCheck(idleWhimFirst)) {
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof CriticalReinforce) {
                criticalReinforceEndTime = new Timestamp(getStart().getTime() + 30000);
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
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (
                            skill instanceof HowlingGale1
                            || skill instanceof HowlingGale2
                            || skill instanceof HowlingGale3
                    ) {
                        i = 840;
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
            for (SkillEvent skillEvent : useBuffSkillList) {
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
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isStormWhim = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof StormWhimBuff) {
                    isStormWhim = true;
                    break;
                }
            }
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
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack() && start.equals(se.getStart())) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (isStormWhim) {
                        if (ran <= stormWhim.getProp() && start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(stormWhim, start, end), buffSkill, start, end);
                        }
                    }
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= stormBringer.getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(stormBringer, start, end), buffSkill, start, end);
                    }
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= triflingWhim.getProp() && start.equals(se.getStart())) {
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= triflingWhimReinforce.getProp() && start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(triflingWhimReinforce, start, end), buffSkill, start, end);
                            totalDamage += getAttackDamage(new SkillEvent(triflingWhimReinforce, start, end), buffSkill, start, end);
                        } else if (start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(triflingWhim, start, end), buffSkill, start, end);
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

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        if (isCriticalReinforce) {
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP());
            buffSkill.addBuffCriticalDamage(criticalReinforce.getBuffCriticalDamage());
        }
        for (AttackSkill as : getAttackSkillList()) {
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
                            * (1 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
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
