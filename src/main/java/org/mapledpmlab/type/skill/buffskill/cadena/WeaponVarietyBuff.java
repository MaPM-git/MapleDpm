package org.mapledpmlab.type.skill.buffskill.cadena;

import lombok.Getter;
import lombok.Setter;
import org.mapledpmlab.type.skill.buffskill.BuffSkill;

@Getter
@Setter
public class WeaponVarietyBuff extends BuffSkill {
    public WeaponVarietyBuff() {
        this.setName("웨폰 버라이어티(8중첩)");
        this.addBuffFinalDamage(1.88);
        this.setDuration(720L);
    }
}
