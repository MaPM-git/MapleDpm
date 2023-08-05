package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.StrUnion;

public class Striker extends Job {

    public Striker() {
        // 기본
        super();
        this.setDescription("스트라이커");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
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

        // 2차
        this.addMainStat(20L);          // 너클 액셀레이션
        this.addFinalDamage(1.05);      // 너클 마스터리
        this.addMainStat(60L);          // 단련
        this.addCriticalP(10.0);
        this.addCriticalDamage(5.0);
        this.addAtt(20L);               // 뇌백

        // 3차
        this.addDamage(5L);             // 극갑
        this.addCriticalP(10.0);
        this.addAtt(30L);               // 뇌제
        this.addCriticalDamage(10.0);

        // 4차
        this.addAtt(31L);               // 너클 엑스퍼트
        this.addFinalDamage(1.15);
        this.addCriticalDamage(15.0);
        this.addCriticalP(10.0);        // 뇌신
        this.addCriticalDamage(15.0);

        // 5차
        this.addAtt(40L);               // 로디드 다이스
    }
}
