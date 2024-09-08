package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SlashShadowFormationBoss extends AttackSkill {
    public SlashShadowFormationBoss() {
        this.setName("멸귀참영진(우두머리)");
        this.setAttackCount(15L);
        this.setDamage(1870.0);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.getMultiAttackInfo().add(5370 - 600 + 900L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
        this.getMultiAttackInfo().add(90L);
    }
}
