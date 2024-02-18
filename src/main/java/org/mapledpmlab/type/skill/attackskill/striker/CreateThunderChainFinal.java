package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CreateThunderChainFinal extends AttackSkill {
    public CreateThunderChainFinal() {
        this.setName("창뇌연격(마지막 연계)");
        this.setAttackCount(7L);
        this.setDamage(1540.0);
        this.setDelay(600L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.71);          // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
        this.setRelatedSkill(new CreateThunderChainHugeLightning());
    }
}
