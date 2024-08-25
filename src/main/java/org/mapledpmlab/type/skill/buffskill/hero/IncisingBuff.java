package org.mapledpmlab.type.skill.buffskill.hero;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class IncisingBuff extends BuffSkill {
    public IncisingBuff() {
        this.setName("인사이징 버프");
        this.setDuration(60L);
        this.setBuffDamage(26L);
    }
}
