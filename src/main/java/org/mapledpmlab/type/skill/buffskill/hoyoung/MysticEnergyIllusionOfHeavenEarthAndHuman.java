package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MysticEnergyIllusionOfHeavenEarthAndHuman extends BuffSkill {
    public MysticEnergyIllusionOfHeavenEarthAndHuman() {
        this.setName("선기 : 천지인 환영");
        this.setDelay(720L);
        this.setDuration(30L);
        this.setCooldown(90.0);
        this.setApplyServerLag(true);
    }
}
