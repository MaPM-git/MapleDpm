package org.mapledpmlab.type.skill.attackskill.kaiser;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class InfernoBreathUltimate extends AttackSkill {
    public InfernoBreathUltimate() {
        this.setName("얼티밋 인퍼널 브레스");
        this.setDamage(2060.0);
        this.setAttackCount(8L);
        this.setDelayByAttackSpeed(720L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
        this.getMultiAttackInfo().add(60L);
    }
}
