package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulContract extends BuffSkill {
    public SoulContract() {
        this.setName("소울 컨트랙트");
        this.setBuffDamage(45L);
        this.setCooldown(90.0);
        this.setDelay(900L);
        this.setDuration(10L);
        this.setApplyPlusBuffDuration(true);
    }
}
