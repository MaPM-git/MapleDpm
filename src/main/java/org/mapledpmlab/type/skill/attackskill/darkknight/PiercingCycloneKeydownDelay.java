package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PiercingCycloneKeydownDelay extends AttackSkill {
    public PiercingCycloneKeydownDelay() {
        this.setName("피어스 사이클론(선딜)");
        this.setDelay(140L * 26);
        this.setRelatedSkill(new PiercingCycloneEndDelay());
    }
}
