package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.attackskill.viper.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.viper.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ViperContinuousDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EnergyOrb());
            add(new FinalAttackViper());
            add(new FistEnrage());
            add(new FuriosCharge());
            add(new FuriosCharge4());
            add(new HowlingFistBeforeDelay());
            add(new HowlingFist());
            add(new HowlingFistShock());
            add(new LiberateNeptunus());
            add(new LiberateNeptunusEnrage1());
            add(new LiberateNeptunusEnrage2());
            add(new LiberateNeptunusEnrage3());
            add(new LiberateNeptunusEnrage4());
            add(new LiberateNeptunusEnrage5());
            add(new LiberateNeptunusFuryOfTheSea());
            add(new ScrewPunch());
            add(new SeaSerpentEnrage());
            add(new SerpentAssaultEnrage());
            add(new SerpentScrew());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SuperFistEnrage());
            add(new SuperFistEnrageShockWave());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ContinuousRing());
            add(new EpicAdventure());
            add(new LiberateNeptunusBuff());
            add(new LightningForm());
            add(new LuckyDice());
            //add(new LuckyDiceOneMoreChance());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new PirateFlag());
            add(new SeaSerpentEnrageBuff());
            add(new SoulContract());
            add(new Stimulate());
            add(new TimeLeap());
        }
    };

    boolean isNuke = false;

    Long serpentStoneCount = 3L;

    Timestamp liberateNeptunusEndTime = new Timestamp(-1);
    Timestamp stimulateEndTime = new Timestamp(0);
    Timestamp superEndTime = new Timestamp(0);

    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    EnergyOrb energyOrb = new EnergyOrb();
    EpicAdventure epicAdventure = new EpicAdventure();
    FistEnrage fistEnrage = new FistEnrage();
    FuriosCharge furiosCharge = new FuriosCharge();
    FuriosCharge4 furiosCharge4 = new FuriosCharge4();
    HowlingFist howlingFist = new HowlingFist();
    LiberateNeptunus liberateNeptunus = new LiberateNeptunus();
    LiberateNeptunusEnrage1 liberateNeptunusEnrage1 = new LiberateNeptunusEnrage1();
    LightningForm lightningForm = new LightningForm();
    LuckyDice luckyDice = new LuckyDice();
    LuckyDiceOneMoreChance luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    Overdrive overdrive = new Overdrive(255L);
    PirateFlag pirateFlag = new PirateFlag();
    ScrewPunch screwPunch = new ScrewPunch();
    SeaSerpentEnrage seaSerpentEnrage = new SeaSerpentEnrage();
    SerpentAssaultEnrage serpentAssaultEnrage = new SerpentAssaultEnrage();
    SerpentScrew serpentScrew = new SerpentScrew();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    Stimulate stimulate = new Stimulate();
    SuperFistEnrage superFistEnrage = new SuperFistEnrage();
    TimeLeap timeLeap = new TimeLeap();

    public ViperContinuousDealCycle(Job job) {
        super(job, new FinalAttackViper());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        mapleWorldGoddessBlessing.setCooldown(180.0);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());

        getSkillSequence1().add(stimulate);
        getSkillSequence1().add(lightningForm);
        getSkillSequence1().add(epicAdventure);             // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(overdrive);                 // 420
        getSkillSequence1().add(soulContract);              // 30

        getSkillSequence2().add(overdrive);                 // 420
        getSkillSequence2().add(soulContract);              // 30

        getSkillSequence3().add(luckyDice);

        getSkillSequence4().add(pirateFlag);

        stimulate.setDelay(160L);
        lightningForm.setDelay(160L);
        mapleWorldGoddessBlessing.setDelay(160L);

        luckyDice.setDelay(660L);

        pirateFlag.setDelay(660L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(serpentScrew)) {
                addSkillEvent(serpentScrew);
            }
            if (
                    luckyDice.getCooldown() == 0
                            && luckyDice.getBuffAttMagic() == 0
                            && luckyDice.getBuffDamage() == 20
            ) {
                luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
                luckyDice.setCooldown(luckyDiceOneMoreChance.getCooldown());
                luckyDice.setBuffDamage(luckyDiceOneMoreChance.getBuffDamage());
                luckyDice.setBuffAttMagic(luckyDiceOneMoreChance.getBuffAttMagic());
                luckyDice.setDelay(660L);
                addSkillEvent(luckyDice);
            } else if (cooldownCheck(luckyDice)) {
                luckyDice = new LuckyDice();
                addSkillEvent(luckyDice);
            }
            if (cooldownCheck(pirateFlag)) {
                addSkillEvent(pirateFlag);
            }
            if (
                    cooldownCheck(lightningForm)
                    && (
                            serpentStoneCount == 2
                            || serpentStoneCount == 3
                    )
            ) {
                isNuke = true;
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(fistEnrage);
                if (cooldownCheck(liberateNeptunus)) {
                    addSkillEvent(liberateNeptunus);
                    addSkillEvent(fistEnrage);
                }
                addSkillEvent(energyOrb);
                addSkillEvent(energyOrb);
                addSkillEvent(energyOrb);
                addSkillEvent(fistEnrage);
                while (!cooldownCheck(howlingFist)) {
                    addSkillEvent(fistEnrage);
                }
                addSkillEvent(howlingFist);
                addSkillEvent(furiosCharge);
                isNuke = false;
            } else if (
                    cooldownCheck(howlingFist)
                    && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(fistEnrage);
                addSkillEvent(howlingFist);
                addSkillEvent(fistEnrage);
                addSkillEvent(furiosCharge);
            } else if (
                    cooldownCheck(furiosCharge4)
                            && getStart().before(new Timestamp(soulContract.getActivateTime().getTime() + 10000))
            ) {
                addSkillEvent(furiosCharge4);
            } else {
                addSkillEvent(fistEnrage);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Double ran = Math.random() * 99;
                if (ran <= getJob().getReuse()) {
                } else  {
                    if (skill instanceof SeaSerpentEnrage && getStart().before(stimulateEndTime)) {
                        skill.setCooldown(2.0);
                        skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                        skill.setCooldown(4.0);
                    } else {
                        skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                    }
                }
            } else {
                if (skill instanceof SeaSerpentEnrage && getStart().before(stimulateEndTime)) {
                    skill.setCooldown(2.0);
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                    skill.setCooldown(4.0);
                } else {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            }
            if (!skill.isApplyCooldownReduction()) {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + skill.getCooldown() * 1000)));
            }
        }
    }

    @Override
    public boolean cooldownCheck(List<Skill> skillList) {
        for (Skill s : skillList) {
            if (s instanceof SeaSerpentEnrage) {
                continue;
            }
            if (!(getStart().after(s.getActivateTime()) || getStart().equals(s.getActivateTime()))) {
                return false;
            }
        }
        return true;
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
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (
                cooldownCheck(liberateNeptunusEnrage1)
                && getStart().before(liberateNeptunusEndTime)
                && !(
                        skill instanceof LiberateNeptunusEnrage1
                        || skill instanceof LiberateNeptunusEnrage2
                        || skill instanceof LiberateNeptunusEnrage3
                        || skill instanceof LiberateNeptunusEnrage4
                        || skill instanceof LiberateNeptunusEnrage5
                )
        ) {
            addSkillEvent(liberateNeptunusEnrage1);
        }
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
            if (skill instanceof Stimulate) {
                stimulateEndTime = new Timestamp(getStart().getTime() + 3000 + 90000);
            }
            if (skill instanceof LiberateNeptunusBuff) {
                liberateNeptunusEndTime = new Timestamp(getStart().getTime() + 30000);
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
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof EnergyOrb
                            || skill instanceof FistEnrage
                            || skill instanceof FuriosCharge
                            || skill instanceof FuriosCharge4
                            || skill instanceof ScrewPunch
                            || skill instanceof SuperFistEnrage
                            || skill instanceof SuperFistEnrageShockWave
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof FistEnrage
                    && getStart().before(superEndTime)
            ) {
                skill = superFistEnrage;
            }
            if (
                    skill instanceof FistEnrage
                    || skill instanceof SuperFistEnrage
            ) {
                if (serpentStoneCount == 5) {
                    addSkillEvent(serpentAssaultEnrage);
                    superEndTime = new Timestamp(getStart().getTime() + 13000);
                    serpentStoneCount = 0L;
                } else if (cooldownCheck(seaSerpentEnrage)) {
                    addSkillEvent(seaSerpentEnrage);
                    serpentStoneCount += 1;
                }
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (skill instanceof EnergyOrb) {
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
                    if (skill instanceof SerpentAssaultEnrage) {
                        i = 1080;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                        if (skill instanceof HowlingFist) {
                            Timestamp now = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
                            }
                            getStart().setTime(now.getTime());
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
        applyCooldown(skill);
        if (skill instanceof FuriosCharge) {
            applyCooldown(furiosCharge4);
        } else if (skill instanceof FuriosCharge4) {
            applyCooldown(furiosCharge);
        }
        getEventTimeList().add(new Timestamp(getStart().getTime()));
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        if (
                cooldownCheck(screwPunch)
                && skill.getDelay() != 0
                && (
                        skill instanceof LightningForm
                        || skill instanceof SerpentScrew
                        || skill instanceof HowlingFistShock
                        || skill instanceof Stimulate
                        || skill instanceof MapleWorldGoddessBlessing
                        || skill instanceof SpiderInMirror
                        || skill instanceof PirateFlag
                        || skill instanceof CrestOfTheSolar
                        || skill instanceof TimeLeap
                )
        ) {
            endTime = new Timestamp(getStart().getTime() + screwPunch.getDelay());
            getSkillEventList().add(new SkillEvent(screwPunch, new Timestamp(getStart().getTime()), endTime));
            getEventTimeList().add(endTime);
            applyCooldown(screwPunch);
            getStart().setTime(getStart().getTime() + screwPunch.getDelay());
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
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    skill instanceof HowlingFistShock
                    || skill instanceof LiberateNeptunus
                    || skill instanceof LiberateNeptunusFuryOfTheSea
            ) {
                Timestamp now = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                getStart().setTime(now.getTime());
            }
        }
    }
}
