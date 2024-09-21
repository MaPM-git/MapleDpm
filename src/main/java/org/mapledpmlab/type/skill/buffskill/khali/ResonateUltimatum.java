package org.mapledpmlab.type.skill.buffskill.khali;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ResonateUltimatum extends BuffSkill {
    public ResonateUltimatum() {
        this.setName("레조네이트 : 얼티메이텀");
        this.setDelay(810L);
        this.setCooldown(180.0);
        this.setDuration(30L);
        this.setApplyServerLag(true);
    }
}
