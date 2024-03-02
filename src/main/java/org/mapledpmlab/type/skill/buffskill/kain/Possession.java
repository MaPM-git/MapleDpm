package org.mapledpmlab.type.skill.buffskill.kain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Possession extends BuffSkill {
    public Possession() {
        this.setName("포제션");
        this.setDelay(270L);
        this.setCooldown(0.3);
    }
}
