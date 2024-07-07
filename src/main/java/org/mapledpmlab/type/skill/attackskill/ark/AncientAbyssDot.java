package org.mapledpmlab.type.skill.attackskill.ark;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AncientAbyssDot extends AttackSkill {
    public AncientAbyssDot() {
        this.setName("가장 오래된 심연(심연의 손아귀)");
        this.setAttackCount(15L);
        this.setCooldown(360.0);
        this.setDamage(1730.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setDotDuration(30000L);
        this.setInterval(1500L);
        this.setRelatedSkill(new AncientAbyss());
    }
}
