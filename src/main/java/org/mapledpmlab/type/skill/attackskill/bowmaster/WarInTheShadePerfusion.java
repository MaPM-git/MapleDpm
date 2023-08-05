package org.mapledpmlab.type.skill.attackskill.bowmaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class WarInTheShadePerfusion extends AttackSkill {
    public WarInTheShadePerfusion() {
        this.setName("어센던트 셰이드(화살 세례)");
        this.setAttackCount(8L);
        this.setCooldown(360.0);
        this.setDamage(2700.0);
        this.setDotDuration(30000L);
        this.setLimitAttackCount(4L);
        this.setInterval(3000L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
