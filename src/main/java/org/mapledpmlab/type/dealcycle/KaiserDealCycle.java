package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DracoSlasher());
            add(new DracoSlasherEnergy());
            add(new DracoSlasherFF());
            add(new DracoSlasherEnergyFF());
            add(new DragonBlaze());
            add(new DragonBlazeEnergy());
            add(new DragonBlazeFireOrb());
            add(new DragonSlash());
            add(new GigaSlasher());
            add(new GigaSlasherFF());
            add(new GuardianOfNova());
            add(new GuardianOfNova6th());
            add(new GuardianOfNova15th());
            add(new GuardianOfNova27th());
            add(new InfernoBreath());
            add(new InfernoBreathDot());
            add(new MightOfNova());
            add(new MightOfNovaFinish());
            add(new Petrified());
            add(new Prominence());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new WallOfSword());
            add(new WallOfSwordDragonBlow());
            add(new WallOfSwordStrike());
            add(new WallOfSwordStrikeBlaze());
            add(new WingBeat());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new FinalFiguration());
            add(new FinalTrance());
            add(new GrandisGoddessBlessingNova());
            add(new MajestyOfKaiser());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
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

    List<Timestamp> wingBeatTime = new ArrayList<>();

    DracoSlasher dracoSlasher = new DracoSlasher();
    DracoSlasherFF dracoSlasherFF = new DracoSlasherFF();
    GigaSlasher gigaSlasher = new GigaSlasher();
    GigaSlasherFF gigaSlasherFF = new GigaSlasherFF();

    BuffSkill regainStrength = new BuffSkill();

    int gauge = 700;

    public KaiserDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DragonBlaze dragonBlaze = new DragonBlaze();
        DragonSlash dragonSlash = new DragonSlash();
        FinalFiguration finalFiguration = new FinalFiguration();
        FinalTrance finalTrance = new FinalTrance();
        GrandisGoddessBlessingNova grandisGoddessBlessingNova = new GrandisGoddessBlessingNova();
        GuardianOfNova guardianOfNova = new GuardianOfNova();
        MightOfNova mightOfNova = new MightOfNova();
        Petrified petrified = new Petrified();
        Prominence prominence = new Prominence();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        WallOfSwordStrike wallOfSwordStrike = new WallOfSwordStrike();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WingBeat wingBeat = new WingBeat();

        ringSwitching.setCooldown(130.0);
        auraWeaponBuff.setCooldown(180.0);
        auraWeaponBuff.setApplyCooldownReduction(false);
        grandisGoddessBlessingNova.setCooldown(240.0);

        soulContract.setApplyReuse(true);
        for (Skill skill : buffSkillList) {
            if (skill instanceof SoulContract) {
                skill.setApplyReuse(true);
                break;
            }
        }

        regainStrength.setDuration(720L);
        regainStrength.setBuffFinalDamage(1.15);
        regainStrength.setName("리게인 스트렝스");
        addSkillEvent(regainStrength);

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(finalFigurationEndTime)
                    && cooldownCheck(finalTrance)
            ) {
                addSkillEvent(finalTrance);
            }
            if (
                    getStart().after(finalFigurationEndTime)
                    && cooldownCheck(majestyOfKaiser)
                    && gauge <= 300
            ) {
                if (cooldownCheck(wallOfSword)) {
                    addSkillEvent(wallOfSword);
                }
                if (cooldownCheck(infernoBreath)) {
                    addSkillEvent(infernoBreath);
                }
                addSkillEvent(majestyOfKaiser);
                addSkillEvent(wallOfSword);
                addSkillEvent(infernoBreath);
            }
            if (
                    getStart().after(finalFigurationEndTime)
                    && gauge >= 700
            ) {
                addSkillEvent(finalFiguration);
            }
            if (
                    cooldownCheck(auraWeaponBuff)
                    && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(petrified)
                    && cooldownCheck(infernoBreath)
                    && cooldownCheck(guardianOfNova)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(dragonBlaze)
                    && cooldownCheck(dracoSlasher)
                    && cooldownCheck(prominence)
                    && cooldownCheck(wallOfSwordStrike)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && getStart().before(new Timestamp(finalFigurationEndTime.getTime() - 5000))
                    && cooldownCheck(bodyOfSteel)
            ) {
                //addSkillEvent(petrified);
                addSkillEvent(bodyOfSteel);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                /*addSkillEvent(infernoBreath);
                addSkillEvent(dragonSlash);
                addSkillEvent(wingBeat);
                addSkillEvent(wingBeat);*/
                addSkillEvent(guardianOfNova);
                if (cooldownCheck(grandisGoddessBlessingNova)) {
                    if (dealCycleOrder == 1) {
                        grandisGoddessBlessingNova.setCooldown(360.0);
                    } else if (dealCycleOrder == 4) {
                        grandisGoddessBlessingNova.setCooldown(120.0);
                    } else {
                        grandisGoddessBlessingNova.setCooldown(240.0);
                    }
                    addSkillEvent(grandisGoddessBlessingNova);
                }
                addSkillEvent(soulContract);
                addSkillEvent(dragonBlaze);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(dracoSlasher);
                addSkillEvent(prominence);
                addSkillEvent(wallOfSwordStrike);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
                if (cooldownCheck(mightOfNova)) {
                    addSkillEvent(mightOfNova);
                    addSkillEvent(dracoSlasher);
                }
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(100 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 50000))
                    && getStart().after(soulContractEndTime)
            ) {
                addSkillEvent(soulContract);
            } /*else if (
                    cooldownCheck(petrified)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(petrified);
            }*/ else if (
                    cooldownCheck(prominence)
                    && cooldownCheck(wallOfSwordStrike)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(dracoSlasher);
                addSkillEvent(prominence);
                addSkillEvent(wallOfSwordStrike);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
            } else if (
                    cooldownCheck(wallOfSwordStrike)
                    && (
                            getStart().before(new Timestamp(prominence.getActivateTime().getTime() - 20000))
                            || (
                                    getStart().after(new Timestamp(660 * 1000))
                                    && getStart().before(new Timestamp(700 * 1000))
                            )
                    )
            ) {
                addSkillEvent(dracoSlasher);
                addSkillEvent(wallOfSwordStrike);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
                addSkillEvent(dracoSlasher);
            } else if (
                    cooldownCheck(infernoBreath)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 15000))
                    && getStart().after(finalFigurationEndTime)
            ) {
                addSkillEvent(infernoBreath);
            } else if (
                    cooldownCheck(dragonSlash)
                    && getStart().before(new Timestamp(guardianOfNova.getActivateTime().getTime() - 15000))
                    && getStart().after(finalFigurationEndTime)
            ) {
                addSkillEvent(dragonSlash);
                addSkillEvent(wingBeat);
                addSkillEvent(wingBeat);
            } else if (cooldownCheck(wallOfSword)) {
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
        if (wingBeatTime.size() > 0) {
            for (int i = 0; i < wingBeatTime.size(); i++) {
                if (wingBeatTime.get(i).before(getStart())) {
                    wingBeatTime.remove(i);
                    i--;
                    gauge += 1;
                }
            }
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof FinalFiguration) {
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
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                if (skill instanceof SoulContract) {
                    soulContractEndTime = new Timestamp(endTime.getTime());
                }
                if (skill instanceof FinalFiguration) {
                    finalFigurationEndTime = new Timestamp(endTime.getTime());
                }
            } else {
                if (skill instanceof BodyOfSteel) {
                    for (long i = 0; i < 18000; i += 1000) {
                        getSkillEventList().add(new SkillEvent(new BodyOfSteel(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 1000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
                    }
                }
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                if (skill instanceof FinalTrance) {
                    finalFigurationEndTime = new Timestamp(endTime.getTime());
                }
            }
        } else {
            if (
                    skill instanceof GigaSlasher
                    && getStart().before(finalFigurationEndTime)
            ) {
                skill = gigaSlasherFF;
            }
            if (
                    skill instanceof DracoSlasher
                    && getStart().before(finalFigurationEndTime)
            ) {
                skill = dracoSlasherFF;
            }
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
            } else if (
                    skill instanceof WallOfSword
                    && dragonBlowChk
            ) {
                addSkillEvent(wallOfSwordDragonBlow);
                dragonBlowChk = false;
            }
            if (skill instanceof WallOfSwordStrike) {
                dracoSlasher.setActivateTime(new Timestamp(-1));
                dracoSlasherFF.setActivateTime(new Timestamp(-1));
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
                    || skill instanceof GigaSlasherFF
                    || skill instanceof DracoSlasherFF
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
                        if (skill instanceof WingBeat) {
                            wingBeatTime.add(new Timestamp(getStart().getTime() + i));
                        }
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
        if (skill instanceof DracoSlasherFF) {
            dracoSlasher.setActivateTime(dracoSlasherFF.getActivateTime());
        } else if (skill instanceof DracoSlasher) {
            dracoSlasherFF.setActivateTime(dracoSlasher.getActivateTime());
        } else if (skill instanceof WallOfSwordStrike) {
            wallOfSword.setActivateTime(new Timestamp(getStart().getTime() + 3000));
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
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= getJob().getReuse()) {
                    if (skill instanceof WallOfSword) {
                        skill.setActivateTime(new Timestamp(getStart().getTime() + 3000));
                    }
                    return;
                } else  {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            }
            if (
                    skill.isApplyReuse()
                            && getStart().before(grandisGoddessBlessingEndTime)
                            && reuseCnt > 0
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 55) {
                    if (skill instanceof WallOfSword) {
                        skill.setActivateTime(new Timestamp(getStart().getTime() + 3000));
                    }
                    reuseCnt--;
                } else  {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            } else {
                if (
                        strikeCnt > 0
                        && (
                                skill instanceof DracoSlasher
                                || skill instanceof DracoSlasherFF
                        )
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
            if (isFinalFiguration) {
                regainStrength.setBuffFinalDamage(1.25);
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
            isFinalFiguration = false;
            regainStrength.setBuffFinalDamage(1.15);
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
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
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
        if (isFinalFiguration) {
            if (attackSkill instanceof WallOfSword) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            } else if (attackSkill instanceof WallOfSwordDragonBlow) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            } else if (attackSkill instanceof WallOfSwordStrike) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            } else if (attackSkill instanceof WallOfSwordStrikeBlaze) {
                attackSkill.setAttackCount(attackSkill.getAttackCount() - 1);
            }
        }
        return attackDamage;
    }
}
