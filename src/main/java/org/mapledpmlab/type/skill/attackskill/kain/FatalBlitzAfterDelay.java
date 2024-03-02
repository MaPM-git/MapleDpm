package org.mapledpmlab.type.skill.attackskill.kain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class FatalBlitzAfterDelay extends AttackSkill {
    public FatalBlitzAfterDelay() {
        this.setName("[처형] 페이탈 블리츠(후딜)");
        this.setDelayByAttackSpeed(180L);
    }
}
