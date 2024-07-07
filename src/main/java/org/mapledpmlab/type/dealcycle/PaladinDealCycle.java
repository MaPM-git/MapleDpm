package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.paladin.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.paladin.BlessedHammerBuff;
import org.mapledpmlab.type.skill.buffskill.paladin.HolyUnity;
import org.mapledpmlab.type.skill.buffskill.paladin.NobleDemand;
import org.mapledpmlab.type.skill.buffskill.paladin.SacredBastionBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PaladinDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new Blast());
            add(new BlessedHammerDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DivineJudgement());
            add(new FallingJustice());
            add(new FinalAttackPaladin());
            add(new GrandCrossFirstDelay());
            add(new GrandCross1());
            add(new GrandCross1Delay());
            add(new GrandCrossLoopDelay());
            add(new GrandCross2());
            add(new GrandCross2Delay());
            add(new GrandCrossAfterDelay());
            add(new MightyMjolnirDelay());
            add(new MightyMjolnir());
            add(new MightyMjolnirImpact());
            add(new SacredBastion1());
            add(new SacredBastion2());
            add(new SacredBastionLight());
            add(new Sanctuary());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BlessedHammerBuff());
            add(new EpicAdventure());
            add(new HolyUnity());
            add(new NobleDemand());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SacredBastionBuff());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    private Timestamp sacredBastionEndTime = new Timestamp(0);

    Double divineBrandCount = 0.0;      // 신성 낙인 개수

    FallingJustice fallingJustice = new FallingJustice();
    SacredBastionLight sacredBastionLight = new SacredBastionLight();
    MightyMjolnir mightyMjolnir = new MightyMjolnir();
    MightyMjolnirImpact mightyMjolnirImpact = new MightyMjolnirImpact();
    DivineJudgement divineJudgement = new DivineJudgement();

    public PaladinDealCycle(Job job) {
        super(job, new FinalAttackPaladin());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        Blast blast = new Blast();
        BlessedHammerBuff blessedHammerBuff = new BlessedHammerBuff();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        EpicAdventure epicAdventure = new EpicAdventure();
        GrandCrossFirstDelay grandCrossFirstDelay = new GrandCrossFirstDelay();
        HolyUnity holyUnity = new HolyUnity();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MightyMjolnirDelay mightyMjolnirDelay = new MightyMjolnirDelay();
        NobleDemand nobleDemand = new NobleDemand();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SacredBastion1 sacredBastion1 = new SacredBastion1();
        Sanctuary sanctuary = new Sanctuary();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        ringSwitching.setCooldown(90.0);
        auraWeaponBuff.setCooldown(180.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);

        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(auraWeaponBuff)
                    && cooldownCheck(nobleDemand)
                    && cooldownCheck(epicAdventure)
                    && cooldownCheck(mapleWorldGoddessBlessing)
                    && cooldownCheck(holyUnity)
                    && cooldownCheck(blessedHammerBuff)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
                    && cooldownCheck(grandCrossFirstDelay)
                    && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(nobleDemand);
                addSkillEvent(auraWeaponBuff);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(blast);
                }
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(holyUnity);
                addSkillEvent(blessedHammerBuff);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                if (cooldownCheck(sacredBastion1)) {
                    addSkillEvent(sacredBastion1);
                }
                addSkillEvent(grandCrossFirstDelay);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(holyUnity)
                            && cooldownCheck(weaponJumpRing)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(nobleDemand);
                addSkillEvent(holyUnity);
                addSkillEvent(weaponJumpRing);
            } else if (
                    cooldownCheck(blessedHammerBuff)
                    && cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() + 10000))
            ) {
                addSkillEvent(blessedHammerBuff);
                addSkillEvent(soulContract);
            } else if (cooldownCheck(mightyMjolnirDelay)) {
                addSkillEvent(mightyMjolnirDelay);
            } else {
                addSkillEvent(blast);
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
            if (skill instanceof SacredBastionBuff) {
                sacredBastionEndTime = new Timestamp(getStart().getTime() + 30000);
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
            if (
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
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (((AttackSkill) skill).getInterval() == 0 && cooldownCheck(fallingJustice)) {
                addSkillEvent(fallingJustice);
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof BlessedHammerDot) {
                        i = 1801;
                    }
                    if (skill instanceof FallingJustice) {
                        i = 270;
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
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                if (skill instanceof Blast) {
                    divineBrandCount ++;
                    if (divineBrandCount >= 5) {
                        addSkillEvent(divineJudgement);
                        divineBrandCount -= 5;
                    }
                }
                if (
                        getStart().before(sacredBastionEndTime)
                        && cooldownCheck(sacredBastionLight)
                ) {
                    getSkillEventList().add(new SkillEvent(sacredBastionLight, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                    getEventTimeList().add(new Timestamp(getStart().getTime()));
                    applyCooldown(sacredBastionLight);
                    divineBrandCount ++;
                    if (divineBrandCount >= 5) {
                        addSkillEvent(divineJudgement);
                        divineBrandCount -= 5;
                    }
                }
                if (skill instanceof MightyMjolnirDelay) {
                    for (int i = 840; i < 840 + 210 * 4; i += 210) {
                        getSkillEventList().add(new SkillEvent(mightyMjolnir, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        getSkillEventList().add(new SkillEvent(mightyMjolnirImpact, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
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
