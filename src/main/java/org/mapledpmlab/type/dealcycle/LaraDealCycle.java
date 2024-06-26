package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.lara.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.lara.ArmfulTree;
import org.mapledpmlab.type.skill.buffskill.lara.DragonVeinEcho;
import org.mapledpmlab.type.skill.buffskill.common.GrandisGoddessBlessingAnima;
import org.mapledpmlab.type.skill.buffskill.lara.ManifestationSunlightFilledGround;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LaraDealCycle extends DealCycle {

    // 6차, 리레
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private final List<Skill> dealCycle3 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            //add(new AbsorptionFierceWind());
            //add(new AbsorptionRiverPuddleDouse());
            //add(new AbsorptionSunlitightGrain());
            add(new BigStretch());
            add(new BloomingFlowerWorld());
            add(new BloomingFlowerWorldFinish());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DragonVeinAbsorption());
            add(new DragonVeinTrace());
            add(new EruptionRipplingRiver());
            add(new EruptionRipplingRiverBig());
            add(new EruptionSunriseWell());
            add(new EruptionSunriseWellDot());
            add(new EruptionSunriseWellLava());
            add(new EruptionSunriseWellVolcanicCoal());
            add(new EruptionWhirlwind());
            add(new EssenceSprinkle());
            add(new FreeDragonVein());
            add(new MountainKid());
            add(new MountainSeed());
            add(new RidgeWinding());
            add(new SoaringSpirit());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SunRiverMountainWindBomb());
            add(new SunRiverMountainWindWave1());
            add(new SunRiverMountainWindWave2());
            add(new SunRiverMountainWindWave3());
            add(new SunRiverMountainWindWave4());
            //add(new VineSkein());
            //add(new Wakeup());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ArmfulTree());
            add(new DragonVeinEcho());
            add(new GrandisGoddessBlessingAnima());
            add(new PriorPreparation());
            add(new ManifestationSunlightFilledGround());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            //add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    MountainKid mountainKid = new MountainKid();
    MountainSeed mountainSeed = new MountainSeed();

    Timestamp mountainSeedEndTime1 = new Timestamp(-1);
    Timestamp mountainSeedEndTime2 = new Timestamp(-1);
    Timestamp mountainSeedEndTime3 = new Timestamp(-1);
    Timestamp mountainSeedEndTime4 = new Timestamp(-1);

    public LaraDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        ArmfulTree armfulTree = new ArmfulTree();
        BigStretch bigStretch = new BigStretch();
        BloomingFlowerWorld bloomingFlowerWorld = new BloomingFlowerWorld();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DragonVeinAbsorption dragonVeinAbsorption = new DragonVeinAbsorption();
        DragonVeinEcho dragonVeinEcho = new DragonVeinEcho();
        DragonVeinTrace dragonVeinTrace = new DragonVeinTrace();
        EruptionRipplingRiver eruptionRipplingRiver = new EruptionRipplingRiver();
        EruptionSunriseWell eruptionSunriseWell = new EruptionSunriseWell();
        EruptionWhirlwind eruptionWhirlwind = new EruptionWhirlwind();
        EssenceSprinkle essenceSprinkle = new EssenceSprinkle();
        FreeDragonVein freeDragonVein = new FreeDragonVein();
        GrandisGoddessBlessingAnima grandisGoddessBlessingAnima = new GrandisGoddessBlessingAnima();
        ManifestationSunlightFilledGround manifestationSunlightFilledGround = new ManifestationSunlightFilledGround();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RidgeWinding ridgeWinding = new RidgeWinding();
        RingSwitching ringSwitching = new RingSwitching();
        SoaringSpirit soaringSpirit = new SoaringSpirit();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SunRiverMountainWindWave1 sunRiverMountainWindWave1 = new SunRiverMountainWindWave1();
        ThiefCunning thiefCunning = new ThiefCunning();
        VineSkein vineSkein = new VineSkein();
        Wakeup wakeup = new Wakeup();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(grandisGoddessBlessingAnima);
        dealCycle1.add(armfulTree);
        dealCycle1.add(eruptionWhirlwind);
        dealCycle1.add(eruptionRipplingRiver);
        dealCycle1.add(eruptionSunriseWell);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(ridgeWinding);
        dealCycle1.add(soaringSpirit);
        dealCycle1.add(bigStretch);
        dealCycle1.add(sunRiverMountainWindWave1);
        dealCycle1.add(bloomingFlowerWorld);

        dealCycle2.add(grandisGoddessBlessingAnima);
        dealCycle2.add(armfulTree);
        dealCycle2.add(eruptionWhirlwind);
        dealCycle2.add(eruptionRipplingRiver);
        dealCycle2.add(eruptionSunriseWell);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(ridgeWinding);
        dealCycle2.add(soaringSpirit);
        dealCycle2.add(bigStretch);
        dealCycle2.add(sunRiverMountainWindWave1);

        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);

        addSkillEvent(dragonVeinEcho);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(manifestationSunlightFilledGround)
            ) {
                addSkillEvent(manifestationSunlightFilledGround);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } /*else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            }*/ else if (
                    cooldownCheck(soulContract)
                    && !cooldownCheck(armfulTree)
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(bigStretch)
                    && !cooldownCheck(armfulTree)
            ) {
                addSkillEvent(bigStretch);
            } else if (
                    cooldownCheck(ridgeWinding)
                    && !cooldownCheck(armfulTree)
            ) {
                addSkillEvent(ridgeWinding);
            } else if (
                    cooldownCheck(soaringSpirit)
                    && !cooldownCheck(armfulTree)
            ) {
                addSkillEvent(soaringSpirit);
            } else if (
                    cooldownCheck(eruptionWhirlwind)
                    && !cooldownCheck(armfulTree)
            ) {
                if (cooldownCheck(dragonVeinTrace)) {
                    addSkillEvent(dragonVeinTrace);
                    getStart().setTime(getStart().getTime() + 910);
                } else {
                    getStart().setTime(getStart().getTime() + 1000);
                }
                addSkillEvent(eruptionWhirlwind);
            } else if (
                    cooldownCheck(eruptionRipplingRiver)
                    && !cooldownCheck(armfulTree)
            ) {
                if (cooldownCheck(dragonVeinTrace)) {
                    addSkillEvent(dragonVeinTrace);
                    getStart().setTime(getStart().getTime() + 910);
                } else {
                    getStart().setTime(getStart().getTime() + 1000);
                }
                addSkillEvent(eruptionRipplingRiver);
            } else if (
                    cooldownCheck(eruptionSunriseWell)
                    && !cooldownCheck(armfulTree)
            ) {
                if (cooldownCheck(dragonVeinTrace)) {
                    addSkillEvent(dragonVeinTrace);
                    getStart().setTime(getStart().getTime() + 910);
                } else {
                    getStart().setTime(getStart().getTime() + 1000);
                }
                addSkillEvent(eruptionSunriseWell);
            } else {
                addSkillEvent(essenceSprinkle);
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
                    skill instanceof EruptionRipplingRiver
                    || skill instanceof EruptionSunriseWell
                    || skill instanceof EruptionWhirlwind
            ) {
                if (getStart().after(mountainSeedEndTime1)) {
                    mountainSeedEndTime1 = new Timestamp(getStart().getTime() + 20000);
                    addSkillEvent(mountainSeed);
                } else if (getStart().after(mountainSeedEndTime2)) {
                    mountainSeedEndTime2 = new Timestamp(getStart().getTime() + 20000);
                    addSkillEvent(mountainSeed);
                } else if (getStart().after(mountainSeedEndTime3)) {
                    mountainSeedEndTime3 = new Timestamp(getStart().getTime() + 20000);
                    addSkillEvent(mountainSeed);
                } else if (getStart().after(mountainSeedEndTime4)) {
                    mountainSeedEndTime4 = new Timestamp(getStart().getTime() + 20000);
                    addSkillEvent(mountainSeed);
                }
            }
            if (skill instanceof EssenceSprinkle) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 70) {
                    addSkillEvent(mountainKid);
                }
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (skillEvent.getSkill() instanceof MountainSeed) {
                        continue;
                    }
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
                    if (skill instanceof EruptionSunriseWellVolcanicCoal) {
                        i = 1500 - 360;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        if (skill instanceof EruptionSunriseWellVolcanicCoal) {
                            EruptionSunriseWellVolcanicCoal coal = new EruptionSunriseWellVolcanicCoal();
                            coal.addFinalDamage(0.9);
                            for (int j = 0; j < 4; j ++) {
                                getSkillEventList().add(new SkillEvent(coal, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                            }
                        }
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
            boolean isGrandisBless = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof GrandisGoddessBlessingAnima) {
                    isGrandisBless = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof DragonVeinEcho && isGrandisBless) {
                    skillEvent.setSkill(new DragonVeinEcho());
                    ((DragonVeinEcho) skillEvent.getSkill()).setBuffFinalDamage(1.11);
                }
                if (skillEvent.getSkill() instanceof DragonVeinEcho && !isGrandisBless) {
                    skillEvent.setSkill(new DragonVeinEcho());
                    ((DragonVeinEcho) skillEvent.getSkill()).setBuffFinalDamage(1.05);
                }
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
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        if (
                attackSkill instanceof AbsorptionFierceWind
                || attackSkill instanceof AbsorptionRiverPuddleDouse
                || attackSkill instanceof AbsorptionSunlitightGrain
                || attackSkill instanceof BigStretch
                || attackSkill instanceof BloomingFlowerWorld
                || attackSkill instanceof BloomingFlowerWorldFinish
                || attackSkill instanceof DragonVeinTrace
                || attackSkill instanceof EruptionRipplingRiver
                || attackSkill instanceof EruptionRipplingRiverBig
                || attackSkill instanceof EruptionSunriseWell
                || attackSkill instanceof EruptionSunriseWellDot
                || attackSkill instanceof EruptionSunriseWellLava
                || attackSkill instanceof EruptionSunriseWellVolcanicCoal
                || attackSkill instanceof EruptionWhirlwind
                || attackSkill instanceof EssenceSprinkle
                || attackSkill instanceof MountainSeed
                || attackSkill instanceof RidgeWinding
                || attackSkill instanceof SoaringSpirit
                || attackSkill instanceof SunRiverMountainWindBomb
                || attackSkill instanceof SunRiverMountainWindWave1
                || attackSkill instanceof SunRiverMountainWindWave2
                || attackSkill instanceof SunRiverMountainWindWave3
                || attackSkill instanceof SunRiverMountainWindWave4
                || attackSkill instanceof VineSkein
                || attackSkill instanceof Wakeup
        ) {
            buffSkill.addBuffFinalDamage(1.08);
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat()) * 4
                        + this.getJob().getFinalSubstat()) * 0.01
                        * (Math.floor((this.getJob().getMagic() + buffSkill.getBuffAttMagic())
                        * (1 + (this.getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
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
        if (
                attackSkill instanceof AbsorptionFierceWind
                        || attackSkill instanceof AbsorptionRiverPuddleDouse
                        || attackSkill instanceof AbsorptionSunlitightGrain
                        || attackSkill instanceof BigStretch
                        || attackSkill instanceof BloomingFlowerWorld
                        || attackSkill instanceof BloomingFlowerWorldFinish
                        || attackSkill instanceof DragonVeinTrace
                        || attackSkill instanceof EruptionRipplingRiver
                        || attackSkill instanceof EruptionRipplingRiverBig
                        || attackSkill instanceof EruptionSunriseWell
                        || attackSkill instanceof EruptionSunriseWellDot
                        || attackSkill instanceof EruptionSunriseWellLava
                        || attackSkill instanceof EruptionSunriseWellVolcanicCoal
                        || attackSkill instanceof EruptionWhirlwind
                        || attackSkill instanceof EssenceSprinkle
                        || attackSkill instanceof MountainSeed
                        || attackSkill instanceof RidgeWinding
                        || attackSkill instanceof SoaringSpirit
                        || attackSkill instanceof SunRiverMountainWindBomb
                        || attackSkill instanceof SunRiverMountainWindWave1
                        || attackSkill instanceof SunRiverMountainWindWave2
                        || attackSkill instanceof SunRiverMountainWindWave3
                        || attackSkill instanceof SunRiverMountainWindWave4
                        || attackSkill instanceof VineSkein
                        || attackSkill instanceof Wakeup
        ) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.08);
        }
        return attackDamage;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (skill instanceof BigStretch && sum != 1980) {
                BigStretch bigStretch = new BigStretch();
                bigStretch.addFinalDamage(0.7);
                getSkillEventList().add(new SkillEvent(bigStretch, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
                getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            } else {
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
                getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            }
        }
    }
}
