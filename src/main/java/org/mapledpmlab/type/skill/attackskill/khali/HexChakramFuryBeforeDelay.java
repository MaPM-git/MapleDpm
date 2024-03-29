package org.mapledpmlab.type.skill.attackskill.khali;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HexChakramFuryBeforeDelay extends AttackSkill implements HexSkill {
    public HexChakramFuryBeforeDelay() {
        this.setName("헥스 : 차크람 퓨리(선딜)");
        this.setDelay(360L);
        this.setCooldown(12.0);
        this.setRelatedSkill(new HexChakramFury());
        this.setApplyReuse(true);
    }
}
