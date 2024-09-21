package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
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
            add(new AnnihilationFinish());
            add(new AnnihilationDragonBreath());
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
            add(new PoisonNeedleLoop());
            add(new PoisonNeedleFinish());
            add(new PoisonNeedleDot());
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
            add(new CriticalReinforce(0.0));
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

    boolean isAnnihilation = false;
    boolean isCriticalReinforce = false;
    boolean isDeathBlessingContribution = false;
    boolean isIncarnation = false;

    int deathBlessingCnt = 15;
    int malice = 500;
    int remainIncenseCnt = 0;
    int reuseCnt = 0;

    Timestamp annihilationBuffEndTime = new Timestamp(-1);
    Timestamp deathBlessingContributionBuffEndTime = new Timestamp(-1);
    Timestamp grandisGoddessBlessingEndTime = new Timestamp(-1);
    Timestamp thanatosDescentEndTime = new Timestamp(-1);
    Timestamp thanatosDescentFinishTime = new Timestamp(-1);

    List<AttackSkill> strikeArrowList = new ArrayList<>();

    Annihilation annihilation = new Annihilation();
    AnnihilationDeathBlessing annihilationDeathBlessing = new AnnihilationDeathBlessing();
    AnnihilationDragonBreath annihilationDragonBreath = new AnnihilationDragonBreath();
    ChainSickle chainSickle = new ChainSickle();
    ChasingShot chasingShot = new ChasingShot();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CriticalReinforce criticalReinforce = new CriticalReinforce(0.0);
    DeathBlessing deathBlessing = new DeathBlessing();
    DragonBurstBeforeDelay dragonBurstBeforeDelay = new DragonBurstBeforeDelay();
    DragonFang dragonFang1 = new DragonFang();
    DragonFang dragonFang2 = new DragonFang();
    DragonFang dragonFang3 = new DragonFang();
    FallingDust fallingDust = new FallingDust();
    FallingDustEnchant fallingDustEnchant = new FallingDustEnchant();
    FatalBlitzBeforeDelay fatalBlitzBeforeDelay = new FatalBlitzBeforeDelay();
    GrandisGoddessBlessingNova grandisGoddessBlessingNova = new GrandisGoddessBlessingNova();
    GripOfAgony gripOfAgony = new GripOfAgony();
    GuidedArrow guidedArrow = new GuidedArrow();
    Incarnation incarnation = new Incarnation();
    PhantomBlade phantomBlade = new PhantomBlade();
    PoisonNeedle poisonNeedle = new PoisonNeedle();
    Possession possession = new Possession();
    PossessionMalice possessionMalice = new PossessionMalice();
    RemainIncense remainIncense = new RemainIncense();
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
    TearingKnife tearingKnife = new TearingKnife();
    ThanatosDescentBuff thanatosDescentBuff = new ThanatosDescentBuff();
    ThanatosDescentDeathArrow thanatosDescentDeathArrow = new ThanatosDescentDeathArrow();
    ThanatosDescentFinish thanatosDescentFinish = new ThanatosDescentFinish();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public KainDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(180.0);

        strikeArrowList.add(strikeArrow1);
        strikeArrowList.add(strikeArrow2);
        strikeArrowList.add(strikeArrow3);
        int i = 0;

        dragonFang2.setActivateTime(new Timestamp(3500L));
        dragonFang3.setActivateTime(new Timestamp(7000L));

        fallingDust.setActivateTime(new Timestamp(-10000));
        scatteringShot.setActivateTime(new Timestamp(-12000));
        shaftBreak.setActivateTime(new Timestamp(-16000));

        grandisGoddessBlessingNova.setCooldown(120.0);

        restraintRing.setActivateTime(new Timestamp(-60000));
    }

    @Override
    public void setSoloDealCycle() {
        addSkillEvent(guidedArrow);
        addSkillEvent(poisonNeedle);
        addSkillEvent(possession);
        addSkillEvent(shaftBreakEnchant);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(incarnation)
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
                addSkillEvent(grandisGoddessBlessingNova);
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
                while (getStart().before(new Timestamp(thanatosDescentFinishTime.getTime() - 4000))) {
                    kainPlatDealCycle();
                }
                addSkillEvent(thanatosDescentFinish);
            } else if (
                    cooldownCheck(gripOfAgony)
                    && !cooldownCheck(criticalReinforce)
            ) {
                addSkillEvent(gripOfAgony);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
                addSkillEvent(dragonBurstBeforeDelay);
                addSkillEvent(fatalBlitzBeforeDelay);
                addSkillEvent(possession);
                addSkillEvent(sneakySnipingEnchantBeforeDelay);
                if (cooldownCheck(sneakySnipingBeforeDelay)) {
                    addSkillEvent(sneakySnipingBeforeDelay);
                }
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(165 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(sneakySnipingBeforeDelay)
                            && !cooldownCheck(soulContract)
            ) {
                addSkillEvent(sneakySnipingBeforeDelay);
            } else {
                kainPlatDealCycle();
            }
        }
        sortEventTimeList();
    }

    public void kainPlatDealCycle() {
        if (
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
                        bs.setUseCount(bs.getUseCount() + 1);
                        bs.getStartTimeList().add(skillEvent.getStart());
                        bs.getEndTimeList().add(skillEvent.getEnd());
                    }
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
            for (int j = 0; j < useBuffSkillList.size(); j++) {
                if (useBuffSkillList.get(j).getSkill() instanceof DeathBlessingContributionBuff) {
                    isDeathBlessingContribution = true;
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
                if (
                        isDeathBlessingContribution
                        && (
                                se.getSkill() instanceof DeathBlessing
                                || se.getSkill() instanceof PhantomBlade
                                || se.getSkill() instanceof TearingKnife
                                || se.getSkill() instanceof ChainSickle
                                || se.getSkill() instanceof ChainSickleFinish
                                || se.getSkill() instanceof PoisonNeedle
                                || se.getSkill() instanceof PoisonNeedleFinish
                                || se.getSkill() instanceof PoisonNeedleLoop
                                || se.getSkill() instanceof FatalBlitzLoop
                        )
                ) {
                    buffSkill.addBuffFinalDamage(1.28);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (
                        isDeathBlessingContribution
                        && (
                                se.getSkill() instanceof DeathBlessing
                                || se.getSkill() instanceof PhantomBlade
                                || se.getSkill() instanceof TearingKnife
                                || se.getSkill() instanceof ChainSickle
                                || se.getSkill() instanceof ChainSickleFinish
                                || se.getSkill() instanceof PoisonNeedle
                                || se.getSkill() instanceof PoisonNeedleFinish
                                || se.getSkill() instanceof PoisonNeedleLoop
                                || se.getSkill() instanceof FatalBlitzLoop
                        )
                ) {
                    buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.28);
                }
            }
            isCriticalReinforce = false;
            isIncarnation = false;
            isAnnihilation = false;
            isDeathBlessingContribution = false;
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
            attackSkill = new DeathBlessing();
            attackSkill.setDamage(725.0);
        }
        if (
                isIncarnation
                && skillEvent.getSkill() instanceof DeathBlessing
        ) {
            if (!isAnnihilation) {
                attackSkill = new DeathBlessing();
            }
            attackSkill.setAttackCount(13L);
            if (isAnnihilation) {
                attackSkill.setAttackCount(15L);
                attackSkill.setDamage(755.0);
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
        if (skillEvent.getSkill() instanceof DeathBlessing) {
            attackSkill.setAttackCount(10L);
            attackSkill.setDamage(308.0);
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
            possessionMalice.setActivateTime(new Timestamp(possessionMalice.getActivateTime().getTime() + 4000));
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
            if (!(skill instanceof PossessionMalice)) {
                System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName());
            }
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t맬리스 : " + malice + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t맬리스 : " + malice + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof Possession) {
                malice -= 100;
            }
            if (skill instanceof RestraintRing) {
                thanatosDescentFinishTime = new Timestamp(getStart().getTime() + 15000);
            }
            if (skill instanceof GrandisGoddessBlessingNova) {
                reuseCnt = 6;
                grandisGoddessBlessingEndTime = new Timestamp(getStart().getTime() + 43000);
            }
            if (skill instanceof AnnihilationBuff) {
                annihilationBuffEndTime = new Timestamp(getStart().getTime() + 33000);
            }
            if (skill instanceof DeathBlessingContributionBuff) {
                deathBlessingContributionBuffEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (skill instanceof ThanatosDescentBuff) {
                thanatosDescentEndTime = new Timestamp(getStart().getTime() + 38000);
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
                thanatosDescentEndTime = new Timestamp(-1);
                remainIncenseCnt += 10;
            }
            if (
                    skill instanceof StrikeArrow1
                    || skill instanceof StrikeArrow2
                    || skill instanceof StrikeArrow3
                    || skill instanceof ScatteringShot
                    || skill instanceof ShaftBreak
                    || skill instanceof FallingDust
                    || skill instanceof ChasingShot
                    || skill instanceof SneakySniping
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
                    if (cooldownCheck(dragonFang1)) {
                        addSkillEvent(dragonFang1);
                    }
                    if (cooldownCheck(dragonFang2)) {
                        addSkillEvent(dragonFang2);
                    }
                    if (cooldownCheck(dragonFang3)) {
                        addSkillEvent(dragonFang3);
                    }
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
        if (skill instanceof FallingDust) {
            long remainTime = getStart().getTime() - skill.getActivateTime().getTime();
            if (remainTime >= 10000) {
                skill.setActivateTime(new Timestamp(getStart().getTime()));
            } else {
                skill.setActivateTime(new Timestamp(getStart().getTime() + 10000 - remainTime));
            }
            return;
        }
        if (skill instanceof ScatteringShot) {
            long remainTime = getStart().getTime() - skill.getActivateTime().getTime();
            if (remainTime >= 12000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 6000));
            } else if (remainTime >= 6000) {
                skill.setActivateTime(new Timestamp(getStart().getTime()));
            } else {
                skill.setActivateTime(new Timestamp(getStart().getTime() + 6000 - remainTime));
            }
            return;
        }
        if (skill instanceof ShaftBreak) {
            long remainTime = getStart().getTime() - skill.getActivateTime().getTime();
            if (remainTime >= 16000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 8000));
            } else if (remainTime >= 8000) {
                skill.setActivateTime(new Timestamp(getStart().getTime()));
            } else {
                skill.setActivateTime(new Timestamp(getStart().getTime() + 8000 - remainTime));
            }
            return;
        }
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Double ran = Math.random() * 99;
                if (ran <= getJob().getReuse()) {
                    return;
                } else {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            }
            if (
                    skill.isApplyReuse()
                            && getStart().before(grandisGoddessBlessingEndTime)
                            && reuseCnt > 0
            ) {
                Double ran = Math.random() * 99;
                if (ran <= getJob().getReuse()) {
                    return;
                } else {
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
