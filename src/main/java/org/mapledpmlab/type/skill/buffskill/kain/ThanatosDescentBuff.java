package org.mapledpmlab.type.skill.buffskill.kain;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ThanatosDescentBuff extends BuffSkill {
    public ThanatosDescentBuff() {
        this.setName("타나토스 디센트(버프)");
        this.setDuration(35L);
        this.addBuffDamage(45L);
        this.setCooldown(180.0);
        this.setApplyServerLag(true);
        this.setDelayByAttackSpeed(540L);
    }
}
