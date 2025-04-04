package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FreudBlessing2 extends BuffSkill {
    public FreudBlessing2() {
        this.setName("프리드의 가호(2중첩)");
        this.setCooldown(25.0);
        this.setDuration(30L);
        this.setDelay(790L);
    }
}
