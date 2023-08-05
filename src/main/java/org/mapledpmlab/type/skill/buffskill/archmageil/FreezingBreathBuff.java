package org.mapledpmlab.type.skill.buffskill.archmageil;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.archmageil.FreezingBreath;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class FreezingBreathBuff extends BuffSkill {
    public FreezingBreathBuff() {
        this.setName("브리징 브레스(버프)");
        this.setCooldown(180.0);
        this.setDuration(13L);
        this.addBuffIgnoreDefense(30L);
        this.setRelatedSkill(new FreezingBreath());
    }
}
