package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.archmagefp.*;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.archmagefp.Ifrit;
import org.mapledpmlab.type.skill.buffskill.archmagefp.InfernalVenomBuff;
import org.mapledpmlab.type.skill.buffskill.common.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ArchMageFPDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DotPunisherAfterSecond());
            add(new DotPunisherDot());
            add(new DotPunisherFirst());
            add(new DotPunisherOriginAfterSecond());
            add(new DotPunisherOriginDot());
            add(new DotPunisherOriginFirst());
            add(new FinalAttackArchMageFP());
            add(new FireAura());
            add(new FireAuraDot());
            add(new FlameHaze());
            add(new FlameHazeDot());
            add(new FlameSweep());
            add(new FlameSweepDot());
            add(new FlameSweepExplosion());
            add(new FuryOfIfrit());
            add(new FuryOfIfritOrigin());
            add(new IfritDot());
            add(new IfritSummon());
            add(new Ignite());
            add(new InfernalVenomExplosion1());
            add(new InfernalVenomExplosionError());
            add(new InfernalVenomExplosion2());
            add(new MegidoFlame());
            add(new MegidoFlameAfterSecond());
            add(new MegidoFlameDot());
            add(new MistEruption());
            add(new PoisonMist());
            add(new PoisonChain());
            add(new PoisonChainExplosion0());
            add(new PoisonChainExplosion1());
            add(new PoisonChainExplosion2());
            add(new PoisonChainExplosion3());
            add(new PoisonChainExplosion4());
            add(new PoisonChainExplosion5());
            add(new PoisonNova());
            add(new PoisonNovaDot());
            add(new PoisonNovaExplosion());
            add(new PoisonNovaExplosionAfterThird());
            add(new PoisonZone());
            add(new PoisonZoneExplosion());
            add(new PoisonZoneExplosionSecond());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
            add(new TeleportMastery());
            add(new TeleportMasteryDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new EpicAdventure());
            add(new Ifrit());
            add(new InfernalVenomBuff());
            add(new Infinity(0L));
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new UnstableMemorize());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    Timestamp cancelRestraintRingEndTime = new Timestamp(-1);
    Timestamp infernalVenomEndTime = new Timestamp(0);
    Timestamp infinityEndTime = new Timestamp(0);
    Timestamp poisonZoneExplosionTime = new Timestamp(-1);

    BuffSkill fervantDrain = new BuffSkill();

    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DotPunisherFirst dotPunisherFirst = new DotPunisherFirst();
    DotPunisherOriginFirst dotPunisherOriginFirst = new DotPunisherOriginFirst();
    EpicAdventure epicAdventure = new EpicAdventure();
    FireAura fireAura = new FireAura();
    FireAuraDot fireAuraDot = new FireAuraDot();
    FlameHaze flameHaze = new FlameHaze();
    FlameSweep flameSweep = new FlameSweep();
    FuryOfIfrit furyOfIfrit = new FuryOfIfrit();
    FuryOfIfritOrigin furyOfIfritOrigin = new FuryOfIfritOrigin();
    Ifrit ifrit = new Ifrit();
    IfritDot ifritDot = new IfritDot();
    IfritSummon ifritSummon = new IfritSummon();
    InfernalVenomBuff infernalVenomBuff = new InfernalVenomBuff();
    Infinity infinity = new Infinity(0L);
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    MegidoFlame megidoFlame = new MegidoFlame();
    MistEruption mistEruption = new MistEruption();
    PoisonChainExplosion0 poisonChainExplosion0 = new PoisonChainExplosion0();
    PoisonNovaDot poisonNovaDot = new PoisonNovaDot();
    PoisonNovaExplosion poisonNovaExplosion = new PoisonNovaExplosion();
    PoisonZone poisonZone = new PoisonZone();
    PoisonZoneExplosion poisonZoneExplosion = new PoisonZoneExplosion();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    TeleportMastery teleportMastery = new TeleportMastery();
    UnstableMemorize unstableMemorize = new UnstableMemorize();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public ArchMageFPDealCycle(Job job) {
        super(job, new FinalAttackArchMageFP());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        // 파이어 오라
        for (int i = 0; i < 720 * 1000; i += fireAura.getInterval()) {
            getSkillEventList().add(new SkillEvent(fireAura, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 파이어 오라 도트
        for (int i = 0; i < 720 * 1000; i += fireAuraDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(fireAuraDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 이프리트 도트
        for (int i = 0; i < 720 * 1000; i += ifritDot.getInterval()) {
            getSkillEventList().add(new SkillEvent(ifritDot, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 이프리트 소환수
        for (int i = 0; i < 720 * 1000; i += ifritSummon.getInterval()) {
            getSkillEventList().add(new SkillEvent(ifritSummon, new Timestamp(i), new Timestamp(i)));
            getEventTimeList().add(new Timestamp(i));
        }

        // 인피니티 달구기
        getStart().setTime(-75000);
        infinity.setActivateTime(new Timestamp(-80000));
        addSkillEvent(infinity);
        getStart().setTime(0);

        ringSwitching.setCooldown(95.0);

        fervantDrain.setBuffFinalDamage(1.25);
        fervantDrain.setDuration(720L);
        fervantDrain.setName("퍼번트 드레인");
        addSkillEvent(fervantDrain);

        mapleWorldGoddessBlessing.setCooldown(120.0);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(infinity)
                            && getStart().after(infinityEndTime)
            ) {
                addSkillEvent(infinity);
            }
            if (
                    cooldownCheck(unstableMemorize)
                            && getStart().after(infinityEndTime)
            ) {
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
                addSkillEvent(unstableMemorize);
            }
            if (cooldownCheck(ifrit)) {
                addSkillEvent(ifrit);
            }
            if (cooldownCheck(poisonZone)) {
                addSkillEvent(poisonZone);
            }
            /*if (cooldownCheck(teleportMastery)) {
                addSkillEvent(teleportMastery);
            }*/
            if (
                    cooldownCheck(mapleWorldGoddessBlessing)
                            && cooldownCheck(epicAdventure)
                            && cooldownCheck(soulContract)
                            && cooldownCheck(megidoFlame)
                            && cooldownCheck(restraintRing)
                            && cooldownCheck(furyOfIfrit)
                            && cooldownCheck(poisonNovaDot)
                            && cooldownCheck(dotPunisherFirst)
                            && cooldownCheck(poisonChainExplosion0)
                            && cooldownCheck(mistEruption)
                            && getStart().before(new Timestamp(11 * 60 * 1000))
            ) {
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(epicAdventure);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    if (cooldownCheck(mistEruption)) {
                        addSkillEvent(flameHaze);
                        addSkillEvent(mistEruption);
                    }
                    addSkillEvent(flameSweep);
                }
                addSkillEvent(soulContract);
                addSkillEvent(megidoFlame);
                addSkillEvent(restraintRing);
                if (cooldownCheck(infernalVenomBuff)) {
                    addSkillEvent(flameHaze);
                    addSkillEvent(mistEruption);
                    addSkillEvent(infernalVenomBuff);
                }
                if (getStart().before(infernalVenomEndTime)) {
                    addSkillEvent(furyOfIfritOrigin);
                } else {
                    addSkillEvent(furyOfIfrit);
                }
                addSkillEvent(poisonNovaDot);
                if (getStart().before(infernalVenomEndTime)) {
                    addSkillEvent(dotPunisherOriginFirst);
                } else {
                    addSkillEvent(dotPunisherFirst);
                }
                addSkillEvent(poisonChainExplosion0);
                addSkillEvent(flameHaze);
                addSkillEvent(mistEruption);
                addSkillEvent(poisonNovaExplosion);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(70 * 1000))
                            && getStart().before(new Timestamp(11 * 60 * 1000))
                            && getStart().before(new Timestamp(poisonNovaDot.getActivateTime().getTime() - 5000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (
                    cooldownCheck(soulContract)
                            && cooldownCheck(weaponJumpRing)
                            && cooldownCheck(furyOfIfrit)
                            && cooldownCheck(poisonNovaDot)
                            && getStart().before(new Timestamp(720 * 1000))
            ) {
                if (cooldownCheck(mistEruption)) {
                    addSkillEvent(flameHaze);
                    addSkillEvent(mistEruption);
                }
                addSkillEvent(soulContract);
                if (cooldownCheck(megidoFlame)) {
                    addSkillEvent(megidoFlame);
                }
                addSkillEvent(weaponJumpRing);
                addSkillEvent(furyOfIfrit);
                addSkillEvent(poisonNovaDot);
                addSkillEvent(dotPunisherFirst);
                addSkillEvent(poisonChainExplosion0);
                addSkillEvent(flameHaze);
                addSkillEvent(mistEruption);
                addSkillEvent(poisonNovaExplosion);
            } else if (
                    cooldownCheck(megidoFlame)
                            && (
                            !cooldownCheck(furyOfIfrit)
                                    || getStart().after(new Timestamp(600 * 1000))
                    )
                            && getStart().before(new Timestamp(700 * 1000))
            ) {
                if (cooldownCheck(mistEruption)) {
                    addSkillEvent(flameHaze);
                    addSkillEvent(mistEruption);
                }
                addSkillEvent(megidoFlame);
            } else if (
                    cooldownCheck(poisonNovaDot)
                            && (
                            getStart().before(new Timestamp(furyOfIfrit.getActivateTime().getTime() + 13800))
                                    || getStart().after(new Timestamp(660 * 1000))
                    )
            ) {
                if (cooldownCheck(mistEruption)) {
                    addSkillEvent(flameHaze);
                    addSkillEvent(mistEruption);
                }
                addSkillEvent(poisonNovaDot);
                if (getStart().before(infernalVenomEndTime)) {
                    addSkillEvent(dotPunisherOriginFirst);
                } else {
                    addSkillEvent(dotPunisherFirst);
                }
                addSkillEvent(poisonChainExplosion0);
                addSkillEvent(flameHaze);
                addSkillEvent(mistEruption);
                addSkillEvent(poisonNovaExplosion);
            } else if (
                    cooldownCheck(flameHaze)
                            && cooldownCheck(mistEruption)
                            && getStart().before(new Timestamp(poisonNovaDot.getActivateTime().getTime() - 1000))
            ) {
                addSkillEvent(flameHaze);
                addSkillEvent(mistEruption);
            } else {
                addSkillEvent(flameSweep);
                if (getStart().after(cancelRestraintRingEndTime)) {
                    addSkillEvent(teleportMastery);
                }
            }
        }
        sortEventTimeList();
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
            if (skill instanceof RestraintRing) {
                cancelRestraintRingEndTime = new Timestamp(getStart().getTime() + 15000);
            }
            if (skill instanceof InfernalVenomBuff) {
                infernalVenomEndTime = new Timestamp(getStart().getTime() + 20000);
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
                if (skill instanceof Infinity) {
                    infinityEndTime = new Timestamp(getStart().getTime() + 120000);
                    for (long i = 0; i < 75000; i += 5000) {
                        getSkillEventList().add(new SkillEvent(new Infinity(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 5000)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 5000));
                    }
                    getSkillEventList().add(new SkillEvent(new Infinity(75000L), new Timestamp(getStart().getTime() + 75000), new Timestamp(getStart().getTime() + 120000)));
                    endTime = new Timestamp(getStart().getTime() + 120000);
                } else {
                    endTime = new Timestamp((long) (getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
                    getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
                }
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            Long ran = (long) (Math.random() * 99 + 1);
            if (
                    (
                            skill instanceof DotPunisherAfterSecond
                            || skill instanceof DotPunisherFirst
                            || skill instanceof DotPunisherOriginAfterSecond
                            || skill instanceof DotPunisherOriginFirst
                            || skill instanceof FlameHaze
                            || skill instanceof FlameSweep
                            || skill instanceof FlameSweepExplosion
                            || skill instanceof FuryOfIfrit
                            || skill instanceof FuryOfIfritOrigin
                            || skill instanceof IfritSummon
                            || skill instanceof MegidoFlame
                    )
                    && ran <= 50
            ) {
                addSkillEvent(new Ignite());
            }
            if (skill instanceof PoisonZone) {
                poisonZoneExplosionTime = new Timestamp(getStart().getTime() + 1500);
            }
            if (
                    cooldownCheck(poisonZoneExplosion)
                    && getStart().after(poisonZoneExplosionTime)
                    && (
                            skill instanceof DotPunisherAfterSecond
                            || skill instanceof DotPunisherFirst
                            || skill instanceof DotPunisherOriginAfterSecond
                            || skill instanceof DotPunisherOriginFirst
                            || skill instanceof FlameHaze
                            || skill instanceof FlameSweep
                            || skill instanceof FlameSweepExplosion
                            || skill instanceof FuryOfIfrit
                            || skill instanceof FuryOfIfritOrigin
                            || skill instanceof IfritSummon
                            || skill instanceof InfernalVenomExplosion1
                            || skill instanceof InfernalVenomExplosion2
                            || skill instanceof MegidoFlame
                    )
            ) {
                addSkillEvent(poisonZoneExplosion);
            }
            if (((AttackSkill) skill).isApplyFinalAttack()) {
                ran = (long) (Math.random() * 99 + 1);
                if (ran <= getFinalAttack().getProp()) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= 50) {
                        addSkillEvent(new Ignite());
                    }
                    if (
                            cooldownCheck(poisonZoneExplosion)
                            && getStart().before(poisonZoneExplosionTime)
                    ) {
                        addSkillEvent(poisonZoneExplosion);
                    }
                }
            }
            if (skill instanceof MistEruption) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                            && skillEvent.getSkill() instanceof PoisonMist
                    ) {
                        remove.add(skillEvent);
                    }
                }
                this.getSkillEventList().removeAll(remove);
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
                if (!(skill instanceof Ignite)) {
                    this.getSkillEventList().removeAll(remove);
                }
                Timestamp tmp = getStart();
                if (((AttackSkill) skill).getLimitAttackCount() == 0) {
                    long i = ((AttackSkill) skill).getInterval();
                    if (
                            skill instanceof FuryOfIfrit
                            || skill instanceof FuryOfIfritOrigin
                    ) {
                        i = 1000;//480 + 960 + 180;
                    }
                    if (
                            skill instanceof FlameSweepDot
                            || skill instanceof TeleportMasteryDot
                    ) {
                        i = 0;
                    }
                    for (; i <= ((AttackSkill) skill).getDotDuration(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
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
        if (skill instanceof DotPunisherFirst) {
            dotPunisherOriginFirst.setActivateTime(new Timestamp(skill.getActivateTime().getTime()));
        } else if (skill instanceof DotPunisherOriginFirst) {
            dotPunisherFirst.setActivateTime(new Timestamp(skill.getActivateTime().getTime()));
        } else if (skill instanceof FuryOfIfrit) {
            furyOfIfritOrigin.setActivateTime(new Timestamp(skill.getActivateTime().getTime()));
        } else if (skill instanceof FuryOfIfritOrigin) {
            furyOfIfrit.setActivateTime(new Timestamp(skill.getActivateTime().getTime()));
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
            useBuffSkillList = deduplication(useBuffSkillList, SkillEvent::getSkill);
            boolean isInfernalVenomBuff = false;
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (skillEvent.getSkill() instanceof InfernalVenomBuff) {
                    isInfernalVenomBuff = true;
                    fervantDrain.setBuffFinalDamage(1.5);
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
            for (SkillEvent se : useAttackSkillList) {
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    Long ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
            if (isInfernalVenomBuff) {
                fervantDrain.setBuffFinalDamage(1.25);
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
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
}
