package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PriorPreparation extends BuffSkill {
    public PriorPreparation() {
        this.setCooldown(40.0);
        this.setDuration(20L);
        this.setBuffDamage(17L);
    }
}
