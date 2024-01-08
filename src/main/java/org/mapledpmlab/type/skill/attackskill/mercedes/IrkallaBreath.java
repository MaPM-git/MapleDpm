package org.mapledpmlab.type.skill.attackskill.mercedes;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class IrkallaBreath extends AttackSkill {
    public IrkallaBreath() {
        this.setName("이르칼라의 숨결");
        this.setDamage(880.0);
        this.setAttackCount(12L);
        this.setDotDuration(5300L);
        this.setInterval(120L);
        this.setRelatedSkill(new IrkallaBreathAfterDelay());
        this.addFinalDamage(1.6);           // 코어 강화
        this.setApplyFinalAttack(true);
    }
}
