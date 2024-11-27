package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class RevenantDamage extends GaugeBuffSkill {
    public RevenantDamage() {
        this.setName("레버넌트(데미지)");
        this.setGaugePer(-4L);
    }
}
