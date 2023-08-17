package org.mapledpmlab.type.skill.buffskill.viper;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Stimulate extends BuffSkill {
    public Stimulate() {
        this.setName("스티뮬레이트");
        this.setDelay(930L);
        this.setDuration(90L);
        this.setCooldown(180.0);
        this.addBuffDamage(20L);
    }
}
