package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.dualblade.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.dualblade.FinalCutBuff;
import org.mapledpmlab.type.skill.buffskill.dualblade.FlashbangBuff;
import org.mapledpmlab.type.skill.buffskill.dualblade.KarmaBladeBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DualBladeDealCycle extends DealCycle {

    /*
     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 6차X,
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜, 웨폰퍼프
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 블토카퓨
    private List<Skill> shortDealCycle = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new Asura());
            add(new BladeStormKeydown());
            add(new BladeStormFirst());
            add(new BladeTornado());
            add(new BladeTornadoTyphoon());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new FatalVenom());
            add(new FinalCut());
            add(new Flashbang());
            add(new HauntedEdge());
            add(new HiddenBlade());
            add(new KarmaBlade1());
            add(new KarmaBlade2());
            add(new KarmaBlade3());
            add(new KarmaBladeFinish());
            add(new KarmaFury());
            add(new PhantomBlow());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new AsuraAfterDelay());
            add(new AsuraBeforeDelay());
            add(new BladeStormAfterDelay());
            add(new BladeStormBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new DarkSight());
            add(new EpicAdventure());
            add(new FinalCutBuff());
            add(new FlashbangBuff());
            add(new KarmaBladeBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UltimateDarkSight());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    HauntedEdge hauntedEdge = new HauntedEdge();
    KarmaBlade3 karmaBlade3 = new KarmaBlade3();
    KarmaBladeFinish karmaBladeFinish = new KarmaBladeFinish();

    List<Timestamp> karmaBladeStartTimeList = new ArrayList<>();
    List<Timestamp> karmaBladeEndTimeList = new ArrayList<>();

    int karmaBladeCnt= 0;

    public DualBladeDealCycle(Job job) {
        super(job, new HiddenBlade());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AsuraBeforeDelay asura = new AsuraBeforeDelay();
        BladeStormFirst bladeStormFirst = new BladeStormFirst();
        BladeTornado bladeTornado = new BladeTornado();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        EpicAdventure epicAdventure = new EpicAdventure();
        FatalVenom fatalVenom = new FatalVenom();
        FinalCutBuff finalCutBuff = new FinalCutBuff();
        FlashbangBuff flashbangBuff = new FlashbangBuff();
        KarmaBlade1 karmaBlade1 = new KarmaBlade1();
        KarmaFury karmaFury = new KarmaFury();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PhantomBlow phantomBlow = new PhantomBlow();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UltimateDarkSight ultimateDarkSight = new UltimateDarkSight();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 페이탈 베놈
        for (int i = 0; i < 720 * 1000; i += fatalVenom.getInterval()) {
            getSkillEventList().add(new SkillEvent(fatalVenom, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ultimateDarkSight.setBuffFinalDamage(1.34);

        ringSwitching.setCooldown(100.0);

        dealCycle1.add(finalCutBuff);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(ultimateDarkSight);
        dealCycle1.add(readyToDie);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(bladeTornado);
        dealCycle1.add(karmaFury);
        dealCycle1.add(phantomBlow);
        dealCycle1.add(karmaBlade1);
        dealCycle1.add(bladeStormFirst);
        dealCycle1.add(bladeTornado);
        dealCycle1.add(karmaFury);
        dealCycle1.add(phantomBlow);
        dealCycle1.add(asura);

        dealCycle2.add(finalCutBuff);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(ultimateDarkSight);
        dealCycle2.add(readyToDie);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(bladeTornado);
        dealCycle2.add(karmaFury);
        dealCycle2.add(phantomBlow);
        dealCycle2.add(bladeStormFirst);
        dealCycle2.add(asura);
        dealCycle2.add(bladeTornado);
        dealCycle2.add(karmaFury);
        dealCycle2.add(phantomBlow);

        dealCycle3.add(finalCutBuff);
        dealCycle3.add(readyToDie);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(bladeTornado);
        dealCycle3.add(karmaFury);
        dealCycle3.add(phantomBlow);
        dealCycle3.add(bladeStormFirst);
        dealCycle3.add(asura);
        dealCycle3.add(bladeTornado);
        dealCycle3.add(karmaFury);
        dealCycle3.add(phantomBlow);

        shortDealCycle.add(bladeTornado);
        shortDealCycle.add(karmaFury);
        shortDealCycle.add(phantomBlow);

        while (getStart().before(getEnd())) {
            if (cooldownCheck(flashbangBuff)) {
                addSkillEvent(flashbangBuff);
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
                    && getStart().before(new Timestamp(hauntedEdge.getActivateTime().getTime() - 5000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().before(new Timestamp(hauntedEdge.getActivateTime().getTime() - 3000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(hauntedEdge.getActivateTime().getTime() - 3000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(shortDealCycle)
                    && !cooldownCheck(finalCutBuff)
                    && getStart().before(new Timestamp(hauntedEdge.getActivateTime().getTime() - 1500))
            ) {
                addDealCycle(shortDealCycle);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else {
                addSkillEvent(phantomBlow);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof KarmaBladeBuff) {
                karmaBladeStartTimeList.add(new Timestamp(getStart().getTime()));
                karmaBladeEndTimeList.add(new Timestamp(getStart().getTime() + 20000));
            }
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
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
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
                getSkillEventList().removeAll(remove);
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
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
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
        if (skill instanceof PhantomBlow && cooldownCheck(hauntedEdge)) {
            addSkillEvent(hauntedEdge);
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
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
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                for (int j = 0; j < karmaBladeStartTimeList.size(); j++) {
                    if (
                            start.after(karmaBladeStartTimeList.get(j))
                            && end.before(karmaBladeEndTimeList.get(j))
                            && karmaBladeCnt < 50
                    ) {
                        totalDamage += getAttackDamage(new SkillEvent(karmaBlade3, start, end), buffSkill, start, end);
                        karmaBladeCnt ++;
                    } else if (karmaBladeCnt == 50) {
                        for (int k = 0; k < 30; k++) {
                            totalDamage += getAttackDamage(new SkillEvent(karmaBladeFinish, start, end), buffSkill, start, end);
                        }
                        karmaBladeCnt = 0;
                        karmaBladeStartTimeList.remove(j);
                        karmaBladeEndTimeList.remove(j);
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
