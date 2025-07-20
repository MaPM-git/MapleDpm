package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Pray2 extends BuffSkill {
    public Pray2() {
        this.setName("프레이");
        this.setCooldown(120.0);
        this.setDuration(40L);
        this.setDelay(360L);
        this.setApplyServerLag(true);
        this.setBuffFinalDamage(1.23 + 0.27);
    }
}
