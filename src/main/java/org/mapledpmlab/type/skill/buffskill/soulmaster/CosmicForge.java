package org.mapledpmlab.type.skill.buffskill.soulmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CosmicForge extends BuffSkill {
    public CosmicForge() {
        this.setName("코스믹 포지");
        this.setDelay(810L);
        this.setDuration(60L);
        this.addBuffDamage(10L);
        this.setCooldown(180.0);
    }
}
