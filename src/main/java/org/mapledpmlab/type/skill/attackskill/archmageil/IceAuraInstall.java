package org.mapledpmlab.type.skill.attackskill.archmageil;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IceAuraInstall extends AttackSkill {
    public IceAuraInstall() {
        this.setName("아이스 오라(소용돌이)");
        this.setDotDuration(30 * 1000L);
        this.setInterval(1200L);
        this.setCooldown(60.0);
    }
}
