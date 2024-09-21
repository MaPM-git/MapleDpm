package org.mapledpmlab.type.skill.buffskill.striker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class CreationOfTheWorld extends BuffSkill {
    public CreationOfTheWorld() {
        this.setName("천지개벽");
        this.setDuration(30L);
        this.setCooldown(120.0);
        this.setDelay(930L);
        this.addBuffDamage(5L);
        this.addBuffIgnoreDefense(10L);
        this.setApplyServerLag(true);
    }
}
