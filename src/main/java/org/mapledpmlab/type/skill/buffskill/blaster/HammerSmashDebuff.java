package org.mapledpmlab.type.skill.buffskill.blaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class HammerSmashDebuff extends BuffSkill {
    public HammerSmashDebuff() {
        this.setName("해머 스매시(디버프)");
        this.setDuration(30L);
        this.addBuffFinalDamage(1.1);
    }
}
