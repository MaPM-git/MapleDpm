package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.kinesis.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.kinesis.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class KinesisDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AnotherRealm());
            add(new AnotherRealmBomb());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new EverPsychic());
            add(new EverPsychicFinish());
            add(new LawOfGravity());
            add(new LawOfGravityPull1());
            add(new LawOfGravityPull2());
            add(new LawOfGravityPull3());
            add(new LawOfGravityPull4());
            add(new LawOfGravityPull5());
            add(new LawOfGravityFinish());
            add(new OtherWorldVoid());
            add(new PsychicDrain());
            add(new PsychicGrab());
            add(new PsychicGround());
            add(new PsychicForce());
            add(new PsychicSmashing());
            add(new PsychicTornado());
            add(new PsychicTornadoBomb());
            add(new PsychicTornadoThrow());
            add(new PsychoMetry());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new Telekinesis());
            add(new UltimateBPM());
            add(new UltimateMaterial());
            add(new UltimateMovingMatter());
            add(new UltimateMovingMatterExtinction());
            add(new UltimatePsychicBullet());
            add(new UltimatePsychicBulletBlackHole());
            add(new UltimatePsychicShoot());
            add(new UltimateTrain());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new OtherWorldGoddessBlessing());
            add(new OtherworldlyAfterimage(Math.toIntExact(getJob().getLevel())));
            add(new PsychicCharge());
            add(new PsychicGroundBuff());
            add(new PsychicOver());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new UltimateMaterialBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int grabCnt = 0;
    int psychicPoint = 40;

    Timestamp blessEndTime = new Timestamp(-1);
    Timestamp movingMatterEndTime = new Timestamp(-1);
    Timestamp psychicOverEndTime = new Timestamp(-1);

    List<Timestamp> drainTime = new ArrayList<>();

    AnotherRealm anotherRealm = new AnotherRealm();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    EverPsychic everPsychic = new EverPsychic();
    LawOfGravity lawOfGravity = new LawOfGravity();
    OtherWorldGoddessBlessing otherWorldGoddessBlessing = new OtherWorldGoddessBlessing();
    OtherworldlyAfterimage otherworldlyAfterimage = new OtherworldlyAfterimage(Math.toIntExact(getJob().getLevel()));
    PsychicCharge psychicCharge = new PsychicCharge();
    PsychicDrain psychicDrain = new PsychicDrain();
    PsychicDrainTic psychicDrainTic = new PsychicDrainTic();
    PsychicForce psychicForce = new PsychicForce();
    PsychicGrab psychicGrab = new PsychicGrab();
    PsychicGround psychicGround = new PsychicGround();
    PsychicOver psychicOver = new PsychicOver();
    PsychicOverTic psychicOverTic = new PsychicOverTic();
    PsychicSmashing psychicSmashing = new PsychicSmashing();
    PsychicTornado psychicTornado = new PsychicTornado();
    PsychicTornadoThrow psychicTornadoThrow = new PsychicTornadoThrow();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    UltimateBPM ultimateBPM = new UltimateBPM();
    UltimateBPMTic ultimateBPMTic = new UltimateBPMTic();
    UltimateMaterial ultimateMaterial = new UltimateMaterial();
    UltimateMovingMatter ultimateMovingMatter = new UltimateMovingMatter();
    UltimatePsychicBullet ultimatePsychicBullet = new UltimatePsychicBullet();
    UltimatePsychicShoot ultimatePsychicShoot = new UltimatePsychicShoot();
    UltimateTrain ultimateTrain = new UltimateTrain();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public KinesisDealCycle(Job job) {
        super(job, new Telekinesis());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ultimateBPMTic.setActivateTime(new Timestamp(600));

        otherWorldGoddessBlessing.setCooldown(120.0);
        ringSwitching.setCooldown(90.0);
    }

    @Override
    public void setSoloDealCycle() {
        addSkillEvent(ultimateBPM);
        while (getStart().before(getEnd())) {
            if (
                    /*psychicPoint > 6
                    && */getStart().before(new Timestamp(10 * 60 * 1000))
                    && cooldownCheck(psychicGround)
                    && cooldownCheck(psychicDrain)
                    && cooldownCheck(otherWorldGoddessBlessing)
                    && cooldownCheck(psychicOver)
                    && cooldownCheck(psychicTornado)
                    && cooldownCheck(ultimateMovingMatter)
                    && cooldownCheck(lawOfGravity)
                    //&& cooldownCheck(ultimateTrain)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
            ) {
                if (
                        cooldownCheck(psychicCharge)
                                && psychicPoint <= 20
                ) {
                    addSkillEvent(psychicCharge);
                }
                addSkillEvent(psychicGround);
                addSkillEvent(psychicDrain);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addSkillEvent(otherworldlyAfterimage);
                if (
                        getStart().after(new Timestamp(2 * 60 * 1000))
                                && getStart().before(new Timestamp(4 * 60 * 1000))
                ) {
                    otherWorldGoddessBlessing.setCooldown(90.0);
                } else if (getStart().after(new Timestamp(8 * 60 * 1000))) {
                    otherWorldGoddessBlessing.setCooldown(90.0);
                } else {
                    otherWorldGoddessBlessing.setCooldown(120.0);
                }
                addSkillEvent(otherWorldGoddessBlessing);
                addSkillEvent(psychicOver);
                addSkillEvent(psychicTornado);
                addSkillEvent(ultimateMovingMatter);
                addSkillEvent(lawOfGravity);
                //addSkillEvent(ultimateTrain);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                if (cooldownCheck(anotherRealm)) {
                    addSkillEvent(anotherRealm);
                    movingMatterEndTime = new Timestamp(-1);
                }
            } else if (
                    cooldownCheck(everPsychic)
                            && cooldownCheck(ultimateMovingMatter)
                            //&& cooldownCheck(ultimateTrain)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(weaponJumpRing)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                if (cooldownCheck(otherWorldGoddessBlessing)) {
                    addSkillEvent(otherWorldGoddessBlessing);
                }
                addSkillEvent(everPsychic);
                addSkillEvent(ultimateMovingMatter);
                //addSkillEvent(ultimateTrain);
                addSkillEvent(soulContract);
                addSkillEvent(weaponJumpRing);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(80 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(otherworldlyAfterimage)
                            && cooldownCheck(lawOfGravity)
                            && getStart().before(new Timestamp(psychicOver.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(otherworldlyAfterimage);
                addSkillEvent(lawOfGravity);
            } else if (
                    cooldownCheck(psychicCharge)
                            && psychicPoint <= 20
            ) {
                addSkillEvent(psychicCharge);
            } else if (
                    cooldownCheck(psychicGround)
                            && getStart().before(new Timestamp(psychicOver.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(psychicGround);
                addSkillEvent(psychicDrain);
            }/* else if (
                    cooldownCheck(ultimateTrain)
                    && psychicPoint >= 15
            ) {
                addSkillEvent(ultimateTrain);
            }*/ else if (
                    getStart().before(movingMatterEndTime)
                            && cooldownCheck(psychicForce)
            ) {
                addSkillEvent(psychicForce);
            } else if (
                    getStart().before(psychicOverEndTime)
                            && psychicPoint >= 3
            ) {
                addSkillEvent(ultimateMaterial);
            } else if (
                    psychicPoint >= 6
                            && !cooldownCheck(psychicOver)
            ){
                addSkillEvent(ultimateMaterial);
            }/* else if (
                    psychicPoint >= 4
                    && grabCnt > 0
                    && !cooldownCheck(psychicOver)
            ) {
                addSkillEvent(ultimatePsychicShoot);
                grabCnt = 0;
            }*/ else if (grabCnt > 0) {
                addSkillEvent(psychicSmashing);
                grabCnt --;
            } else {
                addSkillEvent(psychicGrab);
                grabCnt = 5;
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
        if (drainTime.size() > 0) {
            for (int i = 0; i < drainTime.size(); i++) {
                if (drainTime.get(i).before(getStart())) {
                    drainTime.remove(i);
                    i--;
                    psychicPoint += 1;
                    if (psychicPoint > 40) {
                        psychicPoint = 40;
                    }
                }
            }
        }
        if (
                getStart().before(psychicOverEndTime)
                && cooldownCheck(psychicOverTic)
        ) {
            psychicPoint ++;
            psychicOverTic.setActivateTime(new Timestamp(psychicOverTic.getActivateTime().getTime() + 750));
        }
        if (
                cooldownCheck(ultimateBPMTic)
                && psychicPoint >= 1
        ) {
            psychicPoint -= 1;
            Long ran = (long) (Math.random() * 99 + 1);
            if (ran <= 40) {
                psychicPoint += 1;
                if (psychicPoint > 40) {
                    psychicPoint = 40;
                }
            }
            ultimateBPMTic.setActivateTime(new Timestamp(ultimateBPMTic.getActivateTime().getTime() + 600));
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof OtherWorldGoddessBlessing) {
                blessEndTime = new Timestamp(getStart().getTime() + 40000);
            }
            if (skill instanceof PsychicOver) {
                psychicOverEndTime = new Timestamp(getStart().getTime() + 26000);
                psychicOverTic.setActivateTime(new Timestamp(getStart().getTime() + 750));
            }
            if (skill instanceof PsychicCharge) {
                psychicPoint += 20;
            }
            if (psychicPoint > 40) {
                psychicPoint = 40;
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
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (skill instanceof UltimateMovingMatter) {
                movingMatterEndTime = new Timestamp(getStart().getTime() + 30000);
            }
            if (
                    skill instanceof UltimateTrain
                    || skill instanceof UltimatePsychicShoot
                    || skill instanceof UltimatePsychicBullet
                    || skill instanceof CrestOfTheSolar
                    || skill instanceof SpiderInMirror
                    || skill instanceof LawOfGravity
                    || skill instanceof LawOfGravityPull1
                    || skill instanceof PsychicSmashing
                    || skill instanceof UltimateMaterial
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 40) {
                    psychicPoint += 1;
                    if (((AttackSkill) skill).isApplyFinalAttack()) {
                        psychicPoint += 1;
                    }
                    if (psychicPoint > 40) {
                        psychicPoint = 40;
                    }
                }
            }
            if (skill instanceof PsychicDrain) {
                psychicPoint += 1;
                psychicDrainTic.setActivateTime(new Timestamp(getStart().getTime() + 500));
            }
            if (skill instanceof PsychicSmashing) {
                psychicPoint += 2;
            } else if (
                    skill instanceof PsychicGround
                    || skill instanceof PsychicForce
            ) {
                psychicPoint += 1;
            }
            if (getStart().before(psychicOverEndTime)) {
                if (skill instanceof UltimatePsychicBullet) {
                    psychicPoint -= 1;
                } else if (
                        skill instanceof LawOfGravity
                        || skill instanceof AnotherRealm
                ) {
                    psychicPoint -= 2;
                } else if (skill instanceof UltimatePsychicShoot) {
                    psychicPoint -= 2;
                } else if (skill instanceof UltimateMaterial) {
                    psychicPoint -= 3;
                } else if (skill instanceof UltimateMovingMatter) {
                    psychicPoint -= 5;
                } else if (
                        skill instanceof UltimateTrain
                        || skill instanceof PsychicTornado
                ) {
                    psychicPoint -= 7;
                }
            } else {
                if (skill instanceof UltimatePsychicBullet) {
                    psychicPoint -= 3;
                } else if (
                        skill instanceof LawOfGravity
                        || skill instanceof AnotherRealm
                ) {
                    psychicPoint -= 5;
                } else if (skill instanceof UltimatePsychicShoot) {
                    psychicPoint -= 4;
                } else if (skill instanceof UltimateMaterial) {
                    psychicPoint -= 6;
                } else if (skill instanceof UltimateMovingMatter) {
                    psychicPoint -= 10;
                } else if (
                        skill instanceof UltimateTrain
                        || skill instanceof PsychicTornado
                ) {
                    psychicPoint -= 15;
                }
            }
            if (
                    psychicPoint > 40
                    || skill instanceof EverPsychic
            ) {
                psychicPoint = 40;
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
                        if (skill instanceof OtherWorldVoid) {
                            Long ran = 0L;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran >= 75) {
                                for (int drain = 0; drain < 12; drain ++) {
                                    drainTime.add(new Timestamp(getStart().getTime() + i));
                                }
                                continue;
                            } else if (ran >= 25) {
                                continue;
                            } else {
                                ran = (long) (Math.random() * 99 + 1);
                                if (ran <= 40) {
                                    drainTime.add(new Timestamp(getStart().getTime() + i));
                                }
                            }
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof UltimateTrain) {
                        i = 2130;
                    }
                    if (skill instanceof UltimateMovingMatter) {
                        i = 1890;
                    }
                    if (skill instanceof LawOfGravityPull5) {
                        i = 6960;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (skill instanceof UltimateTrain) {
                            skill = new UltimateTrain();
                            for (int j = 0; j < attackCount; j++) {
                                ((UltimateTrain) skill).setDamage(((UltimateTrain) skill).getDamage() - 5);
                            }
                        }
                        if (
                                skill instanceof UltimateMovingMatter
                                || skill instanceof PsychicTornado
                                || skill instanceof LawOfGravityPull5
                                || skill instanceof EverPsychic
                        ) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 40) {
                                if (((AttackSkill) skill).isApplyFinalAttack()) {
                                    drainTime.add(new Timestamp(getStart().getTime() + i));
                                }
                                drainTime.add(new Timestamp(getStart().getTime() + i));
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
            if (
                    skill instanceof UltimateMovingMatterExtinction
                    || skill instanceof PsychicTornadoBomb
                    || skill instanceof PsychicTornadoThrow
                    || skill instanceof LawOfGravityFinish
                    || skill instanceof LawOfGravityPull2
                    || skill instanceof LawOfGravityPull3
                    || skill instanceof LawOfGravityPull4
                    || skill instanceof EverPsychicFinish
                    || skill instanceof AnotherRealm
                    || skill instanceof AnotherRealmBomb
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 40) {
                    if (((AttackSkill) skill).isApplyFinalAttack()) {
                        drainTime.add(new Timestamp(getStart().getTime() + sum));
                    }
                    drainTime.add(new Timestamp(getStart().getTime() + sum));
                }
            }
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        for (AttackSkill as : getAttackSkillList()) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                if (
                        attackSkill instanceof UltimateBPM
                        || attackSkill instanceof UltimateMaterial
                        || attackSkill instanceof UltimateMovingMatter
                        || attackSkill instanceof UltimateMovingMatterExtinction
                        || attackSkill instanceof UltimatePsychicBullet
                        || attackSkill instanceof UltimatePsychicBulletBlackHole
                        || attackSkill instanceof UltimatePsychicShoot
                        || attackSkill instanceof UltimateTrain
                ) {
                    buffSkill.addBuffCriticalDamage(22.0);
                }
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
                    attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat()) * 0.01
                            * (Math.floor((getJob().getMagic() + buffSkill.getBuffAttMagic())
                            * (1 + (getJob().getMagicP() + buffSkill.getBuffAttMagicPer()) * 0.01))
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
                if (
                        attackSkill instanceof UltimateBPM
                        || attackSkill instanceof UltimateMaterial
                        || attackSkill instanceof UltimateMovingMatter
                        || attackSkill instanceof UltimateMovingMatterExtinction
                        || attackSkill instanceof UltimatePsychicBullet
                        || attackSkill instanceof UltimatePsychicBulletBlackHole
                        || attackSkill instanceof UltimatePsychicShoot
                        || attackSkill instanceof UltimateTrain
                ) {
                    buffSkill.addBuffCriticalDamage(-22.0);
                }
                break;
            }
        }
        return attackDamage;
    }
}
