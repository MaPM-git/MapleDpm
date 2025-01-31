package org.mapledpmlab.type.skill.buffskill.bowmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ExtraQuiverCartridgeBuff extends BuffSkill {
    public ExtraQuiverCartridgeBuff() {
        this.setName("엑스트라 퀴버 카트리지");
        this.setDuration(30L);
        this.setCooldown(30.0);
    }
}
