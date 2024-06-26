package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.bowmaster.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.bowmaster.*;
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
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private final List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private final List<Skill> dealCycle4 = new ArrayList<>();

    // 웨폰퍼프
    private final List<Skill> dealCycle5 = new ArrayList<>();

    private final AdvancedQuiver advancedQuiver = new AdvancedQuiver();

    private final FlashMirage flashMirage = new FlashMirage();

    private final AfterimageShotPassive afterimageShotPassive = new AfterimageShotPassive();

    private boolean isCriticalReinforce = false;

    private Long attackCount1 = 0L;

    private Long attackCount2 = 0L;

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
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

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ArrowRainBuff());
            add(new CriticalReinforce(100.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(275L));
            //add(new MortalBlow());
            add(new Preparation());
            add(new PriorPreparation());
            add(new QuiverFullBurstBuff());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(318L));
        }
    };

    Timestamp warInTheShadeEndTime = new Timestamp(-1);

    WarInTheShadePerfusion warInTheShadePerfusion = new WarInTheShadePerfusion();

    public BowmasterDealCycle(Job job) {
        super(job, new AdvancedFinalAttackBowmaster());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AfterimageShotActive afterimageShotActive = new AfterimageShotActive();
        ArrawPlatter arrawPlatter = new ArrawPlatter();
        ArrawRain arrawRain = new ArrawRain();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(100.0);
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
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
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

        Long specialArrow = 75L;
        boolean isSpree = false;

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(arrawPlatter)){
                addSkillEvent(arrawPlatter);
            }
            if (specialArrow == 75) {
                isSpree = true;
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
                    && dealCycleOrder == 1
            ) {
                addDealCycle(dealCycle1);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
                    && dealCycleOrder == 4
            ) {
                addDealCycle(dealCycle2);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
                    && getStart().before(new Timestamp(5 * 60 * 1000))
                    && dealCycleOrder == 3
            ) {
                addDealCycle(dealCycle3);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle4)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
            ) {
                addDealCycle(dealCycle4);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && specialArrow == 75
                    && dealCycleOrder == 5
            ) {
                addDealCycle(dealCycle5);
                dealCycleOrder ++;
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
            boolean isAfterimageShot = false;
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
                if (useAttackSkillList.get(j).getSkill() instanceof AfterimageShotBuff) {
                    isAfterimageShot = true;
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
                        !isAfterimageShot
                        && se.getStart().equals(start)
                        && (
                                se.getSkill() instanceof AdvancedQuiver
                                || se.getSkill() instanceof FlashMirage
                                || se.getSkill() instanceof Hurricane
                                || se.getSkill() instanceof HurricaneSpree
                                || se.getSkill() instanceof ArrawRain
                                || se.getSkill() instanceof QuiverFullBurst
                                || se.getSkill() instanceof SilhouetteMirage
                        )
                ) {
                    attackCount2 ++;
                    if (attackCount2 == 10) {
                        getStart().setTime(start.getTime());
                        if (cooldownCheck(afterimageShotPassive)) {
                            totalDamage += getAttackDamage(new SkillEvent(afterimageShotPassive, start, end), buffSkill, start, end);
                            applyCooldown(afterimageShotPassive);
                        }
                        attackCount2 = 0L;
                    }
                }
                if (
                        se.getStart().equals(start)
                        && (
                                se.getSkill() instanceof Hurricane
                                || se.getSkill() instanceof HurricaneSpree
                                || se.getSkill() instanceof SilhouetteMirage
                                || se.getSkill() instanceof AfterimageShotActive
                                || se.getSkill() instanceof AfterimageShotPassive
                                || se.getSkill() instanceof QuiverFullBurst
                                || se.getSkill() instanceof ArrawRain
                                || se.getSkill() instanceof WarInTheShade
                        )
                ) {
                    attackCount1++;
                    if (se.getSkill() instanceof WarInTheShade) {
                        attackCount1 += 6;
                    }
                    if (attackCount1 >= 49) {
                        getStart().setTime(start.getTime());
                        if (cooldownCheck(flashMirage)) {
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            applyCooldown(flashMirage);
                        }
                        attackCount1 = 0L;
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
                if (
                        !(se.getSkill() instanceof ArrawPlatter)
                        && ((AttackSkill) se.getSkill()).getDamage() != 0
                        && start.equals(se.getStart())
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= advancedQuiver.getProp()) {
                        totalDamage += getAttackDamage(new SkillEvent(advancedQuiver, start, end), buffSkill, start, end);
                    }
                }
            }
            isCriticalReinforce = false;
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

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

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
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (
                    getStart().before(warInTheShadeEndTime)
                    && cooldownCheck(warInTheShadePerfusion)
            ) {
                Long attackCount = 0L;
                for (long i = warInTheShadePerfusion.getInterval(); i <= warInTheShadePerfusion.getDotDuration() && attackCount < warInTheShadePerfusion.getLimitAttackCount(); i += warInTheShadePerfusion.getInterval()) {
                    getSkillEventList().add(new SkillEvent(warInTheShadePerfusion, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    attackCount += 1;
                }
                applyCooldown(warInTheShadePerfusion);
            }
            if (skill instanceof WarInTheShade) {
                warInTheShadeEndTime = new Timestamp(getStart().getTime() + skill.getDelay() + 30000);
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
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }
}
