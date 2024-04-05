package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MysticEnergyTaeulDivineMedicine extends BuffSkill {
    public MysticEnergyTaeulDivineMedicine() {
        this.setName("선기 : 영약 태을선단");
        this.setDelay(540L);
        this.setDuration(12L);
        this.setCooldown(90.0);
    }
}
