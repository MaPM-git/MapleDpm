package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SpiritCaliber extends AttackSkill {
    public SpiritCaliber() {
        this.setName("스피릿 칼리버");
        this.setAttackCount(14L);
        this.setCooldown(360.0);
        this.setDamage(3900.0);
        this.setDotDuration(7080L);
        this.setLimitAttackCount(12L);
        this.setInterval(590L);
        this.setApplyFinalAttack(true);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new SpiritCaliberDelay());
    }
}
