package org.mapledpmlab.type.skill.buffskill.hero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.hero.ValhallaDot;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ValhallaBuff extends BuffSkill {
    public ValhallaBuff() {
        this.setName("발할라");
        this.setCooldown(120.0);
        this.setDelay(780L);
        this.setDuration(30L);
        this.setBuffAttMagic(50L);
        this.setBuffCriticalP(30.0);
        this.setApplyServerLag(true);
    }
}
