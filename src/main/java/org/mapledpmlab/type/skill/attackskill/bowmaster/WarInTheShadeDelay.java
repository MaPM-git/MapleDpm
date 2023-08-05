package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WarInTheShadeDelay extends AttackSkill {
    public WarInTheShadeDelay() {
        this.setName("어센던트 셰이드");
        this.setDelay(4560L);
        this.setRelatedSkill(new WarInTheShadePerfusion());
    }
}
