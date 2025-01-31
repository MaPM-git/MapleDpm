package org.mapledpmlab.type.skill.buffskill.flamewizard;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SpiritOfFlame extends BuffSkill {
    public SpiritOfFlame() {
        this.setName("스피릿 오브 플레임");
        this.setDelay(30L);
        this.setCooldown(300.0);
        this.setDuration(300L);
    }
}
