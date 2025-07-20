package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class BlasterContinuous extends Job {

    public BlasterContinuous() {
        // 기본
        super();
        this.setName("블래스터(0초, 컨티)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(3381840.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (255 + 157 + 72 + 223));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(10L);
        passive.addSubStat(10L);
        passive.addAtt(3L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("건틀렛 마스터리");
        passive.addCriticalP(30.0);
        passive.addAtt(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("차지 마스터리");
        passive.addDamage(15L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("콤비네이션 트레이닝");
        passive.addAttP(15L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("건틀렛 엑스퍼트");
        passive.addCriticalDamage(15.0);
        passive.addBossDamage(11L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 차지 마스터리");
        passive.addIgnoreDefenseList(38L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("콤비네이션 트레이닝 II");
        passive.addAtt(42L);
        passive.addCriticalP(40.0);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        // 환산 보정
        this.addMainStatP(-66L);
        this.addMainStat(2L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new StrUnion());

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperCommon(this.getLevel(), this.getCriticalP()));
        this.addObject(this.getHyper());

        this.addObject(getPassiveList());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("콤비네이션 트레이닝");
        doping.addFinalDamage(1.7);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("해머 스매시");
        doping.addFinalDamage(1.1);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("콤비네이션 트레이닝 II(콜렉터의 영약)");
        doping.addAtt(2L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
