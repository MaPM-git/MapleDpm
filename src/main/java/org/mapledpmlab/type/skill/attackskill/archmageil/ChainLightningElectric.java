package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ChainLightningElectric extends ThunderAttack {
    public ChainLightningElectric() {
        this.setName("체인 라이트닝(전류 지대)");
        this.setAttackCount(2L);
        this.setDamage(140.0);
        this.setDotDuration(4000L);
        this.setInterval(250L);             // 4중첩
        this.setAddDamage(20L);             // 체인 라이트닝-리인포스
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(60L);             // 프로스트 이펙트
    }
}
