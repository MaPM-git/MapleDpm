package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class NoireCarte extends AttackSkill {
    public NoireCarte() {
        this.setName("느와르 카르트");
        this.setAttackCount(1L);
        this.setDamage(274.0);
        this.setProp(100L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
