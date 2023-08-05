package org.mapledpmlab.type.skill.attackskill.archmageil;

public class LightningSpearDelay extends ThunderAttack {
    public LightningSpearDelay() {
        this.setDelayByAttackSpeed(960L);
        this.setRelatedSkill(new LightningSphereFinish());
    }
}
