package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class OopartsCode extends BuffSkill {
    public OopartsCode() {
        this.setName("오파츠 코드");
        this.setDelay(600L);
        this.setDuration(61L);
        this.addBuffFinalDamage(1.31);
        this.addBuffDamage(32L);
        this.setApplyPlusBuffDuration(true);
        this.setApplyServerLag(true);
    }
}
