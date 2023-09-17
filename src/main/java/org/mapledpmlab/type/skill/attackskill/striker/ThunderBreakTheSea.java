package org.mapledpmlab.type.skill.attackskill.striker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ThunderBreakTheSea extends AttackSkill {
    public ThunderBreakTheSea() {
        this.setName("뇌명벽해파");
        this.setAttackCount(4L);
        this.setDamage(3240.0);
        this.setCooldown(360.0);
        this.setDotDuration(400L * 11);
        this.setInterval(400L);
        this.setLimitAttackCount(11L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new ThunderBreakTheSeaDelay());
        this.addFinalDamage(1.71);          // 축뢰
    }
}
