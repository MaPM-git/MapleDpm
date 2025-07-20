package org.mapledpmlab.type.skill.buffskill.len;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulshatterAwakening extends BuffSkill {
    public SoulshatterAwakening() {
        this.setName("망혼각성");
        this.setDelayByAttackSpeed(690L);
        this.setCooldown(120.0);
        this.setDuration(20L);
    }
}
