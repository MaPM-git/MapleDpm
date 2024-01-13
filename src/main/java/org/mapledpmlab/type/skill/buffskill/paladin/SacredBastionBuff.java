package org.mapledpmlab.type.skill.buffskill.paladin;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SacredBastionBuff extends BuffSkill {
    public SacredBastionBuff() {
        this.setName("세이크리드 바스티온(성역)");
        this.setDuration(30L);
    }
}
