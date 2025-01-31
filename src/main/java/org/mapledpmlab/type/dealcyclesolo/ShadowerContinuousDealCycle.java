package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.JobContinuous.ShadowerContinuous;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.shadower.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.shadower.CovertShadowBuff;
import org.mapledpmlab.type.skill.buffskill.shadower.HeartbreakerDarksight;
import org.mapledpmlab.type.skill.buffskill.shadower.SmokeBomb;
import org.mapledpmlab.type.skill.buffskill.shadower.VeilOfShadowBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ShadowerContinuousDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new Assassination());
            add(new AssassinationFinishCancle());
            add(new CovertShadow());
            add(new CovertShadowEdge());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DarkFlareShadower());
            add(new Eviscerate());
            add(new FatalVenom());
            add(new HeartbreakerCancle());
            add(new HeartbreakerFinishCancle());
            add(new MesoExplosion());
            add(new SavageAssault1());
            add(new SavageAssault2());
            add(new SavageAssault3());
            add(new SlashShadowFormation());
            add(new SlashShadowFormationBoss());
            add(new SonicBlowBeforeDelay());
            add(new SonicBlow());
            add(new SonicBlowAfterDelay());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new VeilOfShadow());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CovertShadowBuff());
            add(new DarkSight());
            add(new EpicAdventure());
            add(new HeartbreakerDarksight());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new ReadyToDie());
            add(new SmokeBomb());
            add(new SoulContract());
            add(new UltimateDarkSight());
            add(new VeilOfShadowBuff());
        }
    };

    Long coinCount = 20L;
    Long heartbreakerCount = 0L;
    Long tlqkf = 0L;

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp smokeBombEndTime = new Timestamp(-1);
    Timestamp ultimateDarkSightEndTime = new Timestamp(-1);
    Timestamp veilOfShadowEndTime = new Timestamp(-1);
    Timestamp darkSightChargeTime = new Timestamp(-1);

    boolean isNuke = false;
    boolean isSmokeBombCovertShadow = true;

    Assassination assassination = new Assassination();
    AssassinationCancle assassinationCancle = new AssassinationCancle();
    AssassinationFinish assassinationFinish = new AssassinationFinish();
    AssassinationFinishCancle assassinationFinishCancle = new AssassinationFinishCancle();
    ContinuousRing continuousRing = new ContinuousRing();
    CovertShadow covertShadow = new CovertShadow();
    CovertShadowBuff covertShadowBuff = new CovertShadowBuff();
    CovertShadowEdge covertShadowEdge = new CovertShadowEdge();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DarkFlareShadower darkFlareShadower = new DarkFlareShadower();
    EpicAdventure epicAdventure = new EpicAdventure();
    Eviscerate eviscerate = new Eviscerate();
    FatalVenom fatalVenom = new FatalVenom();
    Heartbreaker heartbreaker = new Heartbreaker();
    HeartbreakerCancle heartbreakerCancle = new HeartbreakerCancle();
    HeartbreakerFinish heartbreakerFinish = new HeartbreakerFinish();
    HeartbreakerFinishCancle heartbreakerFinishCancle = new HeartbreakerFinishCancle();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MesoExplosion mesoExplosion = new MesoExplosion();
    ReadyToDie readyToDie = new ReadyToDie();
    SavageAssault1 savageAssault1 = new SavageAssault1();
    SlashShadowFormation slashShadowFormation = new SlashShadowFormation();
    SmokeBomb smokeBomb = new SmokeBomb();
    SonicBlowBeforeDelay sonicBlow = new SonicBlowBeforeDelay();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    UltimateDarkSight ultimateDarkSight = new UltimateDarkSight();
    VeilOfShadow veilOfShadow = new VeilOfShadow();

    public ShadowerContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        // 페이탈 베놈
        for (int i = 0; i < 720 * 1000; i += fatalVenom.getInterval()) {
            getSkillEventList().add(new SkillEvent(fatalVenom, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ultimateDarkSight.setBuffFinalDamage(1.29);

        mapleWorldGoddessBlessing.setCooldown(180.0);

        getSkillSequence1().add(epicAdventure);             // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(ultimateDarkSight);
        getSkillSequence1().add(smokeBomb);
        getSkillSequence1().add(soulContract);              // 30
        getSkillSequence1().add(readyToDie);                // 600

        getSkillSequence2().add(soulContract);              // 30
        getSkillSequence2().add(readyToDie);                // 600

        mapleWorldGoddessBlessing.setDelay(100L);
        ultimateDarkSight.setDelay(100L);
        smokeBomb.setDelay(100L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(darkSightChargeTime)
                            && (
                            getStart().before(ultimateDarkSightEndTime)
                                    || getStart().before(veilOfShadowEndTime)
                                    || getStart().before(smokeBombEndTime)
                    )
            ) {
                Timestamp now = new Timestamp(getStart().getTime());
                getStart().setTime(darkSightChargeTime.getTime());
                addSkillEvent(covertShadowBuff);
                getStart().setTime(now.getTime());
                darkSightChargeTime = new Timestamp(darkSightChargeTime.getTime() + 9000);
            }
            if (cooldownCheck(darkFlareShadower)) {
                addSkillEvent(darkFlareShadower);
            }
            if (
                    cooldownCheck(ultimateDarkSight)
                    && cooldownCheck(eviscerate)
                    && cooldownCheck(sonicBlow)
                    && getStart().before(new Timestamp(600 * 1000))
            ) {
                isNuke = true;
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(assassination);
                addSkillEvent(slashShadowFormation);
                addSkillEvent(assassinationFinishCancle);
                addSkillEvent(mesoExplosion);
                addSkillEvent(sonicBlow);
                addSkillEvent(eviscerate);
                if (cooldownCheck(savageAssault1)) {
                    addSkillEvent(savageAssault1);
                }
                addSkillEvent(mesoExplosion);
                isNuke = false;
            } else if (
                    cooldownCheck(slashShadowFormation)
                            && cooldownCheck(sonicBlow)
                            && cooldownCheck(veilOfShadow)
                            && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(veilOfShadow);
                addDealCycle(getSkillSequence2());
                addSkillEvent(assassination);
                addSkillEvent(slashShadowFormation);
                addSkillEvent(assassinationFinishCancle);
                addSkillEvent(mesoExplosion);
                while (getStart().before(new Timestamp(eviscerate.getActivateTime().getTime() - 1800))) {
                    addSkillEvent(assassination);
                    addSkillEvent(assassinationFinishCancle);
                    addSkillEvent(mesoExplosion);
                }
                addSkillEvent(sonicBlow);
                addSkillEvent(eviscerate);
                addSkillEvent(mesoExplosion);
            } else if (
                    getStart().after(smokeBombEndTime)
                            && cooldownCheck(veilOfShadow)
                            && getStart().before(new Timestamp(sonicBlow.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(veilOfShadow);
            } else if (
                    cooldownCheck(sonicBlow)
                            && cooldownCheck(eviscerate)
                            && !cooldownCheck(readyToDie)
                            && getStart().before(new Timestamp(700 * 1000))
            ) {
                addSkillEvent(sonicBlow);
                addSkillEvent(eviscerate);
                addSkillEvent(mesoExplosion);
            } else if (
                    cooldownCheck(eviscerate)
                            && getStart().before(new Timestamp(sonicBlow.getActivateTime().getTime() - 8000))
            ) {
                addSkillEvent(eviscerate);
            } else if (
                    cooldownCheck(heartbreakerCancle)
                    || heartbreakerCount > 0
            ) {
                if (heartbreakerCount > 0) {
                    heartbreakerCancle.setActivateTime(new Timestamp(-1));
                }
                addSkillEvent(heartbreakerCancle);
                addSkillEvent(mesoExplosion);
                addSkillEvent(heartbreakerFinishCancle);
                addSkillEvent(mesoExplosion);
            } else {
                addSkillEvent(assassination);
                addSkillEvent(mesoExplosion);
                addSkillEvent(assassinationFinishCancle);
                addSkillEvent(mesoExplosion);
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
        if (skill instanceof BuffSkill) {
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (skill instanceof SmokeBomb) {
                smokeBombEndTime = new Timestamp(getStart().getTime() + 30000);
                isSmokeBombCovertShadow = false;
                heartbreakerCount += 3;
            }
            if (skill instanceof UltimateDarkSight) {
                ultimateDarkSightEndTime = new Timestamp(getStart().getTime() + 33000);
                darkSightChargeTime = new Timestamp(getStart().getTime() + 9000);
            }
            if (skill instanceof VeilOfShadowBuff) {
                veilOfShadowEndTime = new Timestamp(veilOfShadowEndTime.getTime() + 12000);
                heartbreakerCount += 2;
            }
            if (skill instanceof DarkSight) {
                darkSightChargeTime = new Timestamp(getStart().getTime() + 9000);
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
                            || skill instanceof Assassination
                            || skill instanceof AssassinationCancle
                            || skill instanceof AssassinationFinish
                            || skill instanceof AssassinationFinishCancle
                            || skill instanceof Eviscerate
                            || skill instanceof Heartbreaker
                            || skill instanceof HeartbreakerCancle
                            || skill instanceof HeartbreakerFinish
                            || skill instanceof HeartbreakerFinishCancle
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof Assassination
                    || skill instanceof AssassinationCancle
                    || skill instanceof AssassinationFinish
                    || skill instanceof AssassinationFinishCancle
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 20) {
                    heartbreakerCount ++;
                }
            }
            if (
                    !isSmokeBombCovertShadow
                            && getStart().before(smokeBombEndTime)
                            && (
                            skill instanceof SpiderInMirror
                                    || skill instanceof CrestOfTheSolar
                                    || skill instanceof Assassination
                                    || skill instanceof AssassinationCancle
                                    || skill instanceof AssassinationFinish
                                    || skill instanceof AssassinationFinishCancle
                                    || skill instanceof Eviscerate
                                    || skill instanceof Heartbreaker
                                    || skill instanceof HeartbreakerCancle
                                    || skill instanceof HeartbreakerFinish
                                    || skill instanceof HeartbreakerFinishCancle
                                    || skill instanceof SavageAssault1
                                    || skill instanceof SavageAssault2
                                    || skill instanceof SavageAssault3
                                    || skill instanceof SonicBlow
                                    || skill instanceof SonicBlowAfterDelay
                                    || skill instanceof SonicBlowBeforeDelay
                    )
            ) {
                isSmokeBombCovertShadow = true;
                addSkillEvent(covertShadowBuff);
                darkSightChargeTime = new Timestamp(getStart().getTime() + 9000);
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
                getSkillEventList().removeAll(remove);
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
                        Timestamp now = new Timestamp(getStart().getTime());
                        getStart().setTime(getStart().getTime() + i);
                        if (
                                cooldownCheck(continuousRing)
                                && skill instanceof SonicBlow
                        ) {
                            addSkillEvent(continuousRing);
                        }
                        getStart().setTime(now.getTime());
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
        if (
                heartbreakerCount > 0
                && (
                        skill instanceof Heartbreaker
                        || skill instanceof HeartbreakerCancle
                )
        ) {
            heartbreakerCount --;
        } else if (
                getStart().before(smokeBombEndTime)
                && (
                        skill instanceof Heartbreaker
                        || skill instanceof HeartbreakerCancle
                )
        ) {
            skill.setCooldown(3.0);
            skill.setApplyCooldownReduction(false);
            applyCooldown(skill);
            skill.setCooldown(10.0);
            skill.setApplyCooldownReduction(true);
        } else {
            applyCooldown(skill);
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
                        if (bs.getStartTimeList().size() == 0) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        } else if (skillEvent.getStart().after(bs.getStartTimeList().get(bs.getStartTimeList().size() - 1))) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        }
                    }
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
            boolean isSmokeBomb = false;
            boolean isVeilOfShadow = false;
            boolean isUltimateDarkSight = false;
            boolean isHeartbreakerDarkSight = false;
            boolean isCovertShadow = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof SmokeBomb) {
                    isSmokeBomb = true;
                    isCovertShadow = true;
                } else if (skillEvent.getSkill() instanceof VeilOfShadowBuff) {
                    isVeilOfShadow = true;
                } else if (skillEvent.getSkill() instanceof UltimateDarkSight) {
                    isUltimateDarkSight = true;
                } else if (skillEvent.getSkill() instanceof HeartbreakerDarksight) {
                    isHeartbreakerDarkSight = true;
                } else if (skillEvent.getSkill() instanceof CovertShadowBuff) {
                    isCovertShadow = true;
                }
            }
            if (isUltimateDarkSight) {
            } else if (
                    isSmokeBomb
                    || isVeilOfShadow
                    || isHeartbreakerDarkSight
            ) {
                buffSkill.addBuffFinalDamage(1.15);
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
                if (
                        !isSmokeBomb
                        && !isVeilOfShadow
                        && !isHeartbreakerDarkSight
                        && !isUltimateDarkSight
                        && (
                                se.getSkill() instanceof Heartbreaker
                                || se.getSkill() instanceof HeartbreakerCancle
                                || se.getSkill() instanceof HeartbreakerFinish
                                || se.getSkill() instanceof HeartbreakerFinishCancle
                        )
                ) {
                    buffSkill.addBuffFinalDamage(1.15);
                }
                if (!(se.getSkill() instanceof MesoExplosion)) {
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                }
                if (
                        !isSmokeBomb
                                && !isVeilOfShadow
                                && !isHeartbreakerDarkSight
                                && !isUltimateDarkSight
                                && (
                                se.getSkill() instanceof Heartbreaker
                                        || se.getSkill() instanceof HeartbreakerCancle
                                        || se.getSkill() instanceof HeartbreakerFinish
                                        || se.getSkill() instanceof HeartbreakerFinishCancle
                        )
                ) {
                    buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.15);
                }
                if (
                        se.getStart().equals(start)
                        && (
                                se.getSkill() instanceof Assassination
                                || se.getSkill() instanceof AssassinationCancle
                                || se.getSkill() instanceof AssassinationFinish
                                || se.getSkill() instanceof AssassinationFinishCancle
                                || se.getSkill() instanceof Eviscerate
                                || se.getSkill() instanceof Heartbreaker
                                || se.getSkill() instanceof HeartbreakerCancle
                                || se.getSkill() instanceof HeartbreakerFinish
                                || se.getSkill() instanceof HeartbreakerFinishCancle
                                || se.getSkill() instanceof SonicBlow
                                || se.getSkill() instanceof VeilOfShadow
                        )
                ) {
                    for (int j = 0; j < ((AttackSkill) se.getSkill()).getAttackCount(); j++) {
                        Long ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 40) {
                            coinCount++;
                        }
                        if (coinCount > 20) {
                            coinCount = 20L;
                            break;
                        }
                    }
                }
                if (se.getSkill() instanceof MesoExplosion) {
                    for (int j = 0; j < coinCount; j++) {
                        totalDamage += getAttackDamage(new SkillEvent(se.getSkill(), start, start), buffSkill, start, start);
                        if (isCovertShadow) {
                            totalDamage += getAttackDamage(new SkillEvent(covertShadowEdge, start, start), buffSkill, start, start);
                        } else {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= covertShadow.getProp()) {
                                totalDamage += getAttackDamage(new SkillEvent(covertShadow, start, start), buffSkill, start, start);
                            }
                        }
                    }
                    coinCount = 0L;
                }
                if (
                        se.getStart().equals(start)
                        && (
                                se.getSkill() instanceof SavageAssault1
                                || se.getSkill() instanceof SavageAssault2
                                || se.getSkill() instanceof SavageAssault3
                                || se.getSkill() instanceof SonicBlow
                                || se.getSkill() instanceof Assassination
                                || se.getSkill() instanceof AssassinationCancle
                                || se.getSkill() instanceof AssassinationFinish
                                || se.getSkill() instanceof AssassinationFinishCancle
                                || se.getSkill() instanceof Eviscerate
                                || se.getSkill() instanceof Heartbreaker
                                || se.getSkill() instanceof HeartbreakerCancle
                                || se.getSkill() instanceof HeartbreakerFinish
                                || se.getSkill() instanceof HeartbreakerFinishCancle
                        )
                ) {
                    if (isCovertShadow) {
                        totalDamage += getAttackDamage(new SkillEvent(covertShadowEdge, start, start), buffSkill, start, start);
                    } else {
                        Long ran = (long) (Math.random() * 99 + 1);
                        if (ran <= covertShadow.getProp()) {
                            totalDamage += getAttackDamage(new SkillEvent(covertShadow, start, start), buffSkill, start, start);
                        }
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public Long getDotDamage(AttackSkill attackSkill, BuffSkill buffSkill) {
        Long attackDamage;
        if (buffSkill.getBuffDamage() >= 140) {
            attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                    + getJob().getFinalSubstat() + ((ShadowerContinuous) getJob()).getFinalSubStat2()) * 0.01
                    * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                    * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                    + getJob().getPerXAtt())
                    * getJob().getConstant()
                    * getJob().getMastery()
                    * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                    * (1 + (getJob().getBossDamage() + 140 - 280) * 0.01 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
            );
        } else {
            attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                    + getJob().getFinalSubstat() + ((ShadowerContinuous) getJob()).getFinalSubStat2()) * 0.01
                    * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                    * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                    + getJob().getPerXAtt())
                    * getJob().getConstant()
                    * getJob().getMastery()
                    * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                    * (1 + (getJob().getBossDamage() - 280) * 0.01 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
            );
        }
        return attackDamage;
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
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
                            + getJob().getFinalSubstat() + ((ShadowerContinuous) getJob()).getFinalSubStat2()) * 0.01
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
        return attackDamage;
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
                            skill instanceof SavageAssault1
                            || skill instanceof SavageAssault2
                            || skill instanceof SavageAssault3
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            getStart().setTime(now.getTime());
        }
    }

    @Override
    public void getJobInfo() {
        System.out.println("-------------------");
        System.out.println("직업 : " + getJob().getName());
        System.out.println("기본 주스탯 수치 : " + getJob().getMainStat());
        System.out.println("주스탯 % 수치 : " + (getJob().getMainStatP() + getJob().getAllStatP()));
        System.out.println("% 미적용 주스탯 수치 : " + getJob().getPerXMainStat());
        System.out.println("기본 부스탯 수치 : " + getJob().getSubStat());
        System.out.println("부스탯 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXSubStat());
        System.out.println("기본 부스탯2 수치 : " + getJob().getOtherStat1());
        System.out.println("부스탯2 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXOtherStat());
        System.out.println("기본 스공 : " + getJob().getStatDamage());
        System.out.println("데미지 : " + getJob().getDamage());
        System.out.println("최종데미지 : " + getJob().getFinalDamage());
        System.out.println("보스 데미지 : " + getJob().getBossDamage());
        System.out.println("방어율 무시 : " + getJob().getIgnoreDefense());
        System.out.println("크리티컬 확률 : " + getJob().getCriticalP());
        System.out.println("장비 공격력 % : " + getJob().getAttP());
        System.out.println("장비 마력 % : " + getJob().getMagicP());
        System.out.println("크리티컬 데미지 : " + getJob().getCriticalDamage());
        System.out.println("쿨타임 감소 초 : " + getJob().getCooldownReductionSec());
        System.out.println("쿨타임 감소 % : " + getJob().getCooldownReductionP());
        System.out.println("버프 지속 시간 : " + getJob().getPlusBuffDuration());
        System.out.println("재사용 : " + getJob().getReuse());
        System.out.println("속성 내성 무시 : " + getJob().getProperty());
        System.out.println("무기 공격력 : " + getJob().getWeaponAttMagic());
        System.out.println(getJob().getLinkListStr());
        System.out.println(getJob().getAbility().getDescription());
    }
}
