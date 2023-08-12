package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SlashShadowFormationBoss extends AttackSkill {
    public SlashShadowFormationBoss() {
        this.setName("멸귀참영진(우두머리)");
        this.setAttackCount(15L);
        this.setDamage(1375.0);
        this.setCooldown(90.0);
        this.setDotDuration(4L);
        this.setInterval(1L);
        this.setLimitAttackCount(4L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new SlashShadowFormationDelay());
    }
}
