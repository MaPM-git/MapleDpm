package org.mapledpmlab.type.skill.attackskill.blaster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BurningBreakerRush extends AttackSkill {
    public BurningBreakerRush() {
        this.setName("버닝 브레이커(돌진)");
        this.setAttackCount(15L);
        this.setDamage(3300.0);
        this.addIgnoreDefenseList(100L);
        this.setRelatedSkill(new BurningBreakerExplosion());
        this.addFinalDamage(1.6);       // 코어 강화
    }
}
