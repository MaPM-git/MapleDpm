package org.mapledpmlab.type.skill.attackskill.paladin;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.paladin.SacredBastionBuff;

public class SacredBastion2Delay extends AttackSkill {
    public SacredBastion2Delay() {
        this.setName("세이크리드 바스티온");
        this.setDelay(1200L);
        this.setRelatedSkill(new SacredBastionBuff());
    }
}
