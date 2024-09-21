package org.mapledpmlab.type.skill.buffskill.captain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UntiringNectar extends BuffSkill {
    public UntiringNectar() {
        this.setName("언위어링 넥타");
        this.setDelay(390L);
        this.setDuration(20L);
        this.setCooldown(90.0);
        this.setApplyServerLag(true);
    }
}
