package org.mapledpmlab.type.skill.buffskill.shadower;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.DarkSight;

@Getter
@Setter
public class SmokeBomb extends BuffSkill {
    public SmokeBomb() {
        this.setName("연막탄");
        this.setCooldown(150.0);
        this.setDuration(30L);
        this.setDelay(810L);
        this.addBuffCriticalDamage(22.0);
        this.setApplyReuse(true);
        this.setRelatedSkill(new DarkSight());
    }
}
