package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.archmagefp.*;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.archmagefp.Ifrit;
import org.mapledpmlab.type.skill.buffskill.archmagefp.InfernalVenomBuff;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArchMageFPDealCycle extends DealCycle {

    /*
        파이어 오라, 메기도 플레임, 이프리트, 플레임 헤이즈, 플레임 스윕, 포이즌 미스트, 텔레포트 마스터리 7개 도트 상시 중첩

        불독 딜사이클
        인피니티 지속시간(벞지 196%) - 121.36초
        인피니티 달구기(최대까지 60초) - 극딜 60초 전에 인피니티 사용
        인피니티 쿨타임 180초(169.8초)
        언스태이블 메모라이즈 쿨타임 및 확률
        20% 258.4초  1%
        23% 248.71초 6%
        24% 245.48초 6%
        25% 242.25초 6%
        27% 235.79초 10%
        30% 226.1초  11%
        33% 216.41초 12%
        35% 209.95초 12%
        38% 200.26초 12%
        40% 193.8초  8%
        45% 177.65초 6%
        50% 161.5초  5%
        55% 145.35초 2%
        60% 129.2초  2%
        65% 113.05초 1%

        6차 극딜
        메용2(60초) - 에픽(60초) - 크오솔 - 스인미 - 엔버링크 - 시드링 - 인페르날 베놈
        퓨리 오브 이프리트 - 포이즌 노바 - 도트 퍼니셔 - 포이즌 체인 - 미스트 이럽션
        + 스윕 / 플레임 헤이즈 + 미스트 이럽션

        극딜
        메용2(60초) - 에픽(60초) - 크오솔 - 스인미 - 플레임 헤이즈 - 플레임 스윕
        텔레포트 마스터리 - 엔버링크 - 메기도 플레임 - 시드링 - 퓨리 오브 이프리트
        포이즌 노바 - 도트 퍼니셔 - 포이즌 체인 - 미스트 이럽션

        준극딜
        메용2(60초) - 플레임 헤이즈 - 플레임 스윕 - 텔레포트 마스터리 - 엔버링크
        메기도 플레임 - 시드링 - 퓨리오브 이프리트 - 포이즌 노바 - 도트 퍼니셔
        포이즌 체인 - 미스트 이럽션

        짧은쿨 극딜
        포이즌 노바, 도트 퍼니셔, 포이즌 체인, 미스트 이럽션

        쿨마다 사용
        포이즌 리젼, 메기도 플레임
        
        쿨마다 사용
        플레임 헤이즈 - 미스트 이럽션

        텔레포트 8초마다 사용
     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 쿨마다 사용   6차후 도퍼노바
    private List<Skill> shortDealCycle1 = new ArrayList<>();

    // 쿨마다 사용   6차 X 도퍼노바
    private List<Skill> shortDealCycle2 = new ArrayList<>();

    // 쿨마다 사용   헤이즈 이럽션
    private List<Skill> shortDealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DotPunisherAfterSecond());
            add(new DotPunisherDot());
            add(new DotPunisherFirst());
            add(new DotPunisherOriginAfterSecond());
            add(new DotPunisherOriginDot());
            add(new DotPunisherOriginFirst());
            add(new FinalAttackArchMageFP());
            add(new FireAura());
            add(new FireAuraDot());
            add(new FlameHaze());
            add(new FlameHazeDot());
            add(new FlameSweep());
            add(new FlameSweepDot());
            add(new FlameSweepExplosion());
            add(new FuryOfIfrit());
            add(new FuryOfIfritOrigin());
            add(new IfritDot());
            add(new IfritSummon());
            add(new Ignite());
            add(new InfernalVenomExplosion1());
            add(new InfernalVenomExplosion2());
            add(new MegidoFlame());
            add(new MegidoFlameDot());
            add(new MistEruption());
            add(new PoisonMist());
            add(new PoisonChain());
            add(new PoisonChainExplosion());
            add(new PoisonNova());
            add(new PoisonNovaDot());
            add(new PoisonNovaExplosion());
            add(new PoisonNovaExplosionAfterThird());
            add(new PoisonZoneDot());
            add(new PoisonZoneExplosion());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TeleportMastery());
            add(new TeleportMasteryDot());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new FuryOfIfritDelay());
            add(new FuryOfIfritOriginDelay());
            add(new MegidoFlameDelay());
            add(new PoisonZoneDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new EpicAdventure());
            add(new Ifrit());
            add(new InfernalVenomBuff());
            add(new Infinity(0L));
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UnstableMemorize());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    public ArchMageFPDealCycle(Job job) {
        super(job, new FinalAttackArchMageFP());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrestOfTheSolarDot crestOfTheSolarDot = new CrestOfTheSolarDot();
        DotPunisherAfterSecond dotPunisherAfterSecond = new DotPunisherAfterSecond();
        DotPunisherDot dotPunisherDot = new DotPunisherDot();
        DotPunisherFirst dotPunisherFirst = new DotPunisherFirst();
        DotPunisherOriginAfterSecond dotPunisherOriginAfterSecond = new DotPunisherOriginAfterSecond();
        DotPunisherOriginDot dotPunisherOriginDot = new DotPunisherOriginDot();
        DotPunisherOriginFirst dotPunisherOriginFirst = new DotPunisherOriginFirst();
        EpicAdventure epicAdventure = new EpicAdventure();
        FinalAttackArchMageFP finalAttackArchMageFP = new FinalAttackArchMageFP();
        FireAura fireAura = new FireAura();
        FireAuraDot fireAuraDot = new FireAuraDot();
        FlameHaze flameHaze = new FlameHaze();
        FlameHazeDot flameHazeDot = new FlameHazeDot();
        FlameSweep flameSweep = new FlameSweep();
        FlameSweepDot flameSweepDot = new FlameSweepDot();
        FlameSweepExplosion flameSweepExplosion = new FlameSweepExplosion();
        FuryOfIfrit furyOfIfrit = new FuryOfIfrit();
        FuryOfIfritDelay furyOfIfritDelay = new FuryOfIfritDelay();
        FuryOfIfritOrigin furyOfIfritOrigin = new FuryOfIfritOrigin();
        FuryOfIfritOriginDelay furyOfIfritOriginDelay = new FuryOfIfritOriginDelay();
        Ifrit ifrit = new Ifrit();
        IfritDot ifritDot = new IfritDot();
        IfritSummon ifritSummon = new IfritSummon();
        Ignite ignite = new Ignite();
        InfernalVenomBuff infernalVenomBuff = new InfernalVenomBuff();
        InfernalVenomExplosion1 infernalVenomExplosion1 = new InfernalVenomExplosion1();
        InfernalVenomExplosion2 infernalVenomExplosion2 = new InfernalVenomExplosion2();
        Infinity infinity = new Infinity(0L);
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MegidoFlame megidoFlame = new MegidoFlame();
        MegidoFlameDot megidoFlameDot = new MegidoFlameDot();
        Meteor meteor = new Meteor();
        MistEruption mistEruption = new MistEruption();
        PoisonChain poisonChain = new PoisonChain();
        PoisonChainExplosion poisonChainExplosion = new PoisonChainExplosion();
        PoisonNova poisonNova = new PoisonNova();
        PoisonNovaDot poisonNovaDot = new PoisonNovaDot();
        PoisonNovaExplosion poisonNovaExplosion = new PoisonNovaExplosion();
        PoisonNovaExplosionAfterThird poisonNovaExplosionAfterThird = new PoisonNovaExplosionAfterThird();
        PoisonMist poisonMist = new PoisonMist();
        PoisonZoneDelay poisonZoneDelay = new PoisonZoneDelay();
        PoisonZoneDot poisonZoneDot = new PoisonZoneDot();
        PoisonZoneExplosion poisonZoneExplosion = new PoisonZoneExplosion();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        RiskTakerRing riskTakerRing = new RiskTakerRing();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiderInMirrorDot spiderInMirrorDot = new SpiderInMirrorDot();
        TeleportMastery teleportMastery = new TeleportMastery();
        TeleportMasteryDot teleportMasteryDot = new TeleportMasteryDot();
        ThiefCunning thiefCunning = new ThiefCunning();
        UnstableMemorize unstableMemorize = new UnstableMemorize();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        // 파이어 오라
        for (int i = 0; i < 720 * 1000; i += fireAura.getInterval()) {
            getSkillEventList().add(new SkillEvent(fireAura, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 파이어 오라 도트
        for (int i = 0; i < 720 * 1000; i += fireAuraDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(fireAuraDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 메기도 플레임
        for (int i = 0; i < 720 * 1000; i += megidoFlameDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(megidoFlameDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 이프리트 도트
        for (int i = 0; i < 720 * 1000; i += ifritDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(ifritDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 이프리트 소환수
        for (int i = 0; i < 720 * 1000; i += ifritSummon.getInterval()) {
            getSkillEventList().add(new SkillEvent(ifritSummon, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 이그나이트
        for (int i = 0; i < 720 * 1000; i += ignite.getInterval()) {
            getSkillEventList().add(new SkillEvent(ignite, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 플레임 헤이즈
        for (int i = 0; i < 720 * 1000; i += flameHazeDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(flameHazeDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 플레임 스윕
        for (int i = 0; i < 720 * 1000; i += flameSweepDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(flameSweepDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 포이즌 미스트
        for (int i = 0; i < 720 * 1000; i += poisonMist.getInterval()) {
            getSkillEventList().add(new SkillEvent(poisonMist, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 텔레포트 마스터리
        for (int i = 0; i < 720 * 1000; i += teleportMasteryDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(teleportMasteryDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 포이즌 리젼 맹독 지대 폭발
        for (long i = 0; i < 720 * 1000; i += poisonZoneExplosion.getInterval()) {
            getSkillEventList().add(new SkillEvent(poisonZoneExplosion, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 인피니티 달구기
        getSkillEventList().add(new SkillEvent(new Infinity(70000L), getStart(), new Timestamp(61360)));
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(61360));

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(110.0);

        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(infernalVenomExplosion1);
        dealCycle1.add(furyOfIfritOriginDelay);
        dealCycle1.add(poisonNovaDot);
        dealCycle1.add(dotPunisherOriginFirst);
        dealCycle1.add(poisonChainExplosion);
        dealCycle1.add(mistEruption);
        dealCycle1.add(poisonNovaExplosion);

        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(flameHaze);
        dealCycle2.add(flameSweep);
        dealCycle2.add(teleportMastery);
        dealCycle2.add(soulContract);
        dealCycle2.add(megidoFlame);
        dealCycle2.add(restraintRing);
        dealCycle2.add(furyOfIfritDelay);
        dealCycle2.add(poisonNovaDot);
        dealCycle2.add(dotPunisherFirst);
        dealCycle2.add(poisonChainExplosion);
        dealCycle2.add(mistEruption);
        dealCycle2.add(poisonNovaExplosion);

        dealCycle3.add(flameHaze);
        dealCycle3.add(flameSweep);
        dealCycle3.add(teleportMastery);
        dealCycle3.add(soulContract);
        dealCycle3.add(megidoFlame);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(furyOfIfritDelay);
        dealCycle3.add(poisonNovaDot);
        dealCycle3.add(dotPunisherFirst);
        dealCycle3.add(poisonChainExplosion);
        dealCycle3.add(mistEruption);
        dealCycle3.add(poisonNovaExplosion);

        shortDealCycle1.add(poisonNovaDot);
        shortDealCycle1.add(dotPunisherOriginFirst);
        shortDealCycle1.add(poisonChainExplosion);
        shortDealCycle1.add(mistEruption);
        shortDealCycle1.add(poisonNovaExplosion);

        shortDealCycle2.add(poisonNovaDot);
        shortDealCycle2.add(dotPunisherFirst);
        shortDealCycle2.add(poisonChainExplosion);
        shortDealCycle2.add(mistEruption);
        shortDealCycle2.add(poisonNovaExplosion);

        shortDealCycle3.add(flameHaze);
        shortDealCycle3.add(mistEruption);

        Timestamp infernalVenomEndTime = new Timestamp(0);
        Timestamp infinityEndTime = new Timestamp(61360);

        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(infinity)
                    && getStart().after(infinityEndTime)
            ) {
                infinityEndTime = new Timestamp(getStart().getTime() + 121360);
                addSkillEvent(infinity);
            }
            if (
                    cooldownCheck(unstableMemorize)
                    && getStart().after(infinityEndTime)
            ) {
                infinityEndTime = new Timestamp(getStart().getTime() + unstableMemorize.getDelay() + 121360);
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 1) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.8);
                } else if (ran <= 7) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.77);
                } else if (ran <= 13) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.76);
                } else if (ran <= 19) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.75);
                } else if (ran <= 29) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.73);
                } else if (ran <= 40) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.7);
                } else if (ran <= 52) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.67);
                } else if (ran <= 64) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.65);
                } else if (ran <= 76) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.62);
                } else if (ran <= 84) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.60);
                } else if (ran <= 90) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.55);
                } else if (ran <= 95) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.5);
                } else if (ran <= 97) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.45);
                } else if (ran <= 99) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.4);
                } else if (ran <= 100) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.35);
                }
                addSkillEvent(unstableMemorize);
            }
            if (cooldownCheck(ifrit)) {
                addSkillEvent(ifrit);
            }
            if (cooldownCheck(poisonZoneDelay)) {
                addSkillEvent(poisonZoneDelay);
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
                infernalVenomEndTime = new Timestamp(getStart().getTime() + 2940 + infernalVenomBuff.getDuration() * 1000);
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
                dotPunisherFirst.setActivateTime(dotPunisherOriginFirst.getActivateTime());
                furyOfIfritDelay.setActivateTime(furyOfIfritOriginDelay.getActivateTime());
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
                dotPunisherOriginFirst.setActivateTime(dotPunisherFirst.getActivateTime());
                furyOfIfritOriginDelay.setActivateTime(furyOfIfritDelay.getActivateTime());
            } else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
                dotPunisherOriginFirst.setActivateTime(dotPunisherFirst.getActivateTime());
                furyOfIfritOriginDelay.setActivateTime(furyOfIfritDelay.getActivateTime());
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(70 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(megidoFlame)
                    && soulContract.getActivateTime().after(new Timestamp((long) (
                            megidoFlame.getActivateTime().getTime()
                            + applyCooldownReduction(megidoFlame) * 1000
                            - mapleWorldGoddessBlessing.getDelay()
                            - flameHaze.getDelay()
                            - flameSweep.getDelay()
                            - teleportMastery.getDelay()
                            - soulContract.getDelay()
                    )))
            ) {
                addSkillEvent(megidoFlame);
            } else if (
                    cooldownCheck(poisonNovaDot)
                    && getStart().before(infernalVenomEndTime)
            ) {
                addDealCycle(shortDealCycle1);
                dotPunisherFirst.setActivateTime(dotPunisherOriginFirst.getActivateTime());
                furyOfIfritDelay.setActivateTime(furyOfIfritOriginDelay.getActivateTime());
            } else if (
                    cooldownCheck(poisonNovaDot)
                    && soulContract.getActivateTime().after(new Timestamp((long) (
                            poisonNovaDot.getActivateTime().getTime()
                                    + applyCooldownReduction(poisonNovaDot) * 1000
                                    - mapleWorldGoddessBlessing.getDelay()
                                    - flameHaze.getDelay()
                                    - flameSweep.getDelay()
                                    - teleportMastery.getDelay()
                                    + soulContract.getDelay()
                                    + megidoFlame.getDelay()
                                    + furyOfIfritDelay.getDelay()
                    )))
            ) {
                addDealCycle(shortDealCycle2);
                dotPunisherOriginFirst.setActivateTime(dotPunisherFirst.getActivateTime());
                furyOfIfritOriginDelay.setActivateTime(furyOfIfritDelay.getActivateTime());
            } else if (
                    cooldownCheck(shortDealCycle3)
                    && !cooldownCheck(soulContract)
            ) {
                addDealCycle(shortDealCycle3);
            } else if (
                    cooldownCheck(teleportMastery)
                    && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(teleportMastery);
            } else {
                addSkillEvent(flameSweep);
            }
        }

        sortEventTimeList();
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                        + this.getJob().getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
                        * (Math.floor((this.getJob().getMagic() + buffSkill.getBuffAttMagic())
                        * (1 + (this.getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + this.getJob().getPerXAtt())
                        * this.getJob().getConstant()
                        * (1 + (this.getJob().getDamage() + this.getJob().getBossDamage() + this.getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (this.getJob().getFinalDamage() + buffSkill.getBuffPlusFinalDamage() - 1)
                        * buffSkill.getBuffFinalDamage()
                        * this.getJob().getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * this.getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (this.getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (this.getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3 * (1 - buffSkill.getIgnoreDefense()) * (1 - this.getJob().getIgnoreDefense()) * (1 - this.getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                }
                Long distance = end.getTime() - start.getTime();
                if (as.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / as.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        return attackDamage;
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
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
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                if (skill instanceof Infinity) {
                    for (long i = 0; i < 60000; i += 4000) {
                        getSkillEventList().add(new SkillEvent(new Infinity(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 4000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 4000));
                    }
                    getSkillEventList().add(new SkillEvent(new Infinity(60000L), new Timestamp(getStart().getTime() + 60000), new Timestamp(getStart().getTime() + 121360)));
                    endTime = new Timestamp(getStart().getTime() + 121360);
                } else {
                    endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
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
                this.getSkillEventList().removeAll(remove);
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
            } else {
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
