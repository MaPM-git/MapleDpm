package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WrathOfEnlil extends AttackSkill {
    public WrathOfEnlil() {
        this.setName("래쓰 오브 엔릴");
        this.setAttackCount(10L);
        this.setDamage(515.0);
        this.setDelay(900L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
