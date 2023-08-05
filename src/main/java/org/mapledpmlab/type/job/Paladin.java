package org.mapledpmlab.type.job;

import org.mapledpmlab.type.ability.BossCriticalAbnormal;
import org.mapledpmlab.type.etc.JobType;
import org.mapledpmlab.type.farm.NormalFarm;
import org.mapledpmlab.type.link.HybridLogic;
import org.mapledpmlab.type.union.StrUnion;

public class Paladin extends Job {

    public Paladin() {
        // 기본
        super();
        this.setDescription("팔라딘");
        this.setConstant(1.34);         // 무기상수
        this.setMastery(1.91 / 2);      // 숙련도
        this.setJobType(JobType.ETC);
        this.addObject(new BossCriticalAbnormal());
        this.addObject(new NormalFarm());
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
        this.addAtt(3L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);

        // 2차
        this.addMainStat(20L);          // 웨폰 액셀레이션
        this.addMainStat(30L);          // 피지컬 트레이닝
        this.addSubStat(30L);

        // 3차
        this.addAtt(20L);               // 파라쇼크 가드
        this.addAtt(10L);               // 실드 마스터리

        // 4차
        this.addFinalDamage(1.21);      // 디바인 블레싱
        this.addCriticalP(42.0);        // 팔라딘 엑스퍼트
        this.addCriticalDamage(20.0);
        this.addIgnoreDefenseList(31L);
        this.addFinalDamage(1.42);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }

    @Override
    public void Doping() {
        super.Doping();

        this.addAtt(60L);               // 어드밴스드 홀리 차지
        this.addDamage(25L);
        this.addAtt(20L);               // 블레싱 아머
        this.addIgnoreDefenseList(20L); // 디바인 저지먼트
    }
}
