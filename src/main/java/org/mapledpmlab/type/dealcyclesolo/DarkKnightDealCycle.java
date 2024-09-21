package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.darkknight.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.darkknight.DarkThirst;
import org.mapledpmlab.type.skill.buffskill.darkknight.DarknessAura;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DarkKnightDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new BeholderDominant());
            add(new BeholderImpact());
            add(new BeholderRevenge());
            add(new BeholderShock());
            add(new BeholderShockDarkWarfare());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DarknessAuraDot());
            add(new DarknessAuraFinish());
            add(new DarkSpear());
            add(new DarkSynthesis());
            add(new DeadSpaceDarkAura());
            add(new DeadSpaceSlash());
            add(new FinalAttackDarkKnight());
            add(new GungnirDescent());
            add(new PiercingCycloneFirstDelay());
            add(new PiercingCycloneKeydown());
            add(new PiercingCycloneKeydownDelay());
            add(new PiercingCycloneFinish());
            add(new PiercingCycloneEndDelay());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new DarknessAura());
            add(new DarkThirst());
            add(new EpicAdventure());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
        }
    };

    Timestamp beholderImpactEndTime = new Timestamp(0);

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BeholderDominant beholderDominant = new BeholderDominant();
    BeholderImpact beholderImpact = new BeholderImpact();
    BeholderRevenge beholderRevenge = new BeholderRevenge();
    BeholderShock beholderShock = new BeholderShock();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DarknessAuraDot darknessAuraDot = new DarknessAuraDot();
    DarknessAuraFinish darknessAuraFinish = new DarknessAuraFinish();
    DarkSpear darkSpear = new DarkSpear();
    DarkThirst darkThirst = new DarkThirst();
    DeadSpaceSlash deadSpaceSlash = new DeadSpaceSlash();
    EpicAdventure epicAdventure = new EpicAdventure();
    GungnirDescent gungnirDescent = new GungnirDescent();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    PiercingCycloneFirstDelay piercingCycloneFirstDelay = new PiercingCycloneFirstDelay();
    PiercingCycloneFinish piercingCycloneFinish = new PiercingCycloneFinish();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();

    public DarkKnightDealCycle(Job job) {
        super(job, new FinalAttackDarkKnight());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        for (int i = 0; i < 720 * 1000; i += beholderDominant.getInterval()) {
            getSkillEventList().add(new SkillEvent(beholderDominant, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        getStart().setTime(-27610);
        darknessAuraDot.setActivateTime(new Timestamp(-30000));
        darknessAuraDot.getRelatedSkill().setActivateTime(new Timestamp(-30000));
        addSkillEvent(darknessAuraDot);
        getStart().setTime(0);

        ringSwitching.setCooldown(180.0);
        mapleWorldGoddessBlessing.setCooldown(120.0);
        auraWeaponBuff.setCooldown(180.0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(darknessAuraDot)) {
                addSkillEvent(darknessAuraDot);
            }
            if (
                    cooldownCheck(auraWeaponBuff)
                            && cooldownCheck(epicAdventure)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(darkThirst)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(restraintRing)
                            && cooldownCheck(beholderShock)
                            && cooldownCheck(darkSpear)
                            && cooldownCheck(beholderImpact)
                            && cooldownCheck(piercingCycloneFirstDelay)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(gungnirDescent);
                }
                addSkillEvent(bodyOfSteel);
                addSkillEvent(darkThirst);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(beholderShock);
                addSkillEvent(darkSpear);
                addSkillEvent(beholderImpact);
                if (cooldownCheck(deadSpaceSlash)) {
                    addSkillEvent(deadSpaceSlash);
                }
                addSkillEvent(piercingCycloneFirstDelay);
                addSkillEvent(darknessAuraFinish);
            } else if (
                    cooldownCheck(darkThirst)
                            && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(darkThirst);
            } else if (
                    cooldownCheck(soulContract)
                            && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(beholderShock)
                            && getStart().after(beholderImpactEndTime)
                            && (
                            getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 5000))
                                    || getStart().after(new Timestamp(10 * 60 * 1000))
                    )
            ) {
                addSkillEvent(beholderShock);
            } else if (
                    cooldownCheck(beholderImpact)
                            && (
                            getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 5000))
                                    || getStart().after(new Timestamp(10 * 60 * 1000))
                    )
            ) {
                beholderImpactEndTime = new Timestamp(getStart().getTime() + beholderImpact.getDotDuration());
                addSkillEvent(beholderImpact);
            } else if (
                    cooldownCheck(darkSpear)
                            && (
                            getStart().before(new Timestamp(restraintRing.getActivateTime().getTime() - 5000))
                                    || getStart().after(new Timestamp(10 * 60 * 1000))
                    )
            ) {
                addSkillEvent(darkSpear);
            } else {
                addSkillEvent(gungnirDescent);
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
                    }
                }
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
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
                if (skill instanceof PiercingCycloneEndDelay) {
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150), new Timestamp(getStart().getTime() + 150)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150));
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150 + 30), new Timestamp(getStart().getTime() + 150 + 30)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150 + 30));
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150 + 30 + 30), new Timestamp(getStart().getTime() + 150 + 30 + 30)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150 + 30 + 30));
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30), new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30));
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30), new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30));
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30), new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30));
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30 + 30), new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30 + 30)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30 + 30));
                    getSkillEventList().add(new SkillEvent(piercingCycloneFinish, new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30 + 30 + 30), new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30 + 30 + 30)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 150 + 30 + 30 + 30 + 30 + 30 + 30 + 30));
                }
                if (cooldownCheck(beholderRevenge)) {
                    getSkillEventList().add(new SkillEvent(beholderRevenge, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                    getEventTimeList().add(new Timestamp(getStart().getTime()));
                    applyCooldown(beholderRevenge);
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
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }
}
