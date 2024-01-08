package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnfadingGlorySpiritKingAttackReinforce extends AttackSkill {
    public UnfadingGlorySpiritKingAttackReinforce() {
        this.setName("언페이딩 글로리(정령왕, 강화)");
        this.setAttackCount(12L);
        this.setDamage(7200.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setCooldown(3.3);
    }
}
