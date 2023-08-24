package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.paladin.*;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.paladin.BlessedHammerBuff;
import org.mapledpmlab.type.skill.buffskill.paladin.HolyUnity;
import org.mapledpmlab.type.skill.buffskill.paladin.NobleDemand;

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
            add(new DivineCharge());
            add(new DivineJudgement());
            add(new DivineStigma());
            add(new FinalAttackPaladin());
            add(new GrandCross1());
            add(new GrandCross2());
            add(new MightyMjolnir());
            add(new MightyMjolnirImpact());
            add(new SacredBastionDot());
            add(new SacredBastionImpact1());
            add(new SacredBastionImpact2());
            add(new Sanctuary());
            add(new Smite());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new DivineStigmaExplosion());
        }
    };

    public PaladinDealCycle(Job job) {
        super(job, new FinalAttackPaladin());

        this.setAttackSkillList(attackSkillList);

        Long q = 0L;
        Double divineBrandCount = 0.0; // 신성 낙인 개수

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        AuraWeaponDot auraWeaponDot = new AuraWeaponDot();
        Blast blast = new Blast();
        BlessedHammerBuff blessedHammerBuff = new BlessedHammerBuff();
        BlessedHammerDot blessedHammerDot = new BlessedHammerDot();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrestOfTheSolarDot crestOfTheSolarDot = new CrestOfTheSolarDot();
        DivineCharge divineCharge = new DivineCharge();
        DivineJudgement divineJudgement = new DivineJudgement();
        DivineStigma divineStigma = new DivineStigma();
        DivineStigmaExplosion divineStigmaExplosion = new DivineStigmaExplosion();
        EpicAdventure epicAdventure = new EpicAdventure();
        FinalAttackPaladin finalAttackPaladin = new FinalAttackPaladin();
        GrandCross1 grandCross1 = new GrandCross1();
        HolyUnity holyUnity = new HolyUnity();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MightyMjolnir mightyMjolnir = new MightyMjolnir();
        MightyMjolnirImpact mightyMjolnirImpact = new MightyMjolnirImpact();
        NobleDemand nobleDemand = new NobleDemand();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SacredBastionDot sacredBastionDot = new SacredBastionDot();
        SacredBastionImpact1 sacredBastionImpact1 = new SacredBastionImpact1();
        SacredBastionImpact2 sacredBastionImpact2 = new SacredBastionImpact2();
        Sanctuary sanctuary = new Sanctuary();
        Smite smite = new Smite();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiderInMirrorDot spiderInMirrorDot = new SpiderInMirrorDot();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(340L);

        for (int i = 0; i < 720 * 1000; i += auraWeaponDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(auraWeaponDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(nobleDemand);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(holyUnity);
        dealCycle1.add(blessedHammerBuff);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(grandCross1);
        dealCycle1.add(sacredBastionDot);
        dealCycle1.add(sacredBastionImpact1);
        dealCycle1.add(sacredBastionImpact2);

        dealCycle2.add(nobleDemand);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(holyUnity);
        dealCycle2.add(blessedHammerBuff);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(grandCross1);

        dealCycle3.add(nobleDemand);
        dealCycle3.add(holyUnity);
        dealCycle3.add(blessedHammerBuff);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);

        shortDealCycle.add(mightyMjolnir);
        shortDealCycle.add(sanctuary);

        while (getStart().before(getEnd())) {
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
                addSkillEvent(mapleWorldGoddessBlessing);
            }
            if (divineBrandCount >= 5) {
                getSkillEventList().add(
                        new SkillEvent(divineJudgement,
                        new Timestamp((long) (getStart().getTime() + divineBrandCount)),
                        new Timestamp((long) (getStart().getTime() + divineBrandCount)))
                );
                getEventTimeList().add(new Timestamp((long) (getStart().getTime() + divineBrandCount)));
                divineBrandCount -= 5;
            } else if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
                sacredBastionEndTime.setTime(getStart().getTime() + sacredBastionDot.getDotDuration());
                divineBrandCount += 10;
            } else if (cooldownCheck(dealCycle2) && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addDealCycle(dealCycle2);
            } else if (cooldownCheck(dealCycle3) && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            } else if (cooldownCheck(shortDealCycle)) {
                if (getStart().before(sacredBastionEndTime)) {
                    if ((sacredBastionEndTime.getTime() - getStart().getTime()) < (sanctuary.getDelay() + mightyMjolnir.getDelay())) {
                        divineBrandCount += ((double) sacredBastionEndTime.getTime() - (double) getStart().getTime()) / 500;
                    } else {
                        divineBrandCount += ((double) sanctuary.getDelay() + (double) mightyMjolnir.getDelay()) / 500;
                    }
                }
                addDealCycle(shortDealCycle);
            } else {
                if (getStart().before(sacredBastionEndTime)) {
                    if ((sacredBastionEndTime.getTime() - getStart().getTime()) < blast.getDelay()) {
                        divineBrandCount += ((double) sacredBastionEndTime.getTime() - (double) getStart().getTime()) / 500;
                    } else {
                        divineBrandCount += (double) blast.getDelay() / 500;
                    }
                }
                divineBrandCount += 1;
                addSkillEvent(blast);
            }
        }
        sortEventTimeList();
    }
}
