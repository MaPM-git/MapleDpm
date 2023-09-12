package org.mapledpmlab.type.skill.buffskill.nightwalker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SilenceBuff extends BuffSkill {
    public SilenceBuff() {
        this.setName("사일런스");
        this.setDuration(30L);
    }
}
