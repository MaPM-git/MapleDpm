package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrandCrossLoopDelay extends AttackSkill {
    public GrandCrossLoopDelay() {
        this.setName("그랜드 크로스(중간딜)");
        this.setDelay(600L);
        this.setRelatedSkill(new GrandCross2());
    }
}
