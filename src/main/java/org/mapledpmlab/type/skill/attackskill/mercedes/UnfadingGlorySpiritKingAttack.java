package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnfadingGlorySpiritKingAttack extends AttackSkill {
    public UnfadingGlorySpiritKingAttack() {
        this.setName("언페이딩 글로리(정령왕)");
        this.setAttackCount(15L);
        this.setDamage(2200.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setCooldown(3.0);
    }
}
