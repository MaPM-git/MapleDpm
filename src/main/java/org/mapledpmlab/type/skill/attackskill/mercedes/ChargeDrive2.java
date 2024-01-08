package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChargeDrive2 extends AttackSkill {
    public ChargeDrive2() {
        this.setName("차지 드라이브(띄움)");
        this.setAttackCount(2L);
        this.setDamage(250.0 + 100 + 197);
        this.setDelay(540L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
