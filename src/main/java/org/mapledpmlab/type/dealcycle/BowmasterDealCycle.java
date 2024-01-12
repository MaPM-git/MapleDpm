package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.bowmaster.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.bowmaster.ArrowRainBuff;
import org.mapledpmlab.type.skill.buffskill.bowmaster.MortalBlow;
import org.mapledpmlab.type.skill.buffskill.bowmaster.Preparation;
import org.mapledpmlab.type.skill.buffskill.bowmaster.QuiverFullBurstBuff;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BowmasterDealCycle extends DealCycle {
    /*
    에로우 레인-메용2-에픽어드벤쳐-크오솔-스인미-퀴버풀버스트-프리퍼레이션
    이볼브-잔영의시-크리티컬리인포스-소울컨트랙트-시드링-6차-난사모드
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

    private AdvancedQuiver advancedQuiver = new AdvancedQuiver();

    private FlashMirage flashMirage = new FlashMirage();

    private AfterimageShotPassive afterimageShotPassive = new AfterimageShotPassive();

    private boolean isCriticalReinforce = false;

    private boolean isAfterImageShotActive = false;

    private Long attackCount1 = 0L;

    private Long attackCount2 = 0L;

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackBowmaster());
            add(new AdvancedQuiver());
            add(new AfterimageShotActive());
            add(new AfterimageShotPassive());
            add(new ArrawPlatter());
            add(new ArrawRain());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new Evolve());
            add(new FlashMirage());
            add(new GuidedArrow());
            add(new Hurricane());
            add(new HurricaneSpree());
            add(new Phoenix());
            add(new QuiverFullBurst());
            add(new SilhouetteMirage());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new WarInTheShade());
            add(new WarInTheShadePerfusion());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new AfterimageShotDelay());
            add(new ArrawPlatterDelay());
            add(new PhoenixDelay());
            add(new WarInTheShadeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ArrowRainBuff());
            add(new CriticalReinforce(0.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(275L));
            add(new MortalBlow());
            add(new Preparation());
            add(new PriorPreparation());
            add(new QuiverFullBurstBuff());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(318L));
        }
    };

    public BowmasterDealCycle(Job job) {
        super(job, new AdvancedFinalAttackBowmaster());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AfterimageShotActive afterimageShotActive = new AfterimageShotActive();
        ArrawPlatter arrawPlatter = new ArrawPlatter();
        ArrawPlatterDelay arrawPlatterDelay = new ArrawPlatterDelay();
        ArrawRain arrawRain = new ArrawRain();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
        EpicAdventure epicAdventure = new EpicAdventure();
        Evolve evolve = new Evolve();
        GuidedArrow guidedArrow = new GuidedArrow();
        Hurricane hurricane = new Hurricane();
        HurricaneSpree hurricaneSpree = new HurricaneSpree();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        Preparation preparation = new Preparation();
        PriorPreparation priorPreparation = new PriorPreparation();
        Phoenix phoenix = new Phoenix();
        QuiverFullBurst quiverFullBurst = new QuiverFullBurst();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SilhouetteMirage silhouetteMirage = new SilhouetteMirage();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        WarInTheShade warInTheShade = new WarInTheShade();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 피닉스
        for (int i = 0; i < 720 * 1000; i += phoenix.getInterval()) {
            getSkillEventList().add(new SkillEvent(phoenix, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 애로우 플래터
        for (int i = 0; i < 720 * 1000; i += arrawPlatter.getInterval()) {
            getSkillEventList().add(new SkillEvent(arrawPlatter, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 실루엣 미라주
        for (int i = 0; i < 720 * 1000; i += 7500) {
            for (int j = 0; j < silhouetteMirage.getInterval() * silhouetteMirage.getLimitAttackCount(); j += silhouetteMirage.getInterval()) {
                getSkillEventList().add(new SkillEvent(silhouetteMirage, new Timestamp(i + j), new Timestamp(i + j)));
                getEventTimeList().add(new Timestamp(i + j));
            }
        }

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        dealCycle1.add(arrawRain);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(quiverFullBurst);
        dealCycle1.add(preparation);
        dealCycle1.add(evolve);
        dealCycle1.add(afterimageShotActive);
        dealCycle1.add(criticalReinforce);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(warInTheShade);

        dealCycle2.add(arrawRain);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(quiverFullBurst);
        dealCycle2.add(preparation);
        dealCycle2.add(evolve);
        dealCycle2.add(afterimageShotActive);
        dealCycle2.add(criticalReinforce);
        dealCycle2.add(soulContract);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(warInTheShade);

        dealCycle3.add(arrawRain);
        dealCycle3.add(epicAdventure);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(quiverFullBurst);
        dealCycle3.add(preparation);
        dealCycle3.add(evolve);
        dealCycle3.add(afterimageShotActive);
        dealCycle3.add(criticalReinforce);
        dealCycle3.add(soulContract);
        dealCycle3.add(restraintRing);

        dealCycle4.add(arrawRain);
        dealCycle4.add(epicAdventure);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(quiverFullBurst);
        dealCycle4.add(preparation);
        dealCycle4.add(evolve);
        dealCycle4.add(afterimageShotActive);
        dealCycle4.add(criticalReinforce);
        dealCycle4.add(soulContract);
        dealCycle4.add(weaponJumpRing);

        dealCycle5.add(arrawRain);
        dealCycle5.add(epicAdventure);
        dealCycle5.add(quiverFullBurst);
        dealCycle5.add(preparation);
        dealCycle5.add(evolve);
        dealCycle5.add(afterimageShotActive);
        dealCycle5.add(criticalReinforce);
        dealCycle5.add(soulContract);
        dealCycle5.add(restraintRing);

        Long specialArrow = 0L;
        boolean isSpree = false;

        int i = 0;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(arrawPlatterDelay)){
                addSkillEvent(arrawPlatterDelay);
            }
            if (specialArrow == 75) {
                isSpree = true;
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
            ) {
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
                    && getStart().before(new Timestamp(5 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(dealCycle4)
                    && i > 140
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75

            ) {
                addDealCycle(dealCycle4);
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
            ) {
                addDealCycle(dealCycle5);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(9 * 60 * 1000)))
            {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                    && !cooldownCheck(evolve)
            ) {
                addSkillEvent(soulContract);
            } else if (specialArrow == 0) {
                addSkillEvent(hurricane);
                specialArrow ++;
                isSpree = false;
            } else if (isSpree) {
                addSkillEvent(hurricaneSpree);
                specialArrow --;
            } else {
                addSkillEvent(hurricane);
                specialArrow ++;
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
                    if (useAttackSkillList.get(j).getSkill() instanceof Phoenix) {
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
            for (int j = 0; j < useAttackSkillList.size(); j++) {
                if (useAttackSkillList.get(j).getSkill() instanceof AfterimageShotActive) {
                    isAfterImageShotActive = true;
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
                if ((se.getSkill() instanceof AfterimageShotPassive) && isAfterImageShotActive) {
                    continue;
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack() && start.equals(se.getStart())) {
                    attackCount1++;
                    if (attackCount1 == 7) {
                        totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                        attackCount1 = 0L;
                    }
                    attackCount2++;
                    if (attackCount2 == 10) {
                        totalDamage += getAttackDamage(new SkillEvent(afterimageShotPassive, start, end), buffSkill, start, end);
                        Long ran = (long) (Math.random() * 99 + 1);
                        if (ran <= getFinalAttack().getProp()) {
                            totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                        }
                        attackCount2 = 0L;
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
                if (!(se.getSkill() instanceof ArrawPlatter) && ((AttackSkill) se.getSkill()).getDamage() != 0 && start.equals(se.getStart())) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= advancedQuiver.getProp()) {
                        totalDamage += getAttackDamage(new SkillEvent(advancedQuiver, start, end), buffSkill, start, end);
                    }
                }
            }
            isCriticalReinforce = false;
            isAfterImageShotActive = false;
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
