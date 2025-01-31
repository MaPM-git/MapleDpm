package org.mapledpmlab.type.dealcyclesolo;

import org.mapledpmlab.type.etc.DealCycle;
import org.mapledpmlab.type.job.DemonSlayerNormal;
import org.mapledpmlab.type.job.Job;
import org.mapledpmlab.type.skill.Skill;
import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.*;
import org.mapledpmlab.type.skill.attackskill.demonslayer.*;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.*;
import org.mapledpmlab.type.skill.buffskill.demonslayer.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class DemonSlayerDealCycle extends DealCycle {

    private final List<AttackSkill> attackSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponDot());
            add(new Cerburus());
            add(new CerburusTarterian());
            add(new CrestOfTheSolar());
            add(new CrestOfTheSolarDot());
            add(new DemonBaneStartDelay());
            add(new DemonBane1());
            add(new DemonBane2());
            add(new DemonicDescent());
            add(new DemonicSphere());
            add(new DemonicSphereReinforce());
            add(new DemonImpact());
            add(new DemonImpactChain());
            add(new DemonSlash1());
            add(new DemonSlash2());
            add(new DemonSlash3());
            add(new DemonSlash4());
            add(new DemonSlashReinforce1());
            add(new DemonSlashReinforce2());
            add(new DemonSlashReinforce3());
            add(new DemonSlashReinforce4());
            add(new Geryon());
            add(new Jormungand());
            add(new JormungandExtinction());
            add(new MastemaClaw());
            add(new MaxForce());
            add(new Metamorphosis());
            add(new Nemea());
            add(new NightmareFlame());
            add(new NightmareJudgement());
            add(new NightmareWave());
            add(new OtherWorldVoid());
            add(new SpiderInMirror());
            add(new SpiderInMirrorDot());
        }
    };

    private final List<BuffSkill> buffSkillList = new ArrayList<>(){
        {
            add(new AuraWeaponBuff());
            add(new BodyOfSteel(0L));
            add(new CallMastema());
            add(new DemonAwakening());
            add(new DemonicFortitude());
            add(new InfinityForce());
            add(new NightmareTerritory());
            add(new Orthrus());
            add(new OtherWorldGoddessBlessing());
            add(new RestraintRing());
            add(new RingSwitching());
            add(new SoulContract());
            add(new WeaponJumpRing(getJob().getWeaponAttMagic()));
        }
    };

    int demonForce = 150;
    Timestamp demonAwakeningEndTime = new Timestamp(-1);
    Timestamp infinityForceEndTime = new Timestamp(-1);
    Timestamp nightmareTerritoryEndTime = new Timestamp(-1);

    AuraWeaponBuff auraWeaponBuff = new AuraWeaponBuff();
    BodyOfSteel bodyOfSteel = new BodyOfSteel(0L);
    CallMastema callMastema = new CallMastema();
    Cerburus cerburus = new Cerburus();
    CerburusTarterian cerburusTarterian = new CerburusTarterian();
    CrestOfTheSolar crestOfTheSolar = new CrestOfTheSolar();
    DemonAwakening demonAwakening = new DemonAwakening();
    DemonBaneStartDelay demonBaneStartDelay = new DemonBaneStartDelay();
    DemonImpact demonImpact = new DemonImpact();
    DemonImpactChain demonImpactChain = new DemonImpactChain();
    DemonSlash1 demonSlash1 = new DemonSlash1();
    DemonSlashReinforce1 demonSlashReinforce1 = new DemonSlashReinforce1();
    DemonicDescent demonicDescent = new DemonicDescent();
    DemonicFortitude demonicFortitude = new DemonicFortitude();
    DemonicSphere demonicSphere = new DemonicSphere();
    DemonicSphereReinforce demonicSphereReinforce = new DemonicSphereReinforce();
    InfinityForce infinityForce = new InfinityForce();
    Jormungand jormungand = new Jormungand();
    MaxForce maxForce = new MaxForce();
    Metamorphosis metamorphosis = new Metamorphosis();
    NightmareFlame nightmareFlame = new NightmareFlame();
    NightmareJudgement nightmareJudgement = new NightmareJudgement();
    NightmareWave nightmareWave = new NightmareWave();
    Orthrus orthrus = new Orthrus();
    OtherWorldGoddessBlessing otherWorldGoddessBlessing = new OtherWorldGoddessBlessing();
    RestraintRing restraintRing = new RestraintRing();
    RingSwitching ringSwitching = new RingSwitching();
    SoulContract soulContract = new SoulContract();
    SpiderInMirror spiderInMirror = new SpiderInMirror();
    WeaponJumpRing weaponJumpRing = new WeaponJumpRing(getJob().getWeaponAttMagic());

    public DemonSlayerDealCycle(Job job) {
        super(job, null);

        if (getJob() instanceof DemonSlayerNormal) {
            getJob().setName("데몬슬레이어(리웨, 극포실, 환산 84549)");
        }

        this.setAttackSkillList(attackSkillList);
        this.setBuffSkillList(buffSkillList);

        ringSwitching.setCooldown(120.0);
        //ringSwitching.setApplyCooldownReduction(false);

        auraWeaponBuff.setCooldown(180.0);
        auraWeaponBuff.setApplyCooldownReduction(false);
        otherWorldGoddessBlessing.setCooldown(120.0);

        getSkillSequence1().add(infinityForce);
        getSkillSequence1().add(demonicFortitude);          // 30
        getSkillSequence1().add(callMastema);
        getSkillSequence1().add(bodyOfSteel);
        getSkillSequence1().add(demonAwakening);
        getSkillSequence1().add(orthrus);
        getSkillSequence1().add(otherWorldGoddessBlessing);

        infinityForce.setDelay(150L);
        callMastema.setDelay(150L);
        bodyOfSteel.setDelay(150L);
        demonAwakening.setDelay(150L);
        orthrus.setDelay(150L);
        otherWorldGoddessBlessing.setDelay(120L);
    }

    @Override
    public void setSoloDealCycle() {
        boolean isOrigin = false;

        int dealCycleOrder = 1;
        addSkillEvent(demonImpactChain);
        while (getStart().before(getEnd())) {
            if (
                    cooldownCheck(auraWeaponBuff)
                            && getStart().before(new Timestamp(660 * 1000))
            ) {
                addSkillEvent(auraWeaponBuff);
            }
            if (
                    cooldownCheck(otherWorldGoddessBlessing)
                            && getStart().after(new Timestamp(soulContract.getActivateTime().getTime() - 2000))
                            && demonForce >= 100
            ) {
                if (cooldownCheck(crestOfTheSolar)) {
                    addSkillEvent(crestOfTheSolar);
                }
                if (cooldownCheck(spiderInMirror)) {
                    addSkillEvent(spiderInMirror);
                }
                addDealCycle(getSkillSequence1());
                if (cooldownCheck(nightmareWave)) {
                    addSkillEvent(nightmareWave);
                    isOrigin = true;
                }
                addSkillEvent(jormungand);
                addSkillEvent(soulContract);
                if (cooldownCheck(restraintRing)) {
                    addSkillEvent(restraintRing);
                } else if (cooldownCheck(weaponJumpRing)) {
                    addSkillEvent(weaponJumpRing);
                }
                addSkillEvent(demonSlashReinforce1);
                addSkillEvent(demonSlashReinforce1);
                addSkillEvent(demonSlashReinforce1);
                addSkillEvent(demonBaneStartDelay);
                if (isOrigin) {
                    addSkillEvent(demonSlashReinforce1);
                    addSkillEvent(demonSlashReinforce1);
                    addSkillEvent(nightmareJudgement);
                    isOrigin = false;
                }
                dealCycleOrder ++;
            } else if (
                    cooldownCheck(soulContract)
                            && getStart().before(new Timestamp(demonicFortitude.getActivateTime().getTime() - 45000))
            ) {
                addSkillEvent(soulContract);
            } else if (
                    cooldownCheck(ringSwitching)
                            && getStart().after(new Timestamp(110 * 1000))
                            && getStart().before(new Timestamp(10 * 60 * 1000))
            ) {
                addSkillEvent(ringSwitching);
            } else if (getStart().before(demonAwakeningEndTime)) {
                addSkillEvent(demonSlashReinforce1);
            } else if (cooldownCheck(cerburusTarterian)) {
                addSkillEvent(cerburusTarterian);
            } else if (
                    cooldownCheck(demonImpactChain)
                            && demonForce >= 8
            ) {
                addSkillEvent(demonImpactChain);
            } else if (
                    demonForce >= 8
                    && !cooldownCheck(infinityForce)
            ) {
                addSkillEvent(demonImpact);
            } else {
                addSkillEvent(demonSlash1);
            }
        }
        sortEventTimeList();
    }

    public void addSkillEvent(Skill skill) {
        Timestamp endTime = null;
        if (getStart().before(skill.getActivateTime())) {
            System.out.println(getStart() + "\t" + skill.getName() + "\t" + getJob().getName() + "\t" + skill.getActivateTime());
            return;
        }
        if (skillLog.equals("")) {
            skillLog += getJob().getName() + "\tDF : " + demonForce + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        } else {
            skillLog += "\n" + getJob().getName() + "\tDF : " + demonForce + "\t" + simpleDateFormat.format(getStart()) + "\t" + skill.getName();
        }
        double gaugeTmp = 0;
        if (getStart().after(maxForce.getActivateTime())) {
            demonForce += 10;
            maxForce.setActivateTime(new Timestamp(maxForce.getActivateTime().getTime() + 4000));
        }
        if (skill instanceof GaugeAttackSkill) {
            gaugeTmp = ((GaugeAttackSkill) skill).getGaugeCharge();
            if (gaugeTmp < 0) {
                if (getStart().before(infinityForceEndTime)) {
                } else {
                    demonForce += gaugeTmp;
                }
            } else {
                demonForce += gaugeTmp;
            }
        } else if (skill instanceof GaugeBuffSkill) {
            gaugeTmp = ((GaugeBuffSkill) skill).getGaugeCharge();
            if (gaugeTmp < 0) {
                if (getStart().before(infinityForceEndTime)) {
                } else {
                    demonForce += gaugeTmp;
                }
            } else {
                demonForce += gaugeTmp;
            }
        }
        if (demonForce > 150) {
            demonForce = 150;
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
            if (skill instanceof DemonAwakening) {
                demonAwakeningEndTime = new Timestamp(getStart().getTime() + 68000);
            }
            if (skill instanceof InfinityForce) {
                infinityForceEndTime = new Timestamp(getStart().getTime() + 64250);
            }
            if (skill instanceof NightmareTerritory) {
                nightmareTerritoryEndTime = new Timestamp(getStart().getTime() + 20000);
                demonicDescent.setActivateTime(new Timestamp(-1));
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
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i + 1000));
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
                    skill instanceof DemonBane1
                    || skill instanceof DemonBane2
                    || skill instanceof DemonImpact
                    || skill instanceof DemonImpactChain
                    || skill instanceof DemonSlash1
                    || skill instanceof DemonSlash2
                    || skill instanceof DemonSlash3
                    || skill instanceof DemonSlash4
                    || skill instanceof DemonSlashReinforce1
                    || skill instanceof DemonSlashReinforce2
                    || skill instanceof DemonSlashReinforce3
                    || skill instanceof DemonSlashReinforce4
                    || skill instanceof NightmareJudgement
                    || skill instanceof NightmareWave
                    || skill instanceof Cerburus
                    || skill instanceof CerburusTarterian
                    || skill instanceof DemonicSphere
                    || skill instanceof DemonicSphereReinforce
            ) {
                if (cooldownCheck(demonicDescent)) {
                    if (getStart().before(nightmareTerritoryEndTime)) {
                        demonicDescent.setCooldown(5.0);
                    }
                    addSkillEvent(demonicDescent);
                    demonicDescent.setCooldown(20.0);
                }
                if (cooldownCheck(metamorphosis)) {
                    addSkillEvent(metamorphosis);
                }
                if (
                        getStart().before(demonAwakeningEndTime)
                        && !(skill instanceof CerburusTarterian)
                        && cooldownCheck(cerburus)
                ) {
                    CerburusTarterian ct = new CerburusTarterian();
                    ct.setDelay(0L);
                    addSkillEvent(ct);
                    applyCooldown(cerburus);
                }
                if (
                        getStart().before(nightmareTerritoryEndTime)
                        && cooldownCheck(nightmareFlame)
                ) {
                    addSkillEvent(nightmareFlame);
                }
            }
            if (
                    cooldownCheck(demonicSphere)
                    && (
                            skill instanceof DemonSlash1
                            || skill instanceof DemonSlash2
                            || skill instanceof DemonSlash3
                            || skill instanceof DemonSlash4
                    )
            ) {
                addSkillEvent(demonicSphere);
                applyCooldown(demonicSphereReinforce);
            }
            if (
                    cooldownCheck(demonicSphereReinforce)
                    && (
                            skill instanceof DemonSlashReinforce1
                            || skill instanceof DemonSlashReinforce2
                            || skill instanceof DemonSlashReinforce3
                            || skill instanceof DemonSlashReinforce4
                    )
            ) {
                addSkillEvent(demonicSphereReinforce);
                applyCooldown(demonicSphere);
            }
            if (((AttackSkill) skill).getInterval() != 0) {
                if (skill instanceof Jormungand) {
                    getSkillEventList().add(new SkillEvent(new JormungandExtinction(), new Timestamp(getStart().getTime() + 16000), new Timestamp(getStart().getTime() + 16000)));
                    getEventTimeList().add(new Timestamp(getStart().getTime() + 16000));
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
                        if (skill instanceof OtherWorldVoid) {
                            Long ran = 0L;
                            ran = (long) (Math.random() * 99 + 1);
                            if (ran >= 75) {
                                demonForce += 45;
                                if (demonForce > 150) {
                                    demonForce = 150;
                                }
                                continue;
                            } else if (ran >= 25) {
                                continue;
                            }
                        }
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                    }
                } else {
                    Long attackCount = 0L;
                    for (long i = ((AttackSkill) skill).getInterval(); i <= ((AttackSkill) skill).getDotDuration() && attackCount < ((AttackSkill) skill).getLimitAttackCount(); i += ((AttackSkill) skill).getInterval()) {
                        getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + i), new Timestamp(getStart().getTime() + i)));
                        getEventTimeList().add(new Timestamp(getStart().getTime() + i));
                        if (
                                skill instanceof DemonBane1
                                || skill instanceof DemonBane2
                        ) {
                            Timestamp temp = new Timestamp(getStart().getTime());
                            getStart().setTime(getStart().getTime() + i);
                            if (
                                    getStart().before(nightmareTerritoryEndTime)
                                    && cooldownCheck(nightmareFlame)
                            ) {
                                addSkillEvent(nightmareFlame);
                            }
                            if (cooldownCheck(demonicDescent)) {
                                if (getStart().before(nightmareTerritoryEndTime)) {
                                    demonicDescent.setCooldown(5.0);
                                }
                                addSkillEvent(demonicDescent);
                                demonicDescent.setCooldown(20.0);
                            }
                            if (cooldownCheck(metamorphosis)) {
                                addSkillEvent(metamorphosis);
                            }
                            if (
                                    getStart().before(demonAwakeningEndTime)
                                    && cooldownCheck(cerburus)
                            ) {
                                CerburusTarterian ct = new CerburusTarterian();
                                ct.setDelay(0L);
                                addSkillEvent(ct);
                                applyCooldown(cerburus);
                            }
                            getStart().setTime(temp.getTime());
                        }
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
                Long ran = (long) (Math.random() * 99 + 1);
                if (ran <= 1) {
                    buffSkill.addBuffDamage(100L);      // 데스 커스 
                }
                totalDamage += getAttackDamage(se, buffSkill, start, end);
                if (ran <= 1) {
                    buffSkill.addBuffDamage(-100L);      // 데스 커스
                }
                if (((AttackSkill) se.getSkill()).isApplyFinalAttack()) {
                    ran = (long) (Math.random() * 99 + 1);
                    if (ran <= getFinalAttack().getProp() && start.equals(se.getStart())) {
                        totalDamage += getAttackDamage(new SkillEvent(getFinalAttack(), start, end), buffSkill, start, end);
                    }
                }
            }
        }
        for (AttackSkill as : attackSkillList) {
            as.setShare(as.getCumulativeDamage().doubleValue() / totalDamage * 100);
        }
        return totalDamage;
    }

    @Override
    public void multiAttackProcess(Skill skill) {
        Long sum = 0L;
        for (Long info : ((AttackSkill) skill).getMultiAttackInfo()) {
            sum += info;
            getSkillEventList().add(new SkillEvent(skill, new Timestamp(getStart().getTime() + sum), new Timestamp(getStart().getTime() + sum)));
            getEventTimeList().add(new Timestamp(getStart().getTime() + sum));
            if (
                    skill instanceof NightmareJudgement
                    || skill instanceof NightmareWave
            ) {
                Timestamp temp = new Timestamp(getStart().getTime());
                getStart().setTime(getStart().getTime() + sum);
                if (cooldownCheck(demonicDescent)) {
                    if (getStart().before(nightmareTerritoryEndTime)) {
                        demonicDescent.setCooldown(5.0);
                    }
                    addSkillEvent(demonicDescent);
                    demonicDescent.setCooldown(20.0);
                }
                if (cooldownCheck(metamorphosis)) {
                    addSkillEvent(metamorphosis);
                }
                if (
                        getStart().before(demonAwakeningEndTime)
                        && cooldownCheck(cerburus)
                ) {
                    CerburusTarterian ct = new CerburusTarterian();
                    ct.setDelay(0L);
                    addSkillEvent(ct);
                    applyCooldown(cerburus);
                }
                getStart().setTime(temp.getTime());
            }
        }
    }
}
