package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TimePiece extends BuffSkill {
    public TimePiece() {
        this.setName("타임 피스");
        this.setCooldown(2.0);
    }
}
