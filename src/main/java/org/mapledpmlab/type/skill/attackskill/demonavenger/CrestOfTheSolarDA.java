package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.CrestOfTheSolarDot;

public class CrestOfTheSolarDA extends GaugeAttackSkill {
    public CrestOfTheSolarDA() {
        this.setName("크레스트 오브 더 솔라");
        this.setDamage(1650.0);
        this.setAttackCount(12L);
        this.setCooldown(250.0);
        this.setDelayByAttackSpeed(870L);
        this.setRelatedSkill(new CrestOfTheSolarDot());
        this.setGaugePer(-15L);
    }
}
