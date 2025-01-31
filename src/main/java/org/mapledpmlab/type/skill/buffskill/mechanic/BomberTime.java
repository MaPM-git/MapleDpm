package org.mapledpmlab.type.skill.buffskill.mechanic;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BomberTime extends BuffSkill {
    public BomberTime() {
        this.setName("봄버 타임");
        this.setDelay(30L);
        this.setDuration(10L);
        this.setCooldown(90.0);
        this.setApplyServerLag(true);
    }
}
