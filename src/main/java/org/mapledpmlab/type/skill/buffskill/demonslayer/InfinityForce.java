package org.mapledpmlab.type.skill.buffskill.demonslayer;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class InfinityForce extends GaugeBuffSkill {
    public InfinityForce() {
        this.setName("인피니티 포스");
        this.setCooldown(120.0);
        this.setDelay(990L);
        this.setDuration(35L);
        this.setApplyPlusBuffDuration(true);
        this.setGaugeCharge(-100.0);
    }
}
