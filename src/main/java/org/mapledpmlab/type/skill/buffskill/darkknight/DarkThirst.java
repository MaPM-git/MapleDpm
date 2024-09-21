package org.mapledpmlab.type.skill.buffskill.darkknight;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class DarkThirst extends BuffSkill {
    public DarkThirst() {
        this.setName("다크 서스트");
        this.setCooldown(90.0);
        this.setDelay(900L);
        this.setDuration(25L);
        this.addBuffAttMagic(50L);
        this.setApplyServerLag(true);
    }
}
