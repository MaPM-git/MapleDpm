package org.mapledpmlab.type.skill.attackskill.nightlord;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DarkFlareDelay extends AttackSkill {
    public DarkFlareDelay() {
        this.setName("다크 플레어");
        this.setDelayByAttackSpeed(600L);
        this.setCooldown(60.0);
    }
}
