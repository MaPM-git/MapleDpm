package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ReadyToDie extends BuffSkill {
    public ReadyToDie() {
        this.setName("레디 투 다이");
        this.setCooldown(75.0);
        this.setDelay(780L);
        this.setDuration(15L);
        this.addBuffFinalDamage(1.3);
        this.setApplyServerLag(true);
    }
}
