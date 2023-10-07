package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MastemaClaw extends AttackSkill {
    public MastemaClaw() {
        this.setName("마스테마 클로우");
        this.setAttackCount(8L);
        this.setDamage(1100.0);
        this.setDotDuration(48000L - 1080 - 690);
        this.setInterval(5280L);
    }
}
