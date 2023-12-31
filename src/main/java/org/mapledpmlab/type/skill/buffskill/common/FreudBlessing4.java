package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FreudBlessing4 extends BuffSkill {
    public FreudBlessing4() {
        this.setName("프리드의 가호(4중첩)");
        this.setCooldown(240.0 + 25 * 4);
        this.setDuration(30L);
        this.addBuffMainStat(55L);
        this.addBuffSubStat(55L);
        this.addBuffAttMagic(25L);
        this.setDelay(790L);
    }
}
