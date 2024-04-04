package org.mapledpmlab.type.skill.buffskill.lara;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DragonVeinEcho extends BuffSkill {
    public DragonVeinEcho() {
        this.setName("용맥의 메아리");
        this.setDuration(720L);
        this.addBuffFinalDamage(1.05);
    }
}
