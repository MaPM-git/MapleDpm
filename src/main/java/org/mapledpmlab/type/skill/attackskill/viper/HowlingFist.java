package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HowlingFist extends AttackSkill {
    public HowlingFist() {
        this.setName("하울링 피스트");
        this.setAttackCount(6L);
        this.setDamage(935.0);
        this.setCooldown(90.0);
        this.setApplyFinalAttack(true);
        this.setDotDuration(2100L);
        this.setInterval(240L);
        this.setLimitAttackCount(8L);
        this.addFinalDamage(1.6);
        this.setRelatedSkill(new HowlingFistShock());
    }
}
