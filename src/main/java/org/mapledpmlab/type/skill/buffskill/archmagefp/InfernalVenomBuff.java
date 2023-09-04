package org.mapledpmlab.type.skill.buffskill.archmagefp;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.archmagefp.InfernalVenomExplosion1;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class InfernalVenomBuff extends BuffSkill {
    public InfernalVenomBuff() {
        this.setName("인페르날 베놈(버프)");
        this.setCooldown(360.0);
        this.setDuration(20L);
        this.setDelay(6600L);
    }
}
