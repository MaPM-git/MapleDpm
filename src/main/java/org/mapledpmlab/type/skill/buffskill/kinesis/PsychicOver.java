package org.mapledpmlab.type.skill.buffskill.kinesis;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PsychicOver extends BuffSkill {
    public PsychicOver() {
        this.setName("싸이킥 오버");
        this.setCooldown(180.0);
        this.setDuration(26L);
        this.setApplyServerLag(true);
        this.setDelay(30L);
    }
}
