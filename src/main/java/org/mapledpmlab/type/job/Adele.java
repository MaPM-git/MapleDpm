package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.ReuseFarm;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.StrUnion;

public class Adele extends Job {

    public Adele() {
        // 기본
        super();
        this.setName("아델");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);
        this.addObject(new ReuseBossAbnormal());
        this.addObject(new ReuseFarm());
        this.addObject(new PhantomInstinct());
        this.addObject(new Noblesse());
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
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 0차
        this.addCriticalDamage(10.0);   // 페이스
        this.addAttP(10L);
        this.addAtt((long) (340 * 0.15));

        // 1차
        this.addAtt(30L);               // 루디먼트

        // 2차
        this.addAtt(30L);               // 마스터리
        this.addMainStat(60L);          // 트레인

        // 3차
        this.addAtt(30L);               // 어센트
        this.addFinalDamage(1.15);
        this.addCriticalP(20.0);

        // 4차
        this.addAtt(31L);               // 엑스퍼트
        this.addFinalDamage(1.31);      // 데몰리션
        this.addIgnoreDefenseList(21L);
        this.addAtt(31L);               // 어테인
        this.addBossDamage(11L);
        this.addCriticalP(21.0);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }
}
