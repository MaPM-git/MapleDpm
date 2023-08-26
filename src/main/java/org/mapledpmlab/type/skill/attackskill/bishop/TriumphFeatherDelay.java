package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TriumphFeatherDelay extends AttackSkill {
    public TriumphFeatherDelay() {
        this.setName("트라이엄프 페더");
        this.setDelay(900L);
        this.setCooldown(60.0);             // 갱신용
    }
}
