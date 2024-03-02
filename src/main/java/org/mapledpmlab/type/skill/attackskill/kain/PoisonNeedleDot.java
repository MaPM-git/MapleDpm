package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNeedleDot extends AttackSkill {
    public PoisonNeedleDot() {
        this.setName("[처형] 포이즌 니들(도트)");
        this.setDamage(620.0);
        this.setAttackCount(1L);
        this.setDotDuration(12000L);
        this.setInterval(1000L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new PoisonNeedleFinish());
        this.setAddDamage(20L);
    }
}
