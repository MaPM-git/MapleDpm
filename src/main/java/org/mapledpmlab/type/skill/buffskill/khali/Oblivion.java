package org.mapledpmlab.type.skill.buffskill.khali;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Oblivion extends BuffSkill {
    public Oblivion() {
        this.setName("오블리비온");
        this.setDelay(810L);
        this.setCooldown(180.0);
        this.setDuration(30L);
        this.setApplyServerLag(true);
    }
}
