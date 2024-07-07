package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.angelicbuster.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.angelicbuster.*;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AngelicBusterDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CheeringBalloon());
            add(new CheeringBalloonExaltation());
            add(new CheeringBalloonFinale());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EnergyBurst());
            add(new GrandFinale());
            add(new GrandFinaleFinish());
            add(new MascotFamiliarBeforeDelay());
            add(new MascotFamiliar());
            add(new MascotFamiliarEnd());
            add(new SoulSeeker());
            add(new SoulSeekerExaltation());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new Spotlight());
            add(new SuperNova());
            add(new Trinity());
            add(new TrinityFusion());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new FinalContract());
            add(new GrandisGoddessBlessingNova());
            add(new LoadedDice());
            add(new Overdrive(255L));
            add(new OverdriveDebuff(255L));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContractAB());
            add(new SoulExaltation());
            add(new SpotlightBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    SoulSeeker soulSeeker = new SoulSeeker();

    Timestamp grandFinaleBuffEndTime = new Timestamp(-1);
    Timestamp soulExaltationEndTime = new Timestamp(-1);

    public AngelicBusterDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        EnergyBurst energyBurst = new EnergyBurst();
        FinalContract finalContract = new FinalContract();
        GrandisGoddessBlessingNova grandisGoddessBlessingNova = new GrandisGoddessBlessingNova();
        GrandFinale grandFinale = new GrandFinale();
        LoadedDice loadedDice = new LoadedDice();
        MascotFamiliarBeforeDelay mascotFamiliarBeforeDelay = new MascotFamiliarBeforeDelay();
        Overdrive overdrive = new Overdrive(255L);
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContractAB soulContractAB = new SoulContractAB();
        SoulExaltation soulExaltation = new SoulExaltation();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpotlightBuff spotlight = new SpotlightBuff();
        SuperNova superNova = new SuperNova();
        Trinity trinity = new Trinity();
        TrinityFusion trinityFusion = new TrinityFusion();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        ringSwitching.setCooldown(130.0);

        grandisGoddessBlessingNova.setCooldown(240.0);

        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(loadedDice)) {
                addSkillEvent(loadedDice);
            }
            if (
                    cooldownCheck(finalContract)
                    && cooldownCheck(spotlight)
                    && cooldownCheck(overdrive)
                    && cooldownCheck(soulExaltation)
                    && cooldownCheck(soulContractAB)
                    && cooldownCheck(superNova)
                    && cooldownCheck(energyBurst)
                    && cooldownCheck(mascotFamiliarBeforeDelay)
                    && getStart().after(new Timestamp(trinityFusion.getActivateTime().getTime() - 2500))
            ) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                if (
                        cooldownCheck(grandisGoddessBlessingNova)
                ) {
                    if (getStart().before(new Timestamp(60 * 1000))) {
                        grandisGoddessBlessingNova.setCooldown(360.0);
                    } else if (getStart().after(new Timestamp(470 * 1000))) {
                        grandisGoddessBlessingNova.setCooldown(240.0);
                    } else if (getStart().after(new Timestamp(350 * 1000))) {
                        grandisGoddessBlessingNova.setCooldown(120.0);
                    }
                    addSkillEvent(grandisGoddessBlessingNova);
                }
                addSkillEvent(finalContract);
                addSkillEvent(spotlight);
                addSkillEvent(overdrive);
                addSkillEvent(soulExaltation);
                addSkillEvent(soulContractAB);
                addSkillEvent(superNova);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(trinity);
                addSkillEvent(trinityFusion);
                if (cooldownCheck(grandFinale)) {
                    addSkillEvent(grandFinale);
                }
                addSkillEvent(energyBurst);
                addSkillEvent(mascotFamiliarBeforeDelay);
            } else if (
                    cooldownCheck(overdrive)
                    && cooldownCheck(soulExaltation)
                    && cooldownCheck(soulContractAB)
                    && cooldownCheck(superNova)
                    && cooldownCheck(mascotFamiliarBeforeDelay)
                    && !cooldownCheck(finalContract)
            ) {
                addSkillEvent(overdrive);
                addSkillEvent(soulExaltation);
                addSkillEvent(soulContractAB);
                addSkillEvent(superNova);
                addSkillEvent(mascotFamiliarBeforeDelay);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else {
                addSkillEvent(trinity);
                if (cooldownCheck(trinityFusion)) {
                    addSkillEvent(trinityFusion);
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
            if (skill instanceof GrandFinaleBuff) {
                grandFinaleBuffEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof SoulExaltation) {
                soulExaltationEndTime = new Timestamp(getStart().getTime() + 20000);
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
            if (
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
            } else {
                if (skill instanceof OverdriveDebuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 28000), new Timestamp(getStart().getTime() + (long) (applyCooldownReduction(skill) * 1000))));
                } else {
                    endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                if (
                        !(
                                skill instanceof SoulSeeker
                                || skill instanceof CheeringBalloon
                                || skill instanceof CheeringBalloonFinale
                                || skill instanceof CheeringBalloonExaltation
                        )
                ) {
                    for (SkillEvent skillEvent : this.getSkillEventList()) {
                        if (
                                skillEvent.getStart().after(getStart())
                                && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                        ) {
                            remove.add(skillEvent);
                        }
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
                    boolean recharge1 = true;
                    boolean recharge2 = true;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof Spotlight) {
                        i = 1500;
                    }
                    if (
                            skill instanceof SoulSeeker
                            || skill instanceof CheeringBalloon
                            || skill instanceof CheeringBalloonExaltation
                            || skill instanceof CheeringBalloonFinale
                            || skill instanceof SoulSeekerExaltation
                    ) {
                        i = 510;
                    }
                    if (
                            skill instanceof SoulSeeker
                            && getStart().before(grandFinaleBuffEndTime)
                            && getStart().before(soulExaltationEndTime)
                    ) {
                        skill = new CheeringBalloonExaltation();
                    } else if (
                            skill instanceof SoulSeeker
                            && getStart().before(grandFinaleBuffEndTime)
                    ) {
                        skill = new CheeringBalloon();
                    } else if (
                            skill instanceof SoulSeeker
                            && getStart().before(soulExaltationEndTime)
                    ) {
                        skill = new SoulSeekerExaltation();
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (!recharge1 && attackCount % 2 == 1) {
                            continue;
                        }
                        if (!recharge2 && attackCount % 2 == 0) {
                            continue;
                        }
                        if (skill instanceof Spotlight && attackCount % 3 != 0) {
                            Spotlight spotlight = new Spotlight();
                            spotlight.addFinalDamage(0.25);
                            getSkillEventList().add(new SkillEvent(spotlight, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        } else {
                            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        }
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                        if (skill instanceof SuperNova) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (getStart().before(soulExaltationEndTime)) {
                                ran -= 15;
                            }
                            if (ran <= 36) {
                                getStart().setTime(getStart().getTime() + i);
                                addSkillEvent(soulSeeker);
                                getStart().setTime(getStart().getTime() - i);
                            }
                        }
                        if (
                                skill instanceof SoulSeeker
                                || skill instanceof CheeringBalloon
                        ) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (getStart().before(soulExaltationEndTime)) {
                                ran -= 5;
                            }
                            if (ran > 95) {
                                if (attackCount % 2 == 1) {
                                    recharge1 = false;
                                } else {
                                    recharge2 = false;
                                }
                            }
                        }
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
        if (skill instanceof Trinity) {
            Long ran = (long) (Math.random() * 99 + 1);
            if (getStart().before(soulExaltationEndTime)) {
                ran -= 15;
            }
            if (ran <= 51) {
                addSkillEvent(soulSeeker);
            }
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    skill instanceof TrinityFusion
                    || skill instanceof GrandFinale
                    || skill instanceof GrandFinaleFinish
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (getStart().before(soulExaltationEndTime)) {
                    ran -= 15;
                }
                if (ran <= 36) {
                    getStart().setTime(getStart().getTime() + sum);
                    addSkillEvent(soulSeeker);
                    getStart().setTime(getStart().getTime() - sum);
                }
            }
        }
    }

    @Override
    public List<SkillEvent> getOverlappingSkillEvents(Timestamp start, Timestamp end) {
        List<SkillEvent> overlappingSkillEvents = new ArrayList<>();
        for (SkillEvent skillEvent : getSkillEventList()) {
            if (
                    (skillEvent.getStart().before(end) && skillEvent.getEnd().after(start))
                    || (skillEvent.getStart().equals(start) && skillEvent.getStart().equals(skillEvent.getEnd()))
            ) {
                overlappingSkillEvents.add(skillEvent);
            }
        }
        boolean isOverdrive = false;
        for (SkillEvent skillEvent : overlappingSkillEvents) {
            if (skillEvent.getSkill() instanceof Overdrive) {
                isOverdrive = true;
                break;
            }
        }
        if (isOverdrive) {
            for (int i = 0; i < overlappingSkillEvents.size(); i++) {
                if (overlappingSkillEvents.get(i).getSkill() instanceof OverdriveDebuff) {
                    overlappingSkillEvents.remove(i);
                }
            }
        }
        return overlappingSkillEvents;
    }
}
