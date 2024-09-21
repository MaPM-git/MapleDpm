package org.mapledpmlab.type.skill.buffskill.nightwalker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ShadowSpearBuff extends BuffSkill {
    public ShadowSpearBuff() {
        this.setName("쉐도우 스피어");
        this.setCooldown(177.0);
        this.setDelay(360L);
        //this.setDelay(600L);
        this.setDuration(87L);
        this.setApplyServerLag(true);
    }
}
