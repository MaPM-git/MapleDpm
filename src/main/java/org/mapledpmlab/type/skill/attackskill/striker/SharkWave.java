package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SharkWave extends AttackSkill {
    public SharkWave() {
        this.setName("교아탄");
        this.setAttackCount(7L * 2);
        this.setDamage(2200.0 + 200);
        this.setCooldown(8.0);
        this.setDelayByAttackSpeed(360L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
