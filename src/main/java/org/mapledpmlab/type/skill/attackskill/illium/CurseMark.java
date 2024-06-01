package org.mapledpmlab.type.skill.attackskill.illium;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CurseMark extends AttackSkill {
    public CurseMark() {
        this.setName("커스 마크");
        this.setDamage(200.0);
        this.setAttackCount(1L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setFinalAttack(true);
        this.setProp(100L);
    }
}
