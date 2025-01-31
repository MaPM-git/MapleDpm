package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonBurstBeforeDelay extends AttackSkill {
    public DragonBurstBeforeDelay() {
        this.setName("[발현] 드래곤 버스트(선딜)");
        this.setDelay(300L);
        this.setCooldown(90.0);
        this.setRelatedSkill(new DragonBurstLoop());
    }
}
