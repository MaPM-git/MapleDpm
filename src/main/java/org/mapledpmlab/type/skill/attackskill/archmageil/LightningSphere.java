package org.mapledpmlab.type.skill.attackskill.archmageil;

public class LightningSphere extends ThunderAttack {
    public LightningSphere() {
        this.setName("라이트닝 스피어");
        this.setDamage(150.0);
        this.setAttackCount(15L);
        this.setDotDuration(3600L);
        this.setInterval(257L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new LightningSpearDelay());
        this.setApplyFinalAttack(true);
        this.setAddDamage(60L);             // 프로스트 이펙트
    }
}
