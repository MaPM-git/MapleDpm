package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class QueenOfTomorrow extends BuffSkill {
    public QueenOfTomorrow() {
        this.setName("퀸 오브 투모로우");
        this.addBuffDamage(10L);
        this.setDuration(60L);
        this.setCooldown(120.0);
        this.setApplyServerLag(true);
    }
}
