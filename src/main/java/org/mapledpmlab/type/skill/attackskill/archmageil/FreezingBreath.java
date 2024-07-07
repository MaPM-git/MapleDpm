package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FreezingBreath extends AttackSkill {
    public FreezingBreath() {
        this.setName("프리징 브레스");
        this.setDamage(80.0);
        this.setAttackCount(4L);
        this.setCooldown(180.0);
        this.setDelayByAttackSpeed(960L);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
