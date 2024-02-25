package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class RiftBreak extends AttackSkill {
    public RiftBreak() {
        this.setName("리프트 브레이크");
        this.setAttackCount(7L);
        this.setDamage(880.0);
        this.setDelayByAttackSpeed(990L);
        this.setCooldown(30.0);
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(270L);
        this.getMultiAttackInfo().add(1230L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
