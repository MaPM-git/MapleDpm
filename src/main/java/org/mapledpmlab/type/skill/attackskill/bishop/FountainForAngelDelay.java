package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FountainForAngelDelay extends AttackSkill {
    public FountainForAngelDelay() {
        this.setDelay(960L);
        this.setCooldown(60.0);             // 갱신용
    }
}
