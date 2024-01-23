package org.mapledpmlab.type.skill.attackskill.archmageil;

public class LightningSphere extends ThunderAttack {
    public LightningSphere() {
        this.setName("라이트닝 스피어");
        this.setDamage(150.0);
        this.setAttackCount(15L);
        this.setDelay(1680L + 1080);
        this.setDotDuration(1680L);
        this.setInterval(120L);
        this.setLimitAttackCount(14L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new LightningSphereFinish());
        this.setApplyFinalAttack(true);
        this.setAddDamage(60L);             // 프로스트 이펙트
    }
}
