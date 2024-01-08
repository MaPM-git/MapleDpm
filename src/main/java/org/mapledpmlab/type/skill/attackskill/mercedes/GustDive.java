package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GustDive extends AttackSkill {
    public GustDive() {
        this.setName("거스트 다이브");
        this.setAttackCount(4L);
        this.setDamage(280.0 + 240);
        this.setDelayByAttackSpeed(690L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
