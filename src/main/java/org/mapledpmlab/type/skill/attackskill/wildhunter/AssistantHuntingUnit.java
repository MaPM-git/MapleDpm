package org.mapledpmlab.type.skill.attackskill.wildhunter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AssistantHuntingUnit extends AttackSkill {
    public AssistantHuntingUnit() {
        this.setName("어시스턴트 헌팅 유닛");
        this.setDamage(150.0);
        this.setDotDuration(5000L);
        this.setInterval(300L);
        this.setAttackCount(3L);
        this.addFinalDamage(2.8);           // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
