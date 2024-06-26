package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.pathfinder.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.pathfinder.RelicEvolution;
import org.mapledpmlab.type.skill.buffskill.pathfinder.RelicLiberation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PathFinderDealCycle extends DealCycle {
    /*
    메용2 - 에픽 - 이볼브 - 크리티컬 리인포스 - 엔버링크 - 시드링
    옵시디언 배리어 - 레이븐 템페스트 - 렐릭 언바운드 - 렐릭 에볼루션
    얼티밋 블래스트
    
    메용2 - 에픽 - 이볼브 - 크리티컬 리인포스 - 포세이큰 렐릭
    엔버링크 - 시드링 - 옵시디언 배리어 - 레이븐 템페스트 - 렐릭 언바운드
    렐릭 에볼루션 - 얼티밋 블래스트
     */

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

    private boolean isCriticalReinforce = false;
    private boolean isRelicEvolution = false;
    private boolean isRelicLiberation = false;
    private final Long relicGauge = 0L;
    private final AdditionalBlastFirst additionalBlastFirst = new AdditionalBlastFirst();
    private final AdditionalBlastREFirst additionalBlastREFirst = new AdditionalBlastREFirst();
    private final AdditionalDischargeFirst additionalDischargeFirst = new AdditionalDischargeFirst();
    private final AdditionalDischargeREFirst additionalDischargeREFirst = new AdditionalDischargeREFirst();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdditionalBlastAfterSecond());
            add(new AdditionalBlastFirst());
            add(new AdditionalBlastREAfterSecond());
            add(new AdditionalBlastREFirst());
            add(new AdditionalDischargeAfterSecond());
            add(new AdditionalDischargeFirst());
            add(new AdditionalDischargeREAfterSecond());
            add(new AdditionalDischargeREFirst());
            add(new AncientWrath());
            add(new CardinalBlast());
            add(new CardinalDischarge());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CurseArrow());
            add(new EdgeOfResonance());
            add(new Evolve());
            add(new ForsakenRelicExplosion());
            add(new ForsakenRelicMagicArrow());
            add(new ForsakenRelicWave());
            add(new GuidedArrow());
            add(new ObsidianBarrier());
            add(new Raven());
            add(new RavenTempest());
            add(new RelicUnbound());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TripleImpact());
            add(new UltimateBlast());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(100.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(275L));
            add(new PriorPreparation());
            add(new RelicEvolution());
            add(new RelicLiberation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(318L));
        }
    };

    Timestamp relicLiberationEndTime = new Timestamp(-1);
    Timestamp relicEvolutionEndTime = new Timestamp(-1);

    public PathFinderDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AncientWrath ancientWrath = new AncientWrath();
        CardinalBlast cardinalBlast = new CardinalBlast();
        CardinalDischarge cardinalDischarge = new CardinalDischarge();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(100.0);
        CurseArrow curseArrow = new CurseArrow();
        EdgeOfResonance edgeOfResonance = new EdgeOfResonance();
        EpicAdventure epicAdventure = new EpicAdventure();
        Evolve evolve = new Evolve();
        GuidedArrow guidedArrow = new GuidedArrow();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        ObsidianBarrier obsidianBarrier = new ObsidianBarrier();
        PriorPreparation priorPreparation = new PriorPreparation();
        Raven raven = new Raven();
        RavenTempest ravenTempest = new RavenTempest();
        RelicEvolution relicEvolution = new RelicEvolution();
        RelicLiberation relicLiberation = new RelicLiberation();
        RelicUnbound relicUnbound = new RelicUnbound();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        TripleImpact tripleImpact = new TripleImpact();
        UltimateBlast ultimateBlast = new UltimateBlast();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

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

        // 저주 화살
        for (int i = 0; i < 720 * 1000; i += 20000) {
            for (int j = i; j < i + curseArrow.getInterval() * curseArrow.getLimitAttackCount(); j += curseArrow.getInterval()) {
                getSkillEventList().add(new SkillEvent(curseArrow, new Timestamp(j), new Timestamp(j)));
                getEventTimeList().add(new Timestamp(j));
            }
        }

        ringSwitching.setCooldown(130.0);

        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(evolve);
        dealCycle1.add(criticalReinforce);
        dealCycle1.add(relicLiberation);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(obsidianBarrier);
        dealCycle1.add(ravenTempest);
        dealCycle1.add(relicUnbound);
        dealCycle1.add(relicEvolution);
        dealCycle1.add(ultimateBlast);

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(evolve);
        dealCycle2.add(criticalReinforce);
        dealCycle2.add(relicLiberation);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(obsidianBarrier);
        dealCycle2.add(ravenTempest);
        dealCycle2.add(relicUnbound);
        dealCycle2.add(relicEvolution);
        dealCycle2.add(ultimateBlast);

        dealCycle3.add(epicAdventure);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(evolve);
        dealCycle3.add(criticalReinforce);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);
        dealCycle3.add(obsidianBarrier);
        dealCycle3.add(ravenTempest);
        dealCycle3.add(relicUnbound);
        dealCycle3.add(relicEvolution);
        dealCycle3.add(ultimateBlast);

        dealCycle4.add(epicAdventure);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(evolve);
        dealCycle4.add(criticalReinforce);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(obsidianBarrier);
        dealCycle4.add(ravenTempest);
        dealCycle4.add(relicUnbound);
        dealCycle4.add(relicEvolution);
        dealCycle4.add(ultimateBlast);

        dealCycle5.add(epicAdventure);
        dealCycle5.add(evolve);
        dealCycle5.add(criticalReinforce);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);
        dealCycle5.add(obsidianBarrier);
        dealCycle5.add(ravenTempest);
        dealCycle5.add(relicUnbound);
        dealCycle5.add(relicEvolution);
        dealCycle5.add(ultimateBlast);

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(raven)) {
                getStart().setTime(getStart().getTime() + 150);
                addSkillEvent(raven);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 1
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
                applyCooldown(tripleImpact);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
                applyCooldown(tripleImpact);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(6 * 60 * 1000))
                    && dealCycleOrder == 3
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
                applyCooldown(tripleImpact);
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
                applyCooldown(tripleImpact);
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 5
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addDealCycle(dealCycle5);
                dealCycleOrder ++;
                applyCooldown(tripleImpact);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(10 * 60 * 1000)))
            {
                getStart().setTime(getStart().getTime() + 150);
                addSkillEvent(ringSwitching);
                applyCooldown(tripleImpact);
            } else if (
                    getStart().before(relicLiberationEndTime)
                    && cooldownCheck(ancientWrath)
            ) {
                addSkillEvent(ancientWrath);
            } else if (
                    cooldownCheck(soulContract)
                    && !cooldownCheck(evolve)
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addSkillEvent(soulContract);
                applyCooldown(tripleImpact);
            } else if (cooldownCheck(edgeOfResonance)) {
                addSkillEvent(edgeOfResonance);
            } else if (cooldownCheck(tripleImpact)) {
                addSkillEvent(tripleImpact);
            } else {
                Long ran = 0L;
                ran = (long) (Math.random() * 99 + 1);
                if (getStart().before(relicEvolutionEndTime)) {
                    addSkillEvent(cardinalBlast);
                    if (ran <= additionalDischargeREFirst.getProp()) {
                        addSkillEvent(additionalDischargeREFirst);
                    }
                    addSkillEvent(cardinalDischarge);
                    if (ran <= additionalBlastREFirst.getProp()) {
                        addSkillEvent(additionalBlastREFirst);
                    }
                } else {
                    addSkillEvent(cardinalBlast);
                    if (ran <= additionalDischargeFirst.getProp()) {
                        addSkillEvent(additionalDischargeFirst);
                    }
                    addSkillEvent(cardinalDischarge);
                    if (ran <= additionalBlastFirst.getProp()) {
                        addSkillEvent(additionalBlastFirst);
                    }
                }
                edgeOfResonance.setActivateTime(new Timestamp(edgeOfResonance.getActivateTime().getTime() - 2000));
                ancientWrath.setActivateTime(new Timestamp(ancientWrath.getActivateTime().getTime() - 2000));
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
            if (skill instanceof RelicLiberation) {
                relicLiberationEndTime = new Timestamp(getStart().getTime() + 30 * 1000);
            }
            if (skill instanceof RelicEvolution) {
                relicEvolutionEndTime = new Timestamp(getStart().getTime() + 30 * 1000);
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
            boolean isEvolve = false;
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof EvolveBuff) {
                    isEvolve = true;
                    break;
                }
            }
            if (isEvolve) {
                for (int j = 0; j < useAttackSkillList.size(); j++) {
                    if (useAttackSkillList.get(j).getSkill() instanceof Raven) {
                        useAttackSkillList.remove(j);
                    }
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof CriticalReinforce) {
                    isCriticalReinforce = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof RelicEvolution) {
                    isRelicEvolution = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof RelicLiberation) {
                    isRelicLiberation = true;
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
                if (isRelicLiberation) {
                    if (
                            se.getSkill() instanceof CardinalForce
                            && start.equals(se.getStart())
                    ) {
                        totalDamage += getAttackDamage(new SkillEvent(new ForsakenRelicMagicArrow(), start, end), buffSkill, start, end);
                    }
                    if (
                            se.getSkill() instanceof EdgeOfResonance
                            || se.getSkill() instanceof UltimateBlast
                            || se.getSkill() instanceof RavenTempest
                            || se.getSkill() instanceof AncientWrath
                            || se.getSkill() instanceof ObsidianBarrier
                            || se.getSkill() instanceof RelicUnbound
                    ) {
                        buffSkill.addBuffFinalDamage(1.15);
                    }
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (isRelicLiberation) {
                    if (
                            se.getSkill() instanceof EdgeOfResonance
                                    || se.getSkill() instanceof UltimateBlast
                                    || se.getSkill() instanceof RavenTempest
                                    || se.getSkill() instanceof AncientWrath
                                    || se.getSkill() instanceof ObsidianBarrier
                                    || se.getSkill() instanceof RelicUnbound
                    ) {
                        buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.15);
                    }
                }
                Long ran = 0L;
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            isCriticalReinforce = false;
            isRelicLiberation = false;
            isRelicEvolution = false;
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
