package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AsuraBeforeDelay extends AttackSkill {
    public AsuraBeforeDelay() {
        this.setName("아수라(선딜)");
        this.setDelay(900L);
        this.setRelatedSkill(new Asura());
    }
}
