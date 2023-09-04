package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.hero.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.hero.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class HeroDealCycle extends DealCycle {

    // 오라웨폰 극딜마다 사용
    // 소오버 설치(75초) - 인사이징(60초) - 에픽어드벤쳐(60초) - 메용2(60초)
    // 크오솔(51초) - 스인미(50초)
    // 발할라(30초) - 엔버(10초) - 일루전(8초) - 시드링(15초) - 인팅(20초)
    // 30초마다 일루전 - 데폴 - 레업라 사용
    // 시드링 리레 - 웨퍼
    // 시드링 스위칭 시간(5초)
    // 메용2 2극딜 제외 모두 사용

    // 메용2, 6차, 리레, 스인미, 크오솔
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private List<Skill> dealCycle4 = new ArrayList<>();

    // 웨폰퍼프
    private List<Skill> dealCycle5 = new ArrayList<>();

    // 일루전 쿨마다 사용 - 인사이징 - 일루전 - 데폴 - 레업라
    private List<Skill> shortDealCycle = new ArrayList<>();

    private Timestamp swordOfBurningSoulActivateTime = new Timestamp(0);
    private Timestamp swordIllusionActivateTime = new Timestamp(0);
    private Timestamp rageUprisingActivateTime = new Timestamp(0);
    private Timestamp ringSwitchingActivateTime = new Timestamp(75 * 1000);
    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackHero());
            add(new AuraWeaponDot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new ComboDeathFault());
            add(new ComboInstinctsAttack());
            add(new IncisingAttack());
            add(new IncisingDot());
            add(new RageUprising());
            add(new RagingBlow());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SpiritCaliber());
            add(new SwordIllusionExplosion());
            add(new SwordIllusionSlash());
            add(new SwordOfBurningSoulDot());
            add(new ValhallaDot());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new SpiritCaliberDelay());
            add(new SwordIllusionDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new ComboInstinctsBuff());
            add(new EpicAdventure());
            add(new IncisingBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SoulContract());
            add(new SwordIllusionBuff());
            add(new SwordOfBurningSoulBuff());
            add(new ThiefCunning());
            add(new ValhallaBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    BuffSkill advancedComboAttack = new BuffSkill();

    public HeroDealCycle(Job job) {
        super(job, new AdvancedFinalAttackHero());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        Long q = 0L;

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        AuraWeaponDot auraWeaponDot = new AuraWeaponDot();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CrestOfTheSolarDot crestOfTheSolarDot = new CrestOfTheSolarDot();
        ComboDeathFault comboDeathFault = new ComboDeathFault();
        ComboInstinctsAttack comboInstinctsAttack = new ComboInstinctsAttack();
        ComboInstinctsBuff comboInstinctsBuff = new ComboInstinctsBuff();
        EpicAdventure epicAdventure = new EpicAdventure();
        IncisingAttack incisingAttack = new IncisingAttack();
        IncisingDot incisingDot = new IncisingDot();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        PriorPreparation priorPreparation = new PriorPreparation();
        RageUprising rageUprising = new RageUprising();
        RagingBlow ragingBlow = new RagingBlow();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiderInMirrorDot spiderInMirrorDot = new SpiderInMirrorDot();
        SpiritCaliber spiritCaliber = new SpiritCaliber();
        SwordIllusionBuff swordIllusionBuff = new SwordIllusionBuff();
        SwordIllusionExplosion swordIllusionExplosion = new SwordIllusionExplosion();
        SwordIllusionSlash swordIllusionSlash = new SwordIllusionSlash();
        SwordOfBurningSoulBuff swordOfBurningSoulBuff = new SwordOfBurningSoulBuff();
        SwordOfBurningSoulDot swordOfBurningSoulDot = new SwordOfBurningSoulDot();
        ThiefCunning thiefCunning = new ThiefCunning();
        ValhallaBuff valhallaBuff = new ValhallaBuff();
        ValhallaDot valhallaDot = new ValhallaDot();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += incisingDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(incisingDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        dealCycle1.add(swordOfBurningSoulBuff);
        dealCycle1.add(incisingAttack);
        dealCycle1.add(epicAdventure);
        dealCycle1.add(mapleWorldGoddessBlessing);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(valhallaBuff);
        dealCycle1.add(soulContract);
        dealCycle1.add(swordIllusionBuff);
        dealCycle1.add(restraintRing);
        dealCycle1.add(comboInstinctsBuff);
        dealCycle1.add(spiritCaliber);
        q = 12470L;
        while (q > 0) {     // 남은 인스팅트 동안 레이징 블로우 사용
            dealCycle1.add(ragingBlow);
            dealCycle1.add(comboInstinctsAttack);
            q -=  ragingBlow.getDelay();
        }

        dealCycle2.add(swordOfBurningSoulBuff);
        dealCycle2.add(incisingAttack);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(valhallaBuff);
        dealCycle2.add(soulContract);
        dealCycle2.add(swordIllusionBuff);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(comboInstinctsBuff);
        dealCycle2.add(spiritCaliber);
        q = 12470L;
        while (q > 0) {     // 남은 인스팅트 동안 레이징 블로우 사용
            dealCycle2.add(ragingBlow);
            dealCycle2.add(comboInstinctsAttack);
            q -=  ragingBlow.getDelay();
        }

        dealCycle3.add(swordOfBurningSoulBuff);
        dealCycle3.add(incisingAttack);
        dealCycle3.add(epicAdventure);
        dealCycle3.add(mapleWorldGoddessBlessing);
        dealCycle3.add(crestOfTheSolar);
        dealCycle3.add(spiderInMirror);
        dealCycle3.add(valhallaBuff);
        dealCycle3.add(soulContract);
        dealCycle3.add(swordIllusionBuff);
        dealCycle3.add(restraintRing);
        dealCycle3.add(comboInstinctsBuff);
        q = 19550L;
        while (q > 0) {     // 남은 인스팅트 동안 레이징 블로우 사용
            dealCycle3.add(ragingBlow);
            dealCycle3.add(comboInstinctsAttack);
            q -=  ragingBlow.getDelay();
        }

        dealCycle4.add(swordOfBurningSoulBuff);
        dealCycle4.add(incisingAttack);
        dealCycle4.add(epicAdventure);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(valhallaBuff);
        dealCycle4.add(soulContract);
        dealCycle4.add(swordIllusionBuff);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(comboInstinctsBuff);
        q = 19550L;
        while (q > 0) {     // 남은 인스팅트 동안 레이징 블로우 사용
            dealCycle4.add(ragingBlow);
            dealCycle4.add(comboInstinctsAttack);
            q -=  ragingBlow.getDelay();
        }

        dealCycle5.add(swordOfBurningSoulBuff);
        dealCycle5.add(incisingAttack);
        dealCycle5.add(epicAdventure);
        dealCycle5.add(valhallaBuff);
        dealCycle5.add(soulContract);
        dealCycle5.add(swordIllusionBuff);
        dealCycle5.add(weaponJumpRing);
        dealCycle5.add(comboInstinctsBuff);
        q = 19550L;
        while (q > 0) {     // 남은 인스팅트 동안 레이징 블로우 사용
            dealCycle5.add(ragingBlow);
            dealCycle5.add(comboInstinctsAttack);
            q -=  ragingBlow.getDelay();
        }

        shortDealCycle.add(incisingAttack);
        shortDealCycle.add(swordIllusionBuff);
        shortDealCycle.add(comboDeathFault);
        shortDealCycle.add(rageUprising);

        advancedComboAttack.setBuffFinalDamage(2.3);
        advancedComboAttack.setDuration(720L);
        advancedComboAttack.setName("어드밴스드 콤보");
        addSkillEvent(advancedComboAttack);

        int i = 0;
        while (getStart().before(getEnd())) {
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
            ) {
                addDealCycle(dealCycle1);
                swordOfBurningSoulActivateTime.setTime(dealCycle1.get(1).getActivateTime().getTime());
                swordIllusionActivateTime.setTime(dealCycle1.get(7).getActivateTime().getTime());
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
                swordOfBurningSoulActivateTime.setTime(dealCycle2.get(1).getActivateTime().getTime());
                swordIllusionActivateTime.setTime(dealCycle2.get(7).getActivateTime().getTime());
            } else if (
                    cooldownCheck(dealCycle3)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle3);
                swordOfBurningSoulActivateTime.setTime(dealCycle3.get(1).getActivateTime().getTime());
                swordIllusionActivateTime.setTime(dealCycle3.get(7).getActivateTime().getTime());
            } else if (
                    cooldownCheck(dealCycle4)
                    && i > 140
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle4);
                swordOfBurningSoulActivateTime.setTime(dealCycle4.get(1).getActivateTime().getTime());
                swordIllusionActivateTime.setTime(dealCycle4.get(7).getActivateTime().getTime());
            } else if (
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addDealCycle(dealCycle5);
                swordOfBurningSoulActivateTime.setTime(dealCycle5.get(1).getActivateTime().getTime());
                swordIllusionActivateTime.setTime(dealCycle5.get(6).getActivateTime().getTime());
            } else if (
                    cooldownCheck(ringSwitching)
                    && swordOfBurningSoulActivateTime.after(ringSwitchingActivateTime)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(9 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
                ringSwitchingActivateTime.setTime(ringSwitching.getActivateTime().getTime());
            } else if (
                    cooldownCheck(shortDealCycle)
                    && getStart().before(new Timestamp(soulContract.getActivateTime().getTime() + 30000))
            ) {
                addDealCycle(shortDealCycle);
                swordIllusionActivateTime.setTime(shortDealCycle.get(1).getActivateTime().getTime());
                rageUprisingActivateTime.setTime(shortDealCycle.get(3).getActivateTime().getTime());
            } else if (
                    cooldownCheck(rageUprising)
                    && !cooldownCheck(swordIllusionBuff)
            ) {
                addSkillEvent(shortDealCycle.get(3));
                rageUprisingActivateTime.setTime(shortDealCycle.get(3).getActivateTime().getTime());
            } else {
                addSkillEvent(ragingBlow);
            }
            i++;
        }
        sortEventTimeList();
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
            overlappingSkillEvents = deduplication(overlappingSkillEvents, SkillEvent::getSkill);
            boolean isSwordIllusionBuff = false;
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof SwordIllusionBuff) {
                    isSwordIllusionBuff = true;
                    advancedComboAttack.setBuffFinalDamage(2.3 + 0.78);
                    break;
                }
            }
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
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            if (isSwordIllusionBuff) {
                isSwordIllusionBuff = false;
                advancedComboAttack.setBuffFinalDamage(2.3);
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
