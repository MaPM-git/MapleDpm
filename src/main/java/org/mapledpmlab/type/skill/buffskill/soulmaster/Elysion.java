package org.mapledpmlab.type.skill.buffskill.soulmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Elysion extends BuffSkill {
    public Elysion() {
        this.setName("엘리시온");
        this.setDelay(750L);
        this.setDuration(30L);
        this.setCooldown(120.0);
        this.setApplyServerLag(true);
    }
}
