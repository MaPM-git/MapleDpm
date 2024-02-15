package org.mapledpmlab.type.skill.buffskill.windbreaker;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class EmeraldFlower extends BuffSkill {
    public EmeraldFlower() {
        this.setName("에메랄드 플라워");
        this.addBuffIgnoreDefense(11L); // 에메랄드 더스트
        this.setDelay(900L);
        this.setDuration(60L);
        this.setCooldown(60.0);
    }
}
