package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.viper.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.viper.LiberateNeptunusBuff;
import org.mapledpmlab.type.skill.buffskill.viper.LightningForm;
import org.mapledpmlab.type.skill.buffskill.viper.SeaSerpentEnrageBuff;
import org.mapledpmlab.type.skill.buffskill.viper.Stimulate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ViperDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EnergyOrb());
            add(new FinalAttackViper());
            add(new FistEnrage());
            add(new FuriosCharge());
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
            add(new EpicAdventure());
            add(new LiberateNeptunusBuff());
            add(new LightningForm());
            add(new LuckyDice());
            //add(new LuckyDiceOneMoreChance());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new PirateFlag());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SeaSerpentEnrageBuff());
            add(new SoulContract());
            add(new Stimulate());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Long serpentStoneCount = 3L;

    Timestamp liberateNeptunusEndTime = new Timestamp(-1);
    Timestamp stimulateEndTime = new Timestamp(0);
    Timestamp superEndTime = new Timestamp(0);
    Timestamp superFistEnrageEndTime = new Timestamp(-1);

    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    EnergyOrb energyOrb = new EnergyOrb();
    EpicAdventure epicAdventure = new EpicAdventure();
    FistEnrage fistEnrage = new FistEnrage();
    FuriosCharge furiosCharge = new FuriosCharge();
    HowlingFist howlingFist = new HowlingFist();
    LiberateNeptunus liberateNeptunus = new LiberateNeptunus();
    LiberateNeptunusEnrage1 liberateNeptunusEnrage1 = new LiberateNeptunusEnrage1();
    LightningForm lightningForm = new LightningForm();
    LuckyDice luckyDice = new LuckyDice();
    LuckyDiceOneMoreChance luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    Overdrive overdrive = new Overdrive(255L);
    PirateFlag pirateFlag = new PirateFlag();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    ScrewPunch screwPunch = new ScrewPunch();
    SeaSerpentEnrage seaSerpentEnrage = new SeaSerpentEnrage();
    SerpentAssaultEnrage serpentAssaultEnrage = new SerpentAssaultEnrage();
    SerpentScrew serpentScrew = new SerpentScrew();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    Stimulate stimulate = new Stimulate();
    SuperFistEnrage superFistEnrage = new SuperFistEnrage();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public ViperDealCycle(Job job) {
        super(job, new FinalAttackViper());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(100.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    luckyDice.getCooldown() == 0
                            && luckyDice.getBuffAttMagic() == 0
                            && luckyDice.getBuffDamage() == 20
            ) {
                luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
                luckyDice.setCooldown(luckyDiceOneMoreChance.getCooldown());
                luckyDice.setBuffDamage(luckyDiceOneMoreChance.getBuffDamage());
                luckyDice.setBuffAttMagic(luckyDiceOneMoreChance.getBuffAttMagic());
                addSkillEvent(luckyDice);
            } else if (cooldownCheck(luckyDice)) {
                luckyDice = new LuckyDice();
                addSkillEvent(luckyDice);
            }
            if (cooldownCheck(serpentScrew)) {
                addSkillEvent(serpentScrew);
            }
            if (cooldownCheck(pirateFlag)) {
                addSkillEvent(pirateFlag);
            }
            if (
                    cooldownCheck(stimulate)
                            && cooldownCheck(lightningForm)
                            && cooldownCheck(epicAdventure)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(restraintRing)
                            && cooldownCheck(howlingFist)
                            && cooldownCheck(furiosCharge)
                            && (
                            serpentStoneCount == 2
                                    || serpentStoneCount == 3
                    )
                            && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(stimulate);
                addSkillEvent(lightningForm);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(fistEnrage);
                }
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(fistEnrage);
                if (cooldownCheck(liberateNeptunus)) {
                    addSkillEvent(liberateNeptunus);
                    addSkillEvent(fistEnrage);
                }
                addSkillEvent(energyOrb);
                addSkillEvent(energyOrb);
                addSkillEvent(energyOrb);
                addSkillEvent(fistEnrage);
                addSkillEvent(howlingFist);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                addSkillEvent(fistEnrage);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                furiosCharge.setActivateTime(new Timestamp(getStart().getTime() + 44000));
            } else if (
                    cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(weaponJumpRing)
                            && cooldownCheck(howlingFist)
                            && cooldownCheck(furiosCharge)
            ) {
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(fistEnrage);
                addSkillEvent(howlingFist);
                addSkillEvent(fistEnrage);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                addSkillEvent(fistEnrage);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                furiosCharge.setActivateTime(new Timestamp(getStart().getTime() + 44000));
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(furiosCharge)
                            && getStart().before(new Timestamp(soulContract.getActivateTime().getTime() + 10000))
            ) {
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                addSkillEvent(furiosCharge);
                furiosCharge.setActivateTime(new Timestamp(getStart().getTime() + 23000));
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
                Long ran = (long) (Math.random() * 99 + 1);
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
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof Stimulate) {
                stimulateEndTime = new Timestamp(getStart().getTime() + 90000);
            }
            if (skill instanceof LiberateNeptunusBuff) {
                liberateNeptunusEndTime = new Timestamp(getStart().getTime() + 30000);
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
                if (skill instanceof OverdriveDebuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 28000), new Timestamp(getStart().getTime() + (long) (applyCooldownReduction(skill) * 1000))));
                } else {
                    endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
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
                    superEndTime = new Timestamp(getStart().getTime() + 10000);
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
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                if (skill instanceof SerpentAssaultEnrage) {
                    superFistEnrageEndTime = new Timestamp(getStart().getTime() + 10000);
                }
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        }
        applyCooldown(skill);
        getEventTimeList().add(new Timestamp(getStart().getTime()));
        getEventTimeList().add(new Timestamp(getStart().getTime() + skill.getDelay()));
        if (endTime != null) {
            getEventTimeList().add(endTime);
        }
        if (
                cooldownCheck(screwPunch)
                && skill.getDelay() != 0
                && (
                        skill instanceof FistEnrage
                        || skill instanceof SuperFistEnrage
                        || skill instanceof LightningForm
                        || skill instanceof EnergyOrb
                        || skill instanceof SerpentScrew
                        || skill instanceof HowlingFistShock
                        || skill instanceof FuriosCharge
                        || skill instanceof Stimulate
                        || skill instanceof MapleWorldGoddessBlessing
                        || skill instanceof SpiderInMirror
                        || skill instanceof PirateFlag
                        || skill instanceof CrestOfTheSolar
                        || skill instanceof OverdriveDebuff
                )
                && getStart().after(new Timestamp(1000))
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
}
