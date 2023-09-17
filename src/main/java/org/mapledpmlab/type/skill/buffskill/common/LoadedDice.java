package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LoadedDice extends BuffSkill {
    public LoadedDice() {
        this.setName("럭키 다이스");
        this.setDelay(990L);
        this.addBuffDamage(20L);                    // 로디드 다이스 5번
        this.setCooldown(180.0);
        this.setDuration(180L);
    }
}
