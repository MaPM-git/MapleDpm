package org.mapledpmlab.type.skill.buffskill.evan;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ZodiacBurstBuff extends BuffSkill {
    public ZodiacBurstBuff() {
        this.setName("조디악 버스트");
        this.setDuration(45L);
    }
}
