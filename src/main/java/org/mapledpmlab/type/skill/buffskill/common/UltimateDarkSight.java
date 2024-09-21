package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UltimateDarkSight extends BuffSkill {
    public UltimateDarkSight() {
        this.setName("얼티밋 다크 사이트");
        this.setCooldown(180.0);
        this.setDelay(750L);
        this.setDuration(30L);
        this.addBuffFinalDamage(1.14);
        this.setApplyServerLag(true);
    }
}
