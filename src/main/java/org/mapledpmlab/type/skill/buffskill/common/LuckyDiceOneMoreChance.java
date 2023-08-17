package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LuckyDiceOneMoreChance extends BuffSkill {
    public LuckyDiceOneMoreChance() {
        this.setName("럭키 다이스");
        this.setDelay(990L);
        this.addBuffDamage(20L);                    // 로디드 다이스 5번
        this.setCooldown(180.0);
        Long ran = (long) (Math.random() * 3 + 1);
        if (ran == 5) {                             // 5번
            this.addBuffDamage(10L);
        }
        ran = (long) (Math.random() * 9899 + 1);      // 로디드 다이스
        if (this.getBuffDamage() == 30) {           // 5번 2개
            if (                                    // 1번
                    ran <= 1365
                    && this.getCooldown() != 90
            ) {
                this.setCooldown(this.getCooldown() / 2);
            } else if (ran > 2730 && ran <= 4095) { // 3번
                if (this.getBuffAttMagic() == 15) {
                    this.addBuffAttMagic(10L);
                } else {
                    this.addBuffAttMagic(15L);
                }
            } else if (ran > 6460 && ran <= 7535) { // 5번
                this.addBuffDamage(10L);
            }
        } else {
            if (                                    // 1번
                    ran <= 115
                    && this.getCooldown() != 90
            ) {
                this.setCooldown(this.getCooldown() / 2);
            } else if (ran > 230 && ran <= 245) {   // 3번
                if (this.getBuffAttMagic() == 15) {
                    this.addBuffAttMagic(10L);
                } else {
                    this.addBuffAttMagic(15L);
                }
            } else if (ran > 460 && ran <= 875) {   // 5번
                this.addBuffDamage(10L);
            }
        }
    }
}
