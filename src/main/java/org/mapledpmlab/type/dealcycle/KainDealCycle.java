package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.kain.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.kain.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class KainDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new Annihilation());
            add(new AnnihilationDragonBreath());
            add(new AnnihilationFinish());
            add(new ChainSickle());
            add(new ChainSickleFinish());
            add(new ChasingShot());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DeathBlessing());
            add(new DragonBurstBeforeDelay());
            add(new DragonBurstLoop());
            add(new DragonBurstAfterDelay());
            add(new DragonFang());
            add(new FallingDust());
            add(new FallingDustEnchant());
            add(new FallingDustEnchantMalice());
            add(new FatalBlitzBeforeDelay());
            add(new FatalBlitzLoop());
            add(new FatalBlitzAfterDelay());
            add(new GripOfAgony());
            add(new GuidedArrow());
            add(new PhantomBlade());
            add(new PoisonNeedle());
            add(new PoisonNeedleDot());
            add(new PoisonNeedleFinish());
            add(new PoisonNeedleLoop());
            add(new RemainIncense());
            add(new ScatteringShot());
            add(new ScatteringShotEnchant());
            add(new ShaftBreak());
            add(new ShaftBreakBomb());
            add(new ShaftBreakEnchant());
            add(new ShaftBreakEnchantBomb());
            add(new ShaftBreakEnchantTornado());
            add(new SneakySnipingBeforeDelay());
            add(new SneakySniping());
            add(new SneakySnipingEnchant());
            add(new SneakySnipingEnchantBeforeDelay());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new StrikeArrow1());
            add(new StrikeArrow2());
            add(new StrikeArrow3());
            add(new StrikeArrowEnchant());
            add(new TearingKnife());
            add(new ThanatosDescentDeathArrow());
            add(new ThanatosDescentFinish());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AnnihilationBuff());
            add(new AnnihilationDeathBlessing());
            add(new CriticalReinforce(100.0));
            add(new DeathBlessingContributionBuff());
            add(new GrandisGoddessBlessingNova());
            add(new Incarnation());
            add(new Possession());
            add(new PossessionMalice());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new ThanatosDescentBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    AnnihilationDeathBlessing annihilationDeathBlessing = new AnnihilationDeathBlessing();
    AnnihilationDragonBreath annihilationDragonBreath = new AnnihilationDragonBreath();
    ChainSickle chainSickle = new ChainSickle();
    DeathBlessing deathBlessing = new DeathBlessing();
    DragonFang dragonFang1 = new DragonFang();
    DragonFang dragonFang2 = new DragonFang();
    DragonFang dragonFang3 = new DragonFang();
    FatalBlitzBeforeDelay fatalBlitzBeforeDelay = new FatalBlitzBeforeDelay();
    PhantomBlade phantomBlade = new PhantomBlade();
    PoisonNeedle poisonNeedle = new PoisonNeedle();
    PossessionMalice possessionMalice = new PossessionMalice();
    RemainIncense remainIncense = new RemainIncense();
    TearingKnife tearingKnife = new TearingKnife();
    ThanatosDescentDeathArrow thanatosDescentDeathArrow = new ThanatosDescentDeathArrow();

    boolean isAnnihilation = false;
    boolean isCriticalReinforce = false;
    boolean isIncarnation = false;

    int deathBlessingCnt = 15;
    int malice = 500;
    int remainIncenseCnt = 0;
    int reuseCnt = 0;

    Timestamp annihilationBuffEndTime = new Timestamp(-1);
    Timestamp deathBlessingContributionBuffEndTime = new Timestamp(-1);
    Timestamp grandisGoddessBlessingEndTime = new Timestamp(-1);
    Timestamp thanatosDescentEndTime = new Timestamp(-1);

    public KainDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        Annihilation annihilation = new Annihilation();
        ChasingShot chasingShot = new ChasingShot();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CriticalReinforce criticalReinforce = new CriticalReinforce(100.0);
        DragonBurstBeforeDelay dragonBurstBeforeDelay = new DragonBurstBeforeDelay();
        FallingDust fallingDust = new FallingDust();
        FallingDustEnchant fallingDustEnchant = new FallingDustEnchant();
        GrandisGoddessBlessingNova grandisGoddessBlessingNova = new GrandisGoddessBlessingNova();
        GripOfAgony gripOfAgony = new GripOfAgony();
        GuidedArrow guidedArrow = new GuidedArrow();
        Incarnation incarnation = new Incarnation();
        Possession possession = new Possession();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        ScatteringShot scatteringShot = new ScatteringShot();
        ScatteringShotEnchant scatteringShotEnchant = new ScatteringShotEnchant();
        ShaftBreak shaftBreak = new ShaftBreak();
        ShaftBreakEnchant shaftBreakEnchant = new ShaftBreakEnchant();
        SneakySnipingBeforeDelay sneakySnipingBeforeDelay = new SneakySnipingBeforeDelay();
        SneakySnipingEnchantBeforeDelay sneakySnipingEnchantBeforeDelay = new SneakySnipingEnchantBeforeDelay();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        StrikeArrow1 strikeArrow1 = new StrikeArrow1();
        StrikeArrow2 strikeArrow2 = new StrikeArrow2();
        StrikeArrow3 strikeArrow3 = new StrikeArrow3();
        StrikeArrowEnchant strikeArrowEnchant = new StrikeArrowEnchant();
        ThanatosDescentBuff thanatosDescentBuff = new ThanatosDescentBuff();
        ThanatosDescentFinish thanatosDescentFinish = new ThanatosDescentFinish();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        ringSwitching.setCooldown(95.0);

        List<AttackSkill> strikeArrowList = new ArrayList<>();
        strikeArrowList.add(strikeArrow1);
        strikeArrowList.add(strikeArrow2);
        strikeArrowList.add(strikeArrow3);
        int i = 0;

        addSkillEvent(guidedArrow);
        addSkillEvent(poisonNeedle);
        addSkillEvent(possession);
        addSkillEvent(shaftBreakEnchant);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(incarnation)
                    && cooldownCheck(thanatosDescentBuff)
                    && cooldownCheck(criticalReinforce)
                    && cooldownCheck(gripOfAgony)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
                    && cooldownCheck(dragonBurstBeforeDelay)
                    && cooldownCheck(fatalBlitzBeforeDelay)
                    && cooldownCheck(sneakySnipingEnchantBeforeDelay)
                    && cooldownCheck(sneakySnipingBeforeDelay)
                    && cooldownCheck(thanatosDescentFinish)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(strikeArrowList.get(i % 3));
                    i++;
                }
                if (cooldownCheck(grandisGoddessBlessingNova)) {
                    if (getStart().before(new Timestamp(10 * 1000))) {
                        grandisGoddessBlessingNova.setCooldown(360.0);
                    } else if (getStart().after(new Timestamp(5 * 60 * 1000))) {
                        grandisGoddessBlessingNova.setCooldown(180.0);
                    }
                    addSkillEvent(grandisGoddessBlessingNova);
                }
                addSkillEvent(incarnation);
                addSkillEvent(thanatosDescentBuff);
                addSkillEvent(criticalReinforce);
                addSkillEvent(gripOfAgony);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(dragonBurstBeforeDelay);
                if (cooldownCheck(annihilation)) {
                    addSkillEvent(annihilation);
                }
                addSkillEvent(fatalBlitzBeforeDelay);
                addSkillEvent(possession);
                addSkillEvent(sneakySnipingEnchantBeforeDelay);
                addSkillEvent(sneakySnipingBeforeDelay);
                addSkillEvent(thanatosDescentFinish);
            } else if (
                    cooldownCheck(gripOfAgony)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(weaponJumpRing)
                    && cooldownCheck(dragonBurstBeforeDelay)
                    && cooldownCheck(fatalBlitzBeforeDelay)
                    && cooldownCheck(sneakySnipingEnchantBeforeDelay)
                    && cooldownCheck(sneakySnipingBeforeDelay)
            ) {
                addSkillEvent(gripOfAgony);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(dragonBurstBeforeDelay);
                addSkillEvent(fatalBlitzBeforeDelay);
                addSkillEvent(possession);
                addSkillEvent(sneakySnipingEnchantBeforeDelay);
                addSkillEvent(sneakySnipingBeforeDelay);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(sneakySnipingBeforeDelay)
                    && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(sneakySnipingBeforeDelay);
            } else if (
                    cooldownCheck(fallingDustEnchant)
                    && malice >= 100
            ) {
                addSkillEvent(possession);
                addSkillEvent(fallingDustEnchant);
                if (cooldownCheck(poisonNeedle)) {
                    addSkillEvent(poisonNeedle);
                } else if (cooldownCheck(chainSickle)) {
                    addSkillEvent(chainSickle);
                } else if (cooldownCheck(tearingKnife)) {
                    addSkillEvent(tearingKnife);
                } else {
                    addSkillEvent(phantomBlade);
                }
            } else if (
                    cooldownCheck(scatteringShotEnchant)
                    && malice >= 100
            ) {
                addSkillEvent(possession);
                addSkillEvent(scatteringShotEnchant);
                if (cooldownCheck(poisonNeedle)) {
                    addSkillEvent(poisonNeedle);
                } else if (cooldownCheck(chainSickle)) {
                    addSkillEvent(chainSickle);
                } else if (cooldownCheck(tearingKnife)) {
                    addSkillEvent(tearingKnife);
                } else {
                    addSkillEvent(phantomBlade);
                }
            } else if (
                    cooldownCheck(shaftBreakEnchant)
                    && malice >= 100
            ) {
                addSkillEvent(possession);
                addSkillEvent(shaftBreakEnchant);
                if (cooldownCheck(poisonNeedle)) {
                    addSkillEvent(poisonNeedle);
                } else if (cooldownCheck(chainSickle)) {
                    addSkillEvent(chainSickle);
                } else if (cooldownCheck(tearingKnife)) {
                    addSkillEvent(tearingKnife);
                } else {
                    addSkillEvent(phantomBlade);
                }
            } else if (
                    cooldownCheck(strikeArrowEnchant)
                    && malice >= 100
            ) {
                addSkillEvent(possession);
                addSkillEvent(strikeArrowEnchant);
                if (cooldownCheck(poisonNeedle)) {
                    addSkillEvent(poisonNeedle);
                } else if (cooldownCheck(chainSickle)) {
                    addSkillEvent(chainSickle);
                } else if (cooldownCheck(tearingKnife)) {
                    addSkillEvent(tearingKnife);
                } else {
                    addSkillEvent(phantomBlade);
                }
            } else if (
                    cooldownCheck(scatteringShot)
            ) {
                addSkillEvent(scatteringShot);
            } else if (
                    cooldownCheck(fallingDust)
            ) {
                addSkillEvent(fallingDust);
            } else if (
                    cooldownCheck(chasingShot)
            ) {
                addSkillEvent(chasingShot);
            } else {
                addSkillEvent(strikeArrowList.get(i % 3));
                i++;
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
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof CriticalReinforce) {
                    isCriticalReinforce = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof Incarnation) {
                    isIncarnation = true;
                    break;
                }
            }
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof AnnihilationBuff) {
                    isAnnihilation = true;
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
            isCriticalReinforce = false;
        }
        for (AttackSkill as : getAttackSkillList()) {
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
        if (
                isAnnihilation
                && skillEvent.getSkill() instanceof DeathBlessing
        ) {
            skillEvent.setSkill(new DeathBlessing());
            ((DeathBlessing) skillEvent.getSkill()).setDamage(725.0);
        }
        if (
                isIncarnation
                && skillEvent.getSkill() instanceof DeathBlessing
        ) {
            if (!isAnnihilation) {
                skillEvent.setSkill(new DeathBlessing());
            }
            ((DeathBlessing) skillEvent.getSkill()).setAttackCount(13L);
            if (isAnnihilation) {
                ((DeathBlessing) skillEvent.getSkill()).setAttackCount(15L);
                ((DeathBlessing) skillEvent.getSkill()).setDamage(755.0);
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
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
                            * (1 - 0.5 * (1 - (getJob().getProperty() - buffSkill.getBuffProperty()) * 0.01))
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
        if (skillEvent.getSkill() instanceof DeathBlessing) {
            ((DeathBlessing) skillEvent.getSkill()).setAttackCount(10L);
            ((DeathBlessing) skillEvent.getSkill()).setDamage(308.0);
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

        if (
                cooldownCheck(possessionMalice)
                && !(skill instanceof PossessionMalice)
        ) {
            addSkillEvent(possessionMalice);
        }
        if (skill instanceof PossessionMalice) {
            malice += 30;
            if (getStart().before(thanatosDescentEndTime)) {
                malice += 10;
            }
            if (malice > 500) {
                malice = 500;
            }
        }
        if (
                getStart().before(annihilationBuffEndTime)
                && cooldownCheck(annihilationDeathBlessing)
                && !(skill instanceof AnnihilationDeathBlessing)
                && !(skill instanceof PossessionMalice)
        ) {
            addSkillEvent(annihilationDeathBlessing);
        }
        if (skill instanceof AnnihilationDeathBlessing) {
            deathBlessingCnt ++;
        }
        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof GrandisGoddessBlessingNova) {
                reuseCnt = 6;
                grandisGoddessBlessingEndTime = new Timestamp(getStart().getTime() + 40000);
            }
            if (skill instanceof AnnihilationBuff) {
                annihilationBuffEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (skill instanceof DeathBlessingContributionBuff) {
                deathBlessingContributionBuffEndTime = new Timestamp(getStart().getTime() + 5000);
            }
            if (skill instanceof ThanatosDescentBuff) {
                thanatosDescentEndTime = new Timestamp(getStart().getTime() + 35000);
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
            }
            if (
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
            if (
                    skill instanceof FatalBlitzBeforeDelay
                    || skill instanceof FatalBlitzLoop
                    || skill instanceof FatalBlitzAfterDelay
            ) {
                addSkillEvent(new DeathBlessingContributionBuff());
            }
            if (
                    skill instanceof StrikeArrowEnchant
                    || skill instanceof ScatteringShotEnchant
                    || skill instanceof ShaftBreakEnchant
                    || skill instanceof FallingDustEnchant
            ) {
                if (getStart().before(annihilationBuffEndTime)) {
                    if (deathBlessingCnt < 20) {
                        deathBlessingCnt++;
                    }
                } else {
                    if (deathBlessingCnt < 15) {
                        deathBlessingCnt++;
                    }
                }
            }
            if (
                    deathBlessingCnt > 0
                    && (
                            skill instanceof PhantomBlade
                            || skill instanceof TearingKnife
                            || skill instanceof ChainSickle
                            || skill instanceof ChainSickleFinish
                            || skill instanceof PoisonNeedle
                            || skill instanceof PoisonNeedleLoop
                            || skill instanceof PoisonNeedleFinish
                            || skill instanceof SneakySnipingEnchant
                    )
            ) {
                int cnt = 1;
                if (skill instanceof PoisonNeedleLoop) {
                    cnt = 4;
                } else if (skill instanceof SneakySnipingEnchant) {
                    cnt = 5;
                }
                for (int k = 0; k < cnt; k++) {
                    deathBlessingCnt--;
                    addSkillEvent(deathBlessing);
                    if (
                            getStart().before(annihilationBuffEndTime)
                                    && cooldownCheck(annihilationDragonBreath)
                    ) {
                        addSkillEvent(annihilationDragonBreath);
                    }
                }
            }
            if (skill instanceof StrikeArrowEnchant) {
                remainIncenseCnt ++;
            }
            if (skill instanceof ScatteringShotEnchant) {
                remainIncenseCnt += 2;
            }
            if (skill instanceof ShaftBreakEnchant) {
                remainIncenseCnt += 6;
            }
            if (
                    skill instanceof FallingDustEnchant
                    || skill instanceof SneakySnipingEnchant
                    || skill instanceof DragonBurstLoop
            ) {
                remainIncenseCnt += 8;
            }
            if (skill instanceof ThanatosDescentFinish) {
                remainIncenseCnt += 10;
            }
            if (
                    skill instanceof StrikeArrow1
                    || skill instanceof StrikeArrow2
                    || skill instanceof StrikeArrow3
                    || skill instanceof StrikeArrowEnchant
                    || skill instanceof ScatteringShot
                    || skill instanceof ScatteringShotEnchant
                    || skill instanceof ShaftBreak
                    || skill instanceof ShaftBreakEnchant
                    || skill instanceof FallingDust
                    || skill instanceof FallingDustEnchant
                    || skill instanceof ChasingShot
                    || skill instanceof SneakySniping
                    || skill instanceof SneakySnipingEnchant
                    || skill instanceof Annihilation
                    || skill instanceof AnnihilationFinish
            ) {
                malice += 18;
                if (getStart().before(thanatosDescentEndTime)) {
                    malice += 17;
                }
                if (malice > 500) {
                    malice = 500;
                }
            }
            if (
                    getStart().before(deathBlessingContributionBuffEndTime)
                    && (
                            skill instanceof PhantomBlade
                            || skill instanceof TearingKnife
                            || skill instanceof ChainSickle
                            || skill instanceof PoisonNeedle
                    )
            ) {
                malice += 12;
                if (malice > 500) {
                    malice = 500;
                }
            }
            if (
                    getStart().before(deathBlessingContributionBuffEndTime)
                    && skill instanceof FatalBlitzLoop
            ) {
                malice += 12 * 14;
                if (malice > 500) {
                    malice = 500;
                }
            }
            if (skill instanceof Possession) {
                malice -= 100;
            }
            if (
                    skill instanceof Annihilation
                    || skill instanceof AnnihilationFinish
                    || skill instanceof ChainSickle
                    || skill instanceof ChainSickleFinish
                    || skill instanceof ChasingShot
                    || skill instanceof DragonBurstAfterDelay
                    || skill instanceof DragonBurstBeforeDelay
                    || skill instanceof DragonBurstLoop
                    || skill instanceof FallingDust
                    || skill instanceof FallingDustEnchant
                    || skill instanceof FallingDustEnchantMalice
                    || skill instanceof FatalBlitzAfterDelay
                    || skill instanceof FatalBlitzBeforeDelay
                    || skill instanceof FatalBlitzLoop
                    || skill instanceof PhantomBlade
                    || skill instanceof PoisonNeedle
                    || skill instanceof PoisonNeedleFinish
                    || skill instanceof PoisonNeedleLoop
                    || skill instanceof ScatteringShot
                    || skill instanceof ScatteringShotEnchant
                    || skill instanceof ShaftBreak
                    || skill instanceof ShaftBreakBomb
                    || skill instanceof ShaftBreakEnchant
                    || skill instanceof ShaftBreakEnchantBomb
                    || skill instanceof ShaftBreakEnchantTornado
                    || skill instanceof SneakySniping
                    || skill instanceof SneakySnipingBeforeDelay
                    || skill instanceof SneakySnipingEnchant
                    || skill instanceof SneakySnipingEnchantBeforeDelay
                    || skill instanceof StrikeArrow1
                    || skill instanceof StrikeArrow2
                    || skill instanceof StrikeArrow3
                    || skill instanceof StrikeArrowEnchant
                    || skill instanceof TearingKnife
            ) {
                if (
                        cooldownCheck(dragonFang1)
                        || cooldownCheck(dragonFang2)
                        || cooldownCheck(dragonFang3)
                ) {
                    addSkillEvent(dragonFang1);
                    addSkillEvent(dragonFang2);
                    addSkillEvent(dragonFang3);
                }
                if (cooldownCheck(remainIncense)) {
                    remainIncense = new RemainIncense();
                    remainIncense.setAttackCountByCnt(remainIncenseCnt);
                    remainIncenseCnt = 0;
                    addSkillEvent(remainIncense);
                }
                if (
                        getStart().before(thanatosDescentEndTime)
                        && cooldownCheck(thanatosDescentDeathArrow)
                ) {
                    addSkillEvent(thanatosDescentDeathArrow);
                }
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (skill instanceof DragonFang) {
                        break;
                    }
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof ShaftBreakEnchantTornado) {
                        i = 1500;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (skill instanceof DragonBurstLoop) {
                            if (getStart().before(annihilationBuffEndTime)) {
                                if (deathBlessingCnt < 20) {
                                    deathBlessingCnt++;
                                }
                            } else {
                                if (deathBlessingCnt < 15) {
                                    deathBlessingCnt++;
                                }
                            }
                        }
                        if (skill instanceof FatalBlitzLoop && deathBlessingCnt > 0) {
                            deathBlessingCnt--;
                            getSkillEventList().add(new SkillEvent(deathBlessing, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            if (attackCount % 4 == 0) {
                                getSkillEventList().add(new SkillEvent(annihilationDragonBreath, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                            }
                        }
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
        if (
                getStart().before(annihilationBuffEndTime)
                && skill instanceof FatalBlitzLoop
        ) {
            applyCooldown(annihilationDragonBreath);
            chainSickle.setActivateTime(new Timestamp(chainSickle.getActivateTime().getTime() - 3000));
            fatalBlitzBeforeDelay.setActivateTime(new Timestamp(fatalBlitzBeforeDelay.getActivateTime().getTime() - 3000));
            phantomBlade.setActivateTime(new Timestamp(phantomBlade.getActivateTime().getTime() - 3000));
            poisonNeedle.setActivateTime(new Timestamp(poisonNeedle.getActivateTime().getTime() - 3000));
            tearingKnife.setActivateTime(new Timestamp(tearingKnife.getActivateTime().getTime() - 3000));
        }
        if (
                getStart().before(annihilationBuffEndTime)
                && skill instanceof AnnihilationDragonBreath
        ) {
            chainSickle.setActivateTime(new Timestamp(chainSickle.getActivateTime().getTime() - 1000));
            fatalBlitzBeforeDelay.setActivateTime(new Timestamp(fatalBlitzBeforeDelay.getActivateTime().getTime() - 1000));
            phantomBlade.setActivateTime(new Timestamp(phantomBlade.getActivateTime().getTime() - 1000));
            poisonNeedle.setActivateTime(new Timestamp(poisonNeedle.getActivateTime().getTime() - 1000));
            tearingKnife.setActivateTime(new Timestamp(tearingKnife.getActivateTime().getTime() - 1000));
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
            if (skill instanceof ThanatosDescentFinish) {
                if (getStart().before(annihilationBuffEndTime)) {
                    if (deathBlessingCnt < 20) {
                        deathBlessingCnt++;
                    }
                } else {
                    if (deathBlessingCnt < 15) {
                        deathBlessingCnt++;
                    }
                }
            }
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }

    @Override
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (
                        getStart().before(grandisGoddessBlessingEndTime)
                                && reuseCnt > 0
                ) {
                    ran -= 55;
                }
                if (ran <= getJob().getReuse()) {
                    reuseCnt--;
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
