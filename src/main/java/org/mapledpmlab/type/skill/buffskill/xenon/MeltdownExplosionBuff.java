package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MeltdownExplosionBuff extends BuffSkill {
    public MeltdownExplosionBuff() {
        this.setName("멜트다운 익스플로전");
        this.setDuration(25L);
        this.addBuffDamage(10L);
        this.setApplyServerLag(true);
    }
}
