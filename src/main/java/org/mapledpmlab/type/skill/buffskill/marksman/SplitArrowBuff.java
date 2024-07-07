package org.mapledpmlab.type.skill.buffskill.marksman;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SplitArrowBuff extends BuffSkill {
    public SplitArrowBuff() {
        this.setName("스플릿 애로우");
        this.setCooldown(120.0);
        this.setDelay(810L);
        this.setDuration(72L);
    }
}
