package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnfadingGlorySpiritKingAttackReinforce extends AttackSkill {
    public UnfadingGlorySpiritKingAttackReinforce() {
        this.setName("언페이딩 글로리(정령왕, 강화)");
        this.setAttackCount(15L);
        this.setDamage(1440.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setCooldown(2.0);
        this.getMultiAttackInfo().add(540L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
