package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ForsakenRelicMagicArrow extends AttackSkill {
    public ForsakenRelicMagicArrow() {
        this.setName("마법 화살");
        this.setAttackCount(3L);
        this.setDamage(2700.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
