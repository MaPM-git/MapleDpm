package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnfadingGlorySpiritKingAttack extends AttackSkill {
    public UnfadingGlorySpiritKingAttack() {
        this.setName("언페이딩 글로리(정령왕)");
        this.setAttackCount(10L);
        this.setDamage(5400.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setCooldown(3.3);
    }
}
