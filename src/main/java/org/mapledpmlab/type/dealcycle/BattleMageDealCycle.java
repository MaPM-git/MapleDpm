package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.battlemage.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.battlemage.DebuffAura;
import org.mapledpmlab.type.skill.buffskill.battlemage.MasterOfDeath;
import org.mapledpmlab.type.skill.buffskill.battlemage.UnionAura;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BattleMageDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AbyssalLightning());
            add(new BattleKingBar1());
            add(new BattleKingBar2());
            add(new BlackMagicAltar());
            add(new BlackMark());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CrimsonPactum1());
            add(new CrimsonPactum2());
            add(new DarkLightning());
            add(new Death());
            add(new DeathReinforce());
            add(new FinalAttackBattleMage());
            add(new FinishBlow());
            add(new GrimReaper());
            add(new GrimReaperMOD());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new NetherworldLightning());
            add(new ReaperScythe());
            add(new ResistanceLineInfantry());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new ResistanceLineInfantryDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            //add(new DebuffAura());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new MasterOfDeath());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UnionAura());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WillOfLiberty());
        }
    };

    BlackMark blackMark = new BlackMark();
    Death death = new Death();
    DeathReinforce deathReinforce = new DeathReinforce();
    NetherworldLightning netherworldLightning = new NetherworldLightning();

    private List<Timestamp> abyssalLightningStartTimeList = new ArrayList<>();
    private List<Timestamp> abyssalLightningEndTimeList = new ArrayList<>();

    Timestamp unionAuraEndTime = new Timestamp(-1);

    int attackCnt = 0;
    int reaperScytheCnt = 0;
    int soulCnt = 0;

    public BattleMageDealCycle(Job job) {
        super(job, new FinalAttackBattleMage());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AbyssalLightning abyssalLightning = new AbyssalLightning();
        BattleKingBar1 battleKingBar1 = new BattleKingBar1();
        BlackMagicAltar blackMagicAltar = new BlackMagicAltar();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrimsonPactum1 crimsonPactum1 = new CrimsonPactum1();
        DebuffAura debuffAura = new DebuffAura();
        FinishBlow finishBlow = new FinishBlow();
        GrimReaper grimReaper = new GrimReaper();
        GrimReaperMOD grimReaperMOD = new GrimReaperMOD();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MasterOfDeath masterOfDeath = new MasterOfDeath();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReaperScythe reaperScythe = new ReaperScythe();
        ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UnionAura unionAura = new UnionAura();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WillOfLiberty willOfLiberty = new WillOfLiberty();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(willOfLiberty);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(blackMagicAltar);
        dealCycle1.add(unionAura);
        dealCycle1.add(abyssalLightning);
        dealCycle1.add(masterOfDeath);
        dealCycle1.add(grimReaperMOD);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(crimsonPactum1);

        dealCycle2.add(willOfLiberty);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(blackMagicAltar);
        dealCycle2.add(unionAura);
        dealCycle2.add(abyssalLightning);
        dealCycle2.add(masterOfDeath);
        dealCycle2.add(grimReaperMOD);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);

        dealCycle3.add(blackMagicAltar);
        dealCycle3.add(unionAura);
        dealCycle3.add(grimReaper);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);

        addSkillEvent(resistanceLineInfantry);
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(mapleWorldGoddessBlessing.getEndTime())
                    && getStart().before(new Timestamp(90 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addSkillEvent(mapleWorldGoddessBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(blackMagicAltar)
                    && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(blackMagicAltar);
            } else if (
                    cooldownCheck(resistanceLineInfantry)
            ) {
                addSkillEvent(resistanceLineInfantry);
            } else if (
                    cooldownCheck(battleKingBar1)
            ) {
                addSkillEvent(battleKingBar1);
            } else {
                if (getStart().before(unionAuraEndTime)) {
                    addSkillEvent(reaperScythe);
                    reaperScytheCnt++;
                    if (reaperScytheCnt >= 3) {
                        soulCnt++;
                        reaperScytheCnt -= 3;
                    }
                } else {
                    addSkillEvent(finishBlow);
                }
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
            if (skill instanceof UnionAura) {
                unionAuraEndTime = new Timestamp(getStart().getTime() + 40000);
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
            if (skill instanceof AbyssalLightning) {
                this.abyssalLightningStartTimeList.add(new Timestamp(getStart().getTime()));
                this.abyssalLightningEndTimeList.add(new Timestamp(getStart().getTime() + 40000));
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
            attackCnt++;
            if (attackCnt > 12) {
                if (soulCnt >= 4) {
                    getSkillEventList().add(new SkillEvent(deathReinforce, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                    soulCnt -= 4;
                } else {
                    getSkillEventList().add(new SkillEvent(death, new Timestamp(getStart().getTime()), new Timestamp(getStart().getTime())));
                }
                attackCnt -= 12;
                getEventTimeList().add(new Timestamp(getStart().getTime()));
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
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= this.getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(this.getFinalAttack(), start, end), buffSkill, start, end);
                        totalDamage += getAttackDamage(new SkillEvent(this.blackMark, start, end), buffSkill, start, end);
                        for (int j = 0; j < this.abyssalLightningStartTimeList.size(); j++) {
                            if (
                                    start.after(this.abyssalLightningStartTimeList.get(j))
                                    && start.before(this.abyssalLightningEndTimeList.get(j))
                            ) {
                                getStart().setTime(start.getTime());
                                if (cooldownCheck(netherworldLightning)) {
                                    totalDamage += getAttackDamage(new SkillEvent(this.netherworldLightning, start, end), buffSkill, start, end);
                                    applyCooldown(netherworldLightning);
                                }
                            }
                        }
                    }
                }
                if (
                        start.equals(se.getStart())
                        && (
                                se.getSkill() instanceof FinishBlow
                                || se.getSkill() instanceof BattleKingBar1
                                || se.getSkill() instanceof BattleKingBar2
                                || se.getSkill() instanceof ReaperScythe
                                || se.getSkill() instanceof CrestOfTheSolar
                                || se.getSkill() instanceof CrimsonPactum1
                                || se.getSkill() instanceof CrimsonPactum2
                                || se.getSkill() instanceof SpiderInMirror
                        )
                ) {
                    totalDamage += getAttackDamage(new SkillEvent(this.blackMark, start, end), buffSkill, start, end);
                    for (int j = 0; j < this.abyssalLightningStartTimeList.size(); j++) {
                        if (
                                start.after(this.abyssalLightningStartTimeList.get(j))
                                && start.before(this.abyssalLightningEndTimeList.get(j))
                        ) {
                            getStart().setTime(start.getTime());
                            if (cooldownCheck(netherworldLightning)) {
                                totalDamage += getAttackDamage(new SkillEvent(this.netherworldLightning, start, end), buffSkill, start, end);
                                applyCooldown(netherworldLightning);
                            }
                        }
                    }
                }
            }
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
        if (
                attackSkill instanceof AbyssalLightning
                || attackSkill instanceof BattleKingBar1
                || attackSkill instanceof BattleKingBar2
                || attackSkill instanceof BlackMagicAltar
                || attackSkill instanceof BlackMark
                || attackSkill instanceof CrimsonPactum1
                || attackSkill instanceof CrimsonPactum2
                || attackSkill instanceof DarkLightning
                || attackSkill instanceof Death
                || attackSkill instanceof DeathReinforce
                || attackSkill instanceof FinishBlow
                || attackSkill instanceof GrimReaper
                || attackSkill instanceof GrimReaperMOD
                || attackSkill instanceof NetherworldLightning
                || attackSkill instanceof ReaperScythe
                || attackSkill instanceof ResistanceLineInfantry
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
                }
                Long distance = end.getTime() - start.getTime();
                if (attackSkill.getMultiAttackInfo().size() == 0 && attackSkill.getInterval() == 0 && attackSkill.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / attackSkill.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        if (
                attackSkill instanceof AbyssalLightning
                        || attackSkill instanceof BattleKingBar1
                        || attackSkill instanceof BattleKingBar2
                        || attackSkill instanceof BlackMagicAltar
                        || attackSkill instanceof BlackMark
                        || attackSkill instanceof CrimsonPactum1
                        || attackSkill instanceof CrimsonPactum2
                        || attackSkill instanceof DarkLightning
                        || attackSkill instanceof Death
                        || attackSkill instanceof DeathReinforce
                        || attackSkill instanceof FinishBlow
                        || attackSkill instanceof GrimReaper
                        || attackSkill instanceof GrimReaperMOD
                        || attackSkill instanceof NetherworldLightning
                        || attackSkill instanceof ReaperScythe
                        || attackSkill instanceof ResistanceLineInfantry
        ) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.08);
        }
        return attackDamage;
    }
}
