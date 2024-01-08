package org.mapledpmlab.type.skill.buffskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class LegendarySpearBuff extends BuffSkill {
    public LegendarySpearBuff() {
        this.setName("레전드리 스피어");
        this.setDuration(60L);
        this.addBuffIgnoreDefense(30L + 20);    // 레전드리 스피어-리듀스 아머
    }
}
