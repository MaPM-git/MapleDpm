package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BlackMark extends AttackSkill {
    public BlackMark() {
        this.setName("검은 징표");
        this.setDamage(400.0);
        this.setAttackCount(4L);
        this.setCooldown(4.0);
        this.setAddDamage(20L);
    }
}
