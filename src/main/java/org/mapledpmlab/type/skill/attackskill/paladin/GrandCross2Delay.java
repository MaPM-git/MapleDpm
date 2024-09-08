package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class GrandCross2Delay extends AttackSkill {
    public GrandCross2Delay() {
        this.setName("그랜드 크로스(큰 십자가)");
        this.setDelay(60L * 22);
        this.setRelatedSkill(new GrandCrossAfterDelay());
    }
}
