package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossCritical;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class Kain5 extends Job {

    public Kain5() {
        // 기본
        super();
        this.setName("카인(5초, 리웨)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.87 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        this.setAscentDamage(2019360.0);

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
        passive.setDescription("히트맨");
        passive.addAtt(40L);
        passive.addCriticalP(35.0);
        getPassiveList().add(passive);

        // 2차
        passive = new Common();
        passive.setDescription("브레스 슈터 마스터리");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(60L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("내츄럴 본 인스팅트");
        passive.addFinalDamage(1.25);
        passive.addAtt(40L);
        passive.addCriticalP(20.0);
        passive.addIgnoreDefenseList(10L);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("그라인딩 II");
        passive.addAtt(37L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("도그마");
        passive.addFinalDamage(1.3);
        passive.addCriticalDamage(22.0);
        passive.addIgnoreDefenseList(32L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("브레스 슈터 엑스퍼트");
        passive.addFinalDamage(1.31);
        passive.addAtt(32L);
        passive.addCriticalDamage(21.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("어댑트 투 데스");
        passive.addDamage(27L);
        passive.addBossDamage(15L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-78L);
        this.addMainStat(-5L);
        this.addSubStat(-8L);

        this.setAbility(new PassiveBossCritical());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PhantomInstinct());
        this.setUnion(new DexUnion());
        this.addPerXMainStat(20L);

        this.addObject(this.getAbility());
        this.addObject(this.getArtifact());
        this.addObject(this.getLinkList().stream().map(s -> (Common) s).collect(Collectors.toList()));
        this.addObject(this.getUnion());
        this.setHyper(new HyperArcher(this.getLevel()));
        this.addObject(this.getHyper());
    }

    @Override
    public void Doping() {
        super.Doping();

        Common doping = new Common();
        doping.setDescription("그라인딩 II(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("도그마(콜렉터의 영약)");
        doping.minusFinalDamage(1.3);
        doping.addFinalDamage(1.31);
        doping.addCriticalDamage(1.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("브레스 슈터 엑스퍼트(콜렉터의 영약)");
        doping.addAtt(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("어댑트 투 데스(콜렉터의 영약)");
        doping.addDamage(1L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
