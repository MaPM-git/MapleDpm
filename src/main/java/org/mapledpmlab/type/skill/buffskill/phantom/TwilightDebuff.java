package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.attackskill.phantom.Twilight;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class TwilightDebuff extends BuffSkill {
    public TwilightDebuff() {
        this.setName("트와일라이트");
        this.setBuffIgnoreDefense(20L);
        this.setRelatedSkill(new Twilight());
    }
}
