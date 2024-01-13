package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrandCrossFirstDelay extends AttackSkill {
    public GrandCrossFirstDelay() {
        this.setName("그랜드 크로스(선딜)");
        this.setDelay(900L);
        this.setCooldown(180.0);
        this.setRelatedSkill(new GrandCross1());
    }
}
