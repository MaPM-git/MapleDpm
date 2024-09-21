package org.mapledpmlab.type.skill.buffskill.viper;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LightningForm extends BuffSkill {
    public LightningForm() {
        this.setName("라이트닝 폼");
        this.setDelay(720L);
        this.setDuration(80L);
        this.setCooldown(180.0);
        this.addBuffFinalDamage(1.26);
        this.setApplyServerLag(true);
    }
}
