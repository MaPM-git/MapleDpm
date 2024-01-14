package org.mapledpmlab.type.skill.attackskill.darkknight;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PiercingCycloneFinish extends AttackSkill {
    public PiercingCycloneFinish() {
        this.setName("피어스 사이클론(충격파)");
        this.setDamage(780.0);
        this.setAttackCount(15L);
        this.addFinalDamage(1.6);   // 코어 강화
        this.addIgnoreDefenseList(50L);
        this.setApplyFinalAttack(true);
    }
}
