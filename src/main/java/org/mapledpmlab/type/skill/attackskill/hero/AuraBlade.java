package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AuraBlade extends AttackSkill {
    public AuraBlade() {
        this.setName("오라 블레이드");
        this.setDamage(462.0);
        this.setDelayByAttackSpeed(720L);
        this.setAttackCount(5L);
        this.setCooldown(8.0);
        this.addFinalDamage(2.8);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
        this.setApplyCooldownReduction(false);
        this.setRelatedSkill(new AuraBladeFinal());
    }
}
