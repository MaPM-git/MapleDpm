package org.mapledpmlab.type.skill.buffskill.shadower;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.DarkSight;

@Getter
@Setter
public class HeartbreakerDarksight extends BuffSkill {
    public HeartbreakerDarksight() {
        this.setName("분쇄(다크사이트)");
        this.setDuration(6L);
    }
}
