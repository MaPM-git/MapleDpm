package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Eviscerate extends AttackSkill {
    public Eviscerate() {
        this.setName("절개");
        this.setAttackCount(7L);
        this.setDamage(1480.0);
        this.setCooldown(20.0);
        this.setDotDuration(720L);
        this.setInterval(144L);
        this.setLimitAttackCount(5L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new EviscerateDelay());
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
