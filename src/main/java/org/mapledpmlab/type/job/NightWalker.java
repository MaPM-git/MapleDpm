package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

public class NightWalker extends Job {

    public NightWalker() {
        // 기본
        super();
        this.setDescription("나이트워커");
        this.setConstant(1.75);         // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossCriticalAbnormal());
        this.addObject(new NormalFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Noblesse());
        this.addObject(new LukUnion());
        this.addPerXMainStat(20L);

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (172 + 106 + 72 + 195));
        this.setWeaponAttMagic((long) (172 + 106 + 72 + 195));
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
        this.addMagic(3L);
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
        this.addDamage(30L);            // 스로잉 마스터리
        this.addMainStat(20L);          // 스로잉 액셀레이션
        this.addCriticalP(35.0);        // 크리티컬 스로우
        this.addCriticalDamage(10.0);
        this.addMainStat(60L);          // 피지컬 트레이닝

        // 3차
        this.addFinalDamage(1.2);       // 쉐도우 모멘텀
        this.addAtt(10L);               // 스피릿 스로잉
        this.addCriticalDamage(10.0);   // 아드레날린

        // 4차
        this.addAtt(31L);               // 스로잉 엑스퍼트
        this.addCriticalDamage(11.0);
        this.addAtt(31L);               // 다크니스 블레싱
        this.addIgnoreDefenseList(16L);
        this.addFinalDamage(1.08);

        // 5차
        this.addAtt(30L);               // 레디 투 다이
    }
}
