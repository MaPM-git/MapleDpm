package org.mapledpmlab.type.skill.buffskill.demonavenger;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ArmorBreakDebuff extends BuffSkill {
    public ArmorBreakDebuff() {
        this.setName("아머 브레이크 디버프");
        this.setDuration(60L);
        this.addBuffIgnoreDefense(31L);
    }
}
