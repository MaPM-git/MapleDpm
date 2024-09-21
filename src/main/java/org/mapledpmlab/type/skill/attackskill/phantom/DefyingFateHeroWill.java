package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DefyingFateHeroWill extends AttackSkill {
    public DefyingFateHeroWill() {
        this.setName("디파잉 페이트(영웅의 의지)");
        this.setAttackCount(15L);
        this.setDamage(640.0);
        this.setDotDuration(30000L);
        this.setInterval(600L);
        this.setLimitAttackCount(50L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(50L);
        this.setApplyFinalAttack(true);
        this.setApplyServerLag(true);
    }
}
