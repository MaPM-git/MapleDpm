package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;
import org.mapledpmlab.type.skill.buffskill.eunwol.AdventOfTheFoxBuff;

public class AdventOfTheFoxDelay extends AttackSkill {
    public AdventOfTheFoxDelay() {
        this.setName("호신강림");
        this.setDelay(4020L);
        this.setRelatedSkill(new AdventOfTheFoxBuff());
    }
}
