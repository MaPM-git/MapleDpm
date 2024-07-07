package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.GaugeBuffSkill;

@Getter
@Setter
public class ReleaseOverload extends GaugeBuffSkill {
    public ReleaseOverload() {
        this.setName("릴리즈 오버로드");
        this.setDuration(90L);
        this.addBuffFinalDamage(1.25);
        this.setGaugePer(1L);
        this.setApplyPlusBuffDuration(true);
    }
}
