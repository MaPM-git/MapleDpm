package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AdventOfTheFoxBuff extends BuffSkill {
    public AdventOfTheFoxBuff() {
        this.setName("호신강림");
        this.setDuration(40L);
        this.addBuffFinalDamage(1.1);
    }
}
