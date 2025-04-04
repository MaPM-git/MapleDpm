package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.Job;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperCommon;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PirateBlessing;
import org.mapledpmlab.type.union.StrUnion;

import java.util.stream.Collectors;

public class Viper extends Job {

    public Viper() {
        // 기본
        super();
        this.setName("바이퍼(리웨)");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (255 + 157 + 72 + 223));
        this.setWeaponAttMagic((long) (255 + 157 + 72 + 223));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addOtherStat1(10L);
        this.addOtherStat2(10L);
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addCriticalP(20.0);        // 크리티컬 로어
        this.addCriticalDamage(5.0);

        // 2차
        this.addMainStat(20L);          // 너클 액셀레이션
        this.addAtt(30L);               // 멘탈 클리어리티
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(30L);               // 크리티컬 레이지
        this.addCriticalP(15.0);
        this.addCriticalDamage(10.0);
        this.addCriticalP(60.0);        // 그로기 마스터리

        // 4차
        this.addAttP(15L);              // 바이퍼지션
        this.addFinalDamage(1.13);
        this.addIgnoreDefenseList(44L); // 가드 크러쉬
        this.addFinalDamage(1.1);
        this.addAtt(32L);

        // 5차
        this.addAtt(40L);               // 로디드 다이스

        // 환산 보정
        this.addMainStatP(-36L);
        this.addMainStat(7L);
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
        this.addCriticalDamage(15.0);   // 그로기 마스터리
        this.addDamage(27L);            // 오펜스 폼
        this.addCriticalDamage(15.0);   // 서펜트 스피릿
    }
}
