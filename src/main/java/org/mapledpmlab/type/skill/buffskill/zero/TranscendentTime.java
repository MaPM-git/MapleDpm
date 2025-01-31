package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TranscendentTime extends BuffSkill {
    public TranscendentTime() {
        this.setName("트랜센던트(시간)");
        this.setDuration(60L);
        this.setDelayByAttackSpeed(630L);
    }
}
