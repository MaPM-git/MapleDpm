package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class Overdrive extends BuffSkill {
    public Overdrive(Long att) {
        this.setName("오버 드라이브");
        this.setCooldown(60.0);
        this.setDuration(28L);
        this.addBuffAttMagic((long) (att * 0.8));
        this.setRelatedSkill(new OverdriveDebuff());
    }
}
