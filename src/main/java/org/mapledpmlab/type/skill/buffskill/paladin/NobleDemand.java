package org.mapledpmlab.type.skill.buffskill.paladin;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class NobleDemand extends BuffSkill {
    public NobleDemand() {
        this.setName("노블 디맨드");
        this.setCooldown(0.0);
        this.setDelay(720L);
        this.setDuration(80L);
        this.setBuffIgnoreDefense(50L);
    }
}
