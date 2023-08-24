package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.FinalAttackFarm;
import org.mapledpmlab.type.link.AdventurerCuriosity;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.DexUnion;

public class Bowmaster extends Job {

    public Bowmaster() {
        // 기본
        super();
        this.setName("보우마스터");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossCriticalAbnormal());
        this.addObject(new FinalAttackFarm());
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
        this.addMainStat(20L);          // 보우 액셀레이션
        this.addAtt(30L);               // 소울 애로우 : 활
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(40L);               // 익스트림 아쳐리 : 활
        this.addFinalDamage(1.3);
        this.addAttP(25L);              // 마크맨쉽
        this.addIgnoreDefenseList(25L);

        // 4차
        this.addFinalDamage(1.06);      // 어드밴스드 퀴버
        this.addCriticalP(20.0);        // 샤프 아이즈
        this.addCriticalDamage(15.0);
        this.addIgnoreDefenseList(5L);
        this.addAtt(62L);               // 보우 엑스퍼트
        this.addCriticalDamage(16.0);
        this.addMainStat(82L);          // 일루전 스탭
        this.addAtt(21L);               // 어드밴스드 파이널 어택
        this.addIgnoreDefenseList(40L); // 아머 피어싱
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addDamage(35L);            // 모탈 블로우
    }
}
