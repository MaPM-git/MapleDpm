package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonBlaze extends AttackSkill {
    public DragonBlaze() {
        this.setName("드래곤 블레이즈");
        this.setDamage(825.0);
        this.setAttackCount(6L);
        this.setDelay(900L);
        this.setCooldown(120.0);
        this.setDotDuration(20000L);
        this.setInterval(240L);
        this.addFinalDamage(1.6);       // 코어 강화
        this.setApplyServerLag(true);
    }
}
