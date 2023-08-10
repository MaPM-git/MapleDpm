package org.mapledpmlab.type.skill.buffskill.nightlord;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PurgeArea extends BuffSkill {
    public PurgeArea() {
        this.setName("퍼지 에어리어");
        this.setCooldown(40.0);
        this.setDelay(600L);
    }
}
