package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DeadEye extends AttackSkill {
    public DeadEye() {
        this.setName("데드 아이");
        this.setDamage(1022.0 * 3);
        this.setDelayByAttackSpeed(600L);
        this.setAttackCount(15L);
        this.setCooldown(30.0);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
    }
}
