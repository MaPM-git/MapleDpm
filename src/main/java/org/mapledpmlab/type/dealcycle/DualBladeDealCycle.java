package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.dualblade.*;
import org.mapledpmlab.type.skill.attackskill.shadower.*;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.dualblade.FinalCutBuff;
import org.mapledpmlab.type.skill.buffskill.dualblade.FlashbangBuff;
import org.mapledpmlab.type.skill.buffskill.shadower.SmokeBomb;

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
            add(new BladeStormContinuity());
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

    public DualBladeDealCycle(Job job) {
        super(job, new HiddenBlade());

        this.setAttackSkillList(attackSkillList);

        Long q = 0L;

        Asura asura = new Asura();
        BladeStormFirst bladeStormFirst = new BladeStormFirst();
        BladeTornado bladeTornado = new BladeTornado();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        EpicAdventure epicAdventure = new EpicAdventure();
        FatalVenom fatalVenom = new FatalVenom();
        FinalCutBuff finalCutBuff = new FinalCutBuff();
        FlashbangBuff flashbangBuff = new FlashbangBuff();
        HauntedEdge hauntedEdge = new HauntedEdge();
        KarmaBlade1 karmaBlade1 = new KarmaBlade1();
        KarmaBladeFinish karmaBladeFinish = new KarmaBladeFinish();
        KarmaFury karmaFury = new KarmaFury();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PhantomBlow phantomBlow = new PhantomBlow();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SuddenRaid suddenRaid = new SuddenRaid();
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

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(ultimateDarkSight);
        dealCycle1.add(readyToDie);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(karmaBlade1);
        dealCycle1.add(bladeTornado);
        dealCycle1.add(karmaFury);
        dealCycle1.add(phantomBlow);
        dealCycle1.add(hauntedEdge);
        dealCycle1.add(bladeStormFirst);
        dealCycle1.add(asura);
        dealCycle1.add(phantomBlow);
        dealCycle1.add(hauntedEdge);
        dealCycle1.add(karmaBladeFinish);

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(ultimateDarkSight);
        dealCycle2.add(readyToDie);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(bladeTornado);
        dealCycle2.add(karmaFury);
        dealCycle2.add(phantomBlow);
        dealCycle2.add(hauntedEdge);
        dealCycle2.add(bladeStormFirst);
        dealCycle2.add(asura);

        dealCycle3.add(readyToDie);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(bladeTornado);
        dealCycle3.add(karmaFury);
        dealCycle3.add(phantomBlow);
        dealCycle3.add(hauntedEdge);
        dealCycle3.add(bladeStormFirst);
        dealCycle3.add(asura);

        shortDealCycle.add(bladeTornado);
        shortDealCycle.add(karmaFury);

        while (getStart().before(getEnd())) {
            if (cooldownCheck(finalCutBuff)) {
                addSkillEvent(finalCutBuff);
            }
            if (cooldownCheck(flashbangBuff)) {
                addSkillEvent(flashbangBuff);
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
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(shortDealCycle)
                    && !cooldownCheck(readyToDie)
            ) {
                addDealCycle(shortDealCycle);
            } else if (
                    cooldownCheck(hauntedEdge)
                    && !cooldownCheck(readyToDie)
            ) {
                addSkillEvent(phantomBlow);
                addSkillEvent(hauntedEdge);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            } else {
                addSkillEvent(phantomBlow);
            }
        }
        sortEventTimeList();
    }
}
