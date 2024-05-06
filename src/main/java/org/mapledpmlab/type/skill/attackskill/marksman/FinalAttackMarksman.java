package org.mapledpmlab.type.skill.attackskill.marksman;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackMarksman extends AttackSkill {
    public FinalAttackMarksman() {
        this.setName("파이널 어택");
        this.setAttackCount(1L);
        this.setDamage(150.0);
        this.setProp(40L);
        this.setFinalAttack(true);
        this.addFinalDamage(3.4);
        this.addIgnoreDefenseList(20L);
    }
}
