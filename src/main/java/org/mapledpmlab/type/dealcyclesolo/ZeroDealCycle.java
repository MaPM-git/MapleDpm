package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
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
            add(new CriticalBind());
            add(new LimitBreakBuff());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
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

    Timestamp assistEndTime = new Timestamp(-1);
    Timestamp assistNowTime = new Timestamp(-1);
    Timestamp assistMoveTime = new Timestamp(-1);
    Timestamp extraAttackTime = new Timestamp(-1);

    Job job2 = new ZeroBeta();

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
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

    int zero = 1;   // 0 - 알파, 1 - 베타
    int lightSphereCnt = 0;
    int timePieceCnt = 0;

    boolean isShadowFlashAlpha = false;
    boolean isShadowFlashBeta = false;
    boolean isExtraAttack = false;
    boolean isEgoWeapon = false;

    public ZeroDealCycle(Job job) {
        super(job, null);

        job2.addTotal(job2.getJobType());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(120.0);
        transcendentRhinneBless.setCooldown(120.0);
        auraWeaponBuff.setCooldown(180.0);

        earthBreak.setAssistSkill(new StormBreak());
        flashAssault.setAssistSkill(new FrontSlash());
        frontSlash.setAssistSkill(new FlashAssault());
        gigaCrash.setAssistSkill(new WindCutter());
        jumpingCrash.setAssistSkill(new WindStrike());
        moonStrike.setAssistSkill(new UpperSlash());
        pierceThrust.setAssistSkill(new PowerStomp());
        powerStomp.setAssistSkill(new PierceThrust());
        rollingAssaulter.setAssistSkill(new TurningDrive());
        rollingCurve.setAssistSkill(new TurningDrive());
        shadowStrike.setAssistSkill(new UpperSlash());
        spinCutter.setAssistSkill(new ThrowingWeapon());
        stormBreak.setAssistSkill(new EarthBreak());
        throwingWeapon.setAssistSkill(new SpinCutter());
        turningDrive.setAssistSkill(new RollingCurve());
        upperSlash.setAssistSkill(new MoonStrike());
        windCutter.setAssistSkill(new GigaCrash());
        windStrike.setAssistSkill(new JumpingCrash());
        whirlWind.setAssistSkill(new RollingAssaulter());

        timeDistotion.setDelay(220L);
        bodyOfSteel.setDelay(220L);
        transcendentRhinneBless.setDelay(220L);
        transcendentLife.getRelatedSkill().getRelatedSkill().setDelay(210L);

        getSkillSequence1().add(timeDistotion);
        getSkillSequence1().add(bodyOfSteel);
        getSkillSequence1().add(soulContract);
        getSkillSequence1().add(transcendentRhinneBless);
        getSkillSequence1().add(transcendentLife);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        boolean isOrigin = false;
        addSkillEvent(divineLeer);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(auraWeaponBuff)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    getStart().before(new Timestamp(660 * 1000))
                            && zero == 1
                            && getStart().after(new Timestamp(bodyOfSteel.getActivateTime().getTime() - 6000))
            ) {
                betaCancelCycle(shadowFlashBeta);
                alphaCancelCycle(shadowFlashAlpha);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                if (cooldownCheck(shadowRainBeta)) {
                    betaCancelCycle(shadowRainBeta);
                    alphaCycle();
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(limitBreak);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                if (cooldownCheck(chronoTrigger1)) {
                    jointAttackCancelCycle(chronoTrigger1);
                    addSkillEvent(shadowFlashBetaFinish);
                    isOrigin = true;
                } else {
                    jointAttackCancelCycle(shadowFlashBetaFinish);
                }
                addSkillEvent(limitBreakFinish);
                addSkillEvent(tag);
                alphaCancelCycle(shadowFlashAlphaFinish);
                if (
                        cooldownCheck(soulContract)
                                && cooldownCheck(shadowRainBeta)
                ) {
                    addSkillEvent(soulContract);
                    betaCancelCycle(shadowRainBeta);
                }
                if (cooldownCheck(timeHolding)) {
                    addSkillEvent(timeHolding);
                    alphaCycle();
                    if (isOrigin) {
                        addSkillEvent(moonStrike);
                        addSkillEvent(pierceThrust);
                        addSkillEvent(shadowStrike);
                        addSkillEvent(moonStrike);
                        addSkillEvent(pierceThrust);
                        addSkillEvent(shadowStrike);
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
                    betaCancelCycle(shadowRainBeta);
                }
                isOrigin = false;
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(100 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 50000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    getStart().after(new Timestamp(shadowFlashBeta.getActivateTime().getTime() - 2000))
                            && zero == 1
                            && getStart().before(new Timestamp(transcendentLife.getActivateTime().getTime() - 30000))
            ) {
                betaCancelCycle(shadowFlashBeta);
                alphaCancelCycle(shadowFlashAlpha);
                betaCancelCycle(shadowFlashBetaFinish);
                alphaCancelCycle(shadowFlashAlphaFinish);
            } else if (zero == 1) {     // 베타
                betaCycle();
            } else {
                alphaCycle();
            }
        }
        sortEventTimeList();
    }

    public void addAssistSkillEvent(Skill skill, boolean isRelated) {
        Timestamp endTime = null;

        Timestamp skillEndTime = new Timestamp(getStart().getTime() + skill.getDelay());
        if (!isRelated) {
            if (skill instanceof PowerStomp) {
                skillEndTime = new Timestamp(getStart().getTime() + 570);
            } else if (skill instanceof RollingAssaulter) {
                skillEndTime = new Timestamp(getStart().getTime() + 960);
            } else if (skill instanceof RollingCurve) {
                skillEndTime = new Timestamp(getStart().getTime() + 960);
            } else if (skill instanceof ShadowStrike) {
                skillEndTime = new Timestamp(getStart().getTime() + 330);
            } else if (skill instanceof SpinCutter) {
                skillEndTime = new Timestamp(getStart().getTime() + skill.getDelay() + 90);
            }
            skill = ((AssistSkill) skill).getAssistSkill();
            if (
                    ((AssistSkill) skill).isMove()
                            && skillEndTime.before(assistMoveTime)
            ) {
                return;
            }
            if (
                    skillEndTime.before(assistNowTime)
                            && assistNowTime.getTime() - skillEndTime.getTime() > 60    // 스킬 종료 시간이 어시스트 종료 시간보다 전임
            ) {
                assistNowTime = new Timestamp(skillEndTime.getTime());
            } else if (assistNowTime.before(getStart())) {                      // 어시스트 종료 시간이 현재보다 전임
                assistNowTime = new Timestamp(getStart().getTime());
            } else if (skillEndTime.after(assistNowTime)) {                     // 스킬 종료 시간과 어시스트 종료 시간이 같음
            } else if (getStart().before(assistNowTime)) {                      // 현재가 어시스트 종료 시간보다 전임
                assistNowTime = new Timestamp(skillEndTime.getTime());
            } else if (assistEndTime.getTime() - assistNowTime.getTime() < 2940) {  // 어시스트 가능 시간
                assistNowTime = new Timestamp(getStart().getTime());
            } else {                                                            // 이제 막 태그함
                assistNowTime = new Timestamp(getStart().getTime() + 60);
            }
        }
        if (
                assistNowTime.after(assistEndTime)
                        && !isRelated
        ) {
            return;
        }
        if (skill instanceof SpinCutter) {
            assistMoveTime = new Timestamp(-1);
        }
        if (
                !(skill instanceof EarthBreakElectricity)
                        && !(skill instanceof RollingAssaulterBlade)
                        && !(skill instanceof RollingCurveBlade)
                        && !(skill instanceof ShadowStrikeBlade)
                        && !(skill instanceof SpinCutterBlade)
                        && !(skill instanceof StormBreakElectricity)
                        && !(skill instanceof StormBreakTornado)
                        && !(skill instanceof WindCutterTornado)
        ) {
            timePieceCnt ++;
            if (timePieceCnt > 13) {
                timePieceCnt = 13;
            }
        }
        if (
                getStart().before(blessEndTime)
                        && isExtraAttack
                        && !(skill instanceof ThrowingWeapon)
        ) {
            isExtraAttack = false;
            addSkillEvent(extraAttack);
            if (!skillEndTime.equals(assistNowTime)) {
                flashAssault.setActivateTime(new Timestamp(flashAssault.getActivateTime().getTime() - 4000));
            }
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "(어시스트)\t" + simpleDateFormat.format(assistNowTime) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "(어시스트)\t" + simpleDateFormat.format(assistNowTime) + "\t" + skill.getName();
        }
        if (((AttackSkill) skill).getInterval() != 0) {
            if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(assistNowTime.getTime() + i), new Timestamp(assistNowTime.getTime() + i)));
                    getEventTimeList().add(new Timestamp(assistNowTime.getTime() + i));
                }
            } else {
                Long attackCount = 0L;
                for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(assistNowTime.getTime() + i), new Timestamp(assistNowTime.getTime() + i)));
                    getEventTimeList().add(new Timestamp(assistNowTime.getTime() + i));
                    attackCount += 1;
                }
            }
        } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
            this.multiAttackProcess(skill);
        } else {
            if (
                    !(skill instanceof EarthBreakShockWave)
                            && !(skill instanceof FrontSlash)
            ) {
                endTime = new Timestamp(assistNowTime.getTime() + ((AssistSkill) skill).getAssistDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(assistNowTime.getTime()), endTime));
            }
            if (skill instanceof RollingCurveBlade) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 50) {
                    RollingCurveBlade tmp = new RollingCurveBlade();
                    tmp.addFinalDamage(0.7);
                    getSkillEventList().add(new SkillEvent(tmp, new Timestamp(assistNowTime.getTime()), endTime));
                }
            }
            if (skill instanceof RollingAssaulterBlade) {
                RollingAssaulterBlade tmp = new RollingAssaulterBlade();
                tmp.addFinalDamage(0.7);
                getSkillEventList().add(new SkillEvent(tmp, new Timestamp(assistNowTime.getTime()), endTime));
            }
        }
        getEventTimeList().add(assistNowTime);
        getEventTimeList().add(new Timestamp(assistNowTime.getTime() + ((AssistSkill) skill).getAssistDelay()));
        assistNowTime = new Timestamp(assistNowTime.getTime() + ((AssistSkill) skill).getAssistDelay());
        if (skill instanceof RollingAssaulterBlade) {
            assistNowTime = new Timestamp(assistNowTime.getTime() - 600);
        }
        if (
                !(skill instanceof RollingCurve)
                        && ((AssistSkill) skill).isMove()
        ) {
            assistMoveTime = new Timestamp(assistNowTime.getTime() + 600);
        }
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        if (skill.getRelatedSkill() != null) {
            addAssistSkillEvent(skill.getRelatedSkill(), true);
        }
    }

    @Override
    public void applyDoping() {
        getJob().Doping();
        job2.Doping();
        setTotalDamage(calcTotalDamage(getEventTimeList()));
        for (AttackSkill attackSkill : attackSkillList) {
            attackSkill.setUseCountStr(attackSkill.getUseCountStr() + "전체 : " + attackSkill.getUseCount());
            attackSkill.setCumulativeAttackCountStr(attackSkill.getCumulativeAttackCountStr() + "전체 : " + attackSkill.getCumulativeAttackCount());
            attackSkill.setShareStr(attackSkill.getShareStr() + "전체 : " + attackSkill.getShare());
        }
        setDPM(getTotalDamage() / 680 * 660);
        setRestraintRingDeal(calcRestraintRingDeal());
        setFortyDeal(calcFortyDeal());
        setOriginXRestraintRingDeal(calcOriginXRestraintDeal());
    }

    public void alphaCycle() {
        Timestamp cycleStartTime = new Timestamp(getStart().getTime());
        assistEndTime = new Timestamp(getStart().getTime() + 3000);
        if (
                getStart().after(assistNowTime)
                        || getStart().equals(assistNowTime)
        ) {
            assistNowTime = new Timestamp(getStart().getTime() + 60);
        }
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = 0;
        isEgoWeapon = true;
        addSkillEvent(timePieceCrystalOfTime);
        if (getStart().before(blessEndTime)) {
            spinCutter = new SpinCutter();
            spinCutter.setDelay(180L);
            spinCutter.setAssistSkill(new ThrowingWeapon());
            flashAssault.setCooldown(5.0);
            while (getStart().before(new Timestamp(assistEndTime.getTime() + 120))) {
                if (!cooldownCheck(flashAssault)) {
                    getStart().setTime(getStart().getTime() + 180);
                }
                addSkillEvent(flashAssault);
                addSkillEvent(spinCutter);
            }
            flashAssault.setCooldown(0.0);
        } else {
            addSkillEvent(flashAssault);
            spinCutter = new SpinCutter();
            spinCutter.setDelay(270L);
            spinCutter.setAssistSkill(new ThrowingWeapon());
            addSkillEvent(spinCutter);
            addSkillEvent(windCutter);
            addSkillEvent(windStrike);
            addSkillEvent(stormBreak);
            addSkillEvent(flashAssault);
            addSkillEvent(spinCutter);
            addSkillEvent(moonStrike);
            Timestamp comboEndTime = new Timestamp(getStart().getTime());
            addSkillEvent(windCutter);
            Timestamp tmp = new Timestamp(assistNowTime.getTime());
            assistNowTime = new Timestamp(getStart().getTime());
            getStart().setTime(tmp.getTime());
            if (comboEndTime.equals(getStart())) {
                getStart().setTime(getStart().getTime() + 90);
            }
        }
        addSkillEvent(tag);
        Timestamp cycleEndTime = new Timestamp(getStart().getTime());
        getSkillEventList().add(new SkillEvent(alpha, cycleStartTime, cycleEndTime));
    }

    public void betaCycle() {
        Timestamp cycleStartTime = new Timestamp(getStart().getTime());
        assistEndTime = new Timestamp(getStart().getTime() + 3000);
        if (
                getStart().after(assistNowTime)
                        || getStart().equals(assistNowTime)
        ) {
            assistNowTime = new Timestamp(getStart().getTime() + 60);
        }
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = 0;
        isEgoWeapon = true;
        addSkillEvent(timePieceCrystalOfTime);
        whirlWind = new WhirlWind();
        whirlWind.setDelay(90L);
        whirlWind.setAssistSkill(new RollingAssaulter());
        addSkillEvent(frontSlash);
        addSkillEvent(throwingWeapon);
        addSkillEvent(turningDrive);
        addSkillEvent(whirlWind);
        addSkillEvent(frontSlash);
        addSkillEvent(throwingWeapon);
        addSkillEvent(turningDrive);
        addSkillEvent(whirlWind);
        addSkillEvent(frontSlash);
        Timestamp comboEndTime = new Timestamp(getStart().getTime());
        addSkillEvent(throwingWeapon);
        assistNowTime = new Timestamp(assistNowTime.getTime() + 450);
        Timestamp tmp = new Timestamp(assistNowTime.getTime());
        assistNowTime = new Timestamp(getStart().getTime());
        getStart().setTime(tmp.getTime());
        if (comboEndTime.equals(getStart())) {
            getStart().setTime(getStart().getTime() + 30);
        }
        addSkillEvent(tag);
        Timestamp cycleEndTime = new Timestamp(getStart().getTime());
        getSkillEventList().add(new SkillEvent(alpha, cycleStartTime, cycleEndTime));
    }

    public void alphaCancelCycle(Skill skill) {
        Timestamp cycleStartTime = new Timestamp(getStart().getTime());
        assistEndTime = new Timestamp(getStart().getTime() + 3000);
        if (
                getStart().after(assistNowTime)
                        || getStart().equals(assistNowTime)
        ) {
            assistNowTime = new Timestamp(getStart().getTime() + 60);
        }
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = 0;
        isEgoWeapon = true;
        addSkillEvent(timePieceCrystalOfTime);
        if (getStart().before(new Timestamp(blessEndTime.getTime() - 1000))) {
            spinCutter = new SpinCutter();
            spinCutter.setDelay(180L);
            spinCutter.setAssistSkill(new ThrowingWeapon());
            flashAssault.setCooldown(5.0);
            while (getStart().before(new Timestamp(assistEndTime.getTime() - 200))) {
                if (!cooldownCheck(flashAssault)) {
                    getStart().setTime(getStart().getTime() + 180);
                }
                addSkillEvent(flashAssault);
                addSkillEvent(spinCutter);
            }
            addSkillEvent(skill);
            Timestamp tmp = new Timestamp(assistNowTime.getTime());
            assistNowTime = new Timestamp(getStart().getTime());
            getStart().setTime(tmp.getTime());
            if (getStart().before(new Timestamp(assistEndTime.getTime() + 120))) {
                getStart().setTime(assistEndTime.getTime() + 120);
            }
            flashAssault.setCooldown(0.0);
        } else {
            addSkillEvent(flashAssault);
            spinCutter = new SpinCutter();
            spinCutter.setDelay(270L);
            spinCutter.setAssistSkill(new ThrowingWeapon());
            addSkillEvent(spinCutter);
            addSkillEvent(windCutter);
            addSkillEvent(windStrike);
            addSkillEvent(stormBreak);
            addSkillEvent(flashAssault);
            addSkillEvent(spinCutter);
            moonStrike = new MoonStrike();
            moonStrike.setDelay(390L);
            moonStrike.setAssistSkill(new UpperSlash());
            addSkillEvent(moonStrike);
            if (skill instanceof TranscendentLife) {
                skill.getRelatedSkill().getRelatedSkill().setDelay(90L);
            } else {
                skill.setDelay(90L);
            }
            Timestamp comboEndTime = new Timestamp(getStart().getTime());
            addSkillEvent(skill);
            Timestamp tmp = new Timestamp(assistNowTime.getTime());
            assistNowTime = new Timestamp(getStart().getTime());
            getStart().setTime(tmp.getTime());
            if (comboEndTime.equals(getStart())) {
                getStart().setTime(getStart().getTime() + 90);
            }
        }
        addSkillEvent(tag);
        Timestamp cycleEndTime = new Timestamp(getStart().getTime());
        getSkillEventList().add(new SkillEvent(alpha, cycleStartTime, cycleEndTime));
    }

    public void betaCancelCycle(Skill skill) {
        Timestamp cycleStartTime = new Timestamp(getStart().getTime());
        assistEndTime = new Timestamp(getStart().getTime() + 3000);
        if (
                getStart().after(assistNowTime)
                        || getStart().equals(assistNowTime)
        ) {
            assistNowTime = new Timestamp(getStart().getTime() + 60);
        }
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = 0;
        isEgoWeapon = true;
        addSkillEvent(timePieceCrystalOfTime);
        whirlWind = new WhirlWind();
        whirlWind.setDelay(90L);
        whirlWind.setAssistSkill(new RollingAssaulter());
        addSkillEvent(turningDrive);
        addSkillEvent(whirlWind);
        addSkillEvent(frontSlash);
        addSkillEvent(throwingWeapon);
        addSkillEvent(turningDrive);
        addSkillEvent(whirlWind);
        addSkillEvent(frontSlash);
        addSkillEvent(throwingWeapon);
        Timestamp comboEndTime = new Timestamp(getStart().getTime());
        addSkillEvent(skill);
        Timestamp tmp = new Timestamp(assistNowTime.getTime());
        assistNowTime = new Timestamp(getStart().getTime());
        getStart().setTime(tmp.getTime());
        if (comboEndTime.equals(getStart())) {
            getStart().setTime(getStart().getTime() + 30);
        }
        if (getStart().before(new Timestamp(assistEndTime.getTime() + 120))) {
            getStart().setTime(assistEndTime.getTime() + 120);
        }
        addSkillEvent(tag);
        Timestamp cycleEndTime = new Timestamp(getStart().getTime());
        getSkillEventList().add(new SkillEvent(alpha, cycleStartTime, cycleEndTime));
    }

    public void jointAttackCancelCycle(Skill skill) {
        Timestamp cycleStartTime = new Timestamp(getStart().getTime());
        assistEndTime = new Timestamp(getStart().getTime() + 3000);
        if (
                getStart().after(assistNowTime)
                        || getStart().equals(assistNowTime)
        ) {
            assistNowTime = new Timestamp(getStart().getTime() + 60);
        }
        timePieceCrystalOfTime.setMultiAttackByCnt(timePieceCnt);
        timePieceCnt = 0;
        isEgoWeapon = true;
        addSkillEvent(timePieceCrystalOfTime);
        addSkillEvent(turningDrive);
        whirlWind = new WhirlWind();
        whirlWind.setDelay(90L);
        whirlWind.setAssistSkill(new RollingAssaulter());
        addSkillEvent(whirlWind);
        addSkillEvent(gigaCrash);
        addSkillEvent(jumpingCrash);
        addSkillEvent(earthBreak);
        addSkillEvent(jointAttack1);
        addSkillEvent(skill);
        Timestamp cycleEndTime = new Timestamp(getStart().getTime());
        getSkillEventList().add(new SkillEvent(alpha, cycleStartTime, cycleEndTime));
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof TranscendentRhinneBless) {
                blessEndTime = new Timestamp(getStart().getTime() + 3000 + 45000);
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
                timeDistotion.setActivateTime(new Timestamp(-1));
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
                if (skill instanceof BodyOfSteel) {
                    for (long i = 0; i < 21000; i += 1000) {
                        getSkillEventList().add(new SkillEvent(new BodyOfSteel(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 1000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
                    }
                }
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (skill instanceof FlashAssault) {
                applyCooldown(skill);
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
                    && !(skill instanceof TimePieceCrystalOfTime)
            ) {
                isEgoWeapon = true;
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
                    && !(skill instanceof TimePieceCrystalOfTime)
            ) {
                addSkillEvent(egoWeaponBeta);
            }
            if (
                    getStart().before(blessEndTime)
                            && isExtraAttack
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
                                    || skill instanceof EgoWeaponBeta
                                    || skill instanceof EgoWeaponAlpha
                                    || skill instanceof RollingAssaulterBlade
                                    || skill instanceof RollingCurveBlade
                                    || skill instanceof ShadowStrikeBlade
                                    || skill instanceof SpinCutterBlade
                                    || skill instanceof TimePieceCrystalOfTime
                                    || skill instanceof LightSphere
                    )
            ) {
                isExtraAttack = false;
                isEgoWeapon = false;
                extraAttackTime = new Timestamp(getStart().getTime());
                addSkillEvent(extraAttack);
                flashAssault.setActivateTime(new Timestamp(flashAssault.getActivateTime().getTime() - 4000));
            }
            if (
                    getStart().before(blessEndTime)
                            && !getStart().equals(extraAttackTime)
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
                isExtraAttack = true;
            }
            if (
                    skill instanceof AssistSkill
                            && getStart().before(assistEndTime)
            ) {
                if (((AssistSkill) skill).getAssistSkill() != null) {
                    addAssistSkillEvent(skill, false);
                }
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
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                            && !(skillEvent.getSkill() instanceof AssistSkill)
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
                if (skill instanceof WhirlWind) {
                    if (skill.getDelay() == 60) {
                        ((WhirlWind) skill).setDamage(0.0);
                    } else {
                        ((WhirlWind) skill).setDamage(365.0);
                    }
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                if (skill instanceof RollingCurveBlade) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 50) {
                        RollingCurveBlade tmp = new RollingCurveBlade();
                        tmp.addFinalDamage(0.7);
                        getSkillEventList().add(new SkillEvent(tmp, new Timestamp(assistNowTime.getTime()), endTime));
                    }
                }
                if (skill instanceof RollingAssaulterBlade) {
                    RollingAssaulterBlade tmp = new RollingAssaulterBlade();
                    tmp.addFinalDamage(0.7);
                    getSkillEventList().add(new SkillEvent(tmp, new Timestamp(assistNowTime.getTime()), endTime));
                }
            }
        }
        if (!(skill instanceof FlashAssault)) {
            applyCooldown(skill);
        }
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (
                getStart().before(blessEndTime)
                        && isExtraAttack
                        && isEgoWeapon
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
                                || skill instanceof EgoWeaponBeta
                                || skill instanceof EgoWeaponAlpha
                                || skill instanceof RollingAssaulterBlade
                                || skill instanceof RollingCurveBlade
                                || skill instanceof ShadowStrikeBlade
                                || skill instanceof SpinCutterBlade
                                || skill instanceof TimePieceCrystalOfTime
                                || skill instanceof LightSphere
                )
        ) {
            isExtraAttack = false;
            isEgoWeapon = false;
            addSkillEvent(extraAttack);
            flashAssault.setActivateTime(new Timestamp(flashAssault.getActivateTime().getTime() - 4000));
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
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
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
