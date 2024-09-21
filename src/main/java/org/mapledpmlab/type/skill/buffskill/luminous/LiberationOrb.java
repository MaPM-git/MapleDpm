package org.mapledpmlab.type.skill.buffskill.luminous;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LiberationOrb extends BuffSkill {
    public LiberationOrb() {
        this.setName("리버레이션 오브");
        this.setDelay(660L);
        this.setCooldown(180.0);
        this.setDuration(45L);
        this.setApplyServerLag(true);
    }
}
