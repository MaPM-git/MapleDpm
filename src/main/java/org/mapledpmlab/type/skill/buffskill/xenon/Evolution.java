package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Evolution extends BuffSkill {
    public Evolution() {
        this.setName("아티피셜 에볼루션(진화 상태)");
        this.setCooldown(30.0);
    }
}
