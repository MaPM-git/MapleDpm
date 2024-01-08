package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RollingMoonsault extends AttackSkill {
    public RollingMoonsault() {
        this.setName("롤링 문썰트");
        this.setAttackCount(6L);
        this.setDamage(363.0);
        this.setDelayByAttackSpeed(840L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
