package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SonicBlow extends AttackSkill {
    public SonicBlow() {
        this.setName("소닉 블로우");
        this.setAttackCount(7L * 2);
        this.setDamage(1100.0);
        this.setDelay(1800L);
        this.setDotDuration(1800L);
        this.setInterval(120L);
        this.setLimitAttackCount(15L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(0.85);      // 쉐도우 파트너
    }
}
