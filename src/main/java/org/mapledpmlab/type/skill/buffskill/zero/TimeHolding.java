package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TimeHolding extends BuffSkill {
    public TimeHolding() {
        this.setName("타임 홀딩");
        this.setDuration(90L);
        this.setCooldown(180.0);
        this.addBuffDamage(10L);
    }
}
