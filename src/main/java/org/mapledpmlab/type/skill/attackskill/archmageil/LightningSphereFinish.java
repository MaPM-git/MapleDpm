package org.mapledpmlab.type.skill.attackskill.archmageil;

public class LightningSphereFinish extends ThunderAttack {
    public LightningSphereFinish() {
        this.setName("라이트닝 스피어(막타)");
        this.setDamage(780.0 + 133);
        this.setAttackCount(15L);
        this.setDelay(960L);
        this.addFinalDamage(2.2);           // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
