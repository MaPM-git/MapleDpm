package org.mapledpmlab.type.skill.buffskill.shadower;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;
import org.mapledpmlab.type.skill.buffskill.common.DarkSight;

@Getter
@Setter
public class VeilOfShadowBuff extends BuffSkill {
    public VeilOfShadowBuff() {
        this.setName("베일 오브 섀도우");
        this.setDelay(900L);
        this.setDuration(12L);
        this.setRelatedSkill(new DarkSight());
    }
}
