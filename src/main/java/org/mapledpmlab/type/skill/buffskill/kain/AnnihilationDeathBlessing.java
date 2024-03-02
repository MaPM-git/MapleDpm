package org.mapledpmlab.type.skill.buffskill.kain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AnnihilationDeathBlessing extends BuffSkill {
    public AnnihilationDeathBlessing() {
        this.setName("어나일레이션(죽음의 축복)");
        this.setCooldown(2.5);
        this.setApplyCooldownReduction(false);
    }
}
