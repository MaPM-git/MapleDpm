package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossAbnormalBuff;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.BuffFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.link.Noblesse;
import org.mapledpmlab.type.union.LukUnion;

public class NightLord extends Job {

    public NightLord() {
        // 기본
        super();
        this.setName("나이트로드");
        this.setConstant(1.75);         // 무기상수
        this.setMastery(1.86 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossAbnormalBuff());
        this.addObject(new BuffFarm());
        this.addObject(new HybridLogic());
        this.addObject(new Noblesse());
        this.addObject(new LukUnion());

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
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 1차
        this.addMainStat(20L);          // 님블 바디

        // 2차
        this.addMainStat(20L);          // 자벨린 액셀레이션
        this.addCriticalP(50.0);        // 크리티컬 스로우
        this.addCriticalDamage(5.0);
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(10L);               // 스피릿 자벨린
        this.addFinalDamage(1.25);      // 숙련된 표창술
        this.addCriticalP(20.0);
        this.addCriticalDamage(10.0);   // 아드레날린

        // 4차
        this.addBossDamage(11L);        // 퍼지 에어리어
        this.addFinalDamage(1.08);      // 다크 세레니티
        this.addIgnoreDefenseList(31L);
        this.addAtt(31L);               // 자벨린 엑스퍼트
        this.addCriticalDamage(10.0);

        // 하이퍼
        this.addAtt(50L);               // 블리딩 톡신

        // 5차
        this.addAtt(30L);               // 레디 투 다이
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addIgnoreDefenseList(31 + 10L); // 퍼지 에어리어
    }
}
