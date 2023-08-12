package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class EviscerateDelay extends AttackSkill {
    public EviscerateDelay() {
        this.setName("절개");
        this.setDelayByAttackSpeed(930L);
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
