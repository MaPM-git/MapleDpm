package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.bishop.AngelicTouch;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Pray extends BuffSkill {
    public Pray(Long mainStat) {
        this.setName("프레이");
        this.setCooldown(180.0);
        this.setDuration(45L);
        this.setDelay(360L);
        if (mainStat >= 100000) {
            this.setBuffFinalDamage(1.15 + 0.4);
        } else if (mainStat == 0) {
            this.setBuffFinalDamage(1.0);
        } else {
            this.setBuffFinalDamage(1.15 + 0.01 * (mainStat / 2500));
        }
    }
}
