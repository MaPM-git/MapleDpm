package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AdventOfGodsBuff extends BuffSkill {
    public AdventOfGodsBuff() {
        this.setName("신들의 강림");
        this.setDuration(30L);
        this.setApplyServerLag(true);
    }
}
