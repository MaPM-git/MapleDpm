package org.mapledpmlab.type.skill.attackskill.eunwol;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class SmashingMultipunchKedownDelay extends AttackSkill {
    public SmashingMultipunchKedownDelay() {
        this.setName("파쇄 연권(키다운)");
        this.setDelay(910L);
        this.setRelatedSkill(new SmashingMultipunchEnd());
    }
}
