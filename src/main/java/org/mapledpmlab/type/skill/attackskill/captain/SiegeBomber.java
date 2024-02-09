package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SiegeBomber extends AttackSkill {
    public SiegeBomber() {
        this.setName("시즈 봄버");
        this.setAttackCount(1L);
        this.setDamage(300.0);
        this.setDelay(630L);
        this.setCooldown(60.0);
        this.setDotDuration(60000L);
        this.setInterval(600L);
        this.addFinalDamage(2.8);       // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
