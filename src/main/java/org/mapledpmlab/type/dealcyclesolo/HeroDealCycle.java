package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new ComboInstinctsBuff());
            add(new EpicAdventure());
            add(new IncisingBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new SwordIllusionBuff());
            add(new SwordOfBurningSoulBuff());
            add(new ValhallaBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int dealCycleOrder = 1;

    BuffSkill advancedComboAttack = new BuffSkill();

    Timestamp comboInstinctEndTime = new Timestamp(-1);

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    ComboDeathFault comboDeathFault = new ComboDeathFault();
    ComboInstinctsAttack comboInstinctsAttack = new ComboInstinctsAttack();
    ComboInstinctsBuff comboInstinctsBuff = new ComboInstinctsBuff();
    EpicAdventure epicAdventure = new EpicAdventure();
    IncisingAttack incisingAttack = new IncisingAttack();
    IncisingDot incisingDot = new IncisingDot();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    RageUprising rageUprising = new RageUprising();
    RagingBlow ragingBlow = new RagingBlow();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SpiritCaliberSlash spiritCaliberSlash = new SpiritCaliberSlash();
    SwordIllusionBuff swordIllusionBuff = new SwordIllusionBuff();
    SwordOfBurningSoulBuff swordOfBurningSoulBuff = new SwordOfBurningSoulBuff();
    ValhallaBuff valhallaBuff = new ValhallaBuff();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public HeroDealCycle(Job job) {
        super(job, new AdvancedFinalAttackHero());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        for (int i = 0; i < 720 * 1000; i += incisingDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(incisingDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);

        advancedComboAttack.setBuffFinalDamage(2.3);
        advancedComboAttack.setDuration(720L);
        advancedComboAttack.setName("어드밴스드 콤보");
        addSkillEvent(advancedComboAttack);

        auraWeaponBuff.setCooldown(180.0);
        auraWeaponBuff.setApplyCooldownReduction(false);
        mapleWorldGoddessBlessing.setCooldown(180.0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(auraWeaponBuff)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(swordOfBurningSoulBuff)
                            && cooldownCheck(incisingAttack)
                            && cooldownCheck(epicAdventure)
                            && cooldownCheck(valhallaBuff)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(swordIllusionBuff)
                            && cooldownCheck(comboInstinctsBuff)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(swordOfBurningSoulBuff);
                addSkillEvent(incisingAttack);
                addSkillEvent(bodyOfSteel);
                if (cooldownCheck(mapleWorldGoddessBlessing)) {
                    if (dealCycleOrder == 3) {
                        mapleWorldGoddessBlessing.setCooldown(0.0);
                    } else {
                        mapleWorldGoddessBlessing.setCooldown(180.0);
                    }
                    addSkillEvent(mapleWorldGoddessBlessing);
                }
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(ragingBlow);
                }
                addSkillEvent(valhallaBuff);
                addSkillEvent(soulContract);
                addSkillEvent(swordIllusionBuff);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(comboInstinctsBuff);
                if (cooldownCheck(spiritCaliberSlash)) {
                    addSkillEvent(spiritCaliberSlash);
                }
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(swordIllusionBuff)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 20000))
            ) {
                addSkillEvent(swordIllusionBuff);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(100 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(epicAdventure.getActivateTime().getTime() - 50000))
            ) {
                addSkillEvent(incisingAttack);
                addSkillEvent(soulContract);
            } else if (cooldownCheck(rageUprising)
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
            boolean isComboInstincts = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof ComboInstinctsBuff) {
                    isComboInstincts = true;
                    advancedComboAttack.setBuffFinalDamage(2.56);
                    break;
                }
            }
            boolean isSwordIllusionBuff = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof SwordIllusionBuff) {
                    isSwordIllusionBuff = true;
                    if (isComboInstincts) {
                        advancedComboAttack.setBuffFinalDamage(3.496);
                    } else {
                        advancedComboAttack.setBuffFinalDamage(3.08);
                    }
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
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            if (isComboInstincts || isSwordIllusionBuff) {
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
            if (skill instanceof ComboInstinctsBuff) {
                comboInstinctEndTime = new Timestamp(getStart().getTime() + 20000);
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
            } else {
                if (skill instanceof BodyOfSteel) {
                    for (long i = 0; i < 18000; i += 1000) {
                        getSkillEventList().add(new SkillEvent(new BodyOfSteel(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 1000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
                    }
                }
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
        }
        getStart().setTime(getStart().getTime() + skill.getDelay());
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }
}
