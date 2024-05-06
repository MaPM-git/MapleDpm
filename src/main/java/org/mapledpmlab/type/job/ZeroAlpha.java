package org.mapledpmlab.type.job;

public class ZeroAlpha extends Zero {

    public ZeroAlpha() {
        // 기본
        super();
        this.setName("제로 - 알파");
        this.setConstant(1.34);         // 무기상수(알파)
        this.setMastery(1.90 / 2);      // 숙련도

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (337 + 151 + 72 + 252));
        this.setWeaponAttMagic((long) (337 + 151 + 72 + 252));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);

        // 알파
        this.addAtt(40L);               // 태도 마스터리
        this.addFinalDamage(1.23);
        this.addIgnoreDefenseList(30L);
        this.addCriticalP(30.0);        // 리인포스 바디
        this.addCriticalDamage(50.0);   // 디바인 리어

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addDamage(5L);             // 래피드 타임 5중첩
    }
}
