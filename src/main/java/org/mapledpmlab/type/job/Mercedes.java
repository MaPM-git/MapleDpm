package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.FinalAttackFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.DexUnion;

public class Mercedes extends Job {

    public Mercedes() {
        // 기본
        super();
        this.setDescription("메르세데스");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION1);
        this.addObject(new BossCriticalAbnormal());
        this.addObject(new FinalAttackFarm());
        this.addObject(new HybridLogic());
        this.addObject(new DexUnion());

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
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addDamage(20L);            // 포텐셜 파워
        this.addCriticalP(40.0);        // 샤프 에이밍

        // 2차
        this.addMainStat(20L);          // 듀얼보우건 액셀레이션
        this.addDamage(30L);            // 스피릿 인퓨젼
        this.addCriticalP(15.0);
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addFinalDamage(1.25);      // 이그니스 로어
        this.addAtt(40L);

        // 4차
        this.addAttP(31L);              // 앤시언트 스피릿
        this.addAtt(31L);               // 듀얼보우건 엑스퍼트
        this.addCriticalDamage(11.0);
        this.addFinalDamage(1.21);      // 디펜스 브레이크
        this.addIgnoreDefenseList(26L);
        this.addBossDamage(20L);
        this.addCriticalDamage(20.0);
        this.addAtt(21L);               // 어드밴스드 파이널 어택

        // 하이퍼
        this.addAtt(80L);               // 엘비쉬 블레싱
        this.addFinalDamage(1.1);
    }
}
