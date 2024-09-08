package org.mapledpmlab.type.skill.attackskill.captain;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class BulletPartyBeforeDelay extends AttackSkill {
    public BulletPartyBeforeDelay() {
        this.setName("불릿 파티(선딜)");
        this.setDelay(180L);
        this.setCooldown(90.0);
        this.setRelatedSkill(new BulletParty());
    }
}
