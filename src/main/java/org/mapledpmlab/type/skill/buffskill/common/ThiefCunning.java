package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ThiefCunning extends BuffSkill {
    public ThiefCunning() {
        this.setName("시프 커닝");
        this.setCooldown(20.0);
        this.setDuration(10L);
        this.setBuffDamage(18L);
    }
}
