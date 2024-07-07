package org.mapledpmlab.old.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SwingResearch extends AttackSkill {
    public SwingResearch() {
        this.setName("스윙 연구");
        this.setAttackCount(5L + 2);
        this.setDamage(320.0 + 100 + 150);
        this.setProp(100L);
        this.setFinalAttack(true);
    }
}
