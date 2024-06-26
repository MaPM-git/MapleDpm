package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.flamewizard.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.flamewizard.BurningRegion;
import org.mapledpmlab.type.skill.buffskill.flamewizard.PhoenixDrive;
import org.mapledpmlab.type.skill.buffskill.flamewizard.SalamanderMischiefBuff;
import org.mapledpmlab.type.skill.buffskill.flamewizard.SpiritOfFlame;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FlameWizardDealCycle extends DealCycle {

    /*
    https://www.inven.co.kr/board/maple/2295/209443
     */

    // 리레, 스인미, 크오솔
    private final List<Skill> dealCycle1 = new ArrayList<>();

    // 웨펖, 초시축
    private final List<Skill> dealCycle2 = new ArrayList<>();

    // 웨펖
    private final List<Skill> dealCycle3 = new ArrayList<>();

    // 극딜 마지막, 6차 포함
    private final List<Skill> final1 = new ArrayList<>();

    // 극딜 마지막
    private final List<Skill> final2 = new ArrayList<>();

    // 극딜 마지막
    private final List<Skill> final3 = new ArrayList<>();

    // 극딜 마지막
    private final List<Skill> final4 = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BlazingExtinction());
            add(new BlazingOrbitalFlame());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanx());
            add(new Eternity());
            add(new EternityCirculation());
            add(new FlameDischarge(0L));
            add(new InfernoRize());
            add(new InfernoRizeFoxPrank());
            add(new InfinityFlameCircle());
            add(new OrbitalExplosion());
            add(new OrbitalFlame());
            add(new OrbitalFlameDot());
            add(new OrbitalFlameReinforce());
            add(new PhoenixDriveAfterSecond());
            add(new PhoenixDriveFirst());
            add(new SalamanderMischief(0L));
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new CygnusPhalanxDelay());
            add(new FlameDischarge(0L));
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BurningRegion());
            add(new GloryOfGuardians());
            add(new PhoenixDrive());
            add(new PriorPreparation());
            add(new RestraintRing());
            add(new SalamanderMischiefBuff());
            add(new SoulContract());
            add(new SpiritOfFlame());
            add(new ThiefCunning());
            add(new TranscendentCygnusBlessing(0L));
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int orbitalExplosionCount = 0;
    int flameCount = 0;
    int emberCount = 0;
    Timestamp finalTime = new Timestamp(-1);
    Timestamp phoenixDriveEndTime = new Timestamp(-1);
    FlameDischarge flameDischarge = new FlameDischarge(0L);
    SalamanderMischief salamanderMischief = new SalamanderMischief(0L);
    SalamanderMischiefBuff salamanderMischiefBuff = new SalamanderMischiefBuff();

    public FlameWizardDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        BlazingExtinction blazingExtinction = new BlazingExtinction();
        BlazingOrbitalFlame blazingOrbitalFlame = new BlazingOrbitalFlame();
        BurningRegion burningRegion = new BurningRegion();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
        Eternity eternity = new Eternity();
        GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
        InfernoRize infernoRize = new InfernoRize();
        InfinityFlameCircle infinityFlameCircle = new InfinityFlameCircle();
        OrbitalFlame orbitalFlame = new OrbitalFlame();
        OrbitalFlameDot orbitalFlameDot = new OrbitalFlameDot();
        OrbitalFlameReinforce orbitalFlameReinforce = new OrbitalFlameReinforce();
        PhoenixDrive phoenixDrive = new PhoenixDrive();
        PhoenixDriveFirst phoenixDriveFirst = new PhoenixDriveFirst();
        PriorPreparation priorPreparation = new PriorPreparation();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiritOfFlame spiritOfFlame = new SpiritOfFlame();
        ThiefCunning thiefCunning = new ThiefCunning();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(120.0);

        // 초시축 1,3,4,5 극딜에만 사용
        // 리스트레인트 극딜 예열 - F1 1,3,5
        //dealCycle1.add(flameDischarge);
        dealCycle1.add(burningRegion);
        dealCycle1.add(gloryOfGuardians);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(salamanderMischief);

        // 웨폰퍼프, 초시축 극딜 예열 - F2 4
        //dealCycle2.add(flameDischarge);
        dealCycle2.add(burningRegion);
        dealCycle2.add(gloryOfGuardians);
        dealCycle2.add(salamanderMischief);

        // 웨폰퍼프 - F2 2,6
        //dealCycle3.add(flameDischarge);
        dealCycle3.add(burningRegion);
        dealCycle3.add(gloryOfGuardians);
        dealCycle3.add(salamanderMischief);

        // 예열 후 사용(6차)
        final1.add(flameDischarge);
        final1.add(soulContract);
        final1.add(eternity);
        final1.add(restraintRing);
        final1.add(blazingOrbitalFlame);
        final1.add(infinityFlameCircle);
        final1.add(phoenixDrive);

        // 예열 후 사용
        final2.add(flameDischarge);
        final2.add(soulContract);
        final2.add(eternity);
        final2.add(weaponJumpRing);
        final2.add(blazingOrbitalFlame);
        final2.add(infinityFlameCircle);
        final2.add(phoenixDrive);

        // 예열 후 사용
        final3.add(flameDischarge);
        final3.add(soulContract);
        final3.add(restraintRing);
        final3.add(blazingOrbitalFlame);
        final3.add(infinityFlameCircle);
        final3.add(phoenixDrive);

        // 예열 후 사용
        final4.add(flameDischarge);
        final4.add(soulContract);
        final4.add(weaponJumpRing);
        final4.add(blazingOrbitalFlame);
        final4.add(infinityFlameCircle);
        final4.add(phoenixDrive);

        int finalChk = -1;
        int infernoRizeCount = 0;
        int orbitalCount = 0;
        int dealCycleOrder = 1;

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);

        boolean isUse = false;

        flameCount = 150;
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 10000))
                    && (
                            dealCycleOrder == 3
                            || dealCycleOrder == 4
                            || dealCycleOrder == 5
                    )
                    && !isUse
            ) {
                addSkillEvent(transcendentCygnusBlessing);
                isUse = true;
            }
            if (cooldownCheck(spiritOfFlame)) {
                addSkillEvent(spiritOfFlame);
            }
            if (
                    cooldownCheck(cygnusPhalanx)
            ) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && (dealCycleOrder == 1 || dealCycleOrder == 3 || dealCycleOrder == 5)
                    && flameCount >= 50
            ) {
                emberCount = 0;
                addDealCycle(dealCycle1);
                finalTime = new Timestamp(getStart().getTime() + 43000);
                if (dealCycleOrder == 1) {
                    finalChk = 1;
                }
                if (dealCycleOrder == 3 || dealCycleOrder == 5) {
                    finalChk = 3;
                }
                dealCycleOrder++;
                isUse = false;
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && dealCycleOrder == 4
                    && flameCount >= 50
            ) {
                emberCount = 0;
                addDealCycle(dealCycle2);
                finalTime = new Timestamp(getStart().getTime() + 43000);
                finalChk = 2;
                dealCycleOrder++;
                isUse = false;
            } else if (
                    cooldownCheck(dealCycle3)
                    && (dealCycleOrder == 2 || dealCycleOrder == 6)
                    && flameCount >= 50
            ) {
                emberCount = 0;
                addDealCycle(dealCycle3);
                finalTime = new Timestamp(getStart().getTime() + 43000);
                finalChk = 4;
                dealCycleOrder++;
                isUse = false;
            } else if (
                    //getStart().after(new Timestamp(finalTime.getTime() - 27000))
                    finalChk == 1
                    //&& flameCount >= 50
                    && cooldownCheck(final1)
            ) {
                addDealCycle(final1);
                phoenixDriveEndTime = new Timestamp(getStart().getTime() + 15000 - 480);
                finalChk = -1;
            } else if (
                    //getStart().after(new Timestamp(finalTime.getTime() - 27000))
                    finalChk == 2
                    //&& flameCount >= 50
                    && cooldownCheck(final2)
            ) {
                addDealCycle(final2);
                phoenixDriveEndTime = new Timestamp(getStart().getTime() + 15000 - 480);
                finalChk = -1;
            } else if (
                    //getStart().after(new Timestamp(finalTime.getTime() - 27000))
                    finalChk == 3
                    //&& flameCount >= 50
                    && cooldownCheck(final3)
            ) {
                addDealCycle(final3);
                phoenixDriveEndTime = new Timestamp(getStart().getTime() + 15000 - 480);
                finalChk = -1;
            } else if (
                    //getStart().after(new Timestamp(finalTime.getTime() - 27000))
                    finalChk == 4
                    //&& flameCount >= 50
                    && cooldownCheck(final4)
            ) {
                addDealCycle(final4);
                phoenixDriveEndTime = new Timestamp(getStart().getTime() + 15000 - 480);
                finalChk = -1;
            } else if (
                    cooldownCheck(soulContract)
                    && (
                            (
                                    getStart().after(new Timestamp(30 * 1000))
                                    && getStart().before(new Timestamp(90 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(150 * 1000))
                                    && getStart().before(new Timestamp(210 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(280 * 1000))
                                    && getStart().before(new Timestamp(340 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(400 * 1000))
                                    && getStart().before(new Timestamp(460 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(540 * 1000))
                                    && getStart().before(new Timestamp(580 * 1000))
                            )
                            ||
                            (
                                    getStart().after(new Timestamp(660 * 1000))
                                    && getStart().before(new Timestamp(720 * 1000))
                            )
                    )
                    && getStart().before(new Timestamp(690 * 1000))
            ) {
                addSkillEvent(burningRegion);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(flameDischarge)
                    && getStart().before(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 18000))
                    && getStart().before(new Timestamp(phoenixDrive.getActivateTime().getTime() - 18000))
                    && getStart().after(phoenixDriveEndTime)
                    && flameCount >= 50
            ) {
                addSkillEvent(flameDischarge);
            } else if (
                    cooldownCheck(blazingOrbitalFlame)
                    && cooldownCheck(blazingExtinction)
                    && getStart().after(phoenixDriveEndTime)
                    && !cooldownCheck(burningRegion)
            ) {
                addSkillEvent(blazingOrbitalFlame);
                addSkillEvent(blazingExtinction);
            } else {
                if (orbitalCount % 4 == 0) {
                    addSkillEvent(orbitalFlameReinforce);
                } else {
                    addSkillEvent(orbitalFlame);
                }
                orbitalCount++;
                if (getStart().before(phoenixDriveEndTime)) {
                    addSkillEvent(phoenixDriveFirst);
                }

                if (infernoRizeCount != 50) {
                    infernoRizeCount++;
                }
                if (
                        infernoRizeCount >= 0
                        && cooldownCheck(infernoRize)
                        && getStart().after(phoenixDriveEndTime)
                ) {
                    addSkillEvent(infernoRize);
                    infernoRizeCount = 0;
                }
                if (cooldownCheck(orbitalFlameDot)) {
                    addSkillEvent(orbitalFlameDot);
                }
            }
        }
        sortEventTimeList();
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
                if (skill instanceof TranscendentCygnusBlessing) {
                    for (long i = 0; i < 45000; i += 4000) {
                        getSkillEventList().add(new SkillEvent(new TranscendentCygnusBlessing(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 4000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 4000));
                    }
                }
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (skill instanceof SalamanderMischief) {
                this.getSkillEventList().add(
                        new SkillEvent(
                                salamanderMischiefBuff,
                                new Timestamp(getStart().getTime() + 60000 - 750),
                                new Timestamp(getStart().getTime() + 60000 + 30000 - 750)
                        )
                );
                this.getEventTimeList().add(new Timestamp(getStart().getTime() + 60000 - 750));
                this.getEventTimeList().add(new Timestamp(getStart().getTime() + 60000 + 30000 - 750));
            }
            if (skill instanceof FlameDischarge) {
                flameDischarge = new FlameDischarge((long) flameCount / 25);
                flameCount = 0;
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
                        if (skill instanceof SalamanderMischief) {
                            skill = new SalamanderMischief((long) emberCount);
                            if (emberCount < 45) {
                                emberCount++;
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
            if (
                    skill instanceof OrbitalFlame
                    || skill instanceof OrbitalFlameDot
                    || skill instanceof OrbitalFlameReinforce
                    || skill instanceof PhoenixDriveFirst
                    || skill instanceof PhoenixDriveAfterSecond
                    || skill instanceof BlazingOrbitalFlame
                    || skill instanceof InfinityFlameCircle
            ) {
                if (((AttackSkill) skill).getLimitAttackCount() != 0) {
                    orbitalExplosionCount = orbitalExplosionCount + ((AttackSkill) skill).getLimitAttackCount().intValue();
                } else {
                    orbitalExplosionCount++;
                }
                if (orbitalExplosionCount % 10 == 0) {
                    addSkillEvent(new OrbitalExplosion());
                    orbitalExplosionCount = orbitalExplosionCount - 10;
                }
            }
            if (
                    skill instanceof Eternity
                            || skill instanceof EternityCirculation
                            || skill instanceof OrbitalFlame
                            || skill instanceof OrbitalFlameReinforce
                            || skill instanceof PhoenixDriveFirst
                            || skill instanceof PhoenixDriveAfterSecond
                            || skill instanceof InfernoRize
                            || skill instanceof InfinityFlameCircle
            ) {
                if (((AttackSkill) skill).getLimitAttackCount() != 0) {
                    flameCount = flameCount + ((AttackSkill) skill).getLimitAttackCount().intValue();
                } else {
                    flameCount++;
                }
                if (flameCount > 150) {
                    flameCount = 150;
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

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        if (
                attackSkill instanceof BlazingExtinction
                || attackSkill instanceof BlazingOrbitalFlame
                || attackSkill instanceof CygnusPhalanx
                || attackSkill instanceof Eternity
                || attackSkill instanceof EternityCirculation
                || attackSkill instanceof FlameDischarge
                || attackSkill instanceof InfernoRize
                || attackSkill instanceof InfinityFlameCircle
                || attackSkill instanceof OrbitalFlame
                || attackSkill instanceof OrbitalFlameDot
                || attackSkill instanceof OrbitalFlameReinforce
                || attackSkill instanceof PhoenixDriveAfterSecond
                || attackSkill instanceof PhoenixDriveFirst
                || attackSkill instanceof SalamanderMischief
        ) {
            buffSkill.addBuffFinalDamage(1.08);
        }
        for (AttackSkill as : attackSkillList) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                attackDamage = (long) Math.floor(((this.getJob().getFinalMainStat()) * 4
                        + this.getJob().getFinalSubstat()) * 0.01
                        * (Math.floor((this.getJob().getMagic() + buffSkill.getBuffAttMagic())
                        * (1 + (this.getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
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
        if (
                attackSkill instanceof BlazingExtinction
                        || attackSkill instanceof BlazingOrbitalFlame
                        || attackSkill instanceof CygnusPhalanx
                        || attackSkill instanceof Eternity
                        || attackSkill instanceof EternityCirculation
                        || attackSkill instanceof FlameDischarge
                        || attackSkill instanceof InfernoRize
                        || attackSkill instanceof InfinityFlameCircle
                        || attackSkill instanceof OrbitalFlame
                        || attackSkill instanceof OrbitalFlameDot
                        || attackSkill instanceof OrbitalFlameReinforce
                        || attackSkill instanceof PhoenixDriveAfterSecond
                        || attackSkill instanceof PhoenixDriveFirst
                        || attackSkill instanceof SalamanderMischief
        ) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.08);
        }
        return attackDamage;
    }
}
