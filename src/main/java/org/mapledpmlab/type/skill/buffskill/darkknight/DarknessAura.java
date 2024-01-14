package org.mapledpmlab.type.skill.buffskill.darkknight;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DarknessAura extends BuffSkill {
    public DarknessAura() {
        this.setName("다크니스 오라");
        this.setDelay(600L);
        this.setDuration(40L);
    }
}
