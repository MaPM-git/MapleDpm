package org.mapledpmlab.type.skill.buffskill.paladin;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.paladin.BlessedHammerDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BlessedHammerBuff extends BuffSkill {
    public BlessedHammerBuff() {
        this.setCooldown(60.0);
        this.setDelay(360L);
        this.setDuration(30L);
        this.setRelatedSkill(new BlessedHammerDot());
    }
}
