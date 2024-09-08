package org.mapledpmlab.type.skill.buffskill.bowmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class QuiverFullBurstBuff extends BuffSkill {
    public QuiverFullBurstBuff() {
        this.setName("퀴버 풀버스트");
        this.setCooldown(120.0);
        this.setDelay(630L);
        this.setDuration(40L);
        this.setBuffAttMagicPer(20L);
        this.addBuffFinalDamage(1.15);
    }
}
