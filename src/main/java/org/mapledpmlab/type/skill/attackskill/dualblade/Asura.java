package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Asura extends AttackSkill {
    public Asura() {
        this.setName("아수라");
        this.setDamage(1386.0);
        this.setAttackCount(10L);
        this.setCooldown(60.0);
        this.setDelay(4500L);
        this.setDotDuration(4500L);
        this.setInterval(300L);
        this.setLimitAttackCount(15L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(2.2);           // 코어강화
        this.setRelatedSkill(new AsuraAfterDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(0.85);           // 미러 이미징
    }
}
