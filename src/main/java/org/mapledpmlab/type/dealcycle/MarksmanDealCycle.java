package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.marksman.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.marksman.BullsEye;
import org.mapledpmlab.type.skill.buffskill.marksman.RepeatingCrossbowCartridgeBuff;
import org.mapledpmlab.type.skill.buffskill.marksman.SplitArrowBuff;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MarksmanDealCycle extends DealCycle {

    private boolean isCriticalReinforce = false;

    private boolean isSplitArrow = false;

    int splitArrow6th = 0;

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ChargedArrow());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EnhanceSnipe());
            add(new EnhanceSnipeAdditional());
            add(new Evolve());
            add(new FinalAimArrow());
            add(new FinalAimWave());
            add(new FinalAttackMarksman());
            add(new Freezer());
            add(new GuidedArrow());
            add(new RepeatingCrossbowCartridge());
            add(new Snipe());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SplitArrow());
            add(new TrueSnipe());
            add(new UltimateSnipe());
            add(new UltimateSnipeAdditional());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BullsEye());
            add(new CriticalReinforce(100.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RepeatingCrossbowCartridgeBuff());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SplitArrowBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    public MarksmanDealCycle(Job job) {
        super(job, new FinalAttackMarksman());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        BullsEye bullsEye = new BullsEye();
        ChargedArrow chargedArrow = new ChargedArrow();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(100.0);
        EnhanceSnipe enhanceSnipe = new EnhanceSnipe();
        EpicAdventure epicAdventure = new EpicAdventure();
        Evolve evolve = new Evolve();
        FinalAimWave finalAimWave = new FinalAimWave();
        Freezer freezer = new Freezer();
        GuidedArrow guidedArrow = new GuidedArrow();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        RepeatingCrossbowCartridge repeatingCrossbowCartridge = new RepeatingCrossbowCartridge();
        RepeatingCrossbowCartridgeBuff repeatingCrossbowCartridgeBuff = new RepeatingCrossbowCartridgeBuff();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        Snipe snipe = new Snipe();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SplitArrowBuff splitArrowBuff = new SplitArrowBuff();
        TrueSnipe trueSnipe = new TrueSnipe();
        UltimateSnipe ultimateSnipe = new UltimateSnipe();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);

        List<AttackSkill> snipeList = new ArrayList<>();
        snipeList.add(snipe);
        snipeList.add(enhanceSnipe);
        snipeList.add(snipe);
        snipeList.add(ultimateSnipe);
        int snipeCount = 1;
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(freezer)) {
                addSkillEvent(freezer);
            }
            if (
                    cooldownCheck(splitArrowBuff)
                    && cooldownCheck(repeatingCrossbowCartridgeBuff)
                    && cooldownCheck(epicAdventure)
                    && cooldownCheck(bullsEye)
                    && cooldownCheck(evolve)
                    && cooldownCheck(criticalReinforce)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(chargedArrow)
                    && cooldownCheck(trueSnipe)
            ) {
                addSkillEvent(splitArrowBuff);
                addSkillEvent(repeatingCrossbowCartridgeBuff);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(snipeList.get(snipeCount % 4));
                    snipeCount++;
                }
                if (cooldownCheck(mapleWorldGoddessBlessing)) {
                    if (dealCycleOrder == 3) {
                        mapleWorldGoddessBlessing.setCooldown(0.0);
                    } else {
                        mapleWorldGoddessBlessing.setCooldown(180.0);
                    }
                    addSkillEvent(mapleWorldGoddessBlessing);
                }
                addSkillEvent(evolve);
                addSkillEvent(bullsEye);
                addSkillEvent(criticalReinforce);
                addSkillEvent(soulContract);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(chargedArrow);
                addSkillEvent(trueSnipe);
                if (cooldownCheck(finalAimWave)) {
                    addSkillEvent(finalAimWave);
                }
                for (int i = 0; i < 8; i++) {
                    addSkillEvent(repeatingCrossbowCartridge);
                }
                dealCycleOrder ++;
                splitArrow6th = 13;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(100 * 1000))
                    && getStart().before(new Timestamp(10 * 60 * 1000)))
            {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(trueSnipe)
                    && cooldownCheck(soulContract)
                    && !cooldownCheck(evolve)
            ) {
                addSkillEvent(soulContract);
                addSkillEvent(trueSnipe);
            } else if (
                    cooldownCheck(chargedArrow)
                    && !cooldownCheck(trueSnipe)
            ) {
                addSkillEvent(chargedArrow);
            } else {
                addSkillEvent(snipeList.get(snipeCount % 4));
                snipeCount++;
            }
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
                    if (useAttackSkillList.get(j).getSkill() instanceof Freezer) {
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
                if (useBuffSkillList.get(j).getSkill() instanceof SplitArrowBuff) {
                    isSplitArrow = true;
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
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isSplitArrow
                        && start.equals(se.getStart())
                        && (se.getSkill() instanceof Snipe
                        || se.getSkill() instanceof EnhanceSnipe
                        || se.getSkill() instanceof UltimateSnipe
                        || se.getSkill() instanceof FinalAimWave
                        || se.getSkill() instanceof RepeatingCrossbowCartridge)
                ) {
                    if (se.getSkill() instanceof FinalAimWave && splitArrow6th > 0) {
                        totalDamage += getAttackDamage(new SkillEvent(new SplitArrow(), start, end), buffSkill, start, end);
                        splitArrow6th --;
                    } else if (!(se.getSkill() instanceof FinalAimWave)) {
                        totalDamage += getAttackDamage(new SkillEvent(new SplitArrow(), start, end), buffSkill, start, end);
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            isCriticalReinforce = false;
            isSplitArrow = false;
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
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP());
            buffSkill.addBuffCriticalDamage(criticalReinforce.getBuffCriticalDamage());
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
                            * (Math.floor((this.getJob().getAtt() + buffSkill.getBuffAttMagic())
                            * (1 + (this.getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
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
        if (isCriticalReinforce) {
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP());
            buffSkill.addBuffCriticalDamage(-criticalReinforce.getBuffCriticalDamage());
        }
        return attackDamage;
    }
}
