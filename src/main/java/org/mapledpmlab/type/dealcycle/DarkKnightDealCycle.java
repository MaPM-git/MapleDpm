package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.darkknight.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.darkknight.DarkThirst;
import org.mapledpmlab.type.skill.buffskill.darkknight.DarknessAura;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DarkKnightDealCycle extends DealCycle {

    /*
        다크나이트 딜사이클
        다크니스 오라(40초) -> 30초 전에 발동, 15스택 예열용
        오라웨폰(140초) - 에픽 어드벤쳐(60초) - 메용2(60초)
        크오솔(51초) - 스인미(50초)
        다크 서스트(25초) - 엔버(10초) - 시드링(15초)
        다크 스피어 - 비홀더 쇼크 - 비홀더 임팩트 - 데드 스페이스
        피어스 사이클론 - 다크니스 오라 막타
        
        쿨마다 사용
         - 비홀더 임팩트
         - 다크 스피어
         - 비홀더 쇼크
        
        비홀더 쇼크는 재사용 적용
        
        비홀더 임팩트 사용 중 비홀더 쇼크 사용 불가
     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 오라웨폰, 메용2, 다크 서스트, 엔버
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new DeadSpaceDarkAura());
            add(new DeadSpaceSlash());
            add(new FinalAttackDarkKnight());
            add(new GungnirDescent());
            add(new PiercingCyclone());
            add(new PiercingCycloneFinish());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new DarkSpearDelay());
            add(new DeadSpaceDelay());
            add(new PiercingCycloneDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new DarknessAura());
            add(new DarkThirst());
            add(new EpicAdventure());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
        }
    };

    public DarkKnightDealCycle(Job job) {
        super(job, new FinalAttackDarkKnight());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        AuraWeaponDot auraWeaponDot = new AuraWeaponDot();
        BeholderDominant beholderDominant = new BeholderDominant();
        BeholderImpact beholderImpact = new BeholderImpact();
        BeholderRevenge beholderRevenge = new BeholderRevenge();
        BeholderShock beholderShock = new BeholderShock();
        BeholderShockDarkWarfare beholderShockDarkWarfare = new BeholderShockDarkWarfare();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrestOfTheSolarDot crestOfTheSolarDot = new CrestOfTheSolarDot();
        DarknessAura darknessAura = new DarknessAura();
        DarknessAuraDot darknessAuraDot = new DarknessAuraDot();
        DarknessAuraFinish darknessAuraFinish = new DarknessAuraFinish();
        DarkSpear darkSpear = new DarkSpear();
        DarkThirst darkThirst = new DarkThirst();
        DeadSpaceDarkAura deadSpaceDarkAura = new DeadSpaceDarkAura();
        DeadSpaceSlash deadSpaceSlash = new DeadSpaceSlash();
        EpicAdventure epicAdventure = new EpicAdventure();
        FinalAttackDarkKnight finalAttackDarkKnight = new FinalAttackDarkKnight();
        GungnirDescent gungnirDescent = new GungnirDescent();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PiercingCyclone piercingCyclone = new PiercingCyclone();
        PiercingCycloneFinish piercingCycloneFinish = new PiercingCycloneFinish();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiderInMirrorDot spiderInMirrorDot = new SpiderInMirrorDot();
        ThiefCunning thiefCunning = new ThiefCunning();

        for (int i = 0; i < 720 * 1000; i += beholderRevenge.getInterval()) {
            getSkillEventList().add(new SkillEvent(beholderRevenge, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += beholderDominant.getInterval()) {
            getSkillEventList().add(new SkillEvent(beholderDominant, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = -27610; i < 12.39 * 1000; i += darknessAuraDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(darknessAuraDot, new Timestamp(i), new Timestamp(i)));
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

        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(darkThirst);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);      // 여기까지 3.63초 - 리레링 16.09초 전에 다크니스 오라 사용
        dealCycle1.add(beholderShock);
        dealCycle1.add(darkSpear);
        dealCycle1.add(beholderImpact);
        dealCycle1.add(deadSpaceSlash);
        dealCycle1.add(piercingCyclone);    // 여기까지 13.77초 - 극딜 26.23초 전에 다크니스 오라 사용
        dealCycle1.add(darknessAuraFinish);

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(darkThirst);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);      // 여기까지 3.63초 - 리레링 25.39초 전에 다크니스 오라 사용
        dealCycle2.add(beholderShock);
        dealCycle2.add(darkSpear);
        dealCycle2.add(beholderImpact);
        dealCycle2.add(piercingCyclone);    // 여기까지 9.12초 - 극딜 30.88초 전에 다크니스 오라 사용
        dealCycle2.add(darknessAuraFinish);

        dealCycle3.add(darkThirst);
        dealCycle3.add(soulContract);

        Timestamp beholderImpactEndTime = new Timestamp(0);
        Timestamp darknessAuraUseTime = new Timestamp(12 * 60 * 1000);
        Timestamp restraintRingActivateTime = new Timestamp(0);
        Timestamp beholderShockActivateTime = new Timestamp(0);
        Timestamp beholderImpactActivateTime = new Timestamp(0);
        Timestamp darkSpearActivateTime = new Timestamp(0);

        while (getStart().before(getEnd())) {
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    getStart().after(darknessAuraUseTime)
                    && getStart().after(darknessAuraDot.getActivateTime())
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(darknessAuraDot);
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
                restraintRingActivateTime = restraintRing.getActivateTime();
                beholderShockActivateTime = beholderShock.getActivateTime();
                darkSpearActivateTime = darkSpear.getActivateTime();
                darknessAuraUseTime = new Timestamp(restraintRingActivateTime.getTime() - 16090);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
                restraintRingActivateTime = restraintRing.getActivateTime();
                beholderShockActivateTime = beholderShock.getActivateTime();
                darkSpearActivateTime = darkSpear.getActivateTime();
                darknessAuraUseTime = new Timestamp(restraintRingActivateTime.getTime() - 25390);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().before(new Timestamp(restraintRingActivateTime.getTime() - 10000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(beholderShock)
                    && getStart().after(beholderImpactEndTime)
                    && restraintRingActivateTime.after(new Timestamp((long) (
                            beholderShockActivateTime.getTime()
                                    + applyCooldownReduction(beholderShock) * 1000
                                    - auraWeaponBuff.getDelay()
                                    - mapleWorldGoddessBlessing.getDelay()
                                    - darkThirst.getDelay()
                                    - soulContract.getDelay()
                                    - restraintRing.getDelay()
                    )))
            ) {
                addSkillEvent(beholderShock);
                beholderShockActivateTime = beholderShock.getActivateTime();
            } else if (
                    cooldownCheck(beholderImpact)
                    && beholderShockActivateTime.after(new Timestamp((long) (
                            beholderImpactActivateTime.getTime()
                                    + applyCooldownReduction(beholderImpact)
                                    - auraWeaponBuff.getDelay()
                                    - mapleWorldGoddessBlessing.getDelay()
                                    - darkThirst.getDelay()
                                    - soulContract.getDelay()
                                    - restraintRing.getDelay()
                                    - darkSpear.getDelay()
                    )))
            ) {
                beholderImpactEndTime = new Timestamp(getStart().getTime() + beholderImpact.getDotDuration());
                addSkillEvent(beholderImpact);
            } else if (
                    cooldownCheck(darkSpear)
                    && restraintRingActivateTime.after(new Timestamp((long) (
                    darkSpearActivateTime.getTime()
                            + applyCooldownReduction(beholderShock)
                            - auraWeaponBuff.getDelay()
                            - mapleWorldGoddessBlessing.getDelay()
                            - darkThirst.getDelay()
                            - soulContract.getDelay()
                            - restraintRing.getDelay()
                    )))
            ) {
                addSkillEvent(darkSpear);
                darkSpearActivateTime = darkSpear.getActivateTime();
            } else {
                addSkillEvent(gungnirDescent);
            }
        }
        sortEventTimeList();
    }
}
