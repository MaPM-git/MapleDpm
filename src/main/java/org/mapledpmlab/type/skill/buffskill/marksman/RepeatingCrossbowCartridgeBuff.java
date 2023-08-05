package org.mapledpmlab.type.skill.buffskill.marksman;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RepeatingCrossbowCartridgeBuff extends BuffSkill {
    public RepeatingCrossbowCartridgeBuff() {
        this.setName("리피팅 크로스보우 카트리지");
        this.setCooldown(120.0);
        this.setDelay(660L);
        this.setDuration(60L);
    }
}
