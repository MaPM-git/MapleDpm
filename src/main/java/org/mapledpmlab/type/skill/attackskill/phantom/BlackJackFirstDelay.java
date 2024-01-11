package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackJackFirstDelay extends AttackSkill {
    public BlackJackFirstDelay() {
        this.setName("블랙잭(선딜)");
        this.setDelayByAttackSpeed(760L);
        this.setRelatedSkill(new BlackJack());
        this.setCooldown(15.0);
    }
}
