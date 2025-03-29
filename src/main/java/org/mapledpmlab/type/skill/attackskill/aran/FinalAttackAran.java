package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalAttackAran extends AttackSkill {
    public FinalAttackAran() {
        this.setName("파이널 어택");
        this.setAttackCount(3L);
        this.setDamage(317.0);
        this.setProp(61L);
        this.setFinalAttack(true);
        this.addFinalDamage(2.2);           // 코어 강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(30L);     // 아티팩트
    }
}
