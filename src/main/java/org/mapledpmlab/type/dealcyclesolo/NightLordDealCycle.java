package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
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

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BleedingToxinDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DarkFlareNightLord());
            add(new DarkLordsSecretScroll());
            add(new DarkLordsSecretScrollFinish());
            add(new DarknessShuriken());
            add(new FatalVenom());
            add(new FourSeasons());
            add(new FourSeasonsRamphant());
            add(new FourSeasonsRamphantAnnihilation());
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            //add(new DarkSight());
            add(new EpicAdventure());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PurgeArea());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SpreadThrow());
            add(new ThrowBlasting());
            add(new UltimateDarkSight());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Long quadrupleThrowCount = 2L;
    Long throwBlastingCount = 68L;

    boolean isSpreadThrow = false;
    boolean isRamphant = true;

    List<Skill> throwBlastingList;

    BleedingToxinDot bleedingToxinDot = new BleedingToxinDot();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DarkFlareNightLord darkFlareNightLord = new DarkFlareNightLord();
    DarkLordsSecretScroll darkLordsSecretScroll = new DarkLordsSecretScroll();
    DarknessShuriken darknessShuriken = new DarknessShuriken();
    EpicAdventure epicAdventure = new EpicAdventure();
    FatalVenom fatalVenom = new FatalVenom();
    FourSeasons fourSeasons = new FourSeasons();
    FourSeasonsRamphant fourSeasonsRamphant = new FourSeasonsRamphant();
    FumaShuriken fumaShuriken = new FumaShuriken();
    LifeOrDeathSlash lifeOrDeathSlash = new LifeOrDeathSlash();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    PurgeArea purgeArea = new PurgeArea();
    QuadrupleThrow quadrupleThrow = new QuadrupleThrow();
    QuadrupleThrowReinforce quadrupleThrowReinforce = new QuadrupleThrowReinforce();
    ReadyToDie readyToDie = new ReadyToDie();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SpreadThrow spreadThrow = new SpreadThrow();
    ThrowBlasting throwBlasting = new ThrowBlasting();
    ThrowBlastingActive throwBlastingActive = new ThrowBlastingActive();
    ThrowBlastingPassive throwBlastingPassive = new ThrowBlastingPassive();
    UltimateDarkSight ultimateDarkSight = new UltimateDarkSight();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public NightLordDealCycle(Job job) {
        super(job, new MarkOfAssassin());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

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

        ((AttackSkill) lifeOrDeathSlash.getRelatedSkill()).setDotDuration(((AttackSkill) lifeOrDeathSlash.getRelatedSkill()).getDotDuration() + 3000);

        ringSwitching.setCooldown(90.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);

        // 660
        getSkillSequence1().add(purgeArea);
        getSkillSequence1().add(throwBlasting);
        getSkillSequence1().add(epicAdventure);             // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(ultimateDarkSight);

        // 660
        getSkillSequence2().add(purgeArea);
        getSkillSequence2().add(spreadThrow);               // 300
        getSkillSequence2().add(soulContract);              // 30
        getSkillSequence2().add(readyToDie);                // 300  600
        // 극딜 - 리레, 준극딜 - 웨폰                            // 30
        // 레투다 준극일 땐, 600ms

        purgeArea.setDelay(180L);
        throwBlasting.setDelay(150L);
        mapleWorldGoddessBlessing.setDelay(150L);
        ultimateDarkSight.setDelay(150L);

        spreadThrow.setDelay(120L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (cooldownCheck(darkFlareNightLord)) {
                addSkillEvent(darkFlareNightLord);
            }
            if (cooldownCheck(restraintRing)) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                if (cooldownCheck(lifeOrDeathSlash)) {
                    addSkillEvent(lifeOrDeathSlash);
                }
                addSkillEvent(darkLordsSecretScroll);
                addSkillEvent(spreadThrow);
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(restraintRing);
                addSkillEvent(fumaShuriken);
                if (isRamphant) {
                    addSkillEvent(fourSeasons);
                }
                throwBlastingCount = 68L;
                throwBlastingList = new ArrayList<>();
                while (throwBlastingCount != 0) {
                    long ran = (long) (Math.random() * 3 + 2);
                    if (ran > throwBlastingCount) {
                        ran = throwBlastingCount;
                    }
                    if (quadrupleThrowCount == 3) {
                        throwBlastingList.add(quadrupleThrowReinforce);
                        quadrupleThrowCount = 0L;
                    } else {
                        throwBlastingList.add(quadrupleThrow);
                        quadrupleThrowCount++;
                    }
                    for (int i = 0; i < ran; i++) {
                        throwBlastingList.add(throwBlastingActive);
                    }
                    throwBlastingCount -= ran;
                }
                addDealCycle(throwBlastingList);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && cooldownCheck(readyToDie)
                            && cooldownCheck(darkLordsSecretScroll)
                            && !cooldownCheck(epicAdventure)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                readyToDie.setDelay(420L);
                addSkillEvent(darkLordsSecretScroll);
                addSkillEvent(purgeArea);
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(weaponJumpRing);
                readyToDie.setDelay(300L);
            } else if (
                    cooldownCheck(throwBlastingPassive)
            ) {
                addSkillEvent(throwBlastingPassive);
            } else if (
                    cooldownCheck(fumaShuriken)
                            && (
                                    getStart().before(new Timestamp(throwBlasting.getActivateTime().getTime() - 3000))
                                    || getStart().after(new Timestamp(660 * 1000))
                    )
            ) {
                addSkillEvent(fumaShuriken);
            } else if (
                    cooldownCheck(fourSeasons)
                    && !cooldownCheck(throwBlasting)
            ) {
                addSkillEvent(fourSeasons);
            } else {
                if (quadrupleThrowCount == 3) {
                    addSkillEvent(quadrupleThrowReinforce);
                    quadrupleThrowCount = 0L;
                } else {
                    addSkillEvent(quadrupleThrow);
                    quadrupleThrowCount ++;
                }
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
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
            } else if (
                    skill instanceof RestraintRing
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
                    cooldownCheck(darknessShuriken)
                    && (
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof FourSeasons
                            || skill instanceof FourSeasonsRamphant
                            || skill instanceof FumaShuriken
                            || skill instanceof LifeOrDeathSlash
                            || skill instanceof QuadrupleThrow
                            || skill instanceof QuadrupleThrowReinforce
                    )
            ) {
                addSkillEvent(darknessShuriken);
            }
            if (skill instanceof FourSeasons) {
                if (isRamphant) {
                    skill = fourSeasonsRamphant;
                    isRamphant = false;
                } else {
                    isRamphant = true;
                }
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof DarkLordsSecretScroll) {
                        i = 1530;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        if (skill instanceof LifeOrDeathJavelin) {
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof DarknessShuriken) {
                        i = 840;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
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
        if (skill instanceof FourSeasonsRamphant) {
            applyCooldown(fourSeasons);
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
                        if (bs.getStartTimeList().size() == 0) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        } else if (skillEvent.getStart().after(bs.getStartTimeList().get(bs.getStartTimeList().size() - 1))) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        }
                    }
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
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
