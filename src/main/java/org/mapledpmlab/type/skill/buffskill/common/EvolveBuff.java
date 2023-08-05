package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class EvolveBuff extends BuffSkill {
    public EvolveBuff() {
        this.setName("이볼브");
        this.setCooldown(106.0);
        this.setDelay(600L);
        this.setDuration(40L);
    }
}
