package org.mapledpmlab.type.skill.buffskill.nightwalker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DominionBuff extends BuffSkill {
    public DominionBuff() {
        this.setName("도미니언");
        this.setDelay(2490L);
        this.setDuration(30L);
        this.addBuffFinalDamage(1.2);
    }
}
