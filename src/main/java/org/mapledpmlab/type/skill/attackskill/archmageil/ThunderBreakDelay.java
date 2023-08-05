package org.mapledpmlab.type.skill.attackskill.archmageil;

public class ThunderBreakDelay extends ThunderAttack {
    public ThunderBreakDelay() {
        this.setDelayByAttackSpeed(900L);
        this.setCooldown(40.0);
    }
}
