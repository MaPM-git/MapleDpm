package org.mapledpmlab.type.skill.buffskill.viper;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LiberateNeptunusBuff extends BuffSkill {
    public LiberateNeptunusBuff() {
        this.setName("리버레이트 넵투누스");
        this.setDuration(30L);
    }
}
