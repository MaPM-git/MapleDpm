package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.battlemage.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.battlemage.MasterOfDeath;
import org.mapledpmlab.type.skill.buffskill.battlemage.UnionAura;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BattleMageContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new ResistanceLineInfantryDelay());
            add(new ResistanceLineInfantry());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ContinuousRing());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new MasterOfDeath());
            add(new SoulContract());
            add(new UnionAura());
            add(new WillOfLiberty());
        }
    };

    private final List<Timestamp> abyssalLightningStartTimeList = new ArrayList<>();
    private final List<Timestamp> abyssalLightningEndTimeList = new ArrayList<>();

    Timestamp abyssalLightningEndTime = new Timestamp(-1);
    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp masterOfDeathEndTime = new Timestamp(-1);
    Timestamp unionAuraEndTime = new Timestamp(-1);

    int attackCnt = 0;
    int reaperScytheCnt = 0;
    int soulCnt = 0;

    boolean isNuke = false;

    AbyssalLightning abyssalLightning = new AbyssalLightning();
    BattleKingBar1 battleKingBar1 = new BattleKingBar1();
    BlackMagicAltar blackMagicAltar = new BlackMagicAltar();
    BlackMark blackMark = new BlackMark();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CrimsonPactum1 crimsonPactum1 = new CrimsonPactum1();
    Death death = new Death();
    DeathReinforce deathReinforce = new DeathReinforce();
    FinishBlow finishBlow = new FinishBlow();
    GrimReaper grimReaper = new GrimReaper();
    GrimReaperMOD grimReaperMOD = new GrimReaperMOD();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MasterOfDeath masterOfDeath = new MasterOfDeath();
    NetherworldLightning netherworldLightning = new NetherworldLightning();
    ReaperScythe reaperScythe = new ReaperScythe();
    ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    UnionAura unionAura = new UnionAura();
    WillOfLiberty willOfLiberty = new WillOfLiberty();

    public BattleMageContinuousDealCycle(Job job) {
        super(job, new FinalAttackBattleMage());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        mapleWorldGoddessBlessing.setCooldown(120.0);

        resistanceLineInfantry.addFinalDamage(1.08);            // 오버로드 마나
    }

    @Override
    public void setSoloDealCycle() {
        addSkillEvent(resistanceLineInfantry);
        while (getStart().before(getEnd())) {
            if (cooldownCheck(resistanceLineInfantry)) {
                addSkillEvent(resistanceLineInfantry);
            }
            if (cooldownCheck(abyssalLightning)) {
                isNuke = true;
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(willOfLiberty);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(finishBlow);
                }
                addSkillEvent(blackMagicAltar);
                addSkillEvent(unionAura);
                addSkillEvent(abyssalLightning);
                addSkillEvent(masterOfDeath);
                addSkillEvent(grimReaperMOD);
                addSkillEvent(soulContract);
                if (cooldownCheck(crimsonPactum1)) {
                    addSkillEvent(crimsonPactum1);
                }
                isNuke = false;
            } else if (cooldownCheck(unionAura)) {
                addSkillEvent(blackMagicAltar);
                addSkillEvent(unionAura);
                addSkillEvent(grimReaper);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(blackMagicAltar)
                            && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(blackMagicAltar);
            } else if (cooldownCheck(battleKingBar1)) {
                addSkillEvent(battleKingBar1);
            } else {
                if (getStart().before(unionAuraEndTime)) {
                    addSkillEvent(reaperScythe);
                    reaperScytheCnt++;
                    if (reaperScytheCnt >= 3) {
                        soulCnt++;
                        reaperScytheCnt = 0;
                    }
                } else {
                    addSkillEvent(finishBlow);
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
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    (
                            skill instanceof CrimsonPactum1
                            || skill instanceof CrimsonPactum2
                            || skill instanceof BattleKingBar2
                    ) && sum <= 3840
            ) {
                Timestamp tmp = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                addSkillEvent(blackMark);
                if (
                        getStart().before(abyssalLightningEndTime)
                        && cooldownCheck(netherworldLightning)
                ) {
                    addSkillEvent(netherworldLightning);
                }
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= this.getFinalAttack().getProp()) {
                    addSkillEvent(this.getFinalAttack());
                    addSkillEvent(blackMark);
                    if (
                            getStart().before(abyssalLightningEndTime)
                            && cooldownCheck(netherworldLightning)
                    ) {
                        addSkillEvent(netherworldLightning);
                    }
                }
                getStart().setTime(tmp.getTime());
            }
            Timestamp tmp = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrimsonPactum1
                            || skill instanceof CrimsonPactum2
                            || skill instanceof BattleKingBar2
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            attackCnt++;
            if (
                    attackCnt >= 2
                    && cooldownCheck(death)
                    && !(skill instanceof Death)
                    && !(skill instanceof DeathReinforce)
                    && !(skill instanceof BlackMark)
                    && !(skill instanceof FinalAttackBattleMage)
            ) {
                if (
                        getStart().before(masterOfDeathEndTime)
                        && soulCnt >= 1
                ) {
                    addSkillEvent(deathReinforce);
                    death.setActivateTime(new Timestamp(deathReinforce.getActivateTime().getTime()));
                    soulCnt = 0;
                } else if (soulCnt >= 4) {
                    addSkillEvent(deathReinforce);
                    death.setActivateTime(new Timestamp(deathReinforce.getActivateTime().getTime()));
                    soulCnt = 0;
                } else {
                    addSkillEvent(death);
                    deathReinforce.setActivateTime(new Timestamp(death.getActivateTime().getTime()));
                    soulCnt ++;
                }
                attackCnt = 0;
                getEventTimeList().add(new Timestamp(getStart().getTime()));
            }
            getStart().setTime(tmp.getTime());
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof MasterOfDeath) {
                masterOfDeathEndTime = new Timestamp(getStart().getTime() + 33000);
            }
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (skill instanceof UnionAura) {
                unionAuraEndTime = new Timestamp(getStart().getTime() + 43000);
            }
            if (
                    skill instanceof SoulContract
                            && isNuke
                            && restraintRingStartTime == null
                            && restraintRingEndTime == null
                            && fortyEndTime == null
            ) {
                restraintRingStartTime = new Timestamp(getStart().getTime());
                restraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
                fortyEndTime = new Timestamp(getStart().getTime() + 40000);
            } else if (
                    skill instanceof SoulContract
                            && isNuke
                            && restraintRingStartTime != null
                            && restraintRingEndTime != null
                            && fortyEndTime != null
                            && originXRestraintRingStartTime == null
                            && originXRestraintRingEndTime == null
            ) {
                originXRestraintRingStartTime = new Timestamp(getStart().getTime());
                originXRestraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
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
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof BattleKingBar1
                            || skill instanceof DarkLightning
                            || skill instanceof FinishBlow
                            || skill instanceof ReaperScythe
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof DarkLightning
                    && getStart().before(abyssalLightningEndTime)
                    && cooldownCheck(netherworldLightning)
            ) {
                addSkillEvent(netherworldLightning);
            }
            if (
                    skill instanceof FinishBlow
                    || skill instanceof BattleKingBar1
                    || skill instanceof ReaperScythe
                    || skill instanceof CrestOfTheSolar
                    || skill instanceof SpiderInMirror
            ) {
                addSkillEvent(blackMark);
                if (
                        getStart().before(abyssalLightningEndTime)
                        && cooldownCheck(netherworldLightning)
                ) {
                    addSkillEvent(netherworldLightning);
                }
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= this.getFinalAttack().getProp()) {
                    addSkillEvent(this.getFinalAttack());
                    addSkillEvent(blackMark);
                    if (
                            getStart().before(abyssalLightningEndTime)
                            && cooldownCheck(netherworldLightning)
                    ) {
                        addSkillEvent(netherworldLightning);
                    }
                }
            }
            if (skill instanceof AbyssalLightning) {
                this.abyssalLightningStartTimeList.add(new Timestamp(getStart().getTime()));
                this.abyssalLightningEndTimeList.add(new Timestamp(getStart().getTime() + 43000));
                abyssalLightningEndTime = new Timestamp(getStart().getTime() + 43000);
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
                    if (
                            skill instanceof GrimReaper
                            || skill instanceof GrimReaperMOD
                    ) {
                        i += 840;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        Long ran = (long) (Math.random() * 99 + 1);
                        if (
                                skill instanceof BlackMagicAltar
                                        && ran <= this.getFinalAttack().getProp()
                        ) {
                            Timestamp now = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            addSkillEvent(this.getFinalAttack());
                            addSkillEvent(blackMark);
                            getStart().setTime(now.getTime());
                        }
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
                attackCnt++;
                if (
                        attackCnt >= 2
                        && cooldownCheck(death)
                        && !(skill instanceof Death)
                        && !(skill instanceof DeathReinforce)
                                && !(skill instanceof BlackMark)
                                && !(skill instanceof FinalAttackBattleMage)
                ) {
                    if (
                            getStart().before(masterOfDeathEndTime)
                            && soulCnt >= 1
                    ) {
                        addSkillEvent(deathReinforce);
                        death.setActivateTime(new Timestamp(deathReinforce.getActivateTime().getTime()));
                        soulCnt = 0;
                    } else if (soulCnt >= 4) {
                        addSkillEvent(deathReinforce);
                        death.setActivateTime(new Timestamp(deathReinforce.getActivateTime().getTime()));
                        soulCnt = 0;
                    } else {
                        addSkillEvent(death);
                        deathReinforce.setActivateTime(new Timestamp(death.getActivateTime().getTime()));
                        soulCnt ++;
                    }
                    attackCnt = 0;
                    getEventTimeList().add(new Timestamp(getStart().getTime()));
                }
            }
        }
        if (
                getStart().before(masterOfDeathEndTime)
                && (
                        skill instanceof Death
                        || skill instanceof DeathReinforce
                )
        ) {
            skill.setActivateTime(new Timestamp(getStart().getTime() + 2040));
        } else {
            applyCooldown(skill);
        }
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
            boolean isMasterOfDeath = false;
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof MasterOfDeath) {
                    isMasterOfDeath = true;
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
            for (SkillEvent se : useAttackSkillList) {
                if (
                        isMasterOfDeath
                        && (
                                se.getSkill() instanceof Death
                                || se.getSkill() instanceof DeathReinforce
                        )
                ) {
                    buffSkill.addBuffFinalDamage(1.5);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isMasterOfDeath
                        && (
                                se.getSkill() instanceof Death
                                || se.getSkill() instanceof DeathReinforce
                        )
                ) {
                    buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.5);
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
        return attackDamage;
    }
}
