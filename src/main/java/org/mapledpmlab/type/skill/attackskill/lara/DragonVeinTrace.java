package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DragonVeinTrace extends AttackSkill {
    public DragonVeinTrace() {
        this.setName("용맥의 자취");
        this.setDamage(500.0 + 59);
        this.setAttackCount(2L);
        this.setCooldown(1.0);
        this.setDelay(120L);
        this.setApplyCooldownReduction(false);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
