package org.mapledpmlab.type.dealcycle;

import org.mapledpmlab.type.etc.Larkness;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolar;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirror;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;
import org.mapledpmlab.type.skill.attackskill.luminous.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.luminous.Equilibrium;
import org.mapledpmlab.type.skill.buffskill.luminous.EquilibriumMemorize;
import org.mapledpmlab.type.skill.buffskill.luminous.LiberationOrb;
import org.mapledpmlab.type.skill.buffskill.luminous.Memorize;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LuminousContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AbsoluteKill());
            add(new Apocalypse());
            add(new BaptismOfLightAndDarkness());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DoorOfTruth());
            add(new EndlessDarkness());
            add(new HarmonicParadoxBeforeDelay());
            add(new HarmonicParadoxKeydown());
            add(new HarmonicParadoxPower());
            add(new LiberationOrbActive());
            add(new LiberationOrbPassive());
            add(new LightReflection());
            add(new PunishingResonator());
            add(new PunishingResonatorEclipse());
            add(new PunishingResonatorEquilibrium());
            add(new PunishingResonatorSunfire());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new Equilibrium());
            add(new EquilibriumMemorize());
            add(new HeroesOath());
            add(new LiberationOrb());
            add(new MapleWorldGoddessBlessing(getJob().getLevel()));
            add(new Memorize());
            add(new SoulContract());
        }
    };

    Larkness larkness = Larkness.ECLIPSE;
    Larkness next = Larkness.SUNFIRE;
    Long sunFireCnt = 0L;       // 라이트리플렉션 25회
    Long eclipseCnt = 22L;       // 아포칼립스 22회
    Long liberationOrbCnt = 0L;

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp equilibriumEndTime = new Timestamp(-1);
    Timestamp liberationOrbEndTime = new Timestamp(-1);

    BaptismOfLightAndDarkness baptismOfLightAndDarkness = new BaptismOfLightAndDarkness();
    ContinuousRing continuousRing = new ContinuousRing();
    EndlessDarkness endlessDarkness = new EndlessDarkness();
    PunishingResonatorEclipse punishingResonatorEclipse = new PunishingResonatorEclipse();
    PunishingResonatorSunfire punishingResonatorSunfire = new PunishingResonatorSunfire();
    PunishingResonatorEquilibrium punishingResonatorEquilibrium = new PunishingResonatorEquilibrium();
    LiberationOrbActive liberationOrbActive = new LiberationOrbActive();
    LiberationOrbPassive liberationOrbPassive = new LiberationOrbPassive();

    boolean isNuke = false;

    public LuminousContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        AbsoluteKill absoluteKill = new AbsoluteKill();
        Apocalypse apocalypse = new Apocalypse();
        CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
        DoorOfTruth doorOfTruth = new DoorOfTruth();
        Equilibrium equilibrium = new Equilibrium();
        HarmonicParadoxBeforeDelay harmonicParadox = new HarmonicParadoxBeforeDelay();
        HeroesOath heroesOath = new HeroesOath();
        LiberationOrb liberationOrb = new LiberationOrb();
        LightReflection lightReflection = new LightReflection();
        MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(job.getLevel());
        Memorize memorize = new Memorize();
        PunishingResonator punishingResonator = new PunishingResonator();
        SoulContract soulContract = new SoulContract();
        SpiderInMirror spiderInMirror = new SpiderInMirror();

        mapleWorldGoddessBlessing.setCooldown(180.0);

        while (getStart().before(getEnd())) {
            if (
                    getStart().after(equilibriumEndTime)
                    && larkness == Larkness.EQUILIBRIUM
            ) {
                larkness = next;
            }
            if (
                    cooldownCheck(heroesOath)
                    && cooldownCheck(mapleWorldGoddessBlessing)
                    && cooldownCheck(liberationOrb)
                    && cooldownCheck(soulContract)
                    && cooldownCheck(baptismOfLightAndDarkness)
                    && cooldownCheck(punishingResonator)
                    && getStart().before(new Timestamp(11 * 60 * 1000))
                    && (
                            sunFireCnt >= 23
                            || eclipseCnt >= 19
                    )
            ) {
                isNuke = true;
                addSkillEvent(mapleWorldGoddessBlessing);
                addSkillEvent(heroesOath);
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                } else {
                    if (larkness == Larkness.ECLIPSE) {
                        addSkillEvent(apocalypse);
                    } else if (larkness == Larkness.SUNFIRE) {
                        addSkillEvent(lightReflection);
                    }
                }
                addSkillEvent(liberationOrb);
                addSkillEvent(soulContract);
                addSkillEvent(baptismOfLightAndDarkness);
                addSkillEvent(equilibrium);
                addSkillEvent(punishingResonator);
                addSkillEvent(absoluteKill);
                addSkillEvent(baptismOfLightAndDarkness);
                addSkillEvent(absoluteKill);
                addSkillEvent(doorOfTruth);
                if (cooldownCheck(harmonicParadox)) {
                    addSkillEvent(harmonicParadox);
                    addSkillEvent(baptismOfLightAndDarkness);
                }
                isNuke = false;
            } else if (
                    getStart().after(equilibriumEndTime)
                    && cooldownCheck(memorize)
                    && !cooldownCheck(heroesOath)
            ) {
                addSkillEvent(memorize);
                addSkillEvent(doorOfTruth);
            } else if (
                    getStart().after(equilibriumEndTime)
                    && (
                            sunFireCnt >= 23
                            || eclipseCnt >= 19
                    )
                    && (
                            getStart().before(new Timestamp(heroesOath.getActivateTime().getTime() + 35000))
                            || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addSkillEvent(equilibrium);
                addSkillEvent(doorOfTruth);
            } else if (
                    cooldownCheck(punishingResonator)
                    && (
                            !cooldownCheck(liberationOrb)
                            || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addSkillEvent(punishingResonator);
            } else if (
                    cooldownCheck(baptismOfLightAndDarkness)
                    && (
                            getStart().before(new Timestamp(liberationOrb.getActivateTime().getTime() - 10000))
                            || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addSkillEvent(baptismOfLightAndDarkness);
            } else {
                if (larkness == Larkness.ECLIPSE) {
                    addSkillEvent(apocalypse);
                } else if (larkness == Larkness.SUNFIRE) {
                    addSkillEvent(lightReflection);
                } else if (larkness == Larkness.EQUILIBRIUM) {
                    addSkillEvent(absoluteKill);
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
            if (skill instanceof ContinuousRing) {
                continuousRingEndTime = new Timestamp(getStart().getTime() + 8000);
            }
            if (
                    skill instanceof Equilibrium
                    || skill instanceof EquilibriumMemorize
            ) {
                if (larkness == Larkness.ECLIPSE) {
                    next = Larkness.SUNFIRE;
                } else if (larkness == Larkness.SUNFIRE) {
                    next = Larkness.ECLIPSE;
                }
                larkness = Larkness.EQUILIBRIUM;
                baptismOfLightAndDarkness.setActivateTime(new Timestamp(-1));
                sunFireCnt = 0L;
                eclipseCnt = 0L;
            }
            if (skill instanceof Equilibrium) {
                equilibriumEndTime = new Timestamp((long) (getStart().getTime() + ((Equilibrium) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
            } else if (skill instanceof EquilibriumMemorize) {
                equilibriumEndTime = new Timestamp(getStart().getTime() + ((EquilibriumMemorize) skill).getDuration() * 1000);
            }
            if (skill instanceof LiberationOrb) {
                liberationOrbEndTime = new Timestamp(getStart().getTime() + ((LiberationOrb) skill).getDuration() * 1000);
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
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            } else {
                endTime = new Timestamp(getStart().getTime() + ((BuffSkill) skill).getDuration() * 1000);
                getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime()), endTime));
            }
        } else {
            if (
                    cooldownCheck(continuousRing)
                    && (
                            skill instanceof CrestOfTheSolar
                            || skill instanceof SpiderInMirror
                            || skill instanceof AbsoluteKill
                            || skill instanceof Apocalypse
                            || skill instanceof BaptismOfLightAndDarkness
                            || skill instanceof LightReflection
                            || skill instanceof PunishingResonatorEclipse
                            || skill instanceof PunishingResonatorEquilibrium
                            || skill instanceof PunishingResonatorSunfire
                            || skill instanceof LiberationOrbActive
                            || skill instanceof LiberationOrbPassive
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof Apocalypse
                    || skill instanceof LightReflection
                    || skill instanceof AbsoluteKill
                    || skill instanceof BaptismOfLightAndDarkness
            ) {
                if (
                        cooldownCheck(liberationOrbActive)
                        && getStart().before(liberationOrbEndTime)
                ) {
                    addSkillEvent(liberationOrbActive);
                    liberationOrbCnt ++;
                    if (liberationOrbCnt >= 20) {
                        liberationOrbCnt = 0L;
                        liberationOrbEndTime = new Timestamp(-1);
                    }
                } else if (
                        cooldownCheck(liberationOrbPassive)
                        && getStart().after(liberationOrbEndTime)
                ) {
                    addSkillEvent(liberationOrbPassive);
                    if (getStart().before(equilibriumEndTime)) {
                        liberationOrbPassive.setActivateTime(new Timestamp(-1));
                        addSkillEvent(liberationOrbPassive);
                    }
                }
            }
            if (skill instanceof HarmonicParadoxKeydown) {
                baptismOfLightAndDarkness.setActivateTime(new Timestamp(-1));
            }
            if (
                    cooldownCheck(endlessDarkness)
                    && (
                            skill instanceof Apocalypse
                            || skill instanceof AbsoluteKill
                    )
            ) {
                addSkillEvent(endlessDarkness);
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                if (skill instanceof HarmonicParadoxKeydown) {
                    equilibriumEndTime = new Timestamp(equilibriumEndTime.getTime() + 10000);
                }
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
                        if (
                                skill instanceof HarmonicParadoxKeydown
                        ) {
                            Timestamp temp = new Timestamp(getStart().getTime());
                            setStart(new Timestamp(getStart().getTime() + i));
                            if (cooldownCheck(endlessDarkness)) {
                                addSkillEvent(endlessDarkness);
                            }
                            if (cooldownCheck(liberationOrbActive)) {
                                addSkillEvent(liberationOrbActive);
                                liberationOrbCnt++;
                            }
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
                            }
                            setStart(new Timestamp(temp.getTime()));
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
                if (skill instanceof Apocalypse) {
                    eclipseCnt ++;
                } else if (skill instanceof LightReflection) {
                    sunFireCnt ++;
                } else if (skill instanceof AbsoluteKill) {
                    baptismOfLightAndDarkness.setActivateTime(new Timestamp(baptismOfLightAndDarkness.getActivateTime().getTime() - 3000));
                }
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
        if (skill instanceof PunishingResonator) {
            if (larkness == Larkness.ECLIPSE) {
                skill.setRelatedSkill(punishingResonatorEclipse);
            } else if (larkness == Larkness.SUNFIRE) {
                skill.setRelatedSkill(punishingResonatorSunfire);
            } else if (larkness == Larkness.EQUILIBRIUM) {
                skill.setRelatedSkill(punishingResonatorEquilibrium);
            }
        }
        if (skill.getRelatedSkill() != null) {
            addSkillEvent(skill.getRelatedSkill());
        }
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            if (
                    /*skill instanceof BaptismOfLightAndDarkness
                    || */skill instanceof HarmonicParadoxPower
            ) {
                Timestamp tmp = new Timestamp(getStart().getTime());
                setStart(new Timestamp(getStart().getTime() + sum));
                if (cooldownCheck(endlessDarkness)) {
                    addSkillEvent(endlessDarkness);
                }
                if (
                        getStart().before(liberationOrbEndTime)
                        && cooldownCheck(liberationOrbActive)
                ) {
                    addSkillEvent(liberationOrbActive);
                    liberationOrbCnt++;
                }
                if (cooldownCheck(continuousRing)) {
                    addSkillEvent(continuousRing);
                }
                setStart(new Timestamp(tmp.getTime()));
            }
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
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
                break;
            }
        }
        return attackDamage;
    }
}
