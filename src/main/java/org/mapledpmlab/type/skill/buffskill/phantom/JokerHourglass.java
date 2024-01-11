package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class JokerHourglass extends BuffSkill {
    public JokerHourglass() {
        this.setName("조커(모래시계)");
        this.setDuration(30L);
    }
}
