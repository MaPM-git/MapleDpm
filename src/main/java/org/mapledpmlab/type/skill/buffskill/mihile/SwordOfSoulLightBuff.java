package org.mapledpmlab.type.skill.buffskill.mihile;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class SwordOfSoulLightBuff extends BuffSkill {
    public SwordOfSoulLightBuff() {
        this.setName("소드 오브 소울 라이트");
        this.setCooldown(180.0);
        this.setDelay(1050L);
        this.setDuration(35L);
        this.addBuffFinalDamage(1.1);
        this.addBuffIgnoreDefense(100L);
    }
}
