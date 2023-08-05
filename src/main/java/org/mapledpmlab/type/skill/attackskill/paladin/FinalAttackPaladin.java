package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackPaladin extends AttackSkill {
    public FinalAttackPaladin() {
        this.setName("파이널 어택");
        this.setAttackCount(2L);
        this.setDamage(80.0);
        this.setProp(40L);
        this.setFinalAttack(true);
        this.addFinalDamage(4.0);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
