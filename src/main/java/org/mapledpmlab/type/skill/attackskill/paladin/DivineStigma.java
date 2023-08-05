package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivineStigma extends AttackSkill {
    public DivineStigma() {
        this.setApplyFinalAttack(true);
        this.setAttackCount(7L);
        this.setCooldown(7.0);
        this.setDamage(428.0);
        this.setDelayByAttackSpeed(810L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new DivineStigmaExplosion());
    }
}
