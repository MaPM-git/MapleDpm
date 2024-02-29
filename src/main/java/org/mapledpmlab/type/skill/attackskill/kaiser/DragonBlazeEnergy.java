package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonBlazeEnergy extends AttackSkill {
    public DragonBlazeEnergy() {
        this.setName("드래곤 블레이즈(불의 기운)");
        this.setDamage(990.0);
        this.setAttackCount(6L);
        this.setCooldown(3.6);
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
