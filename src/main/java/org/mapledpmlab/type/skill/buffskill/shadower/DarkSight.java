package org.mapledpmlab.type.skill.buffskill.shadower;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DarkSight extends BuffSkill {
    public DarkSight() {
        this.setName("다크 사이트");
        this.setDelay(100L);
    }
}
