package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.nightwalker.DominionBuff;

public class Dominion extends AttackSkill implements DarkAttack {
    public Dominion() {
        this.setName("도미니언");
        this.setAttackCount(10L);
        this.setDamage(2000.0);
        this.setRelatedSkill(new DominionBuff());
        this.setCooldown(180.0);
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
