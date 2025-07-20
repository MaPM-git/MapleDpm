package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PirateBlessing;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class ViperContinuous extends Job {

    public ViperContinuous() {
        // 기본
        super();
        this.setName("바이퍼(0초, 컨티)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        this.setAscentDamage(2820825.0);

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
        passive.addOtherStat1(10L);
        passive.addOtherStat2(10L);
        passive.addAtt(3L);
        //passive.addBossDamage(70L);
        //passive.addAttP(9L);
        passive.addBossDamage(30L);
        passive.addAttP(21L);
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
        passive.setDescription("너클 액셀레이션");
        passive.addMainStat(20L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("멘탈 클리어리티");
        passive.addAtt(30L);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("피지컬 트레이닝");
        passive.addMainStat(30L);
        passive.addSubStat(30L);
        getPassiveList().add(passive);

        // 3차
        passive = new Common();
        passive.setDescription("크리티컬 레이지");
        passive.addAtt(30L);
        passive.addCriticalP(15.0);
        passive.addCriticalDamage(10.0);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("그로기 마스터리");
        passive.addCriticalP(60.0);
        getPassiveList().add(passive);

        // 4차
        passive = new Common();
        passive.setDescription("바이퍼지션");
        passive.addAttP(15L);
        passive.addFinalDamage(1.13);
        getPassiveList().add(passive);

        passive = new Common();
        passive.setDescription("가드 크러쉬");
        passive.addIgnoreDefenseList(44L);
        passive.addFinalDamage(1.1);
        passive.addAtt(32L);
        getPassiveList().add(passive);

        // 5차
        passive = new Common();
        passive.setDescription("로디드 다이스");
        passive.addAtt(40L);
        getPassiveList().add(passive);

        this.addObject(getPassiveList());

        // 환산 보정
        this.addMainStatP(-39L);
        this.addMainStat(14L);
        this.addSubStat(-5L);

        this.setAbility(new BossAbnormalAttack());
        this.setArtifact(new ArtifactNormal());
        this.getLinkList().add(new HybridLogic());
        this.getLinkList().add(new PirateBlessing());
        this.setUnion(new StrUnion());
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
        doping.setDescription("그로기 마스터리");
        doping.addCriticalDamage(15.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("오펜스 폼");
        doping.addDamage(27L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("서펜트 스피릿");
        doping.addCriticalDamage(15.0);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("바이퍼지션(콜렉터의 영약)");
        doping.addAttP(1L);
        getDopingList().add(doping);

        doping = new Common();
        doping.setDescription("가드 크러쉬(콜렉터의 영약)");
        doping.addAtt(2L);
        getDopingList().add(doping);

        this.addObject(getDopingList());
    }
}
