package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class ElementalKnightsFlameDot extends DotAttackSkill {
    public ElementalKnightsFlameDot() {
        this.setName("엘리멘탈 나이트(화염 정령, 도트)");
        this.setAttackCount(1L);
        this.setDamage(110.0);
        this.setDotDuration(5000L);
        this.setInterval(1000L);
    }
}
