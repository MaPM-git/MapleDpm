package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThunderBreakTheSeaFinal extends AttackSkill {
    public ThunderBreakTheSeaFinal() {
        this.setName("뇌명벽해파(막타)");
        this.setAttackCount(7L);
        this.setDamage(5520.0);
        this.setDotDuration(400L * 7);
        this.setInterval(400L);
        this.setLimitAttackCount(7L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new ThunderBreakTheSeaFinalDelay());
        this.addFinalDamage(1.71);          // 축뢰
    }
}
