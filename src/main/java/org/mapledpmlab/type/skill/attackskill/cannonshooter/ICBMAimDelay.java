package org.mapledpmlab.type.skill.attackskill.cannonshooter;

import org.mapledpmlab.type.skill.attackskill.AttackSkill;

public class ICBMAimDelay extends AttackSkill {
    public ICBMAimDelay() {
        this.setName("ICBM(조준 딜레이)");
        this.setDelay(630L);
        this.setCooldown(30.0);
        this.setRelatedSkill(new ICBM());
    }
}
