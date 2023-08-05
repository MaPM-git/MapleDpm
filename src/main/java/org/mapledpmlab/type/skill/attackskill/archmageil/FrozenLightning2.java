package org.mapledpmlab.type.skill.attackskill.archmageil;

public class FrozenLightning2 extends ThunderAttack {
    public FrozenLightning2() {
        this.setName("프로즌 라이트닝(참격2)");
        this.setAttackCount(9L);
        this.setDamage(4500.0);
        this.setCooldown(360.0);
        this.setDotDuration(1020L);
        this.setLimitAttackCount(4L);
        this.setInterval(254L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new FrozenLightningDelay());
        this.setAddDamage(60L);         // 프로스트 이펙트
    }
}
