package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HiddenBlade extends AttackSkill {
    public HiddenBlade() {
        this.setName("히든 블레이드");
        this.setAttackCount(2L);
        this.setDamage(480.0);
        this.setProp(100L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
