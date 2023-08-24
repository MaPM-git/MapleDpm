package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.PassiveBossCritical;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.PhantomInstinct;
import org.mapledpmlab.type.union.DexUnion;

public class Kain extends Job {

    public Kain() {
        // 기본
        super();
        this.setName("카인");
        this.setConstant(1.3);          // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new PassiveBossCritical());
        this.addObject(new NormalFarm());
        this.addObject(new HybridLogic());
        this.addObject(new PhantomInstinct());
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
        this.addAtt(40L);               // 히트맨
        this.addCriticalP(35.0);

        // 2차
        this.addAtt(40L);               // 브레스 슈터 마스터리
        this.addMainStat(60L);          // 피지컬 트레이닝

        // 3차
        this.addFinalDamage(1.24);      // 내츄럴 본 인스팅트
        this.addAtt(40L);
        this.addCriticalP(20.0);
        this.addIgnoreDefenseList(10L);

        // 4차
        this.addAtt(31L);               // 그라인딩 II
        this.addFinalDamage(1.2);       // 도그마
        this.addCriticalDamage(21.0);
        this.addIgnoreDefenseList(31L);
        this.addFinalDamage(1.3);       // 브레스 슈터 엑스퍼트
        this.addAtt(31L);
        this.addCriticalDamage(20.0);
        this.addDamage(14L);            // 어댑트 투 데스
        this.addBossDamage(10L);
    }
}
