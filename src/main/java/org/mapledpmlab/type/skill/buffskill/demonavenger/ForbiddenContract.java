package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class ForbiddenContract extends GaugeBuffSkill {
    public ForbiddenContract() {
        this.setName("포비든 컨트랙트");
        this.setCooldown(75.0);
        this.setDelay(1020L);
        this.setDuration(30L);
        this.setGaugeCharge(-5000.0);
        this.setBuffDamage(10L);
        this.setApplyServerLag(true);
    }
}
