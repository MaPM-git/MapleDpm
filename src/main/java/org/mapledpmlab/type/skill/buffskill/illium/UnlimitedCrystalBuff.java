package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UnlimitedCrystalBuff extends BuffSkill {
    public UnlimitedCrystalBuff() {
        this.setName("언리미티드 크리스탈");
        this.setDuration(20L);
    }
}
