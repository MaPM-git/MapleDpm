package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ChainLightningElectric extends ThunderAttack {
    public ChainLightningElectric() {
        this.setName("체인 라이트닝(전류 지대)");
        this.setAttackCount(2L);
        this.setDamage(140.0);
        this.setCooldown(7.0);
        this.setDotDuration(4000L);
        this.setInterval(540L);
        this.setLimitAttackCount(4L);
        this.setAddDamage(20L);             // 체인 라이트닝-리인포스
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
