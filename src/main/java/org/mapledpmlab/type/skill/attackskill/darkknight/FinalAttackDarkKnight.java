package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackDarkKnight extends AttackSkill {
    public FinalAttackDarkKnight() {
        this.setName("파이널 어택");
        this.setAttackCount(2L);
        this.setDamage(80.0);
        this.setProp(40L);
        this.setFinalAttack(true);
        this.addFinalDamage(3.4);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
