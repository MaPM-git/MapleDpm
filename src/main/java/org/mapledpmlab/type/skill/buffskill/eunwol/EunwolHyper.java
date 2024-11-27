package org.mapledpmlab.type.skill.buffskill.eunwol;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class EunwolHyper extends BuffSkill {
    public EunwolHyper() {
        this.setName("호주개시");
        this.setCooldown(120.0);
        this.setDuration(30L);
        this.setApplyServerLag(true);
        this.setDelay(30L);
    }
}
