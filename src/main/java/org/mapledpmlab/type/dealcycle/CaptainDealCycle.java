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

    /*
        엔버 리레 헤드샷 어썰트 드레드 트리거 헤샷 데드아이 풀파
     */

    // 6차, 리레
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private final List<Skill> dealCycle3 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BattleShipBomber());
            add(new BulletParty());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DeadEye());
            add(new DeathTrigger());
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

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new AssembleCrewDelay());
            add(new BulletPartyAfterDelay());
            add(new BulletPartyBeforeDelay());
            add(new DeathTriggerAfterDelay());
            add(new DeathTriggerBeforeDelay());
            add(new DeathTriggerLoopDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new EpicAdventure());
            add(new LuckyDice());
            //add(new LuckyDiceOneMoreChance());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(249L));
            add(new OverdriveDebuff(249L));
            add(new PirateFlag());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UntiringNectar());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    DeadEye deadEye = new DeadEye();
    HeadShot headShot = new HeadShot();

    DeathTrigger deathTrigger = new DeathTrigger();
    List<Timestamp> quickDrawTimeList = new ArrayList<>();

    boolean isQuickDraw = false;

    public CaptainDealCycle(Job job) {
        super(job, new FinalAttackCaptain());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AssembleCrewDelay assembleCrewDelay = new AssembleCrewDelay();
        BattleShipBomber battleShipBomber = new BattleShipBomber();
        BulletPartyBeforeDelay bulletParty = new BulletPartyBeforeDelay();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DeathTriggerBeforeDelay deathTrigger = new DeathTriggerBeforeDelay();
        Dreadnought dreadnought = new Dreadnought();
        DualPistolCrew dualPistolCrew = new DualPistolCrew();
        EpicAdventure epicAdventure = new EpicAdventure();
        LuckyDice luckyDice = new LuckyDice();
        LuckyDiceOneMoreChance luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MarksmanCrew marksmanCrew = new MarksmanCrew();
        NautilusAssaultHull nautilusAssaultHull = new NautilusAssaultHull();
        Overdrive overdrive = new Overdrive(249L);
        PirateFlag pirateFlag = new PirateFlag();
        PriorPreparation priorPreparation = new PriorPreparation();
        RapidFire rapidFire = new RapidFire();
        RapidFireSpree rapidFireSpree = new RapidFireSpree();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SiegeBomber siegeBomber = new SiegeBomber();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UntiringNectar untiringNectar = new UntiringNectar();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(100.0);

        /*
            파이렛플래그 옵드 언티어링넥타 엔버 리레 헤드샷 어썰트 드레드 트리거 헤샷 데드아이 풀파
        */
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(pirateFlag);
        dealCycle1.add(overdrive);
        dealCycle1.add(untiringNectar);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(headShot);
        dealCycle1.add(deathTrigger);
        dealCycle1.add(nautilusAssaultHull);
        dealCycle1.add(dreadnought);
        dealCycle1.add(headShot);
        dealCycle1.add(deadEye);
        dealCycle1.add(bulletParty);

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(pirateFlag);
        dealCycle2.add(overdrive);
        dealCycle2.add(untiringNectar);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(headShot);
        dealCycle2.add(deathTrigger);
        dealCycle2.add(nautilusAssaultHull);
        dealCycle2.add(deadEye);
        dealCycle2.add(bulletParty);

        dealCycle3.add(pirateFlag);
        dealCycle3.add(overdrive);
        dealCycle3.add(untiringNectar);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(headShot);
        dealCycle3.add(deathTrigger);
        dealCycle3.add(deadEye);
        dealCycle3.add(bulletParty);
        
        // 데스트리거, 데드아이, 헤드샷 쿨마다 사용

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());

        Long clipCount = 9L;
        Timestamp spreeEndTime = new Timestamp(-1);

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
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
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
                    cooldownCheck(deathTrigger)
                    && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(deathTrigger);
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
                if (clipCount >= 10) {
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
                    buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
                    buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
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
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
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
