package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LaMortCarteBuff extends BuffSkill {
    public LaMortCarteBuff() {
        this.setName("라모르 카르트(버프)");
        this.setCooldown(60.0);
        this.setDuration(40L);
    }
}
