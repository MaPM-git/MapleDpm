package org.mapledpmlab.type.skill.buffskill.battlemage;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class UnionAura extends BuffSkill {
    public UnionAura() {
        this.setName("유니온 오라");
        this.setDuration(40L);
        this.setCooldown(90.0);
        this.addBuffAttMagic(60L);
        this.setDelay(810L);
    }
}
