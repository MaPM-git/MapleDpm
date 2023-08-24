package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalBuff;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.BuffFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

public class Kaiser extends Job {

    public Kaiser() {
        // 기본
        super();
        this.setName("카이저");
        this.setConstant(1.34);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);
        this.addObject(new BossAbnormalBuff());
        this.addObject(new BuffFarm());
        this.addObject(new HybridLogic());
        this.addObject(new StrUnion());
        this.addPerXMainStat(20L);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (340 + 210 + 72 + 253));
        this.setWeaponAttMagic((long) (340 + 210 + 72 + 253));
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
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 0차
        this.addAtt(5L);                // 리셔플스위치 : 공격모드
        this.addCriticalP(3.0);
        this.addBossDamage(3L);

        // 2차
        this.addAtt(20L);               // 블레이즈 업
        this.addMainStat(20L);          // 이너 블레이즈
        this.addAtt(10L);               // 공격모드 1차 강화
        this.addCriticalP(2.0);
        this.addBossDamage(5L);

        // 3차
        this.addAttP(30L);              // 카탈라이즈
        this.addCriticalP(20.0);
        this.addFinalDamage(1.32);
        this.addMainStat(30L);          // 어드밴스드 이너 블레이즈
        this.addAtt(15L);               // 공격모드 2차 강화
        this.addCriticalP(5.0);
        this.addBossDamage(5L);

        // 4차
        this.addAtt(22L);               // 어드밴스드 윌 오브 소드
        this.addIgnoreDefenseList(41L);  // 언플리칭 커리지
        this.addAtt(31L);               // 어드밴스드 소드 마스터리
        this.addCriticalP(20.0);
        this.addCriticalDamage(15.0);
        this.addAtt(15L);               // 공격모드 3차 강화
        this.addCriticalP(10.0);
        this.addBossDamage(5L);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }
}
