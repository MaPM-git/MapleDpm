package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PiercingCycloneFirstDelay extends AttackSkill {
    public PiercingCycloneFirstDelay() {
        this.setName("피어스 사이클론(선딜)");
        this.setDelay(90L);
        this.setRelatedSkill(new PiercingCycloneKeydown());
    }
}
