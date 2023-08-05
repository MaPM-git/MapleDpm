package org.mapledpmlab.type.skill.attackskill.archmageil;

public class FrozenLightningDot extends ThunderAttack {
    public FrozenLightningDot() {
        this.setName("프로즌 라이트닝(추가타)");
        this.setAttackCount(6L);
        this.setDamage(2100.0);
        this.setCooldown(360.0);
        this.setDotDuration(30000L);
        this.setInterval(1000L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setAddDamage(60L);         // 프로스트 이펙트
    }
}
