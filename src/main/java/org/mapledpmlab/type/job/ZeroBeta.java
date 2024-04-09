package org.mapledpmlab.type.job;

public class ZeroBeta extends Zero {

    public ZeroBeta() {
        // 기본
        super();
        this.setName("제로 - 베타");
        this.setConstant(1.49);         // 무기상수(베타)
        this.setMastery(1.90 / 2);      // 숙련도

        // 무기
        this.addMainStat((long) (150 + 32 + 145));
        this.addSubStat((long) (150 + 145));
        this.addAtt((long) (342 + 151 + 72 + 255));
        this.setWeaponAttMagic((long) (342 + 151 + 72 + 255));
        this.addBossDamage((long) (30 + 10));
        this.addIgnoreDefenseList(20L);
        this.addBossDamage(70L);
        this.addAttP(9L);
        this.addAttP(21L);
        this.addAttP(3L);

        // 베타
        this.addCriticalP(30.0);        // 대검 마스터리
        this.addDamage(50L);
        this.addBossDamage(30L);
        this.addAtt(80L);
        this.addFinalDamage(1.23);

        // 5차
        this.addMainStat(30L);          // 바디 오브 스틸
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addIgnoreDefenseList(50L); // 아머 스플릿 5중첩
        this.addDamage(5L);             // 래피드 타임 5중첩
    }
}
