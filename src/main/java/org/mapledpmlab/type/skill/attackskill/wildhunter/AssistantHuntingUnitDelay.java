package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AssistantHuntingUnitDelay extends AttackSkill {
    public AssistantHuntingUnitDelay() {
        this.setName("어시스턴트 헌팅 유닛");
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(60.0);
    }
}
