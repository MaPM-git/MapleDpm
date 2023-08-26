package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Bahamut extends BuffSkill {
    public Bahamut() {
        this.setName("바하뮤트");
        this.setDuration(265L);
        this.setDelay(600L);
        this.setCooldown(260.0);
    }
}
