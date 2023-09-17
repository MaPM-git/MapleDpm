package org.mapledpmlab.type.skill.buffskill.striker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LightningUnion extends BuffSkill {
    public LightningUnion() {
        this.setName("신뇌합일");
        this.setDuration(62L);
        this.setCooldown(120.0);
        this.addBuffFinalDamage(1.32);
        this.setDelay(540L);
    }
}
