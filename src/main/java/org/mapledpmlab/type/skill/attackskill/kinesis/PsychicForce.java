package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class PsychicForce extends DotAttackSkill {
    public PsychicForce() {
        this.setName("싸이킥 포스3");
        this.setDelayByAttackSpeed(360L);
        this.setCooldown(1.0);
        this.setDamage(75.0);
        this.setAttackCount(1L);
        this.setDotDuration(30000L);
        this.setInterval(1000L);
    }
}
