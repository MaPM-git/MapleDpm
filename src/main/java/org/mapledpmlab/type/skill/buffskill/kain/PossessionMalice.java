package org.mapledpmlab.type.skill.buffskill.kain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PossessionMalice extends BuffSkill {
    public PossessionMalice() {
        this.setName("포제션(맬리스 생성)");
        this.setCooldown(4.0);
    }
}
