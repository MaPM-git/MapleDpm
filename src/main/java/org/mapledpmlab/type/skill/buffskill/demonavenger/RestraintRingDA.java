package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class RestraintRingDA extends GaugeBuffSkill {
    public RestraintRingDA() {
        this.setName("리스트레인트 링(4레벨)");
        this.setCooldown(180.0);
        this.setDuration(15L);
        this.setDelay(30L);
        this.setBuffAttMagicPer(100L);
        this.setGaugeCharge(-600.0);
    }
}
