package org.mapledpmlab.type.skill.buffskill.viper;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TimeLeap extends BuffSkill {
    public TimeLeap() {
        this.setName("타임 리프");
        this.setDelay(1080L);
        this.setCooldown(180.0);
    }
}
