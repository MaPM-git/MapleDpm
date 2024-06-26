package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PriorPreparation extends BuffSkill {
    public PriorPreparation() {
        this.setName("프라이어 프리퍼레이션");
        this.setCooldown(43.0);
        this.setDuration(20L);
        this.setBuffDamage(17L);
        this.setApplyCooldownReduction(false);
    }
}
