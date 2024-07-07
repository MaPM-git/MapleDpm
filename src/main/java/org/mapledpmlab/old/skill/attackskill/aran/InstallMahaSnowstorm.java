package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InstallMahaSnowstorm extends AttackSkill {
    public InstallMahaSnowstorm() {
        this.setName("인스톨 마하(눈보라)");
        this.setDamage(990.0 + 100);
        this.setAttackCount(5L);
        this.setCooldown(3.0);
    }
}
