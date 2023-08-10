package org.mapledpmlab.type.skill.buffskill.nightlord;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SpreadThrow extends BuffSkill {
    public SpreadThrow() {
        this.setName("스프레드 스로우");
        this.setCooldown(180.0);
        this.setDelay(540L);
        this.setDuration(50L);
    }
}
