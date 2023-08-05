package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RiskTakerRing extends BuffSkill {
    public RiskTakerRing() {
        this.setName("리스크테이커 링(4레벨)");
        this.setCooldown(180.0);
        this.setDuration(30L);
        this.setDelay(30L);
        this.setBuffAttMagicPer(50L);
    }
}
