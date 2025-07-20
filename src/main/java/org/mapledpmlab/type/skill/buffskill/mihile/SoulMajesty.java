package org.mapledpmlab.type.skill.buffskill.mihile;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulMajesty extends BuffSkill {
    public SoulMajesty() {
        this.setName("소울 마제스티");
        this.setBuffDamage(15L);
        this.setCooldown(120.0);
        this.setDelay(630L);
        this.setDuration(20L);
    }
}
