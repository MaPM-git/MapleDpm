package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SonicBlow extends AttackSkill {
    public SonicBlow() {
        this.setName("소닉 블로우");
        this.setAttackCount(7L);
        this.setDamage(1100.0);
        this.setCooldown(45.0);
        this.setDotDuration(2500L);
        this.setInterval(100L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new SonicBlowDelay());
        this.addFinalDamage(1.7);       // 쉐도우 파트너
    }
}
