package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackViper extends AttackSkill {
    public FinalAttackViper() {
        this.setName("파이널 어택(바이퍼)");
        this.setAttackCount(2L);
        this.setDamage(167.0);
        this.setProp(100L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
