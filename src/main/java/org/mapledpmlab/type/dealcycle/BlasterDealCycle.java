package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.blaster.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.blaster.AfterImageShock;
import org.mapledpmlab.type.skill.buffskill.blaster.BunkerBuster;
import org.mapledpmlab.type.skill.buffskill.blaster.MaximizeCanon;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BlasterDealCycle extends DealCycle {
    /*
     */

    // 메용2, 6차, 리레, 스인미, 크오솔
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private List<Skill> dealCycle4 = new ArrayList<>();

    // 웨폰퍼프
    private List<Skill> dealCycle5 = new ArrayList<>();

    // 매그팡
    private List<Skill> flatDeal1 = new ArrayList<>();

    // 릴파벙해머
    private List<Skill> flatDeal2 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AfterImageShockActive());
            add(new AfterImageShockPassive());
            add(new BurningBreakerExplosion());
            add(new BurningBreakerRush());
            add(new BurstPileBunker());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DoubleFang());
            add(new FinalAttackBlaster());
            add(new FinalDestroyer1());
            add(new FinalDestroyer2());
            add(new HammerSmashDot());
            add(new HammerSmashJump());
            add(new MagnumPunch());
            add(new MagnumPunch250());
            add(new ReleasePileBunker());
            add(new ReleasePileBunkerA());
            add(new ReleasePileBunkerB());
            add(new ReleasePileBunkerC());
            add(new ReleasePileBunkerD());
            add(new ResistanceLineInfantry());
            add(new RevolvingCannonDF());
            add(new RevolvingCannonMP());
            add(new RevolvingCannonReinforce());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new VulcanPunch());
            add(new VulcanPunchKeydown());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new BurningBreakerDelay());
            add(new DuckingCharge());
            add(new DuckingJump());
            add(new HammerSmashCharge());
            add(new ResistanceLineInfantryDelay());
            add(new VulcanPunchAfterDelay());
            add(new VulcanPunchBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AfterImageShock());
            add(new BunkerBuster());
            add(new MapleWorldGoddessBlessing(275L));
            add(new MaximizeCanon());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(707L));
            add(new WillOfLiberty());
        }
    };

    int cylinder = 0;
    int afterImageShockActiveCount = 0;
    int releasePileBunkerCount = 5;
    Timestamp overheatTime = new Timestamp(-1);
    Timestamp maximizeCannonEndTime = new Timestamp(-1);
    Timestamp afterImageShockEndTime = new Timestamp(-1);
    boolean isMaximizeCannon = false;

    AfterImageShockActive afterImageShockActive = new AfterImageShockActive();
    AfterImageShockPassive afterImageShockPassive = new AfterImageShockPassive();
    BurstPileBunker burstPileBunker = new BurstPileBunker();

    public BlasterDealCycle(Job job) {
        super(job, new FinalAttackBlaster());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        AfterImageShock afterImageShock = new AfterImageShock();
        BunkerBuster bunkerBuster = new BunkerBuster();
        BurningBreakerDelay burningBreakerDelay = new BurningBreakerDelay();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DoubleFang doubleFang = new DoubleFang();
        DuckingCharge duckingCharge = new DuckingCharge();
        DuckingJump duckingJump = new DuckingJump();
        FinalDestroyer1 finalDestroyer1 = new FinalDestroyer1();
        HammerSmashJump hammerSmashJump = new HammerSmashJump();
        MagnumPunch magnumPunch = new MagnumPunch();
        MagnumPunch250 magnumPunch250 = new MagnumPunch250();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MaximizeCanon maximizeCanon = new MaximizeCanon();
        PriorPreparation priorPreparation = new PriorPreparation();
        ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
        ReleasePileBunker releasePileBunker = new ReleasePileBunker();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        VulcanPunch vulcanPunch = new VulcanPunch();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WillOfLiberty willOfLiberty = new WillOfLiberty();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        // 1-4-3-2-5-4
        // 메용2, 6차, 리레, 스인미, 크오솔
        dealCycle1.add(afterImageShock);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(willOfLiberty);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(vulcanPunch);
        dealCycle1.add(maximizeCanon);
        dealCycle1.add(burningBreakerDelay);
        dealCycle1.add(bunkerBuster);
        dealCycle1.add(finalDestroyer1);

        // 메용2, 6차, 웨폰퍼프
        dealCycle2.add(afterImageShock);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(willOfLiberty);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(vulcanPunch);
        dealCycle2.add(maximizeCanon);
        dealCycle2.add(burningBreakerDelay);
        dealCycle2.add(bunkerBuster);
        dealCycle2.add(finalDestroyer1);

        // 메용2, 리레, 스인미, 코오솔
        dealCycle3.add(afterImageShock);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(willOfLiberty);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);
        dealCycle3.add(vulcanPunch);
        dealCycle3.add(maximizeCanon);
        dealCycle3.add(burningBreakerDelay);
        dealCycle3.add(bunkerBuster);

        // 메용2, 웨폰퍼프
        dealCycle4.add(afterImageShock);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(willOfLiberty);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(vulcanPunch);
        dealCycle4.add(maximizeCanon);
        dealCycle4.add(burningBreakerDelay);
        dealCycle4.add(bunkerBuster);

        // 리레
        dealCycle5.add(afterImageShock);
        dealCycle5.add(willOfLiberty);
        dealCycle5.add(crestOfTheSolar);
        dealCycle5.add(spiderInMirror);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);
        dealCycle5.add(vulcanPunch);
        dealCycle5.add(maximizeCanon);
        dealCycle5.add(burningBreakerDelay);
        dealCycle5.add(bunkerBuster);

        // 매그팡      440ms
        flatDeal1.add(duckingCharge);
        flatDeal1.add(magnumPunch);
        flatDeal1.add(doubleFang);
        flatDeal1.add(duckingJump);

        // 릴파벙해머    310ms - 540
        flatDeal2.add(duckingCharge);
        flatDeal2.add(releasePileBunker);
        flatDeal2.add(hammerSmashJump);
        flatDeal2.add(duckingJump);
        flatDeal2.add(duckingCharge);
        flatDeal2.add(magnumPunch250);
        flatDeal2.add(doubleFang);
        flatDeal2.add(duckingJump);

        // 쿨마다 발칸, 인팬트리 사용

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 1
            ) {
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
            ) {
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 3
            ) {
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 5
            ) {
                addDealCycle(dealCycle5);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(9 * 60 * 1000)))
            {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(vulcanPunch)
                    && cooldownCheck(soulContract)
                    && !cooldownCheck(burningBreakerDelay)
            ) {
                addSkillEvent(soulContract);
                addSkillEvent(vulcanPunch);
            } else if (
                    cooldownCheck(resistanceLineInfantry)
            ) {
                addSkillEvent(resistanceLineInfantry);
            } else if (
                    getStart().after(overheatTime)
                    && cylinder == 6
            ) {
                addDealCycle(flatDeal2);
            } else {
                addDealCycle(flatDeal1);
            }
        }
        sortEventTimeList();
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (
                cylinder != 6
                && (
                        skill instanceof RevolvingCannonDF
                        || skill instanceof RevolvingCannonMP
                        || skill instanceof RevolvingCannonReinforce
                )
        ) {
            cylinder ++;
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
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (
                    skill instanceof ReleasePileBunker
                            && releasePileBunkerCount == 5
            ) {
                skill = new BurstPileBunker();
                releasePileBunkerCount = 0;
            }
            if (skill instanceof ReleasePileBunker) {
                releasePileBunkerCount ++;
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
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                if (((AttackSkill) skill).isApplyFinalAttack()) {
                    if (getStart().before(afterImageShockEndTime)) {
                        if (cooldownCheck(afterImageShockActive)) {
                            getSkillEventList().add(new SkillEvent(afterImageShockActive, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                            applyCooldown(afterImageShockActive);
                            afterImageShockActiveCount ++;
                            if (afterImageShockActiveCount == 49) {
                                afterImageShockEndTime = new Timestamp(-1);
                                afterImageShockActiveCount = 0;
                            }
                        }
                    } else {
                        if (cooldownCheck(afterImageShockPassive)) {
                            getSkillEventList().add(new SkillEvent(afterImageShockPassive, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                            applyCooldown(afterImageShockPassive);
                        }
                    }
                }
            }
        }
        applyCooldown(skill);
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
            if (skill instanceof MaximizeCanon) {
                maximizeCannonEndTime = endTime;
            }
            if (skill instanceof AfterImageShock) {
                afterImageShockEndTime = endTime;
                afterImageShockActiveCount = 0;
            }
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill instanceof ReleasePileBunker) {
            if (isMaximizeCannon) {
                overheatTime = new Timestamp(getStart().getTime() + 1000);
            } else {
                overheatTime = new Timestamp(getStart().getTime() + 7000);
            }
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

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
            boolean isBunkerBuster = false;
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof MaximizeCanon) {
                    isMaximizeCannon = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof BunkerBuster) {
                    isBunkerBuster = true;
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
                buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            for (SkillEvent se : useAttackSkillList) {
                if (
                        isMaximizeCannon
                        && (
                                se.getSkill() instanceof RevolvingCannonDF
                                || se.getSkill() instanceof RevolvingCannonMP
                                || se.getSkill() instanceof RevolvingCannonReinforce
                                || se.getSkill() instanceof BurningBreakerExplosion
                                || se.getSkill() instanceof BurningBreakerRush
                        )
                ) {
                    buffSkill.addBuffDamage(35L);
                }
                if (
                        isBunkerBuster
                        && (
                                se.getSkill() instanceof RevolvingCannonDF
                                || se.getSkill() instanceof RevolvingCannonMP
                        )
                ) {
                    se.setSkill(new RevolvingCannonReinforce());
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isBunkerBuster
                        && se.getSkill() instanceof HammerSmashJump
                ) {
                    totalDamage += getAttackDamage(new SkillEvent(new RevolvingCannonReinforce(), start, end), buffSkill, start, end);
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        getFinalAttack().setFinalDamage(2.2);
                        ((FinalAttackBlaster) getFinalAttack()).applyGauge(cylinder);
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            isMaximizeCannon = false;
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
