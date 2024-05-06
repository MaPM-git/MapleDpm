package org.mapledpmlab.type.skill.attackskill.pathfinder;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ForsakenRelicMagicArrow extends AttackSkill {
    public ForsakenRelicMagicArrow() {
        this.setName("포세이큰 렐릭(마법 화살)");
        this.setAttackCount(5L);
        this.setDamage(1620.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
