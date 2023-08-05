package org.mapledpmlab.type.skill.buffskill.bowmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ArrowRainBuff extends BuffSkill {
    public ArrowRainBuff() {
        this.setName("애로우 레인");
        this.setCooldown(120.0);
        this.setDelay(510L);
        this.setDuration(70L);
        this.setBuffDamage(30L);
    }
}
