package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SlashShadowFormation extends AttackSkill {
    public SlashShadowFormation() {
        this.setName("멸귀참영진");
        this.setAttackCount(8L);
        this.setDamage(935.0);
        this.setCooldown(90.0);
        this.setDotDuration(8000L);
        this.setInterval(666L);
        this.setLimitAttackCount(12L);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new SlashShadowFormationBoss());
    }
}
