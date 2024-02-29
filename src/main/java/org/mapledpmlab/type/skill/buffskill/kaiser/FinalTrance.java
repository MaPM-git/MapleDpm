package org.mapledpmlab.type.skill.buffskill.kaiser;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FinalTrance extends BuffSkill {
    public FinalTrance() {
        this.setName("파이널 트랜스");
        this.setDuration(60L);
        this.setBuffFinalDamage(1.15);
        this.setCooldown(240.0);
    }
}
