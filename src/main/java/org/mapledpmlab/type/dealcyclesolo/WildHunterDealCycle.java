package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackWildHunter());
            add(new AnotherBite1());
            add(new AnotherBite2());
            add(new AnotherBite3());
            add(new AssistantHuntingUnitDelay());
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
            add(new NaturesBeliefWave());
            add(new NaturesBeliefRoar());
            add(new SoulResonation());
            add(new RampageAsOne());
            add(new ResistanceLineInfantryDelay());
            add(new ResistanceLineInfantry());
            add(new RideJaguar());
            add(new SonicBoom());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SummonJaguar());
            add(new WildGrenade());
            add(new WildVulcan());
            add(new WildVulcanReinforce());
            add(new WildVulcanTypeXBeforeDelay());
            add(new WildVulcanTypeX());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(0.0));
            add(new JaguarStorm());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SilentRampage());
            add(new SoulContract());
            add(new SoulResonationBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WillOfLiberty());
        }
    };

    Long biteCnt = 0L;

    boolean isCriticalReinforce = false;
    boolean isJaguarStorm = false;
    boolean isSilentRampage = false;

    Timestamp jaguarSkillDelay = new Timestamp(1000);
    Timestamp jaguarStormEndTime = new Timestamp(-1);
    Timestamp soulResonationEndTime = new Timestamp(-1);

    AnotherBite1 anotherBite1 = new AnotherBite1();
    AnotherBite2 anotherBite2 = new AnotherBite2();
    AnotherBite3 anotherBite3 = new AnotherBite3();
    AssistantHuntingUnit assistantHuntingUnit = new AssistantHuntingUnit();
    AssistantHuntingUnitDelay assistantHuntingUnitDelay = new AssistantHuntingUnitDelay();
    ClawCut clawCut = new ClawCut();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
    Crossroad crossroad = new Crossroad();
    DrillContainer drillContainer = new DrillContainer();
    GetOffJaguar getOffJaguar = new GetOffJaguar();
    Grenade grenade = new Grenade();
    GuidedArrow guidedArrow = new GuidedArrow();
    JaguarMaximum jaguarMaximum = new JaguarMaximum();
    JaguarSoul jaguarSoul = new JaguarSoul();
    JaguarStorm jaguarStorm = new JaguarStorm();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    NaturesBeliefWave naturesBeliefWave = new NaturesBeliefWave();
    RampageAsOne rampageAsOne = new RampageAsOne();
    ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
    RestraintRing restraintRing = new RestraintRing();
    RideJaguar rideJaguar = new RideJaguar();
    RingSwitching ringSwitching = new RingSwitching();
    SilentRampage silentRampage = new SilentRampage();
    SonicBoom sonicBoom = new SonicBoom();
    SoulContract soulContract = new SoulContract();
    SoulResonation soulResonation = new SoulResonation();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SummonJaguar summonJaguar = new SummonJaguar();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    WildGrenade wildGrenade = new WildGrenade();
    WildVulcan wildVulcan = new WildVulcan();
    WildVulcanReinforce wildVulcanReinforce = new WildVulcanReinforce();
    WildVulcanTypeXBeforeDelay wildVulcanTypeXBeforeDelay = new WildVulcanTypeXBeforeDelay();
    WillOfLiberty willOfLiberty = new WillOfLiberty();

    public WildHunterDealCycle(Job job) {
        super(job, new AdvancedFinalAttackWildHunter());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);
        mapleWorldGoddessBlessing.setCooldown(120.0);
    }

    @Override
    public void setSoloDealCycle() {
        Long ran;
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(rampageAsOne)
                            && getStart().after(jaguarSkillDelay)
                            && !cooldownCheck(soulContract)
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
                    cooldownCheck(resistanceLineInfantry)
                            && getStart().after(new Timestamp(10000))
                            && !cooldownCheck(willOfLiberty)
                            && getStart().before(new Timestamp(700 * 1000))
            ) {
                addSkillEvent(resistanceLineInfantry);
            }
            if (
                    cooldownCheck(willOfLiberty)
                            && cooldownCheck(assistantHuntingUnitDelay)
                            && cooldownCheck(silentRampage)
                            && cooldownCheck(criticalReinforce)
                            && cooldownCheck(drillContainer)
                            && cooldownCheck(resistanceLineInfantry)
                            && cooldownCheck(jaguarSoul)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(jaguarStorm)
                            && cooldownCheck(rampageAsOne)
                            && cooldownCheck(jaguarMaximum)
                            && cooldownCheck(wildGrenade)
                            && cooldownCheck(wildVulcanTypeXBeforeDelay)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(willOfLiberty);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(wildVulcanReinforce);
                }
                addSkillEvent(assistantHuntingUnitDelay);
                addSkillEvent(drillContainer);
                addSkillEvent(silentRampage);
                addSkillEvent(criticalReinforce);
                addSkillEvent(resistanceLineInfantry);
                addSkillEvent(jaguarStorm);
                addSkillEvent(soulContract);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(jaguarSoul);
                addSkillEvent(rampageAsOne);
                if (cooldownCheck(naturesBeliefWave)) {
                    addSkillEvent(naturesBeliefWave);
                }
                addSkillEvent(jaguarMaximum);
                addSkillEvent(getOffJaguar);
                addSkillEvent(wildGrenade);
                addSkillEvent(wildVulcanTypeXBeforeDelay);

                dealCycleOrder++;
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(110 * 1000))
                            && getStart().before(new Timestamp(10 * 60 * 1000)))
            {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && cooldownCheck(drillContainer)
                            && !cooldownCheck(willOfLiberty)
            ) {
                addSkillEvent(assistantHuntingUnitDelay);
                addSkillEvent(drillContainer);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(wildGrenade)
                            && getStart().before(new Timestamp(willOfLiberty.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(wildGrenade);
            } else {
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (
                cooldownCheck(summonJaguar)
                && getStart().after(jaguarSkillDelay)
                && !(skill instanceof SummonJaguar)
                && !(skill instanceof SoulResonation)
        ) {
            Long ran;
            ran = (long) (Math.random() * 99 + 1);
            if (ran <= 15 && biteCnt < 3) {
                biteCnt ++;
            }
            addSkillEvent(summonJaguar);
            jaguarSkillDelay = new Timestamp(getStart().getTime() + summonJaguar.getJaguarDelay());
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
                        if (skill instanceof WildVulcanTypeX) {
                            Timestamp now = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            Long ran;
                            if (
                                    cooldownCheck(rampageAsOne)
                                            && getStart().after(jaguarSkillDelay)
                                            && !cooldownCheck(soulContract)
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
                                    cooldownCheck(summonJaguar)
                                            && getStart().after(jaguarSkillDelay)
                            ) {
                                ran = (long) (Math.random() * 99 + 1);
                                if (ran <= 15 && biteCnt < 3) {
                                    biteCnt ++;
                                }
                                addSkillEvent(summonJaguar);
                                jaguarSkillDelay = new Timestamp(getStart().getTime() + summonJaguar.getJaguarDelay());
                            }
                            getStart().setTime(now.getTime());
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
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (se.getSkill() instanceof JaguarSkill && isJaguarStorm) {
                    buffSkill.addBuffFinalDamage(3.6);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 3.6);
                }
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
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
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
                            * (1 - 0.5 * (1 - (this.getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
                            * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - this.getJob().getIgnoreDefense()) * (1 - this.getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                    );
                }
                this.getJob().addMainStat(-buffSkill.getBuffMainStat());
                this.getJob().addSubStat(-buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(-buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(-buffSkill.getBuffOtherStat2());
                Long distance = end.getTime() - start.getTime();
                if (attackSkill.getMultiAttackInfo().size() == 0 && attackSkill.getInterval() == 0 && attackSkill.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / attackSkill.getDelay() * distance;
                }
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                    as.setCumulativeAttackCount(as.getCumulativeAttackCount() + attackSkill.getAttackCount());
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
