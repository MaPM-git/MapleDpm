package org.mapledpmlab.type.dealcyclesolo;

import lombok.NoArgsConstructor;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
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

@NoArgsConstructor
public class MechanicContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DistortionField());
            add(new DistortionFieldIntense());
            add(new DistortionFieldIntenseBomb());
            add(new GroundZeroBombardment());
            add(new GroundZeroEarthquake());
            add(new GroundZeroExplosion());
            add(new HomingMissile());
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
            add(new RobotTransitionCBP1());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SupportWaverHEXDie());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BomberTime());
            add(new ContinuousRing());
            add(new LuckyDiceMechanic());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(249L));
            add(new OverdriveDebuff(249L));
            add(new SoulContract());
            add(new SupportWaverHEX());
            add(new WillOfLiberty());
        }
    };

    boolean isNuke = false;

    List<Timestamp> bomberTimeStartTime = new ArrayList<>();
    List<Timestamp> bomberTimeEndTime = new ArrayList<>();
    List<Timestamp> metarArmorFullBurstStartTime = new ArrayList<>();
    List<Timestamp> metarArmorFullBurstEndTime = new ArrayList<>();

    BomberTime bomberTime = new BomberTime();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DistortionField distortionField = new DistortionField();
    DistortionFieldIntenseBomb distortionFieldIntenseBomb = new DistortionFieldIntenseBomb();
    GroundZeroEarthquake groundZeroEarthquake = new GroundZeroEarthquake();
    HomingMissile homingMissile = new HomingMissile();
    LuckyDiceMechanic luckyDice = new LuckyDiceMechanic();
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
    RobotTransitionCBP1 robotTransitionCBP1 = new RobotTransitionCBP1();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SupportWaverHEXDie supportWaverHEXDie = new SupportWaverHEXDie();
    WillOfLiberty willOfLiberty = new WillOfLiberty();

    public MechanicContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        for (int i = 0; i < 720 * 1000; i += homingMissile.getInterval()) {
            getSkillEventList().add(new SkillEvent(homingMissile, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ((AttackSkill) groundZeroEarthquake.getRelatedSkill().getRelatedSkill()).setDotDuration(((AttackSkill) groundZeroEarthquake.getRelatedSkill().getRelatedSkill()).getDotDuration() + 3000);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        luckyDice.setDelay(660L);
        addSkillEvent(luckyDice);

        /*
        시퀀스 1 ->캐리어, 리버티, 메여축 3개
        시퀀스 2-> 옵드, 엔버, 시드링 3개
        이런식으로 따로 둬서 해요

        멀티플 -> 시퀀스 1 -> 마미컨 -> 시퀀스 2 -> 호밍누른채로 그라운드제로 -> 전탄누르고 봄버누르기
        */
        getSkillSequence1().add(mechaCarrierSummon);
        getSkillSequence1().add(willOfLiberty);             // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);

        getSkillSequence2().add(overdrive);                 // 420
        getSkillSequence2().add(soulContract);              // 30

        getSkillSequence3().add(overdrive);                 // 420
        getSkillSequence3().add(soulContract);              // 30

        mechaCarrierSummon.setDelay(330L);
        mapleWorldGoddessBlessing.setDelay(300L);
    }

    @Override
    public void setSoloDealCycle() {
        addSkillEvent(robotTransitionCBP1);
        while (getStart().before(getEnd())) {
            if (cooldownCheck(luckyDice)) {
                luckyDice = new LuckyDiceMechanic();
                luckyDice.setDelay(660L);
                if (
                        luckyDice.getBuffDamage() >= 30
                                || luckyDice.getBuffAttMagic() >= 15
                ) {
                    luckyDice.setCooldown(180.0);
                }
                addSkillEvent(luckyDice);
            }
            if (
                    cooldownCheck(multipleOptionMFLSummon)
                            && getStart().before(new Timestamp(600 * 1000))
                            && getStart().after(new Timestamp(microMissileContainer.getActivateTime().getTime() - 5000))
            ) {
                isNuke = true;
                supportWaverHEXDie.setActivateTime(new Timestamp(-1));
                addSkillEvent(supportWaverHEXDie);
                addSkillEvent(multipleOptionMFLSummon);
                addDealCycle(getSkillSequence1());
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                while (!cooldownCheck(resistanceLineInfantry)) {
                    addSkillEvent(massiveFireIRONBHit);
                }
                addSkillEvent(resistanceLineInfantry);
                addSkillEvent(distortionField);
                addSkillEvent(microMissileContainer);
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
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
                isNuke = false;
            } else if (
                    cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(bomberTime)
                            && getStart().after(new Timestamp(60 * 1000))
                            && getStart().before(new Timestamp(willOfLiberty.getActivateTime().getTime() - 30000))
            ) {
                addSkillEvent(overdrive);
                addSkillEvent(soulContract);
                addSkillEvent(bomberTime);
            } else if (
                    cooldownCheck(resistanceLineInfantry)
                            && (
                            !cooldownCheck(overdrive)
                                    || getStart().after(new Timestamp(660 * 1000))
                                    || getStart().before(new Timestamp(1000))
                    )
            ) {
                addSkillEvent(resistanceLineInfantry);
                addSkillEvent(distortionField);
                addSkillEvent(microMissileContainer);
            } else if (
                    cooldownCheck(distortionField)
                    && getStart().before(new Timestamp(distortionFieldIntenseBomb.getActivateTime().getTime() - 3000))
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
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
                    skill instanceof SoulContract
                    && restraintRingStartTime == null
                    && restraintRingEndTime == null
                    && fortyEndTime == null
                    && isNuke
            ) {
                restraintRingStartTime = new Timestamp(getStart().getTime());
                restraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
                fortyEndTime = new Timestamp(getStart().getTime() + 40000);
            } else if (
                    skill instanceof SoulContract
                            && restraintRingStartTime != null
                            && restraintRingEndTime != null
                            && fortyEndTime != null
                            && originXRestraintRingStartTime == null
                            && originXRestraintRingEndTime == null
                            && isNuke
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
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof DistortionField
                            || skill instanceof DistortionFieldIntense
                            || skill instanceof MassiveFireIRONBHit
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof DistortionField
                    && cooldownCheck(distortionFieldIntenseBomb)
            ) {
                skill = distortionFieldIntenseBomb;
            }
            if (skill instanceof MultipleOptionMFLSummon) {
                int cnt = 0;
                for (long i = getStart().getTime() + 3150; i < getStart().getTime() + 100000; i += 1530) {
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
                long j = 11;
                for (long i = getStart().getTime() + 2430; i <= getStart().getTime() + ((AttackSkill) skill).getDotDuration(); i += 3990) {
                    for (long k = 0; k < j; k++) {
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
                        if (skill instanceof MetalArmorFullBurst) {
                            Timestamp now = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
                            }
                            getStart().setTime(now.getTime());
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
        if (skill instanceof DistortionFieldIntenseBomb) {
            applyCooldown(distortionField);
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
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    skill instanceof GroundZeroEarthquake
                    || skill instanceof GroundZeroExplosion
            ) {
                Timestamp now = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                getStart().setTime(now.getTime());
            }
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
