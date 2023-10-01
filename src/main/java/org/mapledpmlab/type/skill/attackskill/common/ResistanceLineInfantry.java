package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ResistanceLineInfantry extends AttackSkill {
    public ResistanceLineInfantry() {
        this.setName("레지스탕스 라인 인팬트리");
        this.setAttackCount(9L);
        this.setDamage(455.0);
        this.setCooldown(25.0);
        this.setDotDuration(10000L);
        this.setInterval(240L);
        this.setRelatedSkill(new ResistanceLineInfantryDelay());
    }
}
