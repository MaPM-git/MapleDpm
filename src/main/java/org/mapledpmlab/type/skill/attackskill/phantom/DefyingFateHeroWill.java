package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DefyingFateHeroWill extends AttackSkill {
    public DefyingFateHeroWill() {
        this.setName("디파잉 페이트(영웅의 의지)");
        this.setAttackCount(4L);
        this.setDamage(7200.0);
        this.setDotDuration(30000L);
        this.setInterval(1800L);
        this.setLimitAttackCount(16L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setApplyFinalAttack(true);
    }
}
