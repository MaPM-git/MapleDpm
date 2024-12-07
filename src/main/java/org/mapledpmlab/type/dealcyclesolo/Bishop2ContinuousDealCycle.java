package org.mapledpmlab.type.dealcyclesolo;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.bishop.*;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.bishop.*;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Bishop2ContinuousDealCycle extends DealCycle {

    /*
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
     */

    private boolean isPray = false;

    private boolean isAngelOfLibraCharity = false;

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AngelicOfJudgement());
            add(new AngelicRay());
            add(new AngelicTouch());
            add(new AngelOfLibraRevenge2());
            add(new BahamutSummon());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DivinePunishmentDelay());
            add(new DivinePunishment());
            add(new DivinePunishment2());
            add(new DivinePunishment3());
            add(new FountainForAngel());
            add(new HeavensDoor());
            add(new HolyAdvent1());
            add(new HolyAdvent2());
            add(new HolyAdventBalance());
            add(new HolyAdventCharity());
            add(new HolyAdventRevenge());
            add(new Peacemaker());
            add(new PeacemakerFinish());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TriumphFeather());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AngelOfLibra2());
            add(new AngelOfLibraCharity(0L));
            add(new ContinuousRing());
            add(new EpicAdventure());
            add(new HolyAdventBuff());
            add(new HolyBlood());
            add(new Infinity(0L));
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PeacemakerBuff());
            add(new Pray2(0L));
            add(new SoulContract());
            add(new UnstableMemorize());
        }
    };

    Long holySwordCount = 0L;   // 성검 개수

    boolean angelOfLibraRevengeAttack = false;
    boolean isNuke = false;

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp infinityBurningTime = new Timestamp(0);
    Timestamp infinityEndTime = new Timestamp(0);

    AngelicOfJudgement angelicOfJudgement = new AngelicOfJudgement();
    AngelOfLibra2 angelOfLibra = new AngelOfLibra2();
    AngelicRay angelicRay = new AngelicRay();
    AngelicTouch angelicTouch = new AngelicTouch();
    BahamutSummon bahamutSummon = new BahamutSummon();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DivinePunishmentDelay divinePunishment = new DivinePunishmentDelay();
    DivinePunishmentDelay divinePunishment2 = new DivinePunishmentDelay();
    DivinePunishmentDelay divinePunishment3 = new DivinePunishmentDelay();
    FountainForAngel fountainForAngel = new FountainForAngel();
    EpicAdventure epicAdventure = new EpicAdventure();
    HeavensDoor heavensDoor = new HeavensDoor();
    HolyAdventBuff holyAdvent = new HolyAdventBuff();
    HolyBlood holyBlood = new HolyBlood();
    Infinity infinity = new Infinity(0L);
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    Peacemaker peacemaker = new Peacemaker();
    Pray2 pray = new Pray2(0L);
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    TriumphFeather triumphFeather = new TriumphFeather();
    UnstableMemorize unstableMemorize = new UnstableMemorize();

    public Bishop2ContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;

        // 인피니티 달구기
        getStart().setTime(-75000);
        infinity.setActivateTime(new Timestamp(-80000));
        addSkillEvent(infinity);
        getStart().setTime(0);

        mapleWorldGoddessBlessing.setCooldown(120.0);

        divinePunishment2.setRelatedSkill(new DivinePunishment2());
        divinePunishment2.setCooldown(22.0);

        divinePunishment3.setRelatedSkill(new DivinePunishment3());
        divinePunishment3.setCooldown(33.0);

        addSkillEvent(bahamutSummon);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(infinity)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
            ) {
                infinityEndTime = new Timestamp(getStart().getTime() + 121360);
                addSkillEvent(infinity);
            }
            if (
                    cooldownCheck(unstableMemorize)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
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
            if (cooldownCheck(fountainForAngel)) {
                addSkillEvent(fountainForAngel);
            }
            if (cooldownCheck(angelicTouch)) {
                addSkillEvent(angelicTouch);
            }
            if (cooldownCheck(angelOfLibra)) {
                if (
                        dealCycleOrder == 1
                                || dealCycleOrder == 3
                ) {
                    isNuke = true;
                }
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(pray);
                addSkillEvent(angelOfLibra);
                addSkillEvent(soulContract);
                addSkillEvent(holyBlood);
                while (!cooldownCheck(peacemaker)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(peacemaker);
                addSkillEvent(heavensDoor);
                if (cooldownCheck(holyAdvent)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                    addSkillEvent(holyAdvent);
                    while (getStart().before(new Timestamp(continuousRing.getActivateTime().getTime() - 240))) {
                        addSkillEvent(angelicRay);
                        if (holySwordCount >= 24) {
                            addSkillEvent(angelicOfJudgement);
                            holySwordCount -= 24;
                        }
                    }
                    addSkillEvent(divinePunishment);
                } else {
                    if ((continuousRingEndTime.getTime() - getStart().getTime()) < 5000) {
                        while (getStart().before(new Timestamp(continuousRing.getActivateTime().getTime() - 240))) {
                            addSkillEvent(angelicRay);
                            if (holySwordCount >= 24) {
                                addSkillEvent(angelicOfJudgement);
                                holySwordCount -= 24;
                            }
                        }
                    }
                    while (!cooldownCheck(divinePunishment))
                    if (!cooldownCheck(divinePunishment)) {
                        addSkillEvent(angelicRay);
                        if (holySwordCount >= 24) {
                            addSkillEvent(angelicOfJudgement);
                            holySwordCount -= 24;
                        }
                    }
                    addSkillEvent(divinePunishment);
                }
                dealCycleOrder ++;
                isNuke = false;
            } else if (
                    cooldownCheck(divinePunishment2)
                    && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 70000))
            ) {
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(soulContract);
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
            } else if (
                    cooldownCheck(peacemaker)
                    && getStart().before(new Timestamp(holyBlood.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(peacemaker);
            } else {
                addSkillEvent(angelicRay);
                if (holySwordCount >= 24) {
                    addSkillEvent(angelicOfJudgement);
                    holySwordCount -= 24;
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void setDuoDealCycle() {
        int dealCycleOrder = 1;

        // 인피니티 달구기
        getStart().setTime(-75000);
        infinity.setActivateTime(new Timestamp(-80000));
        addSkillEvent(infinity);
        getStart().setTime(0);

        mapleWorldGoddessBlessing.setCooldown(120.0);

        divinePunishment2.setRelatedSkill(new DivinePunishment2());
        divinePunishment2.setCooldown(22.0);

        divinePunishment3.setRelatedSkill(new DivinePunishment3());
        divinePunishment3.setCooldown(33.0);

        addSkillEvent(bahamutSummon);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(infinity)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
            ) {
                infinityEndTime = new Timestamp(getStart().getTime() + 121360);
                addSkillEvent(infinity);
            }
            if (
                    cooldownCheck(unstableMemorize)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
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
            if (cooldownCheck(fountainForAngel)) {
                addSkillEvent(fountainForAngel);
            }
            if (cooldownCheck(angelicTouch)) {
                addSkillEvent(angelicTouch);
            }
            if (cooldownCheck(holyBlood)) {
                if (
                        dealCycleOrder == 1
                                || dealCycleOrder == 3
                ) {
                    isNuke = true;
                }
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(soulContract);
                addSkillEvent(holyBlood);
                while (!cooldownCheck(peacemaker)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(peacemaker);
                addSkillEvent(heavensDoor);
                if (cooldownCheck(holyAdvent)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                    addSkillEvent(holyAdvent);
                    while (getStart().before(new Timestamp(continuousRing.getActivateTime().getTime() - 240))) {
                        addSkillEvent(angelicRay);
                        if (holySwordCount >= 24) {
                            addSkillEvent(angelicOfJudgement);
                            holySwordCount -= 24;
                        }
                    }
                    addSkillEvent(divinePunishment);
                } else {
                    if ((continuousRingEndTime.getTime() - getStart().getTime()) < 5000) {
                        while (getStart().before(new Timestamp(continuousRing.getActivateTime().getTime() - 240))) {
                            addSkillEvent(angelicRay);
                            if (holySwordCount >= 24) {
                                addSkillEvent(angelicOfJudgement);
                                holySwordCount -= 24;
                            }
                        }
                    }
                    while (!cooldownCheck(divinePunishment))
                        if (!cooldownCheck(divinePunishment)) {
                            addSkillEvent(angelicRay);
                            if (holySwordCount >= 24) {
                                addSkillEvent(angelicOfJudgement);
                                holySwordCount -= 24;
                            }
                        }
                    addSkillEvent(divinePunishment);
                }
                dealCycleOrder ++;
                isNuke = false;
            } else if (
                    cooldownCheck(divinePunishment2)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 70000))
            ) {
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(pray);
                addSkillEvent(angelOfLibra);
                addSkillEvent(soulContract);
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
            } else if (
                    cooldownCheck(peacemaker)
                            && getStart().before(new Timestamp(holyBlood.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(peacemaker);
            } else {
                addSkillEvent(angelicRay);
                if (holySwordCount >= 24) {
                    addSkillEvent(angelicOfJudgement);
                    holySwordCount -= 24;
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void setDuoDealCycle2() {
        int dealCycleOrder = 1;

        // 인피니티 달구기
        getStart().setTime(-15000);
        infinity.setActivateTime(new Timestamp(-80000));
        addSkillEvent(infinity);
        getStart().setTime(0);

        mapleWorldGoddessBlessing.setCooldown(120.0);

        divinePunishment2.setRelatedSkill(new DivinePunishment2());
        divinePunishment2.setCooldown(22.0);

        divinePunishment3.setRelatedSkill(new DivinePunishment3());
        divinePunishment3.setCooldown(33.0);

        angelOfLibra.setActivateTime(new Timestamp(60 * 1000));
        epicAdventure.setActivateTime(new Timestamp(60 * 1000));
        holyBlood.setActivateTime(new Timestamp(60 * 1000));

        addSkillEvent(bahamutSummon);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(infinity)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
            ) {
                infinityEndTime = new Timestamp(getStart().getTime() + 121360);
                addSkillEvent(infinity);
            }
            if (
                    cooldownCheck(unstableMemorize)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
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
            if (cooldownCheck(fountainForAngel)) {
                addSkillEvent(fountainForAngel);
            }
            if (cooldownCheck(angelicTouch)) {
                addSkillEvent(angelicTouch);
            }
            if (cooldownCheck(angelOfLibra)) {
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(pray);
                addSkillEvent(angelOfLibra);
                addSkillEvent(soulContract);
                addSkillEvent(holyBlood);
                while (!cooldownCheck(peacemaker)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(peacemaker);
                addSkillEvent(heavensDoor);
                if (cooldownCheck(holyAdvent)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                    addSkillEvent(holyAdvent);
                    while (getStart().before(new Timestamp(continuousRing.getActivateTime().getTime() - 240))) {
                        addSkillEvent(angelicRay);
                        if (holySwordCount >= 24) {
                            addSkillEvent(angelicOfJudgement);
                            holySwordCount -= 24;
                        }
                    }
                    addSkillEvent(divinePunishment);
                } else {
                    if ((continuousRingEndTime.getTime() - getStart().getTime()) < 5000) {
                        while (getStart().before(new Timestamp(continuousRing.getActivateTime().getTime() - 240))) {
                            addSkillEvent(angelicRay);
                            if (holySwordCount >= 24) {
                                addSkillEvent(angelicOfJudgement);
                                holySwordCount -= 24;
                            }
                        }
                    }
                    while (!cooldownCheck(divinePunishment))
                        if (!cooldownCheck(divinePunishment)) {
                            addSkillEvent(angelicRay);
                            if (holySwordCount >= 24) {
                                addSkillEvent(angelicOfJudgement);
                                holySwordCount -= 24;
                            }
                        }
                    addSkillEvent(divinePunishment);
                }
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(divinePunishment2)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 70000))
            ) {
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 30000))
            ) {
                if (
                        dealCycleOrder == 1
                                || dealCycleOrder == 3
                ) {
                    isNuke = true;
                }
                addSkillEvent(soulContract);
                while (!cooldownCheck(divinePunishment2)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
                isNuke = false;
            } else if (
                    cooldownCheck(peacemaker)
                            && getStart().before(new Timestamp(holyBlood.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(peacemaker);
            } else {
                addSkillEvent(angelicRay);
                if (holySwordCount >= 24) {
                    addSkillEvent(angelicOfJudgement);
                    holySwordCount -= 24;
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void setDuoDealCycle3() {
        int dealCycleOrder = 1;

        // 인피니티 달구기
        getStart().setTime(-75000);
        infinity.setActivateTime(new Timestamp(-80000));
        addSkillEvent(infinity);
        getStart().setTime(0);

        mapleWorldGoddessBlessing.setCooldown(120.0);

        divinePunishment2.setRelatedSkill(new DivinePunishment2());
        divinePunishment2.setCooldown(22.0);

        divinePunishment3.setRelatedSkill(new DivinePunishment3());
        divinePunishment3.setCooldown(33.0);

        addSkillEvent(bahamutSummon);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(infinity)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
            ) {
                infinityEndTime = new Timestamp(getStart().getTime() + 121360);
                addSkillEvent(infinity);
            }
            if (
                    cooldownCheck(unstableMemorize)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
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
            if (cooldownCheck(fountainForAngel)) {
                addSkillEvent(fountainForAngel);
            }
            if (cooldownCheck(angelicTouch)) {
                addSkillEvent(angelicTouch);
            }
            if (
                    cooldownCheck(angelOfLibra)
                    && getStart().after(getNukeTimeList().get(dealCycleOrder - 1))
            ) {
                if (
                        dealCycleOrder == 1
                                || dealCycleOrder == 3
                ) {
                    isNuke = true;
                }
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(pray);
                addSkillEvent(angelOfLibra);
                addSkillEvent(soulContract);
                addSkillEvent(holyBlood);
                while (!cooldownCheck(peacemaker)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                }
                addSkillEvent(peacemaker);
                addSkillEvent(heavensDoor);
                if (cooldownCheck(holyAdvent)) {
                    addSkillEvent(angelicRay);
                    if (holySwordCount >= 24) {
                        addSkillEvent(angelicOfJudgement);
                        holySwordCount -= 24;
                    }
                    addSkillEvent(holyAdvent);
                    addSkillEvent(divinePunishment);
                } else {
                    addSkillEvent(divinePunishment);
                }
                dealCycleOrder ++;
                isNuke = false;
            } else if (
                    cooldownCheck(divinePunishment2)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 70000))
            ) {
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(soulContract);
                applyCooldown(divinePunishment);
                addSkillEvent(divinePunishment2);
            } else if (
                    cooldownCheck(peacemaker)
                            && getStart().before(new Timestamp(holyBlood.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(peacemaker);
            } else {
                addSkillEvent(angelicRay);
                if (holySwordCount >= 24) {
                    addSkillEvent(angelicOfJudgement);
                    holySwordCount -= 24;
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    skill instanceof HolyAdvent1
                    || skill instanceof HolyAdvent2
            ) {
                Timestamp t = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (cooldownCheck(triumphFeather)) {
                    addSkillEvent(triumphFeather);
                }
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                getStart().setTime(t.getTime());
            }
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }

    public Long calcTotalDamage(List<Timestamp> eventTimeList) {
        Long totalDamage = 0L;
        Timestamp start = null;
        Timestamp end = null;
        List<SkillEvent> overlappingSkillEvents;
        BuffSkill buffSkill;
        for (int i = 0; i < eventTimeList.size() -1; i++) {
            List<SkillEvent> useAttackSkillList = new ArrayList<>();
            buffSkill = new BuffSkill();
            start = eventTimeList.get(i);
            end = eventTimeList.get(i + 1);
            overlappingSkillEvents = getOverlappingSkillEvents(start, end);
            List<SkillEvent> useBuffSkillList = new ArrayList<>();
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                StackTraceElement[] stackTraceElement = new Throwable().getStackTrace();
                if (
                        stackTraceElement[1].getMethodName().equals("calcOriginXRestraintDeal")
                                && (
                                skillEvent.getSkill() instanceof CrestOfTheSolarDot
                                        || skillEvent.getSkill() instanceof SpiderInMirrorDot
                        )
                ) {
                    continue;
                }
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            for (SkillEvent skillEvent : useBuffSkillList) {
                for (BuffSkill bs : buffSkillList) {
                    if (
                            bs.getClass().getName().equals(skillEvent.getSkill().getClass().getName())
                                    && start.equals(skillEvent.getStart())
                    ) {
                        bs.setUseCount(bs.getUseCount() + 1);
                        bs.getStartTimeList().add(skillEvent.getStart());
                        bs.getEndTimeList().add(skillEvent.getEnd());
                    }
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
            boolean isLibra = false;
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof AngelOfLibra2) {
                    isLibra = true;
                    break;
                }
            }
            if (isLibra) {
                for (int j = 0; j < useAttackSkillList.size(); j++) {
                    if (useAttackSkillList.get(j).getSkill() instanceof BahamutSummon) {
                        useAttackSkillList.remove(j);
                        j--;
                    }
                }
            }
            for (int j = 0; j < useAttackSkillList.size(); j++) {
                if (useAttackSkillList.get(j).getSkill() instanceof AngelOfLibraRevenge2) {
                    angelOfLibraRevengeAttack = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof AngelOfLibraCharity) {
                    isAngelOfLibraCharity = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof Pray2) {
                    isPray = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : useBuffSkillList) {
                buffSkill.addBuffAttMagic(((BuffSkill) skillEvent.getSkill()).getBuffAttMagic());
                buffSkill.addBuffAttMagicPer(((BuffSkill) skillEvent.getSkill()).getBuffAttMagicPer());
                buffSkill.addBuffAllStatP(((BuffSkill) skillEvent.getSkill()).getBuffAllStatP());
                buffSkill.addBuffCriticalDamage(((BuffSkill) skillEvent.getSkill()).getBuffCriticalDamage());
                buffSkill.addBuffCriticalP(((BuffSkill) skillEvent.getSkill()).getBuffCriticalP());
                buffSkill.addBuffDamage(((BuffSkill) skillEvent.getSkill()).getBuffDamage());
                buffSkill.addBuffFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffFinalDamage());
                buffSkill.addBuffIgnoreDefense(((BuffSkill) skillEvent.getSkill()).getBuffIgnoreDefense());
                buffSkill.addBuffMainStat(((BuffSkill) skillEvent.getSkill()).getBuffMainStat());
                buffSkill.addBuffMainStatP(((BuffSkill) skillEvent.getSkill()).getBuffMainStatP());
                buffSkill.addBuffOtherStat1(((BuffSkill) skillEvent.getSkill()).getBuffOtherStat1());
                buffSkill.addBuffOtherStat2(((BuffSkill) skillEvent.getSkill()).getBuffOtherStat2());
                buffSkill.addBuffProperty(((BuffSkill) skillEvent.getSkill()).getBuffProperty());
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            int tmp = 0;
            double perDamage = 0;
            for (int j = 0; j < useAttackSkillList.size(); j++) {
                if (((AttackSkill) useAttackSkillList.get(j).getSkill()).getDamage() * ((AttackSkill) useAttackSkillList.get(j).getSkill()).getAttackCount() > perDamage) {
                    tmp = j;
                    perDamage = ((AttackSkill) useAttackSkillList.get(j).getSkill()).getDamage() * ((AttackSkill) useAttackSkillList.get(j).getSkill()).getAttackCount();
                }
            }
            for (int j = 0; j < useAttackSkillList.size(); j++) {
                Double tmpFinalDamage = buffSkill.getBuffFinalDamage().doubleValue();
                if (
                        j == tmp
                        && !(useAttackSkillList.get(j).getSkill() instanceof BahamutSummon)
                        && !(useAttackSkillList.get(j).getSkill() instanceof AngelOfLibraRevenge2)
                ) {
                    if (angelOfLibraRevengeAttack) {
                        buffSkill.addBuffFinalDamage(1.1);
                        angelOfLibraRevengeAttack = false;
                    } /*else if (bahamutAttack) {
                        buffSkill.addBuffFinalDamage(1.25);
                        bahamutAttack = false;
                    }*/
                }
                totalDamage += getAttackDamage(useAttackSkillList.get(j), buffSkill, start, end);
                buffSkill.setBuffFinalDamage(tmpFinalDamage.doubleValue());
            }
            isAngelOfLibraCharity = false;
            isPray = false;
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        Long mainStat;
        if (isAngelOfLibraCharity) {
            mainStat = this.getJob().getFinalMainStat() + buffSkill.getBuffMainStat();
            AngelOfLibraCharity angelOfLibraCharity = new AngelOfLibraCharity(mainStat);
            buffSkill.addBuffDamage(angelOfLibraCharity.getBuffDamage());
        }
        if (isPray) {
            this.getJob().addMainStat(buffSkill.getBuffMainStat());
            Pray2 pray = new Pray2(this.getJob().getFinalMainStat());
            buffSkill.addBuffFinalDamage(pray.getBuffFinalDamage());
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
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
                            * (1 - 0.5 * (1 - (this.getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
                            * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - this.getJob().getIgnoreDefense()) * (1 - this.getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                    );
                }
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
        if (isAngelOfLibraCharity) {
            mainStat = this.getJob().getFinalMainStat() + buffSkill.getBuffMainStat();
            AngelOfLibraCharity angelOfLibraCharity = new AngelOfLibraCharity(mainStat);
            buffSkill.addBuffDamage(-angelOfLibraCharity.getBuffDamage());
        }
        if (isPray) {
            Pray pray = new Pray(this.getJob().getFinalMainStat());
            this.getJob().addMainStat(-buffSkill.getBuffMainStat());
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / pray.getBuffFinalDamage());
        }
        return attackDamage;
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
            if (skill instanceof AngelOfLibra2) {
                AngelOfLibraCharity angelOfLibraCharity = new AngelOfLibraCharity(0L);
                for (long i = getStart().getTime(); i < getStart().getTime() + 32000; i += angelOfLibraCharity.getCooldown() * 1000) {
                    getSkillEventList().add(new SkillEvent(angelOfLibraCharity, new Timestamp(i), new Timestamp(i + 7000)));
                    getEventTimeList().add(new Timestamp(i));
                }
            }
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime.setTime(getStart().getTime() + 8000);
            }
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
                    && getStart().after(new Timestamp(200 * 1000))
            ) {
                originXRestraintRingStartTime = new Timestamp(getStart().getTime());
                originXRestraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                if (skill instanceof Infinity) {
                    infinityEndTime = new Timestamp(getStart().getTime() + 123000);
                    infinityBurningTime = new Timestamp(getStart().getTime() + 75000);
                    for (long i = 0; i < 75000; i += 5000) {
                        getSkillEventList().add(new SkillEvent(new Infinity(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 5000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 5000));
                    }
                    getSkillEventList().add(new SkillEvent(new Infinity(75000L), new Timestamp(getStart().getTime() + 75000), new Timestamp(getStart().getTime() + 123000)));
                    endTime = new Timestamp(getStart().getTime() + 123000);
                } else {
                    endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                    if (skill.isApplyServerLag()) {
                        endTime = new Timestamp(endTime.getTime() + 3000);
                    }
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            } else {
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
                            skill instanceof AngelicRay
                            || skill instanceof AngelicTouch
                            || skill instanceof CrestOfTheSolar
                            || skill instanceof HeavensDoor
                            || skill instanceof Peacemaker
                            || skill instanceof SpiderInMirror
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    cooldownCheck(triumphFeather)
                    && !(skill instanceof TriumphFeather)
            ) {
                addSkillEvent(triumphFeather);
            }
            if (skill instanceof AngelicRay) {
                holySwordCount += 2;
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
                this.getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof AngelOfLibraRevenge2) {
                        i = 0;
                    }
                    if (
                            skill instanceof HolyAdventBalance
                            || skill instanceof HolyAdventCharity
                            || skill instanceof HolyAdventRevenge
                    ) {
                        i = 3660;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                skill instanceof DivinePunishment3
                                        || skill instanceof DivinePunishment
                                        || skill instanceof DivinePunishment2
                        ) {
                            Timestamp t = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            holySwordCount ++;
                            if (holySwordCount >= 24) {
                                addSkillEvent(angelicOfJudgement);
                                holySwordCount -= 24;
                            }
                            if (cooldownCheck(triumphFeather)) {
                                addSkillEvent(triumphFeather);
                            }
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
                            }
                            getStart().setTime(t.getTime());
                        }
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
            }
        }
        if (skill instanceof DivinePunishmentDelay) {
            if (skill.getRelatedSkill() instanceof DivinePunishment) {
                applyCooldown(divinePunishment);
                applyCooldown(divinePunishment2);
                applyCooldown(divinePunishment3);
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
