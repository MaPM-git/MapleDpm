package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DefyingFate extends AttackSkill {
    public DefyingFate() {
        this.setName("디파잉 페이트");
        this.setAttackCount(15L);
        this.setDamage(6300.0);
        this.setDotDuration(3180L);
        this.setInterval(454L);
        this.setLimitAttackCount(7L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new DefyingFateHeroWill());
        this.setApplyFinalAttack(true);
    }
}
