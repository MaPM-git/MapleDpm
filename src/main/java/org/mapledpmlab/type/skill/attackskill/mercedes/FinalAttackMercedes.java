package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackMercedes extends AttackSkill {
    public FinalAttackMercedes() {
        this.setName("파이널 어택");
        this.setAttackCount(2L);
        this.setDamage(345.0);
        this.setProp(76L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
