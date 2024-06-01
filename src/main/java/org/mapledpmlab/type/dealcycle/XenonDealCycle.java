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
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private final List<Skill> dealCycle3 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new TriangleFormationPlasma());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new PhotonRayBeforeDelay());
            add(new ResistanceLineInfantryDelay());
            add(new MegaSmasherBeforeDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AmaranceGenerator());
            add(new Evolution());
            //add(new ExtraSupply());
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

    Timestamp evolutionEndTime = new Timestamp(-1);
    Timestamp overloadModeEndTime = new Timestamp(-1);
    Timestamp pinpointRocketCooltime = new Timestamp(-1);

    ArtificialEvolutionAirFrame artificialEvolutionAirFrame = new ArtificialEvolutionAirFrame();
    InclinePower inclinePower = new InclinePower();
    PinpointRocket pinpointRocket = new PinpointRocket();
    SupplySurplus supplySurplus = new SupplySurplus();
    TriangleFormation triangleFormation = new TriangleFormation();
    TriangleFormationPlasma triangleFormationPlasma = new TriangleFormationPlasma();

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
        HologramGraffitiForceField hologramGraffitiForceField = new HologramGraffitiForceField();
        HologramGraffitiFusion hologramGraffitiFusion = new HologramGraffitiFusion();
        LoadedDice loadedDice = new LoadedDice();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MegaSmasherBeforeDelay megaSmasher = new MegaSmasherBeforeDelay();
        MegaSmasherReinforce megaSmasherReinforce = new MegaSmasherReinforce();
        MeltdownExplosion meltdownExplosion = new MeltdownExplosion();
        OopartsCode oopartsCode = new OopartsCode();
        Overdrive overdrive = new Overdrive(255L);
        OverloadMode overloadMode = new OverloadMode();
        PhotonRay photonRay = new PhotonRay();
        PhotonRayBeforeDelay photonRayBeforeDelay = new PhotonRayBeforeDelay();
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
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        /*for (int i = 0; i < 720 * 1000; i += aegisSystem.getInterval()) {
            getSkillEventList().add(new SkillEvent(aegisSystem, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }*/

        ringSwitching.setCooldown(95.0);

        dealCycle1.add(photonRayBeforeDelay);
        dealCycle1.add(loadedDice);
        dealCycle1.add(oopartsCode);
        dealCycle1.add(amaranceGenerator);
        dealCycle1.add(overloadMode);
        dealCycle1.add(hologramGraffitiForceField);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(hologramGraffitiFusion);
        dealCycle1.add(overdrive);
        dealCycle1.add(meltdownExplosion);
        dealCycle1.add(soulContract);
        dealCycle1.add(readyToDie);
        dealCycle1.add(restraintRing);
        dealCycle1.add(resistanceLineInfantry);
        dealCycle1.add(artificialEvolution);
        dealCycle1.add(megaSmasherReinforce);
        dealCycle1.add(photonRay);

        dealCycle2.add(photonRayBeforeDelay);
        dealCycle2.add(loadedDice);
        dealCycle2.add(oopartsCode);
        dealCycle2.add(amaranceGenerator);
        dealCycle2.add(overloadMode);
        dealCycle2.add(hologramGraffitiForceField);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(hologramGraffitiFusion);
        dealCycle2.add(overdrive);
        dealCycle2.add(meltdownExplosion);
        dealCycle2.add(soulContract);
        dealCycle2.add(readyToDie);
        dealCycle2.add(restraintRing);
        dealCycle2.add(resistanceLineInfantry);
        dealCycle2.add(megaSmasher);
        dealCycle2.add(photonRay);

        dealCycle3.add(photonRayBeforeDelay);
        dealCycle3.add(oopartsCode);
        dealCycle3.add(amaranceGenerator);
        dealCycle3.add(hologramGraffitiFusion);
        dealCycle3.add(overdrive);
        dealCycle3.add(meltdownExplosion);
        dealCycle3.add(soulContract);
        dealCycle3.add(readyToDie);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(photonRay);

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
                    cooldownCheck(hologramGraffitiForceField)
                    && !cooldownCheck(loadedDice)
            ) {
                addSkillEvent(hologramGraffitiForceField);
            } else if (
                    cooldownCheck(photonRayBeforeDelay)
                    && getStart().before(new Timestamp(loadedDice.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(photonRayBeforeDelay);
                for (int i = 0; i < 10; i++) {
                    if (cooldownCheck(fuzzyRobMasqueradeExecution)) {
                        addSkillEvent(fuzzyRobMasqueradeExecution);
                    } else {
                        addSkillEvent(fuzzyRobMasqueradeSnipe);
                    }
                }
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
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    skill instanceof FuzzyRobMasqueradeExecution
                    || skill instanceof ArtificialEvolution
            ) {
                Long ran = (long) (Math.random() * 9 + 1);
                if (ran <= 3) {
                    Timestamp timestamp = new Timestamp(getStart().getTime());
                    getStart().setTime(getStart().getTime() + sum);
                    addSkillEvent(triangleFormation);
                    airFrameCnt++;
                    if (airFrameCnt >= 3) {
                        addSkillEvent(triangleFormationPlasma);
                        airFrameCnt -= 3;
                    }
                    getStart().setTime(timestamp.getTime());
                }
            }
            getSkillEventList().add(new XenonSkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), (long) this.energyCnt));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
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
            if (skill instanceof Evolution) {
                evolutionEndTime = new Timestamp(getStart().getTime() + 30000);
            }
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
            if (
                    skill instanceof FuzzyRobMasqueradeExecution
                    || skill instanceof MeltdownExplosion
                    || skill instanceof ArtificialEvolutionAirFrame
            ) {
                Long ran = (long) (Math.random() * 9 + 1);
                if (ran <= 3) {
                    addSkillEvent(triangleFormation);
                    airFrameCnt++;
                    if (airFrameCnt >= 3) {
                        addSkillEvent(triangleFormationPlasma);
                        airFrameCnt -= 3;
                    }
                }
            }
            if (
                    getStart().before(evolutionEndTime)
                    && !(skill instanceof ArtificialEvolutionAirFrame)
                    && cooldownCheck(artificialEvolutionAirFrame)
            ) {
                addSkillEvent(artificialEvolutionAirFrame);
            }
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof HologramGraffitiFusion) {
                        i = 1200;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new XenonSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.energyCnt));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                skill instanceof MegaSmasher
                                || skill instanceof MegaSmasherReinforce
                                || skill instanceof OverloadModePlasmaCurrent
                                || skill instanceof PhotonRay
                        ) {
                            Long ran = (long) (Math.random() * 9 + 1);
                            if (ran <= 3) {
                                Timestamp timestamp = new Timestamp(getStart().getTime());
                                getStart().setTime(getStart().getTime() + i);
                                addSkillEvent(triangleFormation);
                                airFrameCnt++;
                                if (airFrameCnt >= 3) {
                                    addSkillEvent(triangleFormationPlasma);
                                    airFrameCnt -= 3;
                                }
                                getStart().setTime(timestamp.getTime());
                            }
                        }
                        getSkillEventList().add(new XenonSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.energyCnt));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
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
            List<SkillEvent> useBuffSkillList = new ArrayList<>();
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isOverloadMode = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof OverloadMode) {
                    isOverloadMode = true;
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
                Long currentEnergyCnt = ((XenonSkillEvent) se).getCurrentEnergyCnt();
                if (currentEnergyCnt <= 20) {
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * currentEnergyCnt
                            )
                    );
                } else if (isOverloadMode){
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.2
                            )
                    );
                    buffSkill.addBuffFinalDamage(
                            1 + (currentEnergyCnt - 20) * 0.01
                    );
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
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
                        totalDamage += getAttackDamage(new XenonSkillEvent(pinpointRocket, start, end, ((XenonSkillEvent) se).getCurrentEnergyCnt()), buffSkill, start, end);
                        pinpointRocketCooltime = new Timestamp(pinpointRocketCooltime.getTime() + 2000);
                    }
                }
                if (currentEnergyCnt <= 20) {
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * -currentEnergyCnt
                            )
                    );
                } else if (isOverloadMode){
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * -0.2
                            )
                    );
                    buffSkill.addBuffFinalDamage(
                            1 + (currentEnergyCnt - 20) * -0.01
                    );
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
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(
                        (
                                getJob().getFinalMainStat()
                                + getJob().getFinalSubstat()
                                + ((Xenon) getJob()).getFinalSubStat2()
                        ) * 4 * 0.01
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

    @Override
    public void getJobInfo() {
        System.out.println("-------------------");
        System.out.println("직업 : " + getJob().getName());
        System.out.println("기본 주스탯 수치 : " + getJob().getMainStat());
        System.out.println("주스탯 % 수치 : " + (getJob().getMainStatP() + getJob().getAllStatP()));
        System.out.println("% 미적용 주스탯 수치 : " + getJob().getPerXMainStat());
        System.out.println("기본 부스탯 수치 : " + getJob().getSubStat());
        System.out.println("부스탯 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXSubStat());
        System.out.println("기본 부스탯2 수치 : " + getJob().getOtherStat1());
        System.out.println("부스탯2 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXOtherStat());
        System.out.println("기본 스공 : " + getJob().getStatDamage());
        System.out.println("데미지 : " + getJob().getDamage());
        System.out.println("최종데미지 : " + getJob().getFinalDamage());
        System.out.println("보스 데미지 : " + getJob().getBossDamage());
        System.out.println("방어율 무시 : " + getJob().getIgnoreDefense());
        System.out.println("크리티컬 확률 : " + getJob().getCriticalP());
        System.out.println("장비 공격력 % : " + getJob().getAttP());
        System.out.println("장비 마력 % : " + getJob().getMagicP());
        System.out.println("크리티컬 데미지 : " + getJob().getCriticalDamage());
        System.out.println("쿨타임 감소 초 : " + getJob().getCooldownReductionSec());
        System.out.println("쿨타임 감소 % : " + getJob().getCooldownReductionP());
        System.out.println("버프 지속 시간 : " + getJob().getPlusBuffDuration());
        System.out.println("재사용 : " + getJob().getReuse());
        System.out.println("속성 내성 무시 : " + getJob().getProperty());
        System.out.println("무기 공격력 : " + getJob().getWeaponAttMagic());
        System.out.println(getJob().getLinkListStr());
        System.out.println(getJob().getAbility().getDescription());
    }
}
