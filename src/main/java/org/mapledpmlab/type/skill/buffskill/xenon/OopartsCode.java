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
        this.setDuration(60L);
        this.addBuffFinalDamage(1.3);
        this.addBuffDamage(31L);
        this.setApplyPlusBuffDuration(true);
    }
}
