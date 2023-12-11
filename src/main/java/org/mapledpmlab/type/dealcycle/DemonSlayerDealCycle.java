package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.hyper.HyperDemonSlayer;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.demonslayer.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.demonslayer.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DemonSlayerDealCycle extends DealCycle {
    /*
     */

    // 메용2, 6차, 리레, 스인미, 크오솔
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private List<Skill> dealCycle4 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new Cerburus());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DemonBane1());
            add(new DemonBane2());
            add(new DemonImpact());
            add(new DemonImpactChain());
            add(new DemonSlash1());
            add(new DemonSlash2());
            add(new DemonSlash3());
            add(new DemonSlash4());
            add(new DemonSlashReinforce1());
            add(new DemonSlashReinforce2());
            add(new DemonSlashReinforce3());
            add(new DemonSlashReinforce4());
            add(new Geryon());
            add(new Jormungand());
            add(new JormungandExtinction());
            add(new MastemaClaw());
            add(new MaxForce());
            add(new Metamorphosis());
            add(new Nemea());
            add(new NightmareFlame());
            add(new NightmareJudgement());
            add(new NightmareWave());
            add(new OtherWorldVoid());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new DemonBane1Delay());
            add(new DemonBane2Delay());
            add(new DemonBaneStartDelay());
            add(new JormungandDelay());
            add(new NightmareJudgementDelay());
            add(new NightmareWaveDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new CallMastema());
            add(new DemonAwakening());
            add(new DemonicFortitude());
            add(new InfinityForce());
            add(new NightmareTerritory());
            add(new Orthrus());
            add(new OtherWorldGoddessBlessing());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(707L));
        }
    };

    int demonForce = 150;
    Timestamp demonAwakeningEndTime = new Timestamp(-1);
    Timestamp infinityForceEndTime = new Timestamp(-1);
    Timestamp nightmareTerritoryEndTime = new Timestamp(-1);

    Cerburus cerburus = new Cerburus();
    NightmareFlame nightmareFlame = new NightmareFlame();

    public DemonSlayerDealCycle(Job job) {
        super();
        this.setFinalAttack(null);
        this.setJob(job);
        this.getJob().addTotal(this.getJob().getJobType());
        this.getJob().addObject(new HyperDemonSlayer(this.getJob().getLevel(), getJob().getCriticalP()));

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        CallMastema callMastema = new CallMastema();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DemonAwakening demonAwakening = new DemonAwakening();
        DemonBaneStartDelay demonBaneStartDelay = new DemonBaneStartDelay();
        DemonImpact demonImpact = new DemonImpact();
        DemonImpactChain demonImpactChain = new DemonImpactChain();
        DemonSlash1 demonSlash1 = new DemonSlash1();
        DemonSlashReinforce1 demonSlashReinforce1 = new DemonSlashReinforce1();
        DemonicFortitude demonicFortitude = new DemonicFortitude();
        InfinityForce infinityForce = new InfinityForce();
        Jormungand jormungand = new Jormungand();
        MaxForce maxForce = new MaxForce();
        Metamorphosis metamorphosis = new Metamorphosis();
        NightmareWave nightmareWave = new NightmareWave();
        NightmareJudgement nightmareJudgement = new NightmareJudgement();
        Orthrus orthrus = new Orthrus();
        OtherWorldGoddessBlessing otherWorldGoddessBlessing = new OtherWorldGoddessBlessing();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += metamorphosis.getInterval()) {
            getSkillEventList().add(new SkillEvent(metamorphosis, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += maxForce.getInterval()) {
            getSkillEventList().add(new SkillEvent(maxForce, new Timestamp(i), new Timestamp(i)));
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

        // 1-4-3-2-3-4
        // 메용2, 6차, 리레, 스인미, 크오솔
        dealCycle1.add(infinityForce);
        dealCycle1.add(demonicFortitude);
        dealCycle1.add(demonAwakening);
        dealCycle1.add(orthrus);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(callMastema);
        dealCycle1.add(otherWorldGoddessBlessing);
        dealCycle1.add(nightmareWave);
        dealCycle1.add(soulContract);
        dealCycle1.add(jormungand);
        dealCycle1.add(restraintRing);
        dealCycle1.add(demonSlashReinforce1);
        dealCycle1.add(demonSlashReinforce1);
        dealCycle1.add(demonSlashReinforce1);
        dealCycle1.add(demonBaneStartDelay);
        dealCycle1.add(demonSlashReinforce1);
        dealCycle1.add(nightmareJudgement);

        // 메용2, 6차, 웨폰퍼프
        dealCycle2.add(infinityForce);
        dealCycle2.add(demonicFortitude);
        dealCycle2.add(demonAwakening);
        dealCycle2.add(orthrus);
        dealCycle2.add(callMastema);
        dealCycle2.add(otherWorldGoddessBlessing);
        dealCycle2.add(nightmareWave);
        dealCycle2.add(soulContract);
        dealCycle2.add(jormungand);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(demonSlashReinforce1);
        dealCycle2.add(demonSlashReinforce1);
        dealCycle2.add(demonSlashReinforce1);
        dealCycle2.add(demonBaneStartDelay);
        dealCycle2.add(demonSlashReinforce1);
        dealCycle2.add(nightmareJudgement);

        // 메용2, 리레, 스인미, 코오솔
        dealCycle3.add(infinityForce);
        dealCycle3.add(demonicFortitude);
        dealCycle3.add(demonAwakening);
        dealCycle3.add(orthrus);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(callMastema);
        dealCycle3.add(otherWorldGoddessBlessing);
        dealCycle3.add(soulContract);
        dealCycle3.add(jormungand);
        dealCycle3.add(restraintRing);
        dealCycle3.add(demonSlashReinforce1);
        dealCycle3.add(demonSlashReinforce1);
        dealCycle3.add(demonSlashReinforce1);
        dealCycle3.add(demonBaneStartDelay);

        // 메용2, 웨폰퍼프
        dealCycle4.add(infinityForce);
        dealCycle4.add(demonicFortitude);
        dealCycle4.add(demonAwakening);
        dealCycle4.add(orthrus);
        dealCycle4.add(callMastema);
        dealCycle4.add(otherWorldGoddessBlessing);
        dealCycle4.add(soulContract);
        dealCycle4.add(jormungand);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(demonSlashReinforce1);
        dealCycle4.add(demonSlashReinforce1);
        dealCycle4.add(demonSlashReinforce1);
        dealCycle4.add(demonBaneStartDelay);

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 1
                    && demonForce >= 100
            ) {
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
                    && demonForce >= 100
            ) {
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 3 || dealCycleOrder == 5)
                    && demonForce >= 100
            ) {
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
                    && demonForce >= 100
            ) {
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(soulContract)
                    && (
                            (
                                    getStart().after(new Timestamp(30 * 1000))
                                    && getStart().before(new Timestamp(90 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(150 * 1000))
                                    && getStart().before(new Timestamp(210 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(270 * 1000))
                                    && getStart().before(new Timestamp(330 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(390 * 1000))
                                    && getStart().before(new Timestamp(450 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(510 * 1000))
                                    && getStart().before(new Timestamp(570 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(630 * 1000))
                                    && getStart().before(new Timestamp(690 * 1000))
                            )
                    )
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(9 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (getStart().before(demonAwakeningEndTime)) {
                addSkillEvent(demonSlashReinforce1);
            } else if (
                    cooldownCheck(demonImpactChain)
                    && demonForce >= 8
            ) {
                addSkillEvent(demonImpactChain);
            } else {
                addSkillEvent(demonSlash1);
            }
        }
        sortEventTimeList();
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;
        double gaugeTmp = 0;
        if (skill instanceof GaugeAttackSkill) {
            gaugeTmp = ((GaugeAttackSkill) skill).getGaugeCharge();
            if (gaugeTmp < 0) {
                if (getStart().before(infinityForceEndTime)) {
                } else {
                    demonForce += gaugeTmp;
                }
            } else {
                demonForce += gaugeTmp;
            }
        } else if (skill instanceof GaugeBuffSkill) {
            gaugeTmp = ((GaugeBuffSkill) skill).getGaugeCharge();
            if (gaugeTmp < 0) {
                if (getStart().before(infinityForceEndTime)) {
                } else {
                    demonForce += gaugeTmp;
                }
            } else {
                demonForce += gaugeTmp;
            }
        }
        if (demonForce > 150) {
            demonForce = 150;
        }
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
            if (skill instanceof DemonAwakening) {
                demonAwakeningEndTime = new Timestamp(getStart().getTime() + 65000);
            }
            if (skill instanceof InfinityForce) {
                infinityForceEndTime = new Timestamp(getStart().getTime() + 61250);
            }
            if (skill instanceof NightmareTerritory) {
                nightmareTerritoryEndTime = new Timestamp(getStart().getTime() + 20000);
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (((AttackSkill) skill).getInterval() != 0) {
                if (skill instanceof Jormungand) {
                    getSkillEventList().add(new SkillEvent(new JormungandExtinction(), new Timestamp(getStart().getTime() + 16000), new Timestamp(getStart().getTime() + 16000)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 16000));
                }
                if (
                        skill instanceof DemonBane1
                        || skill instanceof DemonBane2
                        || skill instanceof DemonImpact
                        || skill instanceof DemonImpactChain
                        || skill instanceof DemonSlashReinforce1
                        || skill instanceof DemonSlashReinforce2
                        || skill instanceof DemonSlashReinforce3
                        || skill instanceof DemonSlashReinforce4
                        || skill instanceof NightmareJudgement
                        || skill instanceof NightmareWave
                ) {
                    if (getStart().before(demonAwakeningEndTime)) {
                        addSkillEvent(cerburus);
                    }
                    if (getStart().before(nightmareTerritoryEndTime)) {
                        addSkillEvent(nightmareFlame);
                    }
                }
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
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 1) {
                    buffSkill.addBuffDamage(100L);      // 데스 커스 
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
