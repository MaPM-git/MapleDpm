package org.mapledpmlab.type.skill.buffskill.shadower;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CovertShadowBuff extends BuffSkill {
    public CovertShadowBuff() {
        this.setName("커버트 쉐도우(버프)");
        this.setDuration(3L);
        this.setApplyServerLag(true);
    }
}
