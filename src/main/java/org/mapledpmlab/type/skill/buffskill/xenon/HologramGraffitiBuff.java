package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class HologramGraffitiBuff extends BuffSkill {
    public HologramGraffitiBuff() {
        this.setName("홀로그램 그래피티");
        this.setDuration(40L);
        this.addBuffDamage(20L);
    }
}
