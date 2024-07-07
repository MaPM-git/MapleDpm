package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TriangleFormation extends AttackSkill {
    public TriangleFormation() {
        this.setName("트라이앵글 포메이션");
        this.setAttackCount(3L);
        this.setDamage(410.0);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
