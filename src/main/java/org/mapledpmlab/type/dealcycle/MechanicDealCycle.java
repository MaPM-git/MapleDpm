package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.mechanic.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.mechanic.BomberTime;
import org.mapledpmlab.type.skill.buffskill.mechanic.LuckyDiceMechanic;
import org.mapledpmlab.type.skill.buffskill.mechanic.SupportWaverHEX;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class MechanicDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 설치기
    private List<Skill> summonCycle = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DistortionField());
            add(new GroundZeroEarthquake());
            add(new HomingMissile());
            add(new MagneticField());
            add(new MagneticFieldDie());
            add(new MassiveFireIRONBExplosion());
            add(new MassiveFireIRONBHit());
            add(new MechaCarrier());
            add(new MetalArmorFullBurst());
            add(new MicroMissileContainer());
            add(new MultipleOptionMFLGatlingGun());
            add(new MultipleOptionMFLMissile());
            add(new ResistanceLineInfantry());
            add(new RobotFactoryRM1());
            add(new RobotFactoryRM1Die());
            add(new RobotLauncherRM7());
            add(new RobotLauncherRM7Die());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SupportWaverHEXDie());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new MagneticFieldSummon());
            add(new MechaCarrierSummon());
            add(new MetalArmorFullBurstBeforeDelay());
            add(new MultipleOptionMFLSummon());
            add(new ResistanceLineInfantryDelay());
            add(new RobotFactoryRM1Summon());
            add(new RobotLauncherRM7Summon());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BomberTime());
            add(new LuckyDiceMechanic());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(249L));
            add(new OverdriveDebuff(249L));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SupportWaverHEX());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WillOfLiberty());
        }
    };

    List<Timestamp> bomberTimeStartTime = new ArrayList<>();
    List<Timestamp> bomberTimeEndTime = new ArrayList<>();
    List<Timestamp> metarArmorFullBurstStartTime = new ArrayList<>();
    List<Timestamp> metarArmorFullBurstEndTime = new ArrayList<>();

    public MechanicDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        BomberTime bomberTime = new BomberTime();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DistortionField distortionField = new DistortionField();
        GroundZeroEarthquake groundZeroEarthquake = new GroundZeroEarthquake();
        HomingMissile homingMissile = new HomingMissile();
        LuckyDiceMechanic luckyDice = new LuckyDiceMechanic();
        MagneticFieldDie magneticFieldDie = new MagneticFieldDie();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MassiveFireIRONBHit massiveFireIRONBHit = new MassiveFireIRONBHit();
        MechaCarrierSummon mechaCarrierSummon = new MechaCarrierSummon();
        MetalArmorFullBurstBeforeDelay metalArmorFullBurstBeforeDelay = new MetalArmorFullBurstBeforeDelay();
        MicroMissileContainer microMissileContainer = new MicroMissileContainer();
        MultipleOptionMFLSummon multipleOptionMFLSummon = new MultipleOptionMFLSummon();
        Overdrive overdrive = new Overdrive(249L);
        PriorPreparation priorPreparation = new PriorPreparation();
        ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        RobotFactoryRM1Die robotFactoryRM1Die = new RobotFactoryRM1Die();
        RobotLauncherRM7Die robotLauncherRM7Die = new RobotLauncherRM7Die();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SupportWaverHEXDie supportWaverHEXDie = new SupportWaverHEXDie();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WillOfLiberty willOfLiberty = new WillOfLiberty();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += homingMissile.getInterval()) {
            getSkillEventList().add(new SkillEvent(homingMissile, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(95.0);

        summonCycle.add(supportWaverHEXDie);
        summonCycle.add(robotLauncherRM7Die);
        summonCycle.add(robotFactoryRM1Die);
        summonCycle.add(magneticFieldDie);

        dealCycle1.addAll(summonCycle);
        dealCycle1.add(multipleOptionMFLSummon);
        dealCycle1.add(mechaCarrierSummon);
        dealCycle1.add(willOfLiberty);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(overdrive);
        dealCycle1.add(resistanceLineInfantry);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(microMissileContainer);
        dealCycle1.add(bomberTime);
        dealCycle1.add(groundZeroEarthquake);
        dealCycle1.add(metalArmorFullBurstBeforeDelay);

        dealCycle2.addAll(summonCycle);
        dealCycle2.add(multipleOptionMFLSummon);
        dealCycle2.add(mechaCarrierSummon);
        dealCycle2.add(willOfLiberty);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(overdrive);
        dealCycle2.add(resistanceLineInfantry);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(microMissileContainer);
        dealCycle2.add(bomberTime);
        dealCycle2.add(metalArmorFullBurstBeforeDelay);

        dealCycle3.addAll(summonCycle);
        dealCycle3.add(overdrive);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(bomberTime);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);

        while (getStart().before(getEnd())) {
            if (cooldownCheck(luckyDice)) {
                luckyDice = new LuckyDiceMechanic();
                if (
                        luckyDice.getBuffDamage() >= 30
                        || luckyDice.getBuffAttMagic() >= 15
                ) {
                    luckyDice.setCooldown(180.0);
                }
                addSkillEvent(luckyDice);
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
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(microMissileContainer)
                    && !cooldownCheck(supportWaverHEXDie)
            ) {
                addSkillEvent(microMissileContainer);
            } else if (
                    cooldownCheck(distortionField)
            ) {
                addSkillEvent(distortionField);
            } else {
                addSkillEvent(massiveFireIRONBHit);
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
            if (skill instanceof BomberTime) {
                bomberTimeStartTime.add(new Timestamp(getStart().getTime()));
                bomberTimeEndTime.add(new Timestamp(getStart().getTime() + 10000));
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
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (skill instanceof MetalArmorFullBurstBeforeDelay) {
                metarArmorFullBurstStartTime.add(new Timestamp(getStart().getTime()));
                metarArmorFullBurstEndTime.add(new Timestamp(getStart().getTime() + 13120));
            }
            if (skill instanceof MechaCarrier) {
                for (long i = getStart().getTime(); i <= ((AttackSkill) skill).getDotDuration(); i += 2850) {
                    for (long j = 9; j <= 16; j++) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(i + j * 30), new Timestamp(i + j * 30)));
                        getEventTimeList().add(new Timestamp(i + j * 30));
                    }
                }
            } else if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                    ) {
                        remove.add(skillEvent);
                    }
                }
                this.getSkillEventList().removeAll(remove);
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
            }
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
        Long tmp = 11L;
        if (skillEvent.getSkill() instanceof HomingMissile) {
            tmp = ((HomingMissile) skillEvent.getSkill()).getAttackCount();
            for (int i = 0; i < bomberTimeEndTime.size(); i++) {
                if (start.after(bomberTimeStartTime.get(i)) && end.before(bomberTimeEndTime.get(i))) {
                    ((HomingMissile) skillEvent.getSkill()).setAttackCount(((HomingMissile) skillEvent.getSkill()).getAttackCount() + 6);
                }
            }
            for (int i = 0; i < metarArmorFullBurstStartTime.size(); i++) {
                if (start.after(metarArmorFullBurstStartTime.get(i)) && end.before(metarArmorFullBurstEndTime.get(i))) {
                    ((HomingMissile) skillEvent.getSkill()).setAttackCount(((HomingMissile) skillEvent.getSkill()).getAttackCount() + 7);
                    ((HomingMissile) skillEvent.getSkill()).addFinalDamage(1.67);
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                attackDamage = (long) Math.floor(((getJob().getFinalMainStat() + buffSkill.getBuffMainStat()) * 4
                        + getJob().getFinalSubstat() + buffSkill.getBuffSubStat()) * 0.01
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
                        * (1 - 3 * (1 - buffSkill.getIgnoreDefense()) * (1 - getJob().getIgnoreDefense()) * (1 - getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
                );
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
                }
                Long distance = end.getTime() - start.getTime();
                if (as.getMultiAttackInfo().size() == 0 && as.getInterval() == 0 && as.getDelay() != 0 && distance != 0) {
                    attackDamage = attackDamage / as.getDelay() * distance;
                }
                as.setCumulativeDamage(as.getCumulativeDamage() + attackDamage);
                break;
            }
        }
        if (skillEvent.getSkill() instanceof HomingMissile) {
            ((HomingMissile) skillEvent.getSkill()).setAttackCount(tmp);
            ((HomingMissile) skillEvent.getSkill()).setFinalDamage(2.2);
        }
        return attackDamage;
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
