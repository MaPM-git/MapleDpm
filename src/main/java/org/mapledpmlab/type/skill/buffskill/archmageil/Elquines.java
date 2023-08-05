package org.mapledpmlab.type.skill.buffskill.archmageil;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Elquines extends BuffSkill {
    public Elquines() {
        this.setDuration(265L);
        this.setDelay(600L);
        this.setCooldown(260.0);
    }
}
