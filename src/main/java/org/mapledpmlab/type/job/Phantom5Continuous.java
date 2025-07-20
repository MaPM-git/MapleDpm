package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalReuse;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

import java.util.stream.Collectors;

public class Phantom5Continuous extends Job {
    private final Long subStat = 4L;

    public Phantom5Continuous() {
        // 기본
        super();
        this.setName("팬텀(5초, 컨티)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2524608.0);

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
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
        passive.addAttP(21L);
        getPassiveList().add(passive);

        // 0차
        passive = new Common();
        passive.setDescription("하이 덱스터러티");
        passive.addSubStat(40L);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("케인 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("럭 모노폴리");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("럭 오브 팬텀시프");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("문 라이트");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어큐트 센스");
        passive.addCriticalP(35.0);
        passive.addFinalDamage(1.3);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("프레이 오브 아리아");
        passive.addDamage(46L);
        passive.addIgnoreDefenseList(31L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("케인 엑스퍼트");
        passive.addAtt(41L);
        passive.addCriticalDamage(20.0);
        passive.addFinalDamage(1.32);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("레디 투 다이");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-78L);
        this.addMainStat(-1L);
        this.addSubStat(5L);

        this.setAbility(new BossAbnormalReuse());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new LukUnion());

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
        doping.setDescription("스피릿 블레이드");
        doping.addAtt(30L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("크로스 오버 체인");
        doping.addFinalDamage(1.2);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("템페스트 오브 카드 디버프");
        doping.addIgnoreDefenseList(20L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("프레이 오브 아리아(콜렉터의 영약)");
        doping.addDamage(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("케인 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        doping.addCriticalDamage(1.0);
        doping.minusFinalDamage(1.32);
        doping.addFinalDamage(1.33);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
