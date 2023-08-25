package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.shadower.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.shadower.SmokeBomb;
import org.mapledpmlab.type.skill.buffskill.shadower.VeilOfShadowBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ShadowerDealCycle extends DealCycle {

    /*
        극딜: 얼닼사 에픽 메용2 레투다 엔버 바인드 암살멸귀참(캔슬) 시드링 소블 풀히트 암살 절개 평딜

        이후 소블 쿨 돌면 베일깔고 소블절개(캔슬)

        준극딜: 연막탄 레투다 엔버 암살멸귀참(캔슬) 소블 풀히트 암살 절개 평딜

        이후 소블 쿨 돌면 베일깔고 소블절개(캔슬)
     */

    // 6차, 리레, 연막탄, 얼닼사
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레, 6차X, 얼닼사
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜, 배오섀
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 준준극딜, 소닉 블로우 - 절개
    private List<Skill> dealCycle4 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new Assassination());
            add(new AssassinationFinish());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new Eviscerate());
            add(new Heartbreaker());
            add(new HeartbreakerFinish());
            add(new MesoExplosion());
            add(new SavageAssault1());
            add(new SavageAssault2());
            add(new SavageAssault3());
            add(new SlashShadowFormation());
            add(new SlashShadowFormationBoss());
            add(new SonicBlow());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new VeilOfShadow());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new DarkFlareDelay());
            add(new EviscerateDelay());
            add(new SavageAssaultDelay());
            add(new SlashShadowFormationDelay());
            add(new SonicBlowDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new DarkSight());
            add(new EpicAdventure());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new SmokeBomb());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UltimateDarkSight());
            add(new VeilOfShadowBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    public ShadowerDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        Long q = 0L;

        Assassination assassination = new Assassination();
        AssassinationFinish assassinationFinish = new AssassinationFinish();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrestOfTheSolarDot crestOfTheSolarDot = new CrestOfTheSolarDot();
        DarkFlare darkFlare = new DarkFlare();
        DarkFlareDelay darkFlareDelay = new DarkFlareDelay();
        EpicAdventure epicAdventure = new EpicAdventure();
        Eviscerate eviscerate = new Eviscerate();
        FatalVenom fatalVenom = new FatalVenom();
        Heartbreaker heartbreaker = new Heartbreaker();
        HeartbreakerFinish heartbreakerFinish = new HeartbreakerFinish();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MesoExplosion mesoExplosion = new MesoExplosion();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SavageAssault1 savageAssault1 = new SavageAssault1();
        SlashShadowFormation slashShadowFormation = new SlashShadowFormation();
        SmokeBomb smokeBomb = new SmokeBomb();
        SonicBlow sonicBlow = new SonicBlow();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiderInMirrorDot spiderInMirrorDot = new SpiderInMirrorDot();
        SuddenRaid suddenRaid = new SuddenRaid();
        ThiefCunning thiefCunning = new ThiefCunning();
        UltimateDarkSight ultimateDarkSight = new UltimateDarkSight();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        VeilOfShadow veilOfShadow = new VeilOfShadow();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 다크 플레어
        for (int i = 0; i < 720 * 1000; i += darkFlare.getInterval()) {
            getSkillEventList().add(new SkillEvent(darkFlare, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 페이탈 베놈
        for (int i = 0; i < 720 * 1000; i += fatalVenom.getInterval()) {
            getSkillEventList().add(new SkillEvent(fatalVenom, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ultimateDarkSight.setBuffFinalDamage(1.29);

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(ultimateDarkSight);
        dealCycle1.add(smokeBomb);
        dealCycle1.add(readyToDie);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(slashShadowFormation);
        dealCycle1.add(savageAssault1);
        dealCycle1.add(sonicBlow);
        dealCycle1.add(eviscerate);

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(ultimateDarkSight);
        dealCycle2.add(readyToDie);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(slashShadowFormation);
        dealCycle2.add(sonicBlow);
        dealCycle2.add(eviscerate);

        dealCycle3.add(veilOfShadow);
        dealCycle3.add(readyToDie);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(slashShadowFormation);
        dealCycle3.add(sonicBlow);
        dealCycle3.add(eviscerate);

        dealCycle4.add(sonicBlow);
        dealCycle4.add(eviscerate);

        Long coinCount = 0L;
        Long ran;

        while (getStart().before(getEnd())) {
            if (cooldownCheck(darkFlareDelay)) {
                addSkillEvent(darkFlareDelay);
            }
            if (
                    getStart().after(mapleWorldGoddessBlessing.getEndTime())
                            && getStart().before(new Timestamp(90 * 1000))
            ) {
                addSkillEvent(mapleWorldGoddessBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
                mesoExplosion.setCoinCount(20L);
                addSkillEvent(mesoExplosion);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
                mesoExplosion.setCoinCount(20L);
                addSkillEvent(mesoExplosion);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
                mesoExplosion.setCoinCount(20L);
                addSkillEvent(mesoExplosion);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            } else if (cooldownCheck(dealCycle4)) {
                addDealCycle(dealCycle4);
                mesoExplosion.setCoinCount(20L);
                addSkillEvent(mesoExplosion);
            } else if (
                    cooldownCheck(heartbreaker)
                    && getStart().before(new Timestamp(sonicBlow.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(heartbreaker);
                for (int i = 0; i < heartbreaker.getAttackCount() * 2; i++) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 40) {
                        coinCount ++;
                    }
                }
                mesoExplosion.setCoinCount(coinCount);
                coinCount = 0L;
                addSkillEvent(mesoExplosion);
                addSkillEvent(heartbreakerFinish);
                for (int i = 0; i < heartbreakerFinish.getAttackCount() * 2; i++) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 40) {
                        coinCount ++;
                    }
                }
                mesoExplosion.setCoinCount(coinCount);
                coinCount = 0L;
                addSkillEvent(mesoExplosion);
            } else {
                addSkillEvent(assassination);
                for (int i = 0; i < assassination.getAttackCount() * 2; i++) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 40) {
                        coinCount ++;
                    }
                }
                mesoExplosion.setCoinCount(coinCount);
                coinCount = 0L;
                addSkillEvent(mesoExplosion);
                addSkillEvent(assassinationFinish);
                for (int i = 0; i < assassinationFinish.getAttackCount() * 2; i++) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 40) {
                        coinCount ++;
                    }
                }
                mesoExplosion.setCoinCount(coinCount);
                coinCount = 0L;
                addSkillEvent(mesoExplosion);
            }
        }
        sortEventTimeList();
    }
}
