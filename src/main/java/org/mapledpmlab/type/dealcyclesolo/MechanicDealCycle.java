package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DistortionField());
            add(new GroundZeroBombardment());
            add(new GroundZeroEarthquake());
            add(new GroundZeroExplosion());
            add(new HomingMissile());
            add(new MagneticFieldSummon());
            add(new MagneticField());
            add(new MagneticFieldDie());
            add(new MassiveFireIRONBExplosion());
            add(new MassiveFireIRONBHit());
            add(new MechaCarrierSummon());
            add(new MechaCarrier());
            add(new MetalArmorFullBurstBeforeDelay());
            add(new MetalArmorFullBurst());
            add(new MicroMissileContainer());
            add(new MultipleOptionMFLSummon());
            add(new MultipleOptionMFLGatlingGun());
            add(new MultipleOptionMFLMissile());
            add(new ResistanceLineInfantryDelay());
            add(new ResistanceLineInfantry());
            add(new RobotFactoryRM1Summon());
            add(new RobotFactoryRM1());
            add(new RobotFactoryRM1Die());
            add(new RobotLauncherRM7Summon());
            add(new RobotLauncherRM7());
            add(new RobotLauncherRM7Die());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SupportWaverHEXDie());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BomberTime());
            add(new LuckyDiceMechanic());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(249L));
            add(new OverdriveDebuff(249L));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SupportWaverHEX());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WillOfLiberty());
        }
    };

    List<Timestamp> bomberTimeStartTime = new ArrayList<>();
    List<Timestamp> bomberTimeEndTime = new ArrayList<>();
    List<Timestamp> metarArmorFullBurstStartTime = new ArrayList<>();
    List<Timestamp> metarArmorFullBurstEndTime = new ArrayList<>();

    BomberTime bomberTime = new BomberTime();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DistortionField distortionField = new DistortionField();
    GroundZeroEarthquake groundZeroEarthquake = new GroundZeroEarthquake();
    HomingMissile homingMissile = new HomingMissile();
    LuckyDiceMechanic luckyDice = new LuckyDiceMechanic();
    MagneticFieldDie magneticFieldDie = new MagneticFieldDie();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MassiveFireIRONBHit massiveFireIRONBHit = new MassiveFireIRONBHit();
    MechaCarrierSummon mechaCarrierSummon = new MechaCarrierSummon();
    MetalArmorFullBurstBeforeDelay metalArmorFullBurstBeforeDelay = new MetalArmorFullBurstBeforeDelay();
    MicroMissileContainer microMissileContainer = new MicroMissileContainer();
    MultipleOptionMFLGatlingGun multipleOptionMFLGatlingGun = new MultipleOptionMFLGatlingGun();
    MultipleOptionMFLMissile multipleOptionMFLMissile = new MultipleOptionMFLMissile();
    MultipleOptionMFLSummon multipleOptionMFLSummon = new MultipleOptionMFLSummon();
    Overdrive overdrive = new Overdrive(249L);
    ResistanceLineInfantry resistanceLineInfantry = new ResistanceLineInfantry();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    RobotFactoryRM1Die robotFactoryRM1Die = new RobotFactoryRM1Die();
    RobotLauncherRM7Die robotLauncherRM7Die = new RobotLauncherRM7Die();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SupportWaverHEXDie supportWaverHEXDie = new SupportWaverHEXDie();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    WillOfLiberty willOfLiberty = new WillOfLiberty();

    public MechanicDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        for (int i = 0; i < 720 * 1000; i += homingMissile.getInterval()) {
            getSkillEventList().add(new SkillEvent(homingMissile, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ((AttackSkill) groundZeroEarthquake.getRelatedSkill().getRelatedSkill()).setDotDuration(((AttackSkill) groundZeroEarthquake.getRelatedSkill().getRelatedSkill()).getDotDuration() + 3000);

        ringSwitching.setCooldown(95.0);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);

        mapleWorldGoddessBlessing.setCooldown(180.0);
    }

    @Override
    public void setSoloDealCycle() {
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
            if (cooldownCheck(distortionField)) {
                addSkillEvent(distortionField);
            }
            if (cooldownCheck(resistanceLineInfantry)) {
                addSkillEvent(resistanceLineInfantry);
            }
            if (
                    cooldownCheck(multipleOptionMFLSummon)
                            && getStart().before(new Timestamp(600 * 1000))
                            && getStart().after(new Timestamp(microMissileContainer.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(supportWaverHEXDie);
                addSkillEvent(robotLauncherRM7Die);
                addSkillEvent(robotFactoryRM1Die);
                addSkillEvent(magneticFieldDie);
                addSkillEvent(multipleOptionMFLSummon);
                addSkillEvent(mechaCarrierSummon);
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(willOfLiberty);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(massiveFireIRONBHit);
                }
                addSkillEvent(microMissileContainer);
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                if (cooldownCheck(groundZeroEarthquake)) {
                    addSkillEvent(groundZeroEarthquake);
                }
                addSkillEvent(bomberTime);
                while (!cooldownCheck(metalArmorFullBurstBeforeDelay)) {
                    if (cooldownCheck(distortionField)) {
                        addSkillEvent(distortionField);
                    } else {
                        addSkillEvent(massiveFireIRONBHit);
                    }
                }
                addSkillEvent(metalArmorFullBurstBeforeDelay);
            } else if (
                    cooldownCheck(supportWaverHEXDie)
                            && cooldownCheck(robotLauncherRM7Die)
                            && cooldownCheck(robotFactoryRM1Die)
                            && cooldownCheck(magneticFieldDie)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(weaponJumpRing)
                            && cooldownCheck(bomberTime)
                            && getStart().after(new Timestamp(60 * 1000))
            ) {
                addSkillEvent(supportWaverHEXDie);
                addSkillEvent(robotLauncherRM7Die);
                addSkillEvent(robotFactoryRM1Die);
                addSkillEvent(magneticFieldDie);
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(bomberTime);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(supportWaverHEXDie)
                            && getStart().after(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(supportWaverHEXDie);
                addSkillEvent(robotLauncherRM7Die);
                addSkillEvent(robotFactoryRM1Die);
                addSkillEvent(magneticFieldDie);
            } else if (
                    cooldownCheck(microMissileContainer)
                            && (
                            !cooldownCheck(mapleWorldGoddessBlessing)
                                    || getStart().after(new Timestamp(660 * 1000))
                                    || getStart().before(new Timestamp(1000))
                    )
            ) {
                addSkillEvent(microMissileContainer);
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof BomberTime) {
                bomberTimeStartTime.add(new Timestamp(getStart().getTime()));
                bomberTimeEndTime.add(new Timestamp(getStart().getTime() + 13000));
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
                if (skill instanceof OverdriveDebuff) {
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + 31000), new Timestamp(getStart().getTime() + (long) (applyCooldownReduction(skill) * 1000))));
                } else {
                    endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                    if (skill.isApplyServerLag()) {
                        endTime = new Timestamp(endTime.getTime() + 3000);
                    }
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            }
        } else {
            if (skill instanceof MultipleOptionMFLSummon) {
                int cnt = 0;
                for (long i = getStart().getTime() + 3150; i < getStart().getTime() + 135000; i += 1530) {
                    if (cnt % 8 == 0 || cnt % 8 == 1 || cnt % 8 == 2) {
                        getSkillEventList().add(new SkillEvent(multipleOptionMFLMissile, new Timestamp(i), new Timestamp(i)));
                        getEventTimeList().add(new Timestamp(i));
                    } else {
                        getSkillEventList().add(new SkillEvent(multipleOptionMFLGatlingGun, new Timestamp(i), new Timestamp(i)));
                        getEventTimeList().add(new Timestamp(i));
                    }
                    cnt ++;
                }
            }
            if (skill instanceof MetalArmorFullBurstBeforeDelay) {
                metarArmorFullBurstStartTime.add(new Timestamp(getStart().getTime()));
                metarArmorFullBurstEndTime.add(new Timestamp(getStart().getTime() + 9870));
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(new Timestamp(getStart().getTime() + 9870))
                            && skillEvent.getStart().before(new Timestamp(getStart().getTime() + 9870 + 2000))
                            && skillEvent.getSkill() instanceof HomingMissile
                    ) {
                        remove.add(skillEvent);
                    }
                }
                this.getSkillEventList().removeAll(remove);
            }
            if (skill instanceof MechaCarrier) {
                long j = 9;
                for (long i = getStart().getTime() + 2430; i <= getStart().getTime() + ((AttackSkill) skill).getDotDuration(); i += 3600) {
                    for (long k = 0; k <= j; k++) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(i + k * 30), new Timestamp(i + k * 30)));
                        getEventTimeList().add(new Timestamp(i + k * 30));
                    }
                    j++;
                    if (j > 16) {
                        j = 16;
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof MicroMissileContainer) {
                        i = 1440;
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
                        bs.setUseCount(bs.getUseCount() + 1);
                        bs.getStartTimeList().add(skillEvent.getStart());
                        bs.getEndTimeList().add(skillEvent.getEnd());
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
        if (skillEvent.getSkill() instanceof HomingMissile) {
            for (int i = 0; i < bomberTimeEndTime.size(); i++) {
                if (start.after(bomberTimeStartTime.get(i)) && end.before(bomberTimeEndTime.get(i))) {
                    attackSkill.setAttackCount(attackSkill.getAttackCount() + 6);
                }
            }
            for (int i = 0; i < metarArmorFullBurstStartTime.size(); i++) {
                if (start.after(metarArmorFullBurstStartTime.get(i)) && end.before(metarArmorFullBurstEndTime.get(i))) {
                    attackSkill.setAttackCount(attackSkill.getAttackCount() + 7);
                    attackSkill.addFinalDamage(1.67);
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
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
                            * (1 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
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
        if (skillEvent.getSkill() instanceof HomingMissile) {
            attackSkill.setAttackCount(12L);
            attackSkill.setFinalDamage(2.2);
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
