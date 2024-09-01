package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.bowmaster.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.bowmaster.*;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class BowmasterDealCycle extends DealCycle {
    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackBowmaster());
            add(new AdvancedQuiver());
            add(new AfterimageShotActive());
            add(new AfterimageShotPassive());
            add(new ArrawPlatter());
            add(new ArrawRain());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new Evolve());
            add(new FlashMirage());
            add(new GuidedArrow());
            add(new Hurricane());
            add(new HurricaneSpree());
            add(new Phoenix());
            add(new QuiverFullBurst());
            add(new SilhouetteMirage());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new WarInTheShade());
            add(new WarInTheShadePerfusion());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ArrowRainBuff());
            add(new CriticalReinforce(0.0));
            add(new EpicAdventure());
            add(new EvolveBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Preparation());
            add(new QuiverFullBurstBuff());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    boolean isCriticalReinforce = false;
    boolean isSpree = false;

    Long afterImageShotPassiveCount = 0L;
    Long attackCount1 = 0L;

    Long attackCount2 = 0L;
    Long specialArrow = 74L;

    Timestamp warInTheShadeEndTime = new Timestamp(-1);
    Timestamp afterImageShotEndTime = new Timestamp(-1);

    AdvancedQuiver advancedQuiver = new AdvancedQuiver();
    AfterimageShotActive afterimageShotActive = new AfterimageShotActive();
    AfterimageShotPassive afterimageShotPassive = new AfterimageShotPassive();
    ArrawPlatter arrawPlatter = new ArrawPlatter();
    ArrawRain arrawRain = new ArrawRain();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
    EpicAdventure epicAdventure = new EpicAdventure();
    Evolve evolve = new Evolve();
    FlashMirage flashMirage = new FlashMirage();
    GuidedArrow guidedArrow = new GuidedArrow();
    Hurricane hurricane = new Hurricane();
    HurricaneSpree hurricaneSpree = new HurricaneSpree();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    Preparation preparation = new Preparation();
    Phoenix phoenix = new Phoenix();
    QuiverFullBurst quiverFullBurst = new QuiverFullBurst();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SilhouetteMirage silhouetteMirage = new SilhouetteMirage();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    WarInTheShade warInTheShade = new WarInTheShade();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
    WarInTheShadePerfusion warInTheShadePerfusion = new WarInTheShadePerfusion();

    public BowmasterDealCycle(Job job) {
        super(job, new AdvancedFinalAttackBowmaster());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        // 피닉스
        for (int i = 0; i < 720 * 1000; i += phoenix.getInterval()) {
            getSkillEventList().add(new SkillEvent(phoenix, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 애로우 플래터
        for (int i = 0; i < 720 * 1000; i += arrawPlatter.getInterval()) {
            getSkillEventList().add(new SkillEvent(arrawPlatter, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 실루엣 미라주
        for (int i = 0; i < 720 * 1000; i += 7500) {
            for (int j = 0; j < silhouetteMirage.getInterval() * silhouetteMirage.getLimitAttackCount(); j += silhouetteMirage.getInterval()) {
                getSkillEventList().add(new SkillEvent(silhouetteMirage, new Timestamp(i + j), new Timestamp(i + j)));
                getEventTimeList().add(new Timestamp(i + j));
            }
        }

        // 가이디드 에로우
        for (int i = 0; i < 720 * 1000; i += guidedArrow.getInterval()) {
            getSkillEventList().add(new SkillEvent(guidedArrow, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(130.0);
        mapleWorldGoddessBlessing.setCooldown(180.0);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(arrawPlatter)){
                addSkillEvent(arrawPlatter);
            }
            if (specialArrow == 75) {
                isSpree = true;
            }
            if (
                    cooldownCheck(arrawRain)
                            && cooldownCheck(epicAdventure)
                            && cooldownCheck(quiverFullBurst)
                            && cooldownCheck(preparation)
                            && cooldownCheck(evolve)
                            && cooldownCheck(afterimageShotActive)
                            && cooldownCheck(criticalReinforce)
                            && cooldownCheck(soulContract)
                            && specialArrow >= 70
            ) {
                addSkillEvent(arrawRain);
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
                    addSkillEvent(hurricane);
                }
                addSkillEvent(quiverFullBurst);
                addSkillEvent(preparation);
                addSkillEvent(evolve);
                addSkillEvent(afterimageShotActive);
                addSkillEvent(criticalReinforce);
                addSkillEvent(soulContract);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                if (cooldownCheck(warInTheShade)) {
                    addSkillEvent(warInTheShade);
                }
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(100 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000)))
            {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && !cooldownCheck(evolve)
            ) {
                addSkillEvent(soulContract);
            } else if (specialArrow == 0) {
                addSkillEvent(hurricane);
                specialArrow ++;
                isSpree = false;
            } else if (isSpree) {
                addSkillEvent(hurricaneSpree);
                specialArrow --;
            } else {
                addSkillEvent(hurricane);
                specialArrow ++;
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
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isEvolve = false;
            boolean isAfterimageShot = false;
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof EvolveBuff) {
                    isEvolve = true;
                    break;
                }
            }
            if (isEvolve) {
                for (int j = 0; j < useAttackSkillList.size(); j++) {
                    if (useAttackSkillList.get(j).getSkill() instanceof Phoenix) {
                        useAttackSkillList.remove(j);
                    }
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof CriticalReinforce) {
                    isCriticalReinforce = true;
                    break;
                }
            }
            for (int j = 0; j < useAttackSkillList.size(); j++) {
                if (useAttackSkillList.get(j).getSkill() instanceof AfterimageShotBuff) {
                    isAfterimageShot = true;
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
                if (
                        se.getStart().equals(start)
                        && (
                                se.getSkill() instanceof Hurricane
                                || se.getSkill() instanceof HurricaneSpree
                                || se.getSkill() instanceof SilhouetteMirage
                                || se.getSkill() instanceof AfterimageShotActive
                                || se.getSkill() instanceof AfterimageShotPassive
                                || se.getSkill() instanceof QuiverFullBurst
                                || se.getSkill() instanceof ArrawRain
                                || se.getSkill() instanceof WarInTheShade
                        )
                ) {
                    attackCount1++;
                    if (se.getSkill() instanceof WarInTheShade) {
                        attackCount1 += 6;
                    }
                    if (attackCount1 >= 49) {
                        getStart().setTime(start.getTime());
                        if (cooldownCheck(flashMirage)) {
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            totalDamage += getAttackDamage(new SkillEvent(flashMirage, start, end), buffSkill, start, end);
                            for (int m = 0; m < 4; m ++) {
                                Long ran = (long) (Math.random() * 99 + 1);
                                if (ran <= advancedQuiver.getProp()) {
                                    totalDamage += getAttackDamage(new SkillEvent(advancedQuiver, start, end), buffSkill, start, end);
                                }
                            }
                            applyCooldown(flashMirage);
                        }
                        attackCount1 = 0L;
                    }
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
                if (
                        start.equals(se.getStart())
                        && (
                                se.getSkill() instanceof ArrawRain
                                || se.getSkill() instanceof Hurricane
                                || se.getSkill() instanceof HurricaneSpree
                                || se.getSkill() instanceof QuiverFullBurst
                                || se.getSkill() instanceof SilhouetteMirage
                                || se.getSkill() instanceof GuidedArrow
                                || se.getSkill() instanceof AfterimageShotActive
                                || se.getSkill() instanceof AfterimageShotPassive
                                || se.getSkill() instanceof WarInTheShade
                        )
                ) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (se.getSkill() instanceof ArrawRain) {
                        ran = 100L;
                    }
                    if (ran <= advancedQuiver.getProp()) {
                        totalDamage += getAttackDamage(new SkillEvent(advancedQuiver, start, end), buffSkill, start, end);
                    }
                }
            }
            isCriticalReinforce = false;
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
        if (isCriticalReinforce) {
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP());
            buffSkill.addBuffCriticalDamage(criticalReinforce.getBuffCriticalDamage());
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
                    attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat()) * 4
                            + this.getJob().getFinalSubstat()) * 0.01
                            * (Math.floor((this.getJob().getAtt() + buffSkill.getBuffAttMagic())
                            * (1 + (this.getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                            + this.getJob().getPerXAtt())
                            * this.getJob().getConstant()
                            * (1 + (this.getJob().getDamage() + this.getJob().getBossDamage() + this.getJob().getStatXDamage() + buffSkill.getBuffDamage() + attackSkill.getAddDamage()) * 0.01)
                            * (this.getJob().getFinalDamage())
                            * buffSkill.getBuffFinalDamage()
                            * this.getJob().getStatXFinalDamage()
                            * attackSkill.getFinalDamage()
                            * this.getJob().getMastery()
                            * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                            * (1 + 0.35 + (this.getJob().getCriticalDamage() + buffSkill.getBuffCriticalDamage()) * 0.01)
                            * (1 - 0.5 * (1 - (this.getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
                            * (1 - 3.8 * (1 - buffSkill.getIgnoreDefense()) * (1 - this.getJob().getIgnoreDefense()) * (1 - this.getJob().getStatXIgnoreDefense()) * (1 - attackSkill.getIgnoreDefense()))
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
        if (isCriticalReinforce) {
            CriticalReinforce criticalReinforce = new CriticalReinforce(getJob().getCriticalP() + buffSkill.getBuffCriticalP());
            buffSkill.addBuffCriticalDamage(-criticalReinforce.getBuffCriticalDamage());
        }
        return attackDamage;
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
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (skill instanceof AfterimageShotActive) {
                afterImageShotPassiveCount = 0L;
                afterImageShotEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (
                    getStart().after(afterImageShotEndTime)
                    && (
                            skill instanceof Hurricane
                            || skill instanceof HurricaneSpree
                    )
                    && cooldownCheck(afterimageShotPassive)
            ) {
                afterImageShotPassiveCount ++;
                if (afterImageShotPassiveCount == 10) {
                    addSkillEvent(afterimageShotPassive);
                    afterImageShotPassiveCount = 0L;
                }
            }
            if (
                    getStart().before(warInTheShadeEndTime)
                    && cooldownCheck(warInTheShadePerfusion)
            ) {
                Long attackCount = 0L;
                for (long i = warInTheShadePerfusion.getInterval(); i <= warInTheShadePerfusion.getDotDuration() && attackCount < warInTheShadePerfusion.getLimitAttackCount(); i += warInTheShadePerfusion.getInterval()) {
                    getSkillEventList().add(new SkillEvent(warInTheShadePerfusion, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    attackCount += 1;
                }
                applyCooldown(warInTheShadePerfusion);
            }
            if (skill instanceof WarInTheShade) {
                warInTheShadeEndTime = new Timestamp(getStart().getTime() + skill.getDelay() + 30000);
            }
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
