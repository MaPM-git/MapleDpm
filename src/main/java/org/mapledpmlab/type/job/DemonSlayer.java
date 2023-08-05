package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.ReuseFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.StrUnion;

public class DemonSlayer extends Job {

    public DemonSlayer() {
        // 기본
        super();
        this.setDescription("데몬슬레이어");
        this.setConstant(1.2);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new ReuseBossAbnormal());
        this.addObject(new ReuseFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Noblesse());
        this.addObject(new StrUnion());

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (326 + 201 + 72 + 249));
        this.setWeaponAttMagic((long) (326 + 201 + 72 + 249));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 보조
        this.addMainStat(10L);
        this.addSubStat(10L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addFinalDamage(1.1);

        // 1차
        this.addMainStat(20L);          // 데몬 액셀레이션

        // 2차
        this.addFinalDamage(1.1);       // 웨폰 마스터리
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);
        this.addAtt(50L);               // 아웃레이지
        this.addCriticalP(20.0);

        // 3차
        this.addFinalDamage(1.3);       // 컨센트레이션

        // 4차
        this.addIgnoreDefenseList(31L);  // 다크 바인드
        this.addDamage(36L);            // 메타모포시스
        this.addAtt(51L);               // 어드밴스드 웨폰 마스터리

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }
}
