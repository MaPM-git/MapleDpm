package org.mapledpmlab.type.skill.attackskill.hero;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class AuraBladeFinal extends AttackSkill {
    public AuraBladeFinal() {
        this.setName("파이널 블레이드");
        this.setDamage(693.0);
        this.setDelayByAttackSpeed(630L);
        this.setAttackCount(5L);
        this.addFinalDamage(2.8);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setApplyFinalAttack(true);
    }
}
