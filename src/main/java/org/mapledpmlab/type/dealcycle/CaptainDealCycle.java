package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.captain.*;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.captain.UntiringNectar;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CaptainDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AssembleCrewDelay());
            add(new BattleShipBomber());
            add(new BulletPartyBeforeDelay());
            add(new BulletParty());
            add(new BulletPartyAfterDelay());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DeadEye());
            add(new DeathTriggerBeforeDelay());
            add(new DeathTrigger());
            add(new DeathTriggerLoopDelay());
            add(new DeathTriggerAfterDelay());
            add(new Dreadnought());
            add(new DreadnoughtBombard());
            add(new DualPistolCrew());
            add(new DualPistolCrewNectar());
            add(new FinalAttackCaptain());
            add(new HeadShot());
            add(new MarksmanCrew());
            add(new MarksmanCrewNectar());
            add(new NautilusAssaultHull());
            add(new NautilusAssaultVolleyFire());
            add(new RapidFire());
            add(new RapidFireSpree());
            add(new SiegeBomber());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new EpicAdventure());
            add(new LuckyDice());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(249L));
            add(new OverdriveDebuff(249L));
            add(new PirateFlag());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new UntiringNectar());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    boolean isQuickDraw = false;

    Long clipCount = 48L;

    Timestamp spreeEndTime = new Timestamp(-1);

    AssembleCrewDelay assembleCrewDelay = new AssembleCrewDelay();
    BattleShipBomber battleShipBomber = new BattleShipBomber();
    BulletPartyBeforeDelay bulletParty = new BulletPartyBeforeDelay();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DeadEye deadEye = new DeadEye();
    DeathTrigger deathTrigger = new DeathTrigger();
    DeathTriggerBeforeDelay deathTriggerStart = new DeathTriggerBeforeDelay();
    Dreadnought dreadnought = new Dreadnought();
    EpicAdventure epicAdventure = new EpicAdventure();
    HeadShot headShot = new HeadShot();
    LuckyDice luckyDice = new LuckyDice();
    LuckyDiceOneMoreChance luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    NautilusAssaultHull nautilusAssaultHull = new NautilusAssaultHull();
    Overdrive overdrive = new Overdrive(249L);
    PirateFlag pirateFlag = new PirateFlag();
    RapidFire rapidFire = new RapidFire();
    RapidFireSpree rapidFireSpree = new RapidFireSpree();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SiegeBomber siegeBomber = new SiegeBomber();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    UntiringNectar untiringNectar = new UntiringNectar();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public CaptainDealCycle(Job job) {
        super(job, new FinalAttackCaptain());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(100.0);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());

        mapleWorldGoddessBlessing.setCooldown(180.0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(luckyDice)) {
                luckyDice = new LuckyDice();
                addSkillEvent(luckyDice);
            }
            if (cooldownCheck(assembleCrewDelay)) {
                addSkillEvent(assembleCrewDelay);
            }
            if (cooldownCheck(battleShipBomber)) {
                addSkillEvent(battleShipBomber);
            }
            if (cooldownCheck(siegeBomber)) {
                addSkillEvent(siegeBomber);
            }
            if (
                    cooldownCheck(epicAdventure)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(pirateFlag)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(untiringNectar)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(restraintRing)
                            && cooldownCheck(headShot)
                            && cooldownCheck(deathTriggerStart)
                            && cooldownCheck(nautilusAssaultHull)
                            && cooldownCheck(deadEye)
                            && cooldownCheck(bulletParty)
            ) {
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(rapidFire);
                    clipCount ++;
                    if (clipCount >= 50) {
                        spreeEndTime = new Timestamp(getStart().getTime() + 6000);
                        clipCount = 0L;
                    }
                }
                addSkillEvent(pirateFlag);
                addSkillEvent(overdrive);
                addSkillEvent(untiringNectar);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(headShot);
                addSkillEvent(nautilusAssaultHull);
                if (cooldownCheck(dreadnought)) {
                    addSkillEvent(dreadnought);
                }
                addSkillEvent(deathTriggerStart);
                if (cooldownCheck(headShot)) {
                    addSkillEvent(headShot);
                }
                addSkillEvent(deadEye);
                addSkillEvent(bulletParty);
            } else if (
                    cooldownCheck(pirateFlag)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(untiringNectar)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(weaponJumpRing)
                            && cooldownCheck(headShot)
                            && cooldownCheck(deathTriggerStart)
                            && cooldownCheck(deadEye)
                            && cooldownCheck(bulletParty)
            ) {
                addSkillEvent(pirateFlag);
                addSkillEvent(overdrive);
                addSkillEvent(untiringNectar);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(headShot);
                addSkillEvent(deathTriggerStart);
                addSkillEvent(deadEye);
                addSkillEvent(bulletParty);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(pirateFlag)
                            && getStart().before(new Timestamp(soulContract.getActivateTime().getTime()))
            ) {
                addSkillEvent(pirateFlag);
            } else if (
                    cooldownCheck(deathTriggerStart)
                            && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(deathTriggerStart);
            } else if (
                    cooldownCheck(deadEye)
                            && getStart().before(new Timestamp(untiringNectar.getActivateTime().getTime() - 25000))
            ) {
                addSkillEvent(deadEye);
            } else if (
                    cooldownCheck(headShot)
                            && !cooldownCheck(untiringNectar)
            ) {
                addSkillEvent(headShot);
            } else if (
                    getStart().before(spreeEndTime)
            ) {
                addSkillEvent(rapidFireSpree);
            } else {
                addSkillEvent(rapidFire);
                clipCount ++;
                if (clipCount >= 50) {
                    spreeEndTime = new Timestamp(getStart().getTime() + 6000);
                    clipCount = 0L;
                }
            }
        }
        sortEventTimeList();
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
            boolean isUntiringNectar = false;
            for (int j = 0; i < useBuffSkillList.size(); i++) {
                if (useBuffSkillList.get(j).getSkill() instanceof UntiringNectar) {
                    isUntiringNectar = true;
                    break;
                }
            }
            if (isUntiringNectar) {
                for (int j = 0; j < useAttackSkillList.size(); j++) {
                    if (useAttackSkillList.get(j).getSkill() instanceof DualPistolCrew) {
                        useAttackSkillList.remove(j);
                    }
                }
                for (int j = 0; j < useAttackSkillList.size(); j++) {
                    if (useAttackSkillList.get(j).getSkill() instanceof MarksmanCrew) {
                        useAttackSkillList.remove(j);
                    }
                }
            }
            for (SkillEvent skillEvent : useBuffSkillList) {
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
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            for (SkillEvent se : useAttackSkillList) {
                if (
                        isUntiringNectar
                        && (
                                se.getSkill() instanceof DualPistolCrewNectar
                                || se.getSkill() instanceof MarksmanCrewNectar
                                || se.getSkill() instanceof SiegeBomber
                                || se.getSkill() instanceof BattleShipBomber
                        )
                ) {
                    buffSkill.addBuffFinalDamage(1.5);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isUntiringNectar
                        && (
                                se.getSkill() instanceof DualPistolCrewNectar
                                || se.getSkill() instanceof MarksmanCrewNectar
                                || se.getSkill() instanceof SiegeBomber
                                || se.getSkill() instanceof BattleShipBomber
                        )
                ) {
                    buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.5);
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            isUntiringNectar = false;
            /*for (int j = 0; i < overlappingSkillEvents.size(); i++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof BattleShipBomber) {

                    ((AttackSkill) overlappingSkillEvents.get(j).getSkill()).setDamage(403.0);
                }
            }
            for (int j = 0; i < overlappingSkillEvents.size(); i++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof SiegeBomber) {
                    ((AttackSkill) overlappingSkillEvents.get(j).getSkill()).setDamage(300.0);
                }
            }*/
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof UntiringNectar) {
                DualPistolCrewNectar dualPistolCrewNectar = new DualPistolCrewNectar();
                MarksmanCrewNectar marksmanCrewNectar = new MarksmanCrewNectar();

                for (long i = getStart().getTime(); i < getStart().getTime() + 20000; i += dualPistolCrewNectar.getInterval()) {
                    getSkillEventList().add(new SkillEvent(dualPistolCrewNectar, new Timestamp(i), new Timestamp(i)));
                    getEventTimeList().add(new Timestamp(i));
                }

                for (long i = getStart().getTime(); i < getStart().getTime() + 20000; i += marksmanCrewNectar.getInterval()) {
                    getSkillEventList().add(new SkillEvent(marksmanCrewNectar, new Timestamp(i), new Timestamp(i)));
                    getEventTimeList().add(new Timestamp(i));
                }
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
                if (skill instanceof OverdriveDebuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 28000), new Timestamp(getStart().getTime() + (long) (applyCooldownReduction(skill) * 1000))));
                } else {
                    endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
            Long ran = (long) (Math.random() * 99 + 1);
            if (ran <= 9) {
                isQuickDraw = true;
                //quickDrawTimeList.add(new Timestamp(getStart().getTime()));
            }
            if (isQuickDraw) {
               /*     && (
                        skill instanceof HeadShot
                                || skill instanceof DeadEye
                )*/
                if (skill instanceof HeadShot) {
                    skill = new HeadShot();
                    ((AttackSkill) skill).addFinalDamage(1.26);
                    applyCooldown(headShot);
                } else if (skill instanceof DeadEye) {
                    skill = new DeadEye();
                    ((AttackSkill) skill).addFinalDamage(1.26);
                    applyCooldown(deadEye);
                }
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                            && !(skillEvent.getSkill() instanceof DeathTrigger)
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
                        if (skill instanceof DeathTriggerLoopDelay) {
                            for (long j = deathTrigger.getInterval(); j <= deathTrigger.getDotDuration(); j += deathTrigger.getInterval()) {
                                getSkillEventList().add(new SkillEvent(deathTrigger, new Timestamp(getStart().getTime() + i + j), new Timestamp(getStart().getTime() + i + j)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + i + j));
                            }
                        }
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
    public List<SkillEvent> getOverlappingSkillEvents(Timestamp start, Timestamp end) {
        List<SkillEvent> overlappingSkillEvents = new ArrayList<>();
        for (SkillEvent skillEvent : getSkillEventList()) {
            if (
                    (skillEvent.getStart().before(end) && skillEvent.getEnd().after(start))
                    || (skillEvent.getStart().equals(start) && skillEvent.getStart().equals(skillEvent.getEnd()))
            ) {
                overlappingSkillEvents.add(skillEvent);
            }
        }
        boolean isOverdrive = false;
        for (SkillEvent skillEvent : overlappingSkillEvents) {
            if (skillEvent.getSkill() instanceof Overdrive) {
                isOverdrive = true;
                break;
            }
        }
        if (isOverdrive) {
            for (int i = 0; i < overlappingSkillEvents.size(); i++) {
                if (overlappingSkillEvents.get(i).getSkill() instanceof OverdriveDebuff) {
                    overlappingSkillEvents.remove(i);
                }
            }
        }
        return overlappingSkillEvents;
    }
}
