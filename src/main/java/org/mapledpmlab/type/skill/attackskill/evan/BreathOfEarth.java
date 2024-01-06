package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BreathOfEarth extends AttackSkill {
    public BreathOfEarth() {
        this.setName("브레스 오브 어스");
        this.setDamage(281.0);
        this.setAttackCount(6L);
        this.setDotDuration(3450L);
        this.setInterval(450L);
        this.setLimitAttackCount(7L);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
