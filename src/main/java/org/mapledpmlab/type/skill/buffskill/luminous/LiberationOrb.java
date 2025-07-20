package org.mapledpmlab.type.skill.buffskill.luminous;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LiberationOrb extends BuffSkill {
    public LiberationOrb() {
        this.setName("리버레이션 오브");
        this.setDelayByAttackSpeed(660L);
        this.setCooldown(120.0);
        this.setDuration(40L);
        this.setApplyServerLag(true);
    }
}
