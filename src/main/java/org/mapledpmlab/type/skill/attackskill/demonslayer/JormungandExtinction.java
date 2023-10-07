package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class JormungandExtinction extends AttackSkill {
    public JormungandExtinction() {
        this.setName("요르문간드(소멸)");
        this.setAttackCount(15L);
        this.setDamage(2280.0);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.6);           // 코어 강화
    }
}
