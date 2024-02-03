package org.mapledpmlab.type.skill.attackskill.shadower;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SlashShadowFormation extends AttackSkill {
    public SlashShadowFormation() {
        this.setName("멸귀참영진");
        this.setAttackCount(8L);
        this.setDamage(935.0);
        this.setCooldown(90.0);
        this.addIgnoreDefenseList(100L);
        this.setFinalDamage(1.6);       // 코어강화
        this.setRelatedSkill(new SlashShadowFormationBoss());
        this.getMultiAttackInfo().add(900L);
        this.getMultiAttackInfo().add(780L);
        this.getMultiAttackInfo().add(780L);
        this.getMultiAttackInfo().add(660L);
        this.getMultiAttackInfo().add(480L);
        this.getMultiAttackInfo().add(360L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(240L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(180L);
        this.getMultiAttackInfo().add(120L);
        this.getMultiAttackInfo().add(450L);
    }
}
