package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class UltimateTrain extends AttackSkill {
    public UltimateTrain() {
        this.setName("얼티메이트-트레인");
        this.setDamage(370.0);
        this.setDelayByAttackSpeed(810L);
        this.setAttackCount(6L);
        this.setCooldown(8.63);
        this.setApplyCooldownReduction(false);
        this.setDotDuration(9000L);
        this.setInterval(470L);
        this.setLimitAttackCount(17L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.addFinalDamage(1.08);          // 오버로드 마나
        this.setApplyFinalAttack(true);
    }
}
