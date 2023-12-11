package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
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

public class BishopDealCycle extends DealCycle {

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

        6차 극딜
        에픽-메용2-크오솔-스인미-프레이-리브라-엔버-시드링-홀블-피메-6차-헤도-디퍼

        극딜
        에픽-메용2-프레이-리브라-엔버-시드링-홀블-피메-헤도-디퍼

        준극딜
        메용2-엔버-시드링-피메-헤도-디퍼

        쿨마다 사용
        페더, 파포엔, 엔젤릭터치, 피메, 바하뮤트

        상시유지
        파포엔, 엔젤릭터치, 페더
     */

    private List<Skill> dealCycle1 = new ArrayList<>();

    private List<Skill> dealCycle2 = new ArrayList<>();

    private List<Skill> dealCycle3 = new ArrayList<>();

    private boolean isPray = false;

    private boolean isAngelOfLibraCharity = false;

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AngelicOfJudgement());
            add(new AngelicRay());
            add(new AngelicTouch());
            add(new AngelOfLibraRevenge());
            add(new BahamutSummon());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DivinePunishment());
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new DivinePunishmentDelay());
            add(new FountainForAngelDelay());
            add(new HolyAdventDelay());
            add(new PeacemakerDelay());
            add(new TriumphFeatherDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AngelOfLibra());
            add(new AngelOfLibraCharity(0L));
            add(new AngelOfLibraRevengeBuff());
            add(new Bahamut());
            add(new BahamutBuff());
            add(new EpicAdventure());
            add(new HolyAdventBuff());
            add(new HolyBlood());
            add(new Infinity(0L));
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PeacemakerBuff());
            add(new Pray(0L));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UnstableMemorize());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    public BishopDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AngelicOfJudgement angelicOfJudgement = new AngelicOfJudgement();
        AngelOfLibra angelOfLibra = new AngelOfLibra();
        AngelicRay angelicRay = new AngelicRay();
        AngelicTouch angelicTouch = new AngelicTouch();
        BahamutSummon bahamutSummon = new BahamutSummon();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DivinePunishment divinePunishment = new DivinePunishment();
        FountainForAngel fountainForAngel = new FountainForAngel();
        FountainForAngelDelay fountainForAngelDelay = new FountainForAngelDelay();
        EpicAdventure epicAdventure = new EpicAdventure();
        HeavensDoor heavensDoor = new HeavensDoor();
        HolyAdvent1 holyAdvent1 = new HolyAdvent1();
        HolyBlood holyBlood = new HolyBlood();
        Infinity infinity = new Infinity(0L);
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        Peacemaker peacemaker = new Peacemaker();
        Pray pray = new Pray(0L);
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        TriumphFeather triumphFeather = new TriumphFeather();
        TriumphFeatherDelay triumphFeatherDelay = new TriumphFeatherDelay();
        UnstableMemorize unstableMemorize = new UnstableMemorize();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        // 파운틴 포 엔젤
        for (int i = 0; i < 720 * 1000; i += fountainForAngel.getInterval()) {
            getSkillEventList().add(new SkillEvent(fountainForAngel, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 트라이엄프 페더
        for (int i = 0; i < 720 * 1000; i += triumphFeather.getInterval()) {
            getSkillEventList().add(new SkillEvent(triumphFeather, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 바하뮤트
        for (int i = 0; i < 720 * 1000; i += bahamutSummon.getInterval()) {
            getSkillEventList().add(new SkillEvent(bahamutSummon, new Timestamp(i), new Timestamp(i)));
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

        ringSwitching.setCooldown(100.0);

        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(pray);
        dealCycle1.add(angelOfLibra);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(holyBlood);
        dealCycle1.add(peacemaker);
        dealCycle1.add(holyAdvent1);
        dealCycle1.add(heavensDoor);
        dealCycle1.add(divinePunishment);

        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(pray);
        dealCycle2.add(angelOfLibra);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(holyBlood);
        dealCycle2.add(peacemaker);
        dealCycle2.add(heavensDoor);
        dealCycle2.add(divinePunishment);

        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(peacemaker);
        dealCycle3.add(heavensDoor);
        dealCycle3.add(divinePunishment);

        Timestamp infinityEndTime = new Timestamp(61360);
        Long holySwordCount = 0L;   // 성검 개수

        while (getStart().before(getEnd())) {
            if (holySwordCount == 12) {
                addSkillEvent(angelicOfJudgement);
                holySwordCount = 0L;
            }
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
            if (cooldownCheck(triumphFeatherDelay)) {
                addSkillEvent(triumphFeatherDelay);
            }
            if (cooldownCheck(fountainForAngelDelay)) {
                addSkillEvent(fountainForAngelDelay);
            }
            if (cooldownCheck(angelicTouch)) {
                addSkillEvent(angelicTouch);
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
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(70 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (cooldownCheck(peacemaker)) {
                addSkillEvent(peacemaker);
            } else {
                addSkillEvent(angelicRay);
                holySwordCount += 1;
            }
        }

        sortEventTimeList();
    }

    public void addDealCycle(List<Skill> skillList) {
        for (Skill s : skillList) {
            if (s instanceof AngelOfLibra) {
                AngelOfLibraCharity angelOfLibraCharity = new AngelOfLibraCharity(0L);
                for (long i = getStart().getTime(); i < 40000; i += angelOfLibraCharity.getCooldown() * 1000) {
                    getSkillEventList().add(new SkillEvent(angelOfLibraCharity, new Timestamp(i), new Timestamp(i)));
                    getEventTimeList().add(new Timestamp(i));
                }
            }
            this.addSkillEvent(s);
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
            overlappingSkillEvents = deduplication(overlappingSkillEvents, SkillEvent::getSkill);
            boolean isLibra = false;
            for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof AngelOfLibra) {
                    isLibra = true;
                    break;
                }
            }
            if (isLibra) {
                for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                    if (overlappingSkillEvents.get(j).getSkill() instanceof BahamutSummon) {
                        overlappingSkillEvents.get(j).setSkill(new AngelOfLibraRevenge());
                    }
                }
            }
            for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof AngelOfLibraCharity) {
                    isAngelOfLibraCharity = true;
                    break;
                }
            }
            for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof Pray) {
                    isPray = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BuffSkill) {
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
                    buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
                    buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
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
            mainStat = this.getJob().getFinalMainStat() + buffSkill.getBuffMainStat();
            Pray pray = new Pray(mainStat);
            buffSkill.addBuffFinalDamage(pray.getBuffFinalDamage());
        }
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
