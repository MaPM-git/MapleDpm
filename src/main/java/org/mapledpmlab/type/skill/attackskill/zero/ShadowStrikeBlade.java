package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ShadowStrikeBlade extends AttackSkill {
    public ShadowStrikeBlade() {
        this.setName("쉐도우 스트라이크(검기)");
        this.setAttackCount(1L);
        this.setDamage(310.0);
        this.setDelayByAttackSpeed(90L);
        this.addFinalDamage(2.8);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.getMultiAttackInfo().add(900L);
    }
}
