package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class TimeHolding extends GaugeBuffSkill {
    public TimeHolding() {
        this.setName("타임 홀딩");
        this.setDuration(60L);
        this.setCooldown(120.0);
        this.addBuffDamage(10L);
        this.setApplyServerLag(true);
        this.setDelay(30L);
        this.setGaugeCharge(-10.0);
    }
}
