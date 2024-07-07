package org.mapledpmlab.type.skill.attackskill.zero;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class DivineLeer extends DotAttackSkill implements AlphaSkill {
    public DivineLeer() {
        this.setName("디바인 리어");
        this.setAttackCount(1L);
        this.setDamage(200.0);
        this.setDotDuration(10000L);
        this.setInterval(1000L);
    }
}

