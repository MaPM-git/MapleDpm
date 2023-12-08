package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class RequiemDelay extends GaugeAttackSkill {
    public RequiemDelay() {
        this.setName("레퀴엠");
        this.setDelay(3600L);
        this.setRelatedSkill(new RequiemDemonSword());
    }
}
