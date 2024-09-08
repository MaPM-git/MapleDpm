package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IrkallaBreath extends AttackSkill {
    public IrkallaBreath() {
        this.setName("이르칼라의 숨결");
        this.setDamage(820.0);
        this.setAttackCount(12L);
        this.setDelay(5280L);
        this.setDotDuration(5280L);
        this.setInterval(120L);
        this.setLimitAttackCount(44L);
        this.setRelatedSkill(new IrkallaBreathAfterDelay());
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
        this.addFinalDamage((0.45 + 0.45 * 0.35 + 0.45 * 0.35 * 0.25) * 0.75 + 1);
    }
}
