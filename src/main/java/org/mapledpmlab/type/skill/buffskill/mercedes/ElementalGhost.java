package org.mapledpmlab.type.skill.buffskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ElementalGhost extends BuffSkill {
    public ElementalGhost() {
        this.setName("엘리멘탈 고스트");
        this.setDelay(720L);
        this.setCooldown(120.0);
        this.setDuration(75L);
        this.setApplyServerLag(true);
    }
}
