package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BladeStormBeforeDelay extends AttackSkill {
    public BladeStormBeforeDelay() {
        this.setName("블레이드 스톰(선딜)");
        this.setDelay(120L);
        this.setRelatedSkill(new BladeStormKeydown());
    }
}
