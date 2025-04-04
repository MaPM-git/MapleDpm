package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.cannonshooter.*;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.BarrelRoulette;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.MonkeyFuriousBuff;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.PoolmakerBuff;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.SpecialMonkeyEscort;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CannonShooter3DealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BarrelRouletteSkull());
            add(new BigFuseGiganticCannonball());
            add(new CannonBuster());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new FinalAttackCannonShooter());
            add(new ICBMAimDelay());
            add(new ICBM());
            add(new ICBMPollution());
            add(new MagneticAnchor());
            add(new MagneticAnchorFinish());
            add(new MaxCannonRainbow());
            add(new MiniCanonBall());
            add(new MonkeyBombBasic());
            add(new MonkeyBombBomb());
            add(new MonkeyBombRapidFire());
            add(new MonkeyCannonBasic());
            add(new MonkeyCannonBomb());
            add(new MonkeyCannonRapidFire());
            add(new MonkeyFurious());
            add(new MonkeyFuriousDot());
            add(new Poolmaker());
            add(new RollingCannonRainbow());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SuperCannonExplosion1());
            add(new SuperCannonExplosion2());
            add(new SupportMonkeyTwins());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BarrelRoulette());
            add(new EpicAdventure());
            add(new LuckyDice());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new MonkeyFuriousBuff());
            add(new Overdrive(348L));
            add(new OverdriveDebuff(348L));
            add(new PirateFlag());
            add(new PoolmakerBuff());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SpecialMonkeyEscort());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    BarrelRoulette barrelRoulette = new BarrelRoulette();
    BigFuseGiganticCannonball bigFuseGiganticCannonball = new BigFuseGiganticCannonball();
    CannonBuster cannonBuster = new CannonBuster();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    EpicAdventure epicAdventure = new EpicAdventure();
    ICBMAimDelay icbm = new ICBMAimDelay();
    LuckyDice luckyDice = new LuckyDice();
    LuckyDiceOneMoreChance luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
    MagneticAnchorFinish magneticAnchorFinish = new MagneticAnchorFinish();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MaxCannonRainbow maxCannonRainbow = new MaxCannonRainbow();
    MiniCanonBall miniCanonBall = new MiniCanonBall();
    MonkeyFurious monkeyFurious = new MonkeyFurious();
    Overdrive overdrive = new Overdrive(348L);
    PirateFlag pirateFlag = new PirateFlag();
    PoolmakerBuff poolmakerBuff = new PoolmakerBuff();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    RollingCannonRainbow rollingCannonRainbow = new RollingCannonRainbow();
    SoulContract soulContract = new SoulContract();
    SpecialMonkeyEscort specialMonkeyEscort = new SpecialMonkeyEscort();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SuperCannonExplosion1 superCannonExplosion1 = new SuperCannonExplosion1();
    SupportMonkeyTwins supportMonkeyTwins = new SupportMonkeyTwins();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public CannonShooter3DealCycle(Job job) {
        super(job, new FinalAttackCannonShooter());

        getJob().setName("캐논슈터(리웨, 3분)");

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(90.0);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());

        barrelRoulette.setRan(2L);
        barrelRoulette.setBuffCriticalDamage(5.0);
        barrelRoulette.setDuration(220L);
        barrelRoulette.setCooldown(220.0);
        addSkillEvent(barrelRoulette);

        mapleWorldGoddessBlessing.setCooldown(120.0);

        getSkillSequence1().add(pirateFlag);                // 570
        getSkillSequence1().add(epicAdventure);             // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(overdrive);                 // 30
        getSkillSequence1().add(soulContract);              // 30
        getSkillSequence1().add(restraintRing);             // 30

        getSkillSequence2().add(pirateFlag);                // 570
        getSkillSequence2().add(overdrive);                 // 30
        getSkillSequence2().add(soulContract);              // 30
        getSkillSequence2().add(weaponJumpRing);            // 30

        getSkillSequence3().add(luckyDice);
        luckyDice.setDelay(660L);

        getSkillSequence4().add(pirateFlag);
        pirateFlag.setDelay(570L);

        getSkillSequence5().add(barrelRoulette);
        barrelRoulette.setDelay(660L);

        overdrive.getRelatedSkill().setDelay(30L);
        mapleWorldGoddessBlessing.setDelay(210L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    luckyDice.getCooldown() == 0
                            && luckyDice.getBuffAttMagic() == 0
                            && luckyDice.getBuffDamage() == 20
            ) {
                luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
                if (
                        luckyDiceOneMoreChance.getBuffDamage() >= 30
                                || luckyDiceOneMoreChance.getBuffAttMagic() >= 15
                ) {
                    luckyDiceOneMoreChance.setCooldown(180.0);
                }
                luckyDice.setCooldown(luckyDiceOneMoreChance.getCooldown());
                luckyDice.setBuffDamage(luckyDiceOneMoreChance.getBuffDamage());
                luckyDice.setBuffAttMagic(luckyDiceOneMoreChance.getBuffAttMagic());
                addSkillEvent(luckyDice);
            } else if (cooldownCheck(luckyDice)) {
                luckyDice = new LuckyDice();
                luckyDice.setDelay(660L);
                if (
                        luckyDice.getBuffDamage() >= 30
                                || luckyDice.getBuffAttMagic() >= 15
                ) {
                    luckyDice.setCooldown(180.0);
                }
                addSkillEvent(luckyDice);
            }
            if (cooldownCheck(magneticAnchorFinish)) {
                addSkillEvent(magneticAnchorFinish);
            }
            if (cooldownCheck(monkeyFurious)) {
                addSkillEvent(monkeyFurious);
            }
            if (cooldownCheck(supportMonkeyTwins)) {
                addSkillEvent(supportMonkeyTwins);
            }
            if (cooldownCheck(barrelRoulette)) {
                barrelRoulette = new BarrelRoulette();
                barrelRoulette.setDelay(660L);
                addSkillEvent(barrelRoulette);
            }
            if (
                    cooldownCheck(epicAdventure)
                            && cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(specialMonkeyEscort)
                            && cooldownCheck(pirateFlag)
                            && cooldownCheck(poolmakerBuff)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(restraintRing)
                            && cooldownCheck(bigFuseGiganticCannonball)
                            && cooldownCheck(maxCannonRainbow)
                            && cooldownCheck(icbm)
            ) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addSkillEvent(specialMonkeyEscort);
                addSkillEvent(poolmakerBuff);
                addDealCycle(getSkillSequence1());
                addSkillEvent(maxCannonRainbow);
                addSkillEvent(bigFuseGiganticCannonball);
                addSkillEvent(icbm);
                if (cooldownCheck(miniCanonBall)) {
                    addSkillEvent(cannonBuster);
                    addSkillEvent(miniCanonBall);
                }
                if (cooldownCheck(superCannonExplosion1)) {
                    addSkillEvent(superCannonExplosion1);
                    if (cooldownCheck(miniCanonBall)) {
                        addSkillEvent(cannonBuster);
                        addSkillEvent(miniCanonBall);
                    }
                }
            } else if (
                    cooldownCheck(specialMonkeyEscort)
                            && cooldownCheck(pirateFlag)
                            && cooldownCheck(overdrive)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(weaponJumpRing)
                            && cooldownCheck(bigFuseGiganticCannonball)
                            && cooldownCheck(icbm)
            ) {
                addSkillEvent(specialMonkeyEscort);
                addDealCycle(getSkillSequence2());
                addSkillEvent(bigFuseGiganticCannonball);
                addSkillEvent(icbm);
            } else if (
                    cooldownCheck(poolmakerBuff)
                            && !cooldownCheck(bigFuseGiganticCannonball)
            ) {
                addSkillEvent(poolmakerBuff);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(85 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(pirateFlag)
                            && !cooldownCheck(specialMonkeyEscort)
            ) {
                addSkillEvent(pirateFlag);
                getStart().setTime(getStart().getTime() + 90);
            } else if (
                    cooldownCheck(icbm)
                            && !cooldownCheck(specialMonkeyEscort)
            ) {
                addSkillEvent(icbm);
            } else {
                addSkillEvent(cannonBuster);
                if (cooldownCheck(miniCanonBall)) {
                    addSkillEvent(miniCanonBall);
                }
            }
        }
        sortEventTimeList();
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
            BarrelRoulette barrelRoulette = null;
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BarrelRoulette) {
                    barrelRoulette = (BarrelRoulette) skillEvent.getSkill();
                }
            }
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (barrelRoulette != null) {
                    if (((AttackSkill) se.getSkill()).isApplyFinalAttack() && barrelRoulette.getRan() == 3) {
                        Long ran = (long) (Math.random() * 99 + 1);
                        if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                            totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                        }
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
                    if (
                            skill instanceof RollingCannonRainbow
                            || skill instanceof MaxCannonRainbow
                    ) {
                        i = 720;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof ICBMPollution) {
                        i = 2500;
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

    public void applyCooldown(Skill skill) {
        if (skill instanceof MiniCanonBall) {
            long remainTime = getStart().getTime() - skill.getActivateTime().getTime();
            if (remainTime >= 20000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 16000));
            } else if (remainTime >= 16000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 12000));
            } else if (remainTime >= 12000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 8000));
            } else if (remainTime >= 8000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 4000));
            } else if (remainTime >= 4000) {
                skill.setActivateTime(new Timestamp(getStart().getTime()));
            } else {
                skill.setActivateTime(new Timestamp(getStart().getTime() + 4000 - remainTime));
            }
            return;
        }
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Double ran = Math.random() * 99;
                if (ran <= getJob().getReuse()) {
                } else  {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            } else {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
            }
            if (!skill.isApplyCooldownReduction()) {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + skill.getCooldown() * 1000)));
            }
        }
    }
}
