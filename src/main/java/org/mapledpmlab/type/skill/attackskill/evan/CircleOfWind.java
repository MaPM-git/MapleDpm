package org.mapledpmlab.type.skill.attackskill.evan;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CircleOfWind extends AttackSkill {
    public CircleOfWind() {
        this.setName("서클 오브 윈드");
        this.setDamage(108.0 + 213);
        this.setAttackCount(5L);
        this.setDelayByAttackSpeed(870L);
        this.addFinalDamage(2.2);                   // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
