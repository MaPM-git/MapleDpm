package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RingOfSum extends BuffSkill {
    public RingOfSum() {
        this.setName("링 오브 썸(4레벨)");
        this.setCooldown(180.0);
        this.setDuration(15L);
        this.setDelay(30L);
    }
}
