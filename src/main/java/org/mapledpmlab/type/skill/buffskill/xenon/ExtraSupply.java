package org.mapledpmlab.type.skill.buffskill.xenon;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ExtraSupply extends BuffSkill {
    public ExtraSupply() {
        this.setName("엑스트라 서플라이");
        this.setCooldown(30.0);
    }
}
