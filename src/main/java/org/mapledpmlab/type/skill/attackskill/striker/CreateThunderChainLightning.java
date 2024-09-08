package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CreateThunderChainLightning extends AttackSkill {
    public CreateThunderChainLightning() {
        this.setName("창뇌연격(번개)");
        this.setAttackCount(4L * 2);
        this.setDamage(1555.0);
        this.setDotDuration(3L);
        this.setInterval(1L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.getMultiAttackInfo().add(0L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.855);         // 축뢰
        this.addFinalDamage(1.18);          // 연쇄
    }
}
