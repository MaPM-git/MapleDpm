package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Pray2Party4 extends BuffSkill {
    public Pray2Party4(Long mainStat) {
        this.setName("프레이(2분, 4인팟)");
        this.setCooldown(120.0);
        this.setDuration(40L);
        this.setDelay(360L);
        this.setApplyServerLag(true);
        this.setPartyBuff(true);
        this.setBuffFinalDamage(1.08);
        /*if (mainStat >= 81000) {
            this.setBuffFinalDamage(1.08);
        } else if (mainStat == 0) {
            this.setBuffFinalDamage(1.0);
        } else {
            this.setBuffFinalDamage(1.0 + Math.abs((6 + mainStat / 3000) / 4) * 0.01);
        }*/
    }
}
