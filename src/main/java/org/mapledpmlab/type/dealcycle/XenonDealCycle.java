package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.job.Xenon;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.xenon.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.xenon.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class XenonDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AegisSystem());
            add(new ArtificialEvolution());
            add(new ArtificialEvolutionAirFrame());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new FuzzyRobMasqueradeExecution());
            add(new FuzzyRobMasqueradeSnipe());
            add(new HologramGraffitiForceField());
            add(new HologramGraffitiFusion());
            add(new MegaSmasher());
            add(new MegaSmasherReinforce());
            add(new MeltdownExplosion());
            add(new OverloadModePlasmaCurrent());
            add(new PhotonRay());
            add(new PinpointRocket());
            add(new ResistanceLineInfantry());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TriangleFormation());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new ArtificialEvolutionDelay());
            add(new MegaSmasherDelay());
            add(new FuzzyRobMasqueradeExecutionDelay());
            add(new HologramGraffitiForceFieldDelay());
            add(new HologramGraffitiFusionDelay());
            add(new ResistanceLineInfantryDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AmaranceGenerator());
            add(new ExtraSupply());
            add(new HologramGraffitiBuff());
            add(new LoadedDice());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new MeltdownExplosionBuff());
            add(new MeltdownExplosionDebuff());
            add(new OopartsCode());
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new OverloadMode());
            add(new PriorPreparation());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int energyCnt = 20;
    int airFrameCnt = 0;
    List<Timestamp> hologramGraffitiFusionStartTimeList = new ArrayList<>();
    List<Timestamp> hologramGraffitiFusionEndTimeList = new ArrayList<>();

    Timestamp overloadModeEndTime = new Timestamp(-1);
    Timestamp pinpointRocketCooltime = new Timestamp(-1);

    InclinePower inclinePower = new InclinePower();
    PinpointRocket pinpointRocket = new PinpointRocket();
    SupplySurplus supplySurplus = new SupplySurplus();
    TriangleFormation triangleFormation = new TriangleFormation();

    public XenonDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AegisSystem aegisSystem = new AegisSystem();
        AmaranceGenerator amaranceGenerator = new AmaranceGenerator();
        ArtificialEvolution artificialEvolution = new ArtificialEvolution();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        ExtraSupply extraSupply = new ExtraSupply();
        FuzzyRobMasqueradeExecution fuzzyRobMasqueradeExecution = new FuzzyRobMasqueradeExecution();
        FuzzyRobMasqueradeSnipe fuzzyRobMasqueradeSnipe = new FuzzyRobMasqueradeSnipe();
        HologramGraffitiForceFieldDelay hologramGraffitiForceFieldDelay = new HologramGraffitiForceFieldDelay();
        HologramGraffitiFusionDelay hologramGraffitiFusionDelay = new HologramGraffitiFusionDelay();
        LoadedDice loadedDice = new LoadedDice();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MegaSmasher megaSmasher = new MegaSmasher();
        MegaSmasherReinforce megaSmasherReinforce = new MegaSmasherReinforce();
        MeltdownExplosion meltdownExplosion = new MeltdownExplosion();
        OopartsCode oopartsCode = new OopartsCode();
        Overdrive overdrive = new Overdrive(255L);
        OverloadMode overloadMode = new OverloadMode();
        PhotonRay photonRay = new PhotonRay();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReadyToDie readyToDie = new ReadyToDie();
        ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        /*for (int i = 0; i < 720 * 1000; i += aegisSystem.getInterval()) {
            getSkillEventList().add(new SkillEvent(aegisSystem, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }*/

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(loadedDice);
        dealCycle1.add(oopartsCode);
        dealCycle1.add(amaranceGenerator);
        dealCycle1.add(overloadMode);
        dealCycle1.add(hologramGraffitiForceFieldDelay);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(hologramGraffitiFusionDelay);
        dealCycle1.add(overdrive);
        dealCycle1.add(meltdownExplosion);
        dealCycle1.add(soulContract);
        dealCycle1.add(readyToDie);
        dealCycle1.add(restraintRing);
        dealCycle1.add(resistanceLineInfantry);
        dealCycle1.add(artificialEvolution);
        dealCycle1.add(megaSmasherReinforce);
        dealCycle1.add(photonRay);

        dealCycle2.add(loadedDice);
        dealCycle2.add(oopartsCode);
        dealCycle2.add(amaranceGenerator);
        dealCycle2.add(overloadMode);
        dealCycle2.add(hologramGraffitiForceFieldDelay);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(hologramGraffitiFusionDelay);
        dealCycle2.add(overdrive);
        dealCycle2.add(meltdownExplosion);
        dealCycle2.add(soulContract);
        dealCycle2.add(readyToDie);
        dealCycle2.add(restraintRing);
        dealCycle2.add(resistanceLineInfantry);
        dealCycle2.add(megaSmasher);
        dealCycle2.add(photonRay);

        dealCycle3.add(oopartsCode);
        dealCycle3.add(amaranceGenerator);
        dealCycle3.add(hologramGraffitiFusionDelay);
        dealCycle3.add(overdrive);
        dealCycle3.add(meltdownExplosion);
        dealCycle3.add(soulContract);
        dealCycle3.add(readyToDie);
        dealCycle3.add(weaponJumpRing);

        while (getStart().before(getEnd())) {
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
                    && energyCnt == 20
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().after(new Timestamp(60 * 1000))
                    && energyCnt == 20
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().after(new Timestamp(60 * 1000))
                    && energyCnt == 20
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(hologramGraffitiForceFieldDelay)
                    && !cooldownCheck(loadedDice)
            ) {
                addSkillEvent(hologramGraffitiForceFieldDelay);
            } else if (
                    cooldownCheck(photonRay)
                    && getStart().before(new Timestamp(loadedDice.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(photonRay);
            } else if (
                    cooldownCheck(resistanceLineInfantry)
                    && getStart().before(new Timestamp(loadedDice.getActivateTime().getTime() - 25000))
            ) {
                addSkillEvent(resistanceLineInfantry);
            } else {
                if (cooldownCheck(fuzzyRobMasqueradeExecution)) {
                    addSkillEvent(fuzzyRobMasqueradeExecution);
                } else {
                    addSkillEvent(fuzzyRobMasqueradeSnipe);
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (cooldownCheck(inclinePower)) {
            if (
                    getStart().before(overloadModeEndTime)
                    && energyCnt >= 3
            ) {
                energyCnt -= 3;
            } else if (energyCnt >= 3) {
                energyCnt -= 3;
            } else {
                energyCnt = 0;
            }
            applyCooldown(inclinePower);
        }
        if (cooldownCheck(supplySurplus)) {
            if (
                    getStart().before(overloadModeEndTime)
                    && energyCnt < 50
            ) {
                energyCnt ++;
                supplySurplus.setCooldown(0.5);
            } else if (
                    energyCnt < 20
            ) {
                energyCnt ++;
                supplySurplus.setCooldown(4.0);
            }
            applyCooldown(supplySurplus);
        }
        if (getStart().after(overloadModeEndTime) && energyCnt > 20) {
            energyCnt = 20;
        }
        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof OverloadMode) {
                overloadModeEndTime = new Timestamp(getStart().getTime() + 70000);
            }
            if (skill instanceof OopartsCode) {
                energyCnt -= 20;
            }
            if (skill instanceof AmaranceGenerator) {
                if (energyCnt < 20) {
                    energyCnt = 20;
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
            if (skill instanceof HologramGraffitiFusion) {
                hologramGraffitiFusionStartTimeList.add(new Timestamp(getStart().getTime()));
                hologramGraffitiFusionEndTimeList.add(new Timestamp(getStart().getTime() + 40000));
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
                        getSkillEventList().add(new XenonSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.energyCnt));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new XenonSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.energyCnt));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new XenonSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, (long) this.energyCnt));
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
            overlappingSkillEvents = deduplication(overlappingSkillEvents, SkillEvent::getSkill);
            for (SkillEvent skillEvent : overlappingSkillEvents) {
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
                Long currentEnergyCnt = ((XenonSkillEvent) se).getCurrentEnergyCnt();
                if (currentEnergyCnt <= 20) {
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * currentEnergyCnt
                            )
                    );
                } else {
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.2
                            )
                    );
                    buffSkill.addBuffFinalDamage(
                            1 + currentEnergyCnt * 0.01
                    );
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        se.getSkill() instanceof MegaSmasher
                        || se.getSkill() instanceof MegaSmasherReinforce
                        || se.getSkill() instanceof FuzzyRobMasqueradeSnipe
                        || se.getSkill() instanceof FuzzyRobMasqueradeExecution
                        || se.getSkill() instanceof OverloadModePlasmaCurrent
                        || se.getSkill() instanceof PhotonRay
                        || se.getSkill() instanceof MeltdownExplosion
                ) {
                    Long ran = (long) (Math.random() * 9 + 1);
                    if (ran <= 3) {
                        airFrameCnt++;
                        if (airFrameCnt >= 3) {
                            totalDamage += getAttackDamage(new XenonSkillEvent(triangleFormation, start, end, (long) this.energyCnt), buffSkill, start, end);
                            airFrameCnt -= 3;
                        }
                    }
                }
                if (
                        se.getSkill() instanceof MegaSmasher
                        || se.getSkill() instanceof MegaSmasherReinforce
                        || se.getSkill() instanceof FuzzyRobMasqueradeSnipe
                        || se.getSkill() instanceof FuzzyRobMasqueradeExecution
                ) {
                    if (
                            start.after(pinpointRocketCooltime)
                            && start.equals(se.getStart())
                    ) {
                        totalDamage += getAttackDamage(new XenonSkillEvent(pinpointRocket, start, end, (long) this.energyCnt), buffSkill, start, end);
                        pinpointRocketCooltime = new Timestamp(pinpointRocketCooltime.getTime() + 2000);
                    }
                }
            }
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
        Long tmp = 3L;
        if (skillEvent.getSkill() instanceof AegisSystem) {
            tmp = ((AegisSystem) skillEvent.getSkill()).getAttackCount();
            for (int i = 0; i < hologramGraffitiFusionStartTimeList.size(); i++) {
                if (start.after(hologramGraffitiFusionStartTimeList.get(i)) && end.before(hologramGraffitiFusionEndTimeList.get(i))) {
                    ((AegisSystem) skillEvent.getSkill()).setAttackCount(((AegisSystem) skillEvent.getSkill()).getAttackCount() + 8);
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                attackDamage = (long) Math.floor(
                        (
                                getJob().getFinalMainStat() + buffSkill.getBuffMainStat()
                                + getJob().getFinalSubstat() + buffSkill.getBuffSubStat()
                                + ((Xenon) getJob()).getFinalSubStat2() + buffSkill.getBuffOtherStat1()
                        ) * 4 * 0.01
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
                if (as.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / as.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        if (skillEvent.getSkill() instanceof AegisSystem) {
            ((AegisSystem) skillEvent.getSkill()).setAttackCount(tmp);
        }
        return attackDamage;
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
