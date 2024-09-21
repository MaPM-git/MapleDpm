package org.mapledpmlab.type.skill.buffskill.pathfinder;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class RelicEvolution extends GaugeBuffSkill {
    public RelicEvolution() {
        this.setName("렐릭 에볼루션");
        this.setCooldown(120.0);
        this.setDuration(30L);
        this.setGaugeCharge(1000.0);
        this.setApplyServerLag(true);
    }
}
