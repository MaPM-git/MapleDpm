package org.mapledpmlab.old.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SmashingMultipunchFirstDelay extends AttackSkill {
    public SmashingMultipunchFirstDelay() {
        this.setName("파쇄 연권(선딜)");
        this.setDelay(390L);
        this.setCooldown(60.0);
        this.setRelatedSkill(new SmashingMultipunch());
    }
}
