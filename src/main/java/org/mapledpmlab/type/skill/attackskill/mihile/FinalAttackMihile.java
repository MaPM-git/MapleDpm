package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackMihile extends AttackSkill {
    public FinalAttackMihile() {
        this.setName("파이널 어택");
        this.setAttackCount(4L);
        this.setDamage(222.0);
        this.setProp(76L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
