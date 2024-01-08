package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UnfadingGlory extends AttackSkill {
    public UnfadingGlory() {
        this.setName("언페이딩 글로리");
        this.setAttackCount(9L);
        this.setCooldown(360.0);
        this.setDamage(3600.0);
        this.setDotDuration(5580L);
        this.setLimitAttackCount(12L);
        this.setInterval(465L);
        this.setAddDamage(50L);
        this.addIgnoreDefenseList(20L);
        this.addIgnoreDefenseList(30L);
        this.setRelatedSkill(new UnfadingGloryDelay());
        this.setApplyFinalAttack(true);
    }
}
