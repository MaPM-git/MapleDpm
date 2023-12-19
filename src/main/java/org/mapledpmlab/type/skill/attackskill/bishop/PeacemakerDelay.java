package org.mapledpmlab.type.skill.attackskill.bishop;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class PeacemakerDelay extends AttackSkill {
    public PeacemakerDelay() {
        this.setName("피스메이커");
        this.setDelay(750L);
        this.setCooldown(10.0);
        this.setRelatedSkill(new PeacemakerFinish());
    }
}
