package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AuraBlade extends AttackSkill {
    public AuraBlade() {
        this.setDamage(180.0 + 70.0);   // 레이징 블로우
        this.setDelayByAttackSpeed(720L);
        this.setAttackCount(5L);
        this.setCooldown(7.0);
        this.addFinalDamage(2.8);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
