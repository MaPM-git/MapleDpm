package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NoireCarteReverse extends AttackSkill {
    public NoireCarteReverse() {
        this.setName("느와르 카르트(반전)");
        this.setAttackCount(1L);
        this.setDamage(910.0);
        this.setCooldown(5.0);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
