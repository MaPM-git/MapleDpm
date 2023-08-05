package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DivineStigmaExplosion extends AttackSkill {
    public DivineStigmaExplosion() {
        this.setDamage(296.0);
        this.setDelayByAttackSpeed(0L);
        this.setAttackCount(5L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
