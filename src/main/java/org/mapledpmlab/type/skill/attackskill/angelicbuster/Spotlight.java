package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Spotlight extends AttackSkill {
    public Spotlight() {
        this.setName("스포트라이트");
        this.setDamage(1760.0);
        this.setAttackCount(3L);
        this.setDotDuration(30000L);
        this.setInterval(240L);
        this.setLimitAttackCount(115L);
        this.addFinalDamage(1.6);   // 코어강화
    }
}
