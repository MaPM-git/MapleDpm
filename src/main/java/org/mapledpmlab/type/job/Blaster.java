package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalAttack;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

public class Blaster extends Job {

    public Blaster() {
        // 기본
        super();
        this.setDescription("블래스터");
        this.setConstant(1.7);          // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossAbnormalAttack());
        this.addObject(new NormalFarm());
        this.addObject(new HybridLogic());
        this.addObject(new StrUnion());

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

        // 2차
        this.addCriticalP(30.0);        // 건틀렛 마스터리
        this.addAtt(20L);
        this.addFinalDamage(1.05);
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);
        this.addDamage(20L);            // 차지 마스터리

        // 3차
        this.addAttP(15L);              // 콤비네이션 트레이닝

        // 4차
        this.addCriticalDamage(21.0);   // 건틀렛 엑스퍼트
        this.addBossDamage(21L);
        this.addIgnoreDefenseList(38L);  // 어드밴스드 차지 마스터리
        this.addAtt(42L);               // 콤비네이션 트레이닝 II
        this.addCriticalP(30.0);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }
}
