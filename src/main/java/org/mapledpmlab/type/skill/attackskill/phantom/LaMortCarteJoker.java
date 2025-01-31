package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LaMortCarteJoker extends AttackSkill {
    public LaMortCarteJoker() {
        this.setName("라모르 카르트(조커)");
        this.setAttackCount(1L);
        this.setDamage(1350.0 + 450);
        this.setProp(100L);
        this.setFinalAttack(true);
    }
}
