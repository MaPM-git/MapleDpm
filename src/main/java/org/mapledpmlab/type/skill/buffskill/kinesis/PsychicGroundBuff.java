package org.mapledpmlab.type.skill.buffskill.kinesis;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PsychicGroundBuff extends BuffSkill {
    public PsychicGroundBuff() {
        this.setName("사이킥 그라운드");
        this.setDuration(30L);
        this.addBuffIgnoreDefense(15L + 10);    // 싸이킥 그라운드-리듀스 가드
        this.addBuffFinalDamage(1.15);
    }
}
