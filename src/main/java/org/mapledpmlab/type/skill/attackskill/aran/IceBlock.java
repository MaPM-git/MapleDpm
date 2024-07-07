package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IceBlock extends AttackSkill {
    public IceBlock() {
        this.setName("얼음 덩어리");
        this.setDamage(1320.0);
        this.setAttackCount(4L);
        this.setCooldown(0.4);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
