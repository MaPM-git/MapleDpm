package org.mapledpmlab.type.skill.attackskill.dualblade;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class KarmaBladeDelay extends AttackSkill {
    public KarmaBladeDelay() {
        this.setName("카르마 블레이드");
        this.setDelay(3300L);
        this.setRelatedSkill(new KarmaBlade3());
    }
}
