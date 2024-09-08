package org.mapledpmlab.type.skill.attackskill.archmageil;

public class LightningSphereDelay extends ThunderAttack {
    public LightningSphereDelay() {
        this.setName("라이트닝 스피어");
        this.setDelay(780L);
        this.setRelatedSkill(new LightningSphere());
    }
}
