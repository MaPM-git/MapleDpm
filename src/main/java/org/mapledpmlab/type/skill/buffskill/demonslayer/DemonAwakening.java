package org.mapledpmlab.type.skill.buffskill.demonslayer;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class DemonAwakening extends GaugeBuffSkill {
    public DemonAwakening() {
        this.setName("데몬 어웨이크닝");
        this.setCooldown(120.0);
        this.setDelay(870L);
        this.setDuration(65L);
        this.setGaugeCharge(-100.0);
    }
}
