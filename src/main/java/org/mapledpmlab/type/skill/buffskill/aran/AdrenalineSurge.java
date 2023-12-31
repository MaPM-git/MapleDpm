package org.mapledpmlab.type.skill.buffskill.aran;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class AdrenalineSurge extends BuffSkill {
    public AdrenalineSurge() {
        this.setName("아드레날린 서지");
        this.setDuration(20L);
        this.setDelay(720L);
        this.setCooldown(360.0);
    }
}
