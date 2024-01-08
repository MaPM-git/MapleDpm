package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ChargeDrive1 extends AttackSkill {
    public ChargeDrive1() {
        this.setName("차지 드라이브(돌진)");
        this.setAttackCount(1L);
        this.setDamage(250.0 + 100 + 197);
        this.setDelayByAttackSpeed(600L);
        this.setRelatedSkill(new ChargeDrive2());
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
