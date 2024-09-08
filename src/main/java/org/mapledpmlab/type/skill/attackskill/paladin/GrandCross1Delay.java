package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrandCross1Delay extends AttackSkill {
    public GrandCross1Delay() {
        this.setName("그랜드 크로스(작은 십자가)");
        this.setDelay(1080L);
        this.setRelatedSkill(new GrandCrossLoopDelay());
    }
}
