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
        this.setDuration(30L);
        this.setDelay(360L);
        if (mainStat >= 100000) {
            this.setBuffFinalDamage(1.05 + 0.4);
        } else if (mainStat == 0) {
            this.setBuffFinalDamage(1.0);
        } else {
            this.setBuffFinalDamage(1.05 + 0.01 * (mainStat / 2500));
        }
        this.setBuffFinalDamage(this.getBuffFinalDamage() + 0.1);   // 코어 강화
    }
}
