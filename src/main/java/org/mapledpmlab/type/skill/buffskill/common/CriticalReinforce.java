package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CriticalReinforce extends BuffSkill {
    public CriticalReinforce(Double criticalP) {
        this.setName("크리티컬 리인포스");
        this.setCooldown(120.0);
        this.setDuration(30L);
        this.setDelayByAttackSpeed(780L);
        this.addBuffCriticalDamage(criticalP / 2);
        this.setApplyServerLag(true);
    }
}
