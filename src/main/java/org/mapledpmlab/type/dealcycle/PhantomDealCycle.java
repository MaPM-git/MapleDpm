package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.phantom.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.phantom.BullsEye;
import org.mapledpmlab.type.skill.buffskill.phantom.FinalCutBuff;
import org.mapledpmlab.type.skill.buffskill.phantom.JokerHourglass;
import org.mapledpmlab.type.skill.buffskill.phantom.JokerSword;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PhantomDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BlackJack());
            add(new BlackJackFinal());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DefyingFate());
            add(new DefyingFateHeroWill());
            add(new FinalCut());
            add(new Joker());
            add(new Judgement());
            add(new MarkOfPhantom());
            add(new MarkOfPhantomFinal());
            add(new NoireCarte());
            add(new NoireCarteReverse());
            add(new RiftBreak());
            add(new RoseCarteFinale());
            add(new RoseCarteFinaleDot());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TempestOfCard());
            add(new UltimateDrive());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new BlackJackBeforeDelay());
            add(new JokerAfterDelay());
            add(new JokerBeforeDelay());
            add(new MarkOfPhantom());
            add(new TempestOfCardBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BullsEye());
            add(new FinalCutBuff());
            add(new HeroesOath());
            add(new JokerHourglass());
            add(new JokerSword());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    BlackJackFinal blackJackFinal = new BlackJackFinal();
    Judgement judgement = new Judgement();
    MarkOfPhantomFinal markOfPhantomFinal = new MarkOfPhantomFinal();
    NoireCarteReverse noireCarteReverse = new NoireCarteReverse();
    RiftBreak riftBreak = new RiftBreak();

    Long cardStack = 0L;

    public PhantomDealCycle(Job job) {
        super(job, new NoireCarte());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        BlackJackBeforeDelay blackJackBeforeDelay = new BlackJackBeforeDelay();
        BullsEye bullsEye = new BullsEye();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DefyingFate defyingFate = new DefyingFate();
        FinalCutBuff finalCutBuff = new FinalCutBuff();
        HeroesOath heroesOath = new HeroesOath();
        JokerBeforeDelay jokerBeforeDelay = new JokerBeforeDelay();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MarkOfPhantom markOfPhantom = new MarkOfPhantom();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RiftBreak riftBreak = new RiftBreak();
        RingSwitching ringSwitching = new RingSwitching();
        RoseCarteFinale roseCarteFinale = new RoseCarteFinale();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        TempestOfCardBeforeDelay tempestOfCardBeforeDelay = new TempestOfCardBeforeDelay();
        ThiefCunning thiefCunning = new ThiefCunning();
        UltimateDrive ultimateDrive = new UltimateDrive();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        dealCycle1.add(finalCutBuff);
        dealCycle1.add(heroesOath);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(bullsEye);
        dealCycle1.add(soulContract);
        dealCycle1.add(readyToDie);
        dealCycle1.add(blackJackBeforeDelay);
        dealCycle1.add(markOfPhantom);
        dealCycle1.add(restraintRing);
        dealCycle1.add(defyingFate);
        dealCycle1.add(riftBreak);
        dealCycle1.add(jokerBeforeDelay);
        dealCycle1.add(blackJackBeforeDelay);
        dealCycle1.add(roseCarteFinale);

        dealCycle2.add(finalCutBuff);
        dealCycle2.add(heroesOath);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(bullsEye);
        dealCycle2.add(soulContract);
        dealCycle2.add(readyToDie);
        dealCycle2.add(blackJackBeforeDelay);
        dealCycle2.add(markOfPhantom);
        dealCycle2.add(restraintRing);
        dealCycle2.add(riftBreak);
        dealCycle2.add(jokerBeforeDelay);
        dealCycle2.add(blackJackBeforeDelay);
        dealCycle2.add(roseCarteFinale);

        dealCycle3.add(finalCutBuff);
        dealCycle3.add(soulContract);
        dealCycle3.add(readyToDie);
        dealCycle3.add(blackJackBeforeDelay);
        dealCycle3.add(markOfPhantom);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(riftBreak);
        dealCycle3.add(roseCarteFinale);

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
                    cooldownCheck(markOfPhantom)
                    && !cooldownCheck(readyToDie)
            ) {
                addSkillEvent(markOfPhantom);
            } else if (
                    cooldownCheck(riftBreak)
                    && !cooldownCheck(readyToDie)
            ) {
                addSkillEvent(riftBreak);
            } else if (
                    cooldownCheck(blackJackBeforeDelay)
                    && !cooldownCheck(readyToDie)
            ) {
                addSkillEvent(blackJackBeforeDelay);
            } else if (
                    cooldownCheck(tempestOfCardBeforeDelay)
            ) {
                addSkillEvent(tempestOfCardBeforeDelay);
            } else {
                addSkillEvent(ultimateDrive);
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
                    long i = 0;
                    if (skill instanceof BlackJack) {
                        i = 440 + 180 * 6;
                        AttackSkill as = new BlackJackFinal();
                        for (; i < 440 + 180 * 6 + as.getDotDuration(); i += as.getInterval()) {
                            getSkillEventList().add(new SkillEvent(as, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        }
                        i = 440;
                    } else {
                        i = ((AttackSkill) skill).getInterval();
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
                if (skill instanceof JokerAfterDelay) {
                    skill = new JokerAfterDelay();
                    if (skill.getRelatedSkill() instanceof JokerHourglass) {

                    }
                }
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

    Timestamp noireCarteReverseActivateTime = new Timestamp(-1);

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
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                        if (start.after(noireCarteReverseActivateTime)) {
                            totalDamage += getAttackDamage(new SkillEvent(noireCarteReverse, start, end), buffSkill, start, end);
                            noireCarteReverseActivateTime = new Timestamp(start.getTime() + 4700);
                        }
                        cardStack ++;
                        if (cardStack >= 40) {
                            totalDamage += getAttackDamage(new SkillEvent(judgement, start, end), buffSkill, start, end);
                            cardStack -= 40;
                        }
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
