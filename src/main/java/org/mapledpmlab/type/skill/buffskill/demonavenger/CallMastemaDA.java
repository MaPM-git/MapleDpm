package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.common.MastemaClaw;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class CallMastemaDA extends GaugeBuffSkill {
    public CallMastemaDA() {
        this.setName("콜 마스테마");
        this.setCooldown(120.0);
        this.setDelay(690L);
        this.setGaugePer(-4L);
        this.setRelatedSkill(new MastemaClaw());
    }
}
