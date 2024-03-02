package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FatalBlitzBeforeDelay extends AttackSkill {
    public FatalBlitzBeforeDelay() {
        this.setName("[처형] 페이탈 블리츠(선딜)");
        this.setDelayByAttackSpeed(360L);
        this.setCooldown(90.0);
        this.setRelatedSkill(new FatalBlitzLoop());
    }
}
