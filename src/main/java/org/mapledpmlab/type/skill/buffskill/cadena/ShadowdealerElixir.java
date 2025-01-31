package org.mapledpmlab.type.skill.buffskill.cadena;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ShadowdealerElixir extends BuffSkill {
    public ShadowdealerElixir() {
        this.setName("상인단 특제 비약");
        this.setDelayByAttackSpeed(570L);
        this.setDuration(60L);
        this.setCooldown(120.0);
        this.addBuffDamage(10L);
        this.setApplyServerLag(true);
    }
}
