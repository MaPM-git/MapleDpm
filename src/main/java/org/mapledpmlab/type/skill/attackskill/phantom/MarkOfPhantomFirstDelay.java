package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MarkOfPhantomFirstDelay extends AttackSkill {
    public MarkOfPhantomFirstDelay() {
        this.setName("마크 오브 팬텀(선딜)");
        this.setDelay(900L);
        this.setRelatedSkill(new MarkOfPhantom());
        this.setCooldown(30.0);
    }
}
