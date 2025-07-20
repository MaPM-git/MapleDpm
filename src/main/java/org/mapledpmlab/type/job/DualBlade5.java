package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.Confidence;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class DualBlade5 extends Job {

    public DualBlade5() {
        // 기본
        super();
        this.setName("듀얼블레이드(5초, 리웨)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2868192.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (318 + 196 + 72 + 246));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat((long) (65 + 36 + 145));
        passive.addSubStat(145L);
        passive.addAtt((long) (140 + 81 + 186));
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("이도 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("카르마");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 2.5차
        passive = new Common();
        passive.setDescription("베놈");
        passive.addFinalDamage(1.09);
        getPassiveList().add(passive);
        
        // 3차
        passive = new Common();
        passive.setDescription("섀도우 이베이젼");
        passive.addFinalDamage(1.07);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("바이탈 스틸");
        passive.addBossDamage(5L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("쏜즈 이펙트");
        passive.addAtt(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("샤프니스");
        passive.addCriticalP(38.0);
        passive.addCriticalDamage(16.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("이도류 엑스퍼트");
        passive.addAtt(31L);
        passive.addFinalDamage(1.2);
        getPassiveList().add(passive);

        // 하이퍼
        passive = new Common();
        passive.setDescription("히든 블레이드");
        passive.addDamage(10L);
        getPassiveList().add(passive);

        this.addDamage(10L);            // 히든 블레이드

        // 5차
        passive = new Common();
        passive.setDescription("레디 투 다이");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-90L);
        this.addMainStat(-7L);
        this.addSubStat(0L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new PhantomInstinct());
        this.getLinkList().add(new Confidence());
        this.setUnion(new LukUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("섀도우 인베이젼");
        doping.addAtt(15L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("쏜즈 이펙트(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("샤프니스(콜렉터의 영약)");
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("이도류 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.minusFinalDamage(1.2);
        doping.addFinalDamage(1.21);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }

    public Long getFinalSubStat2() {
        return (long) Math.floor(
                this.getOtherStat1()
                * (1 + this.getAllStatP() * 0.01))
                + this.getPerXOtherStat();
    }

    public Long getStatDamage() {
        return (long) Math.floor(
                (this.getFinalMainStat() * 4 + getFinalSubstat() + getFinalSubStat2()) * 0.01
                * Math.floor(this.getAtt() * (1 + this.getAttP() * 0.01))
                * this.getConstant()
                * (1 + this.getDamage() * 0.01)
                * this.getFinalDamage()
        );
    }

    @Override
    public Object[] getOpject() {
        Long attMagicBase;
        Long attMagicP;
        Long attMagicAbs;
        Long statusAdditionalDmg;
        if (this.getAtt() > this.getMagic()) {
            attMagicBase = this.getAtt();
            attMagicP = this.getAttP();
            attMagicAbs = this.getPerXAtt();
        } else {
            attMagicBase = this.getMagic();
            attMagicP = this.getMagicP();
            attMagicAbs = this.getPerXAtt();
        }
        if (this.getAbilityDescription().contains("상태")) {
            statusAdditionalDmg = 14L;
        } else {
            statusAdditionalDmg = 6L;
        }
        Object[] result = new Object[]{
                this.getName(), this.getConstant(), this.getMastery() * 2 - 1, this.getLevel(),
                this.getMainStat(), this.getMainStatP() + this.getAllStatP(), this.getPerXMainStat(),
                this.getSubStat(), this.getAllStatP(), this.getPerXSubStat(), this.getOtherStat1(), this.getAllStatP(), this.getPerXOtherStat(), this.getStatDamage(),
                this.getDamage(), String.format("%.2f", this.getFinalDamage() * 100 - 100), this.getBossDamage(),
                String.format("%.4f", this.getIgnoreDefense() * 100), attMagicBase, attMagicP, attMagicAbs, this.getCriticalP(), this.getCriticalDamage(),
                this.getCooldownReductionSec() + "초 / " + this.getCooldownReductionP() + "%", this.getPlusBuffDuration(), this.getReuse(),
                this.getProperty(), statusAdditionalDmg, "30", "1350", "660", this.getWeaponAttMagic()
        };
        return result;
    }
}
