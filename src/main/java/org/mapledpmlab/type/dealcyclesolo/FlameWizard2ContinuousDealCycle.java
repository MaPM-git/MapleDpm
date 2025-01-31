package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.flamewizard.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.ContinuousRing;
import org.mapledpmlab.type.skill.buffskill.common.GloryOfGuardians;
import org.mapledpmlab.type.skill.buffskill.common.SoulContract;
import org.mapledpmlab.type.skill.buffskill.common.TranscendentCygnusBlessing;
import org.mapledpmlab.type.skill.buffskill.flamewizard.BurningRegion;
import org.mapledpmlab.type.skill.buffskill.flamewizard.PhoenixDrive;
import org.mapledpmlab.type.skill.buffskill.flamewizard.SalamanderMischiefBuff;
import org.mapledpmlab.type.skill.buffskill.flamewizard.SpiritOfFlame;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FlameWizard2ContinuousDealCycle extends DealCycle {

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
            add(new InfinityFlameCirclePre());
            add(new InfinityFlameCircle());
            add(new InfinityFlameCircle4());
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
            add(new ContinuousRing());
            add(new GloryOfGuardians());
            add(new PhoenixDrive());
            add(new SalamanderMischiefBuff());
            add(new SoulContract());
            add(new SpiritOfFlame());
            add(new TranscendentCygnusBlessing(0L));
        }
    };

    int emberCount = 0;
    int flameCount = 0;
    int infernoRizeCount = 0;
    int orbitalCount = 0;
    int orbitalExplosionCount = 0;

    boolean isNuke = false;

    Timestamp finalTime = new Timestamp(-1);
    Timestamp phoenixDriveEndTime = new Timestamp(-1);

    BlazingExtinction blazingExtinction = new BlazingExtinction();
    BlazingOrbitalFlame blazingOrbitalFlame = new BlazingOrbitalFlame();
    BurningRegion burningRegion = new BurningRegion();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CygnusPhalanx cygnusPhalanx = new CygnusPhalanx();
    Eternity eternity = new Eternity();
    FlameDischarge flameDischarge = new FlameDischarge(0L);
    GloryOfGuardians gloryOfGuardians = new GloryOfGuardians();
    InfernoRize infernoRize = new InfernoRize();
    InfinityFlameCirclePre infinityFlameCircle4 = new InfinityFlameCirclePre();
    InfinityFlameCirclePre infinityFlameCircle = new InfinityFlameCirclePre();
    OrbitalFlame orbitalFlame = new OrbitalFlame();
    OrbitalFlameDot orbitalFlameDot = new OrbitalFlameDot();
    OrbitalFlameReinforce orbitalFlameReinforce = new OrbitalFlameReinforce();
    PhoenixDrive phoenixDrive = new PhoenixDrive();
    PhoenixDriveFirst phoenixDriveFirst = new PhoenixDriveFirst();
    SalamanderMischief salamanderMischief = new SalamanderMischief(0L);
    SalamanderMischiefBuff salamanderMischiefBuff = new SalamanderMischiefBuff();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SpiritOfFlame spiritOfFlame = new SpiritOfFlame();
    TranscendentCygnusBlessing transcendentCygnusBlessing = new TranscendentCygnusBlessing(0L);

    Skill skill = new Skill();

    public FlameWizard2ContinuousDealCycle(Job job) {
        super(job, null);

        getJob().setName("플레임위자드(컨티, 2분)");

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        infinityFlameCircle.setRelatedSkill(new InfinityFlameCircle());
        infinityFlameCircle4.setRelatedSkill(new InfinityFlameCircle4());
        infinityFlameCircle4.setCooldown(48.0);

        transcendentCygnusBlessing.setCooldown(180.0);
        transcendentCygnusBlessing.setActivateTime(new Timestamp(-5555555));

        getStart().setTime(-10000);
        addSkillEvent(transcendentCygnusBlessing);
        getStart().setTime(0);

        burningRegion.setCooldown(60.0);
        burningRegion.setApplyCooldownReduction(false);

        for (AttackSkill attackSkill : attackSkillList) {
            if (attackSkill instanceof CygnusPhalanx) {
                attackSkill.addFinalDamage(1.08);       // 오버로드 마나
                break;
            }
        }
        cygnusPhalanx.addFinalDamage(1.08);             // 오버로드 마나

        flameCount = 150;

        skill.setCooldown(120.0);

        getSkillSequence1().add(burningRegion);         // 630
        getSkillSequence1().add(gloryOfGuardians);      // 30
        getSkillSequence1().add(salamanderMischief);
        getSkillSequence1().add(soulContract);          // 30

        getSkillSequence2().add(burningRegion);
        getSkillSequence2().add(soulContract);          // 30
        burningRegion.setDelay(630L);
        salamanderMischief.setDelay(210L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(transcendentCygnusBlessing)
                            && getStart().after(new Timestamp(salamanderMischief.getActivateTime().getTime() - 5000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(transcendentCygnusBlessing);
            }
            if (cooldownCheck(spiritOfFlame)) {
                addSkillEvent(spiritOfFlame);
            }
            if (cooldownCheck(cygnusPhalanx)) {
                addSkillEvent(cygnusPhalanx);
            }
            if (
                    cooldownCheck(skill)
                    && getStart().after(new Timestamp(flameDischarge.getActivateTime().getTime() - 1500))
            ) {
                burningRegion.setActivateTime(new Timestamp(-1));
                isNuke = true;
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(flameDischarge);
                addSkillEvent(blazingExtinction);
                applyCooldown(skill);
                if (cooldownCheck(eternity)) {
                    addSkillEvent(eternity);
                }
                while (!cooldownCheck(blazingOrbitalFlame)) {
                    addPlatDeal();
                }
                addSkillEvent(blazingOrbitalFlame);
                addSkillEvent(infinityFlameCircle);
                addSkillEvent(phoenixDrive);
                isNuke = false;
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(gloryOfGuardians.getActivateTime().getTime() - 50000))
            ) {
                burningRegion.setActivateTime(new Timestamp(-1));
                addDealCycle(getSkillSequence2());
            } else {
                addPlatDeal();
            }
        }
        sortEventTimeList();
    }

    public void addPlatDeal() {
        if (cooldownCheck(cygnusPhalanx)) {
            addSkillEvent(cygnusPhalanx);
        } else if (
                cooldownCheck(flameDischarge)
                        && flameCount >= 50
                        && getStart().before(new Timestamp(skill.getActivateTime().getTime() - 5000))
                        && getStart().before(new Timestamp(665 * 1000))
        ) {
            addSkillEvent(flameDischarge);
        } else if (
                cooldownCheck(blazingExtinction)
                && getStart().before(new Timestamp(skill.getActivateTime().getTime() - 5000))
        ) {
            addSkillEvent(blazingExtinction);
        } else if (cooldownCheck(blazingOrbitalFlame)) {
            addSkillEvent(blazingOrbitalFlame);
        } else {
            if (getStart().before(phoenixDriveEndTime)) {
                addSkillEvent(phoenixDriveFirst);
            } else {
                if (orbitalCount % 4 == 0) {
                    addSkillEvent(orbitalFlameReinforce);
                } else {
                    addSkillEvent(orbitalFlame);
                }
                orbitalCount++;
                if (cooldownCheck(orbitalFlameDot)) {
                    addSkillEvent(orbitalFlameDot);
                }
            }
            if (infernoRizeCount < 50) {
                infernoRizeCount++;
            }
            if (
                    getStart().before(phoenixDriveEndTime)
                    && cooldownCheck(infernoRize)
            ) {
                if (infernoRizeCount < 50) {
                    infernoRize.setRelatedSkill(null);
                    addSkillEvent(infernoRize);
                    infernoRize.setRelatedSkill(new InfernoRizeFoxPrank());
                } else {
                    addSkillEvent(infernoRize);
                }
            }
            if (
                    infernoRizeCount >= 50
                            && cooldownCheck(infernoRize)
            ) {
                addSkillEvent(infernoRize);
                infernoRizeCount = 0;
            }
        }
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof PhoenixDrive) {
                phoenixDriveEndTime = new Timestamp(getStart().getTime() + 18000);
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
                if (skill instanceof TranscendentCygnusBlessing) {
                    for (long i = 0; i < 48000; i += 4000) {
                        getSkillEventList().add(new SkillEvent(new TranscendentCygnusBlessing(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 4000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 4000));
                    }
                }
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
                            skill instanceof BlazingOrbitalFlame
                            || skill instanceof FlameDischarge
                            || skill instanceof InfernoRize
                            || skill instanceof InfernoRizeFoxPrank
                            || skill instanceof OrbitalFlame
                            || skill instanceof OrbitalFlameReinforce
                            || skill instanceof PhoenixDriveFirst
                            || skill instanceof SalamanderMischief
                            || skill instanceof CrestOfTheSolar
                            || skill instanceof CrestOfTheSolarDot
                            || skill instanceof SpiderInMirror
                            || skill instanceof SpiderInMirrorDot
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof PhoenixDriveFirst
                    || skill instanceof OrbitalFlame
                    || skill instanceof OrbitalFlameReinforce
            ) {
                infernoRize.setActivateTime(new Timestamp(infernoRize.getActivateTime().getTime() - 600));
                if (skill instanceof PhoenixDriveFirst) {
                    infernoRize.setActivateTime(new Timestamp(infernoRize.getActivateTime().getTime() - 1800));
                }
            }
            if (skill instanceof InfinityFlameCircle) {
                applyCooldown(infinityFlameCircle4);
            }
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
                        if (
                                skill instanceof BlazingOrbitalFlame
                                || skill instanceof InfinityFlameCircle
                                || skill instanceof InfinityFlameCircle4
                        ) {
                            orbitalExplosionCount++;
                            if (orbitalExplosionCount % 11 == 0) {
                                Timestamp now = new Timestamp(getStart().getTime());
                                getStart().setTime(getStart().getTime() + i);
                                addSkillEvent(new OrbitalExplosion());
                                getStart().setTime(now.getTime());
                                orbitalExplosionCount = orbitalExplosionCount - 11;
                            }
                        }
                        if (
                                skill instanceof InfinityFlameCircle
                                || skill instanceof InfinityFlameCircle4
                        ) {
                            Timestamp now = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
                            }
                            getStart().setTime(now.getTime());
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
                    || skill instanceof OrbitalFlameReinforce
            ) {
                orbitalExplosionCount++;
                if (orbitalExplosionCount % 11 == 0) {
                    addSkillEvent(new OrbitalExplosion());
                    orbitalExplosionCount = orbitalExplosionCount - 11;
                }
            }
            if (
                    skill instanceof OrbitalFlame
                    || skill instanceof OrbitalFlameReinforce
                    || skill instanceof PhoenixDriveFirst
                    || skill instanceof PhoenixDriveAfterSecond
                    || skill instanceof BlazingOrbitalFlame
                    || skill instanceof InfinityFlameCircle
                    || skill instanceof BlazingExtinction
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
        if (skill instanceof SalamanderMischief) {
            applyCooldown(salamanderMischief);
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
        return attackDamage;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    skill instanceof PhoenixDriveFirst
                    || skill instanceof PhoenixDriveAfterSecond
                    || skill instanceof OrbitalFlameDot
            ) {
                orbitalExplosionCount++;
                if (orbitalExplosionCount % 11 == 0) {
                    Timestamp now = new Timestamp(getStart().getTime());
                    getStart().setTime(getStart().getTime() + sum);
                    addSkillEvent(new OrbitalExplosion());
                    getStart().setTime(now.getTime());
                    orbitalExplosionCount = orbitalExplosionCount - 11;
                }
            }
            if (
                    skill instanceof InfinityFlameCircle
                            || skill instanceof InfinityFlameCircle4
            ) {
                Timestamp now = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                getStart().setTime(now.getTime());
            }
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }
}
