package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.job.Xenon;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.xenon.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.xenon.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Xenon2HologramDealCycle extends DealCycle {
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
            add(new MegaSmasherBeforeDelay());
            add(new MegaSmasher());
            add(new MegaSmasherReinforce());
            add(new MeltdownExplosion());
            add(new OverloadModePlasmaCurrent());
            add(new PhotonRayBeforeDelay());
            add(new PhotonRay());
            add(new PinpointRocket());
            add(new ResistanceLineInfantryDelay());
            add(new ResistanceLineInfantry());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TriangleFormation());
            add(new TriangleFormationPlasma());
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
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int airFrameCnt = 0;
    int energyCnt = 20;

    List<Timestamp> hologramGraffitiFusionStartTimeList = new ArrayList<>();
    List<Timestamp> hologramGraffitiFusionEndTimeList = new ArrayList<>();

    Timestamp evolutionEndTime = new Timestamp(-1);
    Timestamp overloadModeEndTime = new Timestamp(-1);
    Timestamp pinpointRocketCooltime = new Timestamp(-1);

    AegisSystem aegisSystem = new AegisSystem();
    AmaranceGenerator amaranceGenerator = new AmaranceGenerator();
    ArtificialEvolution artificialEvolution = new ArtificialEvolution();
    ArtificialEvolutionAirFrame artificialEvolutionAirFrame = new ArtificialEvolutionAirFrame();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    ExtraSupply extraSupply = new ExtraSupply();
    FuzzyRobMasqueradeExecution fuzzyRobMasqueradeExecution = new FuzzyRobMasqueradeExecution();
    FuzzyRobMasqueradeSnipe fuzzyRobMasqueradeSnipe = new FuzzyRobMasqueradeSnipe();
    HologramGraffitiForceField hologramGraffitiForceField = new HologramGraffitiForceField();
    HologramGraffitiFusion hologramGraffitiFusion = new HologramGraffitiFusion();
    InclinePower inclinePower = new InclinePower();
    LoadedDice loadedDice = new LoadedDice();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MegaSmasherBeforeDelay megaSmasherBeforeDelay = new MegaSmasherBeforeDelay();
    MegaSmasher megaSmasher = new MegaSmasher();
    MegaSmasherReinforce megaSmasherReinforce = new MegaSmasherReinforce();
    MeltdownExplosion meltdownExplosion = new MeltdownExplosion();
    OopartsCode oopartsCode = new OopartsCode();
    Overdrive overdrive = new Overdrive(255L);
    OverloadMode overloadMode = new OverloadMode();
    PhotonRay photonRay = new PhotonRay();
    PhotonRayBeforeDelay photonRayBeforeDelay = new PhotonRayBeforeDelay();
    PinpointRocket pinpointRocket = new PinpointRocket();
    ReadyToDie readyToDie = new ReadyToDie();
    ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SupplySurplus supplySurplus = new SupplySurplus();
    TriangleFormation triangleFormation = new TriangleFormation();
    TriangleFormationPlasma triangleFormationPlasma = new TriangleFormationPlasma();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public Xenon2HologramDealCycle(Job job) {
        super(job, null);

        this.getJob().setName("제논(2홀로그램)");

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        /*for (int i = 0; i < 720 * 1000; i += aegisSystem.getInterval()) {
            getSkillEventList().add(new SkillEvent(aegisSystem, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }*/

        ringSwitching.setCooldown(90.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);
        inclinePower.setApplyCooldownReduction(false);
        applyCooldown(inclinePower);

        getStart().setTime(-7000);
        overloadMode.setActivateTime(new Timestamp(-5555555));
        overloadMode.getRelatedSkill().setActivateTime(new Timestamp(-5555555));
        megaSmasherBeforeDelay.setActivateTime(new Timestamp(-5555555));
        triangleFormation.setActivateTime(new Timestamp(-55555555));
        addSkillEvent(overloadMode);
        addSkillEvent(megaSmasherBeforeDelay);
        getStart().setTime(0);
        energyCnt = 50;
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(overloadMode)
                            && cooldownCheck(megaSmasherBeforeDelay)
                            && cooldownCheck(loadedDice)
                            && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(overloadMode);
                addSkillEvent(megaSmasherBeforeDelay);
            }
            if (cooldownCheck(resistanceLineInfantry)) {
                addSkillEvent(resistanceLineInfantry);
            }
            if (
                    cooldownCheck(photonRayBeforeDelay)
                            && cooldownCheck(loadedDice)
                            && cooldownCheck(oopartsCode)
                            && cooldownCheck(amaranceGenerator)
                            && cooldownCheck(hologramGraffitiForceField)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(hologramGraffitiFusion)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(meltdownExplosion)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(readyToDie)
                            && cooldownCheck(restraintRing)
                            && getStart().before(new Timestamp(600 * 1000))
                            && energyCnt >= 20
            ) {
                boolean isOrigin = false;
                addSkillEvent(photonRayBeforeDelay);
                addSkillEvent(loadedDice);
                addSkillEvent(meltdownExplosion);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                if (cooldownCheck(fuzzyRobMasqueradeExecution)) {
                    addSkillEvent(fuzzyRobMasqueradeExecution);
                } else {
                    addSkillEvent(fuzzyRobMasqueradeSnipe);
                }
                addSkillEvent(hologramGraffitiFusion);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(oopartsCode);
                addSkillEvent(hologramGraffitiForceField);
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(restraintRing);
                if (cooldownCheck(fuzzyRobMasqueradeExecution)) {
                    addSkillEvent(fuzzyRobMasqueradeExecution);
                } else {
                    addSkillEvent(fuzzyRobMasqueradeSnipe);
                }
                if (cooldownCheck(artificialEvolution)) {
                    addSkillEvent(artificialEvolution);
                    addSkillEvent(megaSmasherReinforce);
                    if (cooldownCheck(fuzzyRobMasqueradeExecution)) {
                        addSkillEvent(fuzzyRobMasqueradeExecution);
                    } else {
                        addSkillEvent(fuzzyRobMasqueradeSnipe);
                    }
                    isOrigin = true;
                }
                if (!isOrigin) {
                    addSkillEvent(megaSmasher);
                }
                addSkillEvent(photonRay);
            } else if (
                    cooldownCheck(photonRayBeforeDelay)
                            && cooldownCheck(oopartsCode)
                            && cooldownCheck(amaranceGenerator)
                            && cooldownCheck(hologramGraffitiFusion)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(meltdownExplosion)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(readyToDie)
                            && cooldownCheck(weaponJumpRing)
                            && cooldownCheck(photonRay)
                            && getStart().before(new Timestamp(660 * 1000))
                            && energyCnt == 20
            ) {
                addSkillEvent(photonRayBeforeDelay);
                addSkillEvent(oopartsCode);
                addSkillEvent(amaranceGenerator);
                addSkillEvent(hologramGraffitiFusion);
                addSkillEvent(overdrive);
                addSkillEvent(meltdownExplosion);
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(photonRay);
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
                            && (
                            (
                                    !cooldownCheck(readyToDie)
                                            && getStart().before(new Timestamp(loadedDice.getActivateTime().getTime() - 20000))
                            ) || getStart().after(new Timestamp(660 * 1000))
                    )
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
                    || skill instanceof ArtificialEvolutionAirFrame
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
                supplySurplus.setActivateTime(new Timestamp(supplySurplus.getActivateTime().getTime() + 500));
            } else if (energyCnt < 20) {
                energyCnt ++;
                supplySurplus.setActivateTime(new Timestamp(supplySurplus.getActivateTime().getTime() + 4000));
            }
        }
        if (getStart().after(overloadModeEndTime) && energyCnt > 20) {
            energyCnt = 20;
        }
        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t서플러스 에너지 : " + energyCnt + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t서플러스 에너지 : " + energyCnt + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof Evolution) {
                evolutionEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof OverloadMode) {
                overloadModeEndTime = new Timestamp(getStart().getTime() + 70000);
            }
            if (
                    skill instanceof OopartsCode
                    && getStart().after(overloadModeEndTime)
            ) {
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
                if (skill instanceof OverdriveDebuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 31000), new Timestamp(getStart().getTime() + (long) (applyCooldownReduction(skill) * 1000))));
                } else {
                    endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                    if (skill.isApplyServerLag()) {
                        endTime = new Timestamp(endTime.getTime() + 3000);
                    }
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
            if (
                    skill instanceof FuzzyRobMasqueradeExecution
                    || skill instanceof MeltdownExplosion
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
                    && !(skill instanceof TriangleFormationPlasma)
                    && !(skill instanceof TriangleFormation)
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
                    buffSkill.addBuffSubStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * currentEnergyCnt
                            )
                    );
                    buffSkill.addBuffOtherStat1(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * currentEnergyCnt
                            )
                    );
                } else if (isOverloadMode){
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * currentEnergyCnt
                            )
                    );
                    buffSkill.addBuffSubStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * currentEnergyCnt
                            )
                    );
                    buffSkill.addBuffOtherStat1(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * currentEnergyCnt
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
                    buffSkill.addBuffSubStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * -currentEnergyCnt
                            )
                    );
                    buffSkill.addBuffOtherStat1(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * 0.01 * -currentEnergyCnt
                            )
                    );
                } else if (isOverloadMode){
                    buffSkill.addBuffMainStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * -0.01 * currentEnergyCnt
                            )
                    );
                    buffSkill.addBuffSubStat(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * -0.01 * currentEnergyCnt
                            )
                    );
                    buffSkill.addBuffOtherStat1(
                            (long) Math.floor(
                                    (this.getJob().getLevel() + 2) * 5 * -0.01 * currentEnergyCnt
                            )
                    );
                    buffSkill.setBuffFinalDamage(
                            buffSkill.getBuffFinalDamage() / (1 + (currentEnergyCnt - 20) * 0.01)
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
    public Long getDotDamage(AttackSkill attackSkill, BuffSkill buffSkill) {
        Long attackDamage;
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
                        * (1 + (
                        getJob().getDamage()
                                + getJob().getBossDamage()
                                + getJob().getStatXDamage()
                                + buffSkill.getBuffDamage()
                                + attackSkill.getAddDamage()
                                - 310
                                - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01)
                ) * 0.01)
                        * getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
        );
        return attackDamage;
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
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
                                    * (1 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
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
