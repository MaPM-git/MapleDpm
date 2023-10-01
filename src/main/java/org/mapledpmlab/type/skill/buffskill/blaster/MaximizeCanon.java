package org.mapledpmlab.type.skill.buffskill.blaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MaximizeCanon extends BuffSkill {
    public MaximizeCanon() {
        this.setName("맥시마이즈 캐논");
        this.setDuration(35L);
        this.setDelay(870L);
        this.setCooldown(120.0);
    }
}
