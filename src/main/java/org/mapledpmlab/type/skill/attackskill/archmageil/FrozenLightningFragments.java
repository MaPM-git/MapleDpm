package org.mapledpmlab.type.skill.attackskill.archmageil;

public class FrozenLightningFragments extends ThunderAttack {
    public FrozenLightningFragments() {
        this.setName("프로즌 라이트닝(얼음파편)");
        this.setAttackCount(3L);
        this.setDamage(1500.0);
        this.setCooldown(360.0);
        this.setDotDuration(800L);
        this.setLimitAttackCount(22L);
        this.setInterval(1L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new FrozenLightningDot());
        this.setAddDamage(60L);         // 프로스트 이펙트
    }
}
