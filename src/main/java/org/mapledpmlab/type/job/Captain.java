package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PirateBlessing;
import org.mapledpmlab.type.union.DexUnion2;

import java.util.stream.Collectors;

public class Captain extends Job {

    public Captain() {
        // 기본
        super();
        this.setName("캡틴(0초, 리웨)");
        this.setConstant(1.5);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2888550.0);

        Common passive = new Common();
        passive.setDescription("무기");
        passive.addMainStat((long) (150 + 32 + 145));
        passive.addSubStat((long) (150 + 145));
        passive.addAtt((long) (249 + 154 + 72 + 221));
        passive.addBossDamage((long) (30 + 10));
        passive.addIgnoreDefenseList(20L);
        passive.addBossDamage(70L);
        passive.addAttP(9L);
        passive.addAttP(21L);
        passive.addAttP(3L);
        getPassiveList().add(passive);
        this.setWeaponAttMagic((long) (249 + 154 + 72 + 221));

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
        passive.setDescription("크리티컬 로어");
        passive.addCriticalP(20.0);
        passive.addCriticalDamage(5.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("인피닛 불릿");
        passive.addAtt(10L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("자이언트 불릿");
        passive.addAtt(22L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("건 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("건 마스터리");
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("할로포인트 불릿");
        passive.addAtt(60L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("풀메탈 자켓");
        passive.addFinalDamage(1.2);
        passive.addCriticalP(30.0);
        passive.addIgnoreDefenseList(20L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("컨티뉴얼 에이밍");
        passive.addCriticalDamage(21.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("파이렛 스타일");
        passive.addAttP(21L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("크루 커맨더십");
        passive.addCriticalDamage(26.0);
        passive.addCriticalP(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("캡틴 디그니티");
        passive.addFinalDamage(1.08);
        passive.addAtt(31L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-63L);
        this.addMainStat(-4L);
        this.addSubStat(-5L);

        this.setAbility(new ReuseBossAbnormal());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PirateBlessing());
        this.setUnion(new DexUnion2());

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
        doping.setDescription("컨티뉴얼 에이밍");
        doping.addFinalDamage(1.29);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("오펜스 폼");
        doping.addDamage(17L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("크루 커맨더십");
        doping.addAtt(51L);
        doping.addCriticalDamage(5.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("컨티뉴얼 에이밍(콜렉터의 영약)");
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("파이렛 스타일(콜렉터의 영약)");
        doping.addAttP(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("크루 커맨더십(콜렉터의 영약)");
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("캡틴 디그니티(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
