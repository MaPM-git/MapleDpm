package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexSandStormBeforeDelay extends AttackSkill implements HexSkill {
    public HexSandStormBeforeDelay() {
        this.setName("헥스 : 샌드스톰(선딜)");
        this.setDelay(360L);
        this.setCooldown(360.0);
        this.setRelatedSkill(new HexSandStormKeydown());
    }
}
