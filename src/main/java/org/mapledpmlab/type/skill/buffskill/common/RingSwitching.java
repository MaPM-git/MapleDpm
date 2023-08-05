package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RingSwitching extends BuffSkill {
    public RingSwitching() {
        this.setDelay(5000L);   // 5초
    }
}
