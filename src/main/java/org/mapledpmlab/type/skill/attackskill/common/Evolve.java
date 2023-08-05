package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.common.EvolveBuff;

public class Evolve extends AttackSkill {
    public Evolve() {
        this.setName("이볼브");
        this.setAttackCount(7L);
        this.setDamage(900.0);
        this.setCooldown(106.0);
        this.setDotDuration(40000L);
        this.setInterval(3330L);
        this.setRelatedSkill(new EvolveBuff());
    }
}
