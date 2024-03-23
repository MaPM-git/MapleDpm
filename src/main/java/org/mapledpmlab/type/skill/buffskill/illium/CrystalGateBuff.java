package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CrystalGateBuff extends BuffSkill {
    public CrystalGateBuff() {
        this.setName("소울 오브 크리스탈");
        this.setDelay(175L);
        this.addBuffAttMagic(95L);
    }
}
