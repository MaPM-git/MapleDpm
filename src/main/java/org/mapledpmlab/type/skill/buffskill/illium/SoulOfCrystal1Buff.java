package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulOfCrystal1Buff extends BuffSkill {
    public SoulOfCrystal1Buff() {
        this.setName("소울 오브 크리스탈(1스택 버프)");
        this.setBuffDamage(50L);
        this.setApplyServerLag(true);
    }
}
