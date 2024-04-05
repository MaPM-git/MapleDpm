package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlyingFanHuman extends AttackSkill {
    public FlyingFanHuman() {
        this.setName("여의선 : 인");
        this.setDamage(858.0 + 205 + 312);
        this.setDelayByAttackSpeed(690L);
        this.setAttackCount(5L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
