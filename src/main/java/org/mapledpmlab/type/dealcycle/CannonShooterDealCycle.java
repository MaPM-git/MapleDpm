package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.cannonshooter.*;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.BarrelRoulette;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.PoolmakerBuff;
import org.mapledpmlab.type.skill.buffskill.cannonshooter.SpecialMonkeyEscort;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CannonShooterDealCycle extends DealCycle {

    /*
        메용2 에픽 삼숭이 풀메 오버드라이브 코코볼3개 시드링 엔버링크 롤링캐논
     */

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BarrelRouletteSkull());
            add(new BigFuseGiganticCannonball());
            add(new CannonBuster());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new FinalAttackCannonShooter());
            add(new ICBM());
            add(new ICBMPollution());
            add(new MagneticAnchor());
            add(new MagneticAnchorFinish());
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new BigFuseGiganticCannonballDelay());
            add(new MagneticAnchorDelay());
            add(new RollingCannonRainbowDelay());
            add(new SuperCannonExplosionDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BarrelRoulette());
            add(new EpicAdventure());
            add(new LuckyDice());
            add(new LuckyDiceOneMoreChance());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Overdrive(348L));
            add(new OverdriveDebuff(348L));
            add(new PirateFlag());
            add(new PoolmakerBuff());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SpecialMonkeyEscort());
            add(new ThiefCunning());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    public CannonShooterDealCycle(Job job) {
        super(job, new FinalAttackCannonShooter());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        BarrelRoulette barrelRoulette = new BarrelRoulette();
        BigFuseGiganticCannonball bigFuseGiganticCannonball = new BigFuseGiganticCannonball();
        CannonBuster cannonBuster = new CannonBuster();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        EpicAdventure epicAdventure = new EpicAdventure();
        ICBM icbm = new ICBM();
        LuckyDice luckyDice = new LuckyDice();
        LuckyDiceOneMoreChance luckyDiceOneMoreChance = new LuckyDiceOneMoreChance();
        MagneticAnchor magneticAnchor = new MagneticAnchor();
        MagneticAnchorDelay magneticAnchorDelay = new MagneticAnchorDelay();
        MagneticAnchorFinish magneticAnchorFinish = new MagneticAnchorFinish();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        MiniCanonBall miniCanonBall = new MiniCanonBall();
        MonkeyFurious monkeyFurious = new MonkeyFurious();
        MonkeyFuriousDot monkeyFuriousDot = new MonkeyFuriousDot();
        Overdrive overdrive = new Overdrive(348L);
        PirateFlag pirateFlag = new PirateFlag();
        PoolmakerBuff poolmakerBuff = new PoolmakerBuff();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        RollingCannonRainbow rollingCannonRainbow = new RollingCannonRainbow();
        SoulContract soulContract = new SoulContract();
        SpecialMonkeyEscort specialMonkeyEscort = new SpecialMonkeyEscort();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SuperCannonExplosion1 superCannonExplosion1 = new SuperCannonExplosion1();
        SupportMonkeyTwins supportMonkeyTwins = new SupportMonkeyTwins();
        ThiefCunning thiefCunning = new ThiefCunning();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += magneticAnchor.getInterval()) {
            getSkillEventList().add(new SkillEvent(magneticAnchor, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += magneticAnchorFinish.getInterval()) {
            getSkillEventList().add(new SkillEvent(magneticAnchorFinish, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += monkeyFuriousDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(monkeyFuriousDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += supportMonkeyTwins.getInterval()) {
            getSkillEventList().add(new SkillEvent(supportMonkeyTwins, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(180.0);

        /*
            메용2 에픽 삼숭이 풀메 오버드라이브 시드링 엔버링크 코코볼3개 롤링캐논 ICBM
        */
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(specialMonkeyEscort);
        dealCycle1.add(pirateFlag);
        dealCycle1.add(poolmakerBuff);
        dealCycle1.add(overdrive);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(bigFuseGiganticCannonball);
        dealCycle1.add(rollingCannonRainbow);
        dealCycle1.add(superCannonExplosion1);
        dealCycle1.add(icbm);

        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(specialMonkeyEscort);
        dealCycle2.add(pirateFlag);
        dealCycle2.add(poolmakerBuff);
        dealCycle2.add(overdrive);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(bigFuseGiganticCannonball);
        dealCycle2.add(rollingCannonRainbow);
        dealCycle2.add(icbm);

        dealCycle3.add(specialMonkeyEscort);
        dealCycle3.add(pirateFlag);
        dealCycle3.add(poolmakerBuff);
        dealCycle3.add(overdrive);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);
        dealCycle3.add(bigFuseGiganticCannonball);
        dealCycle3.add(rollingCannonRainbow);
        dealCycle3.add(icbm);

        luckyDice.setCooldown(180.0);
        luckyDice.setBuffAttMagic(0L);
        luckyDice.setBuffDamage(40L);
        addSkillEvent(luckyDice);
        luckyDiceOneMoreChance.setActivateTime(luckyDice.getActivateTime());

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
                if (
                        luckyDice.getBuffDamage() >= 30
                        || luckyDice.getBuffAttMagic() >= 15
                ) {
                    luckyDice.setCooldown(180.0);
                }
                addSkillEvent(luckyDice);
            }
            if (cooldownCheck(magneticAnchorDelay)) {
                addSkillEvent(magneticAnchorDelay);
            }
            if (cooldownCheck(monkeyFurious)) {
                addSkillEvent(monkeyFurious);
            }
            if (cooldownCheck(supportMonkeyTwins)) {
                addSkillEvent(supportMonkeyTwins);
            }
            if (cooldownCheck(barrelRoulette)) {
                barrelRoulette = new BarrelRoulette();
                addSkillEvent(barrelRoulette);
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
                    && getStart().before(new Timestamp(11 * 60 * 1000))) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(pirateFlag)
                    && getStart().before(new Timestamp(soulContract.getActivateTime().getTime() - 20000))
            ) {
                addSkillEvent(pirateFlag);
            } else if (
                    cooldownCheck(icbm)
                    && getStart().before(new Timestamp(soulContract.getActivateTime().getTime() - 20000))
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
            overlappingSkillEvents = deduplication(overlappingSkillEvents, SkillEvent::getSkill);
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BuffSkill) {
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
                } else {
                    useAttackSkillList.add(skillEvent);
                }
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
                    if (((AttackSkill) se.getSkill()).isApplyFinalAttack() && barrelRoulette.getRan() == 1) {
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
}
