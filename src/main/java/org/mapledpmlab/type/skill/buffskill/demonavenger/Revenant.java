package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class Revenant extends GaugeBuffSkill {
    public Revenant() {
        this.setName("레버넌트");
        this.setCooldown(120.0);
        this.setDelay(900L);
        this.setDuration(15L + 3);      // 코어 강화
        this.setGaugePer(-25L);
    }
}
