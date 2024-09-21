package org.mapledpmlab.type.skill.buffskill.mihile;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class RhoAias extends BuffSkill {
    public RhoAias() {
        this.setName("로 아이아스");
        this.setBuffFinalDamage(1.4);
        this.setCooldown(180.0);
        this.setDelay(840L);
        this.setDuration(115L);
        this.setApplyServerLag(true);
    }
}
