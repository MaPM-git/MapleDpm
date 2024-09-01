package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.evan.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.evan.ComeBack;
import org.mapledpmlab.type.skill.buffskill.evan.ElementalBlastBuff;
import org.mapledpmlab.type.skill.buffskill.evan.SwiftComeBack;
import org.mapledpmlab.type.skill.buffskill.evan.ZodiacBurstBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EvanDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedDragonSpark());
            add(new BreakComeBack());
            add(new BreathComeBack());
            add(new BreathOfEarth());
            add(new BreathOfWind());
            add(new CircleOfEarth());
            add(new CircleOfMana1());
            add(new CircleOfMana2());
            add(new CircleOfMana2Cancel());
            add(new CircleOfThunder());
            add(new CircleOfWind());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DarkFog());
            add(new DiveOfEarth());
            add(new DiveOfThunder());
            add(new DragonBreak());
            add(new DragonBreath());
            add(new DragonDive());
            add(new DragonSwift());
            add(new ElementalBlast());
            add(new ImperialBreath());
            add(new MagicDebris());
            add(new SpiralOfMana());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SummonOnyxDragon());
            add(new SwiftOfThunder());
            add(new SwiftOfWind());
            add(new ZodiacBurst());
            add(new ZodiacBurstMeteor());
            add(new ZodiacRayDelay());
            add(new ZodiacRay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ComeBack());
            add(new ElementalBlastBuff());
            add(new HeroesOath());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SwiftComeBack());
            //add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new ZodiacBurstBuff());
        }
    };

    Long debrisCnt = 0L;

    Timestamp zodiacBurstEndTime = new Timestamp(-1);

    BreakComeBack breakComeBack = new BreakComeBack();
    BreathComeBack breathComeBack = new BreathComeBack();
    BreathOfEarth breathOfEarth = new BreathOfEarth();
    BreathOfWind breathOfWind = new BreathOfWind();
    CircleOfEarth circleOfEarth = new CircleOfEarth();
    CircleOfMana1 circleOfMana = new CircleOfMana1();
    CircleOfMana1 circleOfManaCancel = new CircleOfMana1();
    CircleOfThunder circleOfThunder = new CircleOfThunder();
    CircleOfWind circleOfWind = new CircleOfWind();
    ComeBack comeBack = new ComeBack();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DarkFog darkFog = new DarkFog();
    DiveOfEarth diveOfEarth = new DiveOfEarth();
    DragonBreak dragonBreak = new DragonBreak();
    DragonBreath dragonBreath = new DragonBreath();
    DragonDive dragonDive = new DragonDive();
    DragonSwift dragonSwift = new DragonSwift();
    ElementalBlast elementalBlast = new ElementalBlast();
    HeroesOath heroesOath = new HeroesOath();
    ImperialBreath imperialBreath = new ImperialBreath();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SpiralOfMana spiralOfMana = new SpiralOfMana();
    SummonOnyxDragon summonOnyxDragon = new SummonOnyxDragon();
    SwiftComeBack swiftComeBack = new SwiftComeBack();
    SwiftOfThunder swiftOfThunder = new SwiftOfThunder();
    SwiftOfWind swiftOfWind = new SwiftOfWind();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    ZodiacBurst zodiacBurst = new ZodiacBurst();
    ZodiacBurstMeteor zodiacBurstMeteor = new ZodiacBurstMeteor();
    ZodiacRay zodiacRay = new ZodiacRay();
    ZodiacRayDelay zodiacRayDelay = new ZodiacRayDelay();

    public EvanDealCycle(Job job) {
        super(job, new AdvancedDragonSpark());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(95.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);

        circleOfManaCancel.setRelatedSkill(new CircleOfMana2Cancel());

        List<Skill> swiftOfThunderCycle = new ArrayList<>();
        List<Skill> diveOfEarthCycle = new ArrayList<>();
        List<Skill> breathOfEarthCycle = new ArrayList<>();

        swiftOfThunderCycle.add(dragonSwift);
        swiftOfThunderCycle.add(circleOfThunder);
        swiftOfThunderCycle.add(swiftOfThunder);
        swiftOfThunderCycle.add(circleOfMana);
        swiftOfThunderCycle.add(circleOfMana);
        swiftOfThunderCycle.add(swiftComeBack);

        diveOfEarthCycle.add(dragonDive);
        diveOfEarthCycle.add(circleOfEarth);
        diveOfEarthCycle.add(diveOfEarth);
        diveOfEarthCycle.add(circleOfMana);
        diveOfEarthCycle.add(circleOfMana);
        diveOfEarthCycle.add(circleOfMana);
        diveOfEarthCycle.add(circleOfMana);
        diveOfEarthCycle.add(comeBack);

        breathOfEarthCycle.add(dragonBreath);
        breathOfEarthCycle.add(circleOfEarth);
        breathOfEarthCycle.add(breathOfEarth);
        breathOfEarthCycle.add(circleOfMana);
        breathOfEarthCycle.add(circleOfMana);
        breathOfEarthCycle.add(breathComeBack);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(heroesOath)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(summonOnyxDragon)
                            && cooldownCheck(zodiacRayDelay)
                            && cooldownCheck(dragonBreath)
                            && cooldownCheck(dragonSwift)
                            && cooldownCheck(dragonDive)
                            && cooldownCheck(dragonBreak)
                            && cooldownCheck(elementalBlast)
                            && cooldownCheck(imperialBreath)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(restraintRing)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                //getStart().setTime(getStart().getTime() + 210);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(heroesOath);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else if (cooldownCheck(spiralOfMana)) {
                    addSkillEvent(spiralOfMana);
                } else {
                    addSkillEvent(circleOfMana);
                }
                addSkillEvent(summonOnyxDragon);
                addSkillEvent(zodiacRayDelay);
                addSkillEvent(circleOfManaCancel);
                addSkillEvent(dragonBreath);
                addSkillEvent(circleOfWind);
                addSkillEvent(breathOfWind);
                addSkillEvent(breathComeBack);
                addSkillEvent(circleOfManaCancel);
                addSkillEvent(dragonSwift);
                addSkillEvent(circleOfWind);
                addSkillEvent(swiftOfWind);
                addSkillEvent(swiftComeBack);
                addSkillEvent(circleOfManaCancel);
                addSkillEvent(dragonDive);
                addSkillEvent(circleOfEarth);
                addSkillEvent(diveOfEarth);
                addSkillEvent(darkFog);
                addSkillEvent(comeBack);
                addSkillEvent(dragonBreak);
                addSkillEvent(elementalBlast);
                addSkillEvent(imperialBreath);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(zodiacRay);
                if (cooldownCheck(spiralOfMana)) {
                    addSkillEvent(spiralOfMana);
                }
                if (cooldownCheck(zodiacBurst)) {
                    addSkillEvent(zodiacBurst);
                    if (cooldownCheck(spiralOfMana)) {
                        addSkillEvent(spiralOfMana);
                        addSkillEvent(spiralOfMana);
                        addSkillEvent(breakComeBack);
                    } else {
                        addSkillEvent(circleOfMana);
                        addSkillEvent(circleOfMana);
                        addSkillEvent(circleOfMana);
                        addSkillEvent(breakComeBack);
                    }
                } else {
                    int delay = 4650;
                    for (int i = 0; i < 8; i++) {
                        if (cooldownCheck(spiralOfMana)) {
                            addSkillEvent(spiralOfMana);
                            addSkillEvent(circleOfMana);
                        } else {
                            addSkillEvent(circleOfMana);
                        }
                    }
                    addSkillEvent(breakComeBack);
                }
            } else if (cooldownCheck(spiralOfMana)) {
                addSkillEvent(spiralOfMana);
            } else if (
                    cooldownCheck(summonOnyxDragon)
                            && !cooldownCheck(heroesOath)
            ) {
                addSkillEvent(summonOnyxDragon);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(heroesOath.getActivateTime().getTime() + 10000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(dragonBreak)
                            && cooldownCheck(elementalBlast)
                            && getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(dragonBreak);
                boolean som = false;
                for (int i = 0; i < 3; i++) {
                    if (cooldownCheck(spiralOfMana)) {
                        addSkillEvent(spiralOfMana);
                        som = true;
                    } else {
                        addSkillEvent(circleOfMana);
                    }
                }
                if (som) {
                    addSkillEvent(circleOfMana);
                }
                addSkillEvent(elementalBlast);
                addSkillEvent(imperialBreath);
                for (int i = 0; i < 8; i++) {
                    if (cooldownCheck(spiralOfMana)) {
                        addSkillEvent(spiralOfMana);
                        addSkillEvent(circleOfMana);
                    } else {
                        addSkillEvent(circleOfMana);
                    }
                }
                addSkillEvent(breakComeBack);
            } else if (
                    cooldownCheck(dragonBreak)
                            && getStart().before(new Timestamp(elementalBlast.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(dragonBreak);
                boolean som = false;
                for (int i = 0; i < 3; i++) {
                    if (cooldownCheck(spiralOfMana)) {
                        addSkillEvent(spiralOfMana);
                        som = true;
                    } else {
                        addSkillEvent(circleOfMana);
                    }
                }
                if (som) {
                    addSkillEvent(circleOfMana);
                }
                addSkillEvent(breakComeBack);
            } else if (
                    cooldownCheck(dragonSwift)
                            && getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 6000))
            ) {
                addSkillEvent(dragonSwift);
                addSkillEvent(circleOfThunder);
                addSkillEvent(swiftOfThunder);
                if (cooldownCheck(spiralOfMana)) {
                    addSkillEvent(spiralOfMana);
                    addSkillEvent(circleOfMana);
                } else {
                    addSkillEvent(circleOfMana);
                }
                if (!cooldownCheck(dragonSwift)) {
                    addSkillEvent(circleOfMana);
                }
                addSkillEvent(circleOfManaCancel);
                addSkillEvent(swiftComeBack);
            } else if (
                    cooldownCheck(dragonDive)
                            && getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 6000))
            ) {
                addSkillEvent(dragonDive);
                addSkillEvent(circleOfEarth);
                addSkillEvent(diveOfEarth);
                addSkillEvent(circleOfMana);
                addSkillEvent(circleOfManaCancel);
                addSkillEvent(comeBack);
            } else if (
                    cooldownCheck(dragonBreath)
                            && getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 6000))
            ) {
                addSkillEvent(dragonBreath);
                addSkillEvent(circleOfWind);
                addSkillEvent(breathOfWind);
                for (int i = 0; i < 3; i++) {
                    if (cooldownCheck(spiralOfMana)) {
                        addSkillEvent(spiralOfMana);
                        addSkillEvent(circleOfMana);
                    } else if (
                            cooldownCheck(dragonSwift)
                                    || cooldownCheck(dragonDive)
                                    || cooldownCheck(dragonBreak)
                    ) {
                        break;
                    } else {
                        addSkillEvent(circleOfMana);
                    }
                }
                addSkillEvent(circleOfManaCancel);
                addSkillEvent(breathComeBack);
            } else {
                addSkillEvent(circleOfMana);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;
        if (
                skill instanceof BreakComeBack
                || skill instanceof BreathComeBack
                || skill instanceof ComeBack
                || skill instanceof SwiftComeBack
        ) {
            List<SkillEvent> remove = new ArrayList<>();
            for (SkillEvent skillEvent : this.getSkillEventList()) {
                if (
                        skillEvent.getStart().after(getStart())
                        && (
                                skillEvent.getSkill() instanceof BreathOfEarth
                                || skillEvent.getSkill() instanceof BreathOfWind
                                || skillEvent.getSkill() instanceof DiveOfEarth
                                || skillEvent.getSkill() instanceof DiveOfThunder
                                || skillEvent.getSkill() instanceof SwiftOfThunder
                                || skillEvent.getSkill() instanceof SwiftOfWind
                        )
                ) {
                    remove.add(skillEvent);
                    debrisCnt --;
                }
            }
            this.getSkillEventList().removeAll(remove);
        } else if (
                skill instanceof BreathOfEarth
                || skill instanceof BreathOfWind
        ) {
            List<SkillEvent> remove = new ArrayList<>();
            for (SkillEvent skillEvent : this.getSkillEventList()) {
                if (
                        skillEvent.getStart().after(getStart())
                        && skillEvent.getSkill() instanceof DragonBreath
                ) {
                    remove.add(skillEvent);
                }
            }
            this.getSkillEventList().removeAll(remove);
        } else if (
                skill instanceof DiveOfEarth
                || skill instanceof DiveOfThunder
        ) {
            List<SkillEvent> remove = new ArrayList<>();
            for (SkillEvent skillEvent : this.getSkillEventList()) {
                if (
                        skillEvent.getStart().after(getStart())
                        && skillEvent.getSkill() instanceof DragonDive
                ) {
                    remove.add(skillEvent);
                }
            }
            this.getSkillEventList().removeAll(remove);
        } else if (skill instanceof ImperialBreath) {
            List<SkillEvent> remove = new ArrayList<>();
            for (SkillEvent skillEvent : this.getSkillEventList()) {
                if (
                        skillEvent.getStart().after(getStart())
                        && skillEvent.getSkill() instanceof DragonBreak
                ) {
                    remove.add(skillEvent);
                }
            }
            this.getSkillEventList().removeAll(remove);
        } else if (
                skill instanceof SwiftOfThunder
                || skill instanceof SwiftOfWind
        ) {
            List<SkillEvent> remove = new ArrayList<>();
            for (SkillEvent skillEvent : this.getSkillEventList()) {
                if (
                        skillEvent.getStart().after(getStart())
                        && skillEvent.getSkill() instanceof DragonSwift
                ) {
                    remove.add(skillEvent);
                }
            }
            this.getSkillEventList().removeAll(remove);
        }
        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof ZodiacBurstBuff) {
                zodiacBurstEndTime = new Timestamp(getStart().getTime() + 45000);
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
            if (
                    getStart().before(zodiacBurstEndTime)
                    && !(skill instanceof ZodiacBurstMeteor)
                    && cooldownCheck(zodiacBurstMeteor)
            ) {
                addSkillEvent(zodiacBurstMeteor);
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                if (
                        skill instanceof BreathOfEarth
                        || skill instanceof BreathOfWind
                        || skill instanceof DiveOfEarth
                        || skill instanceof DiveOfThunder
                        || skill instanceof ImperialBreath
                        || skill instanceof SwiftOfThunder
                        || skill instanceof SwiftOfWind
                ) {
                    debrisCnt += ((AttackSkill) skill).getLimitAttackCount();
                    MagicDebris magicDebris = new MagicDebris();
                    if (debrisCnt >= 15) {
                        magicDebris.setByCnt(15L);
                        addSkillEvent(magicDebris);
                        debrisCnt -= 15;
                    } else if (debrisCnt >= 10) {
                        magicDebris.setByCnt(debrisCnt);
                        addSkillEvent(magicDebris);
                        debrisCnt -= 10;
                    }
                }
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
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = 0;
                    if (skill instanceof BreathOfEarth) {
                        i += 300;
                    } else if (skill instanceof DragonDive) {
                        i += 60;
                    } else if (skill instanceof DiveOfEarth) {
                        Skill doe = new DiveOfEarth();
                        getSkillEventList().add(new SkillEvent(doe, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        i += 900;
                    } else if (skill instanceof ImperialBreath) {
                        i += 840;
                    } else if (skill instanceof SwiftOfThunder) {
                        i += 480;
                    } else if (skill instanceof BreathOfWind) {
                        i += 390;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (skill instanceof SwiftOfThunder) {
                            Skill sot = new SwiftOfThunder();
                            ((SwiftOfThunder) sot).addFinalDamage(Math.pow(0.4, attackCount));
                            getSkillEventList().add(new SkillEvent(sot, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        } else if (skill instanceof DiveOfEarth) {
                            Skill doe = new DiveOfEarth();
                            ((DiveOfEarth) doe).addFinalDamage(Math.pow(0.5, attackCount + 1));
                            getSkillEventList().add(new SkillEvent(doe, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        } else {
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        }
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                if (skill instanceof CircleOfMana1) {
                    List<SkillEvent> skillEventList = getOverlappingSkillEvents(getStart(), new Timestamp(getStart().getTime() + 1000));
                    for (int i = 0; i < skillEventList.size(); i++) {
                        if (skillEventList.get(i).getSkill() instanceof SpiralOfMana) {
                            SpiralOfMana spiralOfMana = new SpiralOfMana();
                            spiralOfMana.setAttackCount(3L);
                            skillEventList.get(i).setSkill(spiralOfMana);
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
                    attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat()) * 0.01
                            * (Math.floor((getJob().getMagic() + buffSkill.getBuffAttMagic())
                            * (1 + (getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
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
}
