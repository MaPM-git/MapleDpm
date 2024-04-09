package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TimeDistotion extends BuffSkill {
    public TimeDistotion() {
        this.setName("타임 디스토션");
        this.setDuration(30L);
        this.setCooldown(240.0);
        this.setDelay(540L);
        this.addBuffDamage(25L);
    }
}
