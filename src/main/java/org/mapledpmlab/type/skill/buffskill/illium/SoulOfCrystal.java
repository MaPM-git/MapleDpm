package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulOfCrystal extends BuffSkill {
    public SoulOfCrystal() {
        this.setName("소울 오브 크리스탈");
        this.setDuration(40L);
    }
}
