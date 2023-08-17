package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingFistShock extends AttackSkill {
    public HowlingFistShock() {
        this.setName("하울링 피스트(충격)");
        this.setAttackCount(14L);
        this.setDamage(1505.0);
        this.setCooldown(90.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(2580L);
        this.setInterval(180L);
        this.setLimitAttackCount(14L);
        this.addFinalDamage(1.6);
        this.setRelatedSkill(new HowlingFistDelay());
    }
}
