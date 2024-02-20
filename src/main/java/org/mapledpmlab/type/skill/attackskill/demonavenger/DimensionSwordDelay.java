package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;

public class DimensionSwordDelay extends GaugeAttackSkill {
    public DimensionSwordDelay() {
        this.setName("디멘션 소드");
        this.setDelay(660L);
        this.setGaugePer(-20L);
        this.setRelatedSkill(new DimensionSword());
    }
}
