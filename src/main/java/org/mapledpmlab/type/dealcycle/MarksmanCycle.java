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

public class MarksmanCycle extends DealCycle {
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

    public MarksmanCycle(Job job) {
        super(job, new FinalAttackMarksman());

        this.setAttackSkillList(attackSkillList);

        BullsEye bullsEye = new BullsEye();
        ChargedArrow chargedArrow = new ChargedArrow();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
        EnhanceSnipe enhanceSnipe = new EnhanceSnipe();
        EnhanceSnipeAdditional enhanceSnipeAdditional = new EnhanceSnipeAdditional();
        EpicAdventure epicAdventure = new EpicAdventure();
        Evolve evolve = new Evolve();
        FinalAimArrow finalAimArrow = new FinalAimArrow();
        FinalAimWave finalAimWave = new FinalAimWave();
        FinalAttackMarksman finalAttackMarksman = new FinalAttackMarksman();
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
        SpiderInMirrorDot spiderInMirrorDot = new SpiderInMirrorDot();
        SplitArrow splitArrow = new SplitArrow();
        SplitArrowBuff splitArrowBuff = new SplitArrowBuff();
        ThiefCunning thiefCunning = new ThiefCunning();
        TrueSnipe trueSnipe = new TrueSnipe();
        UltimateSnipe ultimateSnipe = new UltimateSnipe();
        UltimateSnipeAdditional ultimateSnipeAdditional = new UltimateSnipeAdditional();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(340L);
        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 프리져
        for (int i = 0; i < 720 * 1000; i += freezer.getInterval()) {
            getSkillEventList().add(new SkillEvent(freezer, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

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
        dealCycle1.add(finalAimWave);
        dealCycle1.add(trueSnipe);
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
        dealCycle2.add(finalAimWave);
        dealCycle2.add(trueSnipe);
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
        dealCycle5.add(weaponJumpRing);
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
        int i = 0;
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
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
                    cooldownCheck(trueSnipe)
                    && !cooldownCheck(soulContract)
            ) {
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
            i++;
        }
        sortEventTimeList();
    }

    public Long getTotalDamage() {
        Long totalDamage = 0L;
        Timestamp start = null;
        Timestamp end = null;
        List<SkillEvent> overlappingSkillEvents;
        BuffSkill buffSkill;
        for (int i = 0; i < getEventTimeList().size() -1; i++) {
            List<SkillEvent> useAttackSkillList = new ArrayList<>();
            buffSkill = new BuffSkill();
            start = getEventTimeList().get(i);
            end = getEventTimeList().get(i + 1);
            overlappingSkillEvents = getOverlappingSkillEvents(start, end);
            overlappingSkillEvents = deduplication(overlappingSkillEvents, SkillEvent::getSkill);
            boolean isEvolve = false;
            for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof EvolveBuff) {
                    isEvolve = true;
                    break;
                }
            }
            if (isEvolve) {
                for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                    if (overlappingSkillEvents.get(j).getSkill() instanceof Freezer) {
                        overlappingSkillEvents.remove(j);
                    }
                }
            }
            for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof CriticalReinforce) {
                    isCriticalReinforce = true;
                    break;
                }
            }
            for (int j = 0; j < overlappingSkillEvents.size(); j++) {
                if (overlappingSkillEvents.get(j).getSkill() instanceof SplitArrowBuff) {
                    isSplitArrow = true;
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
                if (
                        isSplitArrow
                        && start.equals(se.getStart())
                        && (se.getSkill() instanceof Snipe
                        || se.getSkill() instanceof EnhanceSnipe
                        || se.getSkill() instanceof UltimateSnipe
                        || se.getSkill() instanceof FinalAimWave
                        || se.getSkill() instanceof FinalAimArrow
                        || se.getSkill() instanceof RepeatingCrossbowCartridge)
                ) {
                    totalDamage += getAttackDamage(new SkillEvent(new SplitArrow(), start, end), buffSkill, start, end);
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
