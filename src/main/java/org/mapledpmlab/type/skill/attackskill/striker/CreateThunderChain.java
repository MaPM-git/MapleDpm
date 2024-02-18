package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CreateThunderChain extends AttackSkill {
    public CreateThunderChain() {
        this.setName("창뇌연격");
        this.setAttackCount(5L);
        this.setDamage(1100.0);
        this.setDelay(240L * 11);
        this.setCooldown(120.0);
        this.setDotDuration(240L * 11);
        this.setInterval(240L);
        this.setLimitAttackCount(11L);
        this.setRelatedSkill(new CreateThunderChainFinal());
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(1.71);          // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
