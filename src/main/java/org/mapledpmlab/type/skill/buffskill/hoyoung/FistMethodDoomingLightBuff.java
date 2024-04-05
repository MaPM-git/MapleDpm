package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FistMethodDoomingLightBuff extends BuffSkill {
    public FistMethodDoomingLightBuff() {
        this.setName("권술 : 미생강변");
        this.setDuration(60L);
        this.addBuffIgnoreDefense(20L);
    }
}
