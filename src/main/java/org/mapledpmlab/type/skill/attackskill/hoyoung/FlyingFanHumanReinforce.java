package org.mapledpmlab.type.skill.attackskill.hoyoung;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FlyingFanHumanReinforce extends AttackSkill {
    public FlyingFanHumanReinforce() {
        this.setName("여의선 : 인(강화)");
        this.setDamage(1230.0 + 205 + 317);
        this.setDelayByAttackSpeed(690L);
        this.setAttackCount(5L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
