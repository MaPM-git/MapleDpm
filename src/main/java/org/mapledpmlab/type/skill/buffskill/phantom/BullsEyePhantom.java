package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BullsEyePhantom extends BuffSkill {
    public BullsEyePhantom() {
        this.setName("불스아이(팬텀)");
        this.setCooldown(180.0);
        this.setDelay(960L);
        this.setDuration(30L);
        this.setBuffCriticalP(20.0);
        this.setBuffCriticalDamage(10.0);
        this.setBuffIgnoreDefense(20L);
        this.setBuffDamage(20L);
    }
}
