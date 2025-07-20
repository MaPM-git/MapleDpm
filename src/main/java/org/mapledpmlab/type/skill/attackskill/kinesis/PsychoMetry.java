package org.mapledpmlab.type.skill.attackskill.kinesis;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PsychoMetry extends AttackSkill {
    public PsychoMetry() {
        this.setName("싸이코 메트리");
        this.setDamage(1200.0);
        this.setDelayByAttackSpeed(840L);
        this.setAttackCount(1L);
        this.setCooldown(120.0);
        this.setApplyFinalAttack(true);
        this.addFinalDamage(1.08);          // 오버로드 마나
    }
}
