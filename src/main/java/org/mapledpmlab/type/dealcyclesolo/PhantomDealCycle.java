package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.phantom.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.phantom.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class PhantomDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BlackJackBeforeDelay());
            add(new BlackJack());
            add(new BlackJackFinal());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DefyingFate());
            add(new DefyingFateHeroWill());
            add(new FinalCut());
            add(new JokerBeforeDelay());
            add(new Joker());
            add(new JokerAfterDelay());
            add(new Judgement());
            add(new LaMortCarte());
            add(new LaMortCarteJoker());
            add(new MarkOfPhantom());
            add(new MarkOfPhantomFinal());
            add(new NoireCarte());
            add(new NoireCarteReverse());
            add(new RiftBreak());
            add(new RoseCarteFinale());
            add(new RoseCarteFinaleDot());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TempestOfCardBeforeDelay());
            add(new TempestOfCard());
            add(new UltimateDrive());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BullsEyePhantom());
            add(new FinalCutBuff());
            add(new FreudBlessing1());
            add(new FreudBlessing2());
            add(new FreudBlessing3());
            add(new FreudBlessing4());
            add(new FreudBlessing5());
            add(new FreudBlessing6());
            add(new HeroesOath());
            add(new JokerHourglass());
            add(new JokerSword());
            add(new LaMortCarteBuff());
            add(new LaMortCarteJokerBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PreparationPhantom());
            add(new ReadyToDie());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int freudStack = 0;

    Long cardStack = 0L;
    Long chk30 = 0L;
    int laMortCarteCount = 0;

    Timestamp laMortCarteEndTime = new Timestamp(-1);
    Timestamp laMortCarteJokerEndTime = new Timestamp(-1);

    BlackJackBeforeDelay blackJackBeforeDelay = new BlackJackBeforeDelay();
    BlackJackFinal blackJackFinal = new BlackJackFinal();
    BullsEyePhantom bullsEye = new BullsEyePhantom();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DefyingFate defyingFate = new DefyingFate();
    FinalCutBuff finalCutBuff = new FinalCutBuff();
    FreudBlessing1 freudBlessing1 = new FreudBlessing1();
    FreudBlessing2 freudBlessing2 = new FreudBlessing2();
    FreudBlessing3 freudBlessing3 = new FreudBlessing3();
    FreudBlessing4 freudBlessing4 = new FreudBlessing4();
    FreudBlessing5 freudBlessing5 = new FreudBlessing5();
    FreudBlessing6 freudBlessing6 = new FreudBlessing6();
    HeroesOath heroesOath = new HeroesOath();
    JokerBeforeDelay jokerBeforeDelay = new JokerBeforeDelay();
    Judgement judgement = new Judgement();
    LaMortCarte laMortCarte = new LaMortCarte();
    LaMortCarteJoker laMortCarteJoker = new LaMortCarteJoker();
    LaMortCarteBuff laMortCarteBuff = new LaMortCarteBuff();
    LaMortCarteJokerBuff laMortCarteJokerBuff = new LaMortCarteJokerBuff();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MarkOfPhantom markOfPhantom = new MarkOfPhantom();
    MarkOfPhantomFinal markOfPhantomFinal = new MarkOfPhantomFinal();
    NoireCarteReverse noireCarteReverse = new NoireCarteReverse();
    PreparationPhantom preparationPhantom = new PreparationPhantom();
    ReadyToDie readyToDie = new ReadyToDie();
    RestraintRing restraintRing = new RestraintRing();
    RiftBreak riftBreak = new RiftBreak();
    RingSwitching ringSwitching = new RingSwitching();
    RoseCarteFinale roseCarteFinale = new RoseCarteFinale();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    TempestOfCardBeforeDelay tempestOfCardBeforeDelay = new TempestOfCardBeforeDelay();
    UltimateDrive ultimateDrive = new UltimateDrive();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public PhantomDealCycle(Job job) {
        super(job, new NoireCarte());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(90.0);
        mapleWorldGoddessBlessing.setCooldown(120.0);

        getSkillSequence1().add(heroesOath);                // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing); // 330
        getSkillSequence1().add(bullsEye);                  // 300
        getSkillSequence1().add(soulContract);              // 30
        getSkillSequence1().add(readyToDie);                // 300

        getSkillSequence2().add(preparationPhantom);        // 300
        getSkillSequence2().add(soulContract);              // 30
        getSkillSequence2().add(readyToDie);                // 300
        getSkillSequence2().add(weaponJumpRing);            // 30

        preparationPhantom.setDelay(300L);
        readyToDie.setDelay(300L);

        bullsEye.setDelay(300L);
        mapleWorldGoddessBlessing.setDelay(330L);

        getStart().setTime(-25000);
        freudBlessing4.setActivateTime(new Timestamp(-30000));
        addSkillEvent(freudBlessing4);
        getStart().setTime(0);

        freudBlessing6.setCooldown(260.0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(freudBlessing1)
                            && freudStack == 6
                            && getStart().before(new Timestamp(7 * 60 * 1000))
            ) {
                addSkillEvent(freudBlessing1);
            } else if (
                    cooldownCheck(freudBlessing2)
                            && freudStack == 1
            ) {
                addSkillEvent(freudBlessing2);
            } else if (
                    cooldownCheck(freudBlessing3)
                            && freudStack == 2
            ) {
                addSkillEvent(freudBlessing3);
            } else if (
                    cooldownCheck(freudBlessing4)
                            && freudStack == 3
            ) {
                addSkillEvent(freudBlessing4);
            } else if (
                    cooldownCheck(freudBlessing6)
                            && freudStack == 5
                            && getStart().after(new Timestamp(freudBlessing6.getActivateTime().getTime() + 10000))
            ) {
                addSkillEvent(freudBlessing6);
            } else if (
                    cooldownCheck(bullsEye)
                            && cooldownCheck(markOfPhantom)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                chk30 = 2L;
                addSkillEvent(finalCutBuff);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                if (cooldownCheck(defyingFate)) {
                    while (!cooldownCheck(freudBlessing5)) {
                        addSkillEvent(ultimateDrive);
                    }
                    addSkillEvent(freudBlessing5);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(blackJackBeforeDelay);
                addSkillEvent(markOfPhantom);
                addSkillEvent(restraintRing);
                addSkillEvent(riftBreak);
                if (cooldownCheck(defyingFate)) {
                    addSkillEvent(defyingFate);
                    addSkillEvent(tempestOfCardBeforeDelay);
                    applyCooldown(tempestOfCardBeforeDelay);
                    while (!cooldownCheck(blackJackBeforeDelay)) {
                        addSkillEvent(ultimateDrive);
                    }
                    addSkillEvent(blackJackBeforeDelay);
                    addSkillEvent(jokerBeforeDelay);
                } else {
                    while (!cooldownCheck(jokerBeforeDelay)) {
                        addSkillEvent(ultimateDrive);
                    }
                    addSkillEvent(jokerBeforeDelay);
                    addSkillEvent(tempestOfCardBeforeDelay);
                    applyCooldown(tempestOfCardBeforeDelay);
                }
            } else if (
                    cooldownCheck(finalCutBuff)
                            && cooldownCheck(preparationPhantom)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(readyToDie)
                            && !cooldownCheck(heroesOath)
            ) {
                chk30 = 4L;
                addSkillEvent(finalCutBuff);
                addDealCycle(getSkillSequence2());
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(70 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                if (ringSwitching.getCooldown() == 90) {
                    ringSwitching.setCooldown(100.0);
                } else {
                    ringSwitching.setCooldown(90.0);
                }
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(laMortCarteBuff)
                    && !cooldownCheck(readyToDie)
            ) {
                addSkillEvent(laMortCarteBuff);
            } else if (
                    chk30 > 0
                            && cooldownCheck(markOfPhantom)
                            && getStart().before(new Timestamp(670 * 1000))
            ) {
                chk30 --;
                addSkillEvent(markOfPhantom);
                while (!cooldownCheck(riftBreak)) {
                    if (cooldownCheck(blackJackBeforeDelay)) {
                        addSkillEvent(blackJackBeforeDelay);
                    } else if (cooldownCheck(tempestOfCardBeforeDelay)) {
                        addSkillEvent(tempestOfCardBeforeDelay);
                        applyCooldown(tempestOfCardBeforeDelay);
                    } else {
                        addSkillEvent(ultimateDrive);
                    }
                }
                addSkillEvent(riftBreak);
                while (!cooldownCheck(roseCarteFinale)) {
                    if (cooldownCheck(blackJackBeforeDelay)) {
                        addSkillEvent(blackJackBeforeDelay);
                    } else if (cooldownCheck(tempestOfCardBeforeDelay)) {
                        addSkillEvent(tempestOfCardBeforeDelay);
                        applyCooldown(tempestOfCardBeforeDelay);
                    } else {
                        addSkillEvent(ultimateDrive);
                    }
                }
                addSkillEvent(roseCarteFinale);
            } else if (
                    cooldownCheck(blackJackBeforeDelay)
                    && getStart().before(new Timestamp(bullsEye.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(blackJackBeforeDelay);
            } else if (cooldownCheck(tempestOfCardBeforeDelay)) {
                addSkillEvent(tempestOfCardBeforeDelay);
                applyCooldown(tempestOfCardBeforeDelay);
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof FreudBlessing1) {
                freudStack = 1;
            } else if (skill instanceof FreudBlessing2) {
                freudStack = 2;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing1
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing3) {
                freudStack = 3;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing2
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing4) {
                freudStack = 4;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing3
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing5) {
                freudStack = 5;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing4
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            } else if (skill instanceof FreudBlessing6) {
                freudStack = 6;
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            getSkillEventList().get(i).getSkill() instanceof FreudBlessing5
                                    && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getStart().getTime());
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            }
            if (skill instanceof LaMortCarteBuff) {
                laMortCarteEndTime = new Timestamp(getStart().getTime() + 40000);
                laMortCarteCount = 80;
            } else if (skill instanceof LaMortCarteJokerBuff) {
                laMortCarteJokerEndTime = new Timestamp(getStart().getTime() + 40000);
                laMortCarteCount = 160;
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
            if (skill instanceof UltimateDrive) {
                if (cooldownCheck(noireCarteReverse)) {
                    addSkillEvent(noireCarteReverse);
                }
                if (laMortCarteCount > 0) {
                    if (getStart().before(laMortCarteEndTime)) {
                        addSkillEvent(laMortCarte);
                    } else if (getStart().before(laMortCarteJokerEndTime)) {
                        addSkillEvent(laMortCarteJoker);
                    }
                    laMortCarteCount --;
                }
            }
            if (skill instanceof JokerBeforeDelay) {
                addSkillEvent(laMortCarteJokerBuff);
                applyCooldown(laMortCarteBuff);
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
                        if (skill instanceof RoseCarteFinaleDot) {
                            Long ran = (long) (Math.random() * 2 + 1);
                            for (int cnt = 0; cnt < ran; cnt ++) {
                                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            }
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = 0;
                    if (skill instanceof BlackJack) {
                        i = 440;
                    } else {
                        i = ((AttackSkill) skill).getInterval();
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        Timestamp now = new Timestamp(getStart().getTime());
                        getStart().setTime(getStart().getTime() + i);
                        if (
                                skill instanceof Joker
                                        || skill instanceof TempestOfCard
                        ) {
                            if (cooldownCheck(noireCarteReverse)) {
                                addSkillEvent(noireCarteReverse);
                            }
                            if (laMortCarteCount > 0) {
                                if (getStart().before(laMortCarteEndTime)) {
                                    addSkillEvent(laMortCarte);
                                } else if (getStart().before(laMortCarteJokerEndTime)) {
                                    addSkillEvent(laMortCarteJoker);
                                }
                                laMortCarteCount --;
                            }
                        }
                        getStart().setTime(now.getTime());
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
        if (skill instanceof FreudBlessing1) {
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing1.getActivateTime().getTime()));
            freudBlessing1.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing2) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing2.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing3) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing3.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing4) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing4.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing5) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing6.setActivateTime(new Timestamp(freudBlessing5.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(getStart().getTime() + 240000));
        } else if (skill instanceof FreudBlessing6) {
            freudBlessing1.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing2.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing3.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing4.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
            freudBlessing5.setActivateTime(new Timestamp(freudBlessing6.getActivateTime().getTime()));
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
            boolean isLaMortCarte = false;
            for (SkillEvent se : useAttackSkillList) {
                if (
                        se.getSkill() instanceof LaMortCarte
                                || se.getSkill() instanceof LaMortCarteJoker
                ) {
                    isLaMortCarte = true;
                    break;
                }
            }
            if (isLaMortCarte) {
                for (SkillEvent se : useAttackSkillList) {
                    if (se.getSkill() instanceof NoireCarte) {
                        useAttackSkillList.remove(se);
                    }
                }
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
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

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Timestamp now = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    skill instanceof DefyingFate
                            || skill instanceof MarkOfPhantom
                            || skill instanceof MarkOfPhantomFinal
                            || skill instanceof RiftBreak
                            || skill instanceof RoseCarteFinale
            ) {
                if (cooldownCheck(noireCarteReverse)) {
                    addSkillEvent(noireCarteReverse);
                }
                if (laMortCarteCount > 0) {
                    if (getStart().before(laMortCarteEndTime)) {
                        addSkillEvent(laMortCarte);
                    } else if (getStart().before(laMortCarteJokerEndTime)) {
                        addSkillEvent(laMortCarteJoker);
                    }
                    laMortCarteCount --;
                }
            }
            getStart().setTime(now.getTime());
        }
    }
}
