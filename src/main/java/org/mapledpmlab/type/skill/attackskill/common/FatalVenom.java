package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class FatalVenom extends DotAttackSkill {
    public FatalVenom() {
        this.setName("페이탈 베놈");
        this.setAttackCount(1L);
        this.setDamage(165.0);
        this.setDotDuration(8000L);
        this.setInterval(334L);
    }
}
