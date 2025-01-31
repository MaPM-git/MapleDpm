package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
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
            add(new EternalLightness());
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
            add(new TwilightNovaEclipse());
            add(new TwilightNovaEquilibrium());
            add(new TwilightNovaSunfire());
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

    boolean isNuke = false;

    Larkness larkness = Larkness.ECLIPSE;
    Larkness next = Larkness.SUNFIRE;

    Long liberationOrbCnt = 0L;
    int gauge = 10000;

    Timestamp continuousRingEndTime = new Timestamp(-1);
    Timestamp equilibriumEndTime = new Timestamp(-1);
    Timestamp liberationOrbEndTime = new Timestamp(-1);

    AbsoluteKill absoluteKill = new AbsoluteKill();
    Apocalypse apocalypse = new Apocalypse();
    BaptismOfLightAndDarkness baptismOfLightAndDarkness = new BaptismOfLightAndDarkness();
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DoorOfTruth doorOfTruth = new DoorOfTruth();
    EndlessDarkness endlessDarkness = new EndlessDarkness();
    Equilibrium equilibrium = new Equilibrium();
    EternalLightness eternalLightness = new EternalLightness();
    HarmonicParadoxBeforeDelay harmonicParadox = new HarmonicParadoxBeforeDelay();
    HeroesOath heroesOath = new HeroesOath();
    LiberationOrb liberationOrb = new LiberationOrb();
    LightReflection lightReflection = new LightReflection();
    MapleWorldGoddessBlessing mapleWorldGoddessBlessing = new MapleWorldGoddessBlessing(getJob().getLevel());
    Memorize memorize = new Memorize();
    PunishingResonator punishingResonator = new PunishingResonator();
    PunishingResonatorEclipse punishingResonatorEclipse = new PunishingResonatorEclipse();
    PunishingResonatorEquilibrium punishingResonatorEquilibrium = new PunishingResonatorEquilibrium();
    PunishingResonatorSunfire punishingResonatorSunfire = new PunishingResonatorSunfire();
    LiberationOrbActive liberationOrbActive = new LiberationOrbActive();
    LiberationOrbPassive liberationOrbPassive = new LiberationOrbPassive();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    TwilightNovaEclipse twilightNovaEclipse = new TwilightNovaEclipse();
    TwilightNovaEquilibrium twilightNovaEquilibrium = new TwilightNovaEquilibrium();
    TwilightNovaSunfire twilightNovaSunfire = new TwilightNovaSunfire();

    public LuminousContinuousDealCycle(Job job) {
        super(job, null);

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        mapleWorldGoddessBlessing.setCooldown(180.0);

        getSkillSequence1().add(heroesOath);                // 30
        getSkillSequence1().add(mapleWorldGoddessBlessing);
        getSkillSequence1().add(liberationOrb);
        getSkillSequence1().add(soulContract);              // 30

        getSkillSequence2().add(memorize);

        memorize.setDelay(660L);

        mapleWorldGoddessBlessing.setDelay(300L);
        liberationOrb.setDelay(300L);
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    getStart().after(equilibriumEndTime)
                            && larkness == Larkness.EQUILIBRIUM
            ) {
                larkness = next;
            }
            if (
                    cooldownCheck(liberationOrb)
                            && cooldownCheck(baptismOfLightAndDarkness)
                            && getStart().after(new Timestamp(punishingResonator.getActivateTime().getTime() - 2500))
                            && gauge == 10000
            ) {
                isNuke = true;
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(baptismOfLightAndDarkness);
                addSkillEvent(equilibrium);
                addSkillEvent(punishingResonator);
                addSkillEvent(baptismOfLightAndDarkness);
                addSkillEvent(doorOfTruth);
                if (cooldownCheck(harmonicParadox)) {
                    addSkillEvent(harmonicParadox);
                    addSkillEvent(baptismOfLightAndDarkness);
                }
                isNuke = false;
            } /*else if (
                    getStart().after(equilibriumEndTime)
                            && cooldownCheck(memorize)
                            && !cooldownCheck(heroesOath)
            ) {
                addSkillEvent(memorize);
                addSkillEvent(doorOfTruth);
            }*/ else if (
                    getStart().after(equilibriumEndTime)
                            && gauge == 10000
                            && (
                            getStart().before(new Timestamp(liberationOrb.getActivateTime().getTime() - 20000))
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
            } else if (
                    cooldownCheck(twilightNovaEclipse)
                            && larkness == Larkness.ECLIPSE
            ) {
                applyCooldown(twilightNovaEquilibrium);
                applyCooldown(twilightNovaSunfire);
                addSkillEvent(twilightNovaEclipse);
            } else if (
                    cooldownCheck(twilightNovaSunfire)
                            && larkness == Larkness.SUNFIRE
            ) {
                applyCooldown(twilightNovaEclipse);
                applyCooldown(twilightNovaEquilibrium);
                addSkillEvent(twilightNovaSunfire);
            } else if (
                    cooldownCheck(twilightNovaEquilibrium)
                            && larkness == Larkness.EQUILIBRIUM
            ) {
                applyCooldown(twilightNovaEclipse);
                applyCooldown(twilightNovaSunfire);
                addSkillEvent(twilightNovaEquilibrium);
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
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
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
                gauge = 0;
            }
            if (skill instanceof Equilibrium) {
                equilibriumEndTime = new Timestamp((long) (getStart().getTime() + 3000 + ((Equilibrium) skill).getDuration() * 1000 * (1 + getJob().getPlusBuffDuration() * 0.01)));
            } else if (skill instanceof EquilibriumMemorize) {
                equilibriumEndTime = new Timestamp(getStart().getTime() + 3000 + ((EquilibriumMemorize) skill).getDuration() * 1000);
            }
            if (skill instanceof LiberationOrb) {
                liberationOrbEndTime = new Timestamp(getStart().getTime() + 3000 + ((LiberationOrb) skill).getDuration() * 1000);
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
            if (
                    cooldownCheck(eternalLightness)
                            && (
                            skill instanceof LightReflection
                                    || skill instanceof AbsoluteKill
                    )
            ) {
                addSkillEvent(eternalLightness);
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
                                addSkillEvent(eternalLightness);
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
                    gauge += 450;
                    if (gauge > 10000) {
                        gauge = 10000;
                    }
                } else if (skill instanceof LightReflection) {
                    gauge += 430;
                    if (gauge > 10000) {
                        gauge = 10000;
                    }
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
            if (skill instanceof HarmonicParadoxPower) {
                Timestamp tmp = new Timestamp(getStart().getTime());
                setStart(new Timestamp(getStart().getTime() + sum));
                if (cooldownCheck(endlessDarkness)) {
                    addSkillEvent(endlessDarkness);
                    addSkillEvent(eternalLightness);
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
            } else if (
                    getStart().after(equilibriumEndTime)
                    && (
                            skill instanceof EternalLightness
                            || skill instanceof EndlessDarkness
                    )
            ) {
                gauge += 150;
                if (gauge > 10000) {
                    gauge = 10000;
                }
            } else if (
                    skill instanceof TwilightNovaSunfire
                    || skill instanceof TwilightNovaEclipse
            ) {
                gauge += 120;
                if (gauge > 10000) {
                    gauge = 10000;
                }
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
