package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RiftBreak extends AttackSkill {
    public RiftBreak() {
        this.setName("리프트 브레이크");
        this.setAttackCount(7L);
        this.setDamage(880.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
