package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.ark.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.ark.*;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArkDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new CrawlingFearBeforeDelay());
            add(new CrawlingFear());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DeviousNightmare());
            add(new DeviousOminousDream());
            add(new EndlessAgonyBeforeDelay());
            add(new EndlessAgony());
            add(new EndlessAgonyFinish());
            add(new EndlessHunger());
            add(new EndlesslyStarvingBeast());
            add(new EndlessNightmare());
            add(new EndlessOminousDream());
            add(new GustChargeDrive());
            add(new GustSpell());
            add(new MagicCircuitFullDrive());
            add(new MemoryOfRootBeforeDelay());
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ChargeSpellAmplification());
            add(new ContactCaravan());
            add(new GrandisGoddessBlessingLef(382L));
            add(new InfinitySpell());
            add(new LoadedDice());
            add(new MagicCircuitFullDriveBuff());
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SpecterForm());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WrathOfGod());
        }
    };

    boolean isSpecter = false;
    boolean isAbyss = false;
    boolean isGust = false;
    boolean isScarlet = false;
    boolean isChaos = false;
    boolean isFear = false;
    boolean isHunger = false;
    boolean isInstinct = false;
    boolean isScar = false;

    Timestamp ancientAbyssEndTime = new Timestamp(-1);
    Timestamp infinitySpellEndTime = new Timestamp(-1);
    Timestamp magicCircuitFullDriveEndTime = new Timestamp(-1);
    Timestamp memoryOfRootEndTime = new Timestamp(-1);

    int hatredCnt = 0;
    int specterAura = 300;

    int gauge = 1000;

    LefGauge lefGauge = new LefGauge();
    SpecterGauge specterGauge = new SpecterGauge();

    AbyssChargeDriveMagic abyssChargeDriveMagic = new AbyssChargeDriveMagic();
    AncientAbyssDot ancientAbyssDot = new AncientAbyssDot();
    ApproachingDeath approachingDeath = new ApproachingDeath();
    AwakenedAbyss awakenedAbyss = new AwakenedAbyss();
    BlissfulRestraintDot blissfulRestraintDot = new BlissfulRestraintDot();
    ChargeSpellAmplification chargeSpellAmplification = new ChargeSpellAmplification();
    ContactCaravan contactCaravan = new ContactCaravan();
    CrawlingFearBeforeDelay crawlingFearBeforeDelay = new CrawlingFearBeforeDelay();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DeviousNightmare deviousNightmare = new DeviousNightmare();
    DeviousOminousDream deviousOminousDream = new DeviousOminousDream();
    EndlessAgonyBeforeDelay endlessAgonyBeforeDelay = new EndlessAgonyBeforeDelay();
    EndlessHunger endlessHunger = new EndlessHunger();
    EndlesslyStarvingBeast endlesslyStarvingBeast = new EndlesslyStarvingBeast();
    EndlessNightmare endlessNightmare = new EndlessNightmare();
    EndlessOminousDream endlessOminousDream = new EndlessOminousDream();
    GrandisGoddessBlessingLef grandisGoddessBlessingLef = new GrandisGoddessBlessingLef(382L);
    GustChargeDrive gustChargeDrive = new GustChargeDrive();
    GustSpell gustSpell = new GustSpell();
    InfinitySpell infinitySpell = new InfinitySpell();
    LoadedDice loadedDice = new LoadedDice();
    MagicCircuitFullDrive magicCircuitFullDrive = new MagicCircuitFullDrive();
    MagicCircuitFullDriveBuff magicCircuitFullDriveBuff = new MagicCircuitFullDriveBuff();
    MemoryOfRootBeforeDelay memoryOfRootBeforeDelay = new MemoryOfRootBeforeDelay();
    Overdrive overdrive = new Overdrive(255L);
    PlainChargeDrive plainChargeDrive = new PlainChargeDrive();
    PlainSpell plainSpell = new PlainSpell();
    RestraintRing restraintRing = new RestraintRing();
    ReturningHatred returningHatred = new ReturningHatred();
    RingSwitching ringSwitching = new RingSwitching();
    ScarletChargeDriveFlame scarletChargeDriveFlame = new ScarletChargeDriveFlame();
    SoulContract soulContract = new SoulContract();
    SpecterForm specterForm = new SpecterForm();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    UncontrollableChaos uncontrollableChaos = new UncontrollableChaos();
    UnfadingScar unfadingScar = new UnfadingScar();
    UnstoppableImpulse unstoppableImpulse = new UnstoppableImpulse();
    UnstoppableInstinct unstoppableInstinct = new UnstoppableInstinct();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    WrathOfGod wrathOfGod = new WrathOfGod();

    public ArkDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(120.0);

        magicCircuitFullDriveBuff.setCooldown(120.0);
        grandisGoddessBlessingLef.setCooldown(120.0);

        magicCircuitFullDriveBuff.setDelay(120L);
        chargeSpellAmplification.setDelay(120L);
        infinitySpell.setDelay(120L);
        grandisGoddessBlessingLef.setDelay(60L);

        getSkillSequence1().add(wrathOfGod);                    // 30
        getSkillSequence1().add(magicCircuitFullDriveBuff);
        getSkillSequence1().add(chargeSpellAmplification);
        getSkillSequence1().add(infinitySpell);
        getSkillSequence1().add(grandisGoddessBlessingLef);
        getSkillSequence1().add(overdrive);                     // 420
        getSkillSequence1().add(soulContract);                  // 30
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        addSkillEvent(contactCaravan);
        while (getStart().before(getEnd())) {
            if (cooldownCheck(loadedDice)) {
                addSkillEvent(loadedDice);
            }
            if (
                    cooldownCheck(wrathOfGod)
                    && getStart().after(new Timestamp(overdrive.getActivateTime().getTime() - 1000))
            ) {
                getNukeTimeList().add(new Timestamp(getStart().getTime()));
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(blissfulRestraintDot);
                addSkillEvent(endlesslyStarvingBeast);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(crawlingFearBeforeDelay);
                addSkillEvent(endlessAgonyBeforeDelay);
                addSkillEvent(memoryOfRootBeforeDelay);
                addSkillEvent(returningHatred);
                if (cooldownCheck(ancientAbyssDot)) {
                    addSkillEvent(ancientAbyssDot);
                }
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(endlessAgonyBeforeDelay)
                    && !cooldownCheck(wrathOfGod)
            ) {
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                if (gauge > 300) {
                    addSkillEvent(crawlingFearBeforeDelay);
                }
                addSkillEvent(endlessAgonyBeforeDelay);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(100 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
                            && !isSpecter
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(returningHatred)
                            && hatredCnt > 0
            ) {
                addSkillEvent(returningHatred);
            } else if (isSpecter) {
                endlessOminousDream = new EndlessOminousDream();
                endlessOminousDream.setDelay(210L);
                endlessHunger = new EndlessHunger();
                endlessHunger.setDelay(690L);
                uncontrollableChaos = new UncontrollableChaos();
                uncontrollableChaos.setDelay(750L);
                Timestamp specterTime = new Timestamp(getStart().getTime() + 3000);
                while (getStart().before(specterTime)) {
                    addSkillEvent(endlessOminousDream);
                    if (cooldownCheck(uncontrollableChaos)) {
                        addSkillEvent(uncontrollableChaos);
                    } else if (cooldownCheck(unfadingScar)) {
                        addSkillEvent(unfadingScar);
                    } else if (cooldownCheck(endlessHunger)) {
                        addSkillEvent(endlessHunger);
                    } else {
                        addSkillEvent(unstoppableInstinct);
                    }
                }
                if (getStart().after(infinitySpellEndTime)) {
                    addSkillEvent(specterForm);
                    applyCooldown(lefGauge);
                }
            } else if (!isSpecter) {
                plainChargeDrive = new PlainChargeDrive();
                plainChargeDrive.setDelay(240L);
                abyssChargeDriveMagic = new AbyssChargeDriveMagic();
                abyssChargeDriveMagic.getRelatedSkill().setDelay(590L);
                unstoppableImpulse = new UnstoppableImpulse();
                unstoppableImpulse.setDelay(560L);
                Timestamp specterTime = new Timestamp(getStart().getTime() + 3000);
                while (getStart().before(specterTime)) {
                    addSkillEvent(plainChargeDrive);
                    if (
                            cooldownCheck(endlessNightmare)
                                    && cooldownCheck(deviousNightmare)
                    ) {
                        addSkillEvent(endlessNightmare);
                    } else if (cooldownCheck(abyssChargeDriveMagic)) {
                        addSkillEvent(abyssChargeDriveMagic);
                    } else if (cooldownCheck(gustChargeDrive)) {
                        addSkillEvent(gustChargeDrive);
                    } else if (cooldownCheck(unstoppableImpulse)) {
                        addSkillEvent(unstoppableImpulse);
                    } else if (cooldownCheck(scarletChargeDriveFlame)) {
                        addSkillEvent(scarletChargeDriveFlame);
                    } else if (cooldownCheck(endlessNightmare)) {
                        addSkillEvent(endlessNightmare);
                    }
                }
                if (
                        getStart().before(new Timestamp(infinitySpell.getActivateTime().getTime() - 18000))
                                && gauge > 500
                ) {
                    addSkillEvent(specterForm);
                    applyCooldown(specterGauge);
                }
            }
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
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t게이지 : " + gauge + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t게이지 : " + gauge + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (
                isSpecter
                && cooldownCheck(specterGauge)
                && getStart().after(memoryOfRootEndTime)
        ) {
            gauge -= 23;
            if (getStart().before(ancientAbyssEndTime)) {
                specterGauge.setActivateTime(new Timestamp(specterGauge.getActivateTime().getTime() + 2000));
            } else {
                specterGauge.setActivateTime(new Timestamp(specterGauge.getActivateTime().getTime() + 1000));
            }
            if (gauge < 0) {
                gauge = 0;
            }
        } else if (
                !isSpecter
                && cooldownCheck(lefGauge)
        ) {
            gauge += 14;
            lefGauge.setActivateTime(new Timestamp(lefGauge.getActivateTime().getTime() + 1000));
            if (gauge > 1000) {
                gauge = 1000;
            }
        }
        if (
                skill instanceof InfinitySpell
                || skill instanceof AncientAbyssDot
        ) {
            specterAura = 300;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof InfinitySpell) {
                infinitySpellEndTime = new Timestamp(getStart().getTime() + 53000);
            }
            if (skill instanceof MagicCircuitFullDriveBuff) {
                if (
                        getStart().after(new Timestamp(90 * 1000))
                        && getStart().before(new Timestamp(150 * 1000))
                ) {
                    return;
                }
                magicCircuitFullDriveEndTime = new Timestamp(getStart().getTime() + 63000);
            }
            if (skill instanceof SpecterForm) {
                if (isSpecter) {
                    isSpecter = false;
                    applyCooldown(lefGauge);
                } else {
                    isSpecter = true;
                    applyCooldown(specterGauge);
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
            if (skill instanceof AncientAbyssDot) {
                ancientAbyssEndTime = new Timestamp(getStart().getTime() + 30000);
            }
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
                applyCooldown(specterGauge);
                applyCooldown(lefGauge);
            }
            if (skill instanceof MemoryOfRootBeforeDelay) {
                memoryOfRootEndTime = new Timestamp(getStart().getTime() + 18000);
                specterGauge.setActivateTime(new Timestamp(memoryOfRootEndTime.getTime() + 1000));
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof AncientAbyssDot) {
                        i = 2000;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new ArkSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), isSpecter));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                skill instanceof EndlessAgony
                                && isSpecter
                        ) {
                            int cnt = 1;
                            if (getStart().before(infinitySpellEndTime)) {
                                cnt = 4;
                            }
                            for (int j = 0; j < cnt; j++) {
                                getSkillEventList().add(new ArkSkillEvent(approachingDeath, new Timestamp(getStart().getTime() + i + 500), new Timestamp(getStart().getTime() + i + 500), isSpecter));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + i + 500));
                                Long ran = (long) (Math.random() * 99 + 1);
                                if (ran <= 20 && hatredCnt < 12) {
                                    hatredCnt++;
                                }
                            }
                        }
                        if (
                                isSpecter
                                        && specterAura > 0
                                        && (
                                        skill instanceof BlissfulRestraintDot
                                                || skill instanceof EndlessAgony
                                                || skill instanceof MemoryOfRoot
                                                || skill instanceof MemoryOfRootFinish
                                )
                        ) {
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
                    int cnt = 1;
                    if (getStart().before(infinitySpellEndTime)) {
                        cnt = 4;
                    }
                    for (int j = 0; j < cnt; j++) {
                        getSkillEventList().add(new ArkSkillEvent(approachingDeath, new Timestamp(getStart().getTime() + 500), new Timestamp(getStart().getTime() + 500), isSpecter));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + 500));
                        Long ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 20 && hatredCnt < 12) {
                            hatredCnt++;
                        }
                    }
                }
                if (
                        isSpecter
                                && specterAura > 0
                                && (
                                skill instanceof UnfadingScar
                                        || skill instanceof UnstoppableInstinct
                                        || skill instanceof EndlessHunger
                                        || skill instanceof EndlessOminousDream
                                        || skill instanceof UncontrollableChaos
                                        || skill instanceof CrawlingFear
                                        || skill instanceof BlissfulRestraint
                                        || skill instanceof DeviousOminousDream
                        )
                ) {
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
                        if (bs.getStartTimeList().size() == 0) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        } else if (skillEvent.getStart().after(bs.getStartTimeList().get(bs.getStartTimeList().size() - 1))) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        }
                    }
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
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
                    totalDamage += getAttackDamage(new SkillEvent(plainSpell, start, end), buffSkill, start, end);
                    totalDamage += getAttackDamage(new SkillEvent(plainSpell, start, end), buffSkill, start, end);
                    totalDamage += getAttackDamage(new SkillEvent(plainSpell, start, end), buffSkill, start, end);
                    if (!(se.getSkill() instanceof PlainSpell)) {
                        totalDamage += getAttackDamage(new SkillEvent(plainSpell, start, end), buffSkill, start, end);
                    }
                }
                if (
                        isInfinitySpell
                        && se.getSkill() instanceof ApproachingDeath
                ) {
                    ((ApproachingDeath) se.getSkill()).setDamage(190.0 + 145 + 118 + 210);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isInfinitySpell
                        && (
                                se.getSkill() instanceof AbyssSpell
                                || se.getSkill() instanceof GustSpell
                                || se.getSkill() instanceof PlainSpell
                                || se.getSkill() instanceof ScarletSpell
                        )
                ) {
                    buffSkill.addBuffDamage(-20L);
                }
                if (
                        isInfinitySpell
                        && se.getSkill() instanceof ApproachingDeath
                ) {
                    se.setSkill(new ApproachingDeath());
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
        if (skill instanceof ReturningHatred) {
            for (int i = 0; i < hatredCnt - 1; i++) {
                returningHatred.getMultiAttackInfo().add(0L);
            }
        }
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    !(skill instanceof BlissfulRestraintFinish)
                    && !(skill instanceof ReturningHatred)
                    && isSpecter
            ) {
                int i = 1;
                if (getStart().before(infinitySpellEndTime)) {
                    i = 4;
                }
                for (int j = 0; j < i; j++) {
                    getSkillEventList().add(new ArkSkillEvent(approachingDeath, new Timestamp(getStart().getTime() + sum + 500), new Timestamp(getStart().getTime() + sum + 500), isSpecter));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + sum + 500));
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 20 && hatredCnt < 12) {
                        hatredCnt++;
                    }
                }
            }
            if (
                    isSpecter
                            && specterAura > 0
                            && (
                            skill instanceof BlissfulRestraintFinish
                                    || skill instanceof EndlessAgonyFinish
                                    || skill instanceof EndlesslyStarvingBeast
                                    || skill instanceof AncientAbyss
                                    || skill instanceof AncientAbyssDot
                    )
            ) {
                getSkillEventList().add(new ArkSkillEvent(awakenedAbyss, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), isSpecter));
                specterAura --;
            }
            getSkillEventList().add(new ArkSkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), isSpecter));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
        if (skill instanceof ReturningHatred) {
            returningHatred.getMultiAttackInfo().clear();
            returningHatred.getMultiAttackInfo().add(500L);
            hatredCnt = 0;
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
