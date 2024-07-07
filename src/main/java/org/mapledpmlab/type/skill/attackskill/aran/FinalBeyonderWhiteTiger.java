package org.mapledpmlab.type.skill.attackskill.aran;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FinalBeyonderWhiteTiger extends AttackSkill {
    public FinalBeyonderWhiteTiger() {
        this.setName("파이널 비욘더-백호");
        this.setDamage(815.0);
        this.setAttackCount(7L);
        this.setDelayByAttackSpeed(600L);
        this.setApplyFinalAttack(true);
        this.addIgnoreDefenseList(50L);
        this.addFinalDamage(1.6);       // 코어강화
        this.addFinalDamage(2.2);       // 코어강화
        this.addIgnoreDefenseList(20L);
    }
}
