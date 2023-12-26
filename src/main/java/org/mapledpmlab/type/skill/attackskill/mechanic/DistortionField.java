package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DistortionField extends AttackSkill {
    public DistortionField() {
        this.setName("디스토션 필드");
        this.setCooldown(8.0);
        this.setDotDuration(4000L);
        this.setInterval(250L);
        this.setLimitAttackCount(15L);
        this.setAttackCount(2L);
        this.setDamage(350.0);
        this.setRelatedSkill(new DistortionFieldDelay());
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
