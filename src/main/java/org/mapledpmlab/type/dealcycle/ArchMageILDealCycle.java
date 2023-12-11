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

    private List<Skill> dealCycle1 = new ArrayList<>();

    private List<Skill> dealCycle2 = new ArrayList<>();

    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<Skill> dealCycle4 = new ArrayList<>();

    private List<Skill> dealCycle5 = new ArrayList<>();

    private List<Skill> shortDealCycle = new ArrayList<>();

    private List<Timestamp> jupiterThunderStartList = new ArrayList<>();

    private List<Timestamp> jupiterThunderEndList = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new FrozenLightningDot());
            add(new FrozenLightningFragments());
            add(new FrozenOrb());
            add(new IceAge());
            add(new IceAgeDot());
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new FrozenLightningDelay());
            add(new FrozenOrbDelay());
            add(new JupiterThunderDelay());
            add(new LightningSpearDelay());
            add(new SpiritOfSnowDelay());
            add(new ThunderBreakDelay());
            add(new ThunderSpearDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
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

    public ArchMageILDealCycle(Job job) {
        super(job, new FinalAttackArchMageIL());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        ChainLightning chainLightning = new ChainLightning();
        ChainLightningElectric chainLightningElectric = new ChainLightningElectric();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        ElquinesSummon elquinesSummon = new ElquinesSummon();
        EpicAdventure epicAdventure = new EpicAdventure();
        FreezingBreathBuff freezingBreathBuff = new FreezingBreathBuff();
        FrozenLightning1 frozenLightning1 = new FrozenLightning1();
        FrozenOrb frozenOrb = new FrozenOrb();
        IceAgeDot iceAgeDot = new IceAgeDot();
        Infinity infinity = new Infinity(0L);
        JupiterThunder jupiterThunder = new JupiterThunder();
        LightningSphere lightningSphere = new LightningSphere();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiritOfSnow spiritOfSnow = new SpiritOfSnow();
        ThiefCunning thiefCunning = new ThiefCunning();
        ThunderBreak thunderBreak = new ThunderBreak();
        ThunderBreakDelay thunderBreakDelay = new ThunderBreakDelay();
        ThunderSpear thunderSpear = new ThunderSpear();
        ThunderSpearDelay thunderSpearDelay = new ThunderSpearDelay();
        UnstableMemorize unstableMemorize = new UnstableMemorize();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        // 인피니티 달구기
        getSkillEventList().add(new SkillEvent(new Infinity(70000L), getStart(), new Timestamp(61360)));
        getEventTimeList().add(getStart());
        getEventTimeList().add(new Timestamp(61360));

        // 썬더 스피어
        for (int i = 0; i < 720 * 1000; i += thunderSpear.getInterval()) {
            getSkillEventList().add(new SkillEvent(thunderSpear, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 엘퀴네스
        for (int i = 0; i < 720 * 1000; i += elquinesSummon.getInterval()) {
            getSkillEventList().add(new SkillEvent(elquinesSummon, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 전류지대
        for (int i = 0; i < 720 * 1000; i += chainLightningElectric.getInterval()) {
            getSkillEventList().add(new SkillEvent(chainLightningElectric, new Timestamp(i), new Timestamp(i)));
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

        ringSwitching.setCooldown(120.0);

        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(spiritOfSnow);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(iceAgeDot);
        dealCycle1.add(jupiterThunder);     // 9.9초 동안 전기 최종뎀 12퍼
        dealCycle1.add(frozenLightning1);
        dealCycle1.add(frozenOrb);
        dealCycle1.add(thunderBreak);
        dealCycle1.add(lightningSphere);
        dealCycle1.add(freezingBreathBuff);

        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(spiritOfSnow);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(iceAgeDot);
        dealCycle2.add(jupiterThunder);
        dealCycle2.add(frozenLightning1);
        dealCycle2.add(frozenOrb);
        dealCycle2.add(thunderBreak);
        dealCycle2.add(lightningSphere);

        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(epicAdventure);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(spiritOfSnow);
        dealCycle3.add(soulContract);
        dealCycle3.add(freezingBreathBuff);
        dealCycle3.add(restraintRing);
        dealCycle3.add(jupiterThunder);
        dealCycle3.add(iceAgeDot);
        dealCycle3.add(frozenOrb);
        dealCycle3.add(thunderBreak);
        dealCycle3.add(lightningSphere);

        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(epicAdventure);
        dealCycle4.add(spiritOfSnow);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(jupiterThunder);
        dealCycle4.add(iceAgeDot);
        dealCycle4.add(frozenOrb);
        dealCycle4.add(thunderBreak);
        dealCycle4.add(lightningSphere);

        dealCycle5.add(epicAdventure);
        dealCycle5.add(spiritOfSnow);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);
        dealCycle5.add(jupiterThunder);
        dealCycle5.add(iceAgeDot);
        dealCycle5.add(frozenOrb);
        dealCycle5.add(thunderBreak);
        dealCycle5.add(lightningSphere);

        shortDealCycle.add(soulContract);
        shortDealCycle.add(iceAgeDot);
        shortDealCycle.add(lightningSphere);

        Timestamp infinityEndTime = new Timestamp(61360);
        Timestamp infinityFinalTime = new Timestamp(0);

        int i = 0;
        while (getStart().before(getEnd())) {
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
            if (cooldownCheck(thunderSpearDelay)) {
                addSkillEvent(thunderBreakDelay);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().after(infinityFinalTime)
            ) {
                addDealCycle(dealCycle1);
                jupiterThunderStartList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder))));
                jupiterThunderEndList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder) + 10000)));
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().after(infinityFinalTime)
            ) {
                addDealCycle(dealCycle2);
                jupiterThunderStartList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder))));
                jupiterThunderEndList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder) + 10000)));
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().after(infinityFinalTime)
                    && getStart().before(new Timestamp(5 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
                jupiterThunderStartList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder))));
                jupiterThunderEndList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder) + 10000)));
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().after(infinityFinalTime)
                    && i > 140
            ) {
                addDealCycle(dealCycle4);
                jupiterThunderStartList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder))));
                jupiterThunderEndList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder) + 10000)));
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().after(infinityFinalTime)
            ) {
                addDealCycle(dealCycle5);
                jupiterThunderStartList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder))));
                jupiterThunderEndList.add(new Timestamp((long) (jupiterThunder.getActivateTime().getTime() - applyCooldownReduction(jupiterThunder) + 10000)));
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(70 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(shortDealCycle)
                    && epicAdventure.getActivateTime().after(new Timestamp((long) (
                            iceAgeDot.getActivateTime().getTime()
                            + applyCooldownReduction(iceAgeDot)
                            - mapleWorldGoddessBlessing.getDelay()
                    )))
            ) {
                addDealCycle(shortDealCycle);
            } else if (
                    cooldownCheck(thunderBreak)
                    && epicAdventure.getActivateTime().after(new Timestamp((long) (
                            thunderBreak.getActivateTime().getTime()
                            + applyCooldownReduction(thunderBreak)
                            - mapleWorldGoddessBlessing.getDelay()
                    )))
            ) {
                addSkillEvent(thunderBreak);
            } else if (
                    cooldownCheck(frozenOrb)
            ) {
                addSkillEvent(frozenOrb);
            } else {
                addSkillEvent(chainLightning);
            }
            i++;
        }

        sortEventTimeList();
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        if (skillEvent.getSkill() instanceof ThunderAttack) {
            for (int i = 0; i < jupiterThunderStartList.size(); i++) {
                if (
                        (start.after(jupiterThunderStartList.get(i)) || start.equals(jupiterThunderStartList.get(i)))
                        && (end.before(jupiterThunderEndList.get(i)) || end.equals(jupiterThunderEndList.get(i)))
                ) {
                    buffSkill.addBuffFinalDamage(1.12);
                }
            }
        }
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
