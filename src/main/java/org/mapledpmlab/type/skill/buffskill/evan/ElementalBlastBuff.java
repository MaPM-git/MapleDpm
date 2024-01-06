package org.mapledpmlab.type.skill.buffskill.evan;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ElementalBlastBuff extends BuffSkill {
    public ElementalBlastBuff() {
        this.setName("엘리멘탈 블래스트");
        this.setDuration(10L);
        this.addBuffFinalDamage(1.2);
    }
}
