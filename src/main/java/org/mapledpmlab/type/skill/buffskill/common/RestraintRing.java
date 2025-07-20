package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RestraintRing extends BuffSkill {
    public RestraintRing() {
        this.setName("리스트레인트 링(4레벨)");
        this.setCooldown(120.0);
        this.setDuration(15L);
        this.setDelay(30L);
        this.setBuffAttMagicPer(80L);
    }
}
