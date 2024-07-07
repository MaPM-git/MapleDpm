package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedFinalAttackAran extends AttackSkill {
    public AdvancedFinalAttackAran() {
        this.setName("어드밴스드 파이널 어택");
        this.setAttackCount(3L);
        this.setDamage(183.0);
        this.setProp(61L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
