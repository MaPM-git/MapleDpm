package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.khali.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.khali.Oblivion;
import org.mapledpmlab.type.skill.buffskill.khali.ResonateUltimatum;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class KhaliDealCycle extends DealCycle {

    // 6차, 리레
    private List<Skill> dealCycle1 = new ArrayList<>();

    // 리레
    private List<Skill> dealCycle2 = new ArrayList<>();

    // 준극딜
    private List<Skill> dealCycle3 = new ArrayList<>();

    private List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ArtsAstra());
            add(new ArtsAstraFinish());
            add(new ArtsCrescentum());
            add(new ArtsFlurry());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DeathBlossom());
            add(new DeceivingBlade());
            add(new HexChakramFury());
            add(new HexChakramSplit());
            add(new HexChakramSweep());
            add(new HexPandemonium());
            add(new HexPandemoniumFinish());
            add(new HexSandStormBomb());
            add(new HexSandStormKeydown());
            add(new HexSandStormSlash());
            add(new MagicCircuitFullDrive());
            add(new Resonate());
            add(new ResonateAwakening());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new VoidBlitz());
            add(new VoidBurstCombo());
            add(new VoidBurstSlash());
            add(new VoidRush());
        }
    };

    private List<AttackSkill> delaySkillList = new ArrayList<>(){
        {
            add(new HexChakramFuryBeforeDelay());
            add(new HexSandStormBeforeDelay());
        }
    };

    private List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new GrandisGoddessBlessingLef(477L));
            add(new MagicCircuitFullDriveBuff());
            add(new Oblivion());
            add(new PriorPreparation());
            add(new ReadyToDie());
            add(new ResonateUltimatum());
            add(new RestraintRing());
            add(new SoulContract());
            add(new ThiefCunning());
            //add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WrathOfGod());
        }
    };

    ArtsAstra artsAstra = new ArtsAstra();
    DeceivingBlade deceivingBlade = new DeceivingBlade();
    MagicCircuitFullDrive magicCircuitFullDrive = new MagicCircuitFullDrive();
    Resonate resonate = new Resonate();
    ResonateAwakening resonateAwakening = new ResonateAwakening();
    ResonateUltimatum resonateUltimatum = new ResonateUltimatum();
    VoidBlitz voidBlitz = new VoidBlitz();
    VoidRush voidRush = new VoidRush();

    Timestamp magicCircuitFullDriveEndTime = new Timestamp(-1);

    int chakriCnt = 0;
    int rushCnt = 0;

    boolean afterBlitz = false;

    Timestamp deathBlossomEndTime = new Timestamp(-1);
    Timestamp deathBlossomInterval = new Timestamp(-1);
    Timestamp oblivionEndTime = new Timestamp(-1);
    Timestamp resonateUltimatumEndTime = new Timestamp(-1);
    Timestamp soulContractEndTime = new Timestamp(-1);

    public KhaliDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setDelaySkillList(delaySkillList);
        this.setBuffSkillList(buffSkillList);

        ArtsCrescentum artsCrescentum = new ArtsCrescentum();
        ArtsFlurry artsFlurry = new ArtsFlurry();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DeathBlossom deathBlossom = new DeathBlossom();
        GrandisGoddessBlessingLef grandisGoddessBlessingLef = new GrandisGoddessBlessingLef(477L);
        HexChakramFuryBeforeDelay hexChakramFuryBeforeDelay = new HexChakramFuryBeforeDelay();
        HexChakramSplit hexChakramSplit = new HexChakramSplit();
        HexChakramSweep hexChakramSweep = new HexChakramSweep();
        HexPandemonium hexPandemonium = new HexPandemonium();
        HexSandStormBeforeDelay hexSandStormBeforeDelay = new HexSandStormBeforeDelay();
        MagicCircuitFullDriveBuff magicCircuitFullDriveBuff = new MagicCircuitFullDriveBuff();
        Oblivion oblivion = new Oblivion();
        PriorPreparation priorPreparation = new PriorPreparation();
        ReadyToDie readyToDie = new ReadyToDie();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        ThiefCunning thiefCunning = new ThiefCunning();
        VoidBurstCombo voidBurstCombo = new VoidBurstCombo();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WrathOfGod wrathOfGod = new WrathOfGod();

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(thiefCunning) * 1000) {
            getSkillEventList().add(new SkillEvent(thiefCunning, new Timestamp(i), new Timestamp(i + 10000)));
            getEventTimeList().add(new Timestamp(i));
        }

        for (int i = 0; i < 720 * 1000; i += applyCooldownReduction(priorPreparation) * 1000) {
            getSkillEventList().add(new SkillEvent(priorPreparation, new Timestamp(i), new Timestamp(i + 20000)));
            getEventTimeList().add(new Timestamp(i));
        }

        ringSwitching.setCooldown(90.0);

        dealCycle1.add(wrathOfGod);
        dealCycle1.add(magicCircuitFullDriveBuff);
        dealCycle1.add(crestOfTheSolar);
        dealCycle1.add(spiderInMirror);
        dealCycle1.add(grandisGoddessBlessingLef);
        dealCycle1.add(resonateUltimatum);
        dealCycle1.add(oblivion);
        dealCycle1.add(deathBlossom);
        dealCycle1.add(readyToDie);
        dealCycle1.add(soulContract);
        dealCycle1.add(restraintRing);
        dealCycle1.add(hexPandemonium);
        dealCycle1.add(voidBlitz);
        dealCycle1.add(hexSandStormBeforeDelay);
        dealCycle1.add(hexChakramSplit);
        dealCycle1.add(voidBlitz);
        dealCycle1.add(voidBurstCombo);

        dealCycle2.add(wrathOfGod);
        dealCycle2.add(magicCircuitFullDriveBuff);
        dealCycle2.add(grandisGoddessBlessingLef);
        dealCycle2.add(resonateUltimatum);
        dealCycle2.add(oblivion);
        dealCycle2.add(deathBlossom);
        dealCycle2.add(readyToDie);
        dealCycle2.add(soulContract);
        dealCycle2.add(restraintRing);
        dealCycle2.add(hexPandemonium);
        dealCycle2.add(voidBlitz);
        dealCycle2.add(artsCrescentum);
        dealCycle2.add(hexChakramSplit);
        dealCycle2.add(voidBlitz);
        dealCycle2.add(voidBurstCombo);

        //dealCycle3.add(soulContract);

        soulContract.setApplyReuse(true);

        while (getStart().before(getEnd())) {
            if (
                    getStart().after(magicCircuitFullDriveEndTime)
                    && getStart().before(new Timestamp(120 * 1000))
                    && getStart().after(new Timestamp(50 * 1000))
            ) {
                addSkillEvent(magicCircuitFullDriveBuff);
            }
            if (
                    cooldownCheck(dealCycle1)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle1);
            } else if (
                    cooldownCheck(dealCycle2)
                    && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addDealCycle(dealCycle2);
            }/* else if (
                    cooldownCheck(dealCycle3)
            ) {
                addDealCycle(dealCycle3);
            } else if (
                    cooldownCheck(ringSwitching)
                    && getStart().after(new Timestamp(80 * 1000))
                    && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            }*/ else if (
                    cooldownCheck(deathBlossom)
                    && !cooldownCheck(wrathOfGod)
            ) {
                addSkillEvent(deathBlossom);
                addSkillEvent(readyToDie);
            } else if (
                    cooldownCheck(soulContract)
                    && getStart().after(soulContractEndTime)
                    && getStart().before(new Timestamp(wrathOfGod.getActivateTime().getTime() + 10000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(artsCrescentum)
                    && afterBlitz
                    && !cooldownCheck(resonateUltimatum)
            ) {
                addSkillEvent(artsCrescentum);
            } else if (
                    cooldownCheck(hexPandemonium)
                    && !cooldownCheck(resonateUltimatum)
            ) {
                addSkillEvent(hexPandemonium);
            } else if (
                    cooldownCheck(hexChakramSplit)
                    && !cooldownCheck(resonateUltimatum)
            ) {
                addSkillEvent(hexChakramSplit);
            } else if (
                    cooldownCheck(hexChakramFuryBeforeDelay)
            ) {
                addSkillEvent(hexChakramFuryBeforeDelay);
            } else if (
                    cooldownCheck(hexChakramSweep)
            ) {
                addSkillEvent(hexChakramSweep);
            } else if (
                    cooldownCheck(artsCrescentum)
                    && !cooldownCheck(resonateUltimatum)
            ) {
                addSkillEvent(artsCrescentum);
            } else {
                addSkillEvent(artsFlurry);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            if (
                    skill instanceof VoidRush
                    && rushCnt != 0
            ) {
                rushCnt--;
            } else {
                return;
            }
        }
        if (cooldownCheck(voidRush)) {
            rushCnt = 0;
        }
        if (
                getStart().before(deathBlossomEndTime)
                && getStart().after(deathBlossomInterval)
        ) {
            chakriCnt += 3;
            if (getStart().before(resonateUltimatumEndTime)) {
                if (chakriCnt > 8) {
                    chakriCnt = 8;
                }
            } else {
                if (chakriCnt > 6) {
                    chakriCnt = 6;
                }
            }
            deathBlossomInterval = new Timestamp(deathBlossomInterval.getTime() + 2010);
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof SoulContract) {
                soulContractEndTime = new Timestamp(getStart().getTime() + 20000);
            }
            if (skill instanceof MagicCircuitFullDriveBuff) {
                magicCircuitFullDriveEndTime = new Timestamp(getStart().getTime() + 60000);
            }
            if (skill instanceof Oblivion) {
                oblivionEndTime = new Timestamp(getStart().getTime() + 30000);
                voidRush.setActivateTime(new Timestamp(-1));
                voidBlitz.setActivateTime(new Timestamp(-1));
            }
            if (skill instanceof ResonateUltimatum) {
                resonateUltimatumEndTime = new Timestamp(getStart().getTime() + 30000);
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
            if (
                    getStart().before(magicCircuitFullDriveEndTime)
                    && cooldownCheck(magicCircuitFullDrive)
                    && !(skill instanceof MagicCircuitFullDrive)
            ) {
                addSkillEvent(magicCircuitFullDrive);
            }
            if (
                    skill instanceof ArtsSkill
                    && cooldownCheck(artsAstra)
                    && !(skill instanceof ArtsAstra)
            ) {
                addSkillEvent(artsAstra);
            }
            if (skill instanceof ArtsCrescentum) {
                voidRush.setActivateTime(new Timestamp(voidRush.getActivateTime().getTime() - 5000));
                voidBlitz.setActivateTime(new Timestamp(voidBlitz.getActivateTime().getTime() - 5000));
            }
            if (skill instanceof ArtsFlurry) {
                voidRush.setActivateTime(new Timestamp(voidRush.getActivateTime().getTime() - 1000));
                voidBlitz.setActivateTime(new Timestamp(voidBlitz.getActivateTime().getTime() - 1000));
            }
            if (skill instanceof DeathBlossom) {
                deathBlossomEndTime = new Timestamp(getStart().getTime() + 30000);
                deathBlossomInterval = new Timestamp(getStart().getTime() + 2010);
            }
            if (
                    cooldownCheck(deceivingBlade)
                    && (
                            skill instanceof ArtsSkill
                            || skill instanceof HexSkill
                    )
            ) {
                addSkillEvent(deceivingBlade);
            }
            if (skill instanceof HexSkill) {
                for (int i = 0; i < chakriCnt; i++) {
                    if (getStart().before(resonateUltimatumEndTime)) {
                        addSkillEvent(resonateAwakening);
                    } else {
                        addSkillEvent(resonate);
                    }
                }
                chakriCnt = 0;
            }
            if (
                    skill instanceof VoidRush
                    || skill instanceof VoidBlitz
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 87) {
                    chakriCnt++;
                    if (getStart().before(resonateUltimatumEndTime)) {
                        if (chakriCnt > 8) {
                            chakriCnt = 8;
                        }
                    } else {
                        if (chakriCnt > 6) {
                            chakriCnt = 6;
                        }
                    }
                }
            }
            if (
                    !cooldownCheck(resonateUltimatum)
                    && (
                            skill instanceof ArtsCrescentum
                            || skill instanceof ArtsFlurry
                            || skill instanceof HexChakramFuryBeforeDelay
                            || skill instanceof HexChakramSplit
                            || skill instanceof HexChakramSweep
                            || skill instanceof HexPandemonium
                    )
            ) {
                Timestamp tmp = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + 150);
                if (cooldownCheck(voidBlitz)) {
                    if (skill instanceof HexChakramFuryBeforeDelay) {
                        skill.getRelatedSkill().setRelatedSkill(voidBlitz);
                    } else if (skill instanceof HexPandemonium) {
                        skill.setDelay(150L);
                        skill.getRelatedSkill().setRelatedSkill(voidBlitz);
                    } else {
                        skill.setDelay(150L);
                        skill.setRelatedSkill(voidBlitz);
                    }
                } else if (
                        cooldownCheck(voidRush)
                        || rushCnt != 0
                ) {
                    if (skill instanceof HexChakramFuryBeforeDelay) {
                        skill.getRelatedSkill().setRelatedSkill(voidRush);
                    } else if (skill instanceof HexPandemonium) {
                        skill.setDelay(150L);
                        skill.getRelatedSkill().setRelatedSkill(voidRush);
                    } else {
                        skill.setDelay(150L);
                        skill.setRelatedSkill(voidRush);
                    }
                } else {
                    if (skill instanceof ArtsCrescentum) {
                        skill.setDelayByAttackSpeed(630L);
                        skill.setRelatedSkill(null);
                    } else if (
                            skill instanceof ArtsFlurry
                            || skill instanceof HexChakramSplit
                    ) {
                        skill.setDelayByAttackSpeed(720L);
                        skill.setRelatedSkill(null);
                    } else if (skill instanceof HexChakramSweep) {
                        skill.setDelayByAttackSpeed(780L);
                        skill.setRelatedSkill(null);
                    } else if (skill instanceof HexChakramFuryBeforeDelay) {
                        skill.getRelatedSkill().setDelay(120L + 180);
                        skill.getRelatedSkill().setRelatedSkill(null);
                    } else if (skill instanceof HexPandemonium) {
                        skill.getRelatedSkill().setRelatedSkill(null);
                        skill.setDelay(600L);
                    }
                }
                getStart().setTime(tmp.getTime());
            }
            if (
                    skill instanceof VoidRush
                    && rushCnt == 0
            ) {
                rushCnt = 2;
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skill instanceof Resonate
                            || skill instanceof ResonateAwakening
                    ) {
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
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        if (skill instanceof VoidBurstCombo) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 87) {
                                chakriCnt++;
                                if (getStart().before(resonateUltimatumEndTime)) {
                                    if (chakriCnt > 8) {
                                        chakriCnt = 8;
                                    }
                                } else {
                                    if (chakriCnt > 6) {
                                        chakriCnt = 6;
                                    }
                                }
                            }
                        }
                        if (skill instanceof Resonate && attackCount != 0) {
                            skill = new Resonate();
                            ((Resonate) skill).addFinalDamage(0.55);
                        }
                        if (skill instanceof ResonateAwakening && attackCount != 0) {
                            skill = new ResonateAwakening();
                            ((ResonateAwakening) skill).addFinalDamage(0.55);
                        }
                        if (
                                skill instanceof ArtsSkill
                                || skill instanceof HexSkill
                        ) {
                            Timestamp temp = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (cooldownCheck(deceivingBlade)) {
                                addSkillEvent(deceivingBlade);
                            }
                            getStart().setTime(temp.getTime());
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
            if (
                    skill.getRelatedSkill() instanceof VoidBlitz
                    || skill.getRelatedSkill() instanceof VoidRush
            ) {
                chakriCnt++;
                if (getStart().before(resonateUltimatumEndTime)) {
                    if (chakriCnt > 8) {
                        chakriCnt = 8;
                    }
                } else {
                    if (chakriCnt > 6) {
                        chakriCnt = 6;
                    }
                }
            }
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            if (skill instanceof VoidBurstSlash) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 87) {
                    if (getStart().before(resonateUltimatumEndTime)) {
                        if (chakriCnt > 8) {
                            chakriCnt = 8;
                        }
                    } else {
                        if (chakriCnt > 6) {
                            chakriCnt = 6;
                        }
                    }
                }
            }
            sum += info;
            if (
                    skill instanceof ArtsSkill
                    || skill instanceof HexSkill
            ) {
                Timestamp temp = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (cooldownCheck(deceivingBlade)) {
                    addSkillEvent(deceivingBlade);
                }
                getStart().setTime(temp.getTime());
            }
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
        }
    }

    @Override
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (
                    getStart().before(oblivionEndTime)
                    && skill instanceof HexSkill
                    && !(skill instanceof HexPandemonium)
                    && !(skill instanceof HexSandStormBeforeDelay)
            ) {
                skill.setCooldown(skill.getCooldown() / 2);
            }
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= getJob().getReuse()) {
                } else  {
                    skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
                }
            } else {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + applyCooldownReduction(skill) * 1000)));
            }
            if (!skill.isApplyCooldownReduction()) {
                skill.setActivateTime(new Timestamp((int) (getStart().getTime() + skill.getCooldown() * 1000)));
            }
            if (
                    getStart().before(oblivionEndTime)
                    && skill instanceof HexSkill
                    && !(skill instanceof HexPandemonium)
                    && !(skill instanceof HexSandStormBeforeDelay)
            ) {
                skill.setCooldown(skill.getCooldown() * 2);
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
                if (skillEvent.getSkill() instanceof BuffSkill) {
                    useBuffSkillList.add(skillEvent);
                } else {
                    useAttackSkillList.add(skillEvent);
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isOblivion = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof Oblivion) {
                    isOblivion = true;
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
            }
            for (SkillEvent se : useAttackSkillList) {
                if (
                        isOblivion
                        && (
                                se.getSkill() instanceof HexSkill
                                || se.getSkill() instanceof VoidSkill
                        )
                ) {
                    buffSkill.addBuffFinalDamage(1.3);
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }
}
