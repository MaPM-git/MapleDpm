package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Asura extends AttackSkill {
    public Asura() {
        this.setName("아수라");
        this.setDamage(1110.0);
        this.setAttackCount(12L);
        this.setCooldown(60.0);
        this.setDelay(2340L);
        this.setDotDuration(2340L);
        this.setInterval(180L);
        this.setLimitAttackCount(13L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(2.2);           // 코어강화
        this.setRelatedSkill(new AsuraAfterDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
