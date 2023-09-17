package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThunderBreakTheSeaDelay extends AttackSkill {
    public ThunderBreakTheSeaDelay() {
        this.setName("뇌명벽해파");
        this.setDelay(400L * 11);
        this.setRelatedSkill(new ThunderBreakTheSeaFinal());
    }
}
