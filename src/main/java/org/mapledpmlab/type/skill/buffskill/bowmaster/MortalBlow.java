package org.mapledpmlab.type.skill.buffskill.bowmaster;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class MortalBlow extends BuffSkill {
    public MortalBlow() {
        this.setName("모탈 블로우");
        this.setCooldown(5.0);
        this.setDuration(5L);
        this.setBuffDamage(35L);
    }
}
