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
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 메용2, 6차, 웨폰퍼프
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 메용2, 리레, 스인미, 코오솔
    private final List<Skill> dealCycle3 = new ArrayList<>();

    // 메용2, 웨폰퍼프
    private final List<Skill> dealCycle4 = new ArrayList<>();

    // 웨폰퍼프
    private final List<Skill> dealCycle5 = new ArrayList<>();

    // 일루전 쿨마다 사용 - 인사이징 - 일루전 - 데폴 - 레업라
    private final List<Skill> shortDealCycle = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new SpiritCaliberFinish());
            add(new SpiritCaliberSlash());
            add(new SwordIllusionExplosion());
            add(new SwordIllusionSlash());
            add(new SwordOfBurningSoulDot());
            add(new ValhallaDot());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
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

    Timestamp comboInstinctEndTime = new Timestamp(-1);

    public HeroDealCycle(Job job) {
        super(job, new AdvancedFinalAttackHero());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
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
        SpiritCaliberSlash spiritCaliberSlash = new SpiritCaliberSlash();
        SwordIllusionBuff swordIllusionBuff = new SwordIllusionBuff();
        SwordOfBurningSoulBuff swordOfBurningSoulBuff = new SwordOfBurningSoulBuff();
        ThiefCunning thiefCunning = new ThiefCunning();
        ValhallaBuff valhallaBuff = new ValhallaBuff();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += incisingDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(incisingDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);

        // 1-4-3-2-5-4
        // 메용2, 6차, 리레, 스인미, 크오솔
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
        dealCycle1.add(spiritCaliberSlash);

        // 메용2, 6차, 웨폰퍼프
        dealCycle2.add(swordOfBurningSoulBuff);
        dealCycle2.add(incisingAttack);
        dealCycle2.add(epicAdventure);
        dealCycle2.add(mapleWorldGoddessBlessing);
        dealCycle2.add(valhallaBuff);
        dealCycle2.add(soulContract);
        dealCycle2.add(swordIllusionBuff);
        dealCycle2.add(weaponJumpRing);
        dealCycle2.add(comboInstinctsBuff);
        dealCycle2.add(spiritCaliberSlash);

        // 메용2, 리레, 스인미, 코오솔
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

        // 메용2, 웨폰퍼프
        dealCycle4.add(swordOfBurningSoulBuff);
        dealCycle4.add(incisingAttack);
        dealCycle4.add(epicAdventure);
        dealCycle4.add(mapleWorldGoddessBlessing);
        dealCycle4.add(valhallaBuff);
        dealCycle4.add(soulContract);
        dealCycle4.add(swordIllusionBuff);
        dealCycle4.add(weaponJumpRing);
        dealCycle4.add(comboInstinctsBuff);

        // 리레
        dealCycle5.add(swordOfBurningSoulBuff);
        dealCycle5.add(incisingAttack);
        dealCycle5.add(epicAdventure);
        dealCycle5.add(valhallaBuff);
        dealCycle5.add(soulContract);
        dealCycle5.add(swordIllusionBuff);
        dealCycle5.add(restraintRing);
        dealCycle5.add(comboInstinctsBuff);

        //shortDealCycle.add(incisingAttack);
        shortDealCycle.add(swordIllusionBuff);
        //shortDealCycle.add(rageUprising);

        advancedComboAttack.setBuffFinalDamage(2.3);
        advancedComboAttack.setDuration(720L);
        advancedComboAttack.setName("어드밴스드 콤보");
        addSkillEvent(advancedComboAttack);

        int dealCycleOrder = 1;
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
                    && dealCycleOrder == 3
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
                    cooldownCheck(dealCycle5)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && dealCycleOrder == 5
            ) {
                addDealCycle(dealCycle5);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                    && (
                            getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 50000))
                            || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addSkillEvent(incisingAttack);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(shortDealCycle)
                    && getStart().after(comboInstinctEndTime)
                    && (
                            getStart().before(new Timestamp(soulContract.getActivateTime().getTime() - 13000))
                            || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addDealCycle(shortDealCycle);
            } else if (
                    cooldownCheck(rageUprising)
            ) {
                addSkillEvent(rageUprising);
            } else {
                addSkillEvent(ragingBlow);
                if (getStart().before(comboInstinctEndTime)) {
                    addSkillEvent(comboInstinctsAttack);
                }
            }
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
            List<SkillEvent> useBuffSkillList = new ArrayList<>();
            for (SkillEvent skillEvent : overlappingSkillEvents) {
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isSwordIllusionBuff = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof SwordIllusionBuff) {
                    isSwordIllusionBuff = true;
                    advancedComboAttack.setBuffFinalDamage(2.3 + 0.78);
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
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            if (isSwordIllusionBuff) {
                advancedComboAttack.setBuffFinalDamage(2.3);
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            return;
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
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
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
            if (skill instanceof ComboInstinctsBuff) {
                comboInstinctEndTime = endTime;
            }
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }
}
