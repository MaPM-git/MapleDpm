package org.mapledpmlab.type.skill.buffskill.common;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class WillOfLiberty extends BuffSkill {
    public WillOfLiberty() {
        this.setName("윌 오브 리버티");
        this.setCooldown(120.0);
        this.setDuration(60L);
        this.setBuffDamage(10L);
    }
}
