package org.mapledpmlab.type.skill.buffskill.angelicbuster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.angelicbuster.Spotlight;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SpotlightBuff extends BuffSkill {
    public SpotlightBuff() {
        this.setName("스포트라이트");
        this.setDelay(660L);
        this.setCooldown(120.0);
        this.setDuration(30L);
        this.addBuffFinalDamage(1.18);
        this.setRelatedSkill(new Spotlight());
        this.setApplyServerLag(true);
    }
}
