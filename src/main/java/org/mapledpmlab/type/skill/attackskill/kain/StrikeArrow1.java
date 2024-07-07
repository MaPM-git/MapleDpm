package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StrikeArrow1 extends AttackSkill {
    public StrikeArrow1() {
        this.setName("스트라이크 애로우");
        this.setDamage(670.0);
        this.setAttackCount(5L);
        this.setDelayByAttackSpeed(570L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(10L + 15);
    }
}
