package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Lio2 extends AttackSkill {
    public Lio2() {
        this.setName("리요(2단계)");
        this.setDamage(100.0 + 100);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);  // 오버로드 마나
    }
}
