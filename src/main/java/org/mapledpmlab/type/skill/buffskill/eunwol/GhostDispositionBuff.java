package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.eunwol.GhostDispositionAttack;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class GhostDispositionBuff extends BuffSkill {
    public GhostDispositionBuff() {
        this.setName("귀문진");
        this.setCooldown(60.0);
        this.setDuration(45L);
        this.addBuffCriticalDamage(10.0);
        this.setRelatedSkill(new GhostDispositionAttack());
    }
}
