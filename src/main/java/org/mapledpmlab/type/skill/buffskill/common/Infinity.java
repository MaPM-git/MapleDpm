package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Infinity extends BuffSkill {
    // 4초마다 최종뎀 3퍼 증가
    public Infinity(Long burningTime) {
        this.setName("인피니티");
        if (burningTime >= 60000) {
            this.setBuffFinalDamage(2.15);
        } else {
            double burn = (double) burningTime / 4000 * 3 / 100;
            this.setBuffFinalDamage(1.71 + burn);
        }
        this.setCooldown(180.0);
        this.setDelay(600L);
        this.setDuration(41L);
        this.setApplyPlusBuffDuration(true);
        this.setApplyReuse(true);
    }
}
