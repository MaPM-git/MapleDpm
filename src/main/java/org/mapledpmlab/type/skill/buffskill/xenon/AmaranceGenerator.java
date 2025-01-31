package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AmaranceGenerator extends BuffSkill {
    public AmaranceGenerator() {
        this.setName("아마란스 제네레이터");
        this.setCooldown(90.0);
        this.setDelayByAttackSpeed(780L);
    }
}
