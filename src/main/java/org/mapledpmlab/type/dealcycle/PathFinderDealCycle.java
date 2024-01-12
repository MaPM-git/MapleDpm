package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.pathfinder.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.pathfinder.RelicEvolution;
import org.mapledpmlab.type.skill.buffskill.pathfinder.RelicLiberation;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PathFinderDealCycle extends DealCycle {
    /*
    메용2 - 에픽 - 이볼브 - 크리티컬 리인포스 - 엔버링크 - 시드링
    옵시디언 배리어 - 레이븐 템페스트 - 렐릭 언바운드 - 렐릭 에볼루션
    얼티밋 블래스트
    
    메용2 - 에픽 - 이볼브 - 크리티컬 리인포스 - 포세이큰 렐릭
    엔버링크 - 시드링 - 옵시디언 배리어 - 레이븐 템페스트 - 렐릭 언바운드
    렐릭 에볼루션 - 얼티밋 블래스트
     */

    // 메용2, 6차, 리레, 스인미, 크오솔
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private List<Skill> dealCycle4 = new ArrayList<>();

    // 웨폰퍼프
    private List<Skill> dealCycle5 = new ArrayList<>();

    private boolean isCriticalReinforce = false;
    private boolean isRelicEvolution = false;
    private boolean isRelicLiberation = false;
    private Long relicGauge = 0L;
    private AdditionalBlastFirst additionalBlastFirst = new AdditionalBlastFirst();
    private AdditionalDischarge additionalDischarge = new AdditionalDischarge();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdditionalBlastAfterSecond());
            add(new AdditionalBlastFirst());
            add(new AdditionalBlastREAfterSecond());
            add(new AdditionalBlastREFirst());
            add(new AdditionalDischarge());
            add(new AdditionalDischargeRE());
            add(new AncientWrath());
            add(new CardinalBlast());
            add(new CardinalDischarge());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CurseArrow());
            add(new EdgeOfResonance());
            add(new Evolve());
            add(new ForsakenRelicExplosion());
            add(new ForsakenRelicMagicArrow());
            add(new ForsakenRelicWave());
            add(new GuidedArrow());
            add(new ObsidianBarrier());
            add(new Raven());
            add(new RavenTempest());
            add(new RelicUnbound());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new UltimateBlast());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new ForsakenRelicExplosionDelay());
            add(new ForsakenRelicWaveDelay());
            add(new ObsidianBarrierDelay());
            add(new RavenDelay());
            add(new RavenTempestDelay());
            add(new RelicUnboundDelay());
            add(new UltimateBlastDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new CriticalReinforce(0.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(275L));
            add(new PriorPreparation());
            add(new RelicEvolution());
            add(new RelicLiberation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(318L));
        }
    };

    public PathFinderDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AncientWrath ancientWrath = new AncientWrath();
        CardinalBlast cardinalBlast = new CardinalBlast();
        CardinalDischarge cardinalDischarge = new CardinalDischarge();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
        CurseArrow curseArrow = new CurseArrow();
        EdgeOfResonance edgeOfResonance = new EdgeOfResonance();
        EpicAdventure epicAdventure = new EpicAdventure();
        Evolve evolve = new Evolve();
        GuidedArrow guidedArrow = new GuidedArrow();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        ObsidianBarrier obsidianBarrier = new ObsidianBarrier();
        PriorPreparation priorPreparation = new PriorPreparation();
        Raven raven = new Raven();
        RavenTempest ravenTempest = new RavenTempest();
        RelicEvolution relicEvolution = new RelicEvolution();
        RelicLiberation relicLiberation = new RelicLiberation();
        RelicUnbound relicUnbound = new RelicUnbound();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UltimateBlast ultimateBlast = new UltimateBlast();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 프리져
        for (int i = 0; i < 720 * 1000; i += raven.getInterval()) {
            getSkillEventList().add(new SkillEvent(raven, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 저주 화살
        for (int i = 10260; i < 720 * 1000; i += 20000) {
            for (int j = i; j < i + curseArrow.getInterval() * curseArrow.getLimitAttackCount(); j += curseArrow.getInterval()) {
                getSkillEventList().add(new SkillEvent(curseArrow, new Timestamp(j), new Timestamp(j)));
                getEventTimeList().add(new Timestamp(j));
            }
        }

        ringSwitching.setCooldown(120.0);

        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(evolve);
        dealCycle1.add(criticalReinforce);
        dealCycle1.add(relicLiberation);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(obsidianBarrier);
        dealCycle1.add(ravenTempest);
        dealCycle1.add(relicUnbound);
        dealCycle1.add(relicEvolution);
        dealCycle1.add(ultimateBlast);

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(evolve);
        dealCycle2.add(criticalReinforce);
        dealCycle2.add(relicLiberation);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(obsidianBarrier);
        dealCycle2.add(ravenTempest);
        dealCycle2.add(relicUnbound);
        dealCycle2.add(relicEvolution);
        dealCycle2.add(ultimateBlast);

        dealCycle3.add(epicAdventure);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(evolve);
        dealCycle3.add(criticalReinforce);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);
        dealCycle3.add(obsidianBarrier);
        dealCycle3.add(ravenTempest);
        dealCycle3.add(relicUnbound);
        dealCycle3.add(relicEvolution);
        dealCycle3.add(ultimateBlast);

        dealCycle4.add(epicAdventure);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(evolve);
        dealCycle4.add(criticalReinforce);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(obsidianBarrier);
        dealCycle4.add(ravenTempest);
        dealCycle4.add(relicUnbound);
        dealCycle4.add(relicEvolution);
        dealCycle4.add(ultimateBlast);

        dealCycle5.add(epicAdventure);
        dealCycle5.add(evolve);
        dealCycle5.add(criticalReinforce);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);
        dealCycle5.add(obsidianBarrier);
        dealCycle5.add(ravenTempest);
        dealCycle5.add(relicUnbound);
        dealCycle5.add(relicEvolution);
        dealCycle5.add(ultimateBlast);

        int i = 0;
        Timestamp relicLiberationEndTime = new Timestamp(-1);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle1);
                relicLiberationEndTime = new Timestamp(getStart().getTime() - 9960 + relicLiberation.getDuration() * 1000);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
                relicLiberationEndTime = new Timestamp(getStart().getTime() - 9960 + relicLiberation.getDuration() * 1000);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(6 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(dealCycle4)
                    && i > 140
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle4);
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle5);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(9 * 60 * 1000)))
            {
                addSkillEvent(ringSwitching);
            } else if (
                    getStart().before(relicLiberationEndTime)
                    && cooldownCheck(ancientWrath)
            ) {
                addSkillEvent(ancientWrath);
            } else if (
                    cooldownCheck(soulContract)
                    && !cooldownCheck(evolve)
            ) {
                addSkillEvent(soulContract);
            } else if (cooldownCheck(edgeOfResonance)) {
                addSkillEvent(edgeOfResonance);
            } else {
                Long ran = 0L;
                addSkillEvent(cardinalBlast);
                ran = (long) (Math.random() * 99 + 1);
                if (ran <= additionalDischarge.getProp()) {
                    addSkillEvent(additionalDischarge);
                }
                addSkillEvent(cardinalDischarge);
                if (ran <= additionalBlastFirst.getProp()) {
                    addSkillEvent(additionalBlastFirst);
                }
                edgeOfResonance.setActivateTime(new Timestamp(edgeOfResonance.getActivateTime().getTime() - 2000));
                ancientWrath.setActivateTime(new Timestamp(ancientWrath.getActivateTime().getTime() - 2000));
            }
            i++;
        }
        sortEventTimeList();
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
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isEvolve = false;
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof EvolveBuff) {
                    isEvolve = true;
                    break;
                }
            }
            if (isEvolve) {
                for (int j = 0; j < useAttackSkillList.size(); j++) {
                    if (useAttackSkillList.get(j).getSkill() instanceof Raven) {
                        useAttackSkillList.remove(j);
                    }
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof CriticalReinforce) {
                    isCriticalReinforce = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof RelicEvolution) {
                    isRelicEvolution = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof RelicLiberation) {
                    isRelicLiberation = true;
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
                buffSkill.addBuffPlusFinalDamage(((BuffSkill) skillEvent.getSkill()).getBuffPlusFinalDamage());
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            for (SkillEvent se : useAttackSkillList) {
                if (isRelicEvolution) {
                    if (se.getSkill() instanceof AdditionalBlastAfterSecond) {
                        se.setSkill(new AdditionalBlastREAfterSecond());
                    } else if (se.getSkill() instanceof AdditionalBlastFirst) {
                        se.setSkill(new AdditionalBlastREFirst());
                    } else if (se.getSkill() instanceof AdditionalDischarge) {
                        se.setSkill(new AdditionalDischargeRE());
                    }
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (isRelicLiberation) {
                    if (se.getSkill() instanceof CardinalForce) {
                        totalDamage += getAttackDamage(new SkillEvent(new ForsakenRelicMagicArrow(), start, end), buffSkill, start, end);
                    }
                }
                Long ran = 0L;
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            isCriticalReinforce = false;
            isRelicLiberation = false;
            isRelicEvolution = false;
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
        if (isCriticalReinforce) {
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP() + ((AttackSkill) skillEvent.getSkill()).getCriticalP());
            buffSkill.addBuffCriticalDamage(criticalReinforce.getBuffCriticalDamage());
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                        + this.getJob().getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
                        * (Math.floor((this.getJob().getAtt() + buffSkill.getBuffAttMagic())
                        * (1 + (this.getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
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
}
