package org.mapledpmlab.type.skill.buffskill.angelicbuster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SoulExaltation extends BuffSkill {
    public SoulExaltation() {
        this.setName("소울 익절트");
        this.setDuration(20L);
        this.setCooldown(60.0);
        this.addBuffFinalDamage(1.05);
        this.setApplyServerLag(true);
    }
}
