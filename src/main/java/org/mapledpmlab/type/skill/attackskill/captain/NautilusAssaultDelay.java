package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NautilusAssaultDelay extends AttackSkill {
    public NautilusAssaultDelay() {
        this.setName("노틸러스 어썰트");
        this.setDelay(900L);
        this.setCooldown(180.0);
    }
}
