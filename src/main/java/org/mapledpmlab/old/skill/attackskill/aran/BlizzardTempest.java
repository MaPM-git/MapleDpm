package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlizzardTempest extends AttackSkill {
    public BlizzardTempest() {
        this.setName("블리자드 템페스트");
        this.setDamage(1760.0 + 100);
        this.setAttackCount(8L);
        this.setDelay(990L);
        this.setCooldown(180.0);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
