package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
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

public class PaladinUnityDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new Blast());
            add(new BlastUnity());
            add(new BlessedHammerDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DivineJudgement());
            add(new FallingJustice());
            add(new RisingJustice());
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
            add(new SanctuaryUnity());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BlessedHammerBuff());
            add(new BodyOfSteel(0L));
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

    Timestamp nobleDemandEndTime = new Timestamp(-1);
    Timestamp sacredBastionEndTime = new Timestamp(0);
    Timestamp holyUnityEndTime = new Timestamp(0);

    Double divineBrandCount = 0.0;      // 신성 낙인 개수

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    Blast blast = new Blast();
    BlastUnity blastUnity = new BlastUnity();
    BlessedHammerBuff blessedHammerBuff = new BlessedHammerBuff();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DivineJudgement divineJudgement = new DivineJudgement();
    EpicAdventure epicAdventure = new EpicAdventure();
    FallingJustice fallingJustice = new FallingJustice();
    GrandCrossFirstDelay grandCrossFirstDelay = new GrandCrossFirstDelay();
    HolyUnity holyUnity = new HolyUnity();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MightyMjolnir mightyMjolnir = new MightyMjolnir();
    MightyMjolnirDelay mightyMjolnirDelay = new MightyMjolnirDelay();
    MightyMjolnirImpact mightyMjolnirImpact = new MightyMjolnirImpact();
    NobleDemand nobleDemand = new NobleDemand();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SacredBastion1 sacredBastion1 = new SacredBastion1();
    SacredBastionLight sacredBastionLight = new SacredBastionLight();
    Sanctuary sanctuary = new Sanctuary();
    SanctuaryUnity sanctuaryUnity = new SanctuaryUnity();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public PaladinUnityDealCycle(Job job) {
        super(job, new FinalAttackPaladin());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        this.getJob().setName("팔라딘(리웨, 결속)");

        mightyMjolnirDelay.setActivateTime(new Timestamp(-24000));
        ringSwitching.setCooldown(90.0);
        auraWeaponBuff.setCooldown(180.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);

        getSkillSequence1().add(auraWeaponBuff);
        getSkillSequence1().add(epicAdventure);             // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(bodyOfSteel);
        getSkillSequence1().add(holyUnity);                 // 450
        // 디바인 블레싱                                      // 150
        getSkillSequence1().add(soulContract);              // 30
        getSkillSequence1().add(restraintRing);             // 30

        getSkillSequence2().add(holyUnity);                 // 450
        // 디바인 블레싱                                      // 150
        getSkillSequence2().add(soulContract);              // 30
        getSkillSequence2().add(weaponJumpRing);            // 30

        holyUnity.setDelay(600L);

        auraWeaponBuff.setDelay(100L);
        mapleWorldGoddessBlessing.setDelay(100L);
        bodyOfSteel.setDelay(100L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (getStart().after(nobleDemandEndTime)) {
                addSkillEvent(nobleDemand);
            }
            if (cooldownCheck(restraintRing)) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addSkillEvent(blessedHammerBuff);
                addDealCycle(getSkillSequence1());
                addSkillEvent(mightyMjolnirDelay);
                addSkillEvent(sanctuary);
                if (cooldownCheck(sacredBastion1)) {
                    addSkillEvent(sacredBastion1);
                }
                while (!cooldownCheck(grandCrossFirstDelay)) {
                    addSkillEvent(blast);
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
                addSkillEvent(blessedHammerBuff);
                addDealCycle(getSkillSequence2());
            } else if (
                    cooldownCheck(mightyMjolnirDelay)
                    && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(mightyMjolnirDelay);
            } else if (
                    cooldownCheck(sanctuary)
                            && getStart().before(new Timestamp(holyUnity.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(sanctuary);
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof HolyUnity) {
                holyUnityEndTime = new Timestamp(getStart().getTime() + 45000 + 3000);
            }
            if (skill instanceof NobleDemand) {
                nobleDemandEndTime = new Timestamp(getStart().getTime() + 80000);
            }
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
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
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
                    getStart().before(holyUnityEndTime)
                    && skill instanceof Blast
            ) {
                addSkillEvent(blastUnity);
            }
            if (
                    getStart().before(holyUnityEndTime)
                    && skill instanceof Sanctuary
            ) {
                addSkillEvent(sanctuaryUnity);
            }
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
                        i = 0;
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
                        Timestamp now = new Timestamp(getStart().getTime());
                        getStart().setTime(getStart().getTime() + i);
                        if (
                                getStart().before(sacredBastionEndTime)
                                && cooldownCheck(sacredBastionLight)
                                && (
                                        skill instanceof GrandCross1
                                        || skill instanceof GrandCross2
                                )
                        ) {
                            addSkillEvent(sacredBastionLight);
                            divineBrandCount ++;
                            if (divineBrandCount >= 5) {
                                addSkillEvent(divineJudgement);
                                divineBrandCount -= 5;
                            }
                        }
                        getStart().setTime(now.getTime());
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
                        && (
                                skill instanceof Blast
                                || skill instanceof Sanctuary
                                || skill instanceof Smite
                                || skill instanceof MightyMjolnirDelay
                        )
                ) {
                    addSkillEvent(sacredBastionLight);
                    divineBrandCount ++;
                    if (divineBrandCount >= 5) {
                        addSkillEvent(divineJudgement);
                        divineBrandCount -= 5;
                    }
                }
                if (skill instanceof MightyMjolnirDelay) {
                    for (int i = 840; i < 840 + 210 * 4; i += 210) {
                        getSkillEventList().add(new SkillEvent(mightyMjolnir, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getSkillEventList().add(new SkillEvent(mightyMjolnir, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getSkillEventList().add(new SkillEvent(mightyMjolnir, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        getSkillEventList().add(new SkillEvent(mightyMjolnirImpact, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getSkillEventList().add(new SkillEvent(mightyMjolnirImpact, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
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

    @Override
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Double ran = Math.random() * 99;
                if (ran <= getJob().getReuse()) {
                } else  {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            } else {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
            }
            if (!skill.isApplyCooldownReduction()) {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + skill.getCooldown() * 1000)));
            }
        }
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (skill instanceof Sanctuary) {
                Timestamp now = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                divineBrandCount ++;
                if (divineBrandCount >= 5) {
                    addSkillEvent(divineJudgement);
                    divineBrandCount -= 5;
                }
                getStart().setTime(now.getTime());
            }
        }
    }
}
