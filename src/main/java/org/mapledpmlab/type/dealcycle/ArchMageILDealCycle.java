package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.archmageil.*;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.archmageil.Elquines;
import org.mapledpmlab.type.skill.buffskill.archmageil.FreezingBreathBuff;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArchMageILDealCycle extends DealCycle {

    /*
        프로스트 이펙트 5중첩 유지
        썬더 스피어 무한 지속

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

        아이스 에이지, 라이트닝 스피어, 썬더 스피어, 썬더 브레이크, 프로즌 오브 쿨마다 사용

        6차 극딜 - 첫번째 리레 / 두번째 웨폰퍼프
        메용2(60초) - 에픽(60초) - 아이스 오라 설치 - 크오솔 - 스인미
        스피릿 오브 스노우(30초) - 엔버링크 - 시드링 - 아이스 에이지 - 주피터 썬더
        프로즌 라이트닝 - 프로즌 오브 - 썬더 브레이크 - 라이트닝 스피어 - 프리징 브레스(13초)

        극딜 - 메용2, 리레, 스인미, 크오솔
        메용2(60초) - 에픽(60초) - 아이스 오라 설치 - 크오솔 - 스인미
        스피릿 오브 스노우 - 엔버링크 - 프리징 브레스 - 시드링 - 주피터 썬더
        아이스 에이지 - 프로즌 오브 - 썬더 브레이크 - 라이트닝 스피어

        메용2, 웨폰퍼프
        메용2(60초) - 에픽(60초) - 아이스 오라 설치
        스피릿 오브 스노우 - 엔버링크 - 프리징 브레스 - 시드링 - 주피터 썬더
        아이스 에이지 - 프로즌 오브 - 썬더 브레이크 - 라이트닝 스피어

        웨폰퍼프
        에픽(60초) - 아이스 오라 설치
        스피릿 오브 스노우 - 엔버링크 - 프리징 브레스 - 시드링 - 주피터 썬더
        아이스 에이지 - 프로즌 오브 - 썬더 브레이크 - 라이트닝 스피어
     */

    private final List<Skill> dealCycle1 = new ArrayList<>();

    private final List<Skill> dealCycle2 = new ArrayList<>();

    private final List<Skill> dealCycle3 = new ArrayList<>();

    private final List<Skill> dealCycle4 = new ArrayList<>();

    private final List<Skill> dealCycle5 = new ArrayList<>();

    private final List<Skill> shortDealCycle = new ArrayList<>();

    private final List<Timestamp> jupiterThunderStartList = new ArrayList<>();

    private final List<Timestamp> jupiterThunderEndList = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ChainLightning());
            add(new ChainLightningElectric());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new ElquinesSummon());
            add(new FinalAttackArchMageIL());
            add(new FreezingBreath());
            add(new FrozenLightning1());
            add(new FrozenLightning2());
            add(new FrozenLightningEnlightenmentOfMana());
            add(new FrozenOrb());
            add(new IceAge());
            add(new IceAgeDot());
            add(new IceAura());
            add(new IceAuraInstall());
            add(new JupiterThunder());
            add(new JupiterThunderElectric());
            add(new LightningSphere());
            add(new LightningSphereFinish());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SpiritOfSnow());
            add(new ThunderBreak());
            add(new ThunderSpear());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new LightningSphereDelay());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new Elquines());
            add(new EpicAdventure());
            add(new FreezingBreathBuff());
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

    int frostEffect = 5;
    ChainLightningElectric chainLightningElectric = new ChainLightningElectric();

    public ArchMageILDealCycle(Job job) {
        super(job, new FinalAttackArchMageIL());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        ChainLightning chainLightning = new ChainLightning();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        ElquinesSummon elquinesSummon = new ElquinesSummon();
        EpicAdventure epicAdventure = new EpicAdventure();
        FreezingBreathBuff freezingBreathBuff = new FreezingBreathBuff();
        FrozenLightning1 frozenLightning1 = new FrozenLightning1();
        FrozenOrb frozenOrb = new FrozenOrb();
        IceAgeDot iceAgeDot = new IceAgeDot();
        IceAura iceAura = new IceAura();
        IceAuraInstall iceAuraInstall = new IceAuraInstall();
        Infinity infinity = new Infinity(0L);
        JupiterThunder jupiterThunder = new JupiterThunder();
        LightningSphereDelay lightningSphere = new LightningSphereDelay();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiritOfSnow spiritOfSnow = new SpiritOfSnow();
        ThiefCunning thiefCunning = new ThiefCunning();
        ThunderBreak thunderBreak = new ThunderBreak();
        ThunderSpear thunderSpear = new ThunderSpear();
        UnstableMemorize unstableMemorize = new UnstableMemorize();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        // 인피니티 달구기
        getStart().setTime(-60000);
        infinity.setActivateTime(new Timestamp(-70000));
        addSkillEvent(infinity);
        getStart().setTime(0);
        /*getSkillEventList().add(new SkillEvent(new Infinity(70000L), getStart(), new Timestamp(61360)));
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(61360));*/

        for (int i = 0; i < 720 * 1000; i += iceAura.getInterval()) {
            getSkillEventList().add(new SkillEvent(iceAura, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        dealCycle1.add(thunderSpear);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(iceAuraInstall);
        dealCycle1.add(spiritOfSnow);
        dealCycle1.add(soulContract);
        dealCycle1.add(freezingBreathBuff);
        dealCycle1.add(restraintRing);
        dealCycle1.add(iceAgeDot);
        dealCycle1.add(jupiterThunder);     // 9.9초 동안 전기 최종뎀 12퍼
        dealCycle1.add(frozenLightning1);
        dealCycle1.add(frozenOrb);
        dealCycle1.add(thunderBreak);
        dealCycle1.add(lightningSphere);

        dealCycle2.add(thunderSpear);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(iceAuraInstall);
        dealCycle2.add(spiritOfSnow);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(iceAgeDot);
        dealCycle2.add(jupiterThunder);
        dealCycle2.add(frozenLightning1);
        dealCycle2.add(frozenOrb);
        dealCycle2.add(thunderBreak);
        dealCycle2.add(lightningSphere);

        dealCycle3.add(thunderSpear);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(epicAdventure);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(iceAuraInstall);
        dealCycle3.add(spiritOfSnow);
        dealCycle3.add(soulContract);
        dealCycle3.add(freezingBreathBuff);
        dealCycle3.add(restraintRing);
        dealCycle3.add(jupiterThunder);
        dealCycle3.add(iceAgeDot);
        dealCycle3.add(frozenOrb);
        dealCycle3.add(thunderBreak);
        dealCycle3.add(lightningSphere);

        dealCycle4.add(thunderSpear);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(epicAdventure);
        dealCycle4.add(iceAuraInstall);
        dealCycle4.add(spiritOfSnow);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(jupiterThunder);
        dealCycle4.add(iceAgeDot);
        dealCycle4.add(frozenOrb);
        dealCycle4.add(thunderBreak);
        dealCycle4.add(lightningSphere);

        dealCycle5.add(thunderSpear);
        dealCycle5.add(epicAdventure);
        dealCycle5.add(iceAuraInstall);
        dealCycle5.add(spiritOfSnow);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);
        dealCycle5.add(jupiterThunder);
        dealCycle5.add(iceAgeDot);
        dealCycle5.add(frozenOrb);
        dealCycle5.add(thunderBreak);
        dealCycle5.add(lightningSphere);

        shortDealCycle.add(iceAuraInstall);
        shortDealCycle.add(soulContract);
        shortDealCycle.add(iceAgeDot);
        shortDealCycle.add(lightningSphere);

        Timestamp infinityEndTime = new Timestamp(61360);
        Timestamp infinityFinalTime = new Timestamp(0);

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(elquinesSummon)) {
                addSkillEvent(elquinesSummon);
            }
            if (
                    cooldownCheck(infinity)
                    && getStart().after(infinityEndTime)
            ) {
                infinityFinalTime = new Timestamp(getStart().getTime() + 60000);
                infinityEndTime = new Timestamp(getStart().getTime() + 121360);
                addSkillEvent(infinity);
            }
            if (
                    cooldownCheck(unstableMemorize)
                    && getStart().after(infinityEndTime)
            ) {
                infinityFinalTime = new Timestamp(getStart().getTime() + 60000);
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
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().after(infinityFinalTime)
                    && dealCycleOrder == 1
            ) {
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().after(infinityFinalTime)
                    && dealCycleOrder == 4
            ) {
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().after(infinityFinalTime)
                    && getStart().before(new Timestamp(5 * 60 * 1000))
                    && dealCycleOrder == 3
            ) {
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().after(infinityFinalTime)
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().after(infinityFinalTime)
                    && dealCycleOrder == 5
            ) {
                addDealCycle(dealCycle5);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(70 * 1000))
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(shortDealCycle)
                    && !cooldownCheck(epicAdventure)
            ) {
                addDealCycle(shortDealCycle);
            } else if (
                    cooldownCheck(thunderBreak)
                    && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(thunderBreak);
            } else if (
                    cooldownCheck(frozenOrb)
            ) {
                addSkillEvent(frozenOrb);
            } else {
                addSkillEvent(chainLightning);
            }
        }

        sortEventTimeList();
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        boolean isJupiter = false;
        if (
                skillEvent.getSkill() instanceof ThunderAttack
                && !(skillEvent.getSkill() instanceof FrozenLightning1)
                && !(skillEvent.getSkill() instanceof FrozenLightning2)
                && !(skillEvent.getSkill() instanceof FrozenLightningEnlightenmentOfMana)
        ) {
            for (int i = 0; i < jupiterThunderStartList.size(); i++) {
                if (
                        (start.after(jupiterThunderStartList.get(i)) || start.equals(jupiterThunderStartList.get(i)))
                        && (end.before(jupiterThunderEndList.get(i)) || end.equals(jupiterThunderEndList.get(i)))
                ) {
                    buffSkill.addBuffFinalDamage(1.12);
                    isJupiter = true;
                }
            }
        }
        if (skillEvent.getSkill() instanceof ThunderAttack) {
            buffSkill.addBuffDamage(12L * frostEffect);
            if (frostEffect > 0) {
                frostEffect --;
            }
        }
        buffSkill.addBuffCriticalDamage(3.0 * frostEffect);
        buffSkill.addBuffIgnoreDefense(2L * frostEffect);
        if (
                skillEvent.getSkill() instanceof FreezingBreath
                || skillEvent.getSkill() instanceof FinalAttackArchMageIL
                || skillEvent.getSkill() instanceof FrozenOrb
                || skillEvent.getSkill() instanceof ElquinesSummon
                || skillEvent.getSkill() instanceof IceAura
                || skillEvent.getSkill() instanceof IceAuraInstall
                || skillEvent.getSkill() instanceof IceAge
                || skillEvent.getSkill() instanceof IceAgeDot
        ) {
            frostEffect ++;
        }
        if (skillEvent.getSkill() instanceof SpiritOfSnow) {
            frostEffect += 3;
        }
        if (frostEffect > 5) {
            frostEffect = 5;
        }
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        if (
                attackSkill instanceof ChainLightning
                || attackSkill instanceof ChainLightningElectric
                || attackSkill instanceof ElquinesSummon
                || attackSkill instanceof FreezingBreath
                || attackSkill instanceof FrozenLightning1
                || attackSkill instanceof FrozenLightning2
                || attackSkill instanceof FrozenLightningEnlightenmentOfMana
                || attackSkill instanceof FrozenOrb
                || attackSkill instanceof IceAge
                || attackSkill instanceof JupiterThunder
                || attackSkill instanceof JupiterThunderElectric
                || attackSkill instanceof LightningSphere
                || attackSkill instanceof LightningSphereFinish
                || attackSkill instanceof SpiritOfSnow
                || attackSkill instanceof ThunderBreak
                || attackSkill instanceof ThunderSpear
        ) {
            buffSkill.addBuffFinalDamage(1.08);
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat()) * 4
                        + this.getJob().getFinalSubstat()) * 0.01
                        * (Math.floor((this.getJob().getMagic() + buffSkill.getBuffAttMagic())
                        * (1 + (this.getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + this.getJob().getPerXAtt())
                        * this.getJob().getConstant()
                        * (1 + (this.getJob().getDamage() + this.getJob().getBossDamage() + this.getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (this.getJob().getFinalDamage())
                        * buffSkill.getBuffFinalDamage()
                        * this.getJob().getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * this.getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (this.getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (this.getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - this.getJob().getIgnoreDefense()) * (1 - this.getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                this.getJob().addMainStat(-buffSkill.getBuffMainStat());
                this.getJob().addSubStat(-buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(-buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(-buffSkill.getBuffOtherStat2());
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                    as.setCumulativeAttackCount(as.getCumulativeAttackCount() + attackSkill.getAttackCount());
                }
                Long distance = end.getTime() - start.getTime();
                if (attackSkill.getMultiAttackInfo().size() == 0 && attackSkill.getInterval() == 0 && attackSkill.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / attackSkill.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        buffSkill.addBuffCriticalDamage(-3.0 * frostEffect);
        buffSkill.addBuffIgnoreDefense(-2L * frostEffect);
        if (isJupiter) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.12);
        }
        if (
                attackSkill instanceof ChainLightning
                        || attackSkill instanceof ChainLightningElectric
                        || attackSkill instanceof ElquinesSummon
                        || attackSkill instanceof FreezingBreath
                        || attackSkill instanceof FrozenLightning1
                        || attackSkill instanceof FrozenLightning2
                        || attackSkill instanceof FrozenLightningEnlightenmentOfMana
                        || attackSkill instanceof FrozenOrb
                        || attackSkill instanceof IceAge
                        || attackSkill instanceof JupiterThunder
                        || attackSkill instanceof JupiterThunderElectric
                        || attackSkill instanceof LightningSphere
                        || attackSkill instanceof LightningSphereFinish
                        || attackSkill instanceof SpiritOfSnow
                        || attackSkill instanceof ThunderBreak
                        || attackSkill instanceof ThunderSpear
        ) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.08);
        }
        return attackDamage;
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof JupiterThunder) {
            jupiterThunderStartList.add(new Timestamp(getStart().getTime()));
            jupiterThunderEndList.add(new Timestamp(getStart().getTime() + 13000));
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
                    if (skill instanceof ChainLightningElectric) {
                        continue;
                    }
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof IceAgeDot) {
                        i = 720;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof FrozenOrb) {
                        i = 1680;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 35) {
                    Long attackCount = 0L;
                    for (long i = chainLightningElectric.getInterval(); i <= chainLightningElectric.getDotDuration() && attackCount < chainLightningElectric.getLimitAttackCount(); i += chainLightningElectric.getInterval()) {
                        getSkillEventList().add(new SkillEvent(chainLightningElectric, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                } else if (cooldownCheck(chainLightningElectric)) {
                    addSkillEvent(chainLightningElectric);
                }
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
