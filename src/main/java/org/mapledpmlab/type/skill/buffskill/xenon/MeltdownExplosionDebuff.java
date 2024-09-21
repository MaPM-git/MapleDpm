package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MeltdownExplosionDebuff extends BuffSkill {
    public MeltdownExplosionDebuff() {
        this.setName("멜트다운 익스플로전");
        this.setDuration(10L);
        this.addBuffIgnoreDefense(30L);
        this.setApplyServerLag(true);
        this.setRelatedSkill(new MeltdownExplosionBuff());
    }
}
