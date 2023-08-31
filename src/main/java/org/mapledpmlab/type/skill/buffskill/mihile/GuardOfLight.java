package org.mapledpmlab.type.skill.buffskill.mihile;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class GuardOfLight extends BuffSkill {
    public GuardOfLight() {
        this.setName("빛의 수호");
        this.setBuffDamage(20L);
        this.setCooldown(180.0);
        this.setDelay(900L);
        this.setDuration(30L);
        this.setApplyPlusBuffDuration(true);
    }
}
