package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.adele.*;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.adele.RestoreBuff;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class AdeleDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new Blossom(0L));
            add(new Creation(0L));
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new Devide());
            add(new DevideReinforce());
            add(new Ether());
            add(new Gathering(0L));
            add(new Grave());
            add(new Impale());
            add(new Infinite());
            add(new Maestro());
            add(new MaestroFinish());
            add(new MagicCircuitFullDrive());
            add(new Marker());
            add(new Order());
            add(new OrderRestore());
            add(new Resonance());
            add(new Restore());
            add(new Ruin());
            add(new RuinFinish());
            add(new Shard());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new Squall());
            add(new Storm(0L));
            add(new Territory());
            add(new TerritoryEnd());
            add(new Tread());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new GrandisGoddessBlessingLef(442L));
            add(new MagicCircuitFullDriveBuff());
            add(new RestoreBuff());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            //add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
            add(new WrathOfGod());
        }
    };

    Creation creation = new Creation(0L);
    DevideReinforce devideReinforce = new DevideReinforce();
    Ether et = new Ether();
    Gathering gathering = new Gathering(0L);
    MagicCircuitFullDrive magicCircuitFullDrive = new MagicCircuitFullDrive();
    Shard shard = new Shard();
    Storm storm = new Storm(0L);

    Long ether = 100L;
    Long etherSword = 3L;

    Timestamp magicCircuitFullDriveEndTime = new Timestamp(-1);
    Timestamp restoreEndTime = new Timestamp(-1);

    public AdeleDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        Devide devide = new Devide();
        GrandisGoddessBlessingLef grandisGoddessBlessingLef = new GrandisGoddessBlessingLef(442L);
        Grave grave = new Grave();
        Impale impale = new Impale();
        Infinite infinite = new Infinite();
        Maestro maestro = new Maestro();
        MagicCircuitFullDriveBuff magicCircuitFullDriveBuff = new MagicCircuitFullDriveBuff();
        Marker marker = new Marker();
        Order order1 = new Order();
        Order order2 = new Order();
        Order order3 = new Order();
        OrderRestore orderRestore = new OrderRestore();
        RestoreBuff restoreBuff = new RestoreBuff();
        RestraintRing restraintRing = new RestraintRing();
        RingSwitching ringSwitching = new RingSwitching();
        Ruin ruin = new Ruin();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();
        Squall squall = new Squall();
        Territory territory = new Territory();
        WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());
        WrathOfGod wrathOfGod = new WrathOfGod();

        ringSwitching.setCooldown(90.0);

        impale.setCooldown(30.0);       // 스택 유지만

        auraWeaponBuff.setCooldown(180.0);
        grandisGoddessBlessingLef.setCooldown(240.0);

        addSkillEvent(grave);
        etherSword = 3L;
        while (getStart().before(getEnd())) {
            if (cooldownCheck(order1)) {
                addSkillEvent(order1);
            }
            if (cooldownCheck(order2)) {
                addSkillEvent(order2);
            }
            if (cooldownCheck(order3)) {
                addSkillEvent(order3);
            }
            if (
                    cooldownCheck(auraWeaponBuff)
                    && cooldownCheck(impale)
                    && cooldownCheck(wrathOfGod)
                    && cooldownCheck(restoreBuff)
                    && cooldownCheck(infinite)
                    && cooldownCheck(gathering)
                    && cooldownCheck(squall)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(restraintRing)
                    && cooldownCheck(storm)
                    && cooldownCheck(ruin)
                    && cooldownCheck(marker)
                    && etherSword == 3
            ) {
                addSkillEvent(auraWeaponBuff);
                addSkillEvent(impale);
                addSkillEvent(wrathOfGod);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    addSkillEvent(devide);
                }
                addSkillEvent(magicCircuitFullDriveBuff);
                if (cooldownCheck(grandisGoddessBlessingLef)) {
                    if (getStart().before(new Timestamp(10 * 1000))) {
                        grandisGoddessBlessingLef.setCooldown(360.0);
                    } else if (getStart().after(new Timestamp(5 * 60 * 1000))) {
                        grandisGoddessBlessingLef.setCooldown(180.0);
                    }
                    addSkillEvent(grandisGoddessBlessingLef);
                }
                addSkillEvent(restoreBuff);
                addSkillEvent(orderRestore);
                addSkillEvent(infinite);
                addSkillEvent(gathering);
                addSkillEvent(squall);
                addSkillEvent(soulContract);
                addSkillEvent(restraintRing);
                addSkillEvent(storm);
                addSkillEvent(ruin);
                addSkillEvent(marker);
                if (cooldownCheck(maestro)) {
                    addSkillEvent(maestro);
                }
            } else if (
                    cooldownCheck(storm)
                    && etherSword == 3
                    && !cooldownCheck(wrathOfGod)
            ) {
                addSkillEvent(storm);
            } else if (
                    cooldownCheck(soulContract)
                    && cooldownCheck(ruin)
                    && cooldownCheck(marker)
                    && getStart().before(new Timestamp(auraWeaponBuff.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(soulContract);
                addSkillEvent(ruin);
                addSkillEvent(marker);
            } else if (cooldownCheck(territory)) {
                addSkillEvent(territory);
            } else if (
                    cooldownCheck(gathering)
                    && etherSword > 1
                    && !cooldownCheck(auraWeaponBuff)
            ) {
                addSkillEvent(gathering);
            } else if (
                    cooldownCheck(impale)
                    && !cooldownCheck(auraWeaponBuff)
            ) {
                addSkillEvent(impale);
            } else if (cooldownCheck(shard)) {
                addSkillEvent(shard);
            } else {
                addSkillEvent(devide);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(restoreEndTime)) {
            if (etherSword < 4 && ether >= 100) {
                ether -= 100;
                etherSword++;
            }
            if (etherSword == 4 && ether > 100) {
                ether = 100L;
            }
        } else {
            if (etherSword < 3 && ether >= 100) {
                ether -= 100;
                etherSword++;
            }
            if (etherSword == 3 && ether > 100) {
                ether = 100L;
            }
        }

        if (getStart().before(skill.getActivateTime())) {
            return;
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof MagicCircuitFullDriveBuff) {
                magicCircuitFullDriveEndTime = new Timestamp(getStart().getTime() + 60000);
            }
            if (skill instanceof RestoreBuff) {
                restoreEndTime = new Timestamp(getStart().getTime() + 30000);
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
                    getStart().before(magicCircuitFullDriveEndTime)
                    && cooldownCheck(magicCircuitFullDrive)
                    && !(skill instanceof MagicCircuitFullDrive)
            ) {
                addSkillEvent(magicCircuitFullDrive);
            }
            if (skill instanceof Devide && cooldownCheck(devideReinforce)) {
                skill = devideReinforce;
            }
            if (getStart().before(restoreEndTime)) {
                if (skill instanceof Ether) {
                    ether += 9;
                }
                if (
                        skill instanceof Devide
                        || skill instanceof DevideReinforce
                        || skill instanceof Tread
                ) {
                    ether += 21;
                }
            } else {
                if (skill instanceof Ether) {
                    ether += 5;
                }
                if (
                        skill instanceof Devide
                        || skill instanceof DevideReinforce
                        || skill instanceof Tread
                ) {
                    ether += 12;
                }
            }
            if (skill instanceof Blossom) {
                skill = new Blossom(etherSword);
            }
            if (skill instanceof Gathering) {
                skill = new Gathering(etherSword);
                gathering = (Gathering) skill;
            }
            if (skill instanceof Storm) {
                skill = new Storm(etherSword);
                storm = (Storm) skill;
            }
            if (
                    skill instanceof Order
                    || skill instanceof OrderRestore
            ) {
                etherSword --;
            }
            if (
                    skill instanceof Devide
                    || skill instanceof DevideReinforce
                    || skill instanceof Tread
            ) {
                if (cooldownCheck(shard)) {
                    shard.setDelay(0L);
                    addSkillEvent(shard);
                    shard.setDelayByAttackSpeed(810L);
                }
                if (
                        cooldownCheck(creation)
                        && etherSword > 0
                ) {
                    creation = new Creation(etherSword);
                    addSkillEvent(creation);
                }
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                if (!(skill instanceof Order)) {
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
                }
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    long i = ((AttackSkill) skill).getInterval();
                    if (skill instanceof Territory) {
                        i = 1500;
                    }
                    if (skill instanceof Ruin) {
                        i = 1320;
                    }
                    if (skill instanceof RuinFinish) {
                        i = 2730;
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
            }
        }
        applyCooldown(skill);
        if (cooldownCheck(et)) {
            et.setActivateTime(new Timestamp(et.getActivateTime().getTime() + 10000));
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
    public void applyCooldown(Skill skill) {
        if (skill.getCooldown() != 0) {
            if (skill.isApplyReuse()) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= getJob().getReuse()) {
                    if (skill instanceof Territory) {
                        skill.setActivateTime(new Timestamp(getStart().getTime() + 7200));
                    }
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
