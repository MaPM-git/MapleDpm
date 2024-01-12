package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SpiritGateBuff extends BuffSkill {
    public SpiritGateBuff() {
        this.setName("귀문진");
        this.setDuration(8L);
        this.addBuffCriticalDamage(2.0);
    }

    /*public void setNesting(Long cnt) {
        if (cnt <= 5) {
            this.addBuffCriticalDamage(2.0 * cnt);
        } else {
            this.addBuffCriticalDamage(10.0);
        }
    }*/
}
