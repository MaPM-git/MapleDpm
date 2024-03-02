package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNeedleFinish extends AttackSkill {
    public PoisonNeedleFinish() {
        this.setName("[처형] 포이즌 니들(마무리 일격)");
        this.setDamage(460.0);
        this.setAttackCount(10L);
        this.setDelayByAttackSpeed(360L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setAddDamage(20L);
    }
}
