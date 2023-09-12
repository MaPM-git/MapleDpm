package org.mapledpmlab.type.skill.attackskill.nightwalker;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.nightwalker.SilenceBuff;

public class SilenceDelay extends AttackSkill {
    public SilenceDelay() {
        this.setName("사일런스");
        this.setDelay(5100L);
        this.setRelatedSkill(new SilenceBuff());
    }
}
