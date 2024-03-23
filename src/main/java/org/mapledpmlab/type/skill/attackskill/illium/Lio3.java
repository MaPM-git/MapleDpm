package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Lio3 extends AttackSkill {
    public Lio3() {
        this.setName("리요(3단계)");
        this.setDamage(200.0 + 100);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
