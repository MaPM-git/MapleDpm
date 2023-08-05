package org.mapledpmlab.type.skill.attackskill.archmageil;

public class FrozenLightningDelay extends ThunderAttack {
    public FrozenLightningDelay() {
        this.setDelay(4020L);
        this.setCooldown(360.0);
        this.setRelatedSkill(new FrozenLightningFragments());
    }
}
