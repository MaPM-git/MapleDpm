package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonVeinJump extends AttackSkill {
    public DragonVeinJump() {
        this.setName("용맥으로 이동(점프)");
        this.setDelay(360L);
        this.setRelatedSkill(new EssenceSprinkle());
    }
}
