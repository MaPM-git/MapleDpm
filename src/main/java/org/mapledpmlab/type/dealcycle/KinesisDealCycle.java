package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.kinesis.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.kinesis.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class KinesisDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
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
            add(new OtherWorldVoid());
            add(new PsychicDrain());
            add(new PsychicGrab());
            add(new PsychicGround());
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

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new OtherWorldGoddessBlessing());
            add(new OtherworldlyAfterimage(275));
            add(new PriorPreparation());
            add(new PsychicCharge());
            add(new PsychicGroundBuff());
            add(new PsychicOver());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            add(new UltimateMaterialBuff());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    PsychicDrainTic psychicDrainTic = new PsychicDrainTic();
    PsychicOverTic psychicOverTic = new PsychicOverTic();
    UltimateBPMTic ultimateBPMTic = new UltimateBPMTic();

    int psychicPoint = 40;
    int grabCnt = 0;

    Timestamp psychicOverEndTime = new Timestamp(-1);
    Timestamp blessEndTime = new Timestamp(-1);

    public KinesisDealCycle(Job job) {
        super(job, new Telekinesis());

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        AnotherRealm anotherRealm = new AnotherRealm();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        EverPsychic everPsychic = new EverPsychic();
        LawOfGravity lawOfGravity = new LawOfGravity();
        OtherWorldGoddessBlessing otherWorldGoddessBlessing = new OtherWorldGoddessBlessing();
        OtherworldlyAfterimage otherworldlyAfterimage = new OtherworldlyAfterimage(275);
        PriorPreparation priorPreparation = new PriorPreparation();
        PsychicCharge psychicCharge = new PsychicCharge();
        PsychicDrain psychicDrain = new PsychicDrain();
        PsychicGrab psychicGrab = new PsychicGrab();
        PsychicGround psychicGround = new PsychicGround();
        PsychicOver psychicOver = new PsychicOver();
        PsychicSmashing psychicSmashing = new PsychicSmashing();
        PsychicTornado psychicTornado = new PsychicTornado();
        PsychicTornadoThrow psychicTornadoThrow = new PsychicTornadoThrow();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        UltimateBPM ultimateBPM = new UltimateBPM();
        UltimateMaterial ultimateMaterial = new UltimateMaterial();
        UltimateMovingMatter ultimateMovingMatter = new UltimateMovingMatter();
        UltimatePsychicBullet ultimatePsychicBullet = new UltimatePsychicBullet();
        UltimatePsychicShoot ultimatePsychicShoot = new UltimatePsychicShoot();
        UltimateTrain ultimateTrain = new UltimateTrain();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ultimateBPMTic.setActivateTime(new Timestamp(600));

        ringSwitching.setCooldown(90.0);

        dealCycle1.add(ultimateMaterial);
        dealCycle1.add(psychicGround);
        dealCycle1.add(psychicDrain);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(otherworldlyAfterimage);
        dealCycle1.add(otherWorldGoddessBlessing);
        dealCycle1.add(psychicOver);
        dealCycle1.add(psychicTornado);         // 720
        dealCycle1.add(ultimateMovingMatter);   // 630
        dealCycle1.add(lawOfGravity);           // 960
        dealCycle1.add(ultimateTrain);          // 630
        dealCycle1.add(soulContract);
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(restraintRing);          // 30
        dealCycle1.add(anotherRealm);           // 7920
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(ultimateMaterial);       // 630
        dealCycle1.add(psychicTornadoThrow);

        dealCycle2.add(ultimateMaterial);
        dealCycle2.add(psychicGround);
        dealCycle2.add(psychicDrain);
        dealCycle2.add(otherworldlyAfterimage);
        dealCycle2.add(otherWorldGoddessBlessing);
        dealCycle2.add(psychicOver);
        dealCycle2.add(psychicTornado);         // 720
        dealCycle2.add(ultimateMovingMatter);   // 630
        dealCycle2.add(lawOfGravity);           // 960
        dealCycle2.add(ultimateTrain);          // 630
        dealCycle2.add(soulContract);
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(restraintRing);          // 30   //7380
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(ultimateMaterial);       // 630
        dealCycle2.add(psychicTornadoThrow);    // 2520

        dealCycle3.add(everPsychic);
        dealCycle3.add(ultimateMaterial);
        dealCycle3.add(ultimateMovingMatter);
        dealCycle3.add(ultimateTrain);
        dealCycle3.add(soulContract);
        dealCycle3.add(weaponJumpRing);

        addSkillEvent(ultimateBPM);
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(blessEndTime)
                    && (
                            (
                                    getStart().before(new Timestamp(60 * 1000))
                            ) || (
                                    getStart().after(new Timestamp(380 * 1000))
                                    && getStart().before(new Timestamp(420 * 1000))
                            ) || (
                                    getStart().after(new Timestamp(560 * 1000))
                                    && getStart().before(new Timestamp(620 * 1000))
                            )
                    )
            ) {
                addSkillEvent(otherWorldGoddessBlessing);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && psychicPoint > 6
            ) {
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
                    && psychicPoint > 6
            ) {
                addDealCycle(dealCycle2);
            } else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
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
            } else if (
                    cooldownCheck(ultimateTrain)
                    && psychicPoint >= 15
            ) {
                addSkillEvent(ultimateTrain);
            } else if (
                    psychicPoint >= 6
                    && !cooldownCheck(psychicOver)
            ){
                addSkillEvent(ultimateMaterial);
            } else if (
                    psychicPoint >= 4
                    && grabCnt > 0
                    && !cooldownCheck(psychicOver)
            ) {
                addSkillEvent(ultimatePsychicShoot);
                grabCnt = 0;
            } else if (grabCnt > 0) {
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
        if (
                getStart().before(psychicOverEndTime)
                && cooldownCheck(psychicOverTic)
        ) {
            psychicPoint ++;
            psychicOverTic.setActivateTime(new Timestamp(psychicOverTic.getActivateTime().getTime() + 750));
        }
        if (cooldownCheck(psychicDrainTic)) {
            Long ran = (long) (Math.random() * 99 + 1);
            if (ran <= 40) {
                psychicPoint += 1;
            }
            psychicDrainTic.setActivateTime(new Timestamp(psychicDrainTic.getActivateTime().getTime() + 500));
        }
        if (cooldownCheck(ultimateBPMTic)) {
            psychicPoint -= 1;
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
            }
            if (((BuffSkill) skill).isApplyPlusBuffDuration()) {
                endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (skill instanceof PsychicDrain) {
                psychicDrainTic.setActivateTime(new Timestamp(getStart().getTime() + 500));
            }
            if (skill instanceof PsychicSmashing) {
                psychicPoint += 2;
            } else if (skill instanceof PsychicGround) {
                psychicPoint += 1;
            }
            if (getStart().before(psychicOverEndTime)) {
                if (
                        skill instanceof EverPsychic
                        || skill instanceof UltimatePsychicBullet
                ) {
                    psychicPoint -= 1;
                } else if (skill instanceof LawOfGravity) {
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
                if (
                        skill instanceof EverPsychic
                        || skill instanceof UltimatePsychicBullet
                ) {
                    psychicPoint -= 2;
                } else if (skill instanceof LawOfGravity) {
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
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        if (
                attackSkill instanceof AnotherRealm
                || attackSkill instanceof AnotherRealmBomb
                || attackSkill instanceof EverPsychic
                || attackSkill instanceof EverPsychicFinish
                || attackSkill instanceof LawOfGravity
                || attackSkill instanceof LawOfGravityPull1
                || attackSkill instanceof LawOfGravityPull2
                || attackSkill instanceof LawOfGravityPull3
                || attackSkill instanceof LawOfGravityPull4
                || attackSkill instanceof LawOfGravityPull5
                || attackSkill instanceof PsychicDrain
                || attackSkill instanceof PsychicGrab
                || attackSkill instanceof PsychicGround
                || attackSkill instanceof PsychicSmashing
                || attackSkill instanceof PsychicTornado
                || attackSkill instanceof PsychicTornadoBomb
                || attackSkill instanceof PsychicTornadoThrow
                || attackSkill instanceof PsychoMetry
                || attackSkill instanceof UltimateBPM
                || attackSkill instanceof UltimateMaterial
                || attackSkill instanceof UltimateMovingMatter
                || attackSkill instanceof UltimateMovingMatterExtinction
                || attackSkill instanceof UltimatePsychicBullet
                || attackSkill instanceof UltimatePsychicBulletBlackHole
                || attackSkill instanceof UltimatePsychicShoot
                || attackSkill instanceof UltimateTrain
        ) {
            buffSkill.addBuffFinalDamage(1.08);
        }
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
                this.getJob().addMainStat(-buffSkill.getBuffMainStat());
                this.getJob().addSubStat(-buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(-buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(-buffSkill.getBuffOtherStat2());
                if (skillEvent.getStart().equals(start)) {
                    as.setUseCount(as.getUseCount() + 1);
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
        if (
                attackSkill instanceof AnotherRealm
                        || attackSkill instanceof AnotherRealmBomb
                        || attackSkill instanceof EverPsychic
                        || attackSkill instanceof EverPsychicFinish
                        || attackSkill instanceof LawOfGravity
                        || attackSkill instanceof LawOfGravityPull1
                        || attackSkill instanceof LawOfGravityPull2
                        || attackSkill instanceof LawOfGravityPull3
                        || attackSkill instanceof LawOfGravityPull4
                        || attackSkill instanceof LawOfGravityPull5
                        || attackSkill instanceof PsychicDrain
                        || attackSkill instanceof PsychicGrab
                        || attackSkill instanceof PsychicGround
                        || attackSkill instanceof PsychicSmashing
                        || attackSkill instanceof PsychicTornado
                        || attackSkill instanceof PsychicTornadoBomb
                        || attackSkill instanceof PsychicTornadoThrow
                        || attackSkill instanceof PsychoMetry
                        || attackSkill instanceof UltimateBPM
                        || attackSkill instanceof UltimateMaterial
                        || attackSkill instanceof UltimateMovingMatter
                        || attackSkill instanceof UltimateMovingMatterExtinction
                        || attackSkill instanceof UltimatePsychicBullet
                        || attackSkill instanceof UltimatePsychicBulletBlackHole
                        || attackSkill instanceof UltimatePsychicShoot
                        || attackSkill instanceof UltimateTrain
        ) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.08);
        }
        return attackDamage;
    }
}
