package org.mapledpmlab.type.skill.buffskill.flamewizard;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BurningRegion extends BuffSkill {
    public BurningRegion() {
        this.setName("버닝 리젼");
        this.setDelay(1080L);
        this.setBuffDamage(61L);
        this.setDuration(30L);
        this.setCooldown(45.0);
        this.setApplyPlusBuffDuration(true);
    }
}
