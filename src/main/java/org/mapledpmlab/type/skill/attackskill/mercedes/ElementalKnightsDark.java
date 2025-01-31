package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ElementalKnightsDark extends AttackSkill {
    public ElementalKnightsDark() {
        this.setName("엘리멘탈 나이트");
        this.setAttackCount(2L);
        this.setDamage(325.0);
        this.setDotDuration(720L * 1000);
        this.setInterval(667L);
        this.addFinalDamage(2.8);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
