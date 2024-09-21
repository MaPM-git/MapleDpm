package org.mapledpmlab.type.skill.buffskill.mechanic;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LuckyDiceMechanic extends BuffSkill {
    public LuckyDiceMechanic() {
        this.setName("럭키 다이스");
        this.setDelay(990L);
        this.addBuffDamage(20L);                    // 로디드 다이스 5번
        this.setCooldown(180.0);
        this.setDuration(180L);
        this.setApplyServerLag(true);
        Long ran = (long) (Math.random() * 99 + 1);
        if (ran <= 50) {                            // 더블 럭키 다이스
            ran = (long) (Math.random() * 5 + 1);
            if (ran == 1) {                         // 1번
                this.setCooldown(90.0);
                this.setDuration(90L);
            } else if (ran == 3) {                  // 3번
                this.addBuffAttMagic(15L);
                this.setCooldown(180.0);
            } else if (ran == 5) {                  // 5번
                this.addBuffDamage(10L);
                this.setCooldown(180.0);
            }
        }
        ran = (long) (Math.random() * 59 + 1);      // 로디드 다이스
        if (this.getBuffDamage() == 30) {           // 5번 2개
            if (ran <= 11) {                        // 1번
                this.setCooldown(90.0);
                this.setDuration(90L);
            } else if (ran > 11 && ran <= 22) {     // 3번
                this.addBuffAttMagic(15L);
            } else if (ran > 44 && ran <= 55) {     // 5번
                this.addBuffDamage(10L);
            }
        } else {
            if (ran == 1) {                         // 1번
                this.setCooldown(90.0);
                this.setDuration(90L);
            } else if (ran == 3) {                  // 3번
                if (this.getBuffAttMagic() == 15) {
                    this.addBuffAttMagic(10L);
                } else {
                    this.addBuffAttMagic(15L);
                }
            } else if (ran == 5) {                  // 5번
                this.addBuffDamage(10L);
            }
        }
        if (
                this.getBuffDamage() != 20
                        || this.getBuffAttMagic() != 0
        ) {
            this.setDuration(180L);
            this.setCooldown(180.0);
        }
    }
}
