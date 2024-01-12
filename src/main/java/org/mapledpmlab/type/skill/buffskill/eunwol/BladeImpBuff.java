package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BladeImpBuff extends BuffSkill {
    public BladeImpBuff() {
        this.setName("파쇄철조");
        this.setDuration(60L);
        this.addBuffFinalDamage(1.1);
    }
}
