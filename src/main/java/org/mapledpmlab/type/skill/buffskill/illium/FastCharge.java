package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FastCharge extends BuffSkill {
    public FastCharge() {
        this.setName("패스트 차지");
        this.setDelay(30L);
        this.setCooldown(178.0);
        //this.setApplyReuse(true);
    }
}
