package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DistortionFieldIntense extends AttackSkill {
    public DistortionFieldIntense() {
        this.setName("인텐스 디스토션 필드");
        this.setDelayByAttackSpeed(900L);
        this.setDotDuration(2500L);
        this.setInterval(180L);
        this.setLimitAttackCount(13L);
        this.setAttackCount(3L);
        this.setDamage(1240.0);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
    }
}
