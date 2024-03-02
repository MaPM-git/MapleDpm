package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FatalBlitzLoop extends AttackSkill {
    public FatalBlitzLoop() {
        this.setName("[처형] 페이탈 블리츠");
        this.setDamage(730.0);
        this.setAttackCount(12L);
        this.setDelay(840L);
        this.setDotDuration(840L);
        this.setInterval(60L);
        this.setLimitAttackCount(14L);
        this.addFinalDamage(1.6);   // 코어강화
        this.setRelatedSkill(new FatalBlitzAfterDelay());
    }
}
