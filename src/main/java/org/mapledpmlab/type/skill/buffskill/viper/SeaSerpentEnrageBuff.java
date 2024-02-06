package org.mapledpmlab.type.skill.buffskill.viper;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SeaSerpentEnrageBuff extends BuffSkill {
    public SeaSerpentEnrageBuff() {
        this.setName("씨 서펜트 인레이지");
        this.setDuration(30L);
        this.addBuffFinalDamage(1.2);
    }
}
