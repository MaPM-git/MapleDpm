package org.mapledpmlab.type.skill.buffskill.kinesis;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PsychicCharge extends BuffSkill {
    public PsychicCharge() {
        this.setName("싸이킥 차징");
        this.setCooldown(44.0);
    }
}
