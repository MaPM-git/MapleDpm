package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.link.AdventurerCuriosity;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.DexUnion;

public class Pathfinder extends Job {

    public Pathfinder() {
        // 기본
        super();
        this.setDescription("패스파인더");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossCriticalAbnormal());
        this.addObject(new NormalFarm());
        this.addObject(new HybridLogic());
        this.addObject(new AdventurerCuriosity());
        this.addObject(new DexUnion());
        this.addPerXMainStat(20L);

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
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addCriticalP(40.0);        // 크리티컬 샷

        // 2차
        this.addMainStat(20L);          // 에이션트 보우 액셀레이션
        this.addAtt(30L);               // 에이션트 보우 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addFinalDamage(1.2);       // 에이션트 가이던스
        this.addCriticalP(10.0);        // 에센스 오브 아처
        this.addDamage(10L);
        this.addIgnoreDefenseList(30L);

        // 4차
        this.addCriticalP(11.0);        // 샤프 아이즈
        this.addCriticalDamage(8.0);
        this.addIgnoreDefenseList(5L);
        this.addAttP(21L);              // 에디셔널 트랜지션
        this.addAtt(62L);               // 에이션트 보우 엑스퍼트
        this.addCriticalDamage(11.0);
        this.addMainStat(82L);          // 일루전 스탭
    }
}
