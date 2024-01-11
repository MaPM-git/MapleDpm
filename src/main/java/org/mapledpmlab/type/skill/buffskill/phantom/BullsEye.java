package org.mapledpmlab.type.skill.buffskill.phantom;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class BullsEye extends BuffSkill {
    public BullsEye() {
        this.setName("불스아이");
        this.setCooldown(120.0);
        this.setDelay(960L);
        this.setDuration(40L);
        this.setBuffCriticalP(20.0);
        this.setBuffCriticalDamage(10.0);
        this.setBuffIgnoreDefense(20L);
        this.setBuffDamage(20L);
    }
}
