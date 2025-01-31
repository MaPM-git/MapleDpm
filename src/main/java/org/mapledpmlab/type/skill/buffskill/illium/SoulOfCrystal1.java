package org.mapledpmlab.type.skill.buffskill.illium;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulOfCrystal1 extends BuffSkill {
    public SoulOfCrystal1() {
        this.setName("소울 오브 크리스탈(1스택)");
        this.setDuration(30L);
        this.setCooldown(20.0);
        this.setDelayByAttackSpeed(660L);
        this.setApplyServerLag(true);
        this.setApplyCooldownReduction(false);
    }
}
