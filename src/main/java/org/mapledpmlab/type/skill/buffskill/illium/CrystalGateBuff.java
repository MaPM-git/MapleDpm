package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CrystalGateBuff extends BuffSkill {
    public CrystalGateBuff() {
        this.setName("크리스탈 게이트");
        this.setDelay(540L);
        this.addBuffAttMagic(95L);
    }
}
