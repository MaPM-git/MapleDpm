package org.mapledpmlab.type.skill.buffskill.len;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Elevation extends BuffSkill {
    public Elevation() {
        this.setName("승화");
        this.setDelayByAttackSpeed(690L);
        this.setCooldown(120.0);
        this.setDuration(30L);
    }
}
