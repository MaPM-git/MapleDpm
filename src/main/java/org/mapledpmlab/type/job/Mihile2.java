package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.MihileUnion;

import java.util.stream.Collectors;

public class Mihile2 extends Job {
    private final Long subStat = 4L;

    public Mihile2() {
        // 기본
        super();
        this.setName("미하일(2초, 리웨)");
        this.setConstant(1.24);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);

        this.setAscentDamage(2395750.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (326 + 201 + 72 + 249));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (326 + 201 + 72 + 249));

        passive = new Common();
        passive.setDescription("보조무기");
        passive.addMainStat(21L);
        passive.addSubStat(21L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("엘리멘탈 엑스퍼트");
        passive.addAttP(10L);
        passive.addMagicP(10L);
        getPassiveList().add(passive);

        // 1차
        passive = new Common();
        passive.setDescription("소울 어택");
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("인커리지");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("소드 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("소드 마스터리");
        passive.addAtt(20L);
        passive.addFinalDamage(1.2);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("로얄 오쓰");
        passive.addMainStat(60L);
        passive.addCriticalP(20.0);
        passive.addFinalDamage(1.25);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 소울 어택");
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("소울 링크");
        passive.addDamage(5L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("소울 레이지");
        passive.addFinalDamage(1.23);
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 소드 마스터리");
        passive.addAtt(31L);
        passive.addCriticalP(15.0);
        passive.addCriticalDamage(20.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어드밴스드 파이널 어택");
        passive.addAtt(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("컴뱃 마스터리");
        passive.addIgnoreDefenseList(42L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("바디 오브 스틸");
        passive.addMainStat(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-96L);
        this.addMainStat(3L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalReuse());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.setUnion(new MihileUnion());

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
        doping.setDescription("로얄 가드");
        doping.addAtt(100L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 소울 어택");
        doping.addFinalDamage(1.25);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("데들리 차지");
        doping.addDamage(10L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("소울 레이지(콜렉터의 영약)");
        doping.minusFinalDamage(1.23);
        doping.addFinalDamage(1.24);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 소드 마스터리(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어드밴스드 파이널 어택(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("인커리지(콜렉터의 영약)");
        doping.addAtt(-30L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
