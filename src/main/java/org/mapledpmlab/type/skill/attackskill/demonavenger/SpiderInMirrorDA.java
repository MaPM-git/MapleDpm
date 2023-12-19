package org.mapledpmlab.type.skill.attackskill.demonavenger;

import org.mapledpmlab.type.skill.attackskill.GaugeAttackSkill;
import org.mapledpmlab.type.skill.attackskill.common.SpiderInMirrorDot;

public class SpiderInMirrorDA extends GaugeAttackSkill {
    public SpiderInMirrorDA() {
        this.setName("스파이더 인 미러");
        this.setDamage(990.0);
        this.setAttackCount(15L);
        this.setCooldown(250.0);
        this.setDelay(960L);
        this.setRelatedSkill(new SpiderInMirrorDot());
        this.setGaugePer(-15L);
    }
}
