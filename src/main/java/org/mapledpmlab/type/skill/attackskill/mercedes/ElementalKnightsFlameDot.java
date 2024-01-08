package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ElementalKnightsFlameDot extends AttackSkill {
    public ElementalKnightsFlameDot() {
        this.setName("엘리멘탈 나이트(화염 정령, 도트)");
        this.setAttackCount(1L);
        this.setDamage(110.0);
        this.setDotDuration(5000L);
        this.setInterval(1000L);
        this.addFinalDamage(2.8);           // 코어 강화
        this.addCriticalP(5.0);
        this.addIgnoreDefenseList(20L);
    }
}
