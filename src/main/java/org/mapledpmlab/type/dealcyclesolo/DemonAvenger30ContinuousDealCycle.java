package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.JobContinuous.DemonAvengerContinuous;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.demonavenger.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.ContinuousRing;
import org.mapledpmlab.type.skill.buffskill.common.SoulContract;
import org.mapledpmlab.type.skill.buffskill.demonavenger.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DemonAvenger30ContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new ArmorBreak());
            add(new BloodFeast());
            add(new CrestOfTheSolarDA());
            add(new CrestOfTheSolarDot());
            add(new DemonFrenzy30());
            add(new DimensionSwordDelay());
            add(new DimensionSword());
            add(new ExceedExecution1());
            add(new ExceedExecution2());
            add(new ExceedExecution3());
            add(new ExceedExecution4());
            add(new ExceedExecution5());
            add(new FinalAttackDemonAvenger());
            add(new MastemaClaw());
            add(new OtherWorldVoid());
            add(new Requiem());
            add(new RequiemDemonSword());
            add(new RoarOfDemonSword());
            add(new ShieldChasing());
            add(new ShieldChasingAfterSecond());
            add(new SpiderInMirrorDA());
            add(new SpiderInMirrorDot());
            add(new ThornOfFury());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ArmorBreakDebuff());
            add(new AuraWeaponBuffDA());
            add(new BodyOfSteelDA(0L));
            add(new CallMastemaDA());
            add(new ContinuousRing());
            add(new DemonicFortitudeDA());
            add(new ForbiddenContract());
            add(new OtherWorldGoddessBlessingDA());
            add(new ReleaseOverload());
            add(new Revenant());
            add(new SoulContract());
        }
    };

    int maxHP = 500000;
    int hp = 150000;
    int maxExceed = 18;
    int exceed = 18;
    int demonFrenzyAttackCnt = 0;
    int demonFrenzyHpReduceCnt = 0;
    int furyStorage = 0;

    Double thornOfFuryCooldown = 0.0;

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp releaseOverloadTime = new Timestamp(-1);
    Timestamp revenantEndTime = new Timestamp(-1);

    List<Timestamp> hpTime = new ArrayList<>();

    boolean isNuke = false;

    ArmorBreak armorBreak = new ArmorBreak();
    AuraWeaponBuffDA auraWeaponBuff = new AuraWeaponBuffDA();
    BloodFeast bloodFeast = new BloodFeast();
    BodyOfSteelDA bodyOfSteel = new BodyOfSteelDA(0L);
    CallMastemaDA callMastema = new CallMastemaDA();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolarDA crestOfTheSolar = new CrestOfTheSolarDA();
    DemonFrenzy30 demonFrenzy30 = new DemonFrenzy30();
    DemonFrenzyBuff tmpDemonFrenzyBuff = new DemonFrenzyBuff();
    DemonicFortitudeDA demonicFortitudeDA = new DemonicFortitudeDA();
    DimensionSwordDelay dimensionSword = new DimensionSwordDelay();
    ExceedExecution3 exceedExecution3 = new ExceedExecution3();
    ExceedExecution4 exceedExecution4 = new ExceedExecution4();
    ExceedExecution5 exceedExecution5 = new ExceedExecution5();
    ForbiddenContract forbiddenContract = new ForbiddenContract();
    OtherWorldGoddessBlessingDA otherWorldGoddessBlessing = new OtherWorldGoddessBlessingDA();
    ReleaseOverload releaseOverload = new ReleaseOverload();
    Requiem requiem = new Requiem();
    Revenant revenant = new Revenant();
    RoarOfDemonSword roarOfDemonSword = new RoarOfDemonSword();
    ShieldChasing shieldChasing = new ShieldChasing();
    SoulContract soulContract = new SoulContract();
    SpiderInMirrorDA spiderInMirror = new SpiderInMirrorDA();
    ThornOfFury thornOfFury = new ThornOfFury();

    public DemonAvenger30ContinuousDealCycle(Job job) {
        super(job, new FinalAttackDemonAvenger());

        getJob().setName("데몬 어벤져(30, 컨티)");
        //demonFrenzy30.setCooldown(0.21);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        addSkillEvent(releaseOverload);
        addSkillEvent(exceedExecution3);
        addSkillEvent(exceedExecution4);
        exceed = 11;

        auraWeaponBuff.setCooldown(180.0);
        auraWeaponBuff.setApplyCooldownReduction(false);
        otherWorldGoddessBlessing.setCooldown(120.0);
    }

    @Override
    public void setSoloDealCycle() {
        // 펫이 자동으로 사용(딜레이 X)
        // 270초마다 쓸샾(5%), 쓸뻥(5%), 쓸컴뱃(5%), 쓸어블(5%) 사용
        // 180초마다 리프랙트 이블(900), 디아볼릭 리커버리(900) 사용
        int dealCycleOrder = 1;
        Timestamp buffEndTime1 = new Timestamp(270 * 1000);
        Timestamp buffEndTime2 = new Timestamp(183 * 1000);
        Timestamp diabolicRecoveryTime = new Timestamp(5500);

        Timestamp roarOfDemonSwordTime = new Timestamp(-1);
        int roarOfDemonSwordChk = 0;

        while (getStart().before(getEnd())) {
            if (hp < 0) {
                hp = 1;
            }
            if (getStart().after(buffEndTime1)) {
                hp -= maxHP * 0.15;
                buffEndTime1 = new Timestamp(getStart().getTime() + 270 * 1000);
                if (getStart().before(revenantEndTime)) {
                    furyStorage += maxHP * 0.2;
                    if (furyStorage >= 300000) {
                        furyStorage = 300000;
                    }
                    thornOfFury.setCooldownByFury(furyStorage);
                    if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                        thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                        thornOfFuryCooldown = thornOfFury.getCooldown();
                    }
                }
            }
            if (getStart().after(buffEndTime2)) {
                hp -= 1800;
                buffEndTime2 = new Timestamp(getStart().getTime() + 183 * 1000);
                if (getStart().before(revenantEndTime)) {
                    furyStorage += 1800;
                    if (furyStorage >= 300000) {
                        furyStorage = 300000;
                    }
                    thornOfFury.setCooldownByFury(furyStorage);
                    if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                        thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                        thornOfFuryCooldown = thornOfFury.getCooldown();
                    }
                }
            }
            if (getStart().after(diabolicRecoveryTime)) {
                hp += maxHP * 0.05;
                diabolicRecoveryTime = new Timestamp(getStart().getTime() + 5500);
            }
            if (
                    cooldownCheck(auraWeaponBuff)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(demonicFortitudeDA)
                            && cooldownCheck(callMastema)
                            && cooldownCheck(otherWorldGoddessBlessing)
                            && cooldownCheck(revenant)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(dimensionSword)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
                            && getStart().after(new Timestamp(spiderInMirror.getActivateTime().getTime() - 110000))
            ) {
                isNuke = true;
                addSkillEvent(armorBreak);
                addSkillEvent(demonicFortitudeDA);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(exceedExecution5);
                }
                addSkillEvent(callMastema);
                addSkillEvent(bodyOfSteel);
                addSkillEvent(forbiddenContract);
                addSkillEvent(otherWorldGoddessBlessing);
                addSkillEvent(revenant);
                addSkillEvent(soulContract);
                if (cooldownCheck(requiem)) {
                    addSkillEvent(requiem);
                    roarOfDemonSwordTime = new Timestamp(getStart().getTime() + 14000);
                    roarOfDemonSwordChk = 1;
                }
                addSkillEvent(dimensionSword);
                dealCycleOrder ++;
                isNuke = false;
            } else if (
                    getStart().after(roarOfDemonSwordTime)
                            && roarOfDemonSwordChk == 1
            ) {
                addSkillEvent(roarOfDemonSword);
                roarOfDemonSwordChk = 0;
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(demonicFortitudeDA.getActivateTime().getTime() - 50000))
            ) {
                addSkillEvent(armorBreak);
                addSkillEvent(soulContract);
            } else if (
                    getStart().after(releaseOverloadTime)
            ) {
                addSkillEvent(releaseOverload);
                exceed = 9;
            } else if (cooldownCheck(bloodFeast)) {
                addSkillEvent(bloodFeast);
            } else if (cooldownCheck(shieldChasing)) {
                addSkillEvent(shieldChasing);
            } else {
                if (exceed == 9) {
                    addSkillEvent(exceedExecution3);
                } else if (exceed == 10) {
                    addSkillEvent(exceedExecution4);
                } else {
                    addSkillEvent(exceedExecution5);
                }
                if (exceed < 18) {
                    exceed++;
                }
            }
        }
        sortEventTimeList();
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\tHP : " + hp + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\tHP : " + hp + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        int j = 0;
        if (hpTime.size() > 0) {
            for (int i = 0; i < hpTime.size(); i++) {
                if (hpTime.get(i).before(getStart())) {
                    hpTime.remove(i);
                    i--;
                    hp += 500000 * 0.0133;
                    if (hp > 500000) {
                        hp = 500000;
                    }
                }
            }
        }
        if (skill instanceof Revenant) {
            revenantEndTime = new Timestamp(getStart().getTime() + 18000);
            furyStorage = 0;
        }
        while (demonFrenzyAttackCnt < getStart().getTime() / 240) {
            getSkillEventList().add(new DemonAvengerSkillEvent(demonFrenzy30, new Timestamp(getStart().getTime() + j), new Timestamp(getStart().getTime() + j), (long) this.hp));
            getEventTimeList().add(new Timestamp(getStart().getTime() + j));
            j++;
            demonFrenzyAttackCnt++;
            hp += 500000 * 0.02;
            if (hp > 500000) {
                hp = 500000;
            }
        }
        while (demonFrenzyHpReduceCnt < getStart().getTime() / 1000) {
            if (hp > 150000) {
                hp -= 6000;
                demonFrenzyHpReduceCnt++;
                if (getStart().before(revenantEndTime)) {
                    furyStorage += 6000;
                    if (furyStorage >= 300000) {
                        furyStorage = 300000;
                    }
                    thornOfFury.setCooldownByFury(furyStorage);
                }
            }
            demonFrenzyHpReduceCnt++;
        }
        if (skill instanceof GaugeAttackSkill) {
            hp += ((GaugeAttackSkill) skill).getGaugeCharge();
            hp += maxHP * ((GaugeAttackSkill) skill).getGaugePer() * 0.01;
            if (getStart().before(revenantEndTime)) {
                if (((GaugeAttackSkill) skill).getGaugeCharge() < 0) {
                    furyStorage -= ((GaugeAttackSkill) skill).getGaugeCharge();
                }
                if (((GaugeAttackSkill) skill).getGaugePer() < 0) {
                    furyStorage -= maxHP * ((GaugeAttackSkill) skill).getGaugePer() * 0.01;
                }
                if (furyStorage >= 300000) {
                    furyStorage = 300000;
                }
                thornOfFury.setCooldownByFury(furyStorage);
                if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                    thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                    thornOfFuryCooldown = thornOfFury.getCooldown();
                }
            }
        } else if (skill instanceof GaugeBuffSkill) {
            hp += ((GaugeBuffSkill) skill).getGaugeCharge();
            hp += maxHP * ((GaugeBuffSkill) skill).getGaugePer() * 0.01;
            if (getStart().before(revenantEndTime)) {
                if (((GaugeBuffSkill) skill).getGaugeCharge() < 0) {
                    furyStorage -= ((GaugeBuffSkill) skill).getGaugeCharge();
                }
                if (((GaugeBuffSkill) skill).getGaugePer() < 0) {
                    furyStorage -= maxHP * ((GaugeBuffSkill) skill).getGaugePer() * 0.01;
                }
                if (furyStorage >= 300000) {
                    furyStorage = 300000;
                }
                thornOfFury.setCooldownByFury(furyStorage);
                if (thornOfFuryCooldown > thornOfFury.getCooldown()) {
                    thornOfFury.setActivateTimeByFury(thornOfFuryCooldown);
                    thornOfFuryCooldown = thornOfFury.getCooldown();
                }
            }
        }
        if (hp > 500000) {
            hp = 500000;
        }
        if (hp < 1) {
            hp = 150000;
        }
        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (skill instanceof ReleaseOverload) {
                releaseOverloadTime = new Timestamp(getStart().getTime() + 178500);
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
                getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, (long) this.hp));
            } else {
                if (skill instanceof BodyOfSteelDA) {
                    for (long i = 0; i < 21000; i += 1000) {
                        getSkillEventList().add(new SkillEvent(new BodyOfSteelDA(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 1000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
                    }
                }
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, (long) this.hp));
            }
        } else {
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrestOfTheSolarDA
                            || skill instanceof SpiderInMirrorDA
                            || skill instanceof ArmorBreak
                            || skill instanceof BloodFeast
                            || skill instanceof DimensionSword
                            || skill instanceof ExceedExecution1
                            || skill instanceof ExceedExecution2
                            || skill instanceof ExceedExecution3
                            || skill instanceof ExceedExecution4
                            || skill instanceof ExceedExecution5
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (skill instanceof ShieldChasingAfterSecond) {
                        break;
                    }
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
                        if (skill instanceof OtherWorldVoid) {
                            Long ran = 0L;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran >= 75) {
                                hpTime.add(new Timestamp(getStart().getTime() + i));
                                continue;
                            } else if (ran >= 25) {
                                continue;
                            }
                        }
                        getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.hp));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                skill instanceof ShieldChasingAfterSecond
                                || skill instanceof DimensionSword
                        ) {
                            hpTime.add(new Timestamp(getStart().getTime() + i));
                        }
                        getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i), (long) this.hp));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        attackCount += 1;
                    }
                }
                this.setStart(tmp);
            } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                this.multiAttackProcess(skill);
            } else {
                endTime = new Timestamp(getStart().getTime() + skill.getDelay());
                getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime()), endTime, (long) this.hp));
                if (
                        (
                                skill instanceof ExceedExecution1
                                || skill instanceof ExceedExecution2
                                || skill instanceof ExceedExecution3
                                || skill instanceof ExceedExecution4
                                || skill instanceof ExceedExecution5
                        )
                        && getStart().before(revenantEndTime)
                        && cooldownCheck(thornOfFury)
                ) {
                    getSkillEventList().add(new DemonAvengerSkillEvent(thornOfFury, endTime, endTime, (long) this.hp));
                    applyCooldown(thornOfFury);
                }
                hp += 500000 * 0.02;
                if (hp > 500000) {
                    hp = 500000;
                }
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
                buffSkill.addBuffSubStat(((BuffSkill) skillEvent.getSkill()).getBuffSubStat());
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new DemonAvengerSkillEvent(getFinalAttack(), start, end, ((DemonAvengerSkillEvent) se).getCurrentHp()), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public Long getDotDamage(AttackSkill attackSkill, BuffSkill buffSkill) {
        Long attackDamage;
        attackDamage = (long) Math.floor(((((DemonAvengerContinuous) getJob()).getFinalHp())// * 4
                + ((DemonAvengerContinuous) getJob()).getStr()) * 0.01
                * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                + getJob().getPerXAtt())
                * getJob().getConstant()
                        * (1 + (
                        getJob().getDamage()
                                + getJob().getBossDamage()
                                + getJob().getStatXDamage()
                                + buffSkill.getBuffDamage()
                                + attackSkill.getAddDamage()
                                - 310
                                - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01)
                ) * 0.01)
                * getJob().getMastery()
                * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
        );
        return attackDamage;
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        tmpDemonFrenzyBuff.setFinalDamageByHp(((DemonAvengerSkillEvent) skillEvent).getCurrentHp());
        buffSkill.addBuffFinalDamage(tmpDemonFrenzyBuff.getBuffFinalDamage());
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
                    attackDamage = (long) Math.floor(((((DemonAvengerContinuous) getJob()).getFinalHp()) //* 4
                            + ((DemonAvengerContinuous) getJob()).getStr()) * 0.01
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
        buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / tmpDemonFrenzyBuff.getBuffFinalDamage());
        return attackDamage;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new DemonAvengerSkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum), (long) this.hp));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    !(skill instanceof Requiem)
                    && !(skill instanceof RequiemDemonSword)
            ) {
                hp += 500000 * 0.02;
                if (hp > 500000) {
                    hp = 500000;
                }
            }
            Timestamp now = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof Requiem
                            || skill instanceof RoarOfDemonSword
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            getStart().setTime(now.getTime());
        }
    }

    @Override
    public void getJobInfo() {
        System.out.println("-------------------");
        System.out.println("직업 : " + getJob().getName());
        System.out.println("기본 주스탯 수치 : " + getJob().getHp());
        System.out.println("주스탯 % 수치 : " + (getJob().getMainStatP() + getJob().getAllStatP()));
        System.out.println("% 미적용 주스탯 수치 : " + getJob().getPerXMainStat());
        System.out.println("기본 부스탯 수치 : " + getJob().getSubStat());
        System.out.println("부스탯 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXSubStat());
        System.out.println("기본 스공 : " + getJob().getStatDamage());
        System.out.println("데미지 : " + getJob().getDamage());
        System.out.println("최종데미지 : " + getJob().getFinalDamage());
        System.out.println("보스 데미지 : " + getJob().getBossDamage());
        System.out.println("방어율 무시 : " + getJob().getIgnoreDefense());
        System.out.println("크리티컬 확률 : " + getJob().getCriticalP());
        System.out.println("장비 공격력 % : " + getJob().getAttP());
        System.out.println("장비 마력 % : " + getJob().getMagicP());
        System.out.println("크리티컬 데미지 : " + getJob().getCriticalDamage());
        System.out.println("쿨타임 감소 초 : " + getJob().getCooldownReductionSec());
        System.out.println("쿨타임 감소 % : " + getJob().getCooldownReductionP());
        System.out.println("버프 지속 시간 : " + getJob().getPlusBuffDuration());
        System.out.println("재사용 : " + getJob().getReuse());
        System.out.println("속성 내성 무시 : " + getJob().getProperty());
        System.out.println("무기 공격력 : " + getJob().getWeaponAttMagic());
        System.out.println(getJob().getLinkListStr());
        System.out.println(getJob().getAbility().getDescription());
    }
}
