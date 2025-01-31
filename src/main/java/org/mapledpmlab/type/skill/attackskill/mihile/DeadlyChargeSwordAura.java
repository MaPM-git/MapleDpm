package org.mapledpmlab.type.skill.attackskill.mihile;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeadlyChargeSwordAura extends AttackSkill {
    public DeadlyChargeSwordAura() {
        this.setName("데들리 차지(검기)");
        this.setApplyFinalAttack(true);
        this.setAttackCount(8L);
        this.setDamage(515.0);
        this.setCooldown(35.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setDotDuration(3000L);
        this.setInterval(60L);
        this.setLimitAttackCount(4L);
    }
}
