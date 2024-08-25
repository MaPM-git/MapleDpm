package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ContinuousRing extends BuffSkill {
    public ContinuousRing() {
        this.setName("컨티뉴어스 링");
        this.setCooldown(12.0);
        this.setDuration(8L);
        this.setBuffDamage(140L);
        this.setBuffAttMagicPer(10L);
        this.setApplyCooldownReduction(false);
    }
}
