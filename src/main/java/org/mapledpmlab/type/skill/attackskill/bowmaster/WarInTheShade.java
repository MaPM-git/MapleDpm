package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WarInTheShade extends AttackSkill {
    public WarInTheShade() {
        this.setName("어센던트 셰이드");
        this.setAttackCount(12L);
        this.setCooldown(360.0);
        this.setDamage(8100.0);
        this.setDotDuration(4000L);
        this.setLimitAttackCount(8L);
        this.setInterval(500L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new WarInTheShadeDelay());
    }
}
