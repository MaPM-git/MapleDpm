package org.mapledpmlab.type.JobContinuous;

public class ZeroAlphaContinuous extends ZeroContinuous {

    public ZeroAlphaContinuous() {
        // 기본
        super();
        this.setName("제로 - 알파(컨티)");
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
    }

    @Override
    public void Doping() {
        super.Doping();
        this.addIgnoreDefenseList(50L); // 아머 스플릿 5중첩
        this.addDamage(5L);             // 래피드 타임 5중첩
        this.addAtt(45L * 3);           // 인피니트 레조넌스 3중첩
    }
}
