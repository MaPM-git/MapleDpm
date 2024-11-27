package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.JobContinuous.CadenaContinuous;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.cadena.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.cadena.*;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class CadenaContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ADOrdnance());
            add(new ADOrdnanceSphere());
            add(new ChainArtsChase());
            add(new ChainArtsCrush());
            add(new ChainArtsFury());
            add(new ChainArtsMaelstrom());
            add(new ChainArtsMassacre1());
            add(new ChainArtsMassacre2());
            add(new ChainArtsMassacre3());
            add(new ChainArtsStroke1());
            add(new ChainArtsStroke1Cancle());
            add(new ChainArtsStroke2());
            add(new ChainArtsStroke2Reinforce());
            add(new ChainArtsStroke2ReinforceWave());
            add(new ChainArtsTakedown());
            add(new ChainArtsTakedownBeat());
            add(new ChainArtsTakedownFinish());
            add(new ChainArtsTakedownWave());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new ProfessionalAgentBomb());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SummonBeatingNeedleBat1());
            add(new SummonBeatingNeedleBat2());
            add(new SummonBeatingNeedleBat3());
            add(new SummonCuttingScimitar());
            add(new SummonReleasingBomb());
            add(new SummonScratchingClaw());
            add(new SummonShootingShotgun());
            add(new SummonSlashingKnife());
            add(new SummonStrikingBrick());
            add(new SummonThrowingWingDagger());
            add(new SummonThrowingWingDaggerBomb());
            add(new VenomBurst());
            add(new WeakPointConvergingAttack());
            add(new WeaponVariety());
            add(new WeaponVarietyFinale());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new ContinuousRing());
            add(new ChainArtsFuryBuff());
            add(new GrandisGoddessBlessingNova());
            add(new ProfessionalAgent());
            add(new ReadyToDie());
            add(new ShadowdealerElixir());
            add(new SoulContract());
            add(new SummonSlashingKnifeBuff());
            add(new WeakPointConvergingAttackBind());
            add(new WeaponVarietyBuff());
        }
    };

    int reuseCnt = 0;
    int weaponVarietyCnt = 4;

    Timestamp chainArtsFuryEndTime = new Timestamp(-1);
    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp grandisGoddessBlessingEndTime = new Timestamp(-1);
    Timestamp professionalAgentEndTime = new Timestamp(-1);
    Timestamp soulContractEndTime = new Timestamp(-1);

    boolean isAir = false;
    boolean isNuke = false;
    boolean isCancel = false;

    ADOrdnance adOrdnance = new ADOrdnance();
    ChainArtsChase chainArtsChase = new ChainArtsChase();
    ChainArtsCrush chainArtsCrush = new ChainArtsCrush();
    ChainArtsFury chainArtsFury = new ChainArtsFury();
    ChainArtsFuryBuff chainArtsFuryBuff = new ChainArtsFuryBuff();
    ChainArtsMaelstrom chainArtsMaelstrom = new ChainArtsMaelstrom();
    ChainArtsMassacre1 chainArtsMassacre1 = new ChainArtsMassacre1();
    ChainArtsStroke1 chainArtsStroke1 = new ChainArtsStroke1();
    ChainArtsStroke1Cancle chainArtsStroke1Cancle = new ChainArtsStroke1Cancle();
    ChainArtsStroke2 chainArtsStroke2 = new ChainArtsStroke2();
    ChainArtsStroke2Reinforce chainArtsStroke2Reinforce = new ChainArtsStroke2Reinforce();
    ChainArtsTakedown chainArtsTakedown = new ChainArtsTakedown();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    GrandisGoddessBlessingNova grandisGoddessBlessingNova = new GrandisGoddessBlessingNova();
    ProfessionalAgent professionalAgent = new ProfessionalAgent();
    ProfessionalAgentBomb professionalAgentBomb = new ProfessionalAgentBomb();
    ReadyToDie readyToDie = new ReadyToDie();
    ShadowdealerElixir shadowdealerElixir = new ShadowdealerElixir();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SummonBeatingNeedleBat1 summonBeatingNeedleBat1 = new SummonBeatingNeedleBat1();
    SummonCuttingScimitar summonCuttingScimitar = new SummonCuttingScimitar();
    SummonReleasingBomb summonReleasingBomb = new SummonReleasingBomb();
    SummonScratchingClaw summonScratchingClaw = new SummonScratchingClaw();
    SummonShootingShotgun summonShootingShotgun = new SummonShootingShotgun();
    SummonSlashingKnife summonSlashingKnife = new SummonSlashingKnife();
    SummonStrikingBrick summonStrikingBrick = new SummonStrikingBrick();
    SummonThrowingWingDaggerBomb summonThrowingWingDagger = new SummonThrowingWingDaggerBomb();
    VenomBurst venomBurst = new VenomBurst();
    WeakPointConvergingAttack weakPointConvergingAttack = new WeakPointConvergingAttack();
    WeaponVariety weaponVariety = new WeaponVariety();
    WeaponVarietyBuff weaponVarietyBuff = new WeaponVarietyBuff();
    WeaponVarietyFinale weaponVarietyFinale = new WeaponVarietyFinale();

    public CadenaContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        soulContract.setApplyReuse(true);

        grandisGoddessBlessingNova.setCooldown(120.0);
    }

    @Override
    public void setSoloDealCycle() {
        addSkillEvent(weakPointConvergingAttack);
        addSkillEvent(weaponVarietyBuff);
        addSkillEvent(venomBurst);
        while (getStart().before(getEnd())) {
            if (cooldownCheck(professionalAgent)) {
                isNuke = true;
                while (getStart().before(new Timestamp(chainArtsTakedown.getActivateTime().getTime() - 5000))) {
                    addPlatDeal();
                }
                if (isCancel) {
                    getStart().setTime(getStart().getTime() + 500);
                }
                addSkillEvent(chainArtsFuryBuff);
                addSkillEvent(shadowdealerElixir);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addSkillEvent(grandisGoddessBlessingNova);
                addSkillEvent(professionalAgent);
                addSkillEvent(adOrdnance);
                addSkillEvent(chainArtsStroke1);
                addSkillEvent(chainArtsStroke2);
                chainArtsMaelstrom.setActivateTime(new Timestamp(-1));
                addSkillEvent(chainArtsMaelstrom);
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(chainArtsTakedown);
                addSkillEvent(chainArtsStroke1Cancle);
                addSkillEvent(summonThrowingWingDagger);
                addSkillEvent(chainArtsStroke1Cancle);
                addSkillEvent(summonBeatingNeedleBat1);
                if (cooldownCheck(chainArtsMassacre1)) {
                    addSkillEvent(chainArtsMassacre1);
                }
                isNuke = false;
            } else if (
                    cooldownCheck(chainArtsTakedown)
                    && cooldownCheck(adOrdnance)
            ) {
                if (isCancel) {
                    getStart().setTime(getStart().getTime() + 500);
                }
                addSkillEvent(soulContract);
                addSkillEvent(readyToDie);
                addSkillEvent(chainArtsTakedown);
                addSkillEvent(adOrdnance);
                addSkillEvent(chainArtsStroke1);
                addSkillEvent(chainArtsStroke2);
                chainArtsMaelstrom.setActivateTime(new Timestamp(-1));
                addSkillEvent(chainArtsMaelstrom);
            } /*else if (
                    cooldownCheck(soulContract)
                            && getStart().after(soulContractEndTime)
            ) {
                if (isCancel) {
                    getStart().setTime(getStart().getTime() + 500);
                }
                addSkillEvent(soulContract);
            }*/ else if (cooldownCheck(chainArtsMaelstrom)) {
                addSkillEvent(chainArtsStroke1);
                addSkillEvent(chainArtsStroke2);
                addSkillEvent(chainArtsMaelstrom);
                isCancel = false;
            } else if (
                    cooldownCheck(adOrdnance)
                    && getStart().before(new Timestamp(670 * 1000))
            ) {
                if (isAir) {
                    addSkillEvent(chainArtsStroke1);
                    addSkillEvent(chainArtsStroke2);
                    isAir = false;
                }
                addSkillEvent(adOrdnance);
                isCancel = false;
            } else {
                addPlatDeal();
            }
        }
        sortEventTimeList();
    }

    public void addPlatDeal() {
        isCancel = true;
        if (
                cooldownCheck(summonThrowingWingDagger)
                        //&& !cooldownCheck(adOrdnance)
        ) {
            if (isAir) {
                addSkillEvent(chainArtsStroke1);
                addSkillEvent(chainArtsStroke2);
                isAir = false;
            }
            addSkillEvent(chainArtsStroke1Cancle);
            addSkillEvent(summonThrowingWingDagger);
        } else if (cooldownCheck(summonBeatingNeedleBat1)) {
            addSkillEvent(chainArtsStroke1Cancle);
            addSkillEvent(summonBeatingNeedleBat1);
        } else if (cooldownCheck(chainArtsStroke2Reinforce)) {
            addSkillEvent(chainArtsStroke1);
            addSkillEvent(chainArtsStroke2Reinforce);
        } else if (cooldownCheck(summonShootingShotgun)) {
            addSkillEvent(chainArtsStroke1Cancle);
            addSkillEvent(summonShootingShotgun);
            isAir = true;
        } else if (cooldownCheck(summonSlashingKnife)) {
            addSkillEvent(chainArtsStroke1Cancle);
            addSkillEvent(summonSlashingKnife);
        } else if (cooldownCheck(summonStrikingBrick)) {
            addSkillEvent(chainArtsStroke1Cancle);
            addSkillEvent(summonStrikingBrick);
        } else if (cooldownCheck(summonReleasingBomb)) {
            addSkillEvent(chainArtsStroke1Cancle);
            addSkillEvent(summonReleasingBomb);
            isAir = true;
        } else if (cooldownCheck(summonScratchingClaw)) {
            if (!isAir) {
                addSkillEvent(chainArtsStroke1);
                addSkillEvent(chainArtsStroke2);
            }
            addSkillEvent(chainArtsStroke1Cancle);
            addSkillEvent(summonScratchingClaw);
            isAir = false;
        } else if (cooldownCheck(chainArtsCrush)) {
            addSkillEvent(chainArtsStroke1);
            addSkillEvent(chainArtsChase);
            addSkillEvent(chainArtsCrush);
            isCancel = false;
        } else if (
                cooldownCheck(summonCuttingScimitar)
        ) {
            addSkillEvent(chainArtsStroke1);
            addSkillEvent(summonCuttingScimitar);
            addSkillEvent(chainArtsChase);
        } else {
            addSkillEvent(chainArtsStroke1);
            addSkillEvent(chainArtsStroke2);
        }
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
            if (skill instanceof SoulContract) {
                soulContractEndTime = new Timestamp(getStart().getTime() + 20000);
            }
            if (skill instanceof GrandisGoddessBlessingNova) {
                reuseCnt = 6;
                grandisGoddessBlessingEndTime = new Timestamp(getStart().getTime() + 43000);
            }
            if (skill instanceof ProfessionalAgent) {
                professionalAgentEndTime = new Timestamp(getStart().getTime() + 33000);
            }
            if (skill instanceof ChainArtsFuryBuff) {
                chainArtsFuryEndTime = new Timestamp(getStart().getTime() + 83000);
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
                            || skill instanceof ADOrdnance
                            || skill instanceof ChainArtsChase
                            || skill instanceof ChainArtsCrush
                            || skill instanceof ChainArtsMaelstrom
                            || skill instanceof ChainArtsStroke1
                            || skill instanceof ChainArtsStroke1Cancle
                            || skill instanceof ChainArtsStroke2
                            || skill instanceof ChainArtsStroke2Reinforce
                            || skill instanceof ChainArtsStroke2ReinforceWave
                            || skill instanceof ChainArtsTakedown
                            || skill instanceof ChainArtsTakedownBeat
                            || skill instanceof ChainArtsTakedownFinish
                            || skill instanceof ChainArtsTakedownWave
                            || skill instanceof SummonBeatingNeedleBat1
                            || skill instanceof SummonBeatingNeedleBat2
                            || skill instanceof SummonBeatingNeedleBat3
                            || skill instanceof SummonCuttingScimitar
                            || skill instanceof SummonReleasingBomb
                            || skill instanceof SummonScratchingClaw
                            || skill instanceof SummonShootingShotgun
                            || skill instanceof SummonSlashingKnife
                            || skill instanceof SummonStrikingBrick
                            || skill instanceof SummonThrowingWingDagger
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    getStart().before(chainArtsFuryEndTime)
                    && cooldownCheck(chainArtsFury)
                    && !(skill instanceof ChainArtsFury)
            ) {
                addSkillEvent(chainArtsFury);
            }
            if (
                    skill instanceof SummonBeatingNeedleBat1
                    || skill instanceof SummonBeatingNeedleBat2
                    || skill instanceof SummonBeatingNeedleBat3
                    || skill instanceof SummonCuttingScimitar
                    || skill instanceof SummonReleasingBomb
                    || skill instanceof SummonScratchingClaw
                    || skill instanceof SummonShootingShotgun
                    || skill instanceof SummonSlashingKnife
                    || skill instanceof SummonStrikingBrick
                    || skill instanceof SummonThrowingWingDagger
                    || skill instanceof SummonThrowingWingDaggerBomb
            ) {
                if (cooldownCheck(weaponVariety)) {
                    addSkillEvent(weaponVariety);
                    weaponVarietyCnt++;
                }
                if (
                        cooldownCheck(weaponVarietyFinale)
                        && weaponVarietyCnt >= 4
                ) {
                    addSkillEvent(weaponVarietyFinale);
                    weaponVarietyCnt = 0;
                }
            }
            if (
                    skill instanceof SummonBeatingNeedleBat1
                    || skill instanceof SummonBeatingNeedleBat2
                    || skill instanceof SummonBeatingNeedleBat3
                    || skill instanceof SummonCuttingScimitar
                    || skill instanceof SummonReleasingBomb
                    || skill instanceof SummonScratchingClaw
                    || skill instanceof SummonShootingShotgun
                    || skill instanceof SummonSlashingKnife
                    || skill instanceof SummonStrikingBrick
                    || skill instanceof SummonThrowingWingDagger
                    || skill instanceof SummonThrowingWingDaggerBomb
                    || skill instanceof ChainArtsCrush
                    || skill instanceof WeaponVariety
                    || skill instanceof ChainArtsStroke1
                    || skill instanceof ChainArtsStroke1Cancle
                    || skill instanceof ChainArtsStroke2
                    || skill instanceof ChainArtsStroke2Reinforce
                    || skill instanceof ChainArtsStroke2ReinforceWave
                    || skill instanceof ChainArtsTakedown
                    || skill instanceof ChainArtsTakedownBeat
                    || skill instanceof ChainArtsTakedownFinish
            ) {
                if (getStart().before(professionalAgentEndTime)) {
                    addSkillEvent(professionalAgentBomb);
                }
            }
            if (
                    skill instanceof ChainArtsTakedown
                    || skill instanceof ChainArtsCrush
                    || skill instanceof ChainArtsTakedownBeat
                    || skill instanceof ChainArtsTakedownFinish
            ) {
                weaponVarietyFinale.setActivateTime(new Timestamp(weaponVarietyFinale.getActivateTime().getTime() - 2000));
            }
            if (skill instanceof ChainArtsFury) {
                weaponVarietyFinale.setActivateTime(new Timestamp(weaponVarietyFinale.getActivateTime().getTime() - 1000));
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
                        if (
                                getStart().before(professionalAgentEndTime)
                                && (
                                        skill instanceof ADOrdnance
                                        || skill instanceof SummonThrowingWingDagger
                                )
                        ) {
                            getSkillEventList().add(new SkillEvent(professionalAgentBomb, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        Timestamp temp = new Timestamp(getStart().getTime());
                        getStart().setTime(getStart().getTime() + i);
                        if (
                                getStart().before(chainArtsFuryEndTime)
                                && cooldownCheck(chainArtsFury)
                                && !(skill instanceof CrestOfTheSolarDot)
                                && !(skill instanceof SpiderInMirrorDot)
                        ) {
                            addSkillEvent(chainArtsFury);
                        }
                        if (skill instanceof SummonThrowingWingDagger) {
                            if (cooldownCheck(weaponVariety)) {
                                addSkillEvent(weaponVariety);
                                weaponVarietyCnt ++;
                            }
                        }
                        getStart().setTime(temp.getTime());
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (
                                skill instanceof ADOrdnance
                                && i < 500
                        ) {
                            i += 1080;
                        }
                        if (skill instanceof ChainArtsTakedownWave) {
                            if (getStart().before(professionalAgentEndTime)) {
                                getSkillEventList().add(new SkillEvent(professionalAgentBomb, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
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
    public void applyCooldown(Skill skill) {
        if (skill instanceof WeaponVarietyFinale) {
            long remainTime = getStart().getTime() - skill.getActivateTime().getTime();
            if (remainTime >= 22000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 11000));
            } else if (remainTime >= 11000) {
                skill.setActivateTime(new Timestamp(getStart().getTime()));
            } else {
                skill.setActivateTime(new Timestamp(getStart().getTime() + 11000 - remainTime));
            }
            return;
        }
        if (skill instanceof ChainArtsStroke2Reinforce) {
            long remainTime = getStart().getTime() - skill.getActivateTime().getTime();
            if (remainTime >= 20000) {
                skill.setActivateTime(new Timestamp(getStart().getTime() - 10000));
            } else if (remainTime >= 10000) {
                skill.setActivateTime(new Timestamp(getStart().getTime()));
            } else {
                skill.setActivateTime(new Timestamp(getStart().getTime() + 10000 - remainTime));
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
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
            boolean isProfessionalAgent = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof ProfessionalAgent) {
                    isProfessionalAgent = true;
                    break;
                }
            }
            if (isProfessionalAgent) {
                weaponVarietyBuff.setBuffFinalDamage(2.76);
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
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            if (isProfessionalAgent) {
                weaponVarietyBuff.setBuffFinalDamage(1.88);
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public Long getDotDamage(AttackSkill attackSkill, BuffSkill buffSkill) {
        Long attackDamage;
        if (buffSkill.getBuffDamage() >= 140) {
            attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat() + ((CadenaContinuous) getJob()).getFinalSubStat2()) * 0.01
                            * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                            * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                            + getJob().getPerXAtt())
                            * getJob().getConstant()
                            * getJob().getMastery()
                            * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                            * (1 + (getJob().getBossDamage() + 140 - 280) * 0.01 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
            );
        } else {
            attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat() + ((CadenaContinuous) getJob()).getFinalSubStat2()) * 0.01
                            * (Math.floor((getJob().getAtt() + buffSkill.getBuffAttMagic())
                            * (1 + (getJob().getAttP() + buffSkill.getBuffAttMagicPer()) * 0.01))
                            + getJob().getPerXAtt())
                            * getJob().getConstant()
                            * getJob().getMastery()
                            * attackSkill.getDamage() * 0.01 * attackSkill.getAttackCount()
                            * (1 + (getJob().getBossDamage() - 280) * 0.01 - 0.5 * (1 - (getJob().getProperty() + buffSkill.getBuffProperty()) * 0.01))
            );
        }
        return attackDamage;
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
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
                            + getJob().getFinalSubstat() + ((CadenaContinuous) getJob()).getFinalSubStat2()) * 0.01
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
        return attackDamage;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        if (skill instanceof ChainArtsMaelstrom) {
            List<SkillEvent> remove = new ArrayList<>();
            for (SkillEvent skillEvent : getSkillEventList()) {
                if (
                        skillEvent.getStart().after(getStart())
                        && skillEvent.getSkill() instanceof ChainArtsMaelstrom
                ) {
                    remove.add(skillEvent);
                }
            }
            getSkillEventList().removeAll(remove);
        }
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    skill instanceof ChainArtsMassacre1
                    || skill instanceof ChainArtsMassacre2
                    || skill instanceof ChainArtsMassacre3
            ) {
                if (getStart().before(professionalAgentEndTime)) {
                    getSkillEventList().add(new SkillEvent(professionalAgentBomb, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
                }
            }
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Timestamp temp = new Timestamp(getStart().getTime());
            getStart().setTime(getStart().getTime() + sum);
            if (
                    getStart().before(chainArtsFuryEndTime)
                    && cooldownCheck(chainArtsFury)
                    && !(skill instanceof ChainArtsMaelstrom)
                    && !(skill instanceof ADOrdnanceSphere)
                    && !(skill instanceof ChainArtsTakedownBeat)
                    && !(skill instanceof ChainArtsTakedownFinish)
                    && !(skill instanceof WeaponVarietyFinale)
                    && !(skill instanceof SummonReleasingBomb)
            ) {
                addSkillEvent(chainArtsFury);
            }
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof ChainArtsMassacre1
                            || skill instanceof ChainArtsMassacre2
                            || skill instanceof ChainArtsMassacre3
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            getStart().setTime(temp.getTime());
        }
    }

    @Override
    public void getJobInfo() {
        System.out.println("-------------------");
        System.out.println("직업 : " + getJob().getName());
        System.out.println("기본 주스탯 수치 : " + getJob().getMainStat());
        System.out.println("주스탯 % 수치 : " + (getJob().getMainStatP() + getJob().getAllStatP()));
        System.out.println("% 미적용 주스탯 수치 : " + getJob().getPerXMainStat());
        System.out.println("기본 부스탯 수치 : " + getJob().getSubStat());
        System.out.println("부스탯 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXSubStat());
        System.out.println("기본 부스탯2 수치 : " + getJob().getOtherStat1());
        System.out.println("부스탯2 % 수치 : " + getJob().getAllStatP());
        System.out.println("% 미적용 부스탯 수치 : " + getJob().getPerXOtherStat());
        System.out.println("기본 스공 : " + getJob().getStatDamage());
        System.out.println("데미지 : " + getJob().getDamage());
        System.out.println("최종데미지 : " + getJob().getFinalDamage());
        System.out.println("보스 데미지 : " + getJob().getBossDamage());
        System.out.println("방어율 무시 : " + getJob().getIgnoreDefense());
        System.out.println("크리티컬 확률 : " + getJob().getCriticalP());
        System.out.println("장비 공격력 % : " + getJob().getAttP());
        System.out.println("장비 마력 % : " + getJob().getMagicP());
        System.out.println("크리티컬 데미지 : " + getJob().getCriticalDamage());
        System.out.println("쿨타임 감소 초 : " + getJob().getCooldownReductionSec());
        System.out.println("쿨타임 감소 % : " + getJob().getCooldownReductionP());
        System.out.println("버프 지속 시간 : " + getJob().getPlusBuffDuration());
        System.out.println("재사용 : " + getJob().getReuse());
        System.out.println("속성 내성 무시 : " + getJob().getProperty());
        System.out.println("무기 공격력 : " + getJob().getWeaponAttMagic());
        System.out.println(getJob().getLinkListStr());
        System.out.println(getJob().getAbility().getDescription());
    }
}
