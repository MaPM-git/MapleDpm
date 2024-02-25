package org.mapledpmlab.type.skill.attackskill.phantom;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class TempestOfCardBeforeDelay extends AttackSkill {
    public TempestOfCardBeforeDelay() {
        this.setName("템페스트 오브 카드(선딜)");
        this.setDelay(480L);
        this.setCooldown(18.0 * 0.8);           // 템페스트 오브 카드-쿨타임 리듀스
        this.setRelatedSkill(new TempestOfCard());
    }
}
