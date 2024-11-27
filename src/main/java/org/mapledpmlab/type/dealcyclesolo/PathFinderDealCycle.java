package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdditionalBlastAfterSecond());
            add(new AdditionalBlastFirst());
            add(new AdditionalBlastREAfterSecond());
            add(new AdditionalBlastREFirst());
            add(new CurseArrow());
            add(new AdditionalDischargeAfterSecond());
            add(new AdditionalDischargeFirst());
            add(new AdditionalDischargeREAfterSecond());
            add(new AdditionalDischargeREFirst());
            add(new CardinalBlast());
            add(new CardinalDischarge());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EdgeOfResonance());
            add(new Evolve());
            add(new ForsakenRelicWave());
            add(new ForsakenRelicExplosion());
            add(new ForsakenRelicMagicArrow());
            add(new AncientWrath());
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(0.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RelicEvolution());
            add(new RelicLiberation());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };
    boolean isCriticalReinforce = false;
    boolean isRelicEvolution = false;
    boolean isRelicLiberation = false;

    Timestamp relicLiberationEndTime = new Timestamp(-1);
    Timestamp relicEvolutionEndTime = new Timestamp(-1);
    Timestamp soulContractEndTime = new Timestamp(-1);

    AncientWrath ancientWrath = new AncientWrath();
    AdditionalBlastFirst additionalBlastFirst = new AdditionalBlastFirst();
    AdditionalBlastREFirst additionalBlastREFirst = new AdditionalBlastREFirst();
    AdditionalDischargeFirst additionalDischargeFirst = new AdditionalDischargeFirst();
    AdditionalDischargeREFirst additionalDischargeREFirst = new AdditionalDischargeREFirst();
    CardinalBlast cardinalBlast = new CardinalBlast();
    CardinalDischarge cardinalDischarge = new CardinalDischarge();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
    CurseArrow curseArrow = new CurseArrow();
    EdgeOfResonance edgeOfResonance = new EdgeOfResonance();
    EpicAdventure epicAdventure = new EpicAdventure();
    Evolve evolve = new Evolve();
    ForsakenRelicMagicArrow forsakenRelicMagicArrow = new ForsakenRelicMagicArrow();
    GuidedArrow guidedArrow = new GuidedArrow();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    ObsidianBarrier obsidianBarrier = new ObsidianBarrier();
    Raven raven = new Raven();
    RavenTempest ravenTempest = new RavenTempest();
    RelicEvolution relicEvolution = new RelicEvolution();
    RelicLiberation relicLiberation = new RelicLiberation();
    RelicUnbound relicUnbound = new RelicUnbound();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    TripleImpact tripleImpact = new TripleImpact();
    UltimateBlast ultimateBlast = new UltimateBlast();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public PathFinderDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        for (BuffSkill buffSkill : getBuffSkillList()) {
            if (buffSkill instanceof SoulContract) {
                buffSkill.setApplyReuse(true);
            }
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

        ringSwitching.setCooldown(120.0);
        mapleWorldGoddessBlessing.setCooldown(120.0);

        soulContract.setApplyReuse(true);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        addSkillEvent(raven);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(epicAdventure)
                    && getStart().before(new Timestamp(660 * 1000))
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addSkillEvent(evolve);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(cardinalBlast);
                    addSkillEvent(cardinalDischarge);
                    getStart().setTime(getStart().getTime() + 150);
                }
                addSkillEvent(obsidianBarrier);
                addSkillEvent(criticalReinforce);
                addSkillEvent(soulContract);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(ravenTempest);
                if (cooldownCheck(edgeOfResonance)) {
                    addSkillEvent(edgeOfResonance);
                }
                if (cooldownCheck(relicLiberation)) {
                    addSkillEvent(relicLiberation);
                } else {
                    for (int i = 0; i < 14; i++) {
                        addSkillEvent(cardinalBlast);
                        addSkillEvent(cardinalDischarge);
                    }
                    getStart().setTime(getStart().getTime() + 150);
                }
                addSkillEvent(ultimateBlast);
                addSkillEvent(relicEvolution);
                addSkillEvent(relicUnbound);
                dealCycleOrder ++;
                applyCooldown(tripleImpact);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(100 * 1000))
                            && getStart().before(new Timestamp(10 * 60 * 1000)))
            {
                getStart().setTime(getStart().getTime() + 150);
                addSkillEvent(ringSwitching);
                applyCooldown(tripleImpact);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().after(soulContractEndTime)
                            && getStart().before(new Timestamp(evolve.getActivateTime().getTime() - 35000))
            ) {
                getStart().setTime(getStart().getTime() + 150);
                addSkillEvent(soulContract);
                applyCooldown(tripleImpact);
            } else if (cooldownCheck(tripleImpact)) {
                getStart().setTime(getStart().getTime() + 150);
                addSkillEvent(tripleImpact);
            } else {
                addSkillEvent(cardinalBlast);
                addSkillEvent(cardinalDischarge);
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
            if (skill instanceof SoulContract) {
                soulContractEndTime.setTime((long) (getStart().getTime() + 3000 + soulContract.getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
            }
            if (skill instanceof RelicLiberation) {
                relicLiberationEndTime = new Timestamp(getStart().getTime() + 3000 + 30 * 1000);
            }
            if (skill instanceof RelicEvolution) {
                relicEvolutionEndTime = new Timestamp(getStart().getTime() + 3000 + 30 * 1000);
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
                    getStart().before(relicLiberationEndTime)
                    && cooldownCheck(ancientWrath)
                    && !(skill instanceof AncientWrath)
            ) {
                addSkillEvent(ancientWrath);
            }
            if (
                    skill instanceof CardinalForce
                    && getStart().before(relicLiberationEndTime)
            ) {
                addSkillEvent(forsakenRelicMagicArrow);
            }
            if (
                    cooldownCheck(edgeOfResonance)
                    && (
                            skill instanceof CardinalBlast
                            || skill instanceof CardinalDischarge
                    )
            ) {
                addSkillEvent(edgeOfResonance);
            }
            if (skill instanceof CardinalBlast) {
                Long ran = 0L;
                ran = (long) (Math.random() * 99 + 1);
                if (
                        getStart().before(relicEvolutionEndTime)
                        && ran <= additionalDischargeREFirst.getProp()
                ) {
                    addSkillEvent(additionalDischargeREFirst);
                } else if (ran <= additionalDischargeFirst.getProp()) {
                    addSkillEvent(additionalDischargeFirst);
                }
                edgeOfResonance.setActivateTime(new Timestamp(edgeOfResonance.getActivateTime().getTime() - 1000));
                ancientWrath.setActivateTime(new Timestamp(ancientWrath.getActivateTime().getTime() - 1000));
            }
            if (skill instanceof CardinalDischarge) {
                Long ran = 0L;
                ran = (long) (Math.random() * 99 + 1);
                if (
                        getStart().before(relicEvolutionEndTime)
                        && ran <= additionalBlastREFirst.getProp()
                ) {
                    addSkillEvent(additionalBlastREFirst);
                } else if (ran <= additionalBlastFirst.getProp()) {
                    addSkillEvent(additionalBlastFirst);
                }
                edgeOfResonance.setActivateTime(new Timestamp(edgeOfResonance.getActivateTime().getTime() - 1000));
                ancientWrath.setActivateTime(new Timestamp(ancientWrath.getActivateTime().getTime() - 1000));
            }
            if (skill instanceof RavenTempest) {
                Timestamp timestamp = new Timestamp(getStart().getTime() + 10080);
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getStart().before(timestamp)
                            && (
                                    skillEvent.getSkill() instanceof Raven
                                    || skillEvent.getSkill() instanceof Evolve
                            )
                    ) {
                        remove.add(skillEvent);
                    }
                }
                getSkillEventList().removeAll(remove);
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
                        bs.setUseCount(bs.getUseCount() + 1);
                        bs.getStartTimeList().add(skillEvent.getStart());
                        bs.getEndTimeList().add(skillEvent.getEnd());
                    }
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
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
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            for (SkillEvent se : useAttackSkillList) {
                if (isRelicLiberation) {
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
