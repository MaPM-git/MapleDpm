package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
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

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new BlazingExtinction());
            add(new BlazingOrbitalFlame());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CygnusPhalanxDelay());
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

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new BurningRegion());
            add(new GloryOfGuardians());
            add(new PhoenixDrive());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SalamanderMischiefBuff());
            add(new SoulContract());
            add(new SpiritOfFlame());
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
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        SpiritOfFlame spiritOfFlame = new SpiritOfFlame();
        TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        ringSwitching.setCooldown(120.0);
        ringSwitching.setApplyCooldownReduction(false);

        int infernoRizeCount = 0;
        int orbitalCount = 0;
        int dealCycleOrder = 1;

        transcendentCygnusBlessing.setCooldown(360.0);
        transcendentCygnusBlessing.setApplyCooldownReduction(false);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);

        flameCount = 150;
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(transcendentCygnusBlessing)
                    && getStart().after(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 10000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                if (dealCycleOrder == 1) {
                    transcendentCygnusBlessing.setCooldown(360.0);
                } else if (dealCycleOrder == 4) {
                    transcendentCygnusBlessing.setCooldown(120.0);
                } else {
                    transcendentCygnusBlessing.setCooldown(240.0);
                }
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (cooldownCheck(spiritOfFlame)) {
                addSkillEvent(spiritOfFlame);
            }
            if (cooldownCheck(cygnusPhalanx)) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(burningRegion)
                    && cooldownCheck(gloryOfGuardians)
                    && cooldownCheck(salamanderMischief)
                    && cooldownCheck(flameDischarge)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(blazingOrbitalFlame)
                    && cooldownCheck(infinityFlameCircle)
                    && cooldownCheck(phoenixDrive)
            ) {
                addSkillEvent(burningRegion);
                addSkillEvent(gloryOfGuardians);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    if (orbitalCount % 4 == 0) {
                        addSkillEvent(orbitalFlameReinforce);
                    } else {
                        addSkillEvent(orbitalFlame);
                    }
                    orbitalCount++;
                    if (infernoRizeCount != 50) {
                        infernoRizeCount++;
                    }
                    if (cooldownCheck(orbitalFlameDot)) {
                        addSkillEvent(orbitalFlameDot);
                    }
                }
                addSkillEvent(salamanderMischief);
                addSkillEvent(flameDischarge);
                addSkillEvent(soulContract);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                if (cooldownCheck(eternity)) {
                    addSkillEvent(eternity);
                }
                addSkillEvent(blazingOrbitalFlame);
                addSkillEvent(infinityFlameCircle);
                addSkillEvent(phoenixDrive);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(soulContract)
                    && getStart().before(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 50000))
            ) {
                addSkillEvent(burningRegion);
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(100 * 1000))
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(flameDischarge)
                    && flameCount >= 50
                    && !cooldownCheck(gloryOfGuardians)
            ) {
                addSkillEvent(flameDischarge);
            } else if (
                    cooldownCheck(blazingOrbitalFlame)
                    && cooldownCheck(blazingExtinction)
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
                skill = flameDischarge;
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof FlameDischarge) {
                        i = skill.getDelay();
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
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
                    skill instanceof OrbitalFlame
                    || skill instanceof OrbitalFlameReinforce
                    || skill instanceof PhoenixDriveFirst
                    || skill instanceof PhoenixDriveAfterSecond
                    || skill instanceof BlazingOrbitalFlame
                    || skill instanceof InfinityFlameCircle
            ) {
                if (((AttackSkill) skill).getLimitAttackCount() != 0) {
                    flameCount = flameCount + ((AttackSkill) skill).getLimitAttackCount().intValue();
                    if (skill instanceof BlazingOrbitalFlame) {
                        flameCount -= 2;
                    }
                } else if (((AttackSkill) skill).getMultiAttackInfo().size() != 0) {
                    flameCount = flameCount + ((AttackSkill) skill).getMultiAttackInfo().size();
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
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
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
