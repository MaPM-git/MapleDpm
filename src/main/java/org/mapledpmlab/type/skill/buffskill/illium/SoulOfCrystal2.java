package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulOfCrystal2 extends BuffSkill {
    public SoulOfCrystal2() {
        this.setName("소울 오브 크리스탈(2스택)");
        this.setDuration(30L);
        this.setCooldown(40.0);
        this.setDelayByAttackSpeed(660L);
        this.setApplyServerLag(true);
        this.setApplyCooldownReduction(false);
    }
}
