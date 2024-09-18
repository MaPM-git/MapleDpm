package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.job.Shadower;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.shadower.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.shadower.HeartbreakerDarksight;
import org.mapledpmlab.type.skill.buffskill.shadower.SmokeBomb;
import org.mapledpmlab.type.skill.buffskill.shadower.VeilOfShadowBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ShadowerDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new Assassination());
            add(new AssassinationFinishCancle());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DarkFlare());
            add(new Eviscerate());
            add(new HeartbreakerCancle());
            add(new HeartbreakerCancleStack());
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
            add(new DarkSight());
            add(new EpicAdventure());
            add(new HeartbreakerDarksight());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SmokeBomb());
            add(new SoulContract());
            add(new UltimateDarkSight());
            add(new VeilOfShadowBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Long coinCount = 0L;

    Timestamp smokeBombEndTime = new Timestamp(-1);
    Timestamp ultimateDarkSightEndTime = new Timestamp(-1);

    Assassination assassination = new Assassination();
    AssassinationCancle assassinationCancle = new AssassinationCancle();
    AssassinationFinish assassinationFinish = new AssassinationFinish();
    AssassinationFinishCancle assassinationFinishCancle = new AssassinationFinishCancle();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DarkFlare darkFlare = new DarkFlare();
    EpicAdventure epicAdventure = new EpicAdventure();
    Eviscerate eviscerate = new Eviscerate();
    FatalVenom fatalVenom = new FatalVenom();
    Heartbreaker heartbreaker = new Heartbreaker();
    HeartbreakerCancle heartbreakerCancle = new HeartbreakerCancle();
    HeartbreakerCancleStack heartbreakerCancleStack = new HeartbreakerCancleStack();
    HeartbreakerFinish heartbreakerFinish = new HeartbreakerFinish();
    HeartbreakerFinishCancle heartbreakerFinishCancle = new HeartbreakerFinishCancle();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MesoExplosion mesoExplosion = new MesoExplosion();
    ReadyToDie readyToDie = new ReadyToDie();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SavageAssault1 savageAssault1 = new SavageAssault1();
    SlashShadowFormation slashShadowFormation = new SlashShadowFormation();
    SmokeBomb smokeBomb = new SmokeBomb();
    SonicBlowBeforeDelay sonicBlow = new SonicBlowBeforeDelay();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    UltimateDarkSight ultimateDarkSight = new UltimateDarkSight();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    VeilOfShadow veilOfShadow = new VeilOfShadow();

    public ShadowerDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        // 페이탈 베놈
        for (int i = 0; i < 720 * 1000; i += fatalVenom.getInterval()) {
            getSkillEventList().add(new SkillEvent(fatalVenom, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ultimateDarkSight.setBuffFinalDamage(1.29);

        ringSwitching.setCooldown(90.0);
        ringSwitching.setApplyCooldownReduction(false);

        mapleWorldGoddessBlessing.setCooldown(180.0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(darkFlare)) {
                addSkillEvent(darkFlare);
            }
            if (
                    cooldownCheck(epicAdventure)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(ultimateDarkSight)
                            && cooldownCheck(smokeBomb)
                            && cooldownCheck(readyToDie)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(slashShadowFormation)
                            && cooldownCheck(restraintRing)
                            && cooldownCheck(smokeBomb)
                            && cooldownCheck(eviscerate)
                            && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(assassination);
                    addSkillEvent(assassinationFinishCancle);
                    addSkillEvent(mesoExplosion);
                }
                addSkillEvent(ultimateDarkSight);
                addSkillEvent(smokeBomb);
                addSkillEvent(readyToDie);
                addSkillEvent(soulContract);
                addSkillEvent(assassination);
                addSkillEvent(slashShadowFormation);
                addSkillEvent(restraintRing);
                addSkillEvent(sonicBlow);
                if (cooldownCheck(savageAssault1)) {
                    addSkillEvent(savageAssault1);
                }
                addSkillEvent(eviscerate);
                addSkillEvent(mesoExplosion);
                for (int i = 0; i < 5; i++) {
                    addSkillEvent(heartbreakerCancleStack);
                    addSkillEvent(heartbreakerFinishCancle);
                    addSkillEvent(mesoExplosion);
                }
            } else if (
                    cooldownCheck(veilOfShadow)
                            && cooldownCheck(readyToDie)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(slashShadowFormation)
                            && cooldownCheck(sonicBlow)
                            && cooldownCheck(eviscerate)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(veilOfShadow);
                addSkillEvent(readyToDie);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(assassination);
                addSkillEvent(slashShadowFormation);
                addSkillEvent(sonicBlow);
                addSkillEvent(eviscerate);
                addSkillEvent(mesoExplosion);
                for (int i = 0; i < 2; i++) {
                    addSkillEvent(heartbreakerCancleStack);
                    addSkillEvent(heartbreakerFinishCancle);
                    addSkillEvent(mesoExplosion);
                }
            } else if (
                    getStart().after(smokeBombEndTime)
                            && cooldownCheck(veilOfShadow)
                            && getStart().before(new Timestamp(sonicBlow.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(veilOfShadow);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(sonicBlow)
                            && cooldownCheck(eviscerate)
                            && getStart().before(new Timestamp(700 * 1000))
            ) {
                addSkillEvent(sonicBlow);
                addSkillEvent(eviscerate);
                addSkillEvent(mesoExplosion);
                for (int i = 0; i < 2; i++) {
                    addSkillEvent(heartbreakerCancleStack);
                    addSkillEvent(heartbreakerFinishCancle);
                    addSkillEvent(mesoExplosion);
                }
            } else if (
                    cooldownCheck(eviscerate)
                            && getStart().before(new Timestamp(sonicBlow.getActivateTime().getTime() - 3000))
            ) {
                addSkillEvent(eviscerate);
            } else if (cooldownCheck(heartbreakerCancle)) {
                addSkillEvent(heartbreakerCancle);
                addSkillEvent(heartbreakerFinishCancle);
                addSkillEvent(mesoExplosion);
            } else {
                addSkillEvent(assassination);
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof SmokeBomb) {
                smokeBombEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof UltimateDarkSight) {
                ultimateDarkSightEndTime = new Timestamp(getStart().getTime() + 30000);
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
                getStart().before(smokeBombEndTime)
                && (
                        skill instanceof Heartbreaker
                        || skill instanceof HeartbreakerCancle
                )
        ) {
            skill.setCooldown(3.2);
            applyCooldown(skill);
            skill.setCooldown(10.0);
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
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isSmokeBomb = false;
            boolean isVeilOfShadow = false;
            boolean isUltimateDarkSight = false;
            boolean isHeartbreakerDarkSight = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof SmokeBomb) {
                    isSmokeBomb = true;
                } else if (skillEvent.getSkill() instanceof VeilOfShadowBuff) {
                    isVeilOfShadow = true;
                } else if (skillEvent.getSkill() instanceof UltimateDarkSight) {
                    isUltimateDarkSight = true;
                } else if (skillEvent.getSkill() instanceof HeartbreakerDarksight) {
                    isHeartbreakerDarkSight = true;
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
                if (
                        !isSmokeBomb
                        && !isVeilOfShadow
                        && !isHeartbreakerDarkSight
                        && !isUltimateDarkSight
                        && (
                                se.getSkill() instanceof Heartbreaker
                                || se.getSkill() instanceof HeartbreakerCancle
                                || se.getSkill() instanceof HeartbreakerCancleStack
                                || se.getSkill() instanceof HeartbreakerFinish
                                || se.getSkill() instanceof HeartbreakerFinishCancle
                        )
                ) {
                    buffSkill.addBuffFinalDamage(1.15);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        !isSmokeBomb
                                && !isVeilOfShadow
                                && !isHeartbreakerDarkSight
                                && !isUltimateDarkSight
                                && (
                                se.getSkill() instanceof Heartbreaker
                                        || se.getSkill() instanceof HeartbreakerCancle
                                        || se.getSkill() instanceof HeartbreakerCancleStack
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
                                || se.getSkill() instanceof HeartbreakerCancleStack
                                || se.getSkill() instanceof HeartbreakerFinish
                                || se.getSkill() instanceof HeartbreakerFinishCancle
                                || se.getSkill() instanceof SonicBlow
                                || se.getSkill() instanceof VeilOfShadow
                        )
                ) {
                    for (int j = 0; j < ((AttackSkill) se.getSkill()).getAttackCount() * 2; j++) {
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
                        totalDamage += getAttackDamage(new SkillEvent(se.getSkill(), start, end), buffSkill, start, end);
                    }
                    coinCount = 0L;
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
        attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                + getJob().getFinalSubstat() + ((Shadower) getJob()).getFinalSubStat2()) * 0.01
                * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                + getJob().getPerXAtt())
                * getJob().getConstant()
                        * (1 + (
                        getJob().getDamage()
                                + getJob().getBossDamage()
                                + getJob().getStatXDamage()
                                + buffSkill.getBuffDamage()
                                + attackSkill.getAddDamage()
                                - 310
                                - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01)
                ) * 0.01)
                * getJob().getMastery()
                * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
        );
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
                            + getJob().getFinalSubstat() + ((Shadower) getJob()).getFinalSubStat2()) * 0.01
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
