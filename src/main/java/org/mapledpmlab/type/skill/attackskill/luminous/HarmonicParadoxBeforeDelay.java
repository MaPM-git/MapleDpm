package org.mapledpmlab.type.skill.attackskill.luminous;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class HarmonicParadoxBeforeDelay extends AttackSkill {
    public HarmonicParadoxBeforeDelay() {
        this.setName("하모닉 패러독스(키다운)");
        this.setCooldown(360.0);
        this.setDelay(720L);
        this.setRelatedSkill(new HarmonicParadoxKeydown());
    }
}
