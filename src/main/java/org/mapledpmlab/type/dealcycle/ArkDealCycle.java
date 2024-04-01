package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.ark.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.ark.ChargeSpellAmplification;
import org.mapledpmlab.type.skill.buffskill.ark.ContactCaravan;
import org.mapledpmlab.type.skill.buffskill.ark.InfinitySpell;
import org.mapledpmlab.type.skill.buffskill.ark.SpecterForm;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArkDealCycle extends DealCycle {
    private List<Skill> dealCycle1 = new ArrayList<>();

    private List<Skill> dealCycle2 = new ArrayList<>();

    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<Skill> dealCycle4 = new ArrayList<>();

    private List<Skill> dealCycle5 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AbyssChargeDrive());
            add(new AbyssChargeDriveMagic());
            add(new AbyssSpell());
            add(new AncientAbyss());
            add(new AncientAbyssDot());
            add(new ApproachingDeath());
            add(new AwakenedAbyss());
            add(new BlissfulRestraint());
            add(new BlissfulRestraintDot());
            add(new BlissfulRestraintFinish());
            add(new CrawlingFear());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DeviousNightmare());
            add(new DeviousOminousDream());
            add(new EndlessAgony());
            add(new EndlessAgonyFinish());
            add(new EndlessHunger());
            add(new EndlesslyStarvingBeast());
            add(new EndlessNightmare());
            add(new EndlessOminousDream());
            add(new GustChargeDrive());
            add(new GustSpell());
            add(new MagicCircuitFullDrive());
            add(new MemoryOfRoot());
            add(new MemoryOfRootFinish());
            add(new PlainChargeDrive());
            add(new PlainSpell());
            add(new ReturningHatred());
            add(new ScarletChargeDrive());
            add(new ScarletChargeDriveFlame());
            add(new ScarletSpell());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new UncontrollableChaos());
            add(new UnfadingScar());
            add(new UnstoppableImpulse());
            add(new UnstoppableInstinct());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new CrawlingFearBeforeDelay());
            add(new EndlessAgonyBeforeDelay());
            add(new MemoryOfRootBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ChargeSpellAmplification());
            add(new ContactCaravan());
            add(new GrandisGoddessBlessingLef(302L));
            add(new InfinitySpell());
            add(new LoadedDice());
            add(new MagicCircuitFullDriveBuff());
            add(new Overdrive(302L));
            add(new OverdriveDebuff(302L));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SpecterForm());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WrathOfGod());
        }
    };

    AbyssSpell abyssSpell = new AbyssSpell();
    ApproachingDeath approachingDeath = new ApproachingDeath();
    AwakenedAbyss awakenedAbyss = new AwakenedAbyss();
    DeviousNightmare deviousNightmare = new DeviousNightmare();
    DeviousOminousDream deviousOminousDream = new DeviousOminousDream();
    GustSpell gustSpell = new GustSpell();
    MagicCircuitFullDrive magicCircuitFullDrive = new MagicCircuitFullDrive();
    PlainSpell plainSpell = new PlainSpell();
    ScarletSpell scarletSpell = new ScarletSpell();

    boolean isSpecter = false;
    boolean isAbyss = false;
    boolean isGust = false;
    boolean isScarlet = false;
    boolean isChaos = false;
    boolean isFear = false;
    boolean isHunger = false;
    boolean isInstinct = false;
    boolean isScar = false;

    Timestamp magicCircuitFullDriveEndTime = new Timestamp(-1);
    Timestamp memoryOfRootEndTime = new Timestamp(-1);

    int hatredCnt = 0;
    int specterAura = 300;

    public ArkDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AbyssChargeDriveMagic abyssChargeDriveMagic = new AbyssChargeDriveMagic();
        AncientAbyssDot ancientAbyssDot = new AncientAbyssDot();
        BlissfulRestraintDot blissfulRestraintDot = new BlissfulRestraintDot();
        ChargeSpellAmplification chargeSpellAmplification = new ChargeSpellAmplification();
        ContactCaravan contactCaravan = new ContactCaravan();
        CrawlingFearBeforeDelay crawlingFearBeforeDelay = new CrawlingFearBeforeDelay();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        EndlessAgonyBeforeDelay endlessAgonyBeforeDelay = new EndlessAgonyBeforeDelay();
        EndlessHunger endlessHunger = new EndlessHunger();
        EndlesslyStarvingBeast endlesslyStarvingBeast = new EndlesslyStarvingBeast();
        EndlessNightmare endlessNightmare = new EndlessNightmare();
        EndlessOminousDream endlessOminousDream = new EndlessOminousDream();
        GrandisGoddessBlessingLef grandisGoddessBlessingLef = new GrandisGoddessBlessingLef(302L);
        GustChargeDrive gustChargeDrive = new GustChargeDrive();
        InfinitySpell infinitySpell = new InfinitySpell();
        LoadedDice loadedDice = new LoadedDice();
        MagicCircuitFullDriveBuff magicCircuitFullDriveBuff = new MagicCircuitFullDriveBuff();
        MemoryOfRootBeforeDelay memoryOfRootBeforeDelay = new MemoryOfRootBeforeDelay();
        Overdrive overdrive = new Overdrive(302L);
        PlainChargeDrive plainChargeDrive = new PlainChargeDrive();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        ReturningHatred returningHatred = new ReturningHatred();
        RingSwitching ringSwitching = new RingSwitching();
        ScarletChargeDriveFlame scarletChargeDriveFlame = new ScarletChargeDriveFlame();
        SoulContract soulContract = new SoulContract();
        SpecterForm specterForm = new SpecterForm();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UncontrollableChaos uncontrollableChaos = new UncontrollableChaos();
        UnfadingScar unfadingScar = new UnfadingScar();
        UnstoppableImpulse unstoppableImpulse = new UnstoppableImpulse();
        UnstoppableInstinct unstoppableInstinct = new UnstoppableInstinct();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WrathOfGod wrathOfGod = new WrathOfGod();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);

        // 리레, 그여축, 6차
        dealCycle1.add(wrathOfGod);
        dealCycle1.add(chargeSpellAmplification);
        dealCycle1.add(magicCircuitFullDriveBuff);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(infinitySpell);
        dealCycle1.add(grandisGoddessBlessingLef);
        dealCycle1.add(overdrive);
        dealCycle1.add(blissfulRestraintDot);
        dealCycle1.add(endlesslyStarvingBeast);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(crawlingFearBeforeDelay);
        dealCycle1.add(endlessAgonyBeforeDelay);
        dealCycle1.add(memoryOfRootBeforeDelay);
        dealCycle1.add(returningHatred);
        dealCycle1.add(ancientAbyssDot);

        // 웨퍼, 그여축, 6차
        dealCycle2.add(wrathOfGod);
        dealCycle2.add(chargeSpellAmplification);
        dealCycle2.add(magicCircuitFullDriveBuff);
        dealCycle2.add(infinitySpell);
        dealCycle2.add(grandisGoddessBlessingLef);
        dealCycle2.add(overdrive);
        dealCycle2.add(blissfulRestraintDot);
        dealCycle2.add(endlesslyStarvingBeast);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(crawlingFearBeforeDelay);
        dealCycle2.add(endlessAgonyBeforeDelay);
        dealCycle2.add(memoryOfRootBeforeDelay);
        dealCycle2.add(returningHatred);
        dealCycle2.add(ancientAbyssDot);

        // 리레, 그여축
        dealCycle3.add(wrathOfGod);
        dealCycle3.add(chargeSpellAmplification);
        dealCycle3.add(magicCircuitFullDriveBuff);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(infinitySpell);
        dealCycle3.add(grandisGoddessBlessingLef);
        dealCycle3.add(overdrive);
        dealCycle3.add(blissfulRestraintDot);
        dealCycle3.add(endlesslyStarvingBeast);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);
        dealCycle3.add(crawlingFearBeforeDelay);
        dealCycle3.add(endlessAgonyBeforeDelay);
        dealCycle3.add(memoryOfRootBeforeDelay);
        dealCycle3.add(returningHatred);

        // 웨퍼
        dealCycle4.add(wrathOfGod);
        dealCycle4.add(chargeSpellAmplification);
        dealCycle4.add(magicCircuitFullDriveBuff);
        dealCycle4.add(infinitySpell);
        dealCycle4.add(grandisGoddessBlessingLef);
        dealCycle4.add(overdrive);
        dealCycle4.add(blissfulRestraintDot);
        dealCycle4.add(endlesslyStarvingBeast);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(crawlingFearBeforeDelay);
        dealCycle4.add(endlessAgonyBeforeDelay);
        dealCycle4.add(memoryOfRootBeforeDelay);
        dealCycle4.add(returningHatred);

        dealCycle5.add(overdrive);
        dealCycle5.add(soulContract);
        dealCycle5.add(crawlingFearBeforeDelay);
        dealCycle5.add(endlessAgonyBeforeDelay);

        // 그여축 1345 1-4-3-2-3-4
        int dealCycleOrder = 1;
        addSkillEvent(contactCaravan);
        while (getStart().before(getEnd())) {
            if (cooldownCheck(loadedDice)) {
                System.out.println("--------------");
                System.out.println("dice");
                System.out.println(getStart());
                addSkillEvent(loadedDice);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 1
                    && !isSpecter
            ) {
                System.out.println("--------------");
                System.out.println("dc1");
                System.out.println(getStart());
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
                    && !isSpecter
            ) {
                System.out.println("--------------");
                System.out.println("dc2");
                System.out.println(getStart());
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 3 || dealCycleOrder == 5)
                    && !isSpecter
            ) {
                System.out.println("--------------");
                System.out.println("dc3");
                System.out.println(getStart());
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
                    && !isSpecter
            ) {
                System.out.println("--------------");
                System.out.println("dc4");
                System.out.println(getStart());
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle5)
                    && !cooldownCheck(wrathOfGod)
                    && !isSpecter
            ) {
                System.out.println("--------------");
                System.out.println("dc5");
                System.out.println(getStart());
                addDealCycle(dealCycle5);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && !isSpecter
            ) {
                System.out.println("--------------");
                System.out.println("ring");
                System.out.println(getStart());
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(returningHatred)
                    && hatredCnt > 0
            ) {
                for (int i = 0; i < hatredCnt; i++) {
                    getSkillEventList().add(new ArkSkillEvent(returningHatred, new Timestamp(getStart().getTime() + 500), new Timestamp(getStart().getTime() + 500), isSpecter));
                }
                applyCooldown(returningHatred);
                hatredCnt = 0;
            } else if (isSpecter) {
                endlessOminousDream.setDelay(240L);
                endlessHunger.setDelay(660L);
                uncontrollableChaos.setDelay(720L);
                addSkillEvent(endlessOminousDream);
                addSkillEvent(unfadingScar);
                addSkillEvent(endlessOminousDream);
                addSkillEvent(endlessHunger);
                addSkillEvent(endlessOminousDream);
                addSkillEvent(uncontrollableChaos);
                addSkillEvent(endlessOminousDream);
                addSkillEvent(unstoppableInstinct);
                addSkillEvent(endlessOminousDream);
                addSkillEvent(unfadingScar);
                addSkillEvent(endlessOminousDream);
                unstoppableInstinct.setDelay(720L);
                addSkillEvent(unstoppableInstinct);
                if (getStart().after(memoryOfRootEndTime)) {
                    addSkillEvent(specterForm);
                }
            } else if (!isSpecter) {
                plainChargeDrive.setDelay(180L);
                scarletChargeDriveFlame.getRelatedSkill().setDelay(470L);
                gustChargeDrive.setDelay(410L);
                abyssChargeDriveMagic.getRelatedSkill().setDelay(530L);
                addSkillEvent(plainChargeDrive);
                addSkillEvent(endlessNightmare);
                addSkillEvent(plainChargeDrive);
                addSkillEvent(scarletChargeDriveFlame);
                addSkillEvent(plainChargeDrive);
                addSkillEvent(gustChargeDrive);
                addSkillEvent(plainChargeDrive);
                addSkillEvent(abyssChargeDriveMagic);
                addSkillEvent(plainChargeDrive);
                addSkillEvent(endlessNightmare);
                addSkillEvent(plainChargeDrive);
                scarletChargeDriveFlame.getRelatedSkill().setDelay(690L);
                addSkillEvent(scarletChargeDriveFlame);
                addSkillEvent(specterForm);
            }/* else {
                addSkillEvent(null);
            }*/
        }
        sortEventTimeList();
    }

    @Override
    public void addDealCycle(List<Skill> skillList) {
        for (Skill s : skillList) {
            if (
                    getStart().after(new Timestamp(90 * 1000))
                    && getStart().before(new Timestamp(150 * 1000))
                    && s instanceof MagicCircuitFullDriveBuff
            ) {
                continue;
            }
            this.addSkillEvent(s);
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        //System.out.println(getStart() + " : " + skill.getName());
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (
                skill instanceof InfinitySpell
                || skill instanceof AncientAbyssDot
        ) {
            specterAura = 300;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof MagicCircuitFullDriveBuff) {
                magicCircuitFullDriveEndTime = new Timestamp(getStart().getTime() + 60000);
            }
            if (skill instanceof SpecterForm) {
                if (isSpecter) {
                    isSpecter = false;
                } else {
                    isSpecter = true;
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
                    getStart().before(magicCircuitFullDriveEndTime)
                    && cooldownCheck(magicCircuitFullDrive)
                    && !(skill instanceof MagicCircuitFullDrive)
            ) {
                addSkillEvent(magicCircuitFullDrive);
            }
            if (skill instanceof DeviousNightmare) {
                isAbyss = false;
                isGust = false;
                isScarlet = false;
            }
            if (
                    skill instanceof AbyssChargeDrive
                    && !isAbyss
            ) {
                isAbyss = true;
                deviousNightmare.setActivateTime(new Timestamp(deviousNightmare.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof GustChargeDrive
                    && !isGust
            ) {
                isGust = true;
                deviousNightmare.setActivateTime(new Timestamp(deviousNightmare.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof ScarletChargeDrive
                    && !isScarlet
            ) {
                isScarlet = true;
                deviousNightmare.setActivateTime(new Timestamp(deviousNightmare.getActivateTime().getTime() - 1000));
            }
            if (skill instanceof DeviousOminousDream) {
                isChaos = false;
                isFear = false;
                isHunger = false;
                isInstinct = false;
                isScar = false;
            }
            if (
                    skill instanceof UncontrollableChaos
                    && !isChaos
            ) {
                isChaos = true;
                deviousOminousDream.setActivateTime(new Timestamp(deviousOminousDream.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof CrawlingFear
                    && !isFear
            ) {
                isFear = true;
                deviousOminousDream.setActivateTime(new Timestamp(deviousOminousDream.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof EndlessHunger
                    && !isHunger
            ) {
                isHunger = true;
                deviousOminousDream.setActivateTime(new Timestamp(deviousOminousDream.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof UnstoppableInstinct
                    && !isInstinct
            ) {
                isInstinct = true;
                deviousOminousDream.setActivateTime(new Timestamp(deviousOminousDream.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof UnfadingScar
                    && !isScar
            ) {
                isScar = true;
                deviousOminousDream.setActivateTime(new Timestamp(deviousOminousDream.getActivateTime().getTime() - 1000));
            }
            if (
                    skill instanceof BlissfulRestraintDot
                    || skill instanceof CrawlingFearBeforeDelay
            ) {
                isSpecter = true;
            }
            if (skill instanceof MemoryOfRootBeforeDelay) {
                memoryOfRootEndTime = new Timestamp(getStart().getTime() + 18000);
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
                        if (isSpecter && specterAura > 0) {
                            getSkillEventList().add(new ArkSkillEvent(awakenedAbyss, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), isSpecter));
                            specterAura --;
                        }
                        if (isSpecter) {
                            getSkillEventList().add(new ArkSkillEvent(approachingDeath, new Timestamp(getStart().getTime() + i + 500), new Timestamp(getStart().getTime() + i + 500), isSpecter));
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 20 && hatredCnt < 12) {
                                hatredCnt ++;
                            }
                        }
                        getSkillEventList().add(new ArkSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), isSpecter));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                !(skill instanceof BlissfulRestraintDot)
                                && !(skill instanceof MemoryOfRoot)
                                && !(skill instanceof MemoryOfRootFinish)
                                && isSpecter
                        ) {
                            getSkillEventList().add(new ArkSkillEvent(approachingDeath, new Timestamp(getStart().getTime() + i + 500), new Timestamp(getStart().getTime() + i + 500), isSpecter));
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 20 && hatredCnt < 12) {
                                hatredCnt ++;
                            }
                        }
                        if (isSpecter && specterAura > 0) {
                            getSkillEventList().add(new ArkSkillEvent(awakenedAbyss, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), isSpecter));
                            specterAura --;
                        }
                        getSkillEventList().add(new ArkSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), isSpecter));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                if (
                        !(skill instanceof BlissfulRestraint)
                        && isSpecter
                ) {
                    getSkillEventList().add(new ArkSkillEvent(approachingDeath, new Timestamp(endTime.getTime() + 500), new Timestamp(endTime.getTime() + 500), isSpecter));
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 20 && hatredCnt < 12) {
                        hatredCnt ++;
                    }
                }
                if (isSpecter && specterAura > 0) {
                    getSkillEventList().add(new ArkSkillEvent(awakenedAbyss, endTime, endTime, isSpecter));
                    specterAura --;
                }
                getSkillEventList().add(new ArkSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, isSpecter));
            }
        }
        applyCooldown(skill);
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill instanceof PlainChargeDrive) {
            specterAura += 10;
            if (specterAura > 300) {
                specterAura = 300;
            }
        }
        if (
                skill instanceof EndlessNightmare
                && cooldownCheck(deviousNightmare)
        ) {
            addSkillEvent(deviousNightmare);
        }
        if (
                skill instanceof EndlessOminousDream
                && cooldownCheck(deviousOminousDream)
        ) {
            addSkillEvent(deviousOminousDream);
        }
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
            boolean isInfinitySpell = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof InfinitySpell) {
                    isInfinitySpell = true;
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
                if (((ArkSkillEvent) se).isSpecter()) {
                    buffSkill.addBuffAttMagic(30L);
                }
                if (
                        isInfinitySpell
                        && (
                                se.getSkill() instanceof AbyssSpell
                                || se.getSkill() instanceof GustSpell
                                || se.getSkill() instanceof PlainSpell
                                || se.getSkill() instanceof ScarletSpell
                        )
                ) {
                    buffSkill.addBuffDamage(20L);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    if (!(se.getSkill() instanceof PlainSpell)) {
                        totalDamage += getAttackDamage(se, buffSkill, start, end);
                    }
                }
                if (
                        isInfinitySpell
                        && se.getSkill() instanceof ApproachingDeath
                ) {
                    ((ApproachingDeath) se.getSkill()).setDamage(190.0 + 145 + 118 + 210);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                    totalDamage += getAttackDamage(se, buffSkill, start, end);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isInfinitySpell
                        && se.getSkill() instanceof ApproachingDeath
                ) {
                    ((ApproachingDeath) se.getSkill()).setDamage(190.0 + 145 + 118);
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    !(skill instanceof BlissfulRestraintFinish)
                    && isSpecter
            ) {
                getSkillEventList().add(new ArkSkillEvent(approachingDeath, new Timestamp(getStart().getTime() + sum + 500), new Timestamp(getStart().getTime() + sum + 500), isSpecter));
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 20 && hatredCnt < 12) {
                    hatredCnt ++;
                }
            }
            if (isSpecter && specterAura > 0) {
                getSkillEventList().add(new ArkSkillEvent(awakenedAbyss, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), isSpecter));
                specterAura --;
            }
            getSkillEventList().add(new ArkSkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), isSpecter));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }
}
