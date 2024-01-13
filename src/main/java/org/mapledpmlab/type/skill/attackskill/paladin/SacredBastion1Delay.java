package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SacredBastion1Delay extends AttackSkill {
    public SacredBastion1Delay() {
        this.setName("세이크리드 바스티온");
        this.setDelay(4200L);
        this.setRelatedSkill(new SacredBastion2());
    }
}
