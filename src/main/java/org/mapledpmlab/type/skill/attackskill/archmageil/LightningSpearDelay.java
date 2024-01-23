package org.mapledpmlab.type.skill.attackskill.archmageil;

public class LightningSpearDelay extends ThunderAttack {
    public LightningSpearDelay() {
        this.setName("라이트닝 스피어");
        this.setDelay(840L);
        this.setRelatedSkill(new LightningSphere());
    }
}
