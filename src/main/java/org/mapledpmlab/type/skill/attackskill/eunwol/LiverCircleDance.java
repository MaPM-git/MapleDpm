package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class LiverCircleDance extends AttackSkill {
    public LiverCircleDance() {
        this.setName("간간 수월래");
        this.setDamage(275.0);
        this.setAttackCount(3L);
        this.setDotDuration(720L * 1000);
        this.setInterval(3000L);
        this.setCooldown(3.0);
    }
}
