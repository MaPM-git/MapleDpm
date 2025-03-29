package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.attackskill.eunwol.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.eunwol.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class EunwolContinuousCancelDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdventOfTheFox1());
            add(new AdventOfTheFox2());
            add(new AdventOfTheFox3());
            add(new BackStep());
            add(new BladeImp());
            add(new ChainBombPunchPre());
            add(new ChainBombPunchKeydown());
            add(new ChainBombPunchEnd());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DivisionSoul());
            add(new FoxSoul());
            add(new FoxSoulOrb());
            add(new FoxSun());
            add(new GhostDispositionAttack());
            add(new GhostDispositionDarkness());
            add(new LightOfTheFoxGoddessAlterEgo());
            add(new SoulTent());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SpiritClaw());
            add(new SpiritClawTrue());
            add(new SpritPunch1());
            add(new SpritPunch2());
            add(new SpritPunch3());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BladeImpBuff());
            add(new ContinuousRing());
            add(new DivisionSoulBuff());
            add(new EunwolHyper());
            add(new FreudBlessing1());
            add(new FreudBlessing2());
            add(new FreudBlessing3());
            add(new FreudBlessing4());
            add(new FreudBlessing5());
            add(new FreudBlessing6());
            add(new GhostDispositionBuff());
            add(new HeroesOath());
            add(new LightOfTheFoxGoddess());
            add(new LoadedDice());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new SoulContract());
        }
    };

    int freudStack = 0;

    boolean isNuke = false;
    boolean isNoContinuousSpiritPunch = false;

    Timestamp cancelRestraintRingEndTime = new Timestamp(-1);
    Timestamp eunwolHyperEndTime = new Timestamp(-1);
    Timestamp continuousRingEndTime = new Timestamp(-1);

    AdventOfTheFox1 adventOfTheFox = new AdventOfTheFox1();
    BackStep backStep = new BackStep();
    BladeImpBuff bladeImp = new BladeImpBuff();
    ChainBombPunchPre chainBombPunch = new ChainBombPunchPre();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DivisionSoulBuff divisionSoul = new DivisionSoulBuff();
    EunwolHyper eunwolHyper = new EunwolHyper();
    FoxSoul foxSoul = new FoxSoul();
    FoxSoulOrb foxSoulOrb = new FoxSoulOrb();
    FreudBlessing1 freudBlessing1 = new FreudBlessing1();
    FreudBlessing2 freudBlessing2 = new FreudBlessing2();
    FreudBlessing3 freudBlessing3 = new FreudBlessing3();
    FreudBlessing4 freudBlessing4 = new FreudBlessing4();
    FreudBlessing5 freudBlessing5 = new FreudBlessing5();
    FreudBlessing6 freudBlessing6 = new FreudBlessing6();
    GhostDispositionBuff ghostDisposition = new GhostDispositionBuff();
    HeroesOath heroesOath = new HeroesOath();
    LightOfTheFoxGoddess lightOfTheFoxGoddess = new LightOfTheFoxGoddess();
    LoadedDice loadedDice = new LoadedDice();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    Overdrive overdrive = new Overdrive(255L);
    SoulContract soulContract = new SoulContract();
    SoulTent soulTent = new SoulTent();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SpiritClaw spiritClaw = new SpiritClaw();
    SpiritClawTrue spiritClawTrue = new SpiritClawTrue();
    SpritPunch1 spritPunch1 = new SpritPunch1();
    SpritPunch1 spritPunch1Cancel = new SpritPunch1();
    SpritPunch2 spritPunch2 = new SpritPunch2();

    public EunwolContinuousCancelDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        this.getJob().setName("은월(컨티, 캔슬)");

        mapleWorldGoddessBlessing.setCooldown(120.0);

        spritPunch2.setDelayByAttackSpeed(300L);

        spritPunch1Cancel.setRelatedSkill(new SpritPunch2());
        spritPunch1Cancel.setDelayByAttackSpeed(300L);
        spritPunch1Cancel.getRelatedSkill().setDelayByAttackSpeed(300L);

        getSkillSequence1().add(heroesOath);                // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(overdrive);                 // 420
        getSkillSequence1().add(eunwolHyper);               // 30
        getSkillSequence1().add(soulContract);              // 30

        getSkillSequence2().add(overdrive);                 // 420
        getSkillSequence2().add(soulContract);              // 30

        getSkillSequence3().add(loadedDice);
        loadedDice.setDelay(660L);

        mapleWorldGoddessBlessing.setDelay(480L);

        getStart().setTime(-25000);
        freudBlessing4.setActivateTime(new Timestamp(-30000));
        addSkillEvent(freudBlessing4);
        getStart().setTime(0);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(loadedDice)) {
                addSkillEvent(loadedDice);
            } else if (cooldownCheck(soulTent)) {
                addSkillEvent(soulTent);
            } else if (
                    cooldownCheck(freudBlessing1)
                            && freudStack == 6
                            && getStart().before(new Timestamp(7 * 60 * 1000))
            ) {
                addSkillEvent(freudBlessing1);
            } else if (
                    cooldownCheck(freudBlessing2)
                            && freudStack == 1
            ) {
                addSkillEvent(freudBlessing2);
            } else if (
                    cooldownCheck(freudBlessing3)
                            && freudStack == 2
            ) {
                addSkillEvent(freudBlessing3);
            } else if (
                    cooldownCheck(freudBlessing4)
                            && freudStack == 3
            ) {
                addSkillEvent(freudBlessing4);
            } else if (
                    cooldownCheck(freudBlessing6)
                            && freudStack == 5
                            && getStart().after(new Timestamp(freudBlessing6.getActivateTime().getTime() + 8000))
            ) {
                addSkillEvent(freudBlessing6);
            } else if (
                    cooldownCheck(heroesOath)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(lightOfTheFoxGoddess)
                            && cooldownCheck(eunwolHyper)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(bladeImp);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                if (freudStack == 4) {
                    while (!cooldownCheck(freudBlessing5)) {
                        if (cooldownCheck(spiritClawTrue)) {
                            addSkillEvent(spiritClawTrue);
                        } else {
                            addSkillEvent(spiritClaw);
                        }
                    }
                    addSkillEvent(freudBlessing5);
                }
                isNuke = true;
                addDealCycle(getSkillSequence1());
                addSkillEvent(divisionSoul);
                addSkillEvent(lightOfTheFoxGoddess);
                addSkillEvent(ghostDisposition);
                addSkillEvent(spritPunch1Cancel);
                addSkillEvent(chainBombPunch);
                if (cooldownCheck(spiritClawTrue)) {
                    addSkillEvent(spiritClawTrue);
                }
                if (cooldownCheck(adventOfTheFox)) {
                    addSkillEvent(adventOfTheFox);
                }
                dealCycleOrder ++;
                isNuke = false;
            } else if (
                    getStart().before(new Timestamp(690 * 1000))
                            && cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(divisionSoul)
                            && cooldownCheck(ghostDisposition)
                            && cooldownCheck(chainBombPunch)
                            && !cooldownCheck(heroesOath)
            ) {
                addDealCycle(getSkillSequence2());
                addSkillEvent(divisionSoul);
                addSkillEvent(ghostDisposition);
                addSkillEvent(chainBombPunch);
            } else if (
                    getStart().before(continuousRingEndTime)
                            && cooldownCheck(spritPunch1Cancel)
                            && getStart().before(new Timestamp(heroesOath.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(spritPunch1Cancel);
            } else if (
                    cooldownCheck(spritPunch1)
                            && getStart().before(new Timestamp(heroesOath.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(spritPunch1);
            } else if (
                    isNoContinuousSpiritPunch
                            && getStart().before(continuousRingEndTime)
            ) {
                addSkillEvent(spritPunch2);
                isNoContinuousSpiritPunch = false;
            } else if (cooldownCheck(spiritClawTrue)) {
                addSkillEvent(spiritClawTrue);
            } else {
                addSkillEvent(spiritClaw);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof FreudBlessing1) {
                freudStack = 1;
            } else if (skill instanceof FreudBlessing2) {
                freudStack = 2;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing1
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing3) {
                freudStack = 3;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing2
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing4) {
                freudStack = 4;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing3
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing5) {
                freudStack = 5;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing4
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing6) {
                freudStack = 6;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing5
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            }
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (skill instanceof LightOfTheFoxGoddess) {
                soulContract.setActivateTime(new Timestamp(-1));
            }
            if (skill instanceof EunwolHyper) {
                eunwolHyperEndTime = new Timestamp(getStart().getTime() + 33000);
            }
            if (skill instanceof RestraintRing) {
                cancelRestraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
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
                    cooldownCheck(continuousRing)
                            && (
                            skill instanceof BladeImp
                                    || skill instanceof DivisionSoul
                                    || skill instanceof SpiritClaw
                                    || skill instanceof SpiritClawTrue
                                    || skill instanceof CrestOfTheSolar
                                    || skill instanceof CrestOfTheSolarDot
                                    || skill instanceof SpiderInMirror
                                    || skill instanceof SpiderInMirrorDot
                                    || skill instanceof SpritPunch1
                                    || skill instanceof SpritPunch2
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof SpritPunch1
                            && skill.getRelatedSkill() == null
            ) {
                isNoContinuousSpiritPunch = true;
            }
            if (
                    skill instanceof BladeImp
                    || skill instanceof DivisionSoul
                    || skill instanceof SpiritClaw
                    || skill instanceof SpiritClawTrue
                            || skill instanceof SpritPunch1
                            || skill instanceof SpritPunch2
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (getStart().before(eunwolHyperEndTime)) {
                    if (ran <= foxSoulOrb.getProp()) {
                        addSkillEvent(foxSoulOrb);
                    }
                } else {
                    if (ran <= foxSoul.getProp()) {
                        addSkillEvent(foxSoul);
                    }
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
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        if (skill instanceof ChainBombPunchKeydown) {
                            Timestamp t = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 50) {
                                if (getStart().before(eunwolHyperEndTime)) {
                                    addSkillEvent(foxSoulOrb);
                                } else {
                                    addSkillEvent(foxSoul);
                                }
                            }
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
                            }
                            getStart().setTime(t.getTime());
                        }
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
        if (skill instanceof FreudBlessing1) {
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing1.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing2) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing3) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing4) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing5) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing6) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
        }
        if (skill instanceof SpritPunch1) {
            applyCooldown(spritPunch1);
            applyCooldown(spritPunch1Cancel);
        }
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        if (
                cooldownCheck(backStep)
                && (
                        skill instanceof BladeImp
                        || skill instanceof DivisionSoul
                        || skill instanceof GhostDispositionAttack
                        || skill instanceof LightOfTheFoxGoddessAlterEgo
                        || skill instanceof SoulTent
                        || skill instanceof SpiritClaw
                        || skill instanceof SpiritClawTrue
                        //|| skill instanceof LoadedDice
                        //|| skill instanceof OverdriveDebuff
                        //|| skill instanceof MapleWorldGoddessBlessing
                        || skill instanceof SpritPunch3
                                || skill instanceof FreudBlessing1
                                || skill instanceof FreudBlessing2
                                || skill instanceof FreudBlessing3
                                || skill instanceof FreudBlessing4
                                || skill instanceof FreudBlessing5
                                || skill instanceof FreudBlessing6
                )
                && getStart().after(cancelRestraintRingEndTime)
        ) {
            addSkillEvent(backStep);
        } else {
            getStart().setTime(getStart().getTime() + skill.getDelay());
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
            if (
                    skill instanceof LightOfTheFoxGoddessAlterEgo
                    || skill instanceof GhostDispositionAttack
                    || skill instanceof GhostDispositionDarkness
                    || skill instanceof ChainBombPunchEnd
                    || skill instanceof AdventOfTheFox1
                    || skill instanceof AdventOfTheFox2
                    || skill instanceof AdventOfTheFox3
                            || skill instanceof SpritPunch3
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                Timestamp tmp = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (getStart().before(eunwolHyperEndTime)) {
                    if (
                            skill instanceof ChainBombPunchEnd
                            && ran <= 50
                    ) {
                        addSkillEvent(foxSoulOrb);
                    } else if (ran <= foxSoulOrb.getProp()) {
                        addSkillEvent(foxSoulOrb);
                    }
                } else {
                    if (
                            skill instanceof ChainBombPunchEnd
                            && ran <= 50
                    ) {
                        addSkillEvent(foxSoul);
                    } else if (ran <= foxSoul.getProp()) {
                        addSkillEvent(foxSoul);
                    }
                }
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                getStart().setTime(tmp.getTime());
            }
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
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
