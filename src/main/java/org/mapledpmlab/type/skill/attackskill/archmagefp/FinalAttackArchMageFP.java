package org.mapledpmlab.type.skill.attackskill.archmagefp;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackArchMageFP extends AttackSkill {
    public FinalAttackArchMageFP() {
        this.setName("파이널 어택(메테오)");
        this.setAttackCount(1L);
        this.setDamage(224.0);      // 쓸컴뱃 기준
        this.setProp(62L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
