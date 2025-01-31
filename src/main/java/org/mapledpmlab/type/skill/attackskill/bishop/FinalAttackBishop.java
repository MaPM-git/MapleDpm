package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackBishop extends AttackSkill {
    public FinalAttackBishop() {
        this.setName("파이널 어택(제네시스)");
        this.setAttackCount(1L);
        this.setDamage(405.0);
        this.setProp(65L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(30L);     // 아티팩트
    }
}
