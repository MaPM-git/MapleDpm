package org.mapledpmlab.type.skill.buffskill.mechanic;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SupportWaverHEX extends BuffSkill {
    public SupportWaverHEX() {
        this.setName("서포트 웨이버 : H-EX");
        this.setDelay(630L);
        this.setDuration((long) (80L * 1.42));
        this.addBuffIgnoreDefense(10L);
        this.addBuffFinalDamage(1.08 + 0.02);   // 서포트 웨이버:H-EX-파티 리인포스
    }
}
