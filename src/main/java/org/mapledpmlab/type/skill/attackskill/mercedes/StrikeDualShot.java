package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StrikeDualShot extends AttackSkill {
    public StrikeDualShot() {
        this.setName("스트라이크 듀얼샷");
        this.setAttackCount(4L);
        this.setDamage(890.0);
        this.setDelayByAttackSpeed(630L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
