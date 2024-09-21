package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TranscendentRhinneBless extends BuffSkill {
    public TranscendentRhinneBless() {
        this.setName("초월자 륀느의 기원");
        this.setDuration(45L);
        this.addBuffAttMagic(100L);
        this.addBuffFinalDamage(1.08);
        this.setDelay(630L);
        this.setApplyServerLag(true);
    }
}
