package org.mapledpmlab.type.skill.attackskill.lara;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FreeDragonVein extends AttackSkill {
    public FreeDragonVein() {
        this.setName("자유로운 용맥");
        this.setCooldown(1.5);
        this.setDelayByAttackSpeed(270L);
    }
}
