package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FuriousEdge extends AttackSkill {
    public FuriousEdge() {
        this.setName("퓨리어스 엣지");
        this.setAttackCount(3L);
        this.setDamage(277.0);
        this.setDotDuration(2000L);
        this.setInterval(210L);
        this.setLimitAttackCount(4L);
    }
}
