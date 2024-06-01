package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.job.ZeroBeta;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.zero.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.zero.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ZeroDealCycle extends DealCycle {

    private final Job job2 = new ZeroBeta();

    private final List<Skill> dealCycle1 = new ArrayList<>();
    private final List<Skill> dealCycle2 = new ArrayList<>();
    private final List<Skill> dealCycle3 = new ArrayList<>();
    private final List<Skill> dealCycle4 = new ArrayList<>();
    private final List<Skill> dealCycle5 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new ChronoTrigger1());
            add(new ChronoTrigger2());
            add(new ChronoTrigger3());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DivineLeer());
            add(new EarthBreak());
            add(new EarthBreakElectricity());
            add(new EarthBreakShockWave());
            add(new EgoWeaponAlpha());
            add(new EgoWeaponBeta());
            add(new ExtraAttack());
            add(new FlashAssault());
            add(new FrontSlash());
            add(new GigaCrash());
            add(new JointAttack1());
            add(new JointAttack2());
            add(new JointAttack3());
            add(new JointAttackFinish());
            add(new JumpingCrash());
            add(new JumpingCrashShockWave());
            add(new LightSphere());
            add(new LightSphereDot());
            add(new LimitBreak());
            add(new LimitBreakFinish());
            add(new MoonStrike());
            add(new PierceThrust());
            add(new PowerStomp());
            add(new PowerStompShockWave());
            add(new RollingAssaulter());
            add(new RollingAssaulterBlade());
            add(new RollingCurve());
            add(new RollingCurveBlade());
            add(new ShadowFlashAlpha());
            add(new ShadowFlashAlphaFinish());
            add(new ShadowFlashBeta());
            add(new ShadowFlashBetaFinish());
            add(new ShadowRainAlpha());
            add(new ShadowRainBeta());
            add(new ShadowStrike());
            add(new ShadowStrikeBlade());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SpinCutter());
            add(new SpinCutterBlade());
            add(new StormBreak());
            add(new StormBreakElectricity());
            add(new StormBreakTornado());
            add(new ThrowingWeapon());
            add(new TimeAfterImage());
            add(new TimeAfterImageZero());
            add(new TimePieceCrystalOfTime());
            add(new TurningDrive());
            add(new UpperSlash());
            add(new WhirlWind());
            add(new WindCutter());
            add(new WindCutterTornado());
            add(new WindStrike());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new CriticalBind());
            add(new LimitBreakBuff());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new TimeDistotion());
            add(new TimeHolding());
            add(new TimePiece());
            add(new TranscendentLife());
            add(new TranscendentLight());
            add(new TranscendentRhinneBless());
            add(new TranscendentTime());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    ChronoTrigger1 chronoTrigger1 = new ChronoTrigger1();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    EarthBreak earthBreak = new EarthBreak();
    EarthBreakElectricity earthBreakElectricity = new EarthBreakElectricity();
    EarthBreakShockWave earthBreakShockWave = new EarthBreakShockWave();
    FlashAssault flashAssault = new FlashAssault();
    FrontSlash frontSlash = new FrontSlash();
    GigaCrash gigaCrash = new GigaCrash();
    JointAttack1 jointAttack1 = new JointAttack1();
    JumpingCrash jumpingCrash = new JumpingCrash();
    JumpingCrashShockWave jumpingCrashShockWave = new JumpingCrashShockWave();
    LimitBreak limitBreak = new LimitBreak();
    LimitBreakFinish limitBreakFinish = new LimitBreakFinish();
    MoonStrike moonStrike = new MoonStrike();
    PierceThrust pierceThrust = new PierceThrust();
    PowerStomp powerStomp = new PowerStomp();
    PriorPreparation priorPreparation = new PriorPreparation();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    RollingAssaulter rollingAssaulter = new RollingAssaulter();
    RollingAssaulterBlade rollingAssaulterBlade = new RollingAssaulterBlade();
    RollingCurve rollingCurve = new RollingCurve();
    RollingCurveBlade rollingCurveBlade = new RollingCurveBlade();
    ShadowFlashAlpha shadowFlashAlpha = new ShadowFlashAlpha();
    ShadowFlashAlphaFinish shadowFlashAlphaFinish = new ShadowFlashAlphaFinish();
    ShadowFlashBeta shadowFlashBeta = new ShadowFlashBeta();
    ShadowFlashBetaFinish shadowFlashBetaFinish = new ShadowFlashBetaFinish();
    ShadowRainBeta shadowRainBeta = new ShadowRainBeta();
    ShadowStrike shadowStrike = new ShadowStrike();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SpinCutter spinCutter = new SpinCutter();
    StormBreak stormBreak = new StormBreak();
    StormBreakElectricity stormBreakElectricity = new StormBreakElectricity();
    StormBreakTornado stormBreakTornado = new StormBreakTornado();
    Tag tag = new Tag();
    ThiefCunning thiefCunning = new ThiefCunning();
    ThrowingWeapon throwingWeapon = new ThrowingWeapon();
    TimeDistotion timeDistotion = new TimeDistotion();
    TimeHolding timeHolding = new TimeHolding();
    TranscendentLife transcendentLife = new TranscendentLife();
    TranscendentRhinneBless transcendentRhinneBless = new TranscendentRhinneBless();
    TurningDrive turningDrive = new TurningDrive();
    UpperSlash upperSlash = new UpperSlash();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    WhirlWind whirlWind = new WhirlWind();
    WindCutter windCutter = new WindCutter();
    WindCutterTornado windCutterTornado = new WindCutterTornado();
    WindStrike windStrike = new WindStrike();
    Alpha alpha = new Alpha();
    Beta beta = new Beta();
    CriticalBind criticalBind = new CriticalBind();
    DivineLeer divineLeer = new DivineLeer();
    EgoWeaponAlpha egoWeaponAlpha = new EgoWeaponAlpha();
    EgoWeaponBeta egoWeaponBeta = new EgoWeaponBeta();
    ExtraAttack extraAttack = new ExtraAttack();
    LightSphere lightSphere = new LightSphere();
    TimeAfterImage timeAfterImage = new TimeAfterImage();
    TimeAfterImageZero timeAfterImageZero = new TimeAfterImageZero();
    TimePiece timePiece = new TimePiece();
    TimePieceCrystalOfTime timePieceCrystalOfTime = new TimePieceCrystalOfTime();
    SpinCutterBlade spinCutterBlade = new SpinCutterBlade();

    Timestamp devineLeerEndTime = new Timestamp(-1);
    Timestamp transcendentLightEndTime = new Timestamp(-1);
    Timestamp transcendentTimeEndTime = new Timestamp(-1);
    Timestamp blessEndTime = new Timestamp(-1);
    Timestamp shadowFlashAlphaEndTime = new Timestamp(-1);
    Timestamp shadowFlashBetaEndTime = new Timestamp(-1);

    int zero = 1;   // 0 - 알파, 1 - 베타
    int lightSphereCnt = 0;
    int timePieceCnt = 0;

    public ZeroDealCycle(Job job) {
        super(job, null);

        job2.addTotal(job2.getJobType());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        dealCycle1.add(shadowFlashBeta);
        dealCycle1.add(shadowFlashAlpha);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(timeDistotion);
        dealCycle1.add(shadowRainBeta);
        dealCycle1.add(soulContract);
        dealCycle1.add(transcendentLife);
        dealCycle1.add(limitBreak);
        dealCycle1.add(jointAttack1);
        dealCycle1.add(chronoTrigger1);

        dealCycle2.add(shadowFlashBeta);
        dealCycle2.add(shadowFlashAlpha);
        dealCycle2.add(soulContract);
        dealCycle2.add(transcendentLife);
        dealCycle2.add(limitBreak);
        dealCycle2.add(jointAttack1);

        dealCycle3.add(shadowFlashBeta);
        dealCycle3.add(shadowFlashAlpha);
        dealCycle3.add(soulContract);
        dealCycle3.add(transcendentLife);
        dealCycle3.add(limitBreak);
        dealCycle3.add(jointAttack1);

        while (getStart().before(getEnd())) {
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(7 * 60 * 1000))
                    && zero == 1
            ) {
                betaCancelCycle(shadowFlashBeta);
                alphaCancelCycle(shadowFlashAlpha);
                addSkillEvent(timeDistotion);
                addSkillEvent(spiderInMirror);
                addSkillEvent(crestOfTheSolar);
                betaCancelCycle(shadowRainBeta);
                alphaCancelCycle(transcendentLife);
                addSkillEvent(soulContract);
                addSkillEvent(transcendentRhinneBless);
                addSkillEvent(limitBreak);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else {
                    addSkillEvent(weaponJumpRing);
                }
                jointAttackCancelCycle(chronoTrigger1);
                shadowFlashBetaFinish = new ShadowFlashBetaFinish();
                addSkillEvent(shadowFlashBetaFinish);
                addSkillEvent(limitBreakFinish);
                addSkillEvent(tag);
                alphaCancelCycle(shadowFlashAlphaFinish);
                addSkillEvent(soulContract);
                betaCancelCycle(shadowRainBeta);
                addSkillEvent(timeHolding);
                alphaCycle();
                betaCycle();
                alphaCycle();
                betaCycle();
                alphaCycle();
                addSkillEvent(soulContract);
                betaCancelCycle(shadowRainBeta);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().after(new Timestamp(2 * 60 * 1000))
                    && getStart().before(new Timestamp(5 * 60 * 1000))
                    && zero == 0
            ) {
                alphaCancelCycle(shadowFlashAlpha);
                betaCancelCycle(shadowFlashBeta);
                alphaCancelCycle(transcendentLife);
                addSkillEvent(soulContract);
                addSkillEvent(limitBreak);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else {
                    addSkillEvent(weaponJumpRing);
                }
                shadowFlashBetaFinish = new ShadowFlashBetaFinish();
                shadowFlashBetaFinish.setDelay(240L);
                jointAttackCancelCycle(shadowFlashBetaFinish);
                addSkillEvent(limitBreakFinish);
                addSkillEvent(tag);
                alphaCancelCycle(shadowFlashAlphaFinish);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().after(new Timestamp(7 * 60 * 1000))
                    && zero == 0
            ) {
                alphaCancelCycle(shadowFlashAlpha);
                betaCancelCycle(shadowFlashBeta);
                if (cooldownCheck(timeDistotion)) {
                    addSkillEvent(timeDistotion);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                alphaCancelCycle(transcendentLife);
                addSkillEvent(soulContract);
                addSkillEvent(transcendentRhinneBless);
                addSkillEvent(limitBreak);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else {
                    addSkillEvent(weaponJumpRing);
                }
                shadowFlashBetaFinish = new ShadowFlashBetaFinish();
                shadowFlashBetaFinish.setDelay(240L);
                jointAttackCancelCycle(shadowFlashBetaFinish);
                addSkillEvent(limitBreakFinish);
                addSkillEvent(tag);
                alphaCancelCycle(shadowFlashAlphaFinish);
                betaCancelCycle(shadowRainBeta);
                if (cooldownCheck(timeHolding)) {
                    addSkillEvent(timeHolding);
                    addSkillEvent(soulContract);
                    alphaCycle();
                    betaCancelCycle(shadowRainBeta);
                }
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 50000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(shadowFlashAlpha)
                    && zero == 0
                    && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 50000))
            ) {
                alphaCancelCycle(shadowFlashAlpha);
            } else if (
                    cooldownCheck(shadowFlashBeta)
                    && zero == 1
                    && !cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 50000))
            ) {
                alphaCancelCycle(shadowFlashBeta);
            } else if (
                    getStart().after(shadowFlashAlphaEndTime)
                    && zero == 0
            ) {
                shadowFlashAlphaEndTime = new Timestamp(13 * 60 * 1000);
                alphaCancelCycle(shadowFlashAlphaFinish);
            } else if (
                    getStart().after(shadowFlashBetaEndTime)
                    && zero == 1
            ) {
                shadowFlashBetaEndTime = new Timestamp(13 * 60 * 1000);
                betaCancelCycle(shadowFlashBetaFinish);
            } else if (zero == 1) {     // 베타
                betaCycle();
            } else {
                alphaCycle();
            }
        }
        sortEventTimeList();
    }

    @Override
    public void applyDoping() {
        getJob().Doping();
        job2.Doping();
        setTotalDamage(calcTotalDamage(getEventTimeList()));
    }

    public void alphaCycle() {
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(alpha, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3330)));
        frontSlash = new FrontSlash();
        frontSlash.setDelay(570L);
        getSkillEventList().add(new SkillEvent(frontSlash, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 630)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 630));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 1110), new Timestamp(getStart().getTime() + 1110)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 1410), new Timestamp(getStart().getTime() + 1410)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 1710), new Timestamp(getStart().getTime() + 1710)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2010), new Timestamp(getStart().getTime() + 2010)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2310), new Timestamp(getStart().getTime() + 2310)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2610), new Timestamp(getStart().getTime() + 2610)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2910), new Timestamp(getStart().getTime() + 2910)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3510), new Timestamp(getStart().getTime() + 3510)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4110), new Timestamp(getStart().getTime() + 4110)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4410), new Timestamp(getStart().getTime() + 4410)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1110));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1410));     // 4    3410
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1710));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2010));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2610));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2910));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3210));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3510));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4110));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4410));
        gigaCrash = new GigaCrash();
        gigaCrash.setDelay(450L);
        getSkillEventList().add(new SkillEvent(gigaCrash, new Timestamp(getStart().getTime() + 1050), new Timestamp(getStart().getTime() + 1500)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1050));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1500));
        jumpingCrash = new JumpingCrash();
        jumpingCrash.setDelay(300L);
        getSkillEventList().add(new SkillEvent(jumpingCrash, new Timestamp(getStart().getTime() + 1500), new Timestamp(getStart().getTime() + 1800)));
        getSkillEventList().add(new SkillEvent(jumpingCrashShockWave, new Timestamp(getStart().getTime() + 1800), new Timestamp(getStart().getTime() + 2010)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1800));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2010));
        earthBreak = new EarthBreak();
        earthBreak.setDelay(90L);
        getSkillEventList().add(new SkillEvent(earthBreak, new Timestamp(getStart().getTime() + 2010), new Timestamp(getStart().getTime() + 2100)));
        getSkillEventList().add(new SkillEvent(earthBreakShockWave, new Timestamp(getStart().getTime() + 2100), new Timestamp(getStart().getTime() + 2490)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 3590), new Timestamp(getStart().getTime() + 3590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 4590), new Timestamp(getStart().getTime() + 4590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 5590), new Timestamp(getStart().getTime() + 5590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 6590), new Timestamp(getStart().getTime() + 6590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 7590), new Timestamp(getStart().getTime() + 7590)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2100));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 7590));
        frontSlash = new FrontSlash();
        frontSlash.setDelay(360L);
        getSkillEventList().add(new SkillEvent(frontSlash, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2850)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2850));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3360), new Timestamp(getStart().getTime() + 3360)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3660), new Timestamp(getStart().getTime() + 3660)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3960), new Timestamp(getStart().getTime() + 3960)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4260), new Timestamp(getStart().getTime() + 4260)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4560), new Timestamp(getStart().getTime() + 4560)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4860), new Timestamp(getStart().getTime() + 4860)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 5160), new Timestamp(getStart().getTime() + 5160)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 5460), new Timestamp(getStart().getTime() + 5460)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 5760), new Timestamp(getStart().getTime() + 5760)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 6060), new Timestamp(getStart().getTime() + 6060)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 6360), new Timestamp(getStart().getTime() + 6360)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 6660), new Timestamp(getStart().getTime() + 6660)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3360));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3660));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3960));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4260));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4560));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4860));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5160));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5460));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5760));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6060));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6360));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6660));
        flashAssault = new FlashAssault();
        flashAssault.setDelay(270L);
        addSkillEvent(flashAssault);
        spinCutter = new SpinCutter();
        spinCutter.setDelay(270L);
        addSkillEvent(spinCutter);
        windCutter = new WindCutter();
        windCutter.setDelay(420L);
        addSkillEvent(windCutter);
        windStrike = new WindStrike();
        windStrike.setDelay(480L);
        addSkillEvent(windStrike);
        stormBreak = new StormBreak();
        stormBreak.setDelay(690L);
        addSkillEvent(stormBreak);
        addSkillEvent(flashAssault);
        addSkillEvent(spinCutter);
        moonStrike = new MoonStrike();
        moonStrike.setDelay(390L);
        addSkillEvent(moonStrike);
        windCutter = new WindCutter();
        windCutter.setDelay(90L);
        addSkillEvent(windCutter);
        addSkillEvent(tag);
    }

    public void betaCycle() {
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(beta, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3150)));
        rollingCurve = new RollingCurve();
        rollingCurve.setDelay(360L);
        getSkillEventList().add(new SkillEvent(rollingCurve, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 420)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 420));
        rollingCurveBlade = new RollingCurveBlade();
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 480));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 540));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(510L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 960)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 960));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1020));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1080));
        windCutter = new WindCutter();
        windCutter.setDelay(540L);
        getSkillEventList().add(new SkillEvent(windCutter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1490), new Timestamp(getStart().getTime() + 1490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1990), new Timestamp(getStart().getTime() + 1990)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2990), new Timestamp(getStart().getTime() + 2990)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3490), new Timestamp(getStart().getTime() + 3490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3990), new Timestamp(getStart().getTime() + 3990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1990));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2990));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3990));
        windStrike = new WindStrike();
        windStrike.setDelay(630L);
        getSkillEventList().add(new SkillEvent(windStrike, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 1620)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1620));
        stormBreak = new StormBreak();
        stormBreak.setDelay(690L);
        getSkillEventList().add(new SkillEvent(stormBreak, new Timestamp(getStart().getTime() + 1620), new Timestamp(getStart().getTime() + 2310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2310));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 2810), new Timestamp(getStart().getTime() + 2810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3310), new Timestamp(getStart().getTime() + 3310)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4810), new Timestamp(getStart().getTime() + 4810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5310));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 3310), new Timestamp(getStart().getTime() + 3310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 6310), new Timestamp(getStart().getTime() + 6310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6310));
        rollingCurve = new RollingCurve();
        rollingCurve.setDelay(330L);
        getSkillEventList().add(new SkillEvent(rollingCurve, new Timestamp(getStart().getTime() + 2310), new Timestamp(getStart().getTime() + 2640)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2640));
        rollingCurveBlade = new RollingCurveBlade();
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2700), new Timestamp(getStart().getTime() + 2700)));
        rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2700), new Timestamp(getStart().getTime() + 2700)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2700), new Timestamp(getStart().getTime() + 2700)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2760), new Timestamp(getStart().getTime() + 2760)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2760), new Timestamp(getStart().getTime() + 2760)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2760), new Timestamp(getStart().getTime() + 2760)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2700));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2760));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(320L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 2670), new Timestamp(getStart().getTime() + 3090)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3120));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3150), new Timestamp(getStart().getTime() + 3150)));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3150), new Timestamp(getStart().getTime() + 3150)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3150), new Timestamp(getStart().getTime() + 3150)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3150));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3210));
        turningDrive = new TurningDrive();
        turningDrive.setDelay(360L);
        addSkillEvent(turningDrive);
        whirlWind = new WhirlWind();
        whirlWind.setDelay(90L);
        addSkillEvent(whirlWind);
        gigaCrash = new GigaCrash();
        gigaCrash.setDelay(420L);
        addSkillEvent(gigaCrash);
        jumpingCrash = new JumpingCrash();
        jumpingCrash.setDelay(240L);
        addSkillEvent(jumpingCrash);
        earthBreak = new EarthBreak();
        earthBreak.setDelay(900L - 390);
        addSkillEvent(earthBreak);
        addSkillEvent(turningDrive);
        addSkillEvent(whirlWind);
        frontSlash = new FrontSlash();
        frontSlash.setDelay(450L);
        addSkillEvent(frontSlash);
        throwingWeapon = new ThrowingWeapon();
        throwingWeapon.setDelay(30L);
        addSkillEvent(throwingWeapon);
        addSkillEvent(tag);
    }

    public void alphaCancelCycle(Skill skill) {
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(alpha, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3330)));
        frontSlash = new FrontSlash();
        frontSlash.setDelay(570L);
        getSkillEventList().add(new SkillEvent(frontSlash, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 630)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 630));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 1110), new Timestamp(getStart().getTime() + 1110)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 1410), new Timestamp(getStart().getTime() + 1410)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 1710), new Timestamp(getStart().getTime() + 1710)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2010), new Timestamp(getStart().getTime() + 2010)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2310), new Timestamp(getStart().getTime() + 2310)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2610), new Timestamp(getStart().getTime() + 2610)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 2910), new Timestamp(getStart().getTime() + 2910)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3510), new Timestamp(getStart().getTime() + 3510)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4110), new Timestamp(getStart().getTime() + 4110)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4410), new Timestamp(getStart().getTime() + 4410)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1110));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1410));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1710));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2010));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2610));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2910));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3210));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3510));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4110));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4410));
        gigaCrash = new GigaCrash();
        gigaCrash.setDelay(450L);
        getSkillEventList().add(new SkillEvent(gigaCrash, new Timestamp(getStart().getTime() + 1050), new Timestamp(getStart().getTime() + 1500)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1050));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1500));
        jumpingCrash = new JumpingCrash();
        jumpingCrash.setDelay(300L);
        getSkillEventList().add(new SkillEvent(jumpingCrash, new Timestamp(getStart().getTime() + 1500), new Timestamp(getStart().getTime() + 1800)));
        getSkillEventList().add(new SkillEvent(jumpingCrashShockWave, new Timestamp(getStart().getTime() + 1800), new Timestamp(getStart().getTime() + 2010)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1800));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2010));
        earthBreak = new EarthBreak();
        earthBreak.setDelay(90L);
        getSkillEventList().add(new SkillEvent(earthBreak, new Timestamp(getStart().getTime() + 2010), new Timestamp(getStart().getTime() + 2100)));
        getSkillEventList().add(new SkillEvent(earthBreakShockWave, new Timestamp(getStart().getTime() + 2100), new Timestamp(getStart().getTime() + 2490)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 3590), new Timestamp(getStart().getTime() + 3590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 4590), new Timestamp(getStart().getTime() + 4590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 5590), new Timestamp(getStart().getTime() + 5590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 6590), new Timestamp(getStart().getTime() + 6590)));
        getSkillEventList().add(new SkillEvent(earthBreakElectricity, new Timestamp(getStart().getTime() + 7590), new Timestamp(getStart().getTime() + 7590)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2100));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6590));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 7590));
        frontSlash = new FrontSlash();
        frontSlash.setDelay(360L);
        getSkillEventList().add(new SkillEvent(frontSlash, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2850)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2850));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3360), new Timestamp(getStart().getTime() + 3360)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3660), new Timestamp(getStart().getTime() + 3660)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 3960), new Timestamp(getStart().getTime() + 3960)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4260), new Timestamp(getStart().getTime() + 4260)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4560), new Timestamp(getStart().getTime() + 4560)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 4860), new Timestamp(getStart().getTime() + 4860)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 5160), new Timestamp(getStart().getTime() + 5160)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 5460), new Timestamp(getStart().getTime() + 5460)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 5760), new Timestamp(getStart().getTime() + 5760)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 6060), new Timestamp(getStart().getTime() + 6060)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 6360), new Timestamp(getStart().getTime() + 6360)));
        getSkillEventList().add(new SkillEvent(throwingWeapon, new Timestamp(getStart().getTime() + 6660), new Timestamp(getStart().getTime() + 6660)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3360));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3660));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3960));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4260));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4560));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4860));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5160));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5460));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5760));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6060));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6360));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6660));
        flashAssault = new FlashAssault();
        flashAssault.setDelay(270L);
        addSkillEvent(flashAssault);
        spinCutter = new SpinCutter();
        spinCutter.setDelay(270L);
        addSkillEvent(spinCutter);
        windCutter = new WindCutter();
        windCutter.setDelay(420L);
        addSkillEvent(windCutter);
        windStrike = new WindStrike();
        windStrike.setDelay(480L);
        addSkillEvent(windStrike);
        stormBreak = new StormBreak();
        stormBreak.setDelay(690L);
        addSkillEvent(stormBreak);
        addSkillEvent(flashAssault);
        addSkillEvent(spinCutter);
        moonStrike = new MoonStrike();
        moonStrike.setDelay(390L);
        addSkillEvent(moonStrike);
        skill.setDelay(90L);
        addSkillEvent(skill);
        addSkillEvent(tag);
    }

    public void betaCancelCycle(Skill skill) {
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(beta, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3180)));
        rollingCurve = new RollingCurve();
        rollingCurve.setDelay(360L);
        getSkillEventList().add(new SkillEvent(rollingCurve, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 420)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 420));
        rollingCurveBlade = new RollingCurveBlade();
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 480));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 540));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(510L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 960)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 960));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1020));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1080));
        windCutter = new WindCutter();
        windCutter.setDelay(540L);
        getSkillEventList().add(new SkillEvent(windCutter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1490), new Timestamp(getStart().getTime() + 1490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1990), new Timestamp(getStart().getTime() + 1990)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2990), new Timestamp(getStart().getTime() + 2990)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3490), new Timestamp(getStart().getTime() + 3490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3990), new Timestamp(getStart().getTime() + 3990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1990));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2990));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3990));
        windStrike = new WindStrike();
        windStrike.setDelay(630L);
        getSkillEventList().add(new SkillEvent(windStrike, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 1620)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1620));
        stormBreak = new StormBreak();
        stormBreak.setDelay(690L);
        getSkillEventList().add(new SkillEvent(stormBreak, new Timestamp(getStart().getTime() + 1620), new Timestamp(getStart().getTime() + 2310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2310));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 2810), new Timestamp(getStart().getTime() + 2810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3310), new Timestamp(getStart().getTime() + 3310)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4810), new Timestamp(getStart().getTime() + 4810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5310));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 3310), new Timestamp(getStart().getTime() + 3310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 6310), new Timestamp(getStart().getTime() + 6310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6310));
        flashAssault = new FlashAssault();
        flashAssault.setDelay(480L);
        getSkillEventList().add(new SkillEvent(flashAssault, new Timestamp(getStart().getTime() + 2310), new Timestamp(getStart().getTime() + 2790)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2790));
        spinCutter = new SpinCutter();
        spinCutter.setDelay(270L);
        getSkillEventList().add(new SkillEvent(spinCutter, new Timestamp(getStart().getTime() + 2790), new Timestamp(getStart().getTime() + 3060)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3060));
        getSkillEventList().add(new SkillEvent(spinCutterBlade, new Timestamp(getStart().getTime() + 3480), new Timestamp(getStart().getTime() + 3480)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3480));
        turningDrive = new TurningDrive();
        turningDrive.setDelay(360L);
        addSkillEvent(turningDrive);
        whirlWind = new WhirlWind();
        whirlWind.setDelay(90L);
        addSkillEvent(whirlWind);
        gigaCrash = new GigaCrash();
        gigaCrash.setDelay(420L);
        addSkillEvent(gigaCrash);
        jumpingCrash = new JumpingCrash();
        jumpingCrash.setDelay(240L);
        addSkillEvent(jumpingCrash);
        earthBreak = new EarthBreak();
        earthBreak.setDelay(900L - 390);
        addSkillEvent(earthBreak);
        frontSlash = new FrontSlash();
        frontSlash.setDelay(450L);
        addSkillEvent(frontSlash);
        throwingWeapon = new ThrowingWeapon();
        throwingWeapon.setDelay(380L);
        addSkillEvent(throwingWeapon);
        skill.setDelay(30L);
        addSkillEvent(skill);
        addSkillEvent(tag);
    }

    public void jointAttackCancelCycle(Skill skill) {
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(beta, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3180)));
        rollingCurve = new RollingCurve();
        rollingCurve.setDelay(360L);
        getSkillEventList().add(new SkillEvent(rollingCurve, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 420)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 420));
        rollingCurveBlade = new RollingCurveBlade();
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 480));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 540));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(510L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 960)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 960));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1020));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1080));
        windCutter = new WindCutter();
        windCutter.setDelay(540L);
        getSkillEventList().add(new SkillEvent(windCutter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1490), new Timestamp(getStart().getTime() + 1490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1990), new Timestamp(getStart().getTime() + 1990)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2990), new Timestamp(getStart().getTime() + 2990)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3490), new Timestamp(getStart().getTime() + 3490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3990), new Timestamp(getStart().getTime() + 3990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1990));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2990));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3490));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3990));
        windStrike = new WindStrike();
        windStrike.setDelay(630L);
        getSkillEventList().add(new SkillEvent(windStrike, new Timestamp(getStart().getTime() + 990), new Timestamp(getStart().getTime() + 1620)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1620));
        stormBreak = new StormBreak();
        stormBreak.setDelay(690L);
        getSkillEventList().add(new SkillEvent(stormBreak, new Timestamp(getStart().getTime() + 1620), new Timestamp(getStart().getTime() + 2310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2310));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 2810), new Timestamp(getStart().getTime() + 2810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3310), new Timestamp(getStart().getTime() + 3310)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4810), new Timestamp(getStart().getTime() + 4810)));
        getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4310));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 4810));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 5310));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 3310), new Timestamp(getStart().getTime() + 3310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
        getSkillEventList().add(new SkillEvent(stormBreakElectricity, new Timestamp(getStart().getTime() + 6310), new Timestamp(getStart().getTime() + 6310)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 6310));
        turningDrive = new TurningDrive();
        turningDrive.setDelay(360L);
        addSkillEvent(turningDrive);
        whirlWind = new WhirlWind();
        whirlWind.setDelay(90L);
        addSkillEvent(whirlWind);
        gigaCrash = new GigaCrash();
        gigaCrash.setDelay(420L);
        addSkillEvent(gigaCrash);
        jumpingCrash = new JumpingCrash();
        jumpingCrash.setDelay(240L);
        addSkillEvent(jumpingCrash);
        earthBreak = new EarthBreak();
        addSkillEvent(earthBreak);
        addSkillEvent(jointAttack1);
        addSkillEvent(skill);
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (skill instanceof Tag) {
            if (zero == 1) {
                zero = 0;
            } else {
                zero = 1;
            }
        }
        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof TranscendentRhinneBless) {
                blessEndTime = new Timestamp(getStart().getTime() + 45000);
            }
            if (skill instanceof TranscendentLife) {
                transcendentLightEndTime = new Timestamp(getStart().getTime() + 20000);
                transcendentTimeEndTime = new Timestamp(getStart().getTime() + 60000);
                lightSphereCnt = 7;
            }
            if (
                    skill instanceof TimeHolding
                    || skill instanceof TranscendentRhinneBless
            ) {
                soulContract.setActivateTime(new Timestamp(-1));
                shadowRainBeta.setActivateTime(new Timestamp(-1));
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
                    zero == 0
                    && cooldownCheck(egoWeaponAlpha)
                    && !(skill instanceof EgoWeaponAlpha)
                    && !(skill instanceof EgoWeaponBeta)
                    && !(skill instanceof ExtraAttack)
                    && !(skill instanceof TimeAfterImageZero)
                    && !(skill instanceof TimeAfterImage)
                    && !(skill instanceof LightSphere)
                    && !(skill instanceof LightSphereDot)
            ) {
                addSkillEvent(egoWeaponAlpha);
            }
            if (
                    zero == 1
                    && cooldownCheck(egoWeaponBeta)
                    && !(skill instanceof EgoWeaponAlpha)
                    && !(skill instanceof EgoWeaponBeta)
                    && !(skill instanceof ExtraAttack)
                    && !(skill instanceof TimeAfterImageZero)
                    && !(skill instanceof TimeAfterImage)
                    && !(skill instanceof LightSphere)
                    && !(skill instanceof LightSphereDot)
            ) {
                addSkillEvent(egoWeaponBeta);
            }
            if (skill instanceof ShadowFlashAlpha) {
                shadowFlashAlphaEndTime = new Timestamp(getStart().getTime() + 36500);
            }
            if (skill instanceof ShadowFlashBeta) {
                shadowFlashBetaEndTime = new Timestamp(getStart().getTime() + 36500);
            }
            if (
                    getStart().before(blessEndTime)
                    && !(skill instanceof ExtraAttack)
                    && !(skill instanceof EgoWeaponAlpha)
                    && !(skill instanceof EgoWeaponBeta)
                    && !(skill instanceof TimeAfterImageZero)
                    && !(skill instanceof TimeAfterImage)
                    && !(skill instanceof LightSphere)
                    && !(skill instanceof LightSphereDot)
            ) {
                addSkillEvent(extraAttack);
            }
            if (getStart().before(transcendentTimeEndTime)) {
                if (
                        skill instanceof AlphaSkill
                        || skill instanceof BetaSkill
                ) {
                    addSkillEvent(timeAfterImageZero);
                } else if (
                        !(skill instanceof TimeAfterImageZero)
                        && !(skill instanceof TimeAfterImage)
                        && !(skill instanceof EgoWeaponAlpha)
                        && !(skill instanceof EgoWeaponBeta)
                        && !(skill instanceof ExtraAttack)
                        && !(skill instanceof LightSphere)
                        && !(skill instanceof LightSphereDot)
                ) {
                    addSkillEvent(timeAfterImage);
                }
            }
            if (
                    getStart().before(transcendentLightEndTime)
                    && cooldownCheck(lightSphere)
                    && !(skill instanceof LightSphere)
                    && !(skill instanceof LightSphereDot)
                    && !(skill instanceof EgoWeaponAlpha)
                    && !(skill instanceof EgoWeaponBeta)
                    && !(skill instanceof ExtraAttack)
                    && !(skill instanceof TimeAfterImageZero)
                    && !(skill instanceof TimeAfterImage)
                    && lightSphereCnt > 0
            ) {
                addSkillEvent(lightSphere);
                lightSphereCnt --;
            }
            if (
                    zero == 1
                    && cooldownCheck(criticalBind)
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 10) {
                    addSkillEvent(criticalBind);
                }
            }
            if (getStart().after(devineLeerEndTime)) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 15) {
                    addSkillEvent(divineLeer);
                }
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof LightSphereDot) {
                        i = 660;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
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
            boolean isCriticalBind = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof CriticalBind) {
                    isCriticalBind = true;
                    break;
                }
            }
            boolean isAlpha = false;
            for (SkillEvent skillEvent : useAttackSkillList) {
                if (skillEvent.getSkill() instanceof Alpha) {
                    isAlpha = true;
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
                if (
                        isCriticalBind
                        && se.getSkill() instanceof AlphaSkill
                ) {
                    buffSkill.addBuffCriticalDamage(20.0);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isCriticalBind
                                && se.getSkill() instanceof AlphaSkill
                ) {
                    buffSkill.addBuffCriticalDamage(-20.0);
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end, isAlpha);
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end, boolean isAlpha) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : getAttackSkillList()) {
            if (skillEvent.getSkill() instanceof AlphaSkill || isAlpha) {
                if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                    attackDamage = (long) Math.floor(((getJob().getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                            + getJob().getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
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
                    if (as.getMultiAttackInfo().size() == 0 && as.getInterval() == 0 && as.getDelay() != 0 && distance != 0) {
                        attackDamage = attackDamage / as.getDelay() * distance;
                    }
                    as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                    break;
                }
            } else {
                if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                    attackDamage = (long) Math.floor(((job2.getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                            + job2.getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
                            * (Math.floor((job2.getAtt() + buffSkill.getBuffAttMagic())
                            * (1 + (job2.getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                            + job2.getPerXAtt())
                            * job2.getConstant()
                            * (1 + (job2.getDamage() + job2.getBossDamage() + job2.getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                            * (job2.getFinalDamage() + buffSkill.getBuffPlusFinalDamage() - 1)
                            * buffSkill.getBuffFinalDamage()
                            * job2.getStatXFinalDamage()
                            * attackSkill.getFinalDamage()
                            * job2.getMastery()
                            * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                            * (1 + 0.35 + (job2.getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                            * (1 - 0.5 * (1 - (job2.getProperty() - buffSkill.getBuffProperty()) * 0.01))
                            * (1 - 3 * (1 - buffSkill.getIgnoreDefense()) * (1 - job2.getIgnoreDefense()) * (1 - job2.getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                    );
                    if (skillEvent.getStart().equals(start)) {
                        as.setUseCount(as.getUseCount() + 1);
                    }
                    Long distance = end.getTime() - start.getTime();
                    if (as.getMultiAttackInfo().size() == 0 && as.getInterval() == 0 && as.getDelay() != 0 && distance != 0) {
                        attackDamage = attackDamage / as.getDelay() * distance;
                    }
                    as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                    break;
                }
            }
        }
        return attackDamage;
    }
}
