package org.mapledpmlab.type.skill.buffskill.nightlord;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class ThrowBlasting extends BuffSkill {
    public ThrowBlasting() {
        this.setName("스로우 블래스팅");
        this.setCooldown(180.0);
        this.setDelayByAttackSpeed(540L);
        this.setDuration(90L);
    }
}
