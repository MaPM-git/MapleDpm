package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PirateFlag extends BuffSkill {
    public PirateFlag() {
        this.setName("파이렛 플래그");
        this.setCooldown(30.0);
        this.setDelay(990L);
        this.addBuffIgnoreDefense(25L);
        this.addBuffMainStat(
                (long) Math.floor(
                        (285 + 2) * 5 * 0.25
                )
        );
        this.setDuration(30L);
    }
}
