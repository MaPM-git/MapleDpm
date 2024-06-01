package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FreudBlessing1 extends BuffSkill {
    public FreudBlessing1() {
        this.setName("프리드의 가호(1중첩)");
        this.setCooldown(240.0 + 25);
        this.setDuration(30L);
        this.setDelay(790L);
    }
}
