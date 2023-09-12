package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.nightwalker.DominionBuff;

public class Dominion extends AttackSkill implements DarkAttack {
    public Dominion() {
        this.setName("도미니언");
        this.setAttackCount(10L);
        this.setDamage(1000.0);
        this.setRelatedSkill(new DominionBuff());
        this.setCooldown(180.0);
    }
}
