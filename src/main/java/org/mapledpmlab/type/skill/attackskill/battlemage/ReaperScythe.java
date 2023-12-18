package org.mapledpmlab.type.skill.attackskill.battlemage;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ReaperScythe extends AttackSkill {
    public ReaperScythe() {
        this.setName("사신의 낫");
        this.setDamage(300.0);
        this.setAttackCount(12L);
        this.addIgnoreDefenseList(50L);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.6);
        this.setApplyFinalAttack(true);
    }
}
