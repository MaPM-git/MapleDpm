package org.mapledpmlab.type.skill.buffskill.archmagefp;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Ifrit extends BuffSkill {
    public Ifrit() {
        this.setDuration(265L);
        this.setDelay(600L);
        this.setCooldown(260.0);
    }
}
