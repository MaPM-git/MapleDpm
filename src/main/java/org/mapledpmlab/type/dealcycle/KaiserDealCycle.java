package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.kaiser.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.kaiser.FinalFiguration;
import org.mapledpmlab.type.skill.buffskill.kaiser.FinalTrance;
import org.mapledpmlab.type.skill.buffskill.kaiser.MajestyOfKaiser;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class KaiserDealCycle extends DealCycle {
    private final List<Skill> dealCycle1 = new ArrayList<>();

    private final List<Skill> dealCycle2 = new ArrayList<>();

    private final List<Skill> dealCycle3 = new ArrayList<>();

    private final List<Skill> dealCycle4 = new ArrayList<>();

    private final List<Skill> dealCycle5 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DracoSlasher());
            add(new DracoSlasherEnergy());
            add(new DragonBlaze());
            add(new DragonBlazeEnergy());
            add(new DragonBlazeFireOrb());
            add(new DragonSlash());
            add(new GigaSlasher());
            add(new GuardianOfNova6th());
            add(new GuardianOfNova15th());
            add(new GuardianOfNova27th());
            add(new InfernoBreath());
            add(new InfernoBreathDot());
            add(new MightOfNova());
            add(new MightOfNovaFinish());
            add(new Petrified());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new WallOfSword());
            add(new WallOfSwordDragonBlow());
            add(new WallOfSwordStrike());
            add(new WallOfSwordStrikeBlaze());
            add(new WingBeat());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new GuardianOfNova());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new FinalFiguration());
            add(new FinalTrance());
            add(new GrandisGoddessBlessingNova());
            add(new MajestyOfKaiser());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    DragonBlazeEnergy dragonBlazeEnergy = new DragonBlazeEnergy();
    DragonBlazeFireOrb dragonBlazeFireOrb = new DragonBlazeFireOrb();
    InfernoBreath infernoBreath = new InfernoBreath();
    MajestyOfKaiser majestyOfKaiser = new MajestyOfKaiser();
    SoulContract soulContract = new SoulContract();
    WallOfSword wallOfSword = new WallOfSword();
    WallOfSwordDragonBlow wallOfSwordDragonBlow = new WallOfSwordDragonBlow();

    boolean dragonBlowChk = false;
    boolean isFinalFiguration = false;

    int reuseCnt = 0;
    int strikeCnt = 0;

    Timestamp dragonBlazeEndTime = new Timestamp(-1);
    Timestamp finalFigurationEndTime = new Timestamp(-1);
    Timestamp grandisGoddessBlessingEndTime = new Timestamp(-1);
    Timestamp soulContractEndTime = new Timestamp(-1);

    int gauge = 700;

    public KaiserDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DracoSlasher dracoSlasher = new DracoSlasher();
        DragonBlaze dragonBlaze = new DragonBlaze();
        DragonSlash dragonSlash = new DragonSlash();
        FinalFiguration finalFiguration = new FinalFiguration();
        FinalTrance finalTrance = new FinalTrance();
        GigaSlasher gigaSlasher = new GigaSlasher();
        GrandisGoddessBlessingNova grandisGoddessBlessingNova = new GrandisGoddessBlessingNova();
        GuardianOfNova guardianOfNova = new GuardianOfNova();
        MightOfNova mightOfNova = new MightOfNova();
        Petrified petrified = new Petrified();
        Prominence prominence = new Prominence();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        WallOfSwordStrike wallOfSwordStrike = new WallOfSwordStrike();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WingBeat wingBeat = new WingBeat();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);

        // 리레, 그여축, 6차
        dealCycle1.add(petrified);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(infernoBreath);
        dealCycle1.add(dragonSlash);
        dealCycle1.add(wingBeat);
        dealCycle1.add(wingBeat);
        dealCycle1.add(guardianOfNova);
        dealCycle1.add(grandisGoddessBlessingNova);
        dealCycle1.add(soulContract);
        dealCycle1.add(dragonBlaze);
        dealCycle1.add(restraintRing);
        dealCycle1.add(dracoSlasher);
        dealCycle1.add(mightOfNova);
        dealCycle1.add(dracoSlasher);
        dealCycle1.add(prominence);
        dealCycle1.add(wallOfSwordStrike);

        // 웨퍼, 그여축, 6차
        dealCycle2.add(petrified);
        dealCycle2.add(infernoBreath);
        dealCycle2.add(dragonSlash);
        dealCycle2.add(wingBeat);
        dealCycle2.add(wingBeat);
        dealCycle2.add(guardianOfNova);
        dealCycle2.add(grandisGoddessBlessingNova);
        dealCycle2.add(soulContract);
        dealCycle2.add(dragonBlaze);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(dracoSlasher);
        dealCycle2.add(mightOfNova);
        dealCycle2.add(dracoSlasher);
        dealCycle2.add(prominence);
        dealCycle2.add(wallOfSwordStrike);

        // 리레, 그여축
        dealCycle3.add(petrified);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(infernoBreath);
        dealCycle3.add(dragonSlash);
        dealCycle3.add(wingBeat);
        dealCycle3.add(wingBeat);
        dealCycle3.add(guardianOfNova);
        dealCycle3.add(grandisGoddessBlessingNova);
        dealCycle3.add(soulContract);
        dealCycle3.add(dragonBlaze);
        dealCycle3.add(restraintRing);
        dealCycle3.add(dracoSlasher);
        dealCycle3.add(prominence);
        dealCycle3.add(wallOfSwordStrike);

        // 웨퍼
        dealCycle4.add(petrified);
        dealCycle4.add(infernoBreath);
        dealCycle4.add(dragonSlash);
        dealCycle4.add(wingBeat);
        dealCycle4.add(wingBeat);
        dealCycle4.add(guardianOfNova);
        dealCycle4.add(soulContract);
        dealCycle4.add(majestyOfKaiser);
        dealCycle4.add(dragonBlaze);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(dracoSlasher);
        dealCycle4.add(prominence);
        dealCycle4.add(wallOfSwordStrike);

        soulContract.setApplyReuse(true);
        grandisGoddessBlessingNova.addBuffDamage(33L);

        // 그여축 1345 1-4-3-2-3-4
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(finalFigurationEndTime)
                    && gauge >= 700
            ) {
                addSkillEvent(finalFiguration);
            }
            if (
                    getStart().after(finalFigurationEndTime)
                    && gauge <= 200
                    && cooldownCheck(finalTrance)
            ) {
                addSkillEvent(finalTrance);
            }
            if (
                    getStart().after(auraWeaponBuff.getEndTime())
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                auraWeaponBuff.setEndTime(new Timestamp(getStart().getTime() + auraWeaponBuff.getDuration() * 1000));
                addSkillEvent(auraWeaponBuff);
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
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (dealCycleOrder == 3 || dealCycleOrder == 5)
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
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 60000))
                    && getStart().after(soulContractEndTime)
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(petrified)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(petrified);
            } else if (
                    cooldownCheck(prominence)
                    && cooldownCheck(wallOfSwordStrike)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(prominence);
                addSkillEvent(wallOfSwordStrike);
            } else if (
                    cooldownCheck(wallOfSwordStrike)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 20000))
            ) {
                addSkillEvent(wallOfSwordStrike);
            } else if (
                    cooldownCheck(infernoBreath)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 15000))
                    && getStart().after(finalFigurationEndTime)
            ) {
                addSkillEvent(infernoBreath);
            } else if (
                    cooldownCheck(dragonSlash)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 15000))
            ) {
                addSkillEvent(dragonSlash);
                addSkillEvent(wingBeat);
                addSkillEvent(wingBeat);
            } else if (
                    cooldownCheck(wallOfSword)
            ) {
                addSkillEvent(wallOfSword);
            } else {
                if (cooldownCheck(dracoSlasher)) {
                    addSkillEvent(dracoSlasher);
                } else {
                    addSkillEvent(gigaSlasher);
                }
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
            if (skill instanceof FinalFiguration || skill instanceof FinalTrance) {
                gauge = 0;
            }
            if (skill instanceof MajestyOfKaiser) {
                infernoBreath.setActivateTime(new Timestamp(-1));
                soulContract.setActivateTime(new Timestamp(-1));
                wallOfSword.setActivateTime(new Timestamp(-1));
            }
            if (skill instanceof GrandisGoddessBlessingNova) {
                reuseCnt = 6;
                grandisGoddessBlessingEndTime = new Timestamp(getStart().getTime() + 40000);
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
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                if (skill instanceof SoulContract) {
                    soulContractEndTime = new Timestamp(endTime.getTime());
                }
                if (skill instanceof FinalFiguration) {
                    finalFigurationEndTime = new Timestamp(endTime.getTime());
                }
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                if (skill instanceof FinalTrance) {
                    finalFigurationEndTime = new Timestamp(endTime.getTime());
                }
            }
        } else {
            if (skill instanceof MightOfNova) {
                finalFigurationEndTime = new Timestamp(finalFigurationEndTime.getTime() + 10000);
                for (int i = getSkillEventList().size() - 1; i >= 0; i--) {
                    if (
                            (
                                    getSkillEventList().get(i).getSkill() instanceof FinalFiguration
                                    || getSkillEventList().get(i).getSkill() instanceof FinalTrance
                            )
                            && getSkillEventList().get(i).getEnd().after(getStart())
                    ) {
                        getSkillEventList().get(i).getEnd().setTime(getSkillEventList().get(i).getEnd().getTime() + 10000);
                        getEventTimeList().add(getSkillEventList().get(i).getEnd());
                    }
                }
            }
            if (
                    skill instanceof WingBeat
                    && getStart().after(finalFigurationEndTime)
            ) {
                gauge += 15;
            }
            if (
                    skill instanceof GigaSlasher
                    && getStart().after(finalFigurationEndTime)
            ) {
                gauge += 5;
            }
            if (
                    skill instanceof DracoSlasher
                    && getStart().after(finalFigurationEndTime)
            ) {
                gauge += 5;
            }
            if (
                    skill instanceof InfernoBreath
                    && getStart().after(finalFigurationEndTime)
            ) {
                gauge += 40;
            }
            if (
                    skill instanceof Prominence
                    && getStart().after(finalFigurationEndTime)
            ) {
                gauge += 50;
            }
            if (
                    skill instanceof WallOfSword
                    && getStart().after(finalFigurationEndTime)
            ) {
                gauge += 60;
            }
            if (
                    skill instanceof DragonBlaze
            ) {
                dragonBlazeEndTime = new Timestamp(getStart().getTime() + 20000);
            }
            if (
                    skill instanceof WallOfSword
                    && !dragonBlowChk
            ) {
                dragonBlowChk = true;
            }
            if (skill instanceof WallOfSwordStrike) {
                strikeCnt = 3;
            }
            if (
                    skill instanceof GigaSlasher
                    || skill instanceof InfernoBreath
                    || skill instanceof InfernoBreathDot
                    || skill instanceof DragonSlash
                    || skill instanceof WallOfSword
                    || skill instanceof WallOfSwordDragonBlow
                    || skill instanceof DracoSlasher
                    || skill instanceof WallOfSwordStrike
                    || skill instanceof WallOfSwordStrikeBlaze
                    || skill instanceof MightOfNova
                    || skill instanceof MightOfNovaFinish
            ) {
                if (getStart().before(dragonBlazeEndTime)) {
                    if (cooldownCheck(dragonBlazeEnergy)) {
                        addSkillEvent(dragonBlazeEnergy);
                    }
                } else {
                    if (cooldownCheck(dragonBlazeFireOrb)) {
                        addSkillEvent(dragonBlazeFireOrb);
                    }
                }
            }
            if (
                    skill instanceof WallOfSword
                    && dragonBlowChk
            ) {
                addSkillEvent(wallOfSwordDragonBlow);
                dragonBlowChk = false;
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                            && !(skill instanceof WingBeat)
                    ) {
                        remove.add(skillEvent);
                    }
                }
                getSkillEventList().removeAll(remove);
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new KaiserSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), gauge));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new KaiserSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), gauge));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new KaiserSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, gauge));
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

    @Override
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (
                        getStart().before(grandisGoddessBlessingEndTime)
                        && reuseCnt > 0
                ) {
                    ran -= 55;
                }
                if (ran <= getJob().getReuse()) {
                    if (skill instanceof WallOfSword) {
                        skill.setActivateTime(new Timestamp(getStart().getTime() + 3000));
                    }
                    reuseCnt--;
                } else  {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                    if (skill instanceof SoulContract) {
                        addSkillEvent(majestyOfKaiser);
                    }
                }
            } else {
                if (
                        skill instanceof DracoSlasher
                        && strikeCnt > 0
                ) {
                    strikeCnt--;
                } else {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            }
            if (!skill.isApplyCooldownReduction()) {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + skill.getCooldown() * 1000)));
            }
        }
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new KaiserSkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), gauge));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
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
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isGradisGoddessBlessing = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof GrandisGoddessBlessingNova) {
                    isGradisGoddessBlessing = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof FinalFiguration) {
                    isFinalFiguration = true;
                    break;
                }
            }
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof FinalTrance) {
                    isFinalFiguration = true;
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
                if (isFinalFiguration) {
                    buffSkill.addBuffDamage(9L);
                } else if (
                        ((KaiserSkillEvent) se).getGauge() >= 700
                ) {
                    buffSkill.addBuffDamage(9L);
                } else if (
                        ((KaiserSkillEvent) se).getGauge() >= 300
                ) {
                    buffSkill.addBuffDamage(6L);
                } else if (
                        ((KaiserSkillEvent) se).getGauge() >= 100
                ) {
                    buffSkill.addBuffDamage(3L);
                }
                if (isGradisGoddessBlessing) {
                    if (
                            ((KaiserSkillEvent) se).getGauge() >= 700
                    ) {
                        buffSkill.addBuffDamage(33L);
                    } else if (
                            ((KaiserSkillEvent) se).getGauge() >= 300
                    ) {
                        buffSkill.addBuffDamage(22L);
                    } else if (
                            ((KaiserSkillEvent) se).getGauge() >= 100
                    ) {
                        buffSkill.addBuffDamage(11L);
                    }
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
                if (isFinalFiguration) {
                    buffSkill.addBuffDamage(-9L);
                } else if (
                        ((KaiserSkillEvent) se).getGauge() >= 700
                ) {
                    buffSkill.addBuffDamage(-9L);
                } else if (
                        ((KaiserSkillEvent) se).getGauge() >= 300
                ) {
                    buffSkill.addBuffDamage(-6L);
                } else if (
                        ((KaiserSkillEvent) se).getGauge() >= 100
                ) {
                    buffSkill.addBuffDamage(-3L);
                }
                if (isGradisGoddessBlessing) {
                    if (
                            ((KaiserSkillEvent) se).getGauge() >= 700
                    ) {
                        buffSkill.addBuffDamage(-33L);
                    } else if (
                            ((KaiserSkillEvent) se).getGauge() >= 300
                    ) {
                        buffSkill.addBuffDamage(-22L);
                    } else if (
                            ((KaiserSkillEvent) se).getGauge() >= 100
                    ) {
                        buffSkill.addBuffDamage(-11L);
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
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        if (isFinalFiguration) {
            if (attackSkill instanceof WallOfSword) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() + 1);
            } else if (attackSkill instanceof WallOfSwordDragonBlow) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() + 1);
            } else if (attackSkill instanceof GigaSlasher) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() + 2);
            } else if (attackSkill instanceof DracoSlasher) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() + 2);
            } else if (attackSkill instanceof WallOfSwordStrike) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() + 1);
            } else if (attackSkill instanceof WallOfSwordStrikeBlaze) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() + 1);
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                        + getJob().getFinalSubstat()) * 0.01
                        * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                        * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                        + getJob().getPerXAtt())
                        * getJob().getConstant()
                        * (1 + (getJob().getDamage() + getJob().getBossDamage() + getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                        * (getJob().getFinalDamage())
                        * buffSkill.getBuffFinalDamage()
                        * getJob().getStatXFinalDamage()
                        * attackSkill.getFinalDamage()
                        * getJob().getMastery()
                        * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                        * (1 + 0.35 + (getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                        * (1 - 0.5 * (1 - (getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                        * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - getJob().getIgnoreDefense()) * (1 - getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
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
        if (isFinalFiguration) {
            if (attackSkill instanceof WallOfSword) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            } else if (attackSkill instanceof WallOfSwordDragonBlow) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            } else if (attackSkill instanceof GigaSlasher) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 2);
            } else if (attackSkill instanceof DracoSlasher) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 2);
            } else if (attackSkill instanceof WallOfSwordStrike) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            } else if (attackSkill instanceof WallOfSwordStrikeBlaze) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            }
        }
        return attackDamage;
    }
}
