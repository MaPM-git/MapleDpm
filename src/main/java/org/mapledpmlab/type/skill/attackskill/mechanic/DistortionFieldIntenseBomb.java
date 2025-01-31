package org.mapledpmlab.type.skill.attackskill.mechanic;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DistortionFieldIntenseBomb extends AttackSkill {
    public DistortionFieldIntenseBomb() {
        this.setName("인텐스 디스토션 필드(폭발)");
        this.setCooldown(30.0);
        this.setAttackCount(15L);
        this.setDamage(1990.0);
        this.addFinalDamage(2.2);               // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new DistortionFieldIntense());
        this.getMultiAttackInfo().add(2400L);
    }
}
