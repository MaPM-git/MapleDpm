package org.mapledpmlab.type.skill.buffskill.bowmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AfterimageShotBuff extends BuffSkill {
    public AfterimageShotBuff() {
        this.setName("잔영의 시");
        this.setDelay(720L);
        this.setDuration(30L);
    }
}
