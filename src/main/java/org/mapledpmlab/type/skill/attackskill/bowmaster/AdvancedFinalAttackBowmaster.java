package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedFinalAttackBowmaster extends AttackSkill {
    public AdvancedFinalAttackBowmaster() {
        this.setName("어드밴스드 파이널 어택");
        this.setAttackCount(1L);
        this.setDamage(212.0 + 320);
        this.setProp(71L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
