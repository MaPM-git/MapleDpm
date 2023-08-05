package org.mapledpmlab.type.skill.attackskill.common;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class CrestOfTheSolar extends AttackSkill {
    public CrestOfTheSolar() {
        this.setName("크레스트 오브 더 솔라");
        this.setDamage(1650.0);
        this.setAttackCount(12L);
        this.setCooldown(250.0);
        this.setDelayByAttackSpeed(870L);
        this.setRelatedSkill(new CrestOfTheSolarDot());
    }
}
