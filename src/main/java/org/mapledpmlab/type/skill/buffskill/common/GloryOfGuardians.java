package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class GloryOfGuardians extends BuffSkill {
    public GloryOfGuardians() {
        this.setName("글로리 오브 가디언즈");
        this.addBuffDamage(10L);
        this.setDuration(60L);
        this.setCooldown(120.0);
        this.setApplyServerLag(true);
        this.setDelay(30L);
    }
}
