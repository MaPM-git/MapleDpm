package org.mapledpmlab.type.skill.buffskill.mercedes;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UnicornSpikeBuff extends BuffSkill {
    public UnicornSpikeBuff() {
        this.setName("유니콘 스파이크");
        this.setBuffDamage(30L);
        this.setDuration(60L);
    }
}
