package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AliveMustDie extends AttackSkill {
    public AliveMustDie() {
        this.setName("생자필멸");
        this.setAttackCount(6L);
        this.setDamage(425.0 + 400);
        this.setCooldown(1.0);
        this.getMultiAttackInfo().add(390L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
        this.getMultiAttackInfo().add(30L);
    }
}
