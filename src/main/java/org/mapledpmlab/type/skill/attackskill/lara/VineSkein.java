package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class VineSkein extends AttackSkill {
    public VineSkein() {
        this.setName("넝쿨 타래");
        this.setDamage(700.0);
        this.setAttackCount(6L);
        this.setCooldown(180.0);
        this.setDelayByAttackSpeed(840L);
        this.addFinalDamage(1.08);      // 오버로드 마나
    }
}
