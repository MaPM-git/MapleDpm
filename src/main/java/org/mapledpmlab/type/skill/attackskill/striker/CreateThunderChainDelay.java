package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CreateThunderChainDelay extends AttackSkill {
    public CreateThunderChainDelay() {
        this.setName("창뇌연격");
        this.setDelay(240L * 11);
        this.setRelatedSkill(new CreateThunderChainFinal());
    }
}
