package org.mapledpmlab.type.skill.buffskill.battlemage;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DebuffAura extends BuffSkill {
    public DebuffAura() {
        this.setName("디버프 오라");
        this.setDuration(60L);
        this.addBuffIgnoreDefense(20L);
        this.addBuffProperty(10L);
        this.addBuffFinalDamage(1.08);
        this.setCooldown(3.0);
    }
}
