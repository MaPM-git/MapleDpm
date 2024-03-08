package org.mapledpmlab.type.skill.attackskill.angelicbuster;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class MascotFamiliarBeforeDelay extends AttackSkill {
    public MascotFamiliarBeforeDelay() {
        this.setName("마스코트 패밀리어(선딜)");
        this.setDelay(360L);
        this.setCooldown(60.0);
        this.setRelatedSkill(new MascotFamiliar());
    }
}
