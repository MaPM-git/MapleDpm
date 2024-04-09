package org.mapledpmlab.type.skill.buffskill.zero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.zero.LimitBreakFinish;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LimitBreakBuff extends BuffSkill {
    public LimitBreakBuff() {
        this.setName("리미트 브레이크");
        this.setDuration(30L);
        this.addBuffFinalDamage(1.46);
    }
}
