package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StrikeArrow3 extends AttackSkill {
    public StrikeArrow3() {
        this.setName("스트라이크 애로우 III");
        this.setDamage(670.0 + 135);
        this.setAttackCount(5L);
        this.setDelayByAttackSpeed(570L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
    }
}
