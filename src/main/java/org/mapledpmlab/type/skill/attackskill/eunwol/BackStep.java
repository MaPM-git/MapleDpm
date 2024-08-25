package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BackStep extends AttackSkill {
    public BackStep() {
        this.setName("후방 이동");
        this.setCooldown(1.0);
        this.setDelay(420L);
    }
}
