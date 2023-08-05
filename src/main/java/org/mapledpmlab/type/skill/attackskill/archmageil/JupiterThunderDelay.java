package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JupiterThunderDelay extends AttackSkill {
    public JupiterThunderDelay() {
        this.setDelayByAttackSpeed(720L);
        this.setCooldown(120.0);
    }
}
