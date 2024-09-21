package org.mapledpmlab.type.skill.buffskill.windbreaker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class WindWall extends BuffSkill {
    public WindWall() {
        this.setName("윈드 월");
        this.setDelay(720L);
        this.setDuration(60L);
        this.setCooldown(90.0);
        this.setApplyServerLag(true);
    }
}
