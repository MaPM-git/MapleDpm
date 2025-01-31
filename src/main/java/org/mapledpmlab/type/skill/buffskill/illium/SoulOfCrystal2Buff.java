package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulOfCrystal2Buff extends BuffSkill {
    public SoulOfCrystal2Buff() {
        this.setName("소울 오브 크리스탈(2스택 버프)");
        this.setBuffDamage(100L);
        this.setApplyServerLag(true);
    }
}
