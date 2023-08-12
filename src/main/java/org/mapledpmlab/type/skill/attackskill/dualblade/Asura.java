package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Asura extends AttackSkill {
    public Asura() {
        this.setName("아수라");
        this.setDamage(693.0);
        this.setAttackCount(5L);
        this.setCooldown(60.0);
        this.setDotDuration(5000L);
        this.setInterval(300L);
        this.addIgnoreDefenseList(100L);
        this.addFinalDamage(2.2);           // 코어강화
        this.setRelatedSkill(new AsuraDelay());
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.7);           // 미러 이미징
    }
}
