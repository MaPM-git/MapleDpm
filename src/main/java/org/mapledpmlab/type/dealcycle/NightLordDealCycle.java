package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.nightlord.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.nightlord.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NightLordDealCycle extends DealCycle {

    /*
        스로우 블래스팅 - 에픽 - 메용2 - 얼티밋 다크사이트 - 생사여탈
        다크로드의 비전서 - 스프레드 스로우 - 엔버링크 - 레디 투 다이
        리스트레인트 링 - 풍마 수리검

        스로우 블래스팅 - 에픽 - 메용2 - 얼티밋 다크사이트
        다크로드의 비전서 - 스프레드 스로우 - 엔버링크 - 레디 투 다이
        리스트레인트 링 - 풍마 수리검

        엔버링크 - 레디 투 다이 - 풍마 수리검
     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 엔버링크 - 레디 투 다이 - 풍마 수리검
    private List<Skill> dealCycle3 = new ArrayList<>();

    private boolean isSpreadThrow = false;

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BleedingToxinDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DarkFlare());
            add(new DarkLordsSecretScroll());
            add(new DarkLordsSecretScrollFinish());
            add(new FatalVenom());
            add(new FumaShuriken());
            add(new LifeOrDeathJavelin());
            add(new LifeOrDeathSlash());
            add(new MarkOfAssassin());
            add(new QuadrupleThrow());
            add(new QuadrupleThrowReinforce());
            add(new QuadrupleThrowReinforceSpread());
            add(new QuadrupleThrowSpread());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new ThrowBlastingActive());
            add(new ThrowBlastingPassive());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new DarkSight());
            add(new EpicAdventure());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new PurgeArea());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SpreadThrow());
            add(new ThiefCunning());
            add(new ThrowBlasting());
            add(new UltimateDarkSight());
        }
    };

    public NightLordDealCycle(Job job) {
        super(job, new MarkOfAssassin());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        BleedingToxinDot bleedingToxinDot = new BleedingToxinDot();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DarkFlare darkFlare = new DarkFlare();
        DarkLordsSecretScroll darkLordsSecretScroll = new DarkLordsSecretScroll();
        EpicAdventure epicAdventure = new EpicAdventure();
        FatalVenom fatalVenom = new FatalVenom();
        FumaShuriken fumaShuriken = new FumaShuriken();
        LifeOrDeathSlash lifeOrDeathSlash = new LifeOrDeathSlash();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PriorPreparation priorPreparation = new PriorPreparation();
        PurgeArea purgeArea = new PurgeArea();
        QuadrupleThrow quadrupleThrow = new QuadrupleThrow();
        QuadrupleThrowReinforce quadrupleThrowReinforce = new QuadrupleThrowReinforce();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpreadThrow spreadThrow = new SpreadThrow();
        ThiefCunning thiefCunning = new ThiefCunning();
        ThrowBlasting throwBlasting = new ThrowBlasting();
        ThrowBlastingActive throwBlastingActive = new ThrowBlastingActive();
        ThrowBlastingPassive throwBlastingPassive = new ThrowBlastingPassive();
        UltimateDarkSight ultimateDarkSight = new UltimateDarkSight();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 블리딩 톡신(도트)
        for (int i = 0; i < 720 * 1000; i += bleedingToxinDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(bleedingToxinDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 페이탈 베놈
        for (int i = 0; i < 720 * 1000; i += fatalVenom.getInterval()) {
            getSkillEventList().add(new SkillEvent(fatalVenom, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(throwBlasting);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(ultimateDarkSight);
        dealCycle1.add(lifeOrDeathSlash);
        dealCycle1.add(darkLordsSecretScroll);
        dealCycle1.add(spreadThrow);
        dealCycle1.add(soulContract);
        dealCycle1.add(readyToDie);
        dealCycle1.add(restraintRing);
        dealCycle1.add(fumaShuriken);

        dealCycle2.add(throwBlasting);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(ultimateDarkSight);
        dealCycle2.add(darkLordsSecretScroll);
        dealCycle2.add(spreadThrow);
        dealCycle2.add(soulContract);
        dealCycle2.add(readyToDie);
        dealCycle2.add(restraintRing);
        dealCycle2.add(fumaShuriken);

        dealCycle3.add(soulContract);
        dealCycle3.add(readyToDie);
        dealCycle3.add(fumaShuriken);

        List<Skill> throwBlastingList;
        List<Skill> dealCycle;

        Long throwBlastingCount = 68L;
        Long ran = 0L;
        Long quadrupleThrowCount = 0L;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(purgeArea)) {
                addSkillEvent(purgeArea);
            }
            if (cooldownCheck(darkFlare)) {
                addSkillEvent(darkFlare);
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
            ) {
                mapleWorldGoddessBlessing.setEndTime(new Timestamp(getStart().getTime() + mapleWorldGoddessBlessing.getDuration() * 1000));
                throwBlastingList = new ArrayList<>();
                dealCycle = new ArrayList<>();
                while (throwBlastingCount != 0) {
                    ran = (long) (Math.random() * 3 + 2);
                    if (ran > throwBlastingCount) {
                        ran = throwBlastingCount;
                    }
                    if (quadrupleThrowCount % 3 == 0) {
                        throwBlastingList.add(quadrupleThrowReinforce);
                    } else {
                        throwBlastingList.add(quadrupleThrow);
                    }
                    quadrupleThrowCount++;
                    for (int i = 0; i < ran; i++) {
                        throwBlastingList.add(throwBlastingActive);
                    }
                    throwBlastingCount -= ran;
                }
                throwBlastingCount = 68L;
                dealCycle.addAll(dealCycle1);
                dealCycle.addAll(throwBlastingList);
                addDealCycle(dealCycle);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                throwBlastingList = new ArrayList<>();
                dealCycle = new ArrayList<>();
                while (throwBlastingCount != 0) {
                    ran = (long) (Math.random() * 3 + 2);
                    if (ran > throwBlastingCount) {
                        ran = throwBlastingCount;
                    }
                    if (quadrupleThrowCount % 3 == 0) {
                        throwBlastingList.add(quadrupleThrowReinforce);
                    } else {
                        throwBlastingList.add(quadrupleThrow);
                    }
                    quadrupleThrowCount++;
                    for (int i = 0; i < ran; i++) {
                        throwBlastingList.add(throwBlastingActive);
                    }
                    throwBlastingCount -= ran;
                }
                throwBlastingCount = 68L;
                dealCycle.addAll(dealCycle2);
                dealCycle.addAll(throwBlastingList);
                addDealCycle(dealCycle);
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().before(new Timestamp(ultimateDarkSight.getActivateTime().getTime() - 70000))
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(throwBlastingPassive)
            ) {
                addSkillEvent(throwBlastingPassive);
            } else if (
                    cooldownCheck(darkLordsSecretScroll)
                    && !cooldownCheck(throwBlasting)
            ) {
                addSkillEvent(darkLordsSecretScroll);
            } else if (
                    cooldownCheck(fumaShuriken)
                    && !cooldownCheck(readyToDie)
            ) {
                addSkillEvent(fumaShuriken);
            } else {
                if (quadrupleThrowCount % 3 == 0) {
                    addSkillEvent(quadrupleThrowReinforce);
                } else {
                    addSkillEvent(quadrupleThrow);
                }
                quadrupleThrowCount ++;
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
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof SpreadThrow) {
                    isSpreadThrow = true;
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
                Long ran = 0L;
                if (
                        start.equals(se.getStart())
                        && se.getSkill() instanceof QuadrupleThrow
                        && isSpreadThrow
                ) {
                    totalDamage += getAttackDamage(new SkillEvent(new QuadrupleThrowSpread(), start, end), buffSkill, start, end);
                    totalDamage += getAttackDamage(new SkillEvent(new QuadrupleThrowSpread(), start, end), buffSkill, start, end);
                    totalDamage += getAttackDamage(new SkillEvent(new QuadrupleThrowSpread(), start, end), buffSkill, start, end);
                    for (int j = 0; j < 15; j++) {
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                        }
                    }
                }
                if (
                        start.equals(se.getStart())
                        && se.getSkill() instanceof QuadrupleThrowReinforce
                        && isSpreadThrow
                ) {
                    totalDamage += getAttackDamage(new SkillEvent(new QuadrupleThrowReinforceSpread(), start, end), buffSkill, start, end);
                    totalDamage += getAttackDamage(new SkillEvent(new QuadrupleThrowReinforceSpread(), start, end), buffSkill, start, end);
                    totalDamage += getAttackDamage(new SkillEvent(new QuadrupleThrowReinforceSpread(), start, end), buffSkill, start, end);
                    for (int j = 0; j < 15; j++) {
                        ran = (long) (Math.random() * 99 + 1);
                        if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                        }
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    if (se.getSkill() instanceof FumaShuriken) {
                        getFinalAttack().setProp(28L);
                    }
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                    getFinalAttack().setProp(39L);
                }
            }
            isSpreadThrow = false;
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
