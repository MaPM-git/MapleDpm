package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MysticEnergyTaeulDivineMedicineTic extends BuffSkill {
    public MysticEnergyTaeulDivineMedicineTic() {
        this.setName("선기 : 영약 태을선단(틱)");
        this.setCooldown(1.0);
        //this.setApplyCooldownReduction(false);
    }
}
