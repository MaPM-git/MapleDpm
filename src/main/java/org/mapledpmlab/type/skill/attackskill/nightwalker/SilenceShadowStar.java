package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SilenceShadowStar extends AttackSkill implements DarkAttack {
    public SilenceShadowStar() {
        this.setName("사일런스(그림자 표창)");
        this.setAttackCount(12L);
        this.setDamage(900.0);
        this.setDotDuration(3000L);
        this.setLimitAttackCount(5L);
        this.setInterval(600L);
        this.setCooldown(3.0);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
    }
}
