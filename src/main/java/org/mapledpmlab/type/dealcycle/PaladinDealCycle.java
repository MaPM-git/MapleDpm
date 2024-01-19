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

    /*
        팔라딘 딜사이클
        오라웨폰(140초) - 노블 디맨드(80초) - 에픽 어드벤쳐(60초) - 메용2(60초)
        크오솔(51초) - 스인미(50초)
        홀리 유니티(45초) - 블래스드 해머(30초) - 엔버(10초) - 시드링(15초)
        그랜드 크로스 - 세이크리드 바스티온
        
        쿨마다 묠니르 - 생츄어리
     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜 - 오라웨폰, 노블 디맨드, 메용2, 홀리 유니티, 엔버, 웨폰퍼프
    private List<Skill> dealCycle3 = new ArrayList<>();
    
    // 쿨마다 사용 - 묠니르, 생츄어리
    private List<Skill> shortDealCycle = new ArrayList<>();

    private Timestamp sacredBastionEndTime = new Timestamp(0);

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new Blast());
            add(new BlessedHammerDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DivineJudgement());
            add(new FallingJustice());
            add(new FinalAttackPaladin());
            add(new GrandCross1());
            add(new GrandCross2());
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new GrandCross1Delay());
            add(new GrandCross2Delay());
            add(new GrandCrossAfterDelay());
            add(new GrandCrossFirstDelay());
            add(new GrandCrossLoopDelay());
            add(new MightyMjolnirDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BlessedHammerBuff());
            add(new EpicAdventure());
            add(new HolyUnity());
            add(new NobleDemand());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SacredBastionBuff());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Double divineBrandCount = 0.0;      // 신성 낙인 개수

    FallingJustice fallingJustice = new FallingJustice();
    SacredBastionLight sacredBastionLight = new SacredBastionLight();
    MightyMjolnir mightyMjolnir = new MightyMjolnir();
    MightyMjolnirImpact mightyMjolnirImpact = new MightyMjolnirImpact();

    public PaladinDealCycle(Job job) {
        super(job, new FinalAttackPaladin());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        Blast blast = new Blast();
        BlessedHammerBuff blessedHammerBuff = new BlessedHammerBuff();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DivineJudgement divineJudgement = new DivineJudgement();
        EpicAdventure epicAdventure = new EpicAdventure();
        GrandCrossFirstDelay grandCrossFirstDelay = new GrandCrossFirstDelay();
        HolyUnity holyUnity = new HolyUnity();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MightyMjolnirDelay mightyMjolnirDelay = new MightyMjolnirDelay();
        NobleDemand nobleDemand = new NobleDemand();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SacredBastion1 sacredBastion1 = new SacredBastion1();
        Sanctuary sanctuary = new Sanctuary();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
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

        ringSwitching.setCooldown(90.0);

        dealCycle1.add(nobleDemand);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(holyUnity);
        dealCycle1.add(blessedHammerBuff);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(grandCrossFirstDelay);
        dealCycle1.add(sacredBastion1);

        dealCycle2.add(nobleDemand);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(holyUnity);
        dealCycle2.add(blessedHammerBuff);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(grandCrossFirstDelay);

        dealCycle3.add(nobleDemand);
        dealCycle3.add(holyUnity);
        dealCycle3.add(blessedHammerBuff);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);

        shortDealCycle.add(mightyMjolnirDelay);
        shortDealCycle.add(sanctuary);

        while (getStart().before(getEnd())) {
            if (divineBrandCount >= 5) {
                addSkillEvent(divineJudgement);
                divineBrandCount -= 5;
            }
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
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
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(shortDealCycle)
            ) {
                addDealCycle(shortDealCycle);
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
                }
                if (
                        getStart().before(sacredBastionEndTime)
                        && cooldownCheck(sacredBastionLight)
                ) {
                    getSkillEventList().add(new SkillEvent(sacredBastionLight, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                    getEventTimeList().add(new Timestamp(getStart().getTime()));
                    applyCooldown(sacredBastionLight);
                    divineBrandCount ++;
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
