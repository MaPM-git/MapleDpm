package org.mapledpmlab.type.skill.buffskill.cadena;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ChainArtsFuryBuff extends BuffSkill {
    public ChainArtsFuryBuff() {
        this.setName("체인아츠:퓨리(버프)");
        this.setDelayByAttackSpeed(540L);
        this.setDuration(80L);
        this.setCooldown(180.0);
        this.setApplyServerLag(true);
    }
}
