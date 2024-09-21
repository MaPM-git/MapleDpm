package org.mapledpmlab.type.skill.buffskill.blaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AfterImageShock extends BuffSkill {
    public AfterImageShock() {
        this.setName("애프터 이미지 쇼크");
        this.setDuration(100L);
        this.setDelay(780L);
        this.setCooldown(120.0);
        this.setApplyServerLag(true);
    }
}
