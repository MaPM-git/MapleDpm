package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class StormBreak extends AttackSkill implements AlphaSkill {
    public StormBreak() {
        this.setName("스톰 브레이크");
        this.setAttackCount(10L);
        this.setDamage(535.0);
        this.setDelayByAttackSpeed(900L);
        this.setRelatedSkill(new StormBreakTornado());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
