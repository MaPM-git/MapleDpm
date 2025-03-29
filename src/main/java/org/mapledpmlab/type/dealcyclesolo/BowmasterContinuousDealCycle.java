package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
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

public class BowmasterContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AdvancedFinalAttackBowmaster());
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
            add(new QuiverCartridge());
            add(new ExtraQuiverCartridge());
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
            add(new ExtraQuiverCartridgeBuff());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Preparation());
            add(new QuiverFullBurstBuff());
            add(new SoulContract());
        }
    };

    boolean isCriticalReinforce = false;
    boolean isNuke = false;
    boolean isSpree = false;

    Long afterImageShotPassiveCount = 0L;
    Long attackCount1 = 40L;
    Long attackCount2 = 0L;
    Long specialArrow = 74L;

    Long magicArrowCount = 50L;
    Long drainArrowCount = 50L;

    Timestamp afterImageShotEndTime = new Timestamp(-1);
    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp extraQuiverCartridgeEndTime = new Timestamp(-1);
    Timestamp warInTheShadeEndTime = new Timestamp(-1);

    QuiverCartridge quiverCartridge = new QuiverCartridge();
    AfterimageShotActive afterimageShotActive = new AfterimageShotActive();
    AfterimageShotPassive afterimageShotPassive = new AfterimageShotPassive();
    ArrawPlatter arrawPlatter = new ArrawPlatter();
    ArrawRain arrawRain = new ArrawRain();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
    EpicAdventure epicAdventure = new EpicAdventure();
    Evolve evolve = new Evolve();
    ExtraQuiverCartridge extraQuiverCartridge = new ExtraQuiverCartridge();
    ExtraQuiverCartridgeBuff extraQuiverCartridgeBuff = new ExtraQuiverCartridgeBuff();
    FlashMirage flashMirage = new FlashMirage();
    GuidedArrow guidedArrow = new GuidedArrow();
    Hurricane hurricane = new Hurricane();
    HurricaneSpree hurricaneSpree = new HurricaneSpree();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    Preparation preparation = new Preparation();
    Phoenix phoenix = new Phoenix();
    QuiverFullBurst quiverFullBurst = new QuiverFullBurst();
    SilhouetteMirage silhouetteMirage = new SilhouetteMirage();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    WarInTheShade warInTheShade = new WarInTheShade();
    WarInTheShadePerfusion warInTheShadePerfusion = new WarInTheShadePerfusion();

    public BowmasterContinuousDealCycle(Job job) {
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

        mapleWorldGoddessBlessing.setCooldown(120.0);

        getSkillSequence1().add(arrawRain);
        getSkillSequence1().add(epicAdventure);             // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(evolve);
        getSkillSequence1().add(quiverFullBurst);
        getSkillSequence1().add(preparation);
        getSkillSequence1().add(afterimageShotActive);
        getSkillSequence1().add(criticalReinforce);
        getSkillSequence1().add(soulContract);              // 30

        arrawRain.setDelay(120L);
        mapleWorldGoddessBlessing.setDelay(120L);
        evolve.setDelay(120L);
        quiverFullBurst.setDelay(120L);
        preparation.setDelay(120L);
        afterimageShotActive.setDelay(120L);
        criticalReinforce.setDelay(120L);
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
            if (cooldownCheck(quiverFullBurst)) {
                getNukeTimeList().add(new Timestamp(getStart().getTime()));
                isNuke = true;
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(extraQuiverCartridgeBuff);
                if (cooldownCheck(warInTheShade)) {
                    addSkillEvent(warInTheShade);
                }
                dealCycleOrder ++;
                isNuke = false;
            } else if (
                    cooldownCheck(soulContract)
                            && !cooldownCheck(evolve)
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(extraQuiverCartridgeBuff)
                    && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(extraQuiverCartridgeBuff);
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
            boolean isEvolve = false;
            boolean isAfterimageShot = false;
            boolean isQuiverFullBurst = false;
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
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof QuiverFullBurstBuff) {
                    isQuiverFullBurst = true;
                    break;
                }
            }
            for (int j = 0; j < useAttackSkillList.size(); j++) {
                if (useAttackSkillList.get(j).getSkill() instanceof AfterimageShotBuff) {
                    isAfterimageShot = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (
                        useBuffSkillList.get(j).getSkill() instanceof ExtraQuiverCartridgeBuff
                        && extraQuiverCartridgeEndTime.before(useBuffSkillList.get(j).getStart())
                ) {
                    extraQuiverCartridgeEndTime = new Timestamp(useBuffSkillList.get(j).getEnd().getTime());
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
                                if (start.before(extraQuiverCartridgeEndTime)) {
                                    if (ran <= quiverCartridge.getProp()) {
                                        totalDamage += getAttackDamage(new SkillEvent(quiverCartridge, start, end), buffSkill, start, end);
                                    }
                                    if (drainArrowCount > 0) {
                                        totalDamage += getAttackDamage(new SkillEvent(extraQuiverCartridge, start, end), buffSkill, start, end);
                                        drainArrowCount --;
                                    } else if (magicArrowCount > 0) {
                                        totalDamage += getAttackDamage(new SkillEvent(extraQuiverCartridge, start, end), buffSkill, start, end);
                                        magicArrowCount --;
                                    } else {
                                        extraQuiverCartridgeEndTime = new Timestamp(end.getTime());
                                    }
                                } else {
                                    if (isQuiverFullBurst) {
                                        if (ran <= quiverCartridge.getProp()) {
                                            totalDamage += getAttackDamage(new SkillEvent(quiverCartridge, start, end), buffSkill, start, end);
                                        }
                                        if (drainArrowCount < 50) {
                                            drainArrowCount++;
                                        }
                                        if (magicArrowCount < 50) {
                                            magicArrowCount++;
                                        }
                                    } else if (drainArrowCount < 50) {
                                        if (drainArrowCount < 50) {
                                            drainArrowCount++;
                                        }
                                    } else if (magicArrowCount < 50) {
                                        if (ran <= quiverCartridge.getProp()) {
                                            totalDamage += getAttackDamage(new SkillEvent(quiverCartridge, start, end), buffSkill, start, end);
                                        }
                                        if (magicArrowCount < 50) {
                                            magicArrowCount++;
                                        }
                                    }
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
                    if (start.before(extraQuiverCartridgeEndTime)) {
                        if (ran <= quiverCartridge.getProp()) {
                            totalDamage += getAttackDamage(new SkillEvent(quiverCartridge, start, end), buffSkill, start, end);
                        }
                        if (drainArrowCount > 0) {
                            totalDamage += getAttackDamage(new SkillEvent(extraQuiverCartridge, start, end), buffSkill, start, end);
                            drainArrowCount --;
                        } else if (magicArrowCount > 0) {
                            totalDamage += getAttackDamage(new SkillEvent(extraQuiverCartridge, start, end), buffSkill, start, end);
                            magicArrowCount --;
                        } else {
                            extraQuiverCartridgeEndTime = new Timestamp(end.getTime());
                        }
                    } else {
                        if (isQuiverFullBurst) {
                            if (ran <= quiverCartridge.getProp()) {
                                totalDamage += getAttackDamage(new SkillEvent(quiverCartridge, start, end), buffSkill, start, end);
                            }
                            if (drainArrowCount < 50) {
                                drainArrowCount++;
                            }
                            if (magicArrowCount < 50) {
                                magicArrowCount++;
                            }
                        } else if (drainArrowCount < 50) {
                            if (drainArrowCount < 50) {
                                drainArrowCount++;
                            }
                        } else if (magicArrowCount < 50) {
                            if (ran <= quiverCartridge.getProp()) {
                                totalDamage += getAttackDamage(new SkillEvent(quiverCartridge, start, end), buffSkill, start, end);
                            }
                            if (magicArrowCount < 50) {
                                magicArrowCount++;
                            }
                        }
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
                            * (1 - 0.5 * (1 - (this.getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
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
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof Hurricane
                            || skill instanceof HurricaneSpree
                    )
            ) {
                addSkillEvent(continuousRing);
            }
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

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Timestamp now = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof WarInTheShade
                            || skill instanceof WarInTheShadePerfusion
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            getStart().setTime(now.getTime());
        }
    }
}
