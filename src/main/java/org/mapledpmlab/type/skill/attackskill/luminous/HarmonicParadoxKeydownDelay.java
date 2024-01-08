package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HarmonicParadoxKeydownDelay extends AttackSkill {
    public HarmonicParadoxKeydownDelay() {
        this.setName("하모닉 패러독스(키다운)");
        this.setDelay(3500L);
        this.setRelatedSkill(new HarmonicParadoxPower());
    }
}
