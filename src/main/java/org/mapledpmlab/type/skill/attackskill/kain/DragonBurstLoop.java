package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonBurstLoop extends AttackSkill {
    public DragonBurstLoop() {
        this.setName("[발현] 드래곤 버스트");
        this.setDamage(970.0);
        this.setAttackCount(12L);
        this.setDelay(2700L);
        this.setDotDuration(2700L);
        this.setInterval(180L);
        this.setLimitAttackCount(15L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new DragonBurstAfterDelay());
    }
}
