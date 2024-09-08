package org.mapledpmlab.type.skill.attackskill.archmageil;

public class LightningSphere extends ThunderAttack {
    public LightningSphere() {
        this.setName("라이트닝 스피어");
        this.setDamage(150.0 + 26);
        this.setAttackCount(15L);
        this.setDelay(1680L);
        this.setDotDuration(1680L);
        this.setInterval(120L);
        this.setLimitAttackCount(14L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new LightningSphereFinish());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
