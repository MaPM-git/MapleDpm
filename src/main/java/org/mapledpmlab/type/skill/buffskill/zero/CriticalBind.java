package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CriticalBind extends BuffSkill {
    public CriticalBind() {
        this.setName("크리티컬 바인드");
        this.setDuration(4L);
        this.setCooldown(35.0);
        this.setApplyCooldownReduction(false);
    }
}
