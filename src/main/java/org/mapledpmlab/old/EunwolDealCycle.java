package org.mapledpmlab.old;

import org.mapledpmlab.old.skill.attackskill.eunwol.*;
import org.mapledpmlab.old.skill.attackskill.eunwol.*;
import org.mapledpmlab.old.skill.buffskill.eunwol.*;
import org.mapledpmlab.old.skill.buffskill.eunwol.*;
import org.mapledpmlab.type.dealcycle.DealCycle;
import org.mapledpmlab.type.dealcycle.SkillEvent;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EunwolDealCycle extends DealCycle {

    // 메용2, 6차, 리레, 스인미, 크오솔
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private final List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private final List<Skill> dealCycle4 = new ArrayList<>();

    // 웨폰퍼프
    private final List<Skill> dealCycle5 = new ArrayList<>();

    // 60초
    private final List<Skill> shortDealCycle = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdventOfTheFox());
            add(new BladeImpDownward());
            add(new BladeImpForward());
            add(new BladeImpSpin());
            add(new BladeImpSpinInstall());
            add(new BombPunch());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DeathMark());
            add(new DeathMarkDot());
            add(new FoxGodAvatar());
            add(new FoxGodClaw1());
            add(new FoxGodClaw2());
            add(new FoxGodClaw3());
            add(new FoxSpirit());
            add(new FoxSpiritOrb());
            add(new GroundPound());
            add(new LiverCircleDance());
            add(new ShockwavePunch1());
            add(new ShockwavePunch2());
            add(new ShockwavePunch3());
            add(new SmashingMultipunch());
            add(new SmashingMultipunchEnd());
            add(new SoulSplitter());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SpiritClaw());
            add(new SpiritClawInstall());
            add(new SpiritFrenzy());
            add(new SpiritFrenzy6th());
            add(new SpiritFrenzyInstall());
            add(new SpiritFrenzySpiritBondMax());
            add(new SpiritFrenzySpiritConcentration());
            add(new SpiritGate());
            add(new SpiritIncarnation());
            add(new TrueSpiritClaw());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new SmashingMultipunchFirstDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AdventOfTheFoxBuff());
            add(new BladeImpBuff());
            add(new HeroesOath());
            add(new LoadedDice());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(249L));
            add(new OverdriveDebuff(249L));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SoulSplitterBuff());
            add(new SpiritConcentration());
            add(new SpiritGateBuff());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    private final List<AttackSkill> spiritConcentrationAttackSkillList = new ArrayList<>(){
        {
            add(new BladeImpDownward());
            add(new BladeImpForward());
            add(new BladeImpSpinInstall());
            add(new BombPunch());
            add(new DeathMark());
            add(new GroundPound());
            add(new ShockwavePunch1());
            add(new SpiritClawInstall());
            add(new SpiritFrenzyInstall());
            add(new SpiritIncarnation());
        }
    };

    FoxGodAvatar foxGodAvatar = new FoxGodAvatar();
    FoxSpirit foxSpirit = new FoxSpirit();
    FoxSpiritOrb foxSpiritOrb = new FoxSpiritOrb();
    SoulConcentrationAutoCool soulConcentrationAutoCool = new SoulConcentrationAutoCool();
    SpiritFrenzy spiritFrenzy = new SpiritFrenzy();
    SpiritFrenzy6th spiritFrenzy6th = new SpiritFrenzy6th();
    SpiritFrenzySpiritConcentration spiritFrenzySpiritConcentration = new SpiritFrenzySpiritConcentration();
    TrueSpiritClaw trueSpiritClaw = new TrueSpiritClaw();

    Timestamp adventOfTheFoxEndTime = new Timestamp(-1);
    Timestamp spiritConcentrationEndTime = new Timestamp(-1);

    public EunwolDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AdventOfTheFox adventOfTheFox = new AdventOfTheFox();
        BladeImpSpin bladeImpSpin = new BladeImpSpin();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        FoxGodClaw1 foxGodClaw1 = new FoxGodClaw1();
        HeroesOath heroesOath = new HeroesOath();
        LiverCircleDance liverCircleDance = new LiverCircleDance();
        LoadedDice loadedDice = new LoadedDice();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        Overdrive overdrive = new Overdrive(249L);
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SmashingMultipunchFirstDelay smashingMultipunchFirstDelay = new SmashingMultipunchFirstDelay();
        SoulContract soulContract = new SoulContract();
        SoulSplitter soulSplitter = new SoulSplitter();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiritClaw spiritClaw = new SpiritClaw();
        SpiritConcentration spiritConcentration = new SpiritConcentration();
        SpiritFrenzySpiritBondMax spiritFrenzySpiritBondMax = new SpiritFrenzySpiritBondMax();
        SpiritGate spiritGate = new SpiritGate();
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

        for (int i = 6100; i < 720 * 1000; i += applyCooldownReduction(spiritFrenzySpiritBondMax) * 1000) {
            getSkillEventList().add(new SkillEvent(spiritFrenzySpiritBondMax, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 6000; i < 720 * 1000; i += applyCooldownReduction(liverCircleDance) * 1000) {
            getSkillEventList().add(new SkillEvent(liverCircleDance, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        // 1-4-3-2-5-4
        // 메용2, 6차, 리레, 스인미, 크오솔
        dealCycle1.add(bladeImpSpin);
        dealCycle1.add(spiritGate);
        dealCycle1.add(heroesOath);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(soulContract);
        dealCycle1.add(spiritConcentration);
        dealCycle1.add(overdrive);
        dealCycle1.add(adventOfTheFox);
        dealCycle1.add(restraintRing);
        dealCycle1.add(soulSplitter);
        dealCycle1.add(spiritFrenzy6th);
        dealCycle1.add(smashingMultipunchFirstDelay);

        // 메용2, 6차, 웨폰퍼프
        dealCycle2.add(bladeImpSpin);
        dealCycle2.add(spiritGate);
        dealCycle2.add(heroesOath);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(soulContract);
        dealCycle2.add(spiritConcentration);
        dealCycle2.add(overdrive);
        dealCycle2.add(adventOfTheFox);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(soulSplitter);
        dealCycle2.add(spiritFrenzy6th);
        dealCycle2.add(smashingMultipunchFirstDelay);

        // 메용2, 리레, 스인미, 코오솔
        dealCycle3.add(bladeImpSpin);
        dealCycle3.add(spiritGate);
        dealCycle3.add(heroesOath);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(soulContract);
        dealCycle3.add(spiritConcentration);
        dealCycle3.add(overdrive);
        dealCycle3.add(restraintRing);
        dealCycle3.add(soulSplitter);
        dealCycle3.add(smashingMultipunchFirstDelay);
        dealCycle3.add(spiritFrenzySpiritConcentration);

        // 메용2, 웨폰퍼프
        dealCycle4.add(bladeImpSpin);
        dealCycle4.add(spiritGate);
        dealCycle4.add(heroesOath);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(soulContract);
        dealCycle4.add(spiritConcentration);
        dealCycle4.add(overdrive);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(soulSplitter);
        dealCycle4.add(smashingMultipunchFirstDelay);
        dealCycle4.add(spiritFrenzySpiritConcentration);

        // 리레
        dealCycle5.add(bladeImpSpin);
        dealCycle5.add(spiritGate);
        dealCycle5.add(heroesOath);
        dealCycle5.add(crestOfTheSolar);
        dealCycle5.add(spiderInMirror);
        dealCycle5.add(soulContract);
        dealCycle5.add(spiritConcentration);
        dealCycle5.add(overdrive);
        dealCycle5.add(restraintRing);
        dealCycle5.add(soulSplitter);
        dealCycle5.add(smashingMultipunchFirstDelay);
        dealCycle5.add(spiritFrenzySpiritConcentration);

        shortDealCycle.add(bladeImpSpin);
        shortDealCycle.add(spiritGate);
        shortDealCycle.add(overdrive);
        shortDealCycle.add(smashingMultipunchFirstDelay);

        addSkillEvent(loadedDice);

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(loadedDice)) {
                addSkillEvent(loadedDice);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 1
            ) {
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
            ) {
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 3
            ) {
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 5
            ) {
                addDealCycle(dealCycle5);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(shortDealCycle)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                if (cooldownCheck(soulContract)) {
                    addSkillEvent(soulContract);
                }
                addDealCycle(shortDealCycle);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    getStart().before(adventOfTheFoxEndTime)
            ) {
                addSkillEvent(foxGodClaw1);
            } else if (
                    cooldownCheck(spiritFrenzy)
                    && getStart().before(new Timestamp(trueSpiritClaw.getActivateTime().getTime() - 3180))
                    && getStart().before(new Timestamp(heroesOath.getActivateTime().getTime() - 15000))
            ) {
                addSkillEvent(spiritFrenzy);
            } else {
                if (cooldownCheck(trueSpiritClaw)) {
                    addSkillEvent(trueSpiritClaw);
                } else {
                    addSkillEvent(spiritClaw);
                }
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
            if (skill instanceof SpiritConcentration) {
                spiritFrenzy.setActivateTime(new Timestamp(-1));
                spiritFrenzy6th.setActivateTime(new Timestamp(-1));
                spiritFrenzySpiritConcentration.setActivateTime(new Timestamp(-1));
                spiritConcentrationEndTime = new Timestamp(getStart().getTime() + 90000);
            } else if (skill instanceof AdventOfTheFoxBuff) {
                adventOfTheFoxEndTime = new Timestamp(getStart().getTime() + 40000);
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
                if (skill instanceof SpiritGateBuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 2000), endTime));
                } else {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
            if (
                    skill instanceof FoxGodClaw1
                    || skill instanceof FoxGodClaw2
                    || skill instanceof FoxGodClaw3
            ) {
                if (cooldownCheck(foxGodAvatar)) {
                    addSkillEvent(foxGodAvatar);
                }
            }
            if (
                    getStart().before(spiritConcentrationEndTime)
                    && cooldownCheck(soulConcentrationAutoCool)
            ) {
                applyCooldown(soulConcentrationAutoCool);
                Long ran = (long) (Math.random() * spiritConcentrationAttackSkillList.size());
                addSkillEvent(spiritConcentrationAttackSkillList.get(Math.toIntExact(ran)));
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
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                        /*if (skill instanceof SpiritGate) {
                            getSkillEventList().add(new SkillEvent(new SpiritGateBuff(), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 8000)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        }*/
                        if (skill instanceof SmashingMultipunch) {
                            Timestamp tmpTime = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (getStart().before(adventOfTheFoxEndTime)) {
                                addSkillEvent(foxSpiritOrb);
                            } else {
                                addSkillEvent(foxSpirit);
                            }
                            getStart().setTime(tmpTime.getTime());
                        } else if (
                                !(skill instanceof CrestOfTheSolarDot)
                                && !(skill instanceof DeathMarkDot)
                                && !(skill instanceof SpiderInMirrorDot)
                        ) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= foxSpirit.getProp()) {
                                Timestamp tmpTime = new Timestamp(getStart().getTime());
                                getStart().setTime(getStart().getTime() + i);
                                if (getStart().before(adventOfTheFoxEndTime)) {
                                    addSkillEvent(foxSpiritOrb);
                                } else {
                                    addSkillEvent(foxSpirit);
                                }
                                getStart().setTime(tmpTime.getTime());
                            }
                        }
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
        if (skill instanceof TrueSpiritClaw) {
            applyCooldown(foxGodAvatar);
        } else if (skill instanceof FoxGodAvatar) {
            applyCooldown(trueSpiritClaw);
        }
        applyCooldown(skill);
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill instanceof SpiritFrenzy) {
            applyCooldown(skill);
            spiritFrenzy6th.setActivateTime(skill.getActivateTime());
            spiritFrenzySpiritConcentration.setActivateTime(skill.getActivateTime());
        } else if (skill instanceof  SpiritFrenzy6th) {
            applyCooldown(skill);
            spiritFrenzy.setActivateTime(skill.getActivateTime());
            spiritFrenzySpiritConcentration.setActivateTime(skill.getActivateTime());
        } else if (skill instanceof SpiritFrenzySpiritConcentration) {
            applyCooldown(skill);
            spiritFrenzy.setActivateTime(skill.getActivateTime());
            spiritFrenzy6th.setActivateTime(skill.getActivateTime());
        }
        if (
                skill instanceof BladeImpSpin
                || skill instanceof SoulSplitter
                || skill instanceof SpiritClaw
                || skill instanceof TrueSpiritClaw
                || skill instanceof BladeImpDownward
                || skill instanceof FoxGodAvatar
                || skill instanceof BladeImpForward
                || skill instanceof BladeImpSpinInstall
                || skill instanceof BombPunch
                || skill instanceof DeathMark
                || skill instanceof FoxGodClaw1
                || skill instanceof FoxGodClaw2
                || skill instanceof FoxGodClaw3
                || skill instanceof GroundPound
                || skill instanceof ShockwavePunch1
                || skill instanceof ShockwavePunch2
                || skill instanceof ShockwavePunch3
                || skill instanceof SpiritClawInstall
        ) {
            Long ran = (long) (Math.random() * 99 + 1);
            if (ran <= foxSpirit.getProp()) {
                if (getStart().before(adventOfTheFoxEndTime)) {
                    if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                        for (int i = 0; i < ((AttackSkill) skill).getMultiAttackInfo().size(); i++) {
                            addSkillEvent(foxSpiritOrb);
                        }
                    } else {
                        addSkillEvent(foxSpiritOrb);
                    }
                } else {
                    if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                        for (int i = 0; i < ((AttackSkill) skill).getMultiAttackInfo().size(); i++) {
                            addSkillEvent(foxSpirit);
                        }
                    } else {
                        addSkillEvent(foxSpirit);
                    }
                }
            }
        }
        if (
                skill instanceof FoxGodAvatar
        ) {
            for (int i = 0; i < 6; i++) {
                addSkillEvent(foxSpiritOrb);
            }
        }
        if (skill instanceof SmashingMultipunchEnd) {
            if (getStart().before(adventOfTheFoxEndTime)) {
                for (int j = 0; j < 16; j++) {
                    addSkillEvent(foxSpiritOrb);
                }
            } else {
                for (int j = 0; j < 16; j++) {
                    addSkillEvent(foxSpirit);
                }
            }
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Long ran = (long) (Math.random() * 99 + 1);
            if (
                    ran <= foxSpirit.getProp()
                    && !(skill instanceof FoxSpirit)
                    && !(skill instanceof FoxSpiritOrb)
            ) {
                Timestamp tmpTime = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (getStart().before(adventOfTheFoxEndTime)) {
                    addSkillEvent(foxSpiritOrb);
                } else {
                    addSkillEvent(foxSpirit);
                }
                getStart().setTime(tmpTime.getTime());
            }
        }
    }

    @Override
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            Timestamp activateTime = new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000));
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= getJob().getReuse()) {
                } else if (
                        skill instanceof SpiritFrenzy
                        || skill instanceof SpiritFrenzy6th
                        || skill instanceof SpiritFrenzySpiritConcentration
                ) {
                    skill.setActivateTime(new Timestamp(activateTime.getTime() + 5040));
                } else  {
                    skill.setActivateTime(activateTime);
                }
            } else {
                skill.setActivateTime(activateTime);
            }
            if (!skill.isApplyCooldownReduction()) {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + skill.getCooldown() * 1000)));
            }
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
}
