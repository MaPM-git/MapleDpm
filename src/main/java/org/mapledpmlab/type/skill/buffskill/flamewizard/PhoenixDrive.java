package org.mapledpmlab.type.skill.buffskill.flamewizard;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class PhoenixDrive extends BuffSkill {
    public PhoenixDrive() {
        this.setName("피닉스 드라이브");
        this.setDelay(480L);
        this.setDuration(15L);
        this.setCooldown(90.0);
    }
}
