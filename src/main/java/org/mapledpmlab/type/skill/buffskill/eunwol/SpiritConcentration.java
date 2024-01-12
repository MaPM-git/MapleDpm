package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SpiritConcentration extends BuffSkill {
    public SpiritConcentration() {
        this.setName("정령 집속");
        this.setDuration(60L + 30);         // 코어 강화
        this.addBuffFinalDamage(1.2);
        this.setCooldown(120.0);
        this.setDelay(900L);
    }
}
