package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PoisonNeedleLoop extends AttackSkill {
    public PoisonNeedleLoop() {
        this.setName("[처형] 포이즌 니들(연속 공격)");
        this.setDamage(550.0);
        this.setAttackCount(8L);
        this.setDelay(480L);
        this.setDotDuration(480L);
        this.setInterval(120L);
        this.setLimitAttackCount(4L);
        this.addFinalDamage(2.2);   // 코어강화
        this.addIgnoreDefenseList(20L);
        this.setRelatedSkill(new PoisonNeedleDot());
        this.setAddDamage(20L);
    }
}
