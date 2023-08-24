package org.mapledpmlab.type.skill.buffskill.cannonshooter;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.cannonshooter.BarrelRouletteSkull;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BarrelRoulette extends BuffSkill {
    private Long ran = 0L;

    public BarrelRoulette() {
        this.setName("오크통 룰렛");
        this.setDelay(840L);
        ran = (long) (Math.random() * 3 + 1);
        if (ran == 2) {         // 얼음
            this.addBuffCriticalDamage(5.0);
            this.setDuration(220L);
            this.setCooldown(220.0);
        } else if (ran == 4) {  // 해골
            this.setDuration(15L);
            this.setCooldown(15.0);
            this.setRelatedSkill(new BarrelRouletteSkull());
        } else {
            this.setDuration(15L);
            this.setCooldown(15.0);
        }
        // 1은 번개, 3은 슬로우
    }
}
