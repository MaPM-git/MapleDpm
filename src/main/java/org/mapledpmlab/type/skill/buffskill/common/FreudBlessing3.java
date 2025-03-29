package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FreudBlessing3 extends BuffSkill {
    public FreudBlessing3() {
        this.setName("프리드의 가호(3중첩)");
        this.setCooldown(25.0);
        this.setDuration(30L);
        this.addBuffMainStat(55L);
        this.addBuffSubStat(55L);
        this.setDelay(790L);
    }
}
