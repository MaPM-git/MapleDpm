package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.artifact.ArtifactNormal;
import org.mapledpmlab.type.etc.Common;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.hyper.HyperArcher;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;

import java.util.stream.Collectors;

public class WindBreaker extends Job {

    public WindBreaker() {
        // 기본
        super();
        this.setName("윈드브레이커(리웨)");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (318 + 196 + 72 + 246));
        this.setWeaponAttMagic((long) (318 + 196 + 72 + 246));
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

        // 0차
        this.addAttP(10L);              // 엘리멘탈 엑스퍼트
        this.addMagicP(10L);
        this.addMainStat(               // 엘리멘탈 하모니
                (this.getLevel() - 1) / 2
        );

        // 1차
        this.addDamage(10L);            // 엘리멘트 : 스톰
        this.addAtt(20L);               // 위스퍼 오브 더 윈드

        // 2차
        this.addAtt(20L);               // 실프스 에이드
        this.addCriticalP(10.0);
        this.addMainStat(20L);          // 보우 액셀레이션
        this.addFinalDamage(1.1);       // 보우 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(20L);               // 알바트로스
        this.addCriticalP(10.0);
        this.addFinalDamage(1.09);

        // 4차
        this.addCriticalP(21.0 - 10);   // 샤프 아이즈
        this.addCriticalDamage(16.0 - 8);
        this.addAttP(11L);              // 윈드 블레싱
        this.addMainStatP(16L);
        this.addAtt(31L);               // 보우 엑스퍼트
        this.addFinalDamage(1.36);
        this.addCriticalDamage(20.0);
        this.addBossDamage(41L);
        this.addAtt(31L);               // 알바트로스 맥시멈
        this.addDamage(25L);
        this.addIgnoreDefenseList(15L);
        this.addCriticalP(15.0);

        // 환산 보정
        this.addMainStatP(-66L);
        this.addMainStat(-1L);
        this.addSubStat(5L);

        this.setAbility(new BossCriticalAbnormal());
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
        this.addAtt(15L);               // 세컨드 윈드
        this.addCriticalP(-20.0);       // 세이람의 영약
        this.addCriticalDamage(-16.0);
    }
}
