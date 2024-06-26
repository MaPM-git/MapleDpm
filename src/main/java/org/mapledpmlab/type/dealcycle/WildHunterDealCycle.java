package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.wildhunter.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.wildhunter.JaguarStorm;
import org.mapledpmlab.type.skill.buffskill.wildhunter.SilentRampage;
import org.mapledpmlab.type.skill.buffskill.wildhunter.SoulResonationBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class WildHunterDealCycle extends DealCycle {

    // 메용2, 6차, 리레, 스인미, 크오솔
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private final List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private final List<Skill> dealCycle4 = new ArrayList<>();

    // 웨폰퍼프
    private final List<Skill> dealCycle5 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackWildHunter());
            add(new AnotherBite1());
            add(new AnotherBite2());
            add(new AnotherBite3());
            add(new AssistantHuntingUnit());
            add(new ClawCut());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new Crossroad());
            add(new DrillContainer());
            add(new GetOffJaguar());
            add(new Grenade());
            add(new GrenadeBoom());
            add(new GuidedArrow());
            add(new JaguarMaximum());
            add(new JaguarMaximumEnd());
            add(new JaguarSoul());
            add(new NaturesBeliefRoar());
            add(new NaturesBeliefWave());
            add(new RampageAsOne());
            add(new ResistanceLineInfantry());
            add(new RideJaguar());
            add(new SonicBoom());
            add(new SoulResonation());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SummonJaguar());
            add(new WildGrenade());
            add(new WildVulcan());
            add(new WildVulcanReinforce());
            add(new WildVulcanTypeX());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new AssistantHuntingUnitDelay());
            add(new ResistanceLineInfantryDelay());
            add(new WildVulcanTypeXBeforeDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(100.0));
            add(new JaguarStorm());
            add(new MapleWorldGoddessBlessing(275L));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SilentRampage());
            add(new SoulContract());
            add(new SoulResonationBuff());
            add(new ThiefCunning());
            add(new WeaponJumpRing(326L));
            add(new WillOfLiberty());
        }
    };

    boolean isCriticalReinforce = false;
    boolean isSilentRampage = false;
    boolean isJaguarStorm = false;

    Timestamp jaguarSkillDelay = new Timestamp(-1);
    Timestamp jaguarStormEndTime = new Timestamp(-1);
    Timestamp soulResonationEndTime = new Timestamp(-1);

    AnotherBite1 anotherBite1 = new AnotherBite1();
    AnotherBite2 anotherBite2 = new AnotherBite2();
    AnotherBite3 anotherBite3 = new AnotherBite3();
    AssistantHuntingUnit assistantHuntingUnit = new AssistantHuntingUnit();
    SoulResonation soulResonation = new SoulResonation();

    Long biteCnt = 0L;

    public WildHunterDealCycle(Job job) {
        super(job, new AdvancedFinalAttackWildHunter());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AssistantHuntingUnit assistantHuntingUnit = new AssistantHuntingUnit();
        AssistantHuntingUnitDelay assistantHuntingUnitDelay = new AssistantHuntingUnitDelay();
        ClawCut clawCut = new ClawCut();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        Crossroad crossroad = new Crossroad();
        CriticalReinforce criticalReinforce = new CriticalReinforce(100.0);
        DrillContainer drillContainer = new DrillContainer();
        GetOffJaguar getOffJaguar = new GetOffJaguar();
        Grenade grenade = new Grenade();
        GuidedArrow guidedArrow = new GuidedArrow();
        JaguarMaximum jaguarMaximum = new JaguarMaximum();
        JaguarSoul jaguarSoul = new JaguarSoul();
        JaguarStorm jaguarStorm = new JaguarStorm();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        NaturesBeliefWave naturesBeliefWave = new NaturesBeliefWave();
        PriorPreparation priorPreparation = new PriorPreparation();
        RampageAsOne rampageAsOne = new RampageAsOne();
        ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
        RestraintRing restraintRing = new RestraintRing();
        RideJaguar rideJaguar = new RideJaguar();
        RingSwitching ringSwitching = new RingSwitching();
        SilentRampage silentRampage = new SilentRampage();
        SonicBoom sonicBoom = new SonicBoom();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SummonJaguar summonJaguar = new SummonJaguar();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WildGrenade wildGrenade = new WildGrenade();
        WildVulcan wildVulcan = new WildVulcan();
        WildVulcanReinforce wildVulcanReinforce = new WildVulcanReinforce();
        WildVulcanTypeXBeforeDelay wildVulcanTypeXBeforeDelay = new WildVulcanTypeXBeforeDelay();
        WillOfLiberty willOfLiberty = new WillOfLiberty();

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

        dealCycle1.add(willOfLiberty);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(assistantHuntingUnitDelay);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(silentRampage);
        dealCycle1.add(criticalReinforce);
        dealCycle1.add(drillContainer);
        dealCycle1.add(resistanceLineInfantry);
        dealCycle1.add(jaguarSoul);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(jaguarStorm);
        dealCycle1.add(rampageAsOne);
        dealCycle1.add(naturesBeliefWave);
        dealCycle1.add(jaguarMaximum);
        dealCycle1.add(getOffJaguar);
        dealCycle1.add(wildGrenade);
        dealCycle1.add(wildVulcanTypeXBeforeDelay);

        dealCycle2.add(willOfLiberty);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(assistantHuntingUnitDelay);
        dealCycle2.add(silentRampage);
        dealCycle2.add(criticalReinforce);
        dealCycle2.add(drillContainer);
        dealCycle2.add(resistanceLineInfantry);
        dealCycle2.add(jaguarSoul);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(jaguarStorm);
        dealCycle2.add(rampageAsOne);
        dealCycle2.add(naturesBeliefWave);
        dealCycle2.add(jaguarMaximum);
        dealCycle2.add(getOffJaguar);
        dealCycle2.add(wildGrenade);
        dealCycle2.add(wildVulcanTypeXBeforeDelay);

        dealCycle3.add(willOfLiberty);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(assistantHuntingUnitDelay);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(silentRampage);
        dealCycle3.add(criticalReinforce);
        dealCycle3.add(drillContainer);
        dealCycle3.add(resistanceLineInfantry);
        dealCycle3.add(jaguarSoul);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);
        dealCycle3.add(jaguarStorm);
        dealCycle3.add(rampageAsOne);
        dealCycle3.add(jaguarMaximum);
        dealCycle3.add(getOffJaguar);
        dealCycle3.add(wildGrenade);
        dealCycle3.add(wildVulcanTypeXBeforeDelay);

        dealCycle4.add(willOfLiberty);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(assistantHuntingUnitDelay);
        dealCycle4.add(silentRampage);
        dealCycle4.add(criticalReinforce);
        dealCycle4.add(drillContainer);
        dealCycle4.add(resistanceLineInfantry);
        dealCycle4.add(jaguarSoul);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(jaguarStorm);
        dealCycle4.add(rampageAsOne);
        dealCycle4.add(jaguarMaximum);
        dealCycle4.add(getOffJaguar);
        dealCycle4.add(wildGrenade);
        dealCycle4.add(wildVulcanTypeXBeforeDelay);

        dealCycle5.add(willOfLiberty);
        dealCycle5.add(assistantHuntingUnitDelay);
        dealCycle5.add(mapleWorldGoddessBlessing);
        dealCycle5.add(assistantHuntingUnitDelay);
        dealCycle5.add(silentRampage);
        dealCycle5.add(criticalReinforce);
        dealCycle5.add(drillContainer);
        dealCycle5.add(resistanceLineInfantry);
        dealCycle5.add(jaguarSoul);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);
        dealCycle5.add(jaguarStorm);
        dealCycle5.add(rampageAsOne);
        dealCycle5.add(jaguarMaximum);
        dealCycle5.add(getOffJaguar);
        dealCycle5.add(wildGrenade);
        dealCycle5.add(wildVulcanTypeXBeforeDelay);

        Timestamp wildVulcanReinforceEndTime = new Timestamp(-1);
        Long wildCnt = 49L;
        Long ran;

        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(summonJaguar)
                    && getStart().after(jaguarSkillDelay)
            ) {
                ran = (long) (Math.random() * 99 + 1);
                if (ran <= 15 && biteCnt < 3) {
                    biteCnt ++;
                }
                addSkillEvent(summonJaguar);
            }
            if (
                    cooldownCheck(rampageAsOne)
                    && getStart().after(jaguarSkillDelay)
                    && !cooldownCheck(willOfLiberty)
            ) {
                if (biteCnt < 3) {
                    biteCnt ++;
                }
                addSkillEvent(rampageAsOne);
                jaguarSkillDelay = new Timestamp(getStart().getTime() + rampageAsOne.getJaguarDelay());
            }
            if (
                    cooldownCheck(sonicBoom)
                    && getStart().after(jaguarSkillDelay)
            ) {
                ran = (long) (Math.random() * 99 + 1);
                if (biteCnt == 0) {
                    biteCnt ++;
                } else if (ran <= 40 && biteCnt < 3) {
                    biteCnt ++;
                }
                addSkillEvent(sonicBoom);
                jaguarSkillDelay = new Timestamp(getStart().getTime() + sonicBoom.getJaguarDelay());
            }
            if (
                    cooldownCheck(clawCut)
                    && getStart().after(jaguarSkillDelay)
            ) {
                ran = (long) (Math.random() * 99 + 1);
                if (biteCnt == 0) {
                    biteCnt ++;
                } else if (ran <= 30 && biteCnt < 3) {
                    biteCnt ++;
                }
                addSkillEvent(clawCut);
                jaguarSkillDelay = new Timestamp(getStart().getTime() + clawCut.getJaguarDelay());
            }
            if (
                    cooldownCheck(crossroad)
                    && getStart().after(jaguarSkillDelay)
            ) {
                ran = (long) (Math.random() * 99 + 1);
                if (biteCnt == 0) {
                    biteCnt ++;
                } else if (ran <= 90 && biteCnt < 3) {
                    biteCnt ++;
                }
                addSkillEvent(crossroad);
                jaguarSkillDelay = new Timestamp(getStart().getTime() + crossroad.getJaguarDelay());
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(6 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(dealCycle4)
            ) {
                addDealCycle(dealCycle4);
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle5);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(10 * 60 * 1000)))
            {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && (
                            (
                                    getStart().after(new Timestamp(30 * 1000))
                                    && getStart().before(new Timestamp(90 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(150 * 1000))
                                    && getStart().before(new Timestamp(210 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(270 * 1000))
                                    && getStart().before(new Timestamp(330 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(390 * 1000))
                                    && getStart().before(new Timestamp(450 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(510 * 1000))
                                    && getStart().before(new Timestamp(570 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(630 * 1000))
                                    && getStart().before(new Timestamp(690 * 1000))
                            )
                    )
            ) {
                addSkillEvent(assistantHuntingUnitDelay);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(wildGrenade)
                    && !cooldownCheck(willOfLiberty)
            ) {
                addSkillEvent(wildGrenade);
            } else if (
                    cooldownCheck(drillContainer)
                    && !cooldownCheck(willOfLiberty)
            ) {
                addSkillEvent(drillContainer);
                addSkillEvent(resistanceLineInfantry);
            } else {
                /*if (getStart().before(wildVulcanReinforceEndTime)) {
                    addSkillEvent(wildVulcanReinforce);
                } else {
                    addSkillEvent(wildVulcan);
                    wildCnt ++;
                }
                if (wildCnt == 50) {
                    wildVulcanReinforceEndTime = new Timestamp(getStart().getTime() + 10000);
                    wildCnt = 0L;
                    addSkillEvent(grenade);
                }*/
                addSkillEvent(wildVulcanReinforce);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (skill instanceof SoulResonation) {
                if (biteCnt < 3) {
                    biteCnt ++;
                }
            }
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof SoulResonationBuff) {
                soulResonationEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof JaguarStorm) {
                jaguarStormEndTime = new Timestamp(getStart().getTime() + 40000);
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
            if (skill instanceof JaguarMaximum) {
                jaguarSkillDelay = new Timestamp(getStart().getTime() + 2790);
            }
            if (
                    getStart().before(soulResonationEndTime)
                    && cooldownCheck(soulResonation)
                    && !(skill instanceof SoulResonation)
            ) {
                addSkillEvent(soulResonation);
            }
            if (skill instanceof JaguarSoul && biteCnt < 3) {
                biteCnt ++;
            }
            if (skill instanceof JaguarMaximum) {
                biteCnt = 3L;
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof DrillContainer) {
                        i = 1020;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (skill instanceof NaturesBeliefRoar || skill instanceof NaturesBeliefWave) {
                            if (biteCnt < 3) {
                                biteCnt ++;
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
                if (skill instanceof AssistantHuntingUnitDelay) {
                    List<SkillEvent> remove = new ArrayList<>();
                    for (SkillEvent skillEvent : this.getSkillEventList()) {
                        if (
                                skillEvent.getStart().after(getStart())
                                && skillEvent.getSkill() instanceof AssistantHuntingUnit
                        ) {
                            remove.add(skillEvent);
                        }
                    }
                    this.getSkillEventList().removeAll(remove);
                    for (long j = 0; j <= 60000; j += 7000) {
                        for (long i = 0; i <= 5000; i += 300) {
                            getSkillEventList().add(new SkillEvent(assistantHuntingUnit, new Timestamp(getStart().getTime() + i + j), new Timestamp(getStart().getTime() + i + j)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + i + j));
                        }
                    }
                }
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
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof CriticalReinforce) {
                    isCriticalReinforce = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof SilentRampage) {
                    isSilentRampage = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof JaguarStorm) {
                    isJaguarStorm = true;
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
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (
                            (isSilentRampage && start.equals(se.getStart()))
                            || (ran <= this.getFinalAttack().getProp() && start.equals(se.getStart()))
                    ) {
                        totalDamage += getAttackDamage(new SkillEvent(this.getFinalAttack(), start, end), buffSkill, start, end);
                    }
                    getStart().setTime(start.getTime());
                    if (cooldownCheck(anotherBite3) && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(anotherBite3, start, end), buffSkill, start, end);
                        applyCooldown(anotherBite3);
                    }
                }
            }
            isCriticalReinforce = false;
            isSilentRampage = false;
            isJaguarStorm = false;
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
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                if (attackSkill instanceof JaguarSkill && isJaguarStorm) {
                    attackSkill.setAttackCount(attackSkill.getAttackCount() * 3);
                    buffSkill.addBuffFinalDamage(3.6);
                }
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat()) * 4
                        + this.getJob().getFinalSubstat()) * 0.01
                        * (Math.floor((this.getJob().getAtt() + buffSkill.getBuffAttMagic())
                        * (1 + (this.getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + this.getJob().getPerXAtt())
                        * this.getJob().getConstant()
                        * (1 + (this.getJob().getDamage() + this.getJob().getBossDamage() + this.getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (this.getJob().getFinalDamage())
                        * buffSkill.getBuffFinalDamage()
                        * this.getJob().getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * this.getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (this.getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (this.getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - this.getJob().getIgnoreDefense()) * (1 - this.getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                this.getJob().addMainStat(-buffSkill.getBuffMainStat());
                this.getJob().addSubStat(-buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(-buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(-buffSkill.getBuffOtherStat2());
                if (skillEvent.getStart().equals(start)) {
                    if (attackSkill instanceof JaguarSkill && isJaguarStorm) {
                        as.setUseCount(as.getUseCount() + 2);
                    }
                    as.setUseCount(as.getUseCount() + 1);
                    as.setCumulativeAttackCount(as.getCumulativeAttackCount() + attackSkill.getAttackCount());
                }
                Long distance = end.getTime() - start.getTime();
                if (attackSkill.getMultiAttackInfo().size() == 0 && attackSkill.getInterval() == 0 && attackSkill.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / attackSkill.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                if (attackSkill instanceof JaguarSkill && isJaguarStorm) {
                    attackSkill.setAttackCount(attackSkill.getAttackCount() / 3);
                    buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 3.6);
                }
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
