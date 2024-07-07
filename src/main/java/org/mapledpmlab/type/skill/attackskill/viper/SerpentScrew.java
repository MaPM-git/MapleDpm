package org.mapledpmlab.type.skill.attackskill.viper;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SerpentScrew extends AttackSkill {
    public SerpentScrew() {
        this.setName("서펜트 스크류");
        this.setAttackCount(3L);
        this.setDamage(780.0);
        this.setDotDuration(72000L);
        this.setInterval(270L);
        this.addFinalDamage(1.6);
        this.setDelay(600L);
        this.setCooldown(76.6);
    }
}
