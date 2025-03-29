package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
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

public class DarkKnight2MinContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new BeholderDominant());
            add(new BeholderImpact());
            add(new BeholderRevenge());
            add(new BeholderPunishment());
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
            add(new PiercingCycloneFinish());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new ContinuousRing());
            add(new DarknessAura());
            add(new DarkThirst());
            add(new EpicAdventure());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new SoulContract());
        }
    };

    int beholderRevengeCount = 5;

    boolean isNuke = false;

    Timestamp beholderImpactEndTime = new Timestamp(0);

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BeholderDominant beholderDominant = new BeholderDominant();
    BeholderImpact beholderImpact = new BeholderImpact();
    BeholderRevenge beholderRevenge = new BeholderRevenge();
    BeholderPunishment beholderPunishment = new BeholderPunishment();
    BeholderShock beholderShock = new BeholderShock();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    ContinuousRing continuousRing = new ContinuousRing();
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
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();

    public DarkKnight2MinContinuousDealCycle(Job job) {
        super(job, new FinalAttackDarkKnight());

        this.getJob().setName("다크나이트(컨티, 2분)");

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        darknessAuraDot.setDotDuration(darknessAuraDot.getDotDuration() + 3000);

        for (int i = 0; i < 720 * 1000; i += beholderDominant.getInterval()) {
            getSkillEventList().add(new SkillEvent(beholderDominant, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        mapleWorldGoddessBlessing.setCooldown(120.0);
        auraWeaponBuff.setCooldown(180.0);

        getSkillSequence1().add(bodyOfSteel);
        getSkillSequence1().add(auraWeaponBuff);
        //getSkillSequence1().add(epicAdventure);             // 30
        //getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(darkThirst);                // 660
        getSkillSequence1().add(soulContract);              // 30

        getSkillSequence2().add(darkThirst);                // 660
        darkThirst.setDelay(660L);

        bodyOfSteel.setDelay(60L);
        auraWeaponBuff.setDelay(60L);
        mapleWorldGoddessBlessing.setDelay(60L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(crestOfTheSolar)) {
                addSkillEvent(crestOfTheSolar);
            } else if (cooldownCheck(spiderInMirror)) {
                addSkillEvent(spiderInMirror);
            } else if (
                    cooldownCheck(mapleWorldGoddessBlessing)
                            && (
                            (
                                    getStart().after(new Timestamp(5 * 60 * 1000))
                                            && getStart().before(new Timestamp(7 * 60 * 1000))
                                            && cooldownCheck(auraWeaponBuff)
                            ) || (
                                    getStart().before(new Timestamp(5 * 60 * 1000))
                                            || getStart().after(new Timestamp(7 * 60 * 1000))
                            )
                    )
                            && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(mapleWorldGoddessBlessing);
            } else if (
                    cooldownCheck(epicAdventure)
                            && (
                            (
                                    getStart().after(new Timestamp(5 * 60 * 1000))
                                            && getStart().before(new Timestamp(7 * 60 * 1000))
                                            && cooldownCheck(auraWeaponBuff)
                            ) || (
                                    getStart().before(new Timestamp(5 * 60 * 1000))
                                            || getStart().after(new Timestamp(7 * 60 * 1000))
                            )
                    )
                            && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(epicAdventure);
            } else if (
                    cooldownCheck(auraWeaponBuff)
                    && cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(660 * 1000))
                    && getStart().after(new Timestamp(darkSpear.getActivateTime().getTime() - 2000))
            ) {
                isNuke = true;
                addSkillEvent(darknessAuraDot);
                addDealCycle(getSkillSequence1());
                if (cooldownCheck(beholderShock)) {
                    addSkillEvent(beholderShock);
                }
                while (!cooldownCheck(darkSpear)) {
                    addSkillEvent(gungnirDescent);
                }
                addSkillEvent(darkSpear);
                addSkillEvent(beholderImpact);
                if (cooldownCheck(deadSpaceSlash)) {
                    addSkillEvent(deadSpaceSlash);
                }
                addSkillEvent(piercingCycloneFirstDelay);
                addSkillEvent(darknessAuraFinish);
                isNuke = false;
            } else if (
                    cooldownCheck(darkThirst)
                            && getStart().before(new Timestamp(auraWeaponBuff.getActivateTime().getTime() - 40000))
            ) {
                addSkillEvent(darkThirst);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(auraWeaponBuff.getActivateTime().getTime() - 40000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(beholderShock)
                            && getStart().after(beholderImpactEndTime)
            ) {
                addSkillEvent(beholderShock);
            } else if (
                    cooldownCheck(beholderImpact)
                    && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(beholderImpact);
            } else if (cooldownCheck(darkSpear)) {
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
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
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof DarkSynthesis
                            || skill instanceof GungnirDescent
                            )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof GungnirDescent
                    || skill instanceof DarkSynthesis
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 60) {
                    addSkillEvent(beholderRevenge);
                    beholderRevengeCount += 1;
                    if (beholderRevengeCount >= 6) {
                        addSkillEvent(beholderPunishment);
                        beholderRevengeCount -= 6;
                    }
                }
            }
            if (skill instanceof BeholderImpact) {
                beholderImpactEndTime = new Timestamp(getStart().getTime() + beholderImpact.getDotDuration());
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
                        if (
                                skill instanceof PiercingCycloneKeydown
                                || skill instanceof DarkSpear
                        ) {
                            Timestamp now = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (
                                    cooldownCheck(beholderShock)
                                    && getStart().after(beholderImpactEndTime)
                            ) {
                                addSkillEvent(beholderShock);
                            }
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 60) {
                                addSkillEvent(beholderRevenge);
                                beholderRevengeCount += 1;
                                if (beholderRevengeCount >= 6) {
                                    addSkillEvent(beholderPunishment);
                                    beholderRevengeCount -= 6;
                                }
                            }
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
        if (
                skill instanceof BeholderShock
                && cooldownCheck(skill)
        ) {
            beholderShock.setActivateTime(new Timestamp(getStart().getTime() + 360));
        }
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
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    skill instanceof PiercingCycloneFinish
                    || skill instanceof DeadSpaceDarkAura
                    || skill instanceof DeadSpaceSlash
            ) {
                Timestamp now = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 60) {
                    addSkillEvent(beholderRevenge);
                    beholderRevengeCount += 1;
                    if (beholderRevengeCount >= 6) {
                        addSkillEvent(beholderPunishment);
                        beholderRevengeCount -= 6;
                    }
                }
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                getStart().setTime(now.getTime());
            }
        }
    }
}
