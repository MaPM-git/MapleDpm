package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.archmageil.*;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.archmageil.Elquines;
import org.mapledpmlab.type.skill.buffskill.archmageil.FreezingBreathBuff;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArchMageILDealCycle extends DealCycle {

    private final List<Timestamp> jupiterThunderStartList = new ArrayList<>();

    private final List<Timestamp> jupiterThunderEndList = new ArrayList<>();

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new ChainLightning());
            add(new ChainLightningElectric());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new CryoShock());
            add(new ElquinesSummon());
            add(new FinalAttackArchMageIL());
            add(new FreezingBreath());
            add(new FrozenLightning1());
            add(new FrozenLightning2());
            add(new FrozenLightningEnlightenmentOfMana());
            add(new FrozenOrb());
            add(new IceAge());
            add(new IceAgeDot());
            add(new IceAura());
            add(new IceAuraInstall());
            add(new JupiterThunder());
            add(new JupiterThunderElectric());
            add(new LightningSphereDelay());
            add(new LightningSphere());
            add(new LightningSphereFinish());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new SpiritOfSnow());
            add(new ThunderBreak());
            add(new ThunderSpear());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new Elquines());
            add(new EpicAdventure());
            add(new FreezingBreathBuff());
            add(new Infinity(0L));
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new UnstableMemorize());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int frostEffect = 5;
    int cryoShockCount = 0;
    ChainLightningElectric chainLightningElectric1 = new ChainLightningElectric();
    ChainLightningElectric chainLightningElectric2 = new ChainLightningElectric();
    ChainLightningElectric chainLightningElectric3 = new ChainLightningElectric();
    ChainLightningElectric chainLightningElectric4 = new ChainLightningElectric();

    ChainLightning chainLightning = new ChainLightning();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    CryoShock cryoShock = new CryoShock();
    ElquinesSummon elquinesSummon = new ElquinesSummon();
    EpicAdventure epicAdventure = new EpicAdventure();
    FreezingBreathBuff freezingBreathBuff = new FreezingBreathBuff();
    FrozenLightning1 frozenLightning1 = new FrozenLightning1();
    FrozenOrb frozenOrb = new FrozenOrb();
    IceAgeDot iceAgeDot = new IceAgeDot();
    IceAura iceAura = new IceAura();
    IceAuraInstall iceAuraInstall = new IceAuraInstall();
    Infinity infinity = new Infinity(0L);
    JupiterThunder jupiterThunder = new JupiterThunder();
    LightningSphereDelay lightningSphere = new LightningSphereDelay();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    SpiritOfSnow spiritOfSnow = new SpiritOfSnow();
    ThunderBreak thunderBreak = new ThunderBreak();
    ThunderSpear thunderSpear = new ThunderSpear();
    UnstableMemorize unstableMemorize = new UnstableMemorize();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    Timestamp infinityEndTime = new Timestamp(0);
    Timestamp infinityFinalTime = new Timestamp(0);

    public ArchMageILDealCycle(Job job) {
        super(job, new FinalAttackArchMageIL());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);


        // 인피니티 달구기
        getStart().setTime(-75000 - 4500);
        infinity.setActivateTime(new Timestamp(-80000));
        thunderSpear.setActivateTime(new Timestamp(-80000));
        addSkillEvent(infinity);
        addSkillEvent(thunderSpear);
        getStart().setTime(0);

        mapleWorldGoddessBlessing.setCooldown(120.0);

        for (int i = 0; i < 720 * 1000; i += iceAura.getInterval()) {
            getSkillEventList().add(new SkillEvent(iceAura, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        unstableMemorize.setDelay(60L);
    }

    @Override
    public void setSoloDealCycle() {
        int dealCycleOrder = 1;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(elquinesSummon)) {
                addSkillEvent(elquinesSummon);
            }
            if (
                    cooldownCheck(infinity)
                            && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
            ) {
                addSkillEvent(thunderSpear);
                addSkillEvent(infinity);
                if (getStart().before(new Timestamp(10 * 60 * 1000))) {
                    addSkillEvent(ringSwitching);
                }
            }
            if (
                    cooldownCheck(unstableMemorize)
                    && getStart().after(new Timestamp(infinityEndTime.getTime() - 5000))
            ) {
                unstableMemorize = new UnstableMemorize();
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 1) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.8);
                } else if (ran <= 7) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.77);
                } else if (ran <= 13) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.76);
                } else if (ran <= 19) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.75);
                } else if (ran <= 29) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.73);
                } else if (ran <= 40) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.7);
                } else if (ran <= 52) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.67);
                } else if (ran <= 64) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.65);
                } else if (ran <= 76) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.62);
                } else if (ran <= 84) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.60);
                } else if (ran <= 90) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.55);
                } else if (ran <= 95) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.5);
                } else if (ran <= 97) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.45);
                } else if (ran <= 99) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.4);
                } else if (ran <= 100) {
                    unstableMemorize.setCooldown(unstableMemorize.getCooldown() * 0.35);
                }
                addSkillEvent(thunderSpear);
                addSkillEvent(unstableMemorize);
                if (getStart().before(new Timestamp(10 * 60 * 1000))) {
                    addSkillEvent(ringSwitching);
                }
            }
            if (
                    cooldownCheck(jupiterThunder)
                    && getStart().before(new Timestamp(660 * 1000))
            ) {
                getNukeTimeList().add(new Timestamp(getStart().getTime()));
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(chainLightning);
                }
                while (!cooldownCheck(iceAuraInstall)) {
                    addSkillEvent(chainLightning);
                }
                addSkillEvent(iceAuraInstall);
                addSkillEvent(spiritOfSnow);
                addSkillEvent(soulContract);
                addSkillEvent(freezingBreathBuff);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(iceAgeDot);
                addSkillEvent(jupiterThunder);
                if (cooldownCheck(frozenLightning1)) {
                    addSkillEvent(frozenLightning1);
                }
                addSkillEvent(frozenOrb);
                while (!cooldownCheck(thunderBreak)) {
                    addSkillEvent(chainLightning);
                }
                addSkillEvent(thunderBreak);
                addSkillEvent(lightningSphere);
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(iceAgeDot)
                    && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(iceAuraInstall);
                addSkillEvent(soulContract);
                addSkillEvent(iceAgeDot);
                addSkillEvent(lightningSphere);
            } else if (
                    getStart().after(new Timestamp(thunderBreak.getActivateTime().getTime() - 1000))
                            && !cooldownCheck(epicAdventure)
            ) {
                while (!cooldownCheck(thunderBreak)) {
                    addSkillEvent(chainLightning);
                }
                addSkillEvent(thunderBreak);
            } else if (
                    cooldownCheck(frozenOrb)
                            && !cooldownCheck(epicAdventure)
            ) {
                addSkillEvent(frozenOrb);
            } else {
                addSkillEvent(chainLightning);
            }
        }
        sortEventTimeList();
    }

    @Override
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        boolean isJupiter = false;
        if (
                skillEvent.getSkill() instanceof ThunderAttack
                && !(skillEvent.getSkill() instanceof FrozenLightning1)
                && !(skillEvent.getSkill() instanceof FrozenLightning2)
                && !(skillEvent.getSkill() instanceof FrozenLightningEnlightenmentOfMana)
        ) {
            for (int i = 0; i < jupiterThunderStartList.size(); i++) {
                if (
                        (start.after(jupiterThunderStartList.get(i)) || start.equals(jupiterThunderStartList.get(i)))
                        && (end.before(jupiterThunderEndList.get(i)) || end.equals(jupiterThunderEndList.get(i)))
                ) {
                    buffSkill.addBuffFinalDamage(1.12);
                    isJupiter = true;
                }
            }
        }
        if (skillEvent.getSkill() instanceof ThunderAttack) {
            if (
                    frostEffect > 0
                    && skillEvent.getStart().equals(start)
                    && (
                            !(skillEvent.getSkill() instanceof FrozenLightning1)
                            && !(skillEvent.getSkill() instanceof FrozenLightning2)
                            && !(skillEvent.getSkill() instanceof FrozenLightningEnlightenmentOfMana)
                            && !(skillEvent.getSkill() instanceof ChainLightningElectric)
                            && !(skillEvent.getSkill() instanceof ThunderSpear)
                    )
            ) {
                frostEffect --;
                cryoShockCount ++;
            }
            if (
                    cryoShockCount >= 13
                            && !(skillEvent.getSkill() instanceof CryoShock)
            ) {
                getAttackDamage(new SkillEvent(cryoShock, start, end), buffSkill, start, end);
                cryoShockCount -= 13;
            }
            buffSkill.addBuffDamage(12L * frostEffect);
        }
        if (
                skillEvent.getStart().equals(start)
                && (
                    skillEvent.getSkill() instanceof FreezingBreath
                    || skillEvent.getSkill() instanceof FinalAttackArchMageIL
                    || skillEvent.getSkill() instanceof FrozenOrb
                    || skillEvent.getSkill() instanceof ElquinesSummon
                    || skillEvent.getSkill() instanceof IceAura
                    || skillEvent.getSkill() instanceof IceAuraInstall
                    || skillEvent.getSkill() instanceof IceAge
                    || skillEvent.getSkill() instanceof IceAgeDot
                )
        ) {
            frostEffect ++;
        }
        if (skillEvent.getSkill() instanceof SpiritOfSnow) {
            frostEffect += 3;
        }
        if (frostEffect > 5) {
            frostEffect = 5;
        }
        buffSkill.addBuffCriticalDamage(3.0 * frostEffect);
        buffSkill.addBuffIgnoreDefense(2L * frostEffect);
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
        if (skillEvent.getSkill() instanceof ThunderAttack) {
            buffSkill.addBuffDamage(-12L * frostEffect);
        }
        buffSkill.addBuffCriticalDamage(-3.0 * frostEffect);
        buffSkill.addBuffIgnoreDefense(-2L * frostEffect);
        if (isJupiter) {
            buffSkill.setBuffFinalDamage(buffSkill.getBuffFinalDamage() / 1.12);
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
        if (skill instanceof JupiterThunder) {
            jupiterThunderStartList.add(new Timestamp(getStart().getTime()));
            jupiterThunderEndList.add(new Timestamp(getStart().getTime() + 10000));
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
                if (skill instanceof Infinity) {
                    infinityEndTime = new Timestamp(getStart().getTime() + 123000);
                    infinityFinalTime = new Timestamp(getStart().getTime() + 75000);
                    for (long i = 0; i < 75000; i += 5000) {
                        getSkillEventList().add(new SkillEvent(new Infinity(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 5000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 5000));
                    }
                    getSkillEventList().add(new SkillEvent(new Infinity(75000L), new Timestamp(getStart().getTime() + 75000), new Timestamp(getStart().getTime() + 123000)));
                    endTime = new Timestamp(getStart().getTime() + 123000);
                } else {
                    endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                    if (skill.isApplyServerLag()) {
                        endTime = new Timestamp(endTime.getTime() + 3000);
                    }
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                if (skill.isApplyServerLag()) {
                    endTime = new Timestamp(endTime.getTime() + 3000);
                }
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (skill instanceof ChainLightningElectric) {
                        continue;
                    }
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
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof IceAgeDot) {
                        i = 720;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof FrozenOrb) {
                        i = 1680;
                    }
                    if (skill instanceof ChainLightningElectric) {
                        i = 1140;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
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
                if (skill instanceof ChainLightning) {
                    for (int i = 0; i < 11; i ++) {
                        Long ran = (long) (Math.random() * 99 + 1);
                        if (ran <= 35) {
                            if (cooldownCheck(chainLightningElectric1)) {
                                addSkillEvent(chainLightningElectric1);
                            } else if (cooldownCheck(chainLightningElectric2)) {
                                addSkillEvent(chainLightningElectric2);
                            } else if (cooldownCheck(chainLightningElectric3)) {
                                addSkillEvent(chainLightningElectric3);
                            } else if (cooldownCheck(chainLightningElectric4)) {
                                addSkillEvent(chainLightningElectric4);
                            }
                        }
                        /*if (cooldownCheck(chainLightningElectric1)) {
                            addSkillEvent(chainLightningElectric1);
                        } else if (ran <= 35) {
                            Long attackCount = 0L;
                            for (long i = chainLightningElectric.getInterval(); i <= chainLightningElectric.getDotDuration() && attackCount < chainLightningElectric.getLimitAttackCount(); i += chainLightningElectric.getInterval()) {
                                getSkillEventList().add(new SkillEvent(chainLightningElectric, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                                getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                                attackCount += 1;
                            }
                        }*/
                    }
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
}
