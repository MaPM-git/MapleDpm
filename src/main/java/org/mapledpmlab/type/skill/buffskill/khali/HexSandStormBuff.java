package org.mapledpmlab.type.skill.buffskill.khali;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class HexSandStormBuff extends BuffSkill {
    public HexSandStormBuff() {
        this.setName("헥스 : 샌드스톰");
        this.setDuration(30L);
        this.setBuffFinalDamage(1.25);
        this.setApplyServerLag(true);
    }
}
