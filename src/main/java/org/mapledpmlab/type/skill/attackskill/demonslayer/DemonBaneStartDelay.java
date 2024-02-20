package org.mapledpmlab.type.skill.attackskill.demonslayer;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DemonBaneStartDelay extends GaugeAttackSkill {
    public DemonBaneStartDelay() {
        this.setName("데몬베인(선딜레이)");
        this.setDelay(600L);
        this.setRelatedSkill(new DemonBane1());
        this.setGaugeCharge(-60.0);
    }
}
