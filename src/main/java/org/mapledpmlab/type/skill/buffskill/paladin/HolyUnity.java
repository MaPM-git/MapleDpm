package org.mapledpmlab.type.skill.buffskill.paladin;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class HolyUnity extends BuffSkill {
    public HolyUnity() {
        this.setName("홀리 유니티");
        this.setCooldown(90.0);
        this.setDelay(600L);
        this.setDuration(45L);
        this.setBuffFinalDamage(1.75 + 0.15);   // 코어 강화
    }
}
