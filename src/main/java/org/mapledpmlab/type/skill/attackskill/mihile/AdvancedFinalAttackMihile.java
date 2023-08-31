package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedFinalAttackMihile extends AttackSkill {
    public AdvancedFinalAttackMihile() {
        this.setName("어드밴스드 파이널 어택");
        this.setAttackCount(4L);
        this.setDamage(96.0);
        this.setProp(76L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
