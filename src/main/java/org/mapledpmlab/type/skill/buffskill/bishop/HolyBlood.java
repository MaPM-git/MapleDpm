package org.mapledpmlab.type.skill.buffskill.bishop;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.bishop.AngelicTouch;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class HolyBlood extends BuffSkill {
    public HolyBlood() {
        this.setName("홀리 블러드");
        this.setCooldown(120.0);     // 3분주기에 맞춤
        this.setDuration(10L);
        this.addBuffFinalDamage(1.15);
        this.setDelay(270L);
    }
}
