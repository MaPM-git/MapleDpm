package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackJackBeforeDelay extends AttackSkill {
    public BlackJackBeforeDelay() {
        this.setName("블랙잭(선딜)");
        this.setDelay(760L);
        this.setRelatedSkill(new BlackJack());
        this.setCooldown(15.0);
    }
}
