package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TempestOfCardBeforeDelay extends AttackSkill {
    public TempestOfCardBeforeDelay() {
        this.setName("템페스트 오브 카드(선딜)");
        this.setDelay(480L);
        this.setCooldown(18.0 * 0.8);
        this.setApplyReuse(true);
        this.setRelatedSkill(new TempestOfCard());
    }
}
