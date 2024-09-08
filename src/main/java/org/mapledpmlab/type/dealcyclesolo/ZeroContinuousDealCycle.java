package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.JobContinuous.ZeroBetaContinuous;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
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

public class ZeroContinuousDealCycle extends DealCycle {
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new ContinuousRing());
            add(new CriticalBind());
            add(new LimitBreakBuff());
            add(new SoulContract());
            add(new TimeDistotion());
            add(new TimeHolding());
            add(new TimePiece());
            add(new TranscendentLife());
            add(new TranscendentLight());
            add(new TranscendentRhinneBless());
            add(new TranscendentTime());
        }
    };

    Job job2 = new ZeroBetaContinuous();

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    ChronoTrigger1 chronoTrigger1 = new ChronoTrigger1();
    ContinuousRing continuousRing = new ContinuousRing();
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
    ThrowingWeapon throwingWeapon = new ThrowingWeapon();
    TimeDistotion timeDistotion = new TimeDistotion();
    TimeHolding timeHolding = new TimeHolding();
    TranscendentLife transcendentLife = new TranscendentLife();
    TranscendentRhinneBless transcendentRhinneBless = new TranscendentRhinneBless();
    TurningDrive turningDrive = new TurningDrive();
    UpperSlash upperSlash = new UpperSlash();
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
    Timestamp continuousRingEndTime = new Timestamp(-1);

    int zero = 1;   // 0 - 알파, 1 - 베타
    int lightSphereCnt = 0;
    int timePieceCnt = 0;

    boolean isShadowFlashAlpha = false;
    boolean isShadowFlashBeta = false;
    boolean isNuke = false;

    public ZeroContinuousDealCycle(Job job) {
        super(job, null);

        job2.addTotal(job2.getJobType());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        transcendentRhinneBless.setCooldown(120.0);
        auraWeaponBuff.setCooldown(180.0);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        boolean isOrigin = false;
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(auraWeaponBuff)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    getStart().before(new Timestamp(660 * 1000))
                            && (
                            (
                                    zero == 1
                                            && (
                                            dealCycleOrder == 1
                                                    || dealCycleOrder == 4
                                    )
                            ) || (
                                    zero == 0
                                            && (
                                            dealCycleOrder == 2
                                                    || dealCycleOrder == 3
                                                    || dealCycleOrder == 5
                                                    || dealCycleOrder == 6
                                    )
                            )
                    )
                            && getStart().after(new Timestamp(transcendentLife.getActivateTime().getTime() - 10000))
                            && getStart().after(new Timestamp(limitBreak.getActivateTime().getTime() - 12000))
                            && getStart().after(new Timestamp(jointAttack1.getActivateTime().getTime() - 15000))
                            && getStart().after(new Timestamp(shadowFlashAlpha.getActivateTime().getTime() - 2000))
                            && getStart().after(new Timestamp(shadowFlashBeta.getActivateTime().getTime() - 2000))
            ) {
                isNuke = true;
                if (zero == 1) {
                    betaCancelCycle(shadowFlashBeta);
                    alphaCancelCycle(shadowFlashAlpha);
                } else {
                    alphaCancelCycle(shadowFlashAlpha);
                    betaCancelCycle(shadowFlashBeta);
                }
                if (cooldownCheck(timeDistotion)) {
                    addSkillEvent(timeDistotion);
                }
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addSkillEvent(bodyOfSteel);
                if (
                        cooldownCheck(shadowRainBeta)
                                && zero == 1
                ) {
                    betaCancelCycle(shadowRainBeta);
                }
                alphaCancelCycle(transcendentLife);
                addSkillEvent(soulContract);
                isNuke = false;
                addSkillEvent(transcendentRhinneBless);
                if (!cooldownCheck(limitBreak)) {
                    addSkillEvent(new UpperSlash());
                }
                addSkillEvent(limitBreak);
                shadowFlashBetaFinish = new ShadowFlashBetaFinish();
                if (cooldownCheck(chronoTrigger1)) {
                    jointAttackCancelCycle(chronoTrigger1);
                    addSkillEvent(shadowFlashBetaFinish);
                    isOrigin = true;
                } else {
                    jointAttackCancelCycle(shadowFlashBetaFinish);
                }
                addSkillEvent(limitBreakFinish);
                addSkillEvent(tag);
                shadowFlashAlphaFinish = new ShadowFlashAlphaFinish();
                alphaCancelCycle(shadowFlashAlphaFinish);
                if (
                        cooldownCheck(soulContract)
                                && cooldownCheck(shadowRainBeta)
                ) {
                    addSkillEvent(soulContract);
                    shadowRainBeta = new ShadowRainBeta();
                    betaCancelCycle(shadowRainBeta);
                }
                if (cooldownCheck(timeHolding)) {
                    addSkillEvent(timeHolding);
                    alphaCycle();
                    if (isOrigin) {
                        betaCancelCycle(shadowFlashBeta);
                        alphaCancelCycle(shadowFlashAlpha);
                        betaCancelCycle(shadowFlashBetaFinish);
                        alphaCancelCycle(shadowFlashAlphaFinish);
                    } else {
                        betaCycle();
                        alphaCycle();
                        betaCycle();
                        alphaCycle();
                    }
                    addSkillEvent(soulContract);
                    shadowRainBeta = new ShadowRainBeta();
                    betaCancelCycle(shadowRainBeta);
                }
                isOrigin = false;
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 50000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    getStart().after(new Timestamp(shadowFlashAlpha.getActivateTime().getTime() - 2000))
                            && zero == 0
                            && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 30000))
            ) {
                alphaCancelCycle(shadowFlashAlpha);
                isShadowFlashAlpha = true;
            } else if (
                    getStart().after(new Timestamp(shadowFlashBeta.getActivateTime().getTime() - 2000))
                            && zero == 1
                            && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 30000))
            ) {
                betaCancelCycle(shadowFlashBeta);
                isShadowFlashBeta = true;
            } else if (
                    zero == 0
                            && isShadowFlashAlpha
            ) {
                alphaCancelCycle(shadowFlashAlphaFinish);
                isShadowFlashAlpha = false;
            } else if (
                    zero == 1
                            && isShadowFlashBeta
            ) {
                betaCancelCycle(shadowFlashBetaFinish);
                isShadowFlashBeta = false;
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
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = timePieceCnt - timePieceCrystalOfTime.getMultiAttackInfo().size();
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
        timePieceCnt += 7;
    }

    public void betaCycle() {
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = timePieceCnt - timePieceCrystalOfTime.getMultiAttackInfo().size();
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(beta, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3150)));
        rollingCurve = new RollingCurve();
        rollingCurve.setDelay(360L);
        getSkillEventList().add(new SkillEvent(rollingCurve, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 420)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 420));
        rollingCurveBlade = new RollingCurveBlade();
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        /*rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 540));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 480));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(510L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 960)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 960));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        /*rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1080));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1020));
        windCutter = new WindCutter();
        windCutter.setDelay(540L);
        getSkillEventList().add(new SkillEvent(windCutter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1490), new Timestamp(getStart().getTime() + 1490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1990), new Timestamp(getStart().getTime() + 1990)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2490)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2990), new Timestamp(getStart().getTime() + 2990)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3490), new Timestamp(getStart().getTime() + 3490)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3990), new Timestamp(getStart().getTime() + 3990)));
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
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4810), new Timestamp(getStart().getTime() + 4810)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
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
        /*rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2700), new Timestamp(getStart().getTime() + 2700)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2700), new Timestamp(getStart().getTime() + 2700)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2760), new Timestamp(getStart().getTime() + 2760)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2760), new Timestamp(getStart().getTime() + 2760)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 2760), new Timestamp(getStart().getTime() + 2760)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2760));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 2700));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(320L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 2670), new Timestamp(getStart().getTime() + 3090)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3120));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3150), new Timestamp(getStart().getTime() + 3150)));
        /*rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3150), new Timestamp(getStart().getTime() + 3150)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3150), new Timestamp(getStart().getTime() + 3150)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 3210), new Timestamp(getStart().getTime() + 3210)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3210));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 3150));
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
        timePieceCnt += 7;
    }

    public void alphaCancelCycle(Skill skill) {
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = timePieceCnt - timePieceCrystalOfTime.getMultiAttackInfo().size();
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
        if (skill instanceof TranscendentLife) {
            skill.getRelatedSkill().getRelatedSkill().setDelay(90L);
        } else {
            skill.setDelay(90L);
        }
        addSkillEvent(skill);
        addSkillEvent(tag);
        timePieceCnt += 7;
    }

    public void betaCancelCycle(Skill skill) {
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = timePieceCnt - timePieceCrystalOfTime.getMultiAttackInfo().size();
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(beta, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3180)));
        rollingCurve = new RollingCurve();
        rollingCurve.setDelay(360L);
        getSkillEventList().add(new SkillEvent(rollingCurve, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 420)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 420));
        rollingCurveBlade = new RollingCurveBlade();
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        /*rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 540));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 480));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(510L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 960)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 960));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        /*rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1080));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1020));
        windCutter = new WindCutter();
        windCutter.setDelay(540L);
        getSkillEventList().add(new SkillEvent(windCutter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1490), new Timestamp(getStart().getTime() + 1490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1990), new Timestamp(getStart().getTime() + 1990)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2490)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2990), new Timestamp(getStart().getTime() + 2990)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3490), new Timestamp(getStart().getTime() + 3490)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3990), new Timestamp(getStart().getTime() + 3990)));
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
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4810), new Timestamp(getStart().getTime() + 4810)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
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
        timePieceCnt += 7;
    }

    public void jointAttackCancelCycle(Skill skill) {
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = timePieceCnt - timePieceCrystalOfTime.getMultiAttackInfo().size();
        addSkillEvent(timePieceCrystalOfTime);
        getSkillEventList().add(new SkillEvent(beta, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime() + 3180)));
        rollingCurve = new RollingCurve();
        rollingCurve.setDelay(360L);
        getSkillEventList().add(new SkillEvent(rollingCurve, new Timestamp(getStart().getTime() + 60), new Timestamp(getStart().getTime() + 420)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 60));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 420));
        rollingCurveBlade = new RollingCurveBlade();
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        /*rollingCurveBlade = new RollingCurveBlade();
        rollingCurveBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 480), new Timestamp(getStart().getTime() + 480)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getSkillEventList().add(new SkillEvent(rollingCurveBlade, new Timestamp(getStart().getTime() + 540), new Timestamp(getStart().getTime() + 540)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 540));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 480));
        rollingAssaulter = new RollingAssaulter();
        rollingAssaulter.setDelay(510L);
        getSkillEventList().add(new SkillEvent(rollingAssaulter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 960)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 960));
        rollingAssaulterBlade = new RollingAssaulterBlade();
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        /*rollingAssaulterBlade = new RollingAssaulterBlade();
        rollingAssaulterBlade.addFinalDamage(0.3);
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1020), new Timestamp(getStart().getTime() + 1020)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getSkillEventList().add(new SkillEvent(rollingAssaulterBlade, new Timestamp(getStart().getTime() + 1080), new Timestamp(getStart().getTime() + 1080)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1080));*/
        getEventTimeList().add(new Timestamp(getStart().getTime() + 1020));
        windCutter = new WindCutter();
        windCutter.setDelay(540L);
        getSkillEventList().add(new SkillEvent(windCutter, new Timestamp(getStart().getTime() + 450), new Timestamp(getStart().getTime() + 990)));
        getEventTimeList().add(new Timestamp(getStart().getTime() + 990));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1490), new Timestamp(getStart().getTime() + 1490)));
        getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 1990), new Timestamp(getStart().getTime() + 1990)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2490), new Timestamp(getStart().getTime() + 2490)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 2990), new Timestamp(getStart().getTime() + 2990)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3490), new Timestamp(getStart().getTime() + 3490)));
        //getSkillEventList().add(new SkillEvent(windCutterTornado, new Timestamp(getStart().getTime() + 3990), new Timestamp(getStart().getTime() + 3990)));
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
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 3810), new Timestamp(getStart().getTime() + 3810)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4310), new Timestamp(getStart().getTime() + 4310)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 4810), new Timestamp(getStart().getTime() + 4810)));
        //getSkillEventList().add(new SkillEvent(stormBreakTornado, new Timestamp(getStart().getTime() + 5310), new Timestamp(getStart().getTime() + 5310)));
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
        timePieceCnt += 5;
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
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
                    skill instanceof SoulContract
                    && restraintRingStartTime == null
                    && restraintRingEndTime == null
                    && fortyEndTime == null
                    && isNuke
            ) {
                restraintRingStartTime = new Timestamp(getStart().getTime());
                restraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
                fortyEndTime = new Timestamp(getStart().getTime() + 40000);
            } else if (
                    skill instanceof SoulContract
                            && restraintRingStartTime != null
                            && restraintRingEndTime != null
                            && fortyEndTime != null
                            && originXRestraintRingStartTime == null
                            && originXRestraintRingEndTime == null
                            && isNuke
                            && getStart().after(new Timestamp(200 * 1000))
            ) {
                originXRestraintRingStartTime = new Timestamp(getStart().getTime());
                originXRestraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                if (skill instanceof BodyOfSteel) {
                    for (long i = 0; i < 18000; i += 1000) {
                        getSkillEventList().add(new SkillEvent(new BodyOfSteel(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 1000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
                    }
                }
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof SpiderInMirror
                            || skill instanceof CrestOfTheSolar
                            || skill instanceof EarthBreak
                            || skill instanceof EarthBreakShockWave
                            || skill instanceof EgoWeaponAlpha
                            || skill instanceof EgoWeaponBeta
                            || skill instanceof FlashAssault
                            || skill instanceof FrontSlash
                            || skill instanceof GigaCrash
                            || skill instanceof JumpingCrash
                            || skill instanceof JumpingCrashShockWave
                            || skill instanceof LightSphere
                            || skill instanceof LimitBreak
                            || skill instanceof MoonStrike
                            || skill instanceof PierceThrust
                            || skill instanceof PowerStomp
                            || skill instanceof PowerStompShockWave
                            || skill instanceof RollingAssaulter
                            || skill instanceof RollingAssaulterBlade
                            || skill instanceof RollingCurve
                            || skill instanceof RollingCurveBlade
                            || skill instanceof ShadowFlashAlpha
                            || skill instanceof ShadowFlashAlphaFinish
                            || skill instanceof ShadowRainAlpha
                            || skill instanceof ShadowRainBeta
                            || skill instanceof ShadowStrike
                            || skill instanceof ShadowStrikeBlade
                            || skill instanceof SpinCutter
                            || skill instanceof SpinCutterBlade
                            || skill instanceof StormBreak
                            || skill instanceof ThrowingWeapon
                            || skill instanceof TurningDrive
                            || skill instanceof UpperSlash
                            || skill instanceof WindCutter
                            || skill instanceof WindStrike
                    )
            ) {
                addSkillEvent(continuousRing);
            }
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
            if (
                    getStart().before(blessEndTime)
                    && (
                            skill instanceof EarthBreak
                            || skill instanceof FlashAssault
                            || skill instanceof FrontSlash
                            || skill instanceof GigaCrash
                            || skill instanceof JumpingCrash
                            || skill instanceof MoonStrike
                            || skill instanceof PierceThrust
                            || skill instanceof PowerStomp
                            || skill instanceof RollingAssaulter
                            || skill instanceof RollingCurve
                            || skill instanceof ShadowStrike
                            || skill instanceof SpinCutter
                            || skill instanceof StormBreak
                            || skill instanceof ThrowingWeapon
                            || skill instanceof TurningDrive
                            || skill instanceof UpperSlash
                            || skill instanceof WhirlWind
                            || skill instanceof WindCutter
                            || skill instanceof WindStrike
                    )
            ) {
                addSkillEvent(extraAttack);
            }
            if (
                    getStart().before(transcendentTimeEndTime)
                    && (
                            skill instanceof EarthBreak
                            || skill instanceof FlashAssault
                            || skill instanceof FrontSlash
                            || skill instanceof GigaCrash
                            || skill instanceof JumpingCrash
                            || skill instanceof MoonStrike
                            || skill instanceof PierceThrust
                            || skill instanceof PowerStomp
                            || skill instanceof RollingAssaulter
                            || skill instanceof RollingCurve
                            || skill instanceof ShadowStrike
                            || skill instanceof SpinCutter
                            || skill instanceof StormBreak
                            || skill instanceof ThrowingWeapon
                            || skill instanceof TurningDrive
                            || skill instanceof UpperSlash
                            || skill instanceof WhirlWind
                            || skill instanceof WindCutter
                            || skill instanceof WindStrike
                    )
            ) {
                addSkillEvent(timeAfterImageZero);
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
                        Timestamp now = new Timestamp(getStart().getTime());
                        getStart().setTime(getStart().getTime() + i);
                        if (
                                cooldownCheck(continuousRing)
                                && skill instanceof JointAttackFinish
                        ) {
                            addSkillEvent(continuousRing);
                        }
                        getStart().setTime(now.getTime());
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
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
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
                            * (getJob().getFinalDamage())
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
                            * (job2.getFinalDamage())
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

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        int cnt = 0;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    cnt != 0
                    && (
                            skill instanceof RollingCurveBlade
                            || skill instanceof RollingAssaulterBlade
                    )
            ) {
                if (skill instanceof RollingCurveBlade) {
                    skill = new RollingCurveBlade();
                    ((RollingCurveBlade) skill).addFinalDamage(0.7);
                } else {
                    skill = new RollingAssaulterBlade();
                    ((RollingAssaulterBlade) skill).addFinalDamage(0.7);
                }
            }
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Timestamp now = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof JointAttack1
                            || skill instanceof JointAttack2
                            || skill instanceof JointAttack3
                            || skill instanceof ChronoTrigger1
                            || skill instanceof ChronoTrigger2
                            || skill instanceof ChronoTrigger3
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            getStart().setTime(now.getTime());
            cnt ++;
        }
    }

    @Override
    public void getJobInfo() {
        System.out.println("-------------------");
        System.out.println("직업 : " + job2.getName());
        System.out.println("기본 주스탯 수치 : " + job2.getMainStat());
        System.out.println("주스탯 % 수치 : " + (job2.getMainStatP() + job2.getAllStatP()));
        System.out.println("% 미적용 주스탯 수치 : " + job2.getPerXMainStat());
        System.out.println("기본 부스탯 수치 : " + job2.getSubStat());
        System.out.println("부스탯 % 수치 : " + job2.getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + job2.getPerXSubStat());
        System.out.println("기본 스공 : " + job2.getStatDamage());
        System.out.println("데미지 : " + job2.getDamage());
        System.out.println("최종데미지 : " + job2.getFinalDamage());
        System.out.println("보스 데미지 : " + job2.getBossDamage());
        System.out.println("방어율 무시 : " + job2.getIgnoreDefense());
        System.out.println("크리티컬 확률 : " + job2.getCriticalP());
        System.out.println("장비 공격력 % : " + job2.getAttP());
        System.out.println("장비 마력 % : " + job2.getMagicP());
        System.out.println("크리티컬 데미지 : " + job2.getCriticalDamage());
        System.out.println("쿨타임 감소 초 : " + job2.getCooldownReductionSec());
        System.out.println("쿨타임 감소 % : " + job2.getCooldownReductionP());
        System.out.println("버프 지속 시간 : " + job2.getPlusBuffDuration());
        System.out.println("재사용 : " + job2.getReuse());
        System.out.println("속성 내성 무시 : " + job2.getProperty());
        System.out.println("무기 공격력 : " + job2.getWeaponAttMagic());
        System.out.println(job2.getLinkListStr());
        System.out.println(job2.getAbility().getDescription());
    }
}
