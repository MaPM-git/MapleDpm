package org.mapledpmlab.type.skill.buffskill.blaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BunkerBuster extends BuffSkill {
    public BunkerBuster() {
        this.setName("벙커 버스터");
        this.setDuration(45L);
        this.setDelay(720L);
        this.setCooldown(120.0);
        this.setApplyServerLag(true);
    }
}
