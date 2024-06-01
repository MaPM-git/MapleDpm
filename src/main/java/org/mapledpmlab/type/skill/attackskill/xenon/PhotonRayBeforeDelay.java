package org.mapledpmlab.type.skill.attackskill.xenon;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PhotonRayBeforeDelay extends AttackSkill {
    public PhotonRayBeforeDelay() {
        this.setName("포톤 레이(선딜)");
        this.setDelay(300L);
        this.setCooldown(30.0);
    }
}
