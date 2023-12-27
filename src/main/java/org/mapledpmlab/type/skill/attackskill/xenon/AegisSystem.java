package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AegisSystem extends AttackSkill {
    public AegisSystem() {
        this.setName("이지스 시스템");
        this.setAttackCount(3L);
        this.setDamage(120.0 + 20);
        this.setDotDuration(720000L);
        this.setInterval(1500L);
    }
}
