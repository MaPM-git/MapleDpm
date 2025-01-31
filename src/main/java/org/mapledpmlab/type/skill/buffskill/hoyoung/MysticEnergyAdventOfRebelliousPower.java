package org.mapledpmlab.type.skill.buffskill.hoyoung;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MysticEnergyAdventOfRebelliousPower extends BuffSkill {
    public MysticEnergyAdventOfRebelliousPower() {
        this.setName("선기 : 강림 괴력난신");
        this.setDelayByAttackSpeed(900L);
        this.setDuration(30L);
        this.setCooldown(180.0);
        this.addBuffDamage(80L);
    }
}
