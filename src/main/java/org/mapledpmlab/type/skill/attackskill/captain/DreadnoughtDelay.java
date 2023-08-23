package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class DreadnoughtDelay extends AttackSkill {
    public DreadnoughtDelay() {
        this.setName("드레드노트");
        this.setDelay(4740L);
        this.setRelatedSkill(new DreadnoughtBombard());
    }
}
