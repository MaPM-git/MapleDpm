package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.StrUnion;

public class Ark extends Job {

    public Ark() {
        // 기본
        super();
        this.setDescription("아크");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.COOLDOWN_REDUCTION2);
        this.addObject(new BossCriticalAbnormal());
        this.addObject(new NormalFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Noblesse());
        this.addObject(new StrUnion());
        this.addPerXMainStat(20L);

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
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addAtt(20L);               // 미스틱 아츠 마스터리

        // 2차
        this.addAtt(20L);               // 너클 마스터리
        this.addFinalDamage(1.05);
        this.addMainStat(60L);          // 피지컬 트레이닝

        // 3차
        this.addFinalDamage(1.1);       // 융합 진행
        this.addCriticalP(20.0);

        // 4차
        this.addAtt(31L);               // 너클 엑스퍼트
        this.addCriticalDamage(31.0);
        this.addAtt(41L);               // 융합 완성
        this.addCriticalP(11.0);
        this.addIgnoreDefenseList(31L);
        this.addBossDamage(31L);
        this.addFinalDamage(1.21);      // 전투 광란

        // 5차
        this.addAtt(40L);               // 로디드 다이스
    }
}
