package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackHero extends AttackSkill {
    public FinalAttackHero() {
        this.setName("파이널 어택");
        this.setAddDamage(30L);     // 아티팩트
        this.setAttackCount(3L);
        this.setDamage(266.0);
        this.setProp(76L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
