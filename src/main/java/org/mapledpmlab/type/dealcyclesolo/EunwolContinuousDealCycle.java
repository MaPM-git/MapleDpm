package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
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

public class EunwolContinuousDealCycle extends DealCycle {
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
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BladeImpBuff());
            add(new ContinuousRing());
            add(new DivisionSoulBuff());
            add(new EunwolHyper());
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

    boolean isNuke = false;

    Timestamp cancelRestraintRingEndTime = new Timestamp(-1);
    Timestamp eunwolHyperEndTime = new Timestamp(-1);

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

    public EunwolContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        mapleWorldGoddessBlessing.setCooldown(120.0);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(loadedDice)) {
                addSkillEvent(loadedDice);
            }
            if (cooldownCheck(soulTent)) {
                addSkillEvent(soulTent);
            }
            if (
                    cooldownCheck(heroesOath)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(lightOfTheFoxGoddess)
                            && cooldownCheck(eunwolHyper)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                isNuke = true;
                addSkillEvent(bladeImp);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(heroesOath);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    if (cooldownCheck(spiritClawTrue)) {
                        addSkillEvent(spiritClawTrue);
                    } else {
                        addSkillEvent(spiritClaw);
                    }
                }
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(divisionSoul);
                addSkillEvent(lightOfTheFoxGoddess);
                addSkillEvent(soulContract);
                addSkillEvent(eunwolHyper);
                addSkillEvent(ghostDisposition);
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
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(divisionSoul);
                addSkillEvent(ghostDisposition);
                addSkillEvent(chainBombPunch);
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
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof BladeImp
                    || skill instanceof DivisionSoul
                    || skill instanceof SpiritClaw
                    || skill instanceof SpiritClawTrue
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
