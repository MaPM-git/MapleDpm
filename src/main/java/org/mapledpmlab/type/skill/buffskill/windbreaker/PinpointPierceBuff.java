package org.mapledpmlab.type.skill.buffskill.windbreaker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PinpointPierceBuff extends BuffSkill {
    public PinpointPierceBuff() {
        this.setName("핀포인트 피어스");
        this.addBuffDamage(15L);
        this.addBuffIgnoreDefense(15L);
    }
}
