package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
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

    /*
        극딜: 얼닼사 에픽 메용2 레투다 엔버 바인드 암살멸귀참(캔슬) 시드링 소블 풀히트 암살 절개 평딜

        이후 소블 쿨 돌면 베일깔고 소블절개(캔슬)

        준극딜: 연막탄 레투다 엔버 암살멸귀참(캔슬) 소블 풀히트 암살 절개 평딜

        이후 소블 쿨 돌면 베일깔고 소블절개(캔슬)
     */

    // 6차, 리레, 연막탄, 얼닼사
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레, 6차X, 얼닼사
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜, 배오섀
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 준준극딜, 소닉 블로우 - 절개
    private List<Skill> dealCycle4 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AssassinationCancle());
            add(new AssassinationFinishCancle());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
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
            add(new SonicBlow());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new VeilOfShadow());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new SonicBlowAfterDelay());
            add(new SonicBlowBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new DarkSight());
            add(new EpicAdventure());
            add(new HeartbreakerDarksight());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new SmokeBomb());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UltimateDarkSight());
            add(new VeilOfShadowBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Long coinCount = 0L;

    Timestamp smokeBombEndTime = new Timestamp(-1);
    Timestamp ultimateDarkSightEndTime = new Timestamp(-1);

    int i=1;
    public ShadowerDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

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
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MesoExplosion mesoExplosion = new MesoExplosion();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SavageAssault1 savageAssault1 = new SavageAssault1();
        SlashShadowFormation slashShadowFormation = new SlashShadowFormation();
        SmokeBomb smokeBomb = new SmokeBomb();
        SonicBlowBeforeDelay sonicBlow = new SonicBlowBeforeDelay();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UltimateDarkSight ultimateDarkSight = new UltimateDarkSight();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        VeilOfShadow veilOfShadow = new VeilOfShadow();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 페이탈 베놈
        for (int i = 0; i < 720 * 1000; i += fatalVenom.getInterval()) {
            getSkillEventList().add(new SkillEvent(fatalVenom, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ultimateDarkSight.setBuffFinalDamage(1.29);

        ringSwitching.setCooldown(100.0);

        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(ultimateDarkSight);
        dealCycle1.add(smokeBomb);
        dealCycle1.add(readyToDie);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(assassinationCancle);
        dealCycle1.add(mesoExplosion);
        dealCycle1.add(slashShadowFormation);
        dealCycle1.add(assassinationFinishCancle);
        dealCycle1.add(mesoExplosion);
        dealCycle1.add(savageAssault1);
        dealCycle1.add(sonicBlow);
        dealCycle1.add(eviscerate);
        for (int i = 0; i < 5; i++) {
            dealCycle1.add(heartbreakerCancleStack);
            dealCycle1.add(mesoExplosion);
            dealCycle1.add(heartbreakerFinishCancle);
            dealCycle1.add(mesoExplosion);
        }

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(ultimateDarkSight);
        dealCycle2.add(readyToDie);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(assassinationCancle);
        dealCycle2.add(mesoExplosion);
        dealCycle2.add(slashShadowFormation);
        dealCycle2.add(assassinationFinishCancle);
        dealCycle2.add(mesoExplosion);
        dealCycle2.add(sonicBlow);
        dealCycle2.add(eviscerate);

        dealCycle3.add(veilOfShadow);
        dealCycle3.add(readyToDie);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(assassinationCancle);
        dealCycle3.add(mesoExplosion);
        dealCycle3.add(slashShadowFormation);
        dealCycle3.add(assassinationFinishCancle);
        dealCycle3.add(mesoExplosion);
        dealCycle3.add(sonicBlow);
        dealCycle3.add(eviscerate);
        for (int i = 0; i < 2; i++) {
            dealCycle3.add(heartbreakerCancleStack);
            dealCycle3.add(mesoExplosion);
            dealCycle3.add(heartbreakerFinishCancle);
            dealCycle3.add(mesoExplosion);
        }

        dealCycle4.add(heartbreakerCancle);
        dealCycle4.add(mesoExplosion);
        dealCycle4.add(heartbreakerFinishCancle);
        dealCycle4.add(mesoExplosion);
        dealCycle4.add(sonicBlow);
        dealCycle4.add(eviscerate);

        while (getStart().before(getEnd())) {
            if (cooldownCheck(darkFlare)) {
                addSkillEvent(darkFlare);
            }
            if (
                    getStart().after(mapleWorldGoddessBlessing.getEndTime())
                    && getStart().before(new Timestamp(90 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addSkillEvent(mapleWorldGoddessBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(smokeBomb)
                    && getStart().after(ultimateDarkSightEndTime)
                    && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(smokeBomb);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (cooldownCheck(dealCycle4)) {
                addDealCycle(dealCycle4);
            } else if (
                    cooldownCheck(eviscerate)
                    && getStart().before(new Timestamp(sonicBlow.getActivateTime().getTime() - 3000))
            ) {
                addSkillEvent(eviscerate);
            } else if (
                    cooldownCheck(heartbreakerCancle)
                    && getStart().before(new Timestamp(sonicBlow.getActivateTime().getTime() - 3000))
            ) {
                addSkillEvent(heartbreakerCancle);
                addSkillEvent(mesoExplosion);
                addSkillEvent(heartbreakerFinishCancle);
                addSkillEvent(mesoExplosion);
            } else {
                addSkillEvent(assassinationCancle);
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
            return;
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
                && (skill instanceof Heartbreaker
                || skill instanceof HeartbreakerCancle)
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
                buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
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
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : getAttackSkillList()) {
            if (
                    as instanceof Assassination
                    || as instanceof AssassinationCancle
                    || as instanceof AssassinationFinish
                    || as instanceof AssassinationFinishCancle
                    || as instanceof Eviscerate
                    || as instanceof Heartbreaker
                    || as instanceof HeartbreakerCancle
                    || as instanceof HeartbreakerCancleStack
                    || as instanceof HeartbreakerFinish
                    || as instanceof HeartbreakerFinishCancle
                    || as instanceof SavageAssault1
                    || as instanceof SavageAssault2
                    || as instanceof SavageAssault3
                    || as instanceof SonicBlow
                    || as instanceof VeilOfShadow
            ) {
                for (int i = 0; i < as.getAttackCount() * 2; i++) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 40) {
                        coinCount ++;
                    }
                }
            }
            if (as instanceof MesoExplosion) {
                ((MesoExplosion) as).setCoinCount(coinCount);
                coinCount = 0L;
            }
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                attackDamage = (long) Math.floor(((getJob().getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                        + getJob().getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
                        * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                        * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + getJob().getPerXAtt())
                        * getJob().getConstant()
                        * (1 + (getJob().getDamage() + getJob().getBossDamage() + getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (getJob().getFinalDamage() + buffSkill.getBuffPlusFinalDamage() - 1)
                        * buffSkill.getBuffFinalDamage()
                        * getJob().getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3 * (1 - buffSkill.getIgnoreDefense()) * (1 - getJob().getIgnoreDefense()) * (1 - getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                }
                Long distance = end.getTime() - start.getTime();
                if (as.getMultiAttackInfo().size() == 0 && as.getInterval() == 0 && as.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / as.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        return attackDamage;
    }
}
