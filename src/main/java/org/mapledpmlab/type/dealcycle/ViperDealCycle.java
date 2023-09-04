package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.viper.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.viper.LightningForm;
import org.mapledpmlab.type.skill.buffskill.viper.Stimulate;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ViperDealCycle extends DealCycle {

    /*

     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private Long serpentStoneCount = 3L;
    private Timestamp superEndTime = new Timestamp(0);
    private Timestamp stimulateEndTime = new Timestamp(0);

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EnergyOrb());
            add(new FinalAttackViper());
            add(new FistEnrage());
            add(new FuriosCharge());
            add(new HowlingFist());
            add(new HowlingFistShock());
            add(new LiberateNeptunus());
            add(new LiberateNeptunusEnrage1());
            add(new LiberateNeptunusEnrage2());
            add(new LiberateNeptunusEnrage3());
            add(new LiberateNeptunusEnrage4());
            add(new LiberateNeptunusEnrage5());
            add(new LiberateNeptunusFuryOfTheSea());
            add(new SeaSerpentEnrage());
            add(new SerpentAssaultEnrage());
            add(new SerpentScrew());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SuperFistEnrage());
            add(new SuperFistEnrageShockWave());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new EnergyOrbDelay());
            add(new HowlingFistDelay());
            add(new LiberateNeptunusDelay());
            add(new SerpentScrewDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new EpicAdventure());
            add(new LightningForm());
            add(new LuckyDice());
            add(new LuckyDiceOneMoreChance());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new PirateFlag());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new Stimulate());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    public ViperDealCycle(Job job) {
        super(job, new FinalAttackViper());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

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
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        Overdrive overdrive = new Overdrive(255L);
        PirateFlag pirateFlag = new PirateFlag();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SeaSerpentBurst seaSerpentBurst = new SeaSerpentBurst();
        SeaSerpentEnrage seaSerpentEnrage = new SeaSerpentEnrage();
        SerpentAssault serpentAssault = new SerpentAssault();
        SerpentAssaultEnrage serpentAssaultEnrage = new SerpentAssaultEnrage();
        SerpentScrew serpentScrew = new SerpentScrew();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        Stimulate stimulate = new Stimulate();
        SuperFistEnrage superFistEnrage = new SuperFistEnrage();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += serpentScrew.getInterval()) {
            getSkillEventList().add(new SkillEvent(serpentScrew, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        // 3스택
        dealCycle1.add(stimulate);
        dealCycle1.add(lightningForm);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(pirateFlag);
        dealCycle1.add(overdrive);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        // 4스택
        dealCycle1.add(fistEnrage);
        dealCycle1.add(seaSerpentEnrage);
        dealCycle1.add(liberateNeptunus);
        // 5스택
        dealCycle1.add(fistEnrage);
        dealCycle1.add(liberateNeptunusEnrage1);
        dealCycle1.add(serpentAssaultEnrage);
        dealCycle1.add(energyOrb);
        dealCycle1.add(energyOrb);
        dealCycle1.add(energyOrb);
        // 1스택
        dealCycle1.add(superFistEnrage);
        dealCycle1.add(liberateNeptunusEnrage1);
        dealCycle1.add(seaSerpentEnrage);
        dealCycle1.add(howlingFist);
        dealCycle1.add(liberateNeptunusEnrage1);
        // 2스택
        dealCycle1.add(superFistEnrage);
        dealCycle1.add(seaSerpentEnrage);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);
        // 3스택
        dealCycle1.add(fistEnrage);
        dealCycle1.add(seaSerpentEnrage);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(liberateNeptunusEnrage1);

        // 4스택
        dealCycle2.add(stimulate);
        dealCycle2.add(lightningForm);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(pirateFlag);
        dealCycle2.add(overdrive);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        // 5스택
        dealCycle2.add(fistEnrage);
        dealCycle2.add(serpentAssaultEnrage);
        dealCycle2.add(energyOrb);
        dealCycle2.add(energyOrb);
        dealCycle2.add(energyOrb);
        // 1스택
        dealCycle2.add(superFistEnrage);
        dealCycle2.add(seaSerpentEnrage);
        dealCycle2.add(howlingFist);
        // 2스택
        dealCycle2.add(superFistEnrage);
        dealCycle2.add(seaSerpentEnrage);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);
        // 3스택
        dealCycle2.add(fistEnrage);
        dealCycle2.add(seaSerpentEnrage);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);

        // 4스택
        dealCycle3.add(pirateFlag);
        dealCycle3.add(overdrive);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        // 5스택
        dealCycle3.add(fistEnrage);
        dealCycle3.add(serpentAssaultEnrage);
        dealCycle3.add(howlingFist);
        // 1스택
        dealCycle3.add(superFistEnrage);
        dealCycle3.add(seaSerpentEnrage);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        // 2스택
        dealCycle3.add(superFistEnrage);
        dealCycle3.add(seaSerpentEnrage);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(superFistEnrage);
        // 3스택
        dealCycle3.add(superFistEnrage);
        dealCycle3.add(seaSerpentEnrage);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());
        Timestamp liberateNeptunusEndTime = new Timestamp(0);

        while (getStart().before(getEnd())) {
            if (
                    luckyDice.getCooldown() == 0
                    && luckyDice.getBuffAttMagic() == 0
                    && luckyDice.getBuffDamage() == 20
            ) {
                luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
                if (
                        luckyDiceOneMoreChance.getBuffDamage() >= 30
                        || luckyDiceOneMoreChance.getBuffAttMagic() >= 15
                ) {
                    luckyDiceOneMoreChance.setCooldown(180.0);
                }
                luckyDice.setCooldown(luckyDiceOneMoreChance.getCooldown());
                luckyDice.setBuffDamage(luckyDiceOneMoreChance.getBuffDamage());
                luckyDice.setBuffAttMagic(luckyDiceOneMoreChance.getBuffAttMagic());
                addSkillEvent(luckyDice);
            } else if (cooldownCheck(luckyDice)) {
                luckyDice = new LuckyDice();
                if (
                        luckyDice.getBuffDamage() >= 30
                        || luckyDice.getBuffAttMagic() >= 15
                ) {
                    luckyDice.setCooldown(180.0);
                }
                addSkillEvent(luckyDice);
            }
            if (cooldownCheck(serpentScrew)) {
                addSkillEvent(serpentScrew);
            }
            if (
                    getStart().after(mapleWorldGoddessBlessing.getEndTime())
                            && getStart().before(new Timestamp(90 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addSkillEvent(mapleWorldGoddessBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && serpentStoneCount == 3
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                stimulateEndTime = new Timestamp(getStart().getTime() + 90000);
                addDealCycle(dealCycle1);
                serpentStoneCount = 3L;
                liberateNeptunusEndTime = new Timestamp(getStart().getTime() + 16680);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && serpentStoneCount == 4
                    && !cooldownCheck(dealCycle1)
            ) {
                stimulateEndTime = new Timestamp(getStart().getTime() + 90000);
                addDealCycle(dealCycle2);
                serpentStoneCount = 3L;
            } else if (
                    cooldownCheck(dealCycle3)
                    && serpentStoneCount == 4
            ) {
                addDealCycle(dealCycle3);
                serpentStoneCount = 3L;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(pirateFlag)
                    && getStart().before(new Timestamp(soulContract.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(pirateFlag);
            } else if (getStart().before(superEndTime)) {
                addSkillEvent(superFistEnrage);
                if (cooldownCheck(seaSerpentEnrage)) {
                    if (serpentStoneCount == 5) {
                        addSkillEvent(serpentAssaultEnrage);
                        superEndTime = new Timestamp(getStart().getTime() + 10000);
                        serpentStoneCount = 0L;
                    } else {
                        addSkillEvent(seaSerpentEnrage);
                        serpentStoneCount += 1;
                    }
                }
                if (
                        cooldownCheck(liberateNeptunusEnrage1)
                        && getStart().before(liberateNeptunusEndTime)
                ) {
                    addSkillEvent(liberateNeptunusEnrage1);
                }
            } else {
                addSkillEvent(fistEnrage);
                if (cooldownCheck(seaSerpentEnrage)) {
                    if (serpentStoneCount == 5) {
                        addSkillEvent(serpentAssaultEnrage);
                        superEndTime = new Timestamp(getStart().getTime() + 10000);
                        serpentStoneCount = 0L;
                    } else {
                        addSkillEvent(seaSerpentEnrage);
                        serpentStoneCount += 1;
                    }
                }
                if (
                        cooldownCheck(liberateNeptunusEnrage1)
                        && getStart().before(liberateNeptunusEndTime)
                ) {
                    addSkillEvent(liberateNeptunusEnrage1);
                }
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
                        skill.setActivateTime(new Timestamp((int) (getStart().getTime() + 2000)));
                    } else {
                        skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                    }
                }
            } else {
                if (skill instanceof SeaSerpentEnrage && getStart().before(stimulateEndTime)) {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + 2000)));
                } else {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
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
}
