package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
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
    /*
    스플릿 애로우-리피팅 크로스보우 카트리지-메용2-에픽어드벤쳐
    크오솔-스인미-불스아이-이볼브-크리티컬 리인포스-소울컨트랙트-시드링
    6차-트루 스나이핑-리피팅 크로스보우 카트리지 소모
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

    private boolean isSplitArrow = false;

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BullsEye());
            add(new CriticalReinforce(0.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(275L));
            add(new PriorPreparation());
            add(new RepeatingCrossbowCartridgeBuff());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SplitArrowBuff());
            add(new ThiefCunning());
            add(new WeaponJumpRing(326L));
        }
    };

    public MarksmanDealCycle(Job job) {
        super(job, new FinalAttackMarksman());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        BullsEye bullsEye = new BullsEye();
        ChargedArrow chargedArrow = new ChargedArrow();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
        EnhanceSnipe enhanceSnipe = new EnhanceSnipe();
        EpicAdventure epicAdventure = new EpicAdventure();
        Evolve evolve = new Evolve();
        FinalAimWave finalAimWave = new FinalAimWave();
        Freezer freezer = new Freezer();
        GuidedArrow guidedArrow = new GuidedArrow();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PriorPreparation priorPreparation = new PriorPreparation();
        RepeatingCrossbowCartridge repeatingCrossbowCartridge = new RepeatingCrossbowCartridge();
        RepeatingCrossbowCartridgeBuff repeatingCrossbowCartridgeBuff = new RepeatingCrossbowCartridgeBuff();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        Snipe snipe = new Snipe();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SplitArrowBuff splitArrowBuff = new SplitArrowBuff();
        ThiefCunning thiefCunning = new ThiefCunning();
        TrueSnipe trueSnipe = new TrueSnipe();
        UltimateSnipe ultimateSnipe = new UltimateSnipe();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);

        dealCycle1.add(splitArrowBuff);
        dealCycle1.add(repeatingCrossbowCartridgeBuff);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(bullsEye);
        dealCycle1.add(evolve);
        dealCycle1.add(criticalReinforce);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(chargedArrow);
        dealCycle1.add(trueSnipe);
        dealCycle1.add(finalAimWave);
        for (int i = 0; i < 8; i++) {
            dealCycle1.add(repeatingCrossbowCartridge);
        }

        dealCycle2.add(splitArrowBuff);
        dealCycle2.add(repeatingCrossbowCartridgeBuff);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(bullsEye);
        dealCycle2.add(evolve);
        dealCycle2.add(criticalReinforce);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(chargedArrow);
        dealCycle2.add(trueSnipe);
        dealCycle2.add(finalAimWave);
        for (int i = 0; i < 8; i++) {
            dealCycle2.add(repeatingCrossbowCartridge);
        }

        dealCycle3.add(splitArrowBuff);
        dealCycle3.add(repeatingCrossbowCartridgeBuff);
        dealCycle3.add(epicAdventure);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(bullsEye);
        dealCycle3.add(evolve);
        dealCycle3.add(criticalReinforce);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);
        dealCycle3.add(chargedArrow);
        dealCycle3.add(trueSnipe);
        for (int i = 0; i < 8; i++) {
            dealCycle3.add(repeatingCrossbowCartridge);
        }

        dealCycle4.add(splitArrowBuff);
        dealCycle4.add(repeatingCrossbowCartridgeBuff);
        dealCycle4.add(epicAdventure);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(bullsEye);
        dealCycle4.add(evolve);
        dealCycle4.add(criticalReinforce);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(chargedArrow);
        dealCycle4.add(trueSnipe);
        for (int i = 0; i < 8; i++) {
            dealCycle4.add(repeatingCrossbowCartridge);
        }

        dealCycle5.add(splitArrowBuff);
        dealCycle5.add(repeatingCrossbowCartridgeBuff);
        dealCycle5.add(epicAdventure);
        dealCycle5.add(bullsEye);
        dealCycle5.add(evolve);
        dealCycle5.add(criticalReinforce);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);
        dealCycle5.add(chargedArrow);
        dealCycle5.add(trueSnipe);
        for (int i = 0; i < 8; i++) {
            dealCycle5.add(repeatingCrossbowCartridge);
        }

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
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 1
            ) {
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 4
            ) {
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(6 * 60 * 1000))
                    && dealCycleOrder == 3
            ) {
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 5
            ) {
                addDealCycle(dealCycle5);
                dealCycleOrder ++;
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

    int finalAimCnt = 0;

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
                    if (se.getSkill() instanceof FinalAimWave && i < 13) {
                        totalDamage += getAttackDamage(new SkillEvent(new SplitArrow(), start, end), buffSkill, start, end);
                        i ++;
                    } else if (!(se.getSkill() instanceof FinalAimWave)) {
                        totalDamage += getAttackDamage(new SkillEvent(new SplitArrow(), start, end), buffSkill, start, end);
                    } else if (
                            start.after(new Timestamp(60 * 3 * 1000))
                            && start.before(new Timestamp(60 * 8 * 1000))
                            && i == 13
                    ) {
                        i = 0;
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
                if (as.getMultiAttackInfo().size() == 0 && as.getInterval() == 0 && as.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / as.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        return attackDamage;
    }
}
