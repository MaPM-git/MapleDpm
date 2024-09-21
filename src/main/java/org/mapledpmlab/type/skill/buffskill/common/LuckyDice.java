package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LuckyDice extends BuffSkill {
    public LuckyDice() {
        this.setName("럭키 다이스");
        this.setDelay(990L);
        this.addBuffDamage(20L);                    // 로디드 다이스 5번
        this.setCooldown(180.0);
        this.setDuration(180L);
        this.setApplyServerLag(true);
        Long ran = (long) (Math.random() * 99 + 1);
        if (ran <= 50) {                            // 더블 럭키 다이스
            ran = (long) (Math.random() * 989 + 1);
            if (ran <= 115) {                       // 1번
                this.setCooldown(90.0);
                this.setDuration(90L);
            } else if (ran > 230 && ran <= 245) {   // 3번
                this.addBuffAttMagic(15L);
                this.setCooldown(180.0);
            } else if (ran > 460 && ran <= 875) {   // 5번
                this.addBuffDamage(10L);
                this.setCooldown(180.0);
            }
        } else {                                    // 더블 럭키 다이스-원모어찬스
            ran = (long) (Math.random() * 99 + 1);
            if (ran <= 40) {
                this.setCooldown(0.0);
            }
        }
        ran = (long) (Math.random() * 9899 + 1);      // 로디드 다이스
        if (this.getBuffDamage() == 30) {           // 5번 2개
            if (                                    // 1번
                    ran <= 1365
                    && this.getCooldown() != 0
            ) {
                this.setCooldown(90.0);
                this.setDuration(90L);
            } else if (ran > 2730 && ran <= 4095) { // 3번
                if (this.getBuffAttMagic() == 15) {
                    this.addBuffAttMagic(10L);
                } else {
                    this.addBuffAttMagic(15L);
                }
                if (this.getCooldown() != 0) {
                    this.setCooldown(180.0);
                }
            } else if (ran > 6460 && ran <= 7535) { // 5번
                this.addBuffDamage(10L);
                if (this.getCooldown() != 0) {
                    this.setCooldown(180.0);
                }
            }
        } else {
            if (                                    // 1번
                    ran <= 115
                    && this.getCooldown() != 0
            ) {
                this.setCooldown(90.0);
                this.setDuration(90L);
            } else if (ran > 230 && ran <= 245) {   // 3번
                if (this.getBuffAttMagic() == 15) {
                    this.addBuffAttMagic(10L);
                } else {
                    this.addBuffAttMagic(15L);
                }
                if (this.getCooldown() != 0) {
                    this.setCooldown(180.0);
                }
            } else if (ran > 460 && ran <= 875) {   // 5번
                this.addBuffDamage(10L);
                if (this.getCooldown() != 0) {
                    this.setCooldown(180.0);
                }
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
