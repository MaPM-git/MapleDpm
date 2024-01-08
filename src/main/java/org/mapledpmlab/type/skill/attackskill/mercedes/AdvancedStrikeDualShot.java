package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AdvancedStrikeDualShot extends AttackSkill {
    public AdvancedStrikeDualShot() {
        this.setName("어드밴스드 스트라이크 듀얼샷");
        this.setAttackCount(4L);
        this.setDamage(456.0);
        this.setDelay(630L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
