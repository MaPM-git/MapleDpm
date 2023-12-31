package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FreudBlessing6 extends BuffSkill {
    public FreudBlessing6() {
        this.setName("프리드의 가호(6중첩)");
        this.setCooldown(240.0 + 25 * 6);
        this.setDuration(30L);
        this.addBuffMainStat(55L);
        this.addBuffSubStat(55L);
        this.addBuffAttMagic(25L);
        this.addBuffDamage(25L);
        this.setDelay(790L);
    }
}
