package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LimitBreakFinish extends AttackSkill {
    public LimitBreakFinish() {
        this.setName("리미트 브레이크(막타)");
        this.setAttackCount(12L);
        this.setDamage(825.0);
        this.addFinalDamage(1.6);       // 코어 강화
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
