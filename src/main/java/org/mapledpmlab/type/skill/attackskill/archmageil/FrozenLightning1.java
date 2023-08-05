package org.mapledpmlab.type.skill.attackskill.archmageil;

public class FrozenLightning1 extends ThunderAttack {
    public FrozenLightning1() {
        this.setName("프로즌 라이트닝(참격1)");
        this.setAttackCount(6L);
        this.setDamage(1920.0);
        this.setCooldown(360.0);
        this.setDotDuration(3000L);
        this.setLimitAttackCount(10L);
        this.setInterval(300L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new FrozenLightning2());
        this.setAddDamage(60L);         // 프로스트 이펙트
    }
}
