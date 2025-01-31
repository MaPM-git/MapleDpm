package org.mapledpmlab.type.skill.attackskill.windbreaker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VortexSphere extends AttackSkill {
    public VortexSphere() {
        this.setName("볼텍스 스피어");
        this.setAttackCount(6L);
        this.setCooldown(30.0);
        this.setDelayByAttackSpeed(960L);
        this.setDamage(960.0);
        this.setDotDuration(180L * 20);
        this.setInterval(180L);
        this.setLimitAttackCount(20L);
        this.addFinalDamage(1.6);       // 코어강화
        this.setApplyFinalAttack(true);
    }
}
