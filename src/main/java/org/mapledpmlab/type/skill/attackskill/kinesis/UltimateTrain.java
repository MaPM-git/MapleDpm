package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimateTrain extends AttackSkill {
    public UltimateTrain() {
        this.setName("얼티메이트-트레인");
        this.setDamage(120.0 + 103);
        this.setDelayByAttackSpeed(810L);
        this.setAttackCount(6L);
        this.setCooldown(12.0);
        this.setApplyCooldownReduction(false);
        this.setDotDuration(12000L);
        this.setInterval(500L);
        this.setLimitAttackCount(17L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
