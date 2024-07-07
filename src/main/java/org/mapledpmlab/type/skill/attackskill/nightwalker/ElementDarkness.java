package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.DotAttackSkill;

public class ElementDarkness extends DotAttackSkill implements DarkAttack {
    public ElementDarkness() {
        this.setName("엘리멘트 : 다크니스");
        this.setAttackCount(1L);
        this.setDamage(220.0 * 5);
        this.setInterval(1000L);
    }
}
