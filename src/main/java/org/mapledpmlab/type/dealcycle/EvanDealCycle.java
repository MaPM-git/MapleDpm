package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.evan.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.evan.ComeBack;
import org.mapledpmlab.type.skill.buffskill.evan.ElementalBlastBuff;
import org.mapledpmlab.type.skill.buffskill.evan.SwiftComeBack;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EvanDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedDragonSpark());
            add(new BreakComeBack());
            add(new BreathComeBack());
            add(new BreathOfEarth());
            add(new BreathOfWind());
            add(new CircleOfEarth());
            add(new CircleOfMana1());
            add(new CircleOfMana2());
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
            add(new ZodiacRay());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new ElementalBlastDelay());
            add(new SpiralOfManaDelay());
            add(new SummonOnyxDragonDelay());
            add(new ZodiacBurstDelay());
            add(new ZodiacRayDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ComeBack());
            add(new ElementalBlastBuff());
            add(new HeroesOath());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SwiftComeBack());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Long debrisCnt = 0L;

    public EvanDealCycle(Job job) {
        super(job, new AdvancedDragonSpark());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        BreakComeBack breakComeBack = new BreakComeBack();
        BreathComeBack breathComeBack = new BreathComeBack();
        BreathOfEarth breathOfEarth = new BreathOfEarth();
        BreathOfWind breathOfWind = new BreathOfWind();
        CircleOfEarth circleOfEarth = new CircleOfEarth();
        CircleOfMana1 circleOfMana1 = new CircleOfMana1();
        CircleOfThunder circleOfThunder = new CircleOfThunder();
        CircleOfWind circleOfWind = new CircleOfWind();
        ComeBack comeBack = new ComeBack();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DarkFog darkFog = new DarkFog();
        DiveOfEarth diveOfEarth = new DiveOfEarth();
        DiveOfThunder diveOfThunder = new DiveOfThunder();
        DragonBreak dragonBreak = new DragonBreak();
        DragonBreath dragonBreath = new DragonBreath();
        DragonDive dragonDive = new DragonDive();
        DragonSwift dragonSwift = new DragonSwift();
        ElementalBlast elementalBlast = new ElementalBlast();
        HeroesOath heroesOath = new HeroesOath();
        ImperialBreath imperialBreath = new ImperialBreath();
        MagicDebris magicDebris = new MagicDebris();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiralOfMana spiralOfMana = new SpiralOfMana();
        SummonOnyxDragon summonOnyxDragon = new SummonOnyxDragon();
        SwiftComeBack swiftComeBack = new SwiftComeBack();
        SwiftOfThunder swiftOfThunder = new SwiftOfThunder();
        SwiftOfWind swiftOfWind = new SwiftOfWind();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        ZodiacBurst zodiacBurst = new ZodiacBurst();
        ZodiacRay zodiacRay = new ZodiacRay();
        ZodiacRayDelay zodiacRayDelay = new ZodiacRayDelay();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(heroesOath);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(summonOnyxDragon);
        dealCycle1.add(zodiacRayDelay);
        dealCycle1.add(dragonBreath);
        dealCycle1.add(circleOfWind);
        dealCycle1.add(breathOfWind);
        dealCycle1.add(breathComeBack);             // 12스택
        dealCycle1.add(dragonSwift);
        dealCycle1.add(circleOfWind);
        dealCycle1.add(swiftOfWind);                // 16스택
        dealCycle1.add(swiftComeBack);
        dealCycle1.add(dragonDive);
        dealCycle1.add(circleOfEarth);
        dealCycle1.add(diveOfEarth);                // 23스택
        dealCycle1.add(darkFog);                    // 26스택
        dealCycle1.add(zodiacRay);
        dealCycle1.add(comeBack);
        dealCycle1.add(dragonBreak);
        dealCycle1.add(elementalBlast);
        dealCycle1.add(imperialBreath);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(zodiacBurst);

        dealCycle2.add(heroesOath);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(summonOnyxDragon);
        dealCycle2.add(dragonBreath);
        dealCycle2.add(circleOfWind);
        dealCycle2.add(breathOfWind);
        dealCycle2.add(breathComeBack);             // 12스택
        dealCycle2.add(dragonSwift);
        dealCycle2.add(circleOfWind);
        dealCycle2.add(swiftOfWind);                // 16스택
        dealCycle2.add(swiftComeBack);
        dealCycle2.add(dragonDive);
        dealCycle2.add(circleOfEarth);
        dealCycle2.add(diveOfEarth);                // 23스택
        dealCycle2.add(darkFog);                    // 26스택
        dealCycle2.add(zodiacRay);
        dealCycle2.add(comeBack);
        dealCycle2.add(dragonBreak);
        dealCycle2.add(elementalBlast);
        dealCycle2.add(imperialBreath);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(circleOfMana1);
        dealCycle2.add(circleOfMana1);
        dealCycle2.add(circleOfMana1);
        dealCycle2.add(circleOfMana1);
        dealCycle2.add(circleOfMana1);
        dealCycle2.add(circleOfMana1);
        dealCycle2.add(breakComeBack);

        List<Skill> swiftOfThunderCycle = new ArrayList<>();
        List<Skill> diveOfEarthCycle = new ArrayList<>();
        List<Skill> breathOfEarthCycle = new ArrayList<>();

        swiftOfThunderCycle.add(dragonSwift);
        swiftOfThunderCycle.add(circleOfThunder);
        swiftOfThunderCycle.add(swiftOfThunder);
        swiftOfThunderCycle.add(circleOfMana1);
        swiftOfThunderCycle.add(swiftComeBack);

        diveOfEarthCycle.add(dragonDive);
        diveOfEarthCycle.add(circleOfEarth);
        diveOfEarthCycle.add(diveOfEarth);
        diveOfEarthCycle.add(circleOfMana1);
        diveOfEarthCycle.add(comeBack);

        breathOfEarthCycle.add(dragonBreath);
        breathOfEarthCycle.add(circleOfMana1);
        breathOfEarthCycle.add(circleOfMana1);
        breathOfEarthCycle.add(circleOfMana1);
        breathOfEarthCycle.add(circleOfMana1);
        breathOfEarthCycle.add(circleOfMana1);
        breathOfEarthCycle.add(circleOfEarth);
        breathOfEarthCycle.add(breathOfEarth);
        breathOfEarthCycle.add(breathComeBack);

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
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            }/* else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            }*/ else if (
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
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(elementalBlast);
                addSkillEvent(imperialBreath);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(breakComeBack);
            } else if (
                    cooldownCheck(dragonBreak)
                    && getStart().before(new Timestamp(elementalBlast.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(dragonBreak);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(circleOfMana1);
                addSkillEvent(breakComeBack);
            } else if (
                    cooldownCheck(spiralOfMana)
            ) {
                addSkillEvent(spiralOfMana);
            } else if (
                    cooldownCheck(dragonSwift)
                    && getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 6000))
            ) {
                addDealCycle(swiftOfThunderCycle);
            } else if (
                    cooldownCheck(dragonDive)
                    && getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 6000))
            ) {
                addDealCycle(diveOfEarthCycle);
            } else if (
                    cooldownCheck(dragonBreath)
                    && getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 6000))
            ) {
                addDealCycle(breathOfEarthCycle);
            } else {
                addSkillEvent(circleOfMana1);
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
                    } else if (skill instanceof ImperialBreath) {
                        i += 840;
                    } else if (skill instanceof SwiftOfThunder) {
                        i += 480;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                skill instanceof DiveOfEarth
                                && (attackCount >= 1 && attackCount <=3)
                        ) {
                            i += 420;
                        }
                        if (skill instanceof SwiftOfThunder) {
                            Skill sot = new SwiftOfThunder();
                            ((SwiftOfThunder) sot).addFinalDamage(Math.pow(0.4, attackCount));
                            getSkillEventList().add(new SkillEvent(sot, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        } else if (skill instanceof DiveOfEarth) {
                            Skill doe = new DiveOfEarth();
                            ((DiveOfEarth) doe).addFinalDamage(Math.pow(0.5, attackCount));
                            getSkillEventList().add(new SkillEvent(doe, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        } else {
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        }
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
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
                attackDamage = (long) Math.floor(((getJob().getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                        + getJob().getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
                        * (Math.floor((getJob().getMagic() + buffSkill.getBuffAttMagic())
                        * (1 + (getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
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
        return attackDamage;
    }
}
