package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class Flashbang extends AttackSkill {
    public Flashbang() {
        this.setName("플래시 뱅");
        this.setAttackCount(1L);
        this.setDamage(250.0);
        this.setDelayByAttackSpeed(570L);
        this.setApplyFinalAttack(true);
    }
}
