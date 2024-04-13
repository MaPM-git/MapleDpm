package org.mapledpmlab.type.dealcycle;

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

    /*

     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private Long serpentStoneCount = 2L;
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new HowlingFistBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
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
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SeaSerpentEnrageBuff());
            add(new SoulContract());
            add(new Stimulate());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Timestamp superFistEnrageEndTime = new Timestamp(-1);
    Timestamp liberateNeptunusEndTime = new Timestamp(-1);
    LiberateNeptunusEnrage1 liberateNeptunusEnrage1 = new LiberateNeptunusEnrage1();
    ScrewPunch screwPunch = new ScrewPunch();
    PirateFlag pirateFlag = new PirateFlag();

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
        LightningForm lightningForm = new LightningForm();
        LuckyDice luckyDice = new LuckyDice();
        LuckyDiceOneMoreChance luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        Overdrive overdrive = new Overdrive(255L);
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SeaSerpentEnrage seaSerpentEnrage = new SeaSerpentEnrage();
        SerpentAssaultEnrage serpentAssaultEnrage = new SerpentAssaultEnrage();
        SerpentScrew serpentScrew = new SerpentScrew();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        Stimulate stimulate = new Stimulate();
        SuperFistEnrage superFistEnrage = new SuperFistEnrage();
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

        ringSwitching.setCooldown(100.0);

        dealCycle1.add(pirateFlag);
        dealCycle1.add(stimulate);
        dealCycle1.add(lightningForm);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(overdrive);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(fistEnrage);
        dealCycle1.add(liberateNeptunus);
        dealCycle1.add(fistEnrage);
        dealCycle1.add(energyOrb);
        dealCycle1.add(energyOrb);
        dealCycle1.add(energyOrb);
        dealCycle1.add(fistEnrage);
        dealCycle1.add(howlingFist);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(fistEnrage);
        dealCycle1.add(furiosCharge);
        dealCycle1.add(furiosCharge);

        dealCycle2.add(pirateFlag);
        dealCycle2.add(stimulate);
        dealCycle2.add(lightningForm);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(overdrive);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(fistEnrage);
        dealCycle2.add(energyOrb);
        dealCycle2.add(energyOrb);
        dealCycle2.add(energyOrb);
        dealCycle2.add(fistEnrage);
        dealCycle2.add(howlingFist);
        dealCycle2.add(fistEnrage);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(fistEnrage);
        dealCycle2.add(furiosCharge);
        dealCycle2.add(furiosCharge);

        dealCycle3.add(pirateFlag);
        dealCycle3.add(overdrive);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(fistEnrage);
        dealCycle3.add(fistEnrage);
        dealCycle3.add(howlingFist);
        dealCycle3.add(fistEnrage);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(fistEnrage);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(furiosCharge);
        dealCycle3.add(fistEnrage);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());

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
                    && cooldownCheck(screwPunch)
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && !cooldownCheck(dealCycle1)
                    && cooldownCheck(screwPunch)
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
                    && cooldownCheck(screwPunch)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(100 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(pirateFlag)
                    && getStart().before(new Timestamp(howlingFist.getActivateTime().getTime() - 3000))
                    && cooldownCheck(screwPunch)
            ) {
                addSkillEvent(pirateFlag);
            } else {
                if (getStart().before(superEndTime)) {
                    addSkillEvent(superFistEnrage);
                } else {
                    addSkillEvent(fistEnrage);
                }
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
        getEventTimeList().add(getStart());
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
        ) {
            endTime = new Timestamp(getStart().getTime() + screwPunch.getDelay());
            getSkillEventList().add(new SkillEvent(screwPunch, new Timestamp(getStart().getTime()), endTime));
            getStart().setTime(getStart().getTime() + skill.getDelay());
            //addSkillEvent(screwPunch);
        } else {
            getStart().setTime(getStart().getTime() + skill.getDelay());
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }
}
