package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.ReuseBossAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.ReuseFarm;
import org.mapledpmlab.type.link.NatureFriend;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.LukUnion;

public class Khali extends Job {

    public Khali() {
        // 기본
        super();
        this.setDescription("칼리");
        this.setConstant(1.30);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION_MAX);
        this.addObject(new ReuseBossAbnormal());
        this.addObject(new ReuseFarm());
        this.addObject(new NatureFriend());
        this.addObject(new PhantomInstinct());
        this.addObject(new LukUnion());
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
        this.addAtt(30L);               // 플레어

        // 2차
        this.addAtt(30L);               // 차크람 마스터리
        this.addCriticalP(35.0);        // 임펄스
        this.addCriticalDamage(20.0);
        this.addMainStat(60L);          // 피지컬 트레이닝

        // 3차
        this.addFinalDamage(1.25);      // 인투이션
        this.addIgnoreDefenseList(20L);
        this.addAtt(30L);

        // 4차
        this.addAtt(31L);               // 차크람 엑스퍼트
        this.addCriticalDamage(8.0);
        this.addFinalDamage(1.31);      // 리뎀션
        this.addIgnoreDefenseList(21L);
        this.addBossDamage(31L);

        // 5차
        this.addAtt(30L);               // 레디 투 다이
    }
}
