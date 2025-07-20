package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.NatureFriend;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Khali5 extends Job {

    public Khali5() {
        // 기본
        super();
        this.setName("칼리(5초, 리레단일)");
        this.setConstant(1.30);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2256120.0);

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
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("플레어");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("차크람 마스터리");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("임펄스");
        passive.addCriticalP(35.0);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("인투이션");
        passive.addFinalDamage(1.3);
        passive.addIgnoreDefenseList(20L);
        passive.addAtt(30L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("차크람 엑스퍼트");
        passive.addAtt(31L);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("리뎀션");
        passive.addFinalDamage(1.42);
        passive.addIgnoreDefenseList(21L);
        passive.addBossDamage(31L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("레디 투 다이");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-45L);
        this.addMainStat(-1L);
        this.addSubStat(-10L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new NatureFriend());
        this.getLinkList().add(new PhantomInstinct());
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
        doping.setDescription("차크람 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("리뎀션(콜렉터의 영약)");
        doping.minusFinalDamage(1.42);
        doping.addFinalDamage(1.44);
        doping.addBossDamage(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
