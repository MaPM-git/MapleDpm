package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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

public class Blaster520DealCycle extends DealCycle {
    // 매그팡
    private final List<Skill> flatDeal1 = new ArrayList<>();

    // 릴파벙해머
    private final List<Skill> flatDeal2 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AfterImageShockActive());
            add(new AuraWeaponDot());
            add(new BurningBreakerDelay());
            add(new BurningBreakerExplosion());
            add(new BurningBreakerRush());
            add(new BurstPileBunker());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DoubleFang190());
            add(new DuckingCharge());
            add(new DuckingJump());
            add(new FinalAttackBlaster());
            add(new FinalDestroyer1());
            add(new FinalDestroyer2());
            add(new HammerSmashCharge());
            add(new HammerSmashDot());
            add(new HammerSmashJump());
            add(new MagnumPunch220());
            add(new MagnumPunch250());
            add(new ReleasePileBunker());
            add(new ReleasePileBunkerA());
            add(new ReleasePileBunkerB());
            add(new ReleasePileBunkerC());
            add(new ReleasePileBunkerD());
            add(new ResistanceLineInfantryDelay());
            add(new ResistanceLineInfantry());
            add(new RevolvingCannonDF());
            add(new RevolvingCannonMP());
            add(new RevolvingCannonReinforce());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new VulcanPunchBeforeDelay());
            add(new VulcanPunch());
            add(new VulcanPunchKeydown());
            add(new VulcanPunchAfterDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AfterImageShock());
            add(new AuraWeaponBuff());
            add(new BunkerBuster());
            add(new MapleWorldGoddessBlessing(275L));
            add(new MaximizeCanon());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
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

    public Blaster520DealCycle(Job job) {
        super(job, new FinalAttackBlaster());

        this.getJob().setName("블래스터(520)");

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        AfterImageShock afterImageShock = new AfterImageShock();
        BunkerBuster bunkerBuster = new BunkerBuster();
        BurningBreakerDelay burningBreakerDelay = new BurningBreakerDelay();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DoubleFang190 doubleFang190 = new DoubleFang190();
        DuckingCharge duckingCharge = new DuckingCharge();
        DuckingJump duckingJump = new DuckingJump();
        FinalDestroyer1 finalDestroyer1 = new FinalDestroyer1();
        HammerSmashJump hammerSmashJump = new HammerSmashJump();
        MagnumPunch220 magnumPunch220 = new MagnumPunch220();
        MagnumPunch250 magnumPunch250 = new MagnumPunch250();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MaximizeCanon maximizeCanon = new MaximizeCanon();
        ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
        ReleasePileBunker releasePileBunker = new ReleasePileBunker();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        VulcanPunch vulcanPunch = new VulcanPunch();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WillOfLiberty willOfLiberty = new WillOfLiberty();


        // 매그팡
        flatDeal1.add(duckingCharge);
        flatDeal1.add(magnumPunch220);
        flatDeal1.add(doubleFang190);
        flatDeal1.add(duckingJump);

        // 릴파벙해머
        flatDeal2.add(duckingCharge);
        flatDeal2.add(releasePileBunker);
        flatDeal2.add(hammerSmashJump);
        flatDeal2.add(duckingJump);
        flatDeal2.add(duckingCharge);
        flatDeal2.add(magnumPunch250);
        flatDeal2.add(doubleFang190);
        flatDeal2.add(duckingJump);

        ringSwitching.setCooldown(130.0);

        auraWeaponBuff.setCooldown(180.0);
        auraWeaponBuff.setApplyCooldownReduction(false);
        mapleWorldGoddessBlessing.setCooldown(180.0);

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(auraWeaponBuff)
                    && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            }
            if (cooldownCheck(resistanceLineInfantry)) {
                addSkillEvent(resistanceLineInfantry);
            }
            if (
                    cooldownCheck(afterImageShock)
                    && cooldownCheck(willOfLiberty)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(vulcanPunch)
                    && cooldownCheck(maximizeCanon)
                    && cooldownCheck(burningBreakerDelay)
                    && cooldownCheck(bunkerBuster)
            ) {
                addSkillEvent(afterImageShock);
                if (cooldownCheck(mapleWorldGoddessBlessing)) {
                    if (dealCycleOrder == 3) {
                        mapleWorldGoddessBlessing.setCooldown(0.0);
                    } else {
                        mapleWorldGoddessBlessing.setCooldown(180.0);
                    }
                    addSkillEvent(mapleWorldGoddessBlessing);
                }
                addSkillEvent(willOfLiberty);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addDealCycle(flatDeal1);
                }
                addSkillEvent(soulContract);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(vulcanPunch);
                addSkillEvent(maximizeCanon);
                addSkillEvent(burningBreakerDelay);
                addSkillEvent(bunkerBuster);
                if (cooldownCheck(finalDestroyer1)) {
                    addSkillEvent(finalDestroyer1);
                }
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(100 * 1000))
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
            if (
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
                    }/* else {
                        if (cooldownCheck(afterImageShockPassive)) {
                            getSkillEventList().add(new SkillEvent(afterImageShockPassive, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                            applyCooldown(afterImageShockPassive);
                        }
                    }*/
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
                        isMaximizeCannon
                                && (
                                se.getSkill() instanceof RevolvingCannonDF
                                        || se.getSkill() instanceof RevolvingCannonMP
                                        || se.getSkill() instanceof RevolvingCannonReinforce
                                        || se.getSkill() instanceof BurningBreakerExplosion
                                        || se.getSkill() instanceof BurningBreakerRush
                        )
                ) {
                    buffSkill.addBuffDamage(-35L);
                }
                if (
                        isBunkerBuster
                        && se.getSkill() instanceof HammerSmashJump
                        && start.equals(se.getStart())
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
                            * (1 - 0.5 * (1 - (getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
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
}
