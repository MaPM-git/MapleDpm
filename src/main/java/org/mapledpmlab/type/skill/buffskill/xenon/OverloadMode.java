package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.xenon.OverloadModePlasmaCurrent;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class OverloadMode extends BuffSkill {
    public OverloadMode() {
        this.setName("오버로드 모드");
        this.setDelay(720L);
        this.setDuration(70L);
        this.setRelatedSkill(new OverloadModePlasmaCurrent());
        this.setCooldown(180.0);
    }
}
