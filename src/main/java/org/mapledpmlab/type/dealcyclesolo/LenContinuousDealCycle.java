package org.mapledpmlab.type.dealcyclesolo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;
import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.len.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.len.Elevation;
import org.mapledpmlab.type.skill.buffskill.len.PlumBlossomSecretApricotTree;
import org.mapledpmlab.type.skill.buffskill.len.SoulshatterAwakening;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class LenContinuousDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new AzureDragonSkybreakerSwordAscension1());
            add(new AzureDragonSkybreakerSwordAscension2());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new PlumBlossom2FallingPetals());
            add(new PlumBlossom3KeenBlade());
            add(new PlumBlossomMainSlash());
            add(new PlumBlossomSecretApricotTreeGoshawk());
            add(new PlumBlossomSecretApricotTreePlumBlossom20());
            add(new PlumBlossomSecretApricotTreePlumBlossom40());
            add(new PlumBlossomSecretApricotTreePlumBlossom65());
            add(new PlumBlossomSecretFlashDancePre());
            add(new PlumBlossomSecretFlashDance());
            add(new Soulshatter2ChainSlash());
            add(new SoulshatterAwakeningCelestialFang());
            add(new SoulshatterAwakeningCelestialTribulation());
            add(new SoulshatterDescent());
            add(new SoulshatterMainSpiritStrike());
            add(new SoulshatterSecretInfiniteBlades());
            add(new SoulshatterSecretInfiniteBladesFlame());
            add(new SoulshatterSecretMindBlade());
            add(new SoulshatterSecretMindBladeForce());
            add(new SoulshatterSecretTearGround1());
            add(new SoulshatterSecretTearGround2());
            add(new SoulshatterSecretVoidFang());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new ContinuousRing());
            add(new Elevation());
            add(new GrandisGoddessBlessingAnima());
            add(new PlumBlossomSecretApricotTree());
            add(new SoulContract());
            add(new SoulshatterAwakening());
        }
    };

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    AzureDragonSkybreakerSwordAscension1 azureDragonSkybreakerSwordAscension1 = new AzureDragonSkybreakerSwordAscension1();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    ContinuousRing continuousRing = new ContinuousRing();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    Elevation elevation = new Elevation();
    GrandisGoddessBlessingAnima grandisGoddessBlessingAnima = new GrandisGoddessBlessingAnima();
    PlumBlossom2FallingPetals plumBlossom2FallingPetals = new PlumBlossom2FallingPetals();
    PlumBlossom3KeenBlade plumBlossom3KeenBlade = new PlumBlossom3KeenBlade();
    PlumBlossomMainSlash plumBlossomMainSlash = new PlumBlossomMainSlash();
    PlumBlossomSecretApricotTree plumBlossomSecretApricotTree = new PlumBlossomSecretApricotTree();
    PlumBlossomSecretApricotTreeGoshawk plumBlossomSecretApricotTreeGoshawk = new PlumBlossomSecretApricotTreeGoshawk();
    PlumBlossomSecretApricotTreePlumBlossom20 plumBlossomSecretApricotTreePlumBlossom20 = new PlumBlossomSecretApricotTreePlumBlossom20();
    PlumBlossomSecretApricotTreePlumBlossom40 plumBlossomSecretApricotTreePlumBlossom40 = new PlumBlossomSecretApricotTreePlumBlossom40();
    PlumBlossomSecretApricotTreePlumBlossom65 plumBlossomSecretApricotTreePlumBlossom65 = new PlumBlossomSecretApricotTreePlumBlossom65();
    PlumBlossomSecretFlashDancePre plumBlossomSecretFlashDancePre = new PlumBlossomSecretFlashDancePre();
    SoulContract soulContract = new SoulContract();
    SoulshatterAwakening soulshatterAwakening = new SoulshatterAwakening();
    SoulshatterAwakeningCelestialFang soulshatterAwakeningCelestialFang = new SoulshatterAwakeningCelestialFang();
    SoulshatterAwakeningCelestialTribulation soulshatterAwakeningCelestialTribulation = new SoulshatterAwakeningCelestialTribulation();
    SoulshatterDescent soulshatterDescent = new SoulshatterDescent();
    SoulshatterMainSpiritStrike soulshatterMainSpiritStrike = new SoulshatterMainSpiritStrike();
    SoulshatterSecretInfiniteBlades soulshatterSecretInfiniteBlades = new SoulshatterSecretInfiniteBlades();
    SoulshatterSecretMindBlade soulshatterSecretMindBlade = new SoulshatterSecretMindBlade();
    SoulshatterSecretTearGround1 soulshatterSecretTearGround1 = new SoulshatterSecretTearGround1();
    SoulshatterSecretVoidFang soulshatterSecretVoidFang = new SoulshatterSecretVoidFang();
    SpiderInMirror spiderInMirror = new SpiderInMirror();

    int soulshatterSecretCnt = 0;
    int grandisCnt = -1;
    int nukeCnt = 0;
    int goshawkCnt = 0;
    int celestialFangCnt = 0;


    boolean isGrandisBless = false;
    boolean is20 = false;
    boolean is40 = false;
    boolean is65 = false;
    boolean isSoulshatterAwakeningCelestialTribulation = false;
    boolean isNuke = false;

    Timestamp grandisActivateTime = new Timestamp(-1);
    Timestamp apricotTreeEndTime = new Timestamp(-1);
    Timestamp soulshatterAwakeningEndTime = new Timestamp(-1);

    public LenContinuousDealCycle(Job job) {
        super(job, new Soulshatter2ChainSlash());

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        grandisGoddessBlessingAnima.setDelay(120L);
        bodyOfSteel.setDelay(120L);
        plumBlossomSecretApricotTree.setDelay(120L);
        soulshatterAwakening.setDelay(120L);
        elevation.setDelay(120L);
        getSkillSequence1().add(grandisGoddessBlessingAnima);
        getSkillSequence1().add(bodyOfSteel);
        getSkillSequence1().add(plumBlossomSecretApricotTree);
        getSkillSequence1().add(soulshatterAwakening);
        getSkillSequence1().add(elevation);
        getSkillSequence1().add(soulContract);                  // 30
    }

    @Override
    public void setSoloDealCycle() {
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(auraWeaponBuff)
                    && getStart().before(new Timestamp(600 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            } else if (
                    cooldownCheck(elevation)
                            && getStart().before(new Timestamp(600 * 1000))
            ) {
                isNuke = true;
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                addSkillEvent(plumBlossom3KeenBlade);
                Timestamp now = new Timestamp(getStart().getTime());
                for (int i = 0; i < 4; i++) {
                    soulshatterSecretTearGround1.setDelay(90L);
                    soulshatterSecretVoidFang.setDelay(90L);
                    soulshatterSecretInfiniteBlades.setDelay(90L);
                    soulshatterSecretMindBlade.setDelay(90L);
                    addSkillEvent(soulshatterSecretTearGround1);
                    addSkillEvent(soulshatterSecretVoidFang);
                    addSkillEvent(soulshatterSecretInfiniteBlades);
                    addSkillEvent(soulshatterSecretMindBlade);
                    soulshatterSecretTearGround1.setDelayByAttackSpeed(660L);
                    soulshatterSecretVoidFang.setDelayByAttackSpeed(660L);
                    soulshatterSecretInfiniteBlades.setDelayByAttackSpeed(660L);
                    soulshatterSecretMindBlade.setDelayByAttackSpeed(660L);
                }
                getStart().setTime(now.getTime());
                addSkillEvent(plumBlossomSecretFlashDancePre);
                if (cooldownCheck(azureDragonSkybreakerSwordAscension1)) {
                    addSkillEvent(azureDragonSkybreakerSwordAscension1);
                }
                isNuke = false;
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(elevation.getActivateTime().getTime() - 10000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(plumBlossom3KeenBlade)
                            && (
                            getStart().before(new Timestamp(elevation.getActivateTime().getTime() - 18000))
                                    || getStart().after(new Timestamp(600 * 1000))
                    )
            ) {
                addSkillEvent(plumBlossom3KeenBlade);
            } else if (cooldownCheck(soulshatterSecretTearGround1)) {
                addSkillEvent(soulshatterSecretTearGround1);
                addSkillEvent(soulshatterSecretVoidFang);
                addSkillEvent(soulshatterSecretInfiniteBlades);
                addSkillEvent(soulshatterSecretMindBlade);
            } else {
                addSkillEvent(plumBlossomMainSlash);
            }
        }
        sortEventTimeList();
    }

    @Override
    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;

        if (getStart().before(skill.getActivateTime())) {
            if (
                    skill instanceof SoulshatterSecretTearGround1
                    && grandisCnt != 0
            ) {
                grandisCnt --;
            } else {
                System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
                return;
            }
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        if (skill instanceof BuffSkill) {
            if (skill instanceof SoulshatterAwakening) {
                soulshatterAwakeningEndTime = new Timestamp(getStart().getTime() + soulshatterAwakening.getDuration() * 1000);
                isSoulshatterAwakeningCelestialTribulation = true;
                celestialFangCnt = 0;
            }
            if (skill instanceof PlumBlossomSecretApricotTree) {
                apricotTreeEndTime = new Timestamp(getStart().getTime() + plumBlossomSecretApricotTree.getDuration() * 1000);
                is20 = true;
                is40 = true;
                is65 = true;
            }
            if (skill instanceof GrandisGoddessBlessingAnima) {
                soulshatterSecretTearGround1.setActivateTime(new Timestamp(-1));
                grandisCnt = 3;
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
                if (skill instanceof BodyOfSteel) {
                    for (long i = 0; i < 21000; i += 1000) {
                        getSkillEventList().add(new SkillEvent(new BodyOfSteel(i), new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i + 1000)));
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
                            skill instanceof SpiderInMirror
                            || skill instanceof CrestOfTheSolar
                            || skill instanceof PlumBlossomMainSlash
                            || skill instanceof SoulshatterSecretMindBlade
                            || skill instanceof SoulshatterSecretTearGround1
                            || skill instanceof SoulshatterSecretTearGround2
                            || skill instanceof SoulshatterSecretVoidFang
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            if (
                    skill instanceof SoulshatterSecretMindBlade
                    || skill instanceof SoulshatterSecretTearGround1
                    || skill instanceof SoulshatterSecretTearGround2
                    || skill instanceof SoulshatterSecretVoidFang
            ) {
                soulshatterSecretCnt ++;
                if (soulshatterSecretCnt == 8) {
                    addSkillEvent(soulshatterDescent);
                    soulshatterSecretCnt = 0;
                }
            }
            if (
                    skill instanceof SoulshatterSecretTearGround1
                    || skill instanceof SoulshatterSecretTearGround2
                    || skill instanceof PlumBlossomMainSlash
                    || skill instanceof SoulshatterSecretVoidFang
                    || skill instanceof SoulshatterSecretMindBlade
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 35) {
                    addSkillEvent(plumBlossom2FallingPetals);
                }
                if (getStart().before(apricotTreeEndTime)) {
                    if (skill instanceof PlumBlossomMainSlash) {
                        nukeCnt++;
                    } else {
                        nukeCnt += 3;
                    }
                    if (nukeCnt >= 9) {
                        addSkillEvent(plumBlossomSecretApricotTreeGoshawk);
                        if (getStart().before(soulshatterAwakeningEndTime)) {
                            addSkillEvent(soulshatterAwakeningCelestialFang);
                            celestialFangCnt ++;
                        }
                        nukeCnt -= 3;
                        goshawkCnt ++;
                    }
                    if (
                            goshawkCnt >= 30
                            && is20
                    ) {
                        addSkillEvent(plumBlossomSecretApricotTreePlumBlossom20);
                        is20 = false;
                    } else if (
                            goshawkCnt >= 70
                            && is40
                    ) {
                        addSkillEvent(plumBlossomSecretApricotTreePlumBlossom40);
                        is40 = false;
                    } else if (
                            goshawkCnt >= 125
                            && is65
                    ) {
                        addSkillEvent(plumBlossomSecretApricotTreePlumBlossom65);
                        is65 = false;
                    }
                    if (
                            celestialFangCnt % 90 == 0
                            && getStart().before(soulshatterAwakeningEndTime)
                            && isSoulshatterAwakeningCelestialTribulation
                    ) {
                        addSkillEvent(soulshatterAwakeningCelestialTribulation);
                        isSoulshatterAwakeningCelestialTribulation = false;
                    }
                }
            }
            if (skill instanceof PlumBlossomMainSlash) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 35) {
                    addSkillEvent(soulshatterMainSpiritStrike);
                }
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                List<SkillEvent> remove = new ArrayList<>();
                for (SkillEvent skillEvent : this.getSkillEventList()) {
                    if (
                            skillEvent.getStart().after(getStart())
                                    && skillEvent.getSkill().getClass().getName().equals(skill.getClass().getName())
                                    && !(skillEvent.getSkill() instanceof SoulshatterSecretInfiniteBladesFlame)
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
                        Timestamp now = new Timestamp(getStart().getTime());
                        setStart(new Timestamp(getStart().getTime() + i));
                        if (skill instanceof SoulshatterSecretInfiniteBladesFlame) {
                            soulshatterSecretCnt ++;
                            if (soulshatterSecretCnt == 8) {
                                addSkillEvent(soulshatterDescent);
                                soulshatterSecretCnt = 0;
                            }
                            if (getStart().before(apricotTreeEndTime)) {
                                nukeCnt += 3;
                                if (nukeCnt >= 9) {
                                    addSkillEvent(plumBlossomSecretApricotTreeGoshawk);
                                    if (getStart().before(soulshatterAwakeningEndTime)) {
                                        addSkillEvent(soulshatterAwakeningCelestialFang);
                                        celestialFangCnt ++;
                                    }
                                    nukeCnt -= 3;
                                    goshawkCnt ++;
                                }
                                if (
                                        goshawkCnt >= 30
                                                && is20
                                ) {
                                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom20);
                                    is20 = false;
                                } else if (
                                        goshawkCnt >= 70
                                                && is40
                                ) {
                                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom40);
                                    is40 = false;
                                } else if (
                                        goshawkCnt >= 125
                                                && is65
                                ) {
                                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom65);
                                    is65 = false;
                                }
                                if (
                                        celestialFangCnt % 90 == 0
                                                && getStart().before(soulshatterAwakeningEndTime)
                                                && isSoulshatterAwakeningCelestialTribulation
                                ) {
                                    addSkillEvent(soulshatterAwakeningCelestialTribulation);
                                    isSoulshatterAwakeningCelestialTribulation = false;
                                }
                            }
                        }
                        setStart(new Timestamp(now.getTime()));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        Timestamp now = new Timestamp(getStart().getTime());
                        setStart(new Timestamp(getStart().getTime() + i));
                        if (skill instanceof PlumBlossomSecretFlashDance) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 35) {
                                addSkillEvent(soulshatterMainSpiritStrike);
                            }
                            if (cooldownCheck(continuousRing)) {
                                addSkillEvent(continuousRing);
                            }
                        }
                        if (
                                skill instanceof PlumBlossomSecretFlashDance
                                || skill instanceof PlumBlossom3KeenBlade
                        ) {
                            Long ran = (long) (Math.random() * 99 + 1);
                            if (ran <= 35) {
                                addSkillEvent(plumBlossom2FallingPetals);
                            }
                            if (getStart().before(apricotTreeEndTime)) {
                                nukeCnt++;
                                if (nukeCnt >= 9) {
                                    addSkillEvent(plumBlossomSecretApricotTreeGoshawk);
                                    if (getStart().before(soulshatterAwakeningEndTime)) {
                                        addSkillEvent(soulshatterAwakeningCelestialFang);
                                        celestialFangCnt ++;
                                    }
                                    nukeCnt -= 3;
                                    goshawkCnt ++;
                                }
                                if (
                                        goshawkCnt >= 30
                                                && is20
                                ) {
                                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom20);
                                    is20 = false;
                                } else if (
                                        goshawkCnt >= 70
                                                && is40
                                ) {
                                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom40);
                                    is40 = false;
                                } else if (
                                        goshawkCnt >= 125
                                                && is65
                                ) {
                                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom65);
                                    is65 = false;
                                }
                                if (
                                        celestialFangCnt % 90 == 0
                                                && getStart().before(soulshatterAwakeningEndTime)
                                                && isSoulshatterAwakeningCelestialTribulation
                                ) {
                                    addSkillEvent(soulshatterAwakeningCelestialTribulation);
                                    isSoulshatterAwakeningCelestialTribulation = false;
                                }
                            }
                        }
                        setStart(new Timestamp(now.getTime()));
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
        if (skill instanceof SoulshatterSecretTearGround1) {
            if (grandisCnt == 3) {
                grandisActivateTime = new Timestamp(soulshatterSecretTearGround1.getActivateTime().getTime());
            } else if (grandisCnt == 0) {
                soulshatterSecretTearGround1.setActivateTime(grandisActivateTime);
                grandisCnt = -1;
            }
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
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            Timestamp now = new Timestamp(getStart().getTime());
            setStart(new Timestamp(getStart().getTime() + sum));
            if (skill instanceof PlumBlossomSecretFlashDance) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 35) {
                    addSkillEvent(soulshatterMainSpiritStrike);
                }
            }
            if (
                    skill instanceof SoulshatterAwakeningCelestialTribulation
                    || skill instanceof AzureDragonSkybreakerSwordAscension1
                    || skill instanceof AzureDragonSkybreakerSwordAscension2
                    || skill instanceof SoulshatterSecretInfiniteBlades
            ) {
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 35) {
                    addSkillEvent(plumBlossom2FallingPetals);
                }
            }
            if (
                    skill instanceof SoulshatterSecretInfiniteBlades
                    || skill instanceof SoulshatterSecretMindBladeForce
            ) {
                soulshatterSecretCnt ++;
                if (soulshatterSecretCnt == 8) {
                    addSkillEvent(soulshatterDescent);
                    soulshatterSecretCnt = 0;
                }
            }
            if (
                    getStart().before(apricotTreeEndTime)
                    && (
                            skill instanceof SoulshatterSecretInfiniteBlades
                            || skill instanceof AzureDragonSkybreakerSwordAscension1
                            || skill instanceof AzureDragonSkybreakerSwordAscension2
                            || skill instanceof SoulshatterSecretMindBladeForce
                    )
            ) {
                nukeCnt += 3;
                if (nukeCnt >= 9) {
                    addSkillEvent(plumBlossomSecretApricotTreeGoshawk);
                    if (getStart().before(soulshatterAwakeningEndTime)) {
                        addSkillEvent(soulshatterAwakeningCelestialFang);
                        celestialFangCnt ++;
                    }
                    nukeCnt -= 3;
                    goshawkCnt ++;
                }
                if (
                        goshawkCnt >= 30
                                && is20
                ) {
                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom20);
                    is20 = false;
                } else if (
                        goshawkCnt >= 70
                                && is40
                ) {
                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom40);
                    is40 = false;
                } else if (
                        goshawkCnt >= 125
                                && is65
                ) {
                    addSkillEvent(plumBlossomSecretApricotTreePlumBlossom65);
                    is65 = false;
                }
                if (
                        celestialFangCnt % 90 == 0
                                && getStart().before(soulshatterAwakeningEndTime)
                                && isSoulshatterAwakeningCelestialTribulation
                ) {
                    addSkillEvent(soulshatterAwakeningCelestialTribulation);
                    isSoulshatterAwakeningCelestialTribulation = false;
                }
            }
            if (
                    cooldownCheck(continuousRing)
                            && (
                            skill instanceof SoulshatterSecretInfiniteBlades
                                    || skill instanceof AzureDragonSkybreakerSwordAscension1
                                    || skill instanceof AzureDragonSkybreakerSwordAscension2
                    )
            ) {
                addSkillEvent(continuousRing);
            }
            setStart(new Timestamp(now.getTime()));
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
                        if (bs.getStartTimeList().size() == 0) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        } else if (skillEvent.getStart().after(bs.getStartTimeList().get(bs.getStartTimeList().size() - 1))) {
                            bs.setUseCount(bs.getUseCount() + 1);
                            bs.getStartTimeList().add(skillEvent.getStart());
                            bs.getEndTimeList().add(skillEvent.getEnd());
                        }
                    }
                }
            }
            useBuffSkillList = deduplication(useBuffSkillList, skillEvent -> skillEvent.getSkill().getName());
            for (SkillEvent skillEvent : useBuffSkillList) {
                if (
                        !isRingOfSum()
                                && skillEvent.getSkill() instanceof RingOfSum
                ) {
                    setRingOfSum(true);
                }
                if (skillEvent.getSkill() instanceof GrandisGoddessBlessingAnima) {
                    isGrandisBless = true;
                }
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
            setRingOfSum(false);
            isGrandisBless = false;
        }
        for (AttackSkill as : getAttackSkillList()) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @JsonIgnore
    public Long getAttackDamage(SkillEvent skillEvent, BuffSkill buffSkill, Timestamp start, Timestamp end) {
        Long attackDamage = 0L;
        Long ringOfSumStat = 0L;
        AttackSkill attackSkill = (AttackSkill) skillEvent.getSkill();
        boolean b = skillEvent.getSkill() instanceof SoulshatterSecretTearGround1
                || skillEvent.getSkill() instanceof SoulshatterSecretTearGround2
                || skillEvent.getSkill() instanceof SoulshatterSecretInfiniteBlades
                || skillEvent.getSkill() instanceof SoulshatterSecretInfiniteBladesFlame
                || skillEvent.getSkill() instanceof PlumBlossomSecretApricotTreePlumBlossom20
                || skillEvent.getSkill() instanceof PlumBlossomSecretApricotTreePlumBlossom40
                || skillEvent.getSkill() instanceof PlumBlossomSecretApricotTreePlumBlossom65
                || skillEvent.getSkill() instanceof PlumBlossomSecretFlashDance
                || skillEvent.getSkill() instanceof SoulshatterSecretMindBlade
                || skillEvent.getSkill() instanceof SoulshatterSecretMindBladeForce
                || skillEvent.getSkill() instanceof AzureDragonSkybreakerSwordAscension1
                || skillEvent.getSkill() instanceof AzureDragonSkybreakerSwordAscension2
                || skillEvent.getSkill() instanceof SoulshatterDescent;
        if (
                isGrandisBless && b
        ) {
            ((AttackSkill) skillEvent.getSkill()).addFinalDamage(1.15);
        }
        for (AttackSkill as : getAttackSkillList()) {
            if (as.getClass().getName().equals(skillEvent.getSkill().getClass().getName())) {
                this.getJob().addMainStat(buffSkill.getBuffMainStat());
                this.getJob().addSubStat(buffSkill.getBuffSubStat());
                this.getJob().addOtherStat1(buffSkill.getBuffOtherStat1());
                this.getJob().addOtherStat2(buffSkill.getBuffOtherStat2());
                if (isRingOfSum()) {
                    ringOfSumStat = getRingOfSumStat();
                    this.getJob().addMainStat(ringOfSumStat);
                }
                if (attackSkill instanceof DotAttackSkill) {
                    attackDamage = getDotDamage(attackSkill, buffSkill);
                } else {
                    attackDamage = (long) Math.floor(((getJob().getFinalMainStat()) * 4
                            + getJob().getFinalSubstat()) * 0.01
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
                if (isRingOfSum()) {
                    this.getJob().addMainStat(-ringOfSumStat);
                }
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
        if (isGrandisBless && b) {
            ((AttackSkill) skillEvent.getSkill()).minusFinalDamage(1.15);
        }
        return attackDamage;
    }
}
