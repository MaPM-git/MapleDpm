package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Pray2 extends BuffSkill {
    public Pray2(Long mainStat) {
        this.setName("프레이");
        this.setCooldown(120.0);
        this.setDuration(40L);
        this.setDelay(360L);
        this.setApplyServerLag(true);
        if (mainStat >= 81000) {
            this.setBuffFinalDamage(1.23 + 0.27);
        } else if (mainStat == 0) {
            this.setBuffFinalDamage(1.0);
        } else {
            this.setBuffFinalDamage(1.23 + 0.01 * (mainStat / 3000));
        }
    }
}
