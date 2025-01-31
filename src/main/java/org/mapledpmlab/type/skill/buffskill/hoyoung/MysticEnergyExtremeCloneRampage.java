package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MysticEnergyExtremeCloneRampage extends BuffSkill {
    public MysticEnergyExtremeCloneRampage() {
        this.setName("선기 : 극대 분신난무");
        this.setDelayByAttackSpeed(900L);
        this.setDuration(30L);
        this.setCooldown(180.0);
        this.setApplyServerLag(true);
    }
}
