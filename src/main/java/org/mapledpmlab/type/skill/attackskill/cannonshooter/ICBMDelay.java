package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ICBMDelay extends AttackSkill {
    public ICBMDelay() {
        this.setName("ICBM");
        this.setDelay(630L);
        this.setRelatedSkill(new ICBMPollution());
    }
}
