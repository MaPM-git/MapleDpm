package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ElementalKnightsDark extends AttackSkill {
    public ElementalKnightsDark() {
        this.setName("엘리멘탈 나이트(암흑 정령)");
        this.setAttackCount(1L);
        this.setDamage(548.0);
        this.setDotDuration(720L * 1000);
        this.setInterval(1470L);
        this.addFinalDamage(2.8);           // 코어 강화
        this.addCriticalP(5.0);
        this.addIgnoreDefenseList(20L);
    }
}
